package person.jzh.itoken.web.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import person.jzh.itoken.web.admin.interceptor.WebAdminInterceptor;

/**
 * @author jzh
 * @date 2019/10/14 8:54
 * @description
 */
@Configuration
public class WebAdminInterceptorConfig implements WebMvcConfigurer {

    /**
     * 控制反转，将拦截器先注入到spring容器里
     * @return
     */
    @Bean
    WebAdminInterceptor webAdminInterceptor(){
        return new WebAdminInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 这里直接new，会导致拦截器无法注入到spring容器里，就无法使用自动注入注解@Autowired
        // registry.addInterceptor(new WebAdminInterceptor())
        registry.addInterceptor(webAdminInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static");
    }
}
