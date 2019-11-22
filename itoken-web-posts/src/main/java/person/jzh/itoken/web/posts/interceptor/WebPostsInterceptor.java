package person.jzh.itoken.web.posts.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import person.jzh.itoken.common.service.RedisCacheService;
import person.jzh.itoken.common.utils.CookieUtils;
import person.jzh.itoken.common.web.constants.WebConstants;
import person.jzh.itoken.common.web.interceptor.BaseInterceptorMethods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jzh
 * @date 2019/10/14 8:52
 * @description
 */
public class WebPostsInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisCacheService redisCacheService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return BaseInterceptorMethods.preHandleForLogin(request, response, handler);

//        String token = CookieUtils.getCookieValue(request, WebConstants.SESSION_TOKEN);
//        // token为空，表示一定没有登录
//        if (StringUtils.isBlank(token)) {
//            sendRedirect(request, response);
//            return false;
//        }
//        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        String token = CookieUtils.getCookieValue(request, WebConstants.SESSION_TOKEN);
        if (StringUtils.isNotBlank(token)) {
            String loginCode = redisCacheService.get(token);
            if (StringUtils.isNotBlank(loginCode)) {
                BaseInterceptorMethods.postHandleForLogin(request, response, handler, modelAndView, redisCacheService.get(loginCode));
            }
        }

//        HttpSession session = request.getSession();
//        TbSysUser tbSysUser = (TbSysUser) session.getAttribute(WebConstants.SESSION_USER);
//        // 已登录状态
//        if (tbSysUser != null) {
//            if (modelAndView != null) {
//                modelAndView.addObject(WebConstants.SESSION_USER, tbSysUser);
//            }
//        } else {
//            String token = CookieUtils.getCookieValue(request, WebConstants.SESSION_TOKEN);
//            if (StringUtils.isNotBlank(token)) {
//                String loginCode = redisCacheService.get(token);
//                if (StringUtils.isNotBlank(loginCode)) {
//                    String json = redisCacheService.get(loginCode);
//                    if (StringUtils.isNotBlank(json)) {
//                        try {
//                            // 已登录状态，创建局部会话
//                            tbSysUser = MapperUtils.json2pojo(json, TbSysUser.class);
//                            if (modelAndView != null) {
//                                modelAndView.addObject(WebConstants.SESSION_USER, tbSysUser);
//                            }
//                            request.getSession().setAttribute(WebConstants.SESSION_USER, tbSysUser);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }
//
//        // 二次确认是否有用户信息
//        if (tbSysUser == null) {
//            sendRedirect(request, response);
//        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

//    private void sendRedirect(HttpServletRequest request, HttpServletResponse response){
//        try {
//            response.sendRedirect(String.format("%s/login?url=%s", HOSTS_SSO, HttpServletUtils.getFullPath(request)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
