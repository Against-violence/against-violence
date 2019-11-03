package cn.abellee.sysadmin.organization.entity.param;

import cn.abellee.sysadmin.organization.entity.po.Group;
import domain.param.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupQueryParam extends BaseParam<Group> {
    private String name;
}
