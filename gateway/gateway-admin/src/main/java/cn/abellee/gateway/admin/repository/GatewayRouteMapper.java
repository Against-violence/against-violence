package cn.abellee.gateway.admin.repository;

import cn.abellee.gateway.admin.domain.po.GatewayRoute;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Abel Lee
 * @date 2019/11/2 4:53 下午
 */
@Mapper
@Repository
public interface GatewayRouteMapper extends BaseMapper<GatewayRoute> {
}
