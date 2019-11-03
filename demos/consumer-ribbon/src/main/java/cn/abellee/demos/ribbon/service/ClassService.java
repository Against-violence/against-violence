package cn.abellee.demos.ribbon.service;

import cn.abellee.core.domain.vo.Result;
import cn.abellee.core.exception.SystemErrorType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ClassService {

    private final RestTemplate restTemplate;

    public ClassService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SentinelResource(fallback = "usersFallback")
    public Result users(String name) {
        return restTemplate.getForEntity("http://producer/product/?name={1}", Result.class, name).getBody();
    }

    @SentinelResource(fallback = "usersFallback")
    public Result users(Map map) {
        return restTemplate.postForEntity("http://producer/product/", map, Result.class).getBody();
    }

    public Result usersFallback(String name) {
        return Result.fail(SystemErrorType.SYSTEM_BUSY);
    }

    public Result usersFallback(Map map) {
        return Result.fail(SystemErrorType.SYSTEM_BUSY);
    }
}
