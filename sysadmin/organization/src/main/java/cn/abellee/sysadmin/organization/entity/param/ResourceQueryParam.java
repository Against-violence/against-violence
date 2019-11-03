package cn.abellee.sysadmin.organization.entity.param;

import cn.abellee.sysadmin.organization.entity.po.Resource;
import domain.param.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceQueryParam extends BaseParam<Resource> {
    private String name;
    private String code;
    private String type;
    private String url;
    private String method;
}
