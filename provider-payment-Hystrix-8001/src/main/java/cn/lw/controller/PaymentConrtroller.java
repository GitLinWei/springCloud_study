package cn.lw.controller;

import cn.lw.service.PaymentServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: linwei
 * @CreteTime: 2021/9/17 14:18
 * @Description:TODO
 */

@RestController
@Slf4j
public class PaymentConrtroller {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentServcie paymentServcie;

    @GetMapping("/payment/hystrix/success/{id}")
    public String paymentinfo_Success(@PathVariable("id") Integer id){
        return paymentServcie.paymentinfo_Success(id);

    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentinfo_timeout( Integer id) {
       String result=paymentServcie.paymentinfo_timeout(id);
       log.info("result***"+result);
       return result;
    }
}
