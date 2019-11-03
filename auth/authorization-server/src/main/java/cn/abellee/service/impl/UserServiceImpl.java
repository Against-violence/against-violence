package cn.abellee.service.impl;

import cn.abellee.domain.User;
import cn.abellee.provider.OrganizationProvider;
import cn.abellee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Abel Lee
 * @date 2019/11/2 3:41 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private OrganizationProvider organizationProvider;

    @Override
    public User getByUniqueId(String uniqueId) {
        return organizationProvider.getUserByUniqueId(uniqueId).getData();
    }
}
