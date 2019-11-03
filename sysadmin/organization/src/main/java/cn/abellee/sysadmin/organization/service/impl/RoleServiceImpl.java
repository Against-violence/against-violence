package cn.abellee.sysadmin.organization.service.impl;

import cn.abellee.sysadmin.organization.dao.RoleMapper;
import cn.abellee.sysadmin.organization.entity.param.RoleQueryParam;
import cn.abellee.sysadmin.organization.entity.po.Role;
import cn.abellee.sysadmin.organization.service.RoleService;
import cn.abellee.sysadmin.organization.service.UserRoleService;
import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public boolean add(Role role) {
        return this.save(role);
    }

    @Override
    @CacheInvalidate(name = "role::", key = "#id")
    public boolean delete(String id) {
        return this.removeById(id);
    }

    @Override
    @CacheInvalidate(name = "role::", key = "#role.id")
    public boolean update(Role role) {
        return this.updateById(role);
    }

    @Override
    @Cached(name = "role::", key = "#id", cacheType = CacheType.BOTH)
    public Role get(String id) {
        return this.getById(id);
    }

    @Override
    public List<Role> get() {
        return this.list();
    }

    @Override
    @Cached(name = "role4user::", key = "#userId", cacheType = CacheType.BOTH)
    public List<Role> query(String userId) {
        Set<String> roleIds = userRoleService.queryByUserId(userId);
        return (List<Role>) this.listByIds(roleIds);
    }

    @Override
    public IPage<Role> query(Page page, RoleQueryParam roleQueryParam) {
        QueryWrapper<Role> queryWrapper = roleQueryParam.build();
        queryWrapper.eq(StringUtils.isNotBlank(roleQueryParam.getName()), "name", roleQueryParam.getName());
        queryWrapper.eq(StringUtils.isNotBlank(roleQueryParam.getCode()), "code", roleQueryParam.getCode());
        return this.page(page, queryWrapper);
    }
}
