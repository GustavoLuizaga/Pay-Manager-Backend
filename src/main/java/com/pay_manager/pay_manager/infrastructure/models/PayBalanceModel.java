package com.pay_manager.pay_manager.infrastructure.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@IdClass(PayBalanceId.class)
public class PayBalanceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_balance_id")
    private Long payBalanceId;

    @Id
    @Column(name = "outstanding_balance_id", nullable = false)
    private Long outstandingBalance;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "outstanding_balance_id", insertable = false, updatable = false)
    private OutstandingBalanceModel outstandingBalanceModel;

    private LocalDate datePay;
    private int mountPay;
    private String payType;

    public PayBalanceModel() {}

    public PayBalanceModel(Long outstandingBalance, LocalDate datePay, int mountPay, String payType) {
        this.outstandingBalance = outstandingBalance;
        this.datePay = datePay;
        this.mountPay = mountPay;
        this.payType = payType;
    }

    public Long getPayBalanceId() {
        return payBalanceId;
    }

    public void setPayBalanceId(Long payBalanceId) {
        this.payBalanceId = payBalanceId;
    }

    public Long getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(Long outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }

    public OutstandingBalanceModel getOutstandingBalanceModel() {
        return outstandingBalanceModel;
    }

    public void setOutstandingBalanceModel(OutstandingBalanceModel outstandingBalanceModel) {
        this.outstandingBalanceModel = outstandingBalanceModel;
    }

    public LocalDate getDatePay() {
        return datePay;
    }

    public void setDatePay(LocalDate datePay) {
        this.datePay = datePay;
    }

    public int getMountPay() {
        return mountPay;
    }

    public void setMountPay(int mountPay) {
        this.mountPay = mountPay;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
