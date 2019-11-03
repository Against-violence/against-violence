package cn.abellee.provider;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Abel Lee
 * @date 2019/11/2 3:40 下午
 */
@Component
public class SmsCodeProviderFallback implements SmsCodeProvider {

    private final PasswordEncoder passwordEncoder;

    public SmsCodeProviderFallback(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String getSmsCode(String mobile, String businessType) {
        // 该类为mock, 目前暂时没有sms的服务
        return passwordEncoder.encode("123456");
    }
}
