package person.jzh.itoken.service.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import person.jzh.itoken.service.redis.service.RedisService;

/**
 * @author jzh
 * @date 2019/9/30 10:25
 * @description
 */
@RestController
@RequestMapping("service/redis")
@Slf4j
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "put", method = RequestMethod.POST)
    public String put(String key, String value, long seconds){
        redisService.put(key, value, seconds);
        return "ok";
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(String key){
//        System.out.println("----------------------------------- redis ------------------------------------------");
        Object o = redisService.get(key);
        if (o != null){
            String json = String.valueOf(o);
            log.info("------------------------- {} -----------------------", json);
            return json;
        }
        log.info("------------------------- null -----------------------");
        return null;
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String delete(String key){
        boolean delete = redisService.delete(key);
        return delete ? "true" : "false";
    }
}
