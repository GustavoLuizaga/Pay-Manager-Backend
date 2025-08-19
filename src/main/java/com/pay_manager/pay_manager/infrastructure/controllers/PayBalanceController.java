package com.pay_manager.pay_manager.infrastructure.controllers;

import com.pay_manager.pay_manager.application.PayBalanceUseCase;
import com.pay_manager.pay_manager.domain.Exceptions.OutstandingBalanceNotFoundException;
import com.pay_manager.pay_manager.domain.PayBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay-balance")
public class PayBalanceController {

    private final PayBalanceUseCase payBalanceUseCase;

    @Autowired
    public PayBalanceController(PayBalanceUseCase payBalanceUseCase) {
        this.payBalanceUseCase = payBalanceUseCase;
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> payBalance(@RequestBody PayBalance payBalanceRequest, @PathVariable Long id) {
        try {
            boolean pay = payBalanceUseCase.payBalance(
                    id,
                    payBalanceRequest.getMountPay(),
                    payBalanceRequest.getDatePay(),
                    payBalanceRequest.getPayType()
            );

            if (pay) {
                return ResponseEntity.ok("Successful payment");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid payment");

        } catch (OutstandingBalanceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

}
