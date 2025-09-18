package com.pay_manager.pay_manager.application;

import com.pay_manager.pay_manager.domain.OutstandingBalance;
import com.pay_manager.pay_manager.domain.repository.OutstandingBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatorOutstandingBalance {
    private final OutstandingBalanceRepository repository;
    @Autowired
    public CreatorOutstandingBalance(OutstandingBalanceRepository ouBalance) {
        this.repository = ouBalance;

    }

    public OutstandingBalance create(OutstandingBalance request){
        return repository.createOutstandingBalance(request);
    }
}
