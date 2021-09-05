package cn.lw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author linwei
 * @Date 2021/8/29 17:21
 * @Description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider_Payment8006 {
    public static void main(String[] args) {
        SpringApplication.run(Provider_Payment8006.class,args);
    }
}