package cn.abellee.core.domain.vo;


import cn.abellee.core.exception.BaseException;
import cn.abellee.core.exception.ErrorType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.Instant;
import java.time.ZonedDateTime;

import static cn.abellee.core.exception.SystemErrorType.SYSTEM_ERROR;

/**
 * @author Abel Lee
 * @date 2019/11/2 12:26 下午
 */
@ApiModel(description = "rest请求的返回模型，所有rest正常都返回该类的对象")
@Getter
public class Result<T> {

    public static final Integer SUCCESSFUL_CODE = 0;
    public static final String SUCCESSFUL_MSG = "成功";

    @ApiModelProperty(value = "处理结果code", required = true)
    private Integer code;
    @ApiModelProperty(value = "处理结果描述信息")
    private String msg;
    @ApiModelProperty(value = "请求结果生成时间戳")
    private Instant time;
    @ApiModelProperty(value = "处理结果数据信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result() {
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     *
     */
    public Result(ErrorType errorType) {
        this.code = errorType.getCode();
        this.msg = errorType.getMsg();
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     *
     */
    public Result(ErrorType errorType, T data) {
        this(errorType);
        this.data = data;
    }

    /**
     * 内部使用，用于构造成功的结果
     */
    private Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * 快速创建成功结果并返回结果数据
     */
    public static <T>Result success(T data) {
        return new Result<>(SUCCESSFUL_CODE, SUCCESSFUL_MSG, data);
    }

    /**
     * 快速创建成功结果
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 系统异常类没有返回数据
     */
    public static Result fail() {
        return new Result(SYSTEM_ERROR);
    }

    /**
     * 系统异常类没有返回数据
     */
    public static Result fail(BaseException baseException) {
        return fail(baseException, null);
    }

    /**
     * 系统异常类并返回结果数据
     */
    public static Result fail(BaseException baseException, Object data) {
        return new Result<>(baseException.getErrorType(), data);
    }

    /**
     * 系统异常类并返回结果数据
     */
    public static Result fail(ErrorType errorType, Object data) {
        return new Result<>(errorType, data);
    }

    /**
     * 系统异常类并返回结果数据
     */
    public static Result fail(ErrorType errorType) {
        return Result.fail(errorType, null);
    }

    /**
     * 系统异常类并返回结果数据
     */
    public static Result fail(Object data) {
        return new Result<>(SYSTEM_ERROR, data);
    }


    /**
     * 成功code=0
     */
    @JsonIgnore
    public boolean isSuccess() {
        return (SUCCESSFUL_CODE == this.code);
    }

    /**
     * 失败
     */
    @JsonIgnore
    public boolean isFail() {
        return !isSuccess();
    }
}
