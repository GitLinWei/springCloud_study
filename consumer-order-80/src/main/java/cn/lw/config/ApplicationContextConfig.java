package cn.lw.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: linwei
 * @CreteTime: 2021/8/18 18:11
 * @Description:TODO
 */
@Configuration
public class ApplicationContextConfig {

    //applicationContext.xml <bean id="" class="">
    @Bean
    //@LoadBalanced   //RestTemplate 赋予负载均衡功能
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
