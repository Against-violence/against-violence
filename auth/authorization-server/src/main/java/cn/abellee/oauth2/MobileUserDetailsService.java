package cn.abellee.oauth2;

import cn.abellee.domain.User;
import cn.abellee.provider.SmsCodeProvider;
import cn.abellee.service.RoleService;
import cn.abellee.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * 手机验证码登陆, 用户相关获取
 */
@Slf4j
@Service("mobileUserDetailsService")
public class MobileUserDetailsService extends CustomUserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private SmsCodeProvider smsCodeProvider;

    public MobileUserDetailsService(UserService userService, RoleService roleService) {
        super(userService, roleService);
    }

    @Override
    public UserDetails loadUserByUsername(String uniqueId) {

        User user = userService.getByUniqueId(uniqueId);
        log.info("load user by mobile:{}", user.toString());

        // 如果为mobile模式，从短信服务中获取验证码（动态密码）
        String credentials = smsCodeProvider.getSmsCode(uniqueId, "LOGIN");

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                credentials,
                user.getEnabled(),
                user.getAccountNonExpired(),
                user.getCredentialsNonExpired(),
                user.getAccountNonLocked(),
                super.obtainGrantedAuthorities(user));
    }
}
