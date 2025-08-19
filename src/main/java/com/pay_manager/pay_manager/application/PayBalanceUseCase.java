package com.pay_manager.pay_manager.application;

import com.pay_manager.pay_manager.domain.*;
import com.pay_manager.pay_manager.domain.repository.OutstandingBalanceRepository;
import com.pay_manager.pay_manager.domain.repository.PayBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PayBalanceUseCase {
    private final PayBalanceRepository repository;
    private final OutstandingBalanceRepository outstandingBalanceRepository;
    private final MountPayBalanceValidator mountPayBalanceValidator;
    private final CompleteObalance completeObalance;

    @Autowired
    public PayBalanceUseCase(PayBalanceRepository repository ,
                             OutstandingBalanceRepository outstandingBalanceRepository,
                             MountPayBalanceValidator mountPayBalanceValidator,
                             CompleteObalance completeObalance) {
        this.repository = repository;
        this.outstandingBalanceRepository = outstandingBalanceRepository;
        this.mountPayBalanceValidator = mountPayBalanceValidator;
        this.completeObalance = completeObalance;
    }

    public boolean payBalance(Long id, int mountPay, LocalDate datePay, String typePay ){
        OutstandingBalance outstandingBalance = outstandingBalanceRepository.findByIdOutstandingBalance(id);
        int balance = new CalculateBalance().calculateBalance(outstandingBalance.getPayBalances(),outstandingBalance.getMount());
        if(mountPayBalanceValidator.validateMountPay(mountPay,balance) && balance != 0 ){
            if ((balance-mountPay) == 0) completeObalance.completeObalance(id);
            return repository.payBalance(id,mountPay,datePay,typePay);
        }else {
            return false;
        }

    }
}
