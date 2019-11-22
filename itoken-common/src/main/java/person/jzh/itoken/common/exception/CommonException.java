package person.jzh.itoken.common.exception;

/**
 * @author jzh
 * @date 2019/10/15 16:33
 * @description 通用异常
 */
public class CommonException extends RuntimeException{
    public CommonException(){
        super();
    }

    public CommonException(String message){
        super(message);
    }

    public CommonException(Throwable cause){
        super(cause);
    }

    public CommonException(String message, Throwable cause){
        super(message, cause);
    }

    public CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
