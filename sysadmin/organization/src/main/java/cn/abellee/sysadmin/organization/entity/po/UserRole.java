package cn.abellee.sysadmin.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import domain.po.BasePo;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_role_relation")
public class UserRole extends BasePo {
    private String userId;
    private String roleId;
}
