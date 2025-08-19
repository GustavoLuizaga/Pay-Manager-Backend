package com.pay_manager.pay_manager.application;
import com.pay_manager.pay_manager.domain.CalculateBalance;
import com.pay_manager.pay_manager.domain.OutstandingBalance;
import com.pay_manager.pay_manager.domain.repository.OutstandingBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllOutstandingBalance {
    private final OutstandingBalanceRepository repository;
    private final CalculateBalance calculateBalance;


    @Autowired
    public GetAllOutstandingBalance(OutstandingBalanceRepository repository, CalculateBalance calculateBalance) {
        this.repository = repository;
        this.calculateBalance = calculateBalance;

    }

    public List<OutstandingBalance> getAllOutstandingBalance() {
        return repository.getAllOutstandingBalance()
                .stream()
                .peek(entity -> entity.setBalance(
                        calculateBalance.calculateBalance(
                                entity.getPayBalances(),
                                entity.getMount()
                        )
                ))
                .toList();
    }

}
