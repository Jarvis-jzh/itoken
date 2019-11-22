package person.jzh.itoken.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import person.jzh.itoken.common.domain.TbPostsPost;
import person.jzh.itoken.common.utils.RedisCache;

@Mapper
@CacheNamespace(implementation = RedisCache.class)
public interface TbPostsPostMapper extends BaseMapper<TbPostsPost> {
}