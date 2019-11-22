package person.jzh.itoken.service.sso.service;

import person.jzh.itoken.common.domain.TbSysUser;
import person.jzh.itoken.common.service.BaseService;

/**
 * @author jzh
 * @date 2019/10/8 16:30
 * @description 登录
 */
public interface LoginService extends BaseService<TbSysUser> {

    /**
     * 登录
     * @param loginCode
     * @param plantPassword
     * @return
     */
    TbSysUser login(String loginCode, String plantPassword);
}
