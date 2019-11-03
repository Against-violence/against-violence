package cn.abellee.sysadmin.organization.service;

import cn.abellee.sysadmin.organization.entity.param.MenuQueryParam;
import cn.abellee.sysadmin.organization.entity.po.Menu;

import java.util.List;

public interface MenuService {
    /**
     * 获取菜单
     *
     * @param id
     * @return
     */
    Menu get(String id);

    /**
     * 新增菜单
     *
     * @param menu
     * @return
     */
    boolean add(Menu menu);

    /**
     * 查询菜单
     *
     * @return
     */
    List<Menu> query(MenuQueryParam menuQueryParam);

    /**
     * 根据父id查询菜单
     *
     * @return
     */
    List<Menu> queryByParentId(String id);

    /**
     * 更新菜单信息
     *
     * @param menu
     */
    boolean update(Menu menu);

    /**
     * 根据id删除菜单
     *
     * @param id
     */
    boolean delete(String id);
}
