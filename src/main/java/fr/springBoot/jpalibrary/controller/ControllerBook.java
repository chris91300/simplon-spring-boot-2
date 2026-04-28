package fr.springBoot.jpalibrary.controller;

import fr.springBoot.jpalibrary.model.Book;
import fr.springBoot.jpalibrary.service.ServiceBook;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<@NonNull Object> getBook(@PathVariable("id") Long id){
        try{
            Book book = bookService.getBookById(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livre non trouvé.");
        }

    }

    //POST /books
    @PostMapping()
    public ResponseEntity<@NonNull Book> create(@RequestBody Book book){
        Book bookCreated = bookService.create(book);
        return new ResponseEntity<@NonNull Book>(bookCreated, HttpStatus.CREATED);
    }

    //PUT /books/{id}
    @PutMapping("/{id}")
    public ResponseEntity<@NonNull Object> update(@PathVariable("id") Long id, @RequestBody Book book){
        try{
            Book bookUpdated = bookService.updateBookWithId(id, book);
            return new ResponseEntity<>(bookUpdated, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livre non trouvé.");
        }

    }

    //DELETE /books/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<@NonNull Object> delete(@PathVariable("id") Long id){
        try{
            bookService.delete(id);
            return ResponseEntity.ok().body("livre supprimé");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livre non trouvé");
        }

    }

    // GET /books/title/{title}
    @GetMapping("/title/{title}")
    public ResponseEntity<@NonNull Object> findByTitle(@PathVariable("title") String title){
        try{
            Book book = bookService.findByTitle(title);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livre non trouvé.");
        }

    }
}
