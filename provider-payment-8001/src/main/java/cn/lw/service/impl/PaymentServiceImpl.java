package cn.lw.service.impl;

import cn.lw.dao.PaymentDao;
import cn.lw.service.PaymentService;
import cn.lw.entity.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: linwei
 * @CreteTime: 2021/8/17 22:23
 * @Description:TODO
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public int createPay(Payment payment) {
        return paymentDao.createPay(payment);
    }
}
