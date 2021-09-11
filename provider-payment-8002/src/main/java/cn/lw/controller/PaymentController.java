package cn.lw.controller;

import cn.lw.service.PaymentService;
import cn.lw.entity.CommonResult;
import cn.lw.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: linwei
 * @CreteTime: 2021/8/17 22:30
 * @Description:TODO
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")//获取本服务端口
    private String serverPort;

    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
       Payment payment=paymentService.getPaymentById(id);
       if(payment!=null){
           return new CommonResult(200,"获取信息成功，serverPort:"+serverPort,payment);
       }else {
           return new CommonResult(200,"无法获取信息，ID="+id,payment);
       }

    }

    @PostMapping("/payment/createPay")
    public CommonResult createPay(@RequestBody Payment payment){
        int result=paymentService.createPay(payment);
        log.info("---插入成功："+result);
        if(payment!=null){
            return new CommonResult(200,"插入信息成功，serverPort:"+serverPort,result);
        }else {
            return new CommonResult(200,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
}
