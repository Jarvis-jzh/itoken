package person.jzh.itoken.common.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author jzh
 * @date 2019/10/25 16:37
 * @description 地址常量
 */
@Component
public class HostsConstants {

    /**
     * 路由系统地址
     */
    public static String ZUUL;

    @Value("${itoken.zuul}")
    public void setZuul(String zuul){
        ZUUL = zuul;
    }

    /**
     * 单点登录系统地址
     */
    public static String HOSTS_SSO;

    @Value("${itoken.service.sso}")
    public void setHostsSso(String hostsSso){
        HOSTS_SSO = hostsSso;
    }

    /**
     * 文章提供者系统地址
     */
    public static String SERVICE_POSTS;

    @Value("${itoken.service.posts}")
    public void setServicePosts(String servicePosts){
        SERVICE_POSTS = servicePosts;
    }

    /**
     * 文章消费者系统地址
     */
    public static String WEB_POSTS;

    @Value("${itoken.web.posts}")
    public void setWebPosts(String webPOSTS){
        WEB_POSTS = webPOSTS;
    }

    /**
     * redis 服务地址
     */
    public static String SERVICE_REDIS;

    @Value("${itoken.service.redis}")
    public void setServiceRedis(String serviceRedis){
        SERVICE_REDIS = serviceRedis;
    }

    /**
     * 管理员提供者系统地址
     */
    public static String SERVICE_ADMIN;

    @Value("${itoken.service.admin}")
    public void setServiceAdmin(String serviceAdmin){
        SERVICE_ADMIN = serviceAdmin;
    }

    /**
     * 管理员消费者系统地址
     */
    public static String WEB_ADMIN;

    @Value("${itoken.web.admin}")
    public void setWebAdmin(String webAdmin){
        WEB_ADMIN = webAdmin;
    }
}
