package cn.abellee.service;

import cn.abellee.domain.Role;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Abel Lee
 * @date 2019/11/2 3:41 下午
 */
@Service
public interface RoleService {

    Set<Role> queryUserRolesByUserId(String userId);

}
