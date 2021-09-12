package cn.lw.controller;

import cn.lw.service.PaymentService;
import cn.lw.entity.CommonResult;
import cn.lw.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private DiscoveryClient discoveryClient; //服务发现，微服务注册信息

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
            return new CommonResult(200,"插入信息成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(200,"插入数据库失败",null);
        }
    }

    @GetMapping("payment/discovery")
    public Object discovery(){
       List<String>services =discoveryClient.getServices();//微服务名称
       for (String service:services){
           log.info("微服务Elment："+service);
       }

       List<ServiceInstance>instances=discoveryClient.getInstances("PROVIDER-PAYMENT");//根据微服务名获取所有实例
        for (ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

    @GetMapping(value = "/payment/openFeignTimeout")
    public String openFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);// 业务逻辑处理正确，但是需要耗费3秒钟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }

}
