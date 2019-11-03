package cn.abellee.service.impl;

import cn.abellee.domain.Role;
import cn.abellee.provider.OrganizationProvider;
import cn.abellee.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Abel Lee
 * @date 2019/11/2 3:42 下午
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private OrganizationProvider organizationProvider;

    @Override
    public Set<Role> queryUserRolesByUserId(String userId) {
        return organizationProvider.queryRolesByUserId(userId).getData();
    }

}
