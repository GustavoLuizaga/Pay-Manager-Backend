package com.pay_manager.pay_manager.application;

import com.pay_manager.pay_manager.domain.CalculateBalance;
import com.pay_manager.pay_manager.domain.OutstandingBalance;
import com.pay_manager.pay_manager.domain.repository.OutstandingBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindOutstandingBalanceById {
    private final OutstandingBalanceRepository outstandingBalanceRepository;
    private final CalculateBalance calculateBalance;

    @Autowired
    public FindOutstandingBalanceById(OutstandingBalanceRepository outstandingBalanceRepository, CalculateBalance calculateBalance ) {
        this.outstandingBalanceRepository = outstandingBalanceRepository;
        this.calculateBalance = calculateBalance;
    }

    public OutstandingBalance findOutstandingBalanceById(Long id) {
       OutstandingBalance found = outstandingBalanceRepository.findByIdOutstandingBalance(id);
       if(found.getPayBalances().isEmpty()) found.setBalance(found.getMount());
       int calculatedBalance = calculateBalance.calculateBalance(found.getPayBalances(), found.getMount());
       found.setBalance(calculatedBalance);
       return found;
    }
}
