package cn.lw.config;

import cn.lw.entity.CommonResult;
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
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
