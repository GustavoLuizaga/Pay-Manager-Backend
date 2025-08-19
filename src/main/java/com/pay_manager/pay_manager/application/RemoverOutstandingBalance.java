package com.pay_manager.pay_manager.application;

import com.pay_manager.pay_manager.domain.repository.OutstandingBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoverOutstandingBalance {
    private final OutstandingBalanceRepository repository;

    @Autowired
    public RemoverOutstandingBalance(OutstandingBalanceRepository repository) {
        this.repository = repository;
    }

    public boolean remove(Long ouBalanceId){
       return repository.deleteOutstandingBalance(ouBalanceId);
    }
}
