package person.jzh.itoken.service.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jzh
 * @date 2019/10/8 15:58
 * @description 单点登录
 */
@EnableEurekaClient     // 服务提供者
@EnableDiscoveryClient  // 服务消费者
@EnableFeignClients(basePackages = "person.jzh.itoken")     // feign服务消费者，注意要加扫描路径
@SpringBootApplication(scanBasePackages = "person.jzh.itoken")
public class ServiceSSOApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSSOApplication.class, args);
    }
}
