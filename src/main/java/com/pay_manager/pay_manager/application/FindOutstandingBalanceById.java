package com.pay_manager.pay_manager.application;

import com.pay_manager.pay_manager.domain.OutstandingBalance;
import com.pay_manager.pay_manager.domain.repository.OutstandingBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindOutstandingBalanceById {
    private final OutstandingBalanceRepository outstandingBalanceRepository;

    @Autowired
    public FindOutstandingBalanceById(OutstandingBalanceRepository outstandingBalanceRepository) {
        this.outstandingBalanceRepository = outstandingBalanceRepository;
    }

    public OutstandingBalance findOutstandingBalanceById(Long id) {
       return outstandingBalanceRepository.findByIdOutstandingBalance(id);
    }
}
