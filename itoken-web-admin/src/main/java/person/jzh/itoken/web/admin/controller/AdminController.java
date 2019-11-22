package person.jzh.itoken.web.admin.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import person.jzh.itoken.common.domain.TbSysUser;
import person.jzh.itoken.common.service.AdminService;
import person.jzh.itoken.common.utils.MapperUtils;
import person.jzh.itoken.common.web.controller.BaseController;

/**
 * @author jzh
 * @date 2019/9/26 10:27
 * @description
 */
@Controller
public class AdminController extends BaseController<TbSysUser, AdminService> {

    @Autowired
    private AdminService adminService;

    @ModelAttribute
    public TbSysUser tbSysUser(String userCode){
        TbSysUser tbSysUser = null;

        if (StringUtils.isBlank(userCode)){
            tbSysUser = new TbSysUser();
        }else{
            String json = adminService.get(userCode);
            try {
                tbSysUser = MapperUtils.json2pojo(json, TbSysUser.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return tbSysUser;
    }

    @RequestMapping(value = {"", "main"}, method = RequestMethod.GET)
    public String menu(){
        return "main";
    }

    @RequestMapping(value = {"index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = {"form"}, method = RequestMethod.GET)
    public String form(){
        return "form";
    }
}
