package fr.springBoot.jpalibrary.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    /*
        si je veux passer par une table de jointure
    @JoinTable( name="category_book",
                joinColumns = @JoinColumn(name="book_id"),
                inverseJoinColumns = @JoinColumn(name="category_id")
    )*/
    /*@JoinColumn(name="category_id")*/
    private Category category;

    @ManyToMany
    @JoinTable( name="author_book",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id")
    )
    private List<Author> authors = new ArrayList<>();

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

    public Category getCategory() {
        return category;
    }

    public List<Author> getAuthors() {
        return authors;
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

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}