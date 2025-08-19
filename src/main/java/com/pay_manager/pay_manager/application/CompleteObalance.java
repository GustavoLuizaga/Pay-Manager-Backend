package com.pay_manager.pay_manager.application;

import com.pay_manager.pay_manager.domain.repository.OutstandingBalanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompleteObalance {
    private final OutstandingBalanceRepository repository;

    @Autowired
    public CompleteObalance(OutstandingBalanceRepository repository) {
        this.repository = repository;
    }

    public boolean completeObalance(Long outstandingBalanceId) {

        return repository.completeOutstandingBalance(outstandingBalanceId);

    }

}
