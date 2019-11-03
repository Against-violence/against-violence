package cn.abellee.sysadmin.organization.entity.po;

import domain.po.BasePo;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resource extends BasePo {
    private String code;
    private String type;
    private String url;
    private String method;
    private String name;
    private String description;
}
