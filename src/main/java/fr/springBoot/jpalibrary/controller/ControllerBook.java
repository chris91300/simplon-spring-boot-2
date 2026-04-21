package fr.springBoot.jpalibrary.controller;

import fr.springBoot.jpalibrary.model.Book;
import fr.springBoot.jpalibrary.service.ServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.util.JSONPObject;

@RestController
@RequestMapping("books")
public class ControllerBook {
    @Autowired
    private ServiceBook bookService;

    //GET /books
    @GetMapping()
    public Iterable<Book> getBooks(){
        return bookService.findAll();
    }

    //GET /books/{id}
    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") Long id){
        return bookService.getBookById(id);
    }

    //POST /books
    @PostMapping()
    public Book create(@RequestBody Book book){
        return bookService.create(book);
    }
    //PUT /books/{id}
    @PutMapping("/{id}")
    public Book update(@PathVariable("id") Long id, @RequestBody Book book){
        return bookService.updateBookWithId(id, book);
    }

    //DELETE /books/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        bookService.delete(id);
    }
}
