package com.pay_manager.pay_manager.infrastructure.mappers;

import com.pay_manager.pay_manager.domain.PayBalance;
import com.pay_manager.pay_manager.infrastructure.models.PayBalanceModel;

import java.util.List;

public class PayBalanceListMapper {

    public List<PayBalance> toDomain(List<PayBalanceModel> payBalance){
        return payBalance.stream().map(pb -> new PayBalance(
                pb.getDatePay(),
                pb.getMountPay(),
                pb.getPayType(),
                pb.getPayBalanceId() )) .toList();
    }
}
