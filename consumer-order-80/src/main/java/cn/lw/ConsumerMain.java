package cn.lw;

import cn.lw.rule.MySelRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author: linwei
 * @CreteTime: 2021/8/18 18:43
 * @Description:TODO
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "provider-payment",configuration = MySelRule.class)
public class ConsumerMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain.class,args);
    }
}
