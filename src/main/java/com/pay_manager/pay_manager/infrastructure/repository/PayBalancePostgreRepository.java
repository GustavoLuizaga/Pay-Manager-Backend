package com.pay_manager.pay_manager.infrastructure.repository;

import com.pay_manager.pay_manager.domain.PayBalance;
import com.pay_manager.pay_manager.domain.repository.PayBalanceRepository;
import com.pay_manager.pay_manager.infrastructure.mappers.PayBalanceListMapper;
import com.pay_manager.pay_manager.infrastructure.models.PayBalanceModel;
import com.pay_manager.pay_manager.infrastructure.repository.jpa.PayBalanceJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;


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
                mountPay,
                typePay
        );
        return true;
    }

    @Override
    public List<PayBalance> getPayBalanceById(Long oustingBalanceId) {
        List<PayBalanceModel> listModel = jpaRepository.findByOutstandingBalanceModel_Id(oustingBalanceId);
        return new PayBalanceListMapper().toDomain(listModel);
    }

}
