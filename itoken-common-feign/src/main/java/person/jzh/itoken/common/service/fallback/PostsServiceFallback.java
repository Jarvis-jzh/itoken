package person.jzh.itoken.common.service.fallback;

import org.springframework.stereotype.Component;
import person.jzh.itoken.common.hystrix.Fallback;
import person.jzh.itoken.common.service.PostsService;

/**
 * @author jzh
 * @date 2019/10/24 11:01
 * @description
 */
@Component
public class PostsServiceFallback implements PostsService {

    @Override
    public String page(int pageNum, int pageSize, String tbPostsPostJson) {
        return Fallback.badGateway();
    }

    @Override
    public String get(String postGuid) {
        return null;
    }

    @Override
    public String save(String tbPostsPostJson, String optsBy) {
        return Fallback.badGateway();
    }

}
