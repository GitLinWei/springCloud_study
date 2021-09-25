package cn.lw.service;


import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author: linwei
 * @CreteTime: 2021/9/17 14:18
 * @Description:TODO
 */

@Service
public class PaymentServcie {
    public String paymentinfo_Success( Integer id){
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo ok id:"+id+"(*^▽^*)";
    }

    @HystrixCommand(fallbackMethod = "paymentinfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="5000")//超时3s时降级到fallbackMethod的方法
    })
    public String paymentinfo_timeout( Integer id){
        //int age =10/0;  //运行异常
        int sum=3000;
        try {
            TimeUnit.MILLISECONDS.sleep(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "payment-8001 有点慢 ￣へ￣"+"耗时（毫秒）："+sum;
    }

    public String paymentinfo_timeoutHandler(Integer id){//超时异常
        return "payment-8001  系统繁忙或错误：o(╥﹏╥)o";
    }

    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCirCuitBreak(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("***id不能为负数！");
        }
        String serialNum= IdUtil.randomUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功！流水号:"+serialNum;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

}
