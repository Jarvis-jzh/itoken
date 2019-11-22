package person.jzh.itoken.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jzh
 * @date 2019/9/26 9:05
 * @description 服务消费者
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "person.jzh.itoken")
@SpringBootApplication(scanBasePackages = "person.jzh.itoken", exclude= {DataSourceAutoConfiguration.class})
public class WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAdminApplication.class, args);
    }
}
