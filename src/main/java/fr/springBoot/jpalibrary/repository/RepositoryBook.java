package fr.springBoot.jpalibrary.repository;

import fr.springBoot.jpalibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBook extends JpaRepository<Book, Long> {
}
