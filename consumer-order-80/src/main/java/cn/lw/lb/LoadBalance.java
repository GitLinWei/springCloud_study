package cn.lw.lb;

import org.springframework.cloud.client.ServiceInstance;
import java.util.List;

/**
 * @Author linwei
 * @Date 2021/9/11 11:51
 * @Description TODO
 */
public interface LoadBalance {
    ServiceInstance instances(List<ServiceInstance>serviceInstances);
}
