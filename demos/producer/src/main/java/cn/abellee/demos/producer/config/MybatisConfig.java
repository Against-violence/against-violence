package cn.abellee.demos.producer.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 初始化Mybatis审计字段自动赋值的interceptor
 */
@Configuration
public class MybatisConfig {
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}
