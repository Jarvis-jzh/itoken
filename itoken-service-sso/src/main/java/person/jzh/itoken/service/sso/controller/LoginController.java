package person.jzh.itoken.service.sso.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import person.jzh.itoken.common.domain.TbSysUser;
import person.jzh.itoken.common.service.RedisCacheService;
import person.jzh.itoken.common.utils.CookieUtils;
import person.jzh.itoken.common.utils.MapperUtils;
import person.jzh.itoken.common.web.constants.WebConstants;
import person.jzh.itoken.service.sso.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author jzh
 * @date 2019/10/8 17:01
 * @description 单点登录
 */
@Controller
public class LoginController {

    @Autowired
    private RedisCacheService redisCacheService;

    @Autowired
    private LoginService loginService;

    /**
     * 跳转到登录页
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(
            @RequestParam(value = "url", required = false) String url,
            HttpServletRequest request,
            RedirectAttributes redirectAttributes,
            Model model) {
//        Object adminlte = modelAndView.getModel().get("adminlte");
//        String s = String.valueOf(adminlte);
//        System.out.println(s);
        String token = CookieUtils.getCookieValue(request, "token");
        if (StringUtils.isNotBlank(token)) {
            // 不为空，可能已经登录
            String loginCode = redisCacheService.get(token);
            if (StringUtils.isNotBlank(loginCode)) {
                String json = redisCacheService.get(loginCode);
                if (StringUtils.isNotBlank(json)) {
                    try {
                        TbSysUser tbSysUser = MapperUtils.json2pojo(json, TbSysUser.class);
                        request.getSession().setAttribute(WebConstants.SESSION_USER, tbSysUser);
                        // 已登录
                        if (tbSysUser != null) {
                            if (StringUtils.isNotBlank(url)) {
                                return "redirect:" + url;
                            }
                        }

                        // 将登录信息传到登录页
                        model.addAttribute(WebConstants.SESSION_USER, tbSysUser);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        if (StringUtils.isNotBlank(url)) {
            model.addAttribute("url", url);
        }
        return "login";
    }

    /**
     * 登录业务
     *
     * @param loginCode
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String loginCode,
                        @RequestParam(required = true) String password,
                        @RequestParam(value = "url", required = false) String url,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        RedirectAttributes redirectAttributes) throws Exception {

        TbSysUser tbSysUser = loginService.login(loginCode, password);
        if (tbSysUser == null) {
            // 登录失败
            redirectAttributes.addFlashAttribute("message", "账号或密码错误，请稍后重试");
        } else {
            String token = UUID.randomUUID().toString();
            String result = redisCacheService.put(token, loginCode, 60 * 60 * 24);
            if (null != result && "ok".equals(result)) {
                request.getSession().setAttribute(WebConstants.SESSION_USER, tbSysUser);
                CookieUtils.setCookie(request, response, WebConstants.SESSION_TOKEN, token, 60 * 60 * 24);
                if (StringUtils.isNotBlank(url)) {
                    redirectAttributes.addFlashAttribute(WebConstants.SESSION_USER, tbSysUser);
                    return "redirect:" + url;
                }
            } else {
                // 熔断处理
                redirectAttributes.addFlashAttribute("message", "服务器异常，请稍后重试");
            }

        }
        return "redirect:/login";


//        TbSysUser tbSysUser = loginService.login(loginCode, password);
//        System.out.println(tbSysUser);
//
//        // 登录成功
//        if (tbSysUser != null) {
//            String token = UUID.randomUUID().toString();
//            String result = redisCacheService.put(token, loginCode, 60 * 60 * 24);
//            if("ok".equals(result)){
//                CookieUtils.setCookie(request, response, "token", token);
//                return "redirect:" + url;
//            }
//        }
//
//        return "login";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(@RequestParam(value = "url", required = false) String url, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session, RedirectAttributes redirectAttributes) {
        String token = CookieUtils.getCookieValue(request, "token");
//        if (StringUtils.isNotBlank(token)) {
            redisCacheService.delete(token);
            CookieUtils.deleteCookie(request, response, "token");
            session.removeAttribute(WebConstants.SESSION_USER);
//        }
        return login(url, request, redirectAttributes, model);
    }


    @RequestMapping(value = "redirect-test", method = RequestMethod.GET)
    public String redirect(String url) {
        return "redirect:" + url;
    }

    @ResponseBody
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        System.out.println("test");
        return "test";
    }

//    @ResponseBody
//    @RequestMapping(value = "user", method = RequestMethod.GET)
//    public BaseResult getUser(HttpServletRequest request){
//        String token = CookieUtils.getCookieValue(request, WebConstants.SESSION_TOKEN);
//        String json = redisCacheService.get(token);
//    }

}
