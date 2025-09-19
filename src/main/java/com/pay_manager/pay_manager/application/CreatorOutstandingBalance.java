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

    public OutstandingBalance create(OutstandingBalance request ){

        OutstandingBalance created = repository.createOutstandingBalance(request);

        if (created.getPayBalances().isEmpty()){
            int balance = request.getMount();
            created.setBalance( balance );
        }
        return created;
    }
}
