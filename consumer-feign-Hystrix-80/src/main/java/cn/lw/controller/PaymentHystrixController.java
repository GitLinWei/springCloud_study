package cn.lw.controller;

import cn.lw.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author linwei
 * @Date 2021/9/20 22:36
 * @Description TODO
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_defaultFallback") //通用降级fllback
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/success/{id}")
    public String paymentinfo_Success(@PathVariable("id") Integer id){
        String result=paymentHystrixService.paymentinfo_Success(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "payment_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="2000")//超时3s时降级到fallbackMethod的方法
    })
    //@HystrixCommand
    public String paymentinfo_timeout(@PathVariable("id") Integer id){
        int age =10/0;  //运行异常
        String result=paymentHystrixService.paymentinfo_timeout(id);
        return result;
    }

    public String payment_timeoutHandler(@PathVariable("id")Integer id){//超时异常
        return "order-80  系统超时繁忙或错误：o(╥﹏╥)o";
    }

    public String global_defaultFallback(){//全局降级方法fallback
        return "通用降级  系统超时繁忙或错误：┭┮﹏┭┮";
    }
}