package person.jzh.itoken.common.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import person.jzh.itoken.common.service.fallback.PostsServiceFallback;
import person.jzh.itoken.common.web.service.BaseClientService;

/**
 * @author jzh
 * @date 2019/10/24 10:49
 * @description
 */
@FeignClient(
        value = "itoken-service-posts",
        name = "itoken-service-posts",
        url = "${itoken.service.posts}",
        fallback = PostsServiceFallback.class)
public interface PostsService extends BaseClientService {

    @Override
    @RequestMapping(value = "v1/posts/page/{pageNum}/{pageSize}", method = RequestMethod.GET)
    String page(
            @PathVariable(required = true, value = "pageNum") int pageNum,
            @PathVariable(required = true, value = "pageSize") int pageSize,
            @RequestParam(required = false, value = "tbPostsPostJson") String tbPostsPostJson
    );

    @RequestMapping(value = "v1/posts/{postGuid}", method = RequestMethod.GET)
    String get(
            @PathVariable(required = true, value = "postGuid") String postGuid
    );

    @RequestMapping(value = "v1/posts", method = RequestMethod.POST)
    String save(
            @RequestParam(required = true, value = "tbPostsPostJson") String tbPostsPostJson,
            @RequestParam(required = true, value = "optsBy") String optsBy
    );
}
