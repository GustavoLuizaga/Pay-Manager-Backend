package com.pay_manager.pay_manager.domain.repository;

import com.pay_manager.pay_manager.domain.PayBalance;
import java.time.LocalDate;
import java.util.List;

public interface PayBalanceRepository {

    boolean payBalance(Long oustingBalanceId, int mountPay, LocalDate datePay, String typePay);
    List<PayBalance> getPayBalanceById(Long oustingBalanceId);

}
