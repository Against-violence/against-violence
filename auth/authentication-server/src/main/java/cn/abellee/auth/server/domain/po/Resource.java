package cn.abellee.auth.server.domain.po;

import domain.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Abel Lee
 * @date 2019/11/2 3:00 下午
 */
@Data
@NoArgsConstructor
public class Resource extends BasePo {
    private String code;
    private String name;
    private String type;
    private String url;
    private String method;
    private String description;
}
