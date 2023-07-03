package com.example.montecomp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity sert à préciser à Spring que cette classe sera utilisée pour créer une table dans la database
@Entity
//@Getter et @Setter sont des annotations venant de la library lombok. Cela permet d'avoir à éviter de faire des getter et des setter individuelement pour chaque attribut
@Getter
@Setter
public class Product {
    //Les entity ont obligatoirement d'un id, annoté avec @Id
    @Id
    //On utilise cette annotation pour générer automatiquement un id à chaque nouvelle insertion (plus securisé que de les générer à la main)
    @GeneratedValue(strategy = GenerationType.AUTO)
    //ici on précise le nom qu'aura la colonne correspondante dans la database
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "type", nullable = false)
    private String type;
}
