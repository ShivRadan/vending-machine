package com.vending.machine.service;

import java.util.stream.DoubleStream;

import com.vending.machine.repository.CashRepo;

import org.springframework.beans.factory.annotation.Autowired;

public class CashService {

    @Autowired
    private CashRepo cashRepo;

    private boolean validateCash(double amount) {
        Long count = cashRepo.getCashCounts();
        boolean contains = DoubleStream.of(1,2,5,10).anyMatch(x -> x == amount);
        if(count<=500 && contains) {
            return true;
        }
        return false;
    }


}
