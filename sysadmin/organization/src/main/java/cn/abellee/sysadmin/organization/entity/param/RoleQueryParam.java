package cn.abellee.sysadmin.organization.entity.param;

import cn.abellee.sysadmin.organization.entity.po.Role;
import domain.param.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleQueryParam extends BaseParam<Role> {
    private String code;
    private String name;
}
