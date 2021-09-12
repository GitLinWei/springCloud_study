package cn.lw.controller;

import cn.lw.entity.CommonResult;
import cn.lw.entity.Payment;
import cn.lw.service.OpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author linwei
 * @Date 2021/9/12 16:13
 * @Description TODO
 */
@RestController
@Slf4j
public class ConsumerFeignController {
    @Resource
    private OpenFeignService openFeignService;

    @GetMapping("/consumerFeign/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return openFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/openFeignTimeout")
    public String openFeignTimeout() {
        // OpenFeign客户端一般默认等待1秒钟
        return openFeignService.openFeignTimeout();
    }
}