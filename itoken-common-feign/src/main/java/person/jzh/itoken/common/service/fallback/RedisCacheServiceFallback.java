package person.jzh.itoken.common.service.fallback;

import org.springframework.stereotype.Component;
import person.jzh.itoken.common.service.RedisCacheService;

/**
 * @author jzh
 * @date 2019/10/8 16:43
 * @description
 */
@Component
public class RedisCacheServiceFallback implements RedisCacheService {
    @Override
    public String put(String key, Object value, long seconds) {
        return null;
    }

    @Override
    public String get(String key) {
//        System.out.println("-------------------------------------------------------------------");
        return null;
    }

    @Override
    public String delete(String key) {
        return null;
    }
}
