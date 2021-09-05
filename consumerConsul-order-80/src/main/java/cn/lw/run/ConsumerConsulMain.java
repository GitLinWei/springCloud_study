package cn.lw.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author linwei
 * @Date 2021/8/29 17:32
 * @Description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulMain.class,args);
    }
}