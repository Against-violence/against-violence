package cn.abellee.service;

import cn.abellee.domain.User;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author Abel Lee
 * @date 2019/11/2 3:40 下午
 */
public interface UserService {

    /**
     * 根据用户唯一标识获取用户信息
     *
     * @param uniqueId
     * @return
     */
    @Cacheable(value = "#id")
    User getByUniqueId(String uniqueId);
}
