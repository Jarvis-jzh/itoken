package person.jzh.itoken.common.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import person.jzh.itoken.common.service.fallback.RedisCacheServiceFallback;

/**
 * @author jzh
 * @date 2019/10/8 16:36
 * @description redis消费者
 */
@FeignClient(
        value = "itoken-service-redis",
        name = "itoken-service-redis",
        url = "${itoken.service.redis}",
        fallback = RedisCacheServiceFallback.class)
public interface RedisCacheService {

    @RequestMapping(value = "service/redis/put", method = RequestMethod.POST)
    String put(@RequestParam("key") String key, @RequestParam("value") Object value, @RequestParam("seconds") long seconds);

    @RequestMapping(value = "service/redis/get", method = RequestMethod.GET)
    String get(@RequestParam("key") String key);

    @RequestMapping(value = "service/redis/delete", method = RequestMethod.DELETE)
    String delete(@RequestParam("key") String key);
}
