package cn.abellee.sysadmin.organization.service;

import cn.abellee.sysadmin.organization.entity.param.ResourceQueryParam;
import cn.abellee.sysadmin.organization.entity.po.Resource;

import java.util.List;

public interface ResourceService {
    /**
     * 获取资源
     *
     * @param id
     * @return
     */
    Resource get(String id);

    /**
     * 新增资源
     *
     * @param resource
     * @return
     */
    boolean add(Resource resource);

    /**
     * 查询资源
     *
     * @return
     */
    List<Resource> query(ResourceQueryParam resourceQueryParam);

    /**
     * 根据username查询角色拥有的资源
     *
     * @return
     */
    List<Resource> query(String username);

    /**
     * 更新资源信息
     *
     * @param resource
     */
    boolean update(Resource resource);

    /**
     * 根据id删除资源
     *
     * @param id
     */
    boolean delete(String id);
}
