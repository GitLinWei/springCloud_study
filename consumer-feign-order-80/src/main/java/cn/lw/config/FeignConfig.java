package cn.lw.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @Author linwei
 * @Date 2021/9/12 22:45
 * @Description  feign日志级别配置
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feiLoggerLevel(){
       return Logger.Level.FULL;
    }
}