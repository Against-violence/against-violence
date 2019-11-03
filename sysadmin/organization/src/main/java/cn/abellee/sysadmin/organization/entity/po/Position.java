package cn.abellee.sysadmin.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import domain.po.BasePo;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Position extends BasePo {
    private String name;
    private String description;
    @TableLogic
    private String deleted = "N";
}
