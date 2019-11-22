package person.jzh.itoken.common.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import person.jzh.itoken.common.constants.HostsConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jzh
 * @date 2019/10/12 16:36
 * @description 初始化常量拦截器
 */
public class ConstantsInterceptor implements HandlerInterceptor {

    @Autowired
    private HostsConstants hostsConstants;

    private static final String HOST_CDN = "http://192.168.56.101:81";

    private static final String TEMPLATE_ADMIN_LTE = "adminlte/v2.4.3";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        if (modelAndView != null){
            modelAndView.addObject("adminlte", HOST_CDN + "/" + TEMPLATE_ADMIN_LTE);
            modelAndView.addObject("hosts", hostsConstants);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
