package com.pay_manager.pay_manager.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class OutstandingBalance {
    private Long id = 0L;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String description;
    private String title;
    private String fullName;
    private int mount;
    private boolean state;
    private List<PayBalance> payBalances = new ArrayList<>();
    private int balance = 0;

    public OutstandingBalance( LocalDate dateStart, String title, String description, LocalDate dateEnd, String fullName, int mount, boolean state, List<PayBalance> payBalances) {
        this.dateStart = dateStart;
        this.title = title;
        this.description = description;
        this.dateEnd = dateEnd;
        this.fullName = fullName;
        this.mount = mount;
        this.state = state;
        this.payBalances = payBalances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getMount() {
        return mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PayBalance> getPayBalances() {
        return payBalances;
    }

    public void setPayBalances(List<PayBalance> payBalances) {
        this.payBalances = payBalances;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
