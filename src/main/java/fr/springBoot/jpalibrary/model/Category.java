package fr.springBoot.jpalibrary.model;


import jakarta.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private CategoryType name;
}
