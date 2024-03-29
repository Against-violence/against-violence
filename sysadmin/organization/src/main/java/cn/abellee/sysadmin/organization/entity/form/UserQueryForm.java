package cn.abellee.sysadmin.organization.entity.form;

import cn.abellee.sysadmin.organization.entity.param.UserQueryParam;
import domain.from.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
public class UserQueryForm extends BaseQueryForm<UserQueryParam> {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "查询开始时间必须小于当前日期")
    @ApiModelProperty(value = "查询开始时间")
    private Date createdTimeStart;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "查询结束时间必须小于当前日期")
    @ApiModelProperty(value = "查询结束时间")
    private Date createdTimeEnd;
}
