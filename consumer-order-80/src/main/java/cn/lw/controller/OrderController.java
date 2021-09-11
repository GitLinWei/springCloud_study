package cn.lw.controller;

import cn.lw.entity.CommonResult;
import cn.lw.entity.Payment;
import cn.lw.lb.LoadBalance;
import com.sun.jndi.toolkit.url.Uri;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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
    @Resource
    private LoadBalance loadBalance;
    @Resource
    private DiscoveryClient discoveryClient;
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

    @GetMapping("/consumer/payment/getforEntity/{id}")
    public CommonResult<Payment> getforEntity(@PathVariable("id") Long id){

        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAY_URL+"/payment/getPaymentById/"+id,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            CommonResult body=entity.getBody();
            log.info("查询结果："+body);
            return body;
        }else {
            return new CommonResult<>(444,"查询失败");
        }
    }

    @PostMapping("/consumer/payment/postEntity")
    public CommonResult<Payment> postEntity(@RequestBody Payment payment){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CommonResult>entity= restTemplate.postForEntity(PAY_URL+"/payment/createPay",payment,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            CommonResult body=entity.getBody();
            log.info("插入数据："+body);
            return body;
        }else {
            return new CommonResult<>(444,"插入失败");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")//自定义LoadBalance
    public String getPaymentLB() {
        List<ServiceInstance> instanceList=discoveryClient.getInstances("provider-payment");
        if(instanceList==null || instanceList.size()<=0){
            return null;
        }else {
            ServiceInstance serviceInstance=loadBalance.instances(instanceList);
            URI uri=serviceInstance.getUri();
            return restTemplate.getForObject(uri+"/payment/lb",String.class);
        }
    }

}
