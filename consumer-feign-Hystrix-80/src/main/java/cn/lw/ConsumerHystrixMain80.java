package cn.lw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author linwei
 * @Date 2021/9/20 22:29
 * @Description TODO
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@EnableCircuitBreaker //
public class ConsumerHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixMain80.class,args);
    }
}