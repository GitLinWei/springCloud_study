package cn.lw.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo ok id:"+id+"(*^▽^*)";
    }

    @HystrixCommand(fallbackMethod = "paymentinfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="3000")//超时3s时降级到fallbackMethod的方法
    })
    public String paymentinfo_timeout( Integer id){
        int sum=id;//自定义秒数
        //int age =10/0;  //运行异常
        try {
            TimeUnit.SECONDS.sleep(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+"id:"+id+"有点慢 ￣へ￣"+"耗时（秒）："+sum+"";
    }

    public String paymentinfo_timeoutHandler(Integer id){//超时异常
        return "线程池:"+Thread.currentThread().getName()+"id:"+id+"系统繁忙或错误：o(╥﹏╥)o";
    }

}
