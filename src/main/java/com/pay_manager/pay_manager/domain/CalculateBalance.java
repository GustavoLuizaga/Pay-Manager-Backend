package com.pay_manager.pay_manager.domain;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateBalance {

    public CalculateBalance() {

    }

    public int calculateBalance(List<PayBalance> pays, int mount) {
        int balance = 0;
        for (PayBalance pb : pays) {
            balance = balance + pb.getMountPay();
        }
        return mount-balance;
    }
}
