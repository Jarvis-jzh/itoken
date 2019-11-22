package person.jzh.itoken.service.redis.service;

/**
 * @author jzh
 * @date 2019/9/30 10:21
 * @description
 */
public interface RedisService {

    /**
     *
     * @param key
     * @param value
     * @param seconds 超时时间
     */
    void put(String key, Object value, long seconds);

    Object get(String key);

    boolean delete(String key);
}
