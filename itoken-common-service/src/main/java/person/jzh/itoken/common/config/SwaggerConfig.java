package person.jzh.itoken.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {

//    @Value("${swagger.enable:false}")
//    private Boolean enable;
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("person.jzh.itoken.service.admin.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("iToken API 文档")
//                .description("iToken API 网关接口，http://www.funtl.com")
//                .termsOfServiceUrl("http://www.funtl.com")
//                .version("1.0.0")
//                .build();
//    }
//
//    @Bean
//    public Docket createPostsApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("文章系统接口文档")
//                .apiInfo(postsApiInfo())
//                .enable(enable)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("person.jzh.itoken.service.posts.controller"))
//                .paths(PathSelectors.any())
//                .build().globalOperationParameters(setHeaderToken());
//    }
//
//    private ApiInfo postsApiInfo() {
//        return new ApiInfoBuilder()
//                .title("文章系统")
//                .description("文章系统接口API服务")
//                .termsOfServiceUrl("no terms of service")
//                .version("1.0")
//                .build();
//    }
//
//    private List<Parameter> setHeaderToken() {
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        tokenPar.name("token")
//                .description("token")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .required(false)
//                .build();
//        pars.add(tokenPar.build());
//        return pars;
//    }


}