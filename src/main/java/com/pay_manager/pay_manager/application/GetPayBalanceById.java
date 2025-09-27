package com.pay_manager.pay_manager.application;

import com.pay_manager.pay_manager.domain.PayBalance;
import com.pay_manager.pay_manager.domain.repository.PayBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GetPayBalanceById {
    private final PayBalanceRepository repository;

    @Autowired
    public GetPayBalanceById(PayBalanceRepository repository) {
        this.repository = repository;
    }

    public List<PayBalance> getPayBalanceById(Long id) {
        return repository.getPayBalanceById( id );
    }
}
