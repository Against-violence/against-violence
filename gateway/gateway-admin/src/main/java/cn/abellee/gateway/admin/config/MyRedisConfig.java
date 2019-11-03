package cn.abellee.gateway.admin.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import redis.RedisConfig;

/**
 * @author Abel Lee
 * @date 2019/11/2 4:52 下午
 */
@Configuration
@EnableCaching
public class MyRedisConfig extends RedisConfig {
}
