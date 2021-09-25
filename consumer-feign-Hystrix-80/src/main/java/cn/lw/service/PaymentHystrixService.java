package cn.lw.service;

import cn.lw.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author linwei
 * @Date 2021/9/20 22:34
 * @Description TODO
 */
@Component
@FeignClient(value = "provider-payment-hystrix",fallback = PaymentFallbackService.class) //服务降级到fallbcak实现类
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/success/{id}")
    public String paymentinfo_Success(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentinfo_timeout( @PathVariable("id") Integer id);
}
