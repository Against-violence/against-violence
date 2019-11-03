package cn.abellee.gateway.admin.domain.from;

import cn.abellee.gateway.admin.domain.param.GatewayRouteQueryParam;
import domain.from.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author Abel Lee
 * @date 2019/11/2 4:54 下午
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
public class GatewayRouteQueryForm extends BaseQueryForm<GatewayRouteQueryParam> {

    @ApiModelProperty(value = "uri路径", required = true)
    private String uri;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "查询开始时间必须小于当前日期")
    @ApiModelProperty(value = "查询开始时间")
    private Date createdTimeStart;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "查询结束时间必须小于当前日期")
    @ApiModelProperty(value = "查询结束时间")
    private Date createdTimeEnd;
}
