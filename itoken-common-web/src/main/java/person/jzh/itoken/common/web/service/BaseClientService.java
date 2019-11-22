package person.jzh.itoken.common.web.service;

import person.jzh.itoken.common.hystrix.Fallback;

/**
 * @author jzh
 * @date 2019/10/24 10:35
 * @description 通用服务消费者接口
 */
public interface BaseClientService {
    default String page(int pageNum, int pageSize, String domainJson){
        return Fallback.badGateway();
    }
}
