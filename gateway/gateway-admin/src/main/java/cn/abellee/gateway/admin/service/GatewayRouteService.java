package cn.abellee.gateway.admin.service;

import cn.abellee.gateway.admin.domain.param.GatewayRouteQueryParam;
import cn.abellee.gateway.admin.domain.po.GatewayRoute;
import cn.abellee.gateway.admin.domain.vo.GatewayRouteVo;

import java.util.List;

/**
 * @author Abel Lee
 * @date 2019/11/2 4:57 下午
 */
public interface GatewayRouteService {
    /**
     * 获取网关路由
     */
    GatewayRoute get(String id);

    /**
     * 新增网关路由
     */
    boolean add(GatewayRoute gatewayRoute);

    /**
     * 查询网关路由
     */
    List<GatewayRouteVo> query(GatewayRouteQueryParam gatewayRouteQueryParam);

    /**
     * 更新网关路由信息
     */
    boolean update(GatewayRoute gatewayRoute);

    /**
     * 根据id删除网关路由
     */
    boolean delete(String id);

    /**
     * 重新加载网关路由配置到redis
     */
    boolean overload();
}
