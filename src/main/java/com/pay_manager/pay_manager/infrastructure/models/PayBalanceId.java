package com.pay_manager.pay_manager.infrastructure.models;

import java.io.Serializable;
import java.util.Objects;

public class PayBalanceId implements Serializable {

    private Long payBalanceId;

    private Long outstandingBalance;  // debe ser Long, no la entidad

    public PayBalanceId() {
    }

    public PayBalanceId(Long payBalanceId, Long outstandingBalance) {
        this.payBalanceId = payBalanceId;
        this.outstandingBalance = outstandingBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PayBalanceId)) return false;
        PayBalanceId that = (PayBalanceId) o;
        return Objects.equals(payBalanceId, that.payBalanceId) &&
                Objects.equals(outstandingBalance, that.outstandingBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payBalanceId, outstandingBalance);
    }

    // getters y setters (opcional)
}
