package cn.abellee.sysadmin.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import domain.po.BasePo;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("roles")
public class Role extends BasePo {
    private String code;
    private String name;
    private String description;
}
