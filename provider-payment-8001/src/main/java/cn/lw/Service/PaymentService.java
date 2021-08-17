package cn.lw.Service;

import cn.lw.entity.Payment;

public interface PaymentService {
    public Payment getPaymentById(Long id);

    public int createPay(Payment payment);
}
