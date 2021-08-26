package cn.lw.controller;

import cn.lw.entity.CommonResult;
import cn.lw.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: linwei
 * @CreteTime: 2021/8/18 18:10
 * @Description:TODO
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    //private static final String PAY_URL="http://localhost:8001";
    private static final String PAY_URL="http://provider-payment";//通过服务名称找到集群的client，而非端口号


    @GetMapping("/consumer/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       return restTemplate.getForObject(PAY_URL+"/payment/getPaymentById/"+id,CommonResult.class);
    }

    @PostMapping("/consumer/payment/createPay")
    public CommonResult<Payment> createPay(@RequestBody Payment payment){
        log.info("插入结果："+payment);
        return restTemplate.postForObject(PAY_URL+"/payment/createPay",payment,CommonResult.class);
    }
}
