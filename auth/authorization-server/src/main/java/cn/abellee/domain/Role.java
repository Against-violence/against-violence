package cn.abellee.domain;

import domain.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Abel Lee
 * @date 2019/11/2 3:31 下午
 */
@Data
@EqualsAndHashCode(callSuper = false )
@NoArgsConstructor
public class Role extends BasePo {
    private String code;
    private String name;
    private String description;
}
