package person.jzh.itoken.common.service.fallback;

import org.springframework.stereotype.Component;
import person.jzh.itoken.common.service.AdminService;

/**
 * @author jzh
 * @date 2019/9/26 10:37
 * @description 熔断
 */
@Component
public class AdminServiceFallback implements AdminService {

    @Override
    public String get(String userCode) {
        return null;
    }

    @Override
    public String save(String tbSysUserJson, String optsBy) {
        return null;
    }

    @Override
    public String page(int pageNum, int pageSize, String tbSysUserJson) {
        return null;
    }
}
