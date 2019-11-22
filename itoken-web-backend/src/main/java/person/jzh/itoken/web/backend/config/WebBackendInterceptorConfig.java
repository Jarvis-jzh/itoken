package person.jzh.itoken.web.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import person.jzh.itoken.web.backend.interceptor.WebBackendInterceptor;

/**
 * @author jzh
 * @date 2019/10/14 8:54
 * @description
 */
@Configuration
public class WebBackendInterceptorConfig implements WebMvcConfigurer {

    /**
     * 控制反转，将拦截器先注入到spring容器里
     *
     * @return
     */
    @Bean
    WebBackendInterceptor webBackendInterceptor() {
        return new WebBackendInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 这里直接new，会导致拦截器无法注入到spring容器里，就无法使用自动注入注解@Autowired
        // registry.addInterceptor(new WebBackendInterceptor())
        registry.addInterceptor(webBackendInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static");
    }
}
