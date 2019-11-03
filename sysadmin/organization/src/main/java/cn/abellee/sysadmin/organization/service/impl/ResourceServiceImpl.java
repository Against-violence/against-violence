package cn.abellee.sysadmin.organization.service.impl;

import cn.abellee.sysadmin.organization.config.BusConfig;
import cn.abellee.sysadmin.organization.dao.ResourceMapper;
import cn.abellee.sysadmin.organization.entity.param.ResourceQueryParam;
import cn.abellee.sysadmin.organization.entity.po.Resource;
import cn.abellee.sysadmin.organization.entity.po.Role;
import cn.abellee.sysadmin.organization.entity.po.RoleResource;
import cn.abellee.sysadmin.organization.entity.po.User;
import cn.abellee.sysadmin.organization.events.EventSender;
import cn.abellee.sysadmin.organization.service.ResourceService;
import cn.abellee.sysadmin.organization.service.RoleResourceService;
import cn.abellee.sysadmin.organization.service.RoleService;
import cn.abellee.sysadmin.organization.service.UserService;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Autowired
    private RoleResourceService roleResourceService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private EventSender eventSender;

    @Override
    public boolean add(Resource resource) {
        eventSender.send(BusConfig.QUEUE_NAME, resource);
        return this.save(resource);
    }

    @Override
    @Cached(name = "resource::", key = "#id", cacheType = CacheType.BOTH)
    public boolean delete(String id) {
        return this.removeById(id);
    }

    @Override
    @Cached(name = "resource::", key = "#resource.id", cacheType = CacheType.BOTH)
    public boolean update(Resource resource) {
        return this.updateById(resource);
    }

    @Override
    @Cached(name = "resource::", key = "#id", cacheType = CacheType.BOTH)
    public Resource get(String id) {
        return this.getById(id);
    }

    @Override
    public List<Resource> query(ResourceQueryParam resourceQueryParam) {
        QueryWrapper<Resource> queryWrapper = resourceQueryParam.build();
        queryWrapper.eq(null != resourceQueryParam.getName(), "name", resourceQueryParam.getName());
        queryWrapper.eq(null != resourceQueryParam.getType(), "type", resourceQueryParam.getType());
        queryWrapper.eq(null != resourceQueryParam.getUrl(), "url", resourceQueryParam.getUrl());
        queryWrapper.eq(null != resourceQueryParam.getMethod(), "method", resourceQueryParam.getMethod());
        return this.list(queryWrapper);
    }

    @Override
    @Cached(name = "resource4user::", key = "#username", cacheType = CacheType.BOTH)
    public List<Resource> query(String username) {
        //根据用户名查询到用户所拥有的角色
        User user = userService.getByUniqueId(username);
        List<Role> roles = roleService.query(user.getId());
        //提取用户所拥有角色id列表
        Set<String> roleIds = roles.stream().map(role -> role.getId()).collect(Collectors.toSet());
        //根据角色列表查询到角色的资源的关联关系
        List<RoleResource> roleResources = roleResourceService.queryByRoleIds(roleIds);
        //根据资源列表查询出所有资源对象
        Set<String> resourceIds = roleResources.stream().map(roleResource -> roleResource.getResourceId()).collect(Collectors.toSet());
        //根据resourceId列表查询出resource对象
        return (List<Resource>) this.listByIds(resourceIds);
    }

}
