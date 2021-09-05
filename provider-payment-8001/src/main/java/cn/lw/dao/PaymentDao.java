package cn.lw.dao;

import cn.lw.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public Payment getPaymentById(@Param("id") Long id);

    public int createPay(Payment payment);
}
