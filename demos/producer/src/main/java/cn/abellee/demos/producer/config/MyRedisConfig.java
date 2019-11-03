package cn.abellee.demos.producer.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import redis.RedisConfig;

@Configuration
@EnableCaching
public class MyRedisConfig extends RedisConfig {

}