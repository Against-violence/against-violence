package cn.abellee.auth.server.event;

import cn.abellee.auth.server.domain.po.Resource;
import cn.abellee.auth.server.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Abel Lee
 * @date 2019/11/2 2:53 下午
 */
@Component
@Slf4j
public class BusReceiver {

    private final ResourceService resourceService;

    public BusReceiver(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    public void handleMessage(Resource resource) {
        log.info("Received Message:<{}>", resource);
        resourceService.saveResource(resource);
    }
}
