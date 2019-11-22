package person.jzh.itoken.service.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import person.jzh.itoken.common.domain.TbSysUser;
import person.jzh.itoken.common.dto.BaseResult;
import person.jzh.itoken.common.utils.MapperUtils;
import person.jzh.itoken.service.admin.service.AdminService;

import java.util.List;
import java.util.UUID;

/**
 * @author jzh
 * @date 2019/9/25 17:10
 * @description adminController
 */
@RestController
@RequestMapping(value = "v1/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 根据 ID 获取管理员
     *
     * @param userCode
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public BaseResult get(String userCode) {
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setUserCode(userCode);
        TbSysUser obj = adminService.selectOne(tbSysUser);
        return BaseResult.ok(obj);
    }

    /**
     * 保存管理员
     *
     * @param tbSysUserJson
     * @param optsBy
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResult save(
            @RequestParam("tbSysUserJson") String tbSysUserJson,
            @RequestParam("optsBy") String optsBy) {
        int result = 0;

        TbSysUser tbSysUser = null;
        try {
            tbSysUser = MapperUtils.json2pojo(tbSysUserJson, TbSysUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (tbSysUser != null) {
            // 密码加密
            String password = DigestUtils.md5DigestAsHex(tbSysUser.getPassword().getBytes());
            tbSysUser.setPassword(password);

            // 新增用户
            if (StringUtils.isBlank(tbSysUser.getUserCode())) {
                tbSysUser.setUserCode(UUID.randomUUID().toString());
                tbSysUser.setCreateBy(optsBy);
                result = adminService.insert(tbSysUser);
            }
            // 修改用户
            else {
                tbSysUser.setUpdateBy(optsBy);
                result = adminService.update(tbSysUser);
            }

            // 最少有一行数据受影响
            if (result > 0) {
                return BaseResult.ok("保存管理员成功");
            }
        }

        return BaseResult.ok("保存管理员失败");
    }

    @RequestMapping(value = "page/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public BaseResult page(
            @PathVariable(required = true) int pageNum,
            @PathVariable(required = true) int pageSize,
            @RequestParam(required = false) String tbSysUserJson
    ) throws Exception {
        TbSysUser tbSysUser = null;
        if (tbSysUser != null) {
            tbSysUser = MapperUtils.json2pojo(tbSysUserJson, TbSysUser.class);
        }

        IPage<TbSysUser> info = adminService.page(pageNum, pageSize, tbSysUser);

        // 分页后的结果集
        List<TbSysUser> list = info.getRecords();

        // 封装 Cursor 对象
        BaseResult.Cursor cursor = new BaseResult.Cursor();
        cursor.setTotal(new Long(info.getTotal()).intValue());
        cursor.setOffset(new Long(info.getCurrent()).intValue());
        cursor.setLimit(new Long(info.getSize()).intValue());

        return BaseResult.ok(list, cursor);

    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public BaseResult testPojo2QueryWrapper(){
        TbSysUser tbSysUser = new TbSysUser();
//        tbSysUser.setUserCode(UUID.randomUUID().toString());
        tbSysUser.setUserName("admin");
        tbSysUser.setLoginCode("admin");
        tbSysUser.setPassword(DigestUtils.md5DigestAsHex("123".getBytes()));
        tbSysUser.setUserType("0");
        tbSysUser.setMgrType("1");
        tbSysUser.setStatus("0");
//        tbSysUser.setCreateDate(new Date());
//        tbSysUser.setCreateBy(tbSysUser.getUserCode());
//        tbSysUser.setUpdateDate(new Date());
//        tbSysUser.setUpdateBy(tbSysUser.getUserCode());
        tbSysUser.setCorpCode("0");
        tbSysUser.setCorpName("iToken");
        TbSysUser tbSysUser1 = adminService.selectOne(tbSysUser);
        System.out.println(tbSysUser1);
        return BaseResult.ok(tbSysUser);
    }
}
