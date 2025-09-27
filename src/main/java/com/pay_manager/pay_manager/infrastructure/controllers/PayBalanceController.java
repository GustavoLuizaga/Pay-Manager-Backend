package com.pay_manager.pay_manager.infrastructure.controllers;

import com.pay_manager.pay_manager.application.GetPayBalanceById;
import com.pay_manager.pay_manager.application.PayBalanceUseCase;
import com.pay_manager.pay_manager.domain.exceptions.OutstandingBalanceNotFoundException;
import com.pay_manager.pay_manager.domain.PayBalance;
import com.pay_manager.pay_manager.infrastructure.controllers.apiResponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pay-balance")
public class PayBalanceController {

    private final PayBalanceUseCase payBalanceUseCase;
    private final GetPayBalanceById getPayBalanceById;

    @Autowired
    public PayBalanceController(PayBalanceUseCase payBalanceUseCase , GetPayBalanceById getPayBalanceById) {
        this.payBalanceUseCase = payBalanceUseCase;
        this.getPayBalanceById = getPayBalanceById;

    }

    @CrossOrigin(origins = {
            "https://pay-manager-frontend.vercel.app",
            "http://localhost:5173"
    })
    @PostMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> payBalance(@RequestBody PayBalance payBalanceRequest, @PathVariable Long id) {
        try {
            boolean pay = payBalanceUseCase.payBalance(
                    id,
                    payBalanceRequest.getMountPay(),
                    payBalanceRequest.getDatePay(),
                    payBalanceRequest.getPayType()
            );

            if (pay) {
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(ApiResponse.success("Payment created successfully"));
            }
            return ResponseEntity.status(HttpStatus
                    .BAD_REQUEST).body(ApiResponse.error("Invalid payment"));

        } catch (OutstandingBalanceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus
                    .BAD_REQUEST).body(ApiResponse.error("Outstanding Balance Not Found" + ex.getMessage()));
        }
    }

    @CrossOrigin(origins = {
            "https://pay-manager-frontend.vercel.app",
            "http://localhost:5173"
    })
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<List<PayBalance>>> getPayBalance(@PathVariable Long id) {

        List<PayBalance> listPayBalanceResponse = getPayBalanceById.getPayBalanceById(id);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(ApiResponse.success("Payment found", listPayBalanceResponse));

    }

}
