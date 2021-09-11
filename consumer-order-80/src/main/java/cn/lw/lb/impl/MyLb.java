package cn.lw.lb.impl;

import cn.lw.lb.LoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author linwei
 * @Date 2021/9/11 11:52
 * @Description 手写轮询算法
 */
@Component
public class MyLb implements LoadBalance {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public final int getAndIncreatment(){
        int current;
        int next;

        do{
            current=this.atomicInteger.get();
            next=current>=2147483647 ? 0: current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
            System.out.println("第几次访问，次数next:"+next);
            return next;

    }


    //负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标  ，每次服务重启动后rest接口计数从1开始。
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index=getAndIncreatment() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}