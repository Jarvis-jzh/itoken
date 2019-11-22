package person.jzh.itoken.common.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import person.jzh.itoken.common.service.RedisCacheService;
import person.jzh.itoken.common.service.fallback.RedisCacheServiceFallback;

/**
 * @author jzh
 * @version 1.0.0
 * @title FeignBean
 * @date 2019/11/6 15:11
 * @description
 */
@Configuration
public class FeignBean {

//    @Bean
//    public RedisCacheService redisCacheService(){
//        return new RedisCacheServiceFallback();
//    }
}
