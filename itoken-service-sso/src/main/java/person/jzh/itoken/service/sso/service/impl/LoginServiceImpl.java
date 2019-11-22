package person.jzh.itoken.service.sso.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import person.jzh.itoken.common.domain.TbSysUser;
import person.jzh.itoken.common.mapper.TbSysUserMapper;
import person.jzh.itoken.common.service.RedisCacheService;
import person.jzh.itoken.common.service.impl.BaseServiceImpl;
import person.jzh.itoken.common.utils.MapperUtils;
import person.jzh.itoken.service.sso.mapper.TbSysUserExtendMapper;
import person.jzh.itoken.service.sso.service.LoginService;

/**
 * @author jzh
 * @date 2019/10/8 16:31
 * @description 登录
 */
@Slf4j
@Service
public class LoginServiceImpl extends BaseServiceImpl<TbSysUser, TbSysUserMapper> implements LoginService {

//    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private RedisCacheService redisService;

    @Autowired
    private TbSysUserExtendMapper tbSysUserExtendMapper;

    @Override
    public TbSysUser login(String loginCode, String plantPassword) {
        TbSysUser tbSysUser = null;

        String json = redisService.get(loginCode);

        // 缓存中有数据
        if (null != json) {
            try {
                tbSysUser = MapperUtils.json2pojo(json, TbSysUser.class);
            } catch (Exception e) {
                log.warn("触发熔断：{}", e.getMessage());
            }
        } else {
            // 查询数据库，获取用户登录信息
            QueryWrapper<TbSysUser> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(TbSysUser::getLoginCode, loginCode);

            tbSysUser = this.baseMapper.selectOne(wrapper);
            String password = DigestUtils.md5DigestAsHex(plantPassword.getBytes());
            if (tbSysUser != null && password.equals(tbSysUser.getPassword())) {
                try {
                    // 缓存到redis
                    redisService.put(loginCode, MapperUtils.obj2json(tbSysUser), 60 * 60 * 24);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return tbSysUser;
            } else {
                return null;
            }
        }
        return tbSysUser;
    }
}
