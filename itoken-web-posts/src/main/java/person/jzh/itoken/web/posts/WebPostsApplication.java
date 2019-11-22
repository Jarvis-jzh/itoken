package person.jzh.itoken.web.posts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jzh
 * @date 2019/10/24 8:29
 * @description 文章模块消费者
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "person.jzh.itoken")
@SpringBootApplication(scanBasePackages = "person.jzh.itoken", exclude= {DataSourceAutoConfiguration.class})
public class WebPostsApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebPostsApplication.class, args);
    }
}
