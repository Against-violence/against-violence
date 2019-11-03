package cn.abellee.core.exception;


/**
 * @author Abel Lee
 * @date 2019/11/2 12:26 下午
 */
public interface ErrorType {
    /**
     * 返回code
     */
    Integer getCode();

    /**
     * 返回msg
     */
    String getMsg();
}
