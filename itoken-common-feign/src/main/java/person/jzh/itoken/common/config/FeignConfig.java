package person.jzh.itoken.common.config;

import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.stereotype.Component;
import person.jzh.itoken.common.constants.HostsConstants;

/**
 * @author jzh
 * @date 2019/10/25 17:27
 * @description fail
 */
@Component
public class FeignConfig<S> {

    public S getClient(Class<S> clazz){
        S service =  Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(clazz, HostsConstants.SERVICE_REDIS);
        return service;
    }
}
