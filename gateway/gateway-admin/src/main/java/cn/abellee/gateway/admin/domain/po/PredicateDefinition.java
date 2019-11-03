package cn.abellee.gateway.admin.domain.po;

import lombok.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Abel Lee
 * @date 2019/11/2 4:56 下午
 */
@EqualsAndHashCode
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PredicateDefinition {
    private String name;
    private Map<String, String> args = new LinkedHashMap<>();
}
