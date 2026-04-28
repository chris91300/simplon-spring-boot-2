package fr.springBoot.jpalibrary.repository;

import fr.springBoot.jpalibrary.model.Book;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBook extends JpaRepository<@NonNull Book,@NonNull  Long> {

    /*@Query("SELECT b FROM Book b WHERE b.title = ?1")*/
    public Book findByTitle(String title);
}
