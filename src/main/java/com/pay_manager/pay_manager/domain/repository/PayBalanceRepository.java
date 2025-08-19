package com.pay_manager.pay_manager.domain.repository;

import java.time.LocalDate;

public interface PayBalanceRepository {

    boolean payBalance(Long oustingBalanceId, int mountPay, LocalDate datePay, String typePay);

}
