package com.vending.machine.controller;
import com.vending.machine.entity.Products;
import com.vending.machine.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vending/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> addProducts(@RequestBody Products product) {
        return ResponseEntity.ok().body(productService.addProducts(product));
    }

    @GetMapping("/select")
    public ResponseEntity<?> selectProducts() {
        return ResponseEntity.ok().body(productService.selectProducts());
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<?> selectProduct(@RequestParam Long id ) {
        return ResponseEntity.ok().body(productService.selectProduct(id));
    }

    @GetMapping("/healthCheck")
    public ResponseEntity<?> healthCheck() {
        return ResponseEntity.ok().body("Running...");
    }
}
