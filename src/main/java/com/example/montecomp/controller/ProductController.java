package com.example.montecomp.controller;

import com.example.montecomp.model.Product;
import com.example.montecomp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/new")
    public ResponseEntity<Product> newProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.OK).body(productService.newProduct(product));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Product>> getProductsByType(@PathVariable String type){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getByType(type));
    }

    @PutMapping("/update-name/{id}")
    public ResponseEntity<Product> updateProductName(@PathVariable Long id, @RequestBody String name){
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateName(id, name));
    }

    @PutMapping("/update-price/{id}")
    public ResponseEntity<Product> updateProductPrice(@PathVariable Long id, @RequestBody Integer price){
        return ResponseEntity.status(HttpStatus.OK).body(productService.updatePrice(id, price));
    }

    @PutMapping("/update-type/{id}")
    public ResponseEntity<Product> updateProductType(@PathVariable Long id, @RequestBody String type){
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateType(id, type));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        productService.deleteById(Long.valueOf(id));
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Product #%s has been successfully deleted.", id));
    }
}
