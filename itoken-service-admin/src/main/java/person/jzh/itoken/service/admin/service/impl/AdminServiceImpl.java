package person.jzh.itoken.service.admin.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.jzh.itoken.common.domain.TbSysUser;
import person.jzh.itoken.common.mapper.TbSysUserMapper;
import person.jzh.itoken.common.service.impl.BaseServiceImpl;
import person.jzh.itoken.service.admin.service.AdminService;

/**
 * @author jzh
 * @date 2019/9/25 16:16
 * @description adminService实现
 */
@Service
@Transactional(readOnly = true)
public class AdminServiceImpl extends BaseServiceImpl<TbSysUser, TbSysUserMapper> implements AdminService {

}
