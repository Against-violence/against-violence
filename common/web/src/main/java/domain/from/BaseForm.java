package domain.from;

import domain.po.BasePo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * @author Abel Lee
 * @date 2019/11/2 6:43 下午
 */
@ApiModel
@Slf4j
@Data
public class BaseForm<T extends BasePo> {
    /**
     * 用户名
     */
    private String username;

    /**
     * From转化为Po，进行后续业务处理
     */
    public T toPo(Class<T> clazz) {
        T t = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(this, t);
        return t;
    }
}
