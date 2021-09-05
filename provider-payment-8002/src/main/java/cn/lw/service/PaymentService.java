package cn.lw.service;

import cn.lw.entity.Payment;

public interface PaymentService {
    public Payment getPaymentById(Long id);

    public int createPay(Payment payment);
}
