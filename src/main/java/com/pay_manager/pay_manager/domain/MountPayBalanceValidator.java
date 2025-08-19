package com.pay_manager.pay_manager.domain;

import org.springframework.stereotype.Service;

@Service
public class MountPayBalanceValidator {

    public boolean validateMountPay(int mountPayBalance, int mountBalance){
        return mountPayBalance <= mountBalance;
    }


}
