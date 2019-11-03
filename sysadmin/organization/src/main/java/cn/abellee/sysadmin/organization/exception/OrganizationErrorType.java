package cn.abellee.sysadmin.organization.exception;

import cn.abellee.core.exception.ErrorType;
import lombok.Getter;

@Getter
public enum OrganizationErrorType implements ErrorType {

    USER_NOT_FOUND(030100, "用户未找到！");

    /**
     * 错误类型码
     */
    private Integer code;
    /**
     * 错误类型描述信息
     */
    private String msg;

    OrganizationErrorType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
