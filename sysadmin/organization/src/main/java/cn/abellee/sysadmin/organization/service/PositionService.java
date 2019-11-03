package cn.abellee.sysadmin.organization.service;

import cn.abellee.sysadmin.organization.entity.po.Position;
import cn.abellee.sysadmin.organization.entity.param.PositionQueryParam;

import java.util.List;

public interface PositionService {
    /**
     * 获取职位
     *
     * @param id
     * @return
     */
    Position get(String id);

    /**
     * 新增职位
     *
     * @param position
     * @return
     */
    boolean add(Position position);

    /**
     * 查询职位
     *
     * @return
     */
    List<Position> query(PositionQueryParam positionQueryParam);

    /**
     * 更新职位信息
     *
     * @param position
     */
    boolean update(Position position);

    /**
     * 根据id删除职位
     *
     * @param id
     */
    boolean delete(String id);
}
