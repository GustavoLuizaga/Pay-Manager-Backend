package com.pay_manager.pay_manager.infrastructure.controllers;
import com.pay_manager.pay_manager.application.CompleteObalance;
import com.pay_manager.pay_manager.application.CreatorOutstandingBalance;
import com.pay_manager.pay_manager.application.GetAllOutstandingBalance;
import com.pay_manager.pay_manager.application.RemoverOutstandingBalance;
import com.pay_manager.pay_manager.domain.OutstandingBalance;
import com.pay_manager.pay_manager.infrastructure.controllers.apiResponse.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/outstanding-balance")
public class OutstandingBalanceController {

    private final CreatorOutstandingBalance createOutstandingBalance;
    private final GetAllOutstandingBalance getAllOutstandingBalance;
    private final RemoverOutstandingBalance removerOutstandingBalance;
    private final CompleteObalance completeObalance;

    @Autowired
    public OutstandingBalanceController(CreatorOutstandingBalance createOutstandingBalance,
                                        GetAllOutstandingBalance getAllOutstandingBalance,
                                        RemoverOutstandingBalance removerOutstandingBalance,
                                        CompleteObalance completeObalance) {
        this.createOutstandingBalance = createOutstandingBalance;
        this.getAllOutstandingBalance = getAllOutstandingBalance;
        this.removerOutstandingBalance = removerOutstandingBalance;
        this.completeObalance = completeObalance;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<OutstandingBalance>> create(@RequestBody OutstandingBalance request) {
        try {
            OutstandingBalance created = createOutstandingBalance.create(request);
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("Outstanding balance created successfully", created));
        } catch (Exception ex) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error("Error creating outstanding balance: " + ex.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<OutstandingBalance>>> getAll() {
        List<OutstandingBalance> balances = getAllOutstandingBalance.getAllOutstandingBalance();
        return ResponseEntity.ok(ApiResponse.success("Outstanding balances retrieved successfully", balances));
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        boolean deleted = removerOutstandingBalance.remove(id);
        if (deleted) {
            return ResponseEntity.ok(ApiResponse.success("Outstanding balance with ID " + id + " deleted successfully", null));
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error("Outstanding balance with ID " + id + " not found"));
        }
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<ApiResponse<Void>> complete(@PathVariable Long id) {
        boolean complete = completeObalance.completeObalance(id);
        if (complete) {
            return ResponseEntity.ok(ApiResponse.success("Outstanding balance with ID " + id + " marked as completed", null));
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error("Outstanding balance with ID " + id + " not found"));
        }
    }


}
