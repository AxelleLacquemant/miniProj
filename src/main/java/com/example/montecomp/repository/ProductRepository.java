package com.example.montecomp.repository;

import com.example.montecomp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Le repository JPA sert d'interface entre l'app et la db
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Par défaut, plusieurs méthodes sont built-in (comme save, deleteById ou findById)
    //Lorsqu'on a besoin d'un méthode custom, on peut la déclarer comme ça:
    List<Product> findByType(String type);
    //Ça ne marche que si la convention de nommage est respectée. Ici, JPA reconnaît le keyword "findBy" ainsi que l'attribut "type" de l'objet Product
}