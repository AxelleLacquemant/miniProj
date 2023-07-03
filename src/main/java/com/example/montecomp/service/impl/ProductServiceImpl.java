package com.example.montecomp.service.impl;

import com.example.montecomp.model.Product;
import com.example.montecomp.repository.ProductRepository;
import com.example.montecomp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//On annote pour que Spring reconnaisse le service et le traite comme tel
@Service
//Cette annotation lombok permet de générer un constructeur sans avoir à le coder, à la manière des Getter et Setter
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    //On initialise le repository correspondant
    private final ProductRepository repository;

    //Ici je vais commenter plus light, les noms de méthodes sont assez transparents
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
        //On utilise un try dans les update pour éviter un plantage de l'app si repository.findById() retourne une valeur nulle, mais ce n'est pas nécessaire dans l'absolu
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
