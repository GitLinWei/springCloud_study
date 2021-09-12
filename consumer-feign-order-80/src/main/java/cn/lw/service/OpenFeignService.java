package cn.lw.service;

import cn.lw.entity.CommonResult;
import cn.lw.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author linwei
 * @Date 2021/9/12 16:05
 * @Description TODO
 */
@Component
@FeignClient(value = "provider-payment") //feign调用该名称所有微服务
public interface OpenFeignService {
    @GetMapping("/payment/getPaymentById/{id}")//feign调用该服务下的接口
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/openFeignTimeout")
    public String openFeignTimeout();
}
