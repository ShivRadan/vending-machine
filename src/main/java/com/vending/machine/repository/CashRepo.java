package com.vending.machine.repository;

import com.vending.machine.entity.Cash;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CashRepo extends JpaRepository<Cash, Long>{

    @Query(value="select count(*) from vend_schema.cash c", nativeQuery = true)
    Long getCashCounts();
    
}
