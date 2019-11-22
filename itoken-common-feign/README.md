# 通用的feign远程客户端



## 来源

~~原本想做动态fegin但没成功~~





## 问题



实际开发的过程发现，每新增一个服务，如果需要用到@FeignClient，就要从其它项目里cv



为了一劳永逸（偷懒），把它统一放到common模块下的feign项目里，下次哪个模块要用到，直接依赖即可



## 注意



因为@EnableFeignClients默认只扫描当前文件所在的包下路径，需要添加basePackages参数，扫描客户端



@SpringBootApplication的scanBasePackages不影响客户端扫描（不要问我为什么QAQ）