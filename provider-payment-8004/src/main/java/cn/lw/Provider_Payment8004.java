package cn.lw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Provider_Payment8004 {
    public static void main(String[] args) {
        SpringApplication.run(Provider_Payment8004.class,args);
    }
}
