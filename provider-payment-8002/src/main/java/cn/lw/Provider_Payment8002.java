package cn.lw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Provider_Payment8002 {

    public static void main(String[] args) {
        SpringApplication.run(Provider_Payment8002.class, args);
    }

}
