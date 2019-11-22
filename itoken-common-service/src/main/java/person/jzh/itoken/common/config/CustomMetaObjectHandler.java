package person.jzh.itoken.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author jzh
 * @date 2019/10/21 9:01
 * @description 自定义填充策略接口实现
 */
@Slf4j
@Configuration
public class CustomMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("--------------------------------- insertFill ----------------------------------");
        try {
            Object createTime = getFieldValByName("createDate", metaObject);
            Object createUser = getFieldValByName("createBy", metaObject);
            Object updateTime = getFieldValByName("updateDate", metaObject);
            Object updateUser = getFieldValByName("updateBy", metaObject);
            Object delTag = getFieldValByName("deleted", metaObject);

            Date timeStr = new Date();
            if (null ==  createTime){
                setFieldValByName("createDate", timeStr, metaObject);
            }
            if (null == updateTime){
                setFieldValByName("updateDate", timeStr, metaObject);
            }
            if (null == delTag){
                setFieldValByName("deleted", 0, metaObject);
            }
            if (null != createUser && updateUser == null){
                setFieldValByName("updateBy", createUser, metaObject);
            }
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("--------------------------------- updateFill ----------------------------------");
        try{
            setFieldValByName("updateDate", new Date(), metaObject);
        }catch (Exception e){
            log.warn(e.getMessage(), e);
        }
    }
}
