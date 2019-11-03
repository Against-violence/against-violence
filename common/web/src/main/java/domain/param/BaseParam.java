package domain.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import domain.po.BasePo;
import lombok.Data;

import java.util.Date;

/**
 * @author Abel Lee
 * @date 2019/11/2 6:44 下午
 */
@Data
public class BaseParam<T extends BasePo> {
    private Date createdTimeStart;
    private Date createdTimeEnd;

    public QueryWrapper<T> build() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge(null != this.createdTimeStart, "created_time", this.createdTimeStart)
                .le(null != this.createdTimeEnd, "created_time", this.createdTimeEnd);
        return queryWrapper;
    }
}
