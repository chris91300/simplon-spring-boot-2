package fr.springBoot.jpalibrary.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=100, nullable=false)
    private String title;

    private String description;

    @Column(columnDefinition = "Boolean Default true")
    private boolean available = true;

    public Book(){};

    public Book(String title){
        this.title = title;
    }

    public Book(String title, String description){
        this.title = title;
        this.description = description;
    }

    public Book(String title, String description, Boolean available){
        this.title = title;
        this.description = description;
        this.available = available;
    }

    public Book(String title, Boolean available){
        this.title = title;
        this.available = available;
    }

    public Long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public boolean getAvailable(){
        return this.available;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}