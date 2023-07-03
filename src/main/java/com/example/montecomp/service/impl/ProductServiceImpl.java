package com.example.montecomp.service.impl;

import com.example.montecomp.model.Product;
import com.example.montecomp.repository.ProductRepository;
import com.example.montecomp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    //CREATE
    public Product newProduct(Product product) {
        return repository.save(product);
    }

    //READ
    public List<Product> getAll(){
        return repository.findAll();
    }

    public Product getById(Long id) { return repository.findById(id).get(); }

    public List<Product> getByType(String type) {
        return repository.findByType(type);
    }

    //UPDATE
    public Product updateName(Long id, String name) {
        try {
            Product product = repository.findById(id).get();
            product.setName(name);
            return repository.save(product);
        } catch (Exception e){
            System.out.printf("Product #%s not found%n", id.toString());
            return null;
        }
    }

    public Product updatePrice(Long id, Integer price){
        try {
            Product product = repository.findById(id).get();
            product.setPrice(price);
            return repository.save(product);
        } catch (Exception e){
            System.out.printf("Product #%s not found%n", id.toString());
            return null;
        }
    }

    public Product updateType(Long id, String type){
        try {
            Product product = repository.findById(id).get();
            product.setType(type);
            return repository.save(product);
        } catch (Exception e){
            System.out.printf("Product #%s not found%n", id.toString());
            return null;
        }
    }

    //DELETE
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
