package cn.abellee.sysadmin.organization.entity.po;

import domain.po.BasePo;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu extends BasePo {
    private String parentId;
    private String name;
    private String type;
    private String href;
    private String icon;
    private int orderNum;
    private String description;
}
