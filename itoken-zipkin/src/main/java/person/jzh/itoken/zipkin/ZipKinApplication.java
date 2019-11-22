package person.jzh.itoken.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

/**
 * @author jzh
 * @date 2019/9/20 9:52
 * @description 分布式链路追踪
 */
@EnableZipkinServer
@EnableEurekaClient
@SpringBootApplication
public class ZipKinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipKinApplication.class, args);
    }
}
