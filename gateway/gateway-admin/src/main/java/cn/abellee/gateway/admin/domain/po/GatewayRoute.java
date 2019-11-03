package cn.abellee.gateway.admin.domain.po;

import domain.po.BasePo;
import lombok.*;

/**
 * @author Abel Lee
 * @date 2019/11/2 4:55 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatewayRoute extends BasePo {
    private String uri;
    private String routeId;
    private String predicates;
    private String filters;
    private String description;
    private Integer orders = 0;
    private String status = "Y";
}
