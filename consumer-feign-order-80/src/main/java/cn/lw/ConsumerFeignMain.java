package cn.lw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author linwei
 * @Date 2021/9/12 16:02
 * @Description TODO
 */
@SpringBootApplication
@EnableFeignClients //开启使用feign
public class ConsumerFeignMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignMain.class,args);
    }
}