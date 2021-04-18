package com.vending.machine.repository;

import java.util.List;

import com.vending.machine.entity.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Long> {
    
    @Query(value="select count(*) from vend_schema.products p", nativeQuery = true)
    Long getProductCounts();
}
