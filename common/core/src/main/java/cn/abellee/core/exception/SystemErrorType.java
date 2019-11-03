package cn.abellee.core.exception;

import lombok.Getter;


/**
 * @author Abel Lee
 * @date 2019/11/2 12:26 下午
 */
@Getter
public enum SystemErrorType implements ErrorType {

    SYSTEM_ERROR(-1, "系统异常"),
    SYSTEM_BUSY(000001, "系统繁忙,请稍候再试"),

    GATEWAY_NOT_FOUND_SERVICE(010404, "服务未找到"),
    GATEWAY_ERROR(010500, "网关异常"),
    GATEWAY_CONNECT_TIME_OUT(010002, "网关超时"),

    ARGUMENT_NOT_VALID(020000, "请求参数校验不通过"),
    UPLOAD_FILE_SIZE_LIMIT(020001, "上传文件大小超过限制"),

    DUPLICATE_PRIMARY_KEY(030000,"唯一键冲突");

    /**
     * 错误类型码
     */
    private Integer code;
    /**
     * 错误类型描述信息
     */
    private String msg;

    SystemErrorType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
