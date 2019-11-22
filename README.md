# itoken（Mybatis-Plus版）



## 来源

撸帝的视频教学（跟着视频做哒~）

官网：https://www.funtl.com/

视频：https://www.bilibili.com/video/av29882762



## 启动顺序

config>eureka>zipkin>admin>service(redis>sso>其它)>web>zuul



由于我把eureka的配置文件也放到了config配置中心下，所以要先启动配置中心才能启动eureka



## 改动

因为一些不知名原因，我改用Mybatis-Plus来代替tk.mybatis（话说还挺好用）

新增了common-feign模块，来保存所有feign客户端（重构）

web-backend模块的页面根据我的需要加了点小东西（一个thymeleaf版js）



## 脚本

所有bat脚本都放在bin文件夹下（其实也没多少，就两个）



### deploy_dependencies.bat

用于一键打包所有common和dependencies模块



### deploy_origin.bat

用于第一次将项目上传到自己的gitlab上（虚拟机没快照备份，然后挂了，只能一个个重新上传，最后还是觉得写个脚本算了QAQ，虚拟机服务器记得一定要备份啊，血一样的教训QWQ）



## 注意

该版本和撸帝视频上的有所不同，本人根据自身所会和习惯稍加改动

有些工具类在该项目中并没有使用，本人是在开发的过程中找到的一些工具类顺便放到项目中，具体用法自行体会（~~其实我也没用过~~）