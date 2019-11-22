package person.jzh.itoken.common.constants;

/**
 * @author jzh
 * @date 2019/9/26 15:44
 * @description http状态码常量枚举类
 */
public enum HttpStatusConstants {
    /**
     * 无法访问上游服务器
     */
    BAD_GATEWAY(502, "从上游服务器接收到无效的响应");

    private int status;

    private String content;

    HttpStatusConstants(int status, String content){
        this.status = status;
        this.content = content;
    }

    public int getStatus(){
        return this.status;
    }

    public String getContent(){
        return this.content;
    }
}
