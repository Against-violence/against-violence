package cn.abellee.auth.server.provider;

import cn.abellee.auth.server.domain.po.Resource;
import cn.abellee.core.domain.vo.Result;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Abel Lee
 * @date 2019/11/2 2:54 下午
 */
@Component
public class ResourceProviderFallback implements ResourceProvider {
    @Override
    public Result<Set<Resource>> resources() {
        return Result.success(new HashSet<Resource>());
    }

    @Override
    public Result<Set<Resource>> resources(String username) {
        return Result.success(new HashSet<Resource>());
    }
}
