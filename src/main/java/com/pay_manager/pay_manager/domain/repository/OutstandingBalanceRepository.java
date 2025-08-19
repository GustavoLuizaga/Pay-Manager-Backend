package com.pay_manager.pay_manager.domain.repository;

import com.pay_manager.pay_manager.domain.OutstandingBalance;

import java.util.List;

public interface OutstandingBalanceRepository {
    OutstandingBalance createOutstandingBalance(OutstandingBalance outstandingBalance);
    boolean deleteOutstandingBalance(Long outstandingBalance);
    List<OutstandingBalance> getAllOutstandingBalance();
    boolean completeOutstandingBalance(Long outstandingBalanceId);
    OutstandingBalance findByIdOutstandingBalance(Long outstandingBalanceId);
}
