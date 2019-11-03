package cn.abellee.provider;

import cn.abellee.core.domain.vo.Result;
import cn.abellee.domain.Role;
import cn.abellee.domain.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Abel Lee
 * @date 2019/11/2 3:39 下午
 */
@Component
public class OrganizationProviderFallback implements OrganizationProvider {

    @Override
    public Result<User> getUserByUniqueId(String uniqueId) {
        return Result.success(new User());
    }

    @Override
    public Result<Set<Role>> queryRolesByUserId(String userId) {
        return Result.success(new HashSet<Role>());
    }
}
