package cn.lw.Dao;

import cn.lw.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    public Payment getPaymentById(Long id);

    public int createPay(Payment payment);
}
