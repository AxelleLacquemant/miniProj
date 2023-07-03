package com.example.montecomp.controller;

import com.example.montecomp.model.Product;
import com.example.montecomp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//On précise que c'est un controller pour Spring
@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    //on initialise le service
    private final ProductService productService;

    //Pour toutes les routes, la logique est la même: on retourne une Response à laquelle on ajoute un status 200, puis on appelle les méthodes des services dans le body

    @PostMapping("/new")
    //@RequestBody permet de récupérer un argument dans le body de la requête
    public ResponseEntity<Product> newProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.OK).body(productService.newProduct(product));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    //On utilise des crochets pour les paths dynamique
    //Par ex, ici un GET /product/7 renverra l'objet avec l'id 7
    @GetMapping("/{id}")
    //@PathVariable fonctionne comme @RequestBody, mais pour les arguments passés dans l'url
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

    //Le delete est un peu différent parce que ma méthode n'a pas de return dans le service, mais c'est le même principe
    //Ici, on met un message texte dans le body à la place
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        productService.deleteById(Long.valueOf(id));
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Product #%s has been successfully deleted.", id));
    }
}
