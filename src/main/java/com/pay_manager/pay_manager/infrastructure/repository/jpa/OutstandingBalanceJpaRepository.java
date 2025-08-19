package com.pay_manager.pay_manager.infrastructure.repository.jpa;
import com.pay_manager.pay_manager.infrastructure.models.OutstandingBalanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutstandingBalanceJpaRepository extends JpaRepository<OutstandingBalanceModel, Long> {
}
