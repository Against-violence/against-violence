package cn.abellee.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Abel Lee
 * @date 2019/11/2 3:39 下午
 */
//@FeignClient(name = "sms", fallback = OrganizationProviderFallback.class)
public interface SmsCodeProvider {

    /**
     * @param mobile
     * @return
     */
    @GetMapping(value = "/sms/{mobile}")
    String getSmsCode(@PathVariable("mobile") String mobile, @RequestParam("businessType") String businessType);
}
