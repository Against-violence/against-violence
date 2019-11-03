package cn.abellee.gateway.admin.domain.from;

import cn.abellee.gateway.admin.domain.po.FilterDefinition;
import cn.abellee.gateway.admin.domain.po.GatewayRoute;
import cn.abellee.gateway.admin.domain.po.PredicateDefinition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.from.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Abel Lee
 * @date 2019/11/2 4:54 下午
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
@Slf4j
public class GatewayRouteForm extends BaseForm<GatewayRoute> {

    @NotEmpty(message = "网关断言不能为空")
    @ApiModelProperty(value = "网关断言")
    private List<PredicateDefinition> predicates = new ArrayList<>();

    @ApiModelProperty(value = "网关过滤器信息")
    private List<FilterDefinition> filters = new ArrayList<>();

    @NotBlank(message = "uri不能为空")
    @ApiModelProperty(value = "网关uri")
    private String uri;

    @NotBlank(message = "路由id不能为空")
    @ApiModelProperty(value = "网关路由id")
    private String routeId;

    @ApiModelProperty(value = "排序")
    private Integer orders = 0;

    @ApiModelProperty(value = "网关路由描述信息")
    private String description;

    @Override
    public GatewayRoute toPo(Class<GatewayRoute> clazz) {
        GatewayRoute gatewayRoute = new GatewayRoute();
        BeanUtils.copyProperties(this, gatewayRoute);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            gatewayRoute.setFilters(objectMapper.writeValueAsString(this.getFilters()));
            gatewayRoute.setPredicates(objectMapper.writeValueAsString(this.getPredicates()));
        } catch (JsonProcessingException e) {
            log.error("网关filter或predicates配置转换异常", e);
        }
        return gatewayRoute;
    }
}
