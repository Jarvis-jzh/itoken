package person.jzh.itoken.common.hystrix;

import com.google.common.collect.Lists;
import person.jzh.itoken.common.constants.HttpStatusConstants;
import person.jzh.itoken.common.dto.BaseResult;
import person.jzh.itoken.common.utils.MapperUtils;

/**
 * @author jzh
 * @date 2019/10/8 16:45
 * @description 通用的熔断方法
 */
public class Fallback {

    /**
     * 502
     * @return
     */
    public static String badGateway(){
        BaseResult baseResult = BaseResult.notOk(Lists.newArrayList(
                new BaseResult.Error(
                        String.valueOf(HttpStatusConstants.BAD_GATEWAY.getStatus()),
                        HttpStatusConstants.BAD_GATEWAY.getContent())));
        try {
            return MapperUtils.obj2json(baseResult);
        } catch (Exception e) {
            return null;
        }
    }
}
