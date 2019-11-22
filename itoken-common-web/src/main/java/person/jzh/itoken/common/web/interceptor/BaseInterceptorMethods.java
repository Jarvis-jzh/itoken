package person.jzh.itoken.common.web.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.servlet.ModelAndView;
import person.jzh.itoken.common.domain.TbSysUser;
import person.jzh.itoken.common.utils.CookieUtils;
import person.jzh.itoken.common.utils.HttpServletUtils;
import person.jzh.itoken.common.utils.MapperUtils;
import person.jzh.itoken.common.constants.HostsConstants;
import person.jzh.itoken.common.web.constants.WebConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author jzh
 * @date 2019/10/24 16:04
 * @description 拦截器通用函数
 */
@Component
public class BaseInterceptorMethods {

    /**
     * 登录方法拦截
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    public static boolean preHandleForLogin(HttpServletRequest request, HttpServletResponse response, Object handler){
        String token = CookieUtils.getCookieValue(request, WebConstants.SESSION_TOKEN);

        if (StringUtils.isBlank(token)){
            sendRedirect(request, response);
            return false;
        }

        return true;
    }

    /**
     * 登录方法拦截
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @param tbSysUserJson 登录用户 JSON 对象
     */
    public static void postHandleForLogin(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView, String tbSysUserJson){
        HttpSession session = request.getSession();
        TbSysUser tbSysUser = (TbSysUser) session.getAttribute(WebConstants.SESSION_USER);

        // 已登录状态
        if (tbSysUser != null){
            if (modelAndView != null){
                modelAndView.addObject(WebConstants.SESSION_USER, tbSysUser);
            }
        }

        // 未登录状态
        else{
            if (StringUtils.isNotBlank(tbSysUserJson)){
                try{
                    // 已登录状态，创建局部会话
                    tbSysUser = MapperUtils.json2pojo(tbSysUserJson, TbSysUser.class);
                    if (modelAndView != null){
                        modelAndView.addObject(WebConstants.SESSION_USER, tbSysUser);
                    }
                    session.setAttribute(WebConstants.SESSION_USER, tbSysUser);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // 二次确认是否有用户信息
        if (tbSysUser == null) {
            sendRedirect(request, response);
        }
    }

    public static void sendRedirect(HttpServletRequest request, HttpServletResponse response){
        try {
            Assert.notNull(HostsConstants.HOSTS_SSO, "系统异常");
            response.sendRedirect(String.format("%s/login?url=%s", HostsConstants.HOSTS_SSO, HttpServletUtils.getFullPath(request)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
