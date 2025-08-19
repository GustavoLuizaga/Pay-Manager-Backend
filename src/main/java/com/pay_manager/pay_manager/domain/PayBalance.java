package com.pay_manager.pay_manager.domain;

import java.time.LocalDate;

public class PayBalance {
    private Long id;
    private LocalDate datePay;
    private int mountPay;
    private String payType;

    public PayBalance(LocalDate datePay, int mountPay, String payType, Long id) {
        this.datePay = datePay;
        this.mountPay = mountPay;
        this.payType = payType;
        this.id = id;
    }

    public PayBalance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public int getMountPay() {
        return mountPay;
    }

    public void setMountPay(int mountPay) {
        this.mountPay = mountPay;
    }

    public LocalDate getDatePay() {
        return datePay;
    }

    public void setDatePay(LocalDate datePay) {
        this.datePay = datePay;
    }
}
