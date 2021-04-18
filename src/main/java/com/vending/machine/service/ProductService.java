package com.vending.machine.service;

import java.util.List;
import java.util.Optional;

import com.vending.machine.entity.Products;
import com.vending.machine.repository.ProductsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductsRepo productsRepo;

    public String addProducts(Products product) {
        if(validateMachineStorage()) {
            productsRepo.save(product);
            return "Product added Successfully";
        }
        return "Storage is full";
    }
    public List<Products> selectProducts() {
        List<Products> productList =productsRepo.findAll();
        return productList;
    }

    public Products selectProduct(Long id) {
        Optional<Products> product =productsRepo.findById(id);
        return product.isPresent()?product.get():new Products();
    }

    private Boolean validateMachineStorage() {
        Long count = productsRepo.getProductCounts();
        boolean isValid = count>=120?false:true;
        return isValid;
    }
}
