package com.pay_manager.pay_manager.infrastructure.repositorys;

import com.pay_manager.pay_manager.domain.repository.PayBalanceRepository;
import com.pay_manager.pay_manager.infrastructure.repositorys.jpa.PayBalanceJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;


@Repository
public class PayBalancePostgreRepository implements PayBalanceRepository {

    private final PayBalanceJpaRepository jpaRepository;


    @Autowired
    public PayBalancePostgreRepository( PayBalanceJpaRepository jpaRepository)  {
        this.jpaRepository = jpaRepository;

    }

    @Override
    public boolean payBalance(Long oustingBalanceId, int mountPay, LocalDate datePay, String typePay){
        jpaRepository.insertPayBalance(
                oustingBalanceId,
                datePay,
                BigDecimal.valueOf(mountPay),
                typePay
        );
        return true;
    }

}
