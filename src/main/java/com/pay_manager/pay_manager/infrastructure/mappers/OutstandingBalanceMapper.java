package com.pay_manager.pay_manager.infrastructure.mappers;

import com.pay_manager.pay_manager.domain.OutstandingBalance;
import com.pay_manager.pay_manager.domain.PayBalance;
import com.pay_manager.pay_manager.infrastructure.models.OutstandingBalanceModel;

import java.util.List;

public class OutstandingBalanceMapper {

    public OutstandingBalance toDomain(OutstandingBalanceModel outstandingBalanceModel ){
       List<PayBalance> paysDomain = new PayBalanceListMapper().
               toDomain(outstandingBalanceModel.getPayBalances());
        OutstandingBalance ouBalanceDomain= new OutstandingBalance(
                outstandingBalanceModel.getDateStart(),
                outstandingBalanceModel.getTitle(),
                outstandingBalanceModel.getDescription(),
                outstandingBalanceModel.getDateEnd(),
                outstandingBalanceModel.getFullName(),
                outstandingBalanceModel.getMount(),
                outstandingBalanceModel.isState(),
                paysDomain
        );
        ouBalanceDomain.setId(outstandingBalanceModel.getId());

        if (paysDomain.isEmpty()){
            int balance = ouBalanceDomain.getMount();
            ouBalanceDomain.setBalance( balance );
        }

        return ouBalanceDomain;
    }
}
