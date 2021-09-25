package cn.lw.service.impl;

import cn.lw.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Author linwei
 * @Date 2021/9/25 15:11
 * @Description TODO
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentinfo_Success(Integer id) {
        return "服务错误，请稍后再试o(╥﹏╥)o";
    }

    @Override
    public String paymentinfo_timeout(Integer id) {
        return null;
    }
}