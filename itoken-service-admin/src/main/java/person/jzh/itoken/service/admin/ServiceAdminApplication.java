package person.jzh.itoken.service.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jzh
 * @date 2019/9/25 10:22
 * @description 服务提供者
 */
@MapperScan(basePackages = {"person.jzh.itoken.common.mapper", "person.jzh.itoken.service.admin.mapper"})
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "person.jzh.itoken")
public class ServiceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class, args);
    }
}
