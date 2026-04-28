package fr.springBoot.jpalibrary.service;

import fr.springBoot.jpalibrary.model.Book;
import fr.springBoot.jpalibrary.repository.RepositoryBook;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class ServiceBook {
    @Autowired
    private RepositoryBook bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).get();
    }

    public Book create(Book book){
        return bookRepository.save(book);
    }


    //PUT /books/{id}
    public Book updateBookWithId(Long id, Book bookModified){
        Book currentBook = this.getBookById(id);

        if(Objects.nonNull(bookModified.getTitle())){
            currentBook.setTitle(bookModified.getTitle());
        }

        if(Objects.nonNull(bookModified.getDescription())){
            currentBook.setDescription(bookModified.getDescription());
        }

        currentBook.setAvailable(bookModified.getAvailable());

        return bookRepository.save(currentBook);
    }

    //DELETE /books/{id}
    public void delete(Long id){

        bookRepository.findById(id).ifPresentOrElse(
                bookRepository::delete,
                () -> {
                    throw new EntityNotFoundException("Livre non trouvé");
                }
        );
    }

    public Book findByTitle(String title){
        return bookRepository.findByTitle(title);
    }

}
