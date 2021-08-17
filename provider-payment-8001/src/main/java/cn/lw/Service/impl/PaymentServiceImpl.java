package cn.lw.Service.impl;

import cn.lw.Dao.PaymentDao;
import cn.lw.Service.PaymentService;
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
