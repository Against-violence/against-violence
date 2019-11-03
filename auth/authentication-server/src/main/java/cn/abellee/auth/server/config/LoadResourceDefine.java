package cn.abellee.auth.server.config;

import cn.abellee.auth.server.service.ResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Abel Lee
 * @date 2019/11/2 2:52 下午
 */
@Component
class LoadResourceDefine {

    private final ResourceService resourceService;

    public LoadResourceDefine(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Bean
    public Map<RequestMatcher, ConfigAttribute> resourceConfigAttributes() {
        return resourceService.loadResource();
    }
}
