package cn.abellee.gateway.admin.domain.param;

import cn.abellee.gateway.admin.domain.po.GatewayRoute;
import domain.param.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Abel Lee
 * @date 2019/11/2 4:55 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatewayRouteQueryParam extends BaseParam<GatewayRoute> {
    private String uri;
}
