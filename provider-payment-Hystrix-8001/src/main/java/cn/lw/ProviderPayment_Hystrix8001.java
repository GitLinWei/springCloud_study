package cn.lw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: linwei
 * @CreteTime: 2021/9/17 13:58
 * @Description:TODO
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderPayment_Hystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment_Hystrix8001.class,args);
    }
}
