package com.pay_manager.pay_manager.infrastructure.repository;
import com.pay_manager.pay_manager.domain.exceptions.OutstandingBalanceNotFoundException;
import com.pay_manager.pay_manager.domain.OutstandingBalance;
import com.pay_manager.pay_manager.domain.repository.OutstandingBalanceRepository;
import com.pay_manager.pay_manager.infrastructure.mappers.OutstandingBalanceMapper;
import com.pay_manager.pay_manager.infrastructure.repository.jpa.OutstandingBalanceJpaRepository;
import com.pay_manager.pay_manager.infrastructure.models.OutstandingBalanceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Repository
public class ObalancePostgreRepository implements OutstandingBalanceRepository {

    private final OutstandingBalanceJpaRepository jpaRepository;

    @Autowired
    public ObalancePostgreRepository(OutstandingBalanceJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public OutstandingBalance createOutstandingBalance(OutstandingBalance outstandingBalance){
        OutstandingBalanceModel oBalance = new OutstandingBalanceModel(
                outstandingBalance.getDateStart(),
                outstandingBalance.getDateEnd(),
                outstandingBalance.getDescription(),
                outstandingBalance.getTitle(),
                outstandingBalance.getMount(),
                outstandingBalance.isState(),
                outstandingBalance.getFullName()
        );
        OutstandingBalanceModel savedEntity = jpaRepository.save(oBalance);
        return new OutstandingBalanceMapper().toDomain(savedEntity);
    }

    @Override
    public boolean deleteOutstandingBalance(Long outstandingBalance){
        try{
            jpaRepository.deleteById( outstandingBalance);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
       }

    @Override
    public List<OutstandingBalance> getAllOutstandingBalance() {
        List<OutstandingBalanceModel> entities = jpaRepository.findAll(Sort.by("id"));
        return entities.stream()
                .map(entity -> {
                    return new OutstandingBalanceMapper().toDomain(entity);
                })
                .toList();
    }


    @Override
    public boolean completeOutstandingBalance(Long outstandingBalance) {

        try {
            Optional<OutstandingBalanceModel> ob = jpaRepository.findById(outstandingBalance);

            if (ob.isPresent()) {
                OutstandingBalanceModel balance = ob.get();
                balance.setState(!balance.isState());
                jpaRepository.save(balance);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public OutstandingBalance findByIdOutstandingBalance(Long outstandingBalanceId) {
        OutstandingBalanceModel model = jpaRepository.findById(outstandingBalanceId)
                .orElseThrow(() -> new OutstandingBalanceNotFoundException(outstandingBalanceId));
        return new OutstandingBalanceMapper().toDomain(model);
    }



}
