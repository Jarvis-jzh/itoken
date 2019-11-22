package person.jzh.itoken.service.upload.fastdfs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jzh
 * @version 1.0.0
 * @title FastDFSConfiguration
 * @date 2019/10/30 10:42
 * @description Java 配置方式定义 StorageFactory 的 Bean 使其可以被依赖注入
 */
@Configuration
public class FastDFSConfiguration {
    @Bean
    public StorageFactory storageFactory() {
        return new StorageFactory();
    }
}
