package cn.lw.controller;

import cn.lw.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author linwei
 * @Date 2021/9/20 22:36
 * @Description TODO
 */
@RestController
@Slf4j
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/success/{id}")
    public String paymentinfo_Success(@PathVariable("id") Integer id){
        String result=paymentHystrixService.paymentinfo_Success(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentinfo_timeout(@PathVariable("id") Integer id){
        String result=paymentHystrixService.paymentinfo_timeout(id);
        return result;
    }

}