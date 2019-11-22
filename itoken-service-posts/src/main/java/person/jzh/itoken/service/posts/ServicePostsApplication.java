package person.jzh.itoken.service.posts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jzh
 * @date 2019/10/18 8:28
 * @description 文章服务提供者
 */
@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "person.jzh.itoken")
//@ComponentScan(basePackages = {"person.jzh.itoken.common.context"})
//@ComponentScan(basePackages = {"person.jzh.itoken.service.posts"})
@MapperScan(basePackages = {"person.jzh.itoken.common.mapper", "person.jzh.itoken.service.posts.mapper"})
public class ServicePostsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicePostsApplication.class, args);
    }
}
