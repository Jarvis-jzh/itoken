package person.jzh.itoken.web.admin.interceptor;

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
public class WebAdminInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisCacheService redisCacheService;

//    @Value("${itoken.service.sso}")
//    private String hosts_sso;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return BaseInterceptorMethods.preHandleForLogin(request, response, handler);
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
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
