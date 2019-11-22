package person.jzh.itoken.web.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jzh
 * @version 1.0.0
 * @title WebBackendApplication
 * @date 2019/11/4 18:10
 * @description
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "person.jzh.itoken")
@SpringBootApplication(scanBasePackages = "person.jzh.itoken", exclude= {DataSourceAutoConfiguration.class})
public class WebBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebBackendApplication.class, args);
    }
}
