package person.jzh.itoken.service.sso.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import person.jzh.itoken.common.domain.TbSysUser;
import person.jzh.itoken.common.utils.RedisCache;

/**
 * @author jzh
 * @date 2019/10/8 17:01
 * @description user扩展mapper
 */
//@Repository
@Mapper
@CacheNamespace(implementation = RedisCache.class)
public interface TbSysUserExtendMapper extends BaseMapper<TbSysUser> {
}