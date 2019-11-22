package person.jzh.itoken.service.posts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.jzh.itoken.common.domain.TbPostsPost;
import person.jzh.itoken.common.mapper.TbPostsPostMapper;
import person.jzh.itoken.common.service.impl.BaseServiceImpl;
import person.jzh.itoken.service.posts.mapper.TbPostsPostExtendMapper;
import person.jzh.itoken.service.posts.service.PostsService;

/**
 * @author jzh
 * @date 2019/10/18 8:34
 * @description
 */
@Service
//@Transactional(readOnly = true)
public class PostsServiceImpl extends BaseServiceImpl<TbPostsPost, TbPostsPostMapper> implements PostsService {

    @Autowired
    private TbPostsPostExtendMapper extendMapper;
}
