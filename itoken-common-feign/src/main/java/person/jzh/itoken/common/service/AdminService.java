package person.jzh.itoken.common.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import person.jzh.itoken.common.service.fallback.AdminServiceFallback;
import person.jzh.itoken.common.web.service.BaseClientService;

/**
 * @author jzh
 * @date 2019/9/26 10:27
 * @description
 */
@FeignClient(
        value = "itoken-service-admin",
        url = "${itoken.service.admin}",
        fallback = AdminServiceFallback.class)
public interface AdminService extends BaseClientService {

    /**
     * 根据 ID 获取管理员
     *
     * @param userCode
     * @return
     */
    @RequestMapping(value = "v1/admins/get", method = RequestMethod.GET)
    String get(
            @RequestParam(required = true, value = "userCode") String userCode
    );

    /**
     * 保存管理员
     *
     * @param tbSysUserJson
     * @param optsBy
     * @return
     */
    @RequestMapping(value = "v1/admins", method = RequestMethod.POST)
    String save(
            @RequestParam(required = true, value = "tbSysUserJson") String tbSysUserJson,
            @RequestParam(required = true, value = "optsBy") String optsBy
    );

    @RequestMapping(value = "v1/admins/page/{pageNum}/{pageSize}", method = RequestMethod.GET)
    String page(
            @PathVariable(required = true, value = "pageNum") int pageNum,
            @PathVariable(required = true, value = "pageSize") int pageSize,
            @RequestParam(required = false, value = "tbSysUserJson") String tbSysUserJson
    );
}
