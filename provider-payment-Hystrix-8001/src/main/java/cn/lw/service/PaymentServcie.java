package cn.lw.service;


import ch.qos.logback.core.util.TimeUtil;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: linwei
 * @CreteTime: 2021/9/17 14:18
 * @Description:TODO
 */

@Service
public class PaymentServcie {
    public String paymentinfo_Success( Integer id){
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo ok id:"+id+"√";
    }

    public String paymentinfo_timeout( Integer id){
        int sum=3;
        try {
            TimeUnit.SECONDS.sleep(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+"id:"+id+"耗时（秒）："+sum+"";
    }

}
