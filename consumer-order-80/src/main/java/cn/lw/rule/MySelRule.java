package cn.lw.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author linwei
 * @Date 2021/9/5 10:57
 * @Description TODO
 */
@Configuration
public class MySelRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();//随机分发
    }
}