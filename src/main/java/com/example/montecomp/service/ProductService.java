package com.example.montecomp.service;

import com.example.montecomp.model.Product;

import java.util.List;

//Cette classe n'est qu'une interface, l'implementation se fait dans ProductServiceImpl
public interface ProductService {
    Product newProduct(Product product);
    List<Product> getAll();
    Product getById(Long id);
    List<Product> getByType(String type);
    Product updateName(Long id, String name);
    Product updatePrice(Long id, Integer price);
    Product updateType(Long id, String type);
    void deleteById(Long id);
}
