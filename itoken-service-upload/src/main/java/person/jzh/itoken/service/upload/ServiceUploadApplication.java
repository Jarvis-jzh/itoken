package person.jzh.itoken.service.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jzh
 * @date 2019/10/30 9:58
 * @description 上传提供者
 */
@EnableEurekaClient
@SpringBootApplication
public class ServiceUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUploadApplication.class, args);
    }
}
