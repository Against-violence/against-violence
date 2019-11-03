package cn.abellee.sysadmin.organization.entity.form;

import cn.abellee.sysadmin.organization.entity.po.Position;
import domain.from.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
public class PositionForm extends BaseForm<Position> {

    @NotBlank(message = "职位名称不能为空")
    @ApiModelProperty(value = "职位名称")
    private String name;

    @ApiModelProperty(value = "职位描述")
    private String description;
}
