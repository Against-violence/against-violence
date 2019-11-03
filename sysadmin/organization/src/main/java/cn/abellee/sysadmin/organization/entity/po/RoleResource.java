package cn.abellee.sysadmin.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import domain.po.BasePo;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("role_resource_relation")
public class RoleResource extends BasePo {
    private String roleId;
    private String resourceId;
}
