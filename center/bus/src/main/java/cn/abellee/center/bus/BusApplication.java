package cn.abellee.center.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Abel Lee
 * @date 2019/11/2 4:43 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BusApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusApplication.class, args);
    }
}
