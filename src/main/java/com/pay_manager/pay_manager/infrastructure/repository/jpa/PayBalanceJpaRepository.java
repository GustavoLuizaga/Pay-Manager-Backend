package com.pay_manager.pay_manager.infrastructure.repository.jpa;

import com.pay_manager.pay_manager.infrastructure.models.PayBalanceModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface PayBalanceJpaRepository extends JpaRepository<PayBalanceModel, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO pay_balance_model (outstanding_balance_id, date_pay, mount_pay, pay_type) VALUES (:outstandingBalanceId, :datePay, :mountPay, :payType)", nativeQuery = true)
    void insertPayBalance(@Param("outstandingBalanceId") Long outstandingBalanceId,
                          @Param("datePay") LocalDate datePay,
                          @Param("mountPay") int mountPay,
                          @Param("payType") String payType);

    List<PayBalanceModel> findByOutstandingBalanceModel_Id(Long outstandingBalanceId);

}
