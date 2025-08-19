package com.pay_manager.pay_manager.infrastructure.models;

import jakarta.persistence.*;
import com.pay_manager.pay_manager.infrastructure.models.PayBalanceModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OutstandingBalanceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String description;
    private String title;
    private String fullName;
    private int mount;
    private boolean state;

    @OneToMany(mappedBy = "outstandingBalanceModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PayBalanceModel> payBalances = new ArrayList<PayBalanceModel>();


    public OutstandingBalanceModel() {

    }

    public OutstandingBalanceModel(LocalDate dateStart, LocalDate dateEnd, String description, String title, int mount, boolean state, String fullName) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.description = description;
        this.title = title;
        this.mount = mount;
        this.state = state;
        this.fullName = fullName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PayBalanceModel> getPayBalances() {
        return payBalances;
    }

    public void setPayBalances(List<PayBalanceModel> payBalances) {
        this.payBalances = payBalances;
    }
}
