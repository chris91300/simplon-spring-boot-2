package fr.springBoot.jpalibrary.repository;

import fr.springBoot.jpalibrary.model.Book;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBook extends JpaRepository<@NonNull Book,@NonNull  Long> {

    /*
        l'utilisation de @Query est possible mais pas sécurisé contre les injection SQL
        @Query("SELECT b FROM Book b WHERE b.title = ?1")

        JpaRepository est capable de générer tout seul les requêtes sql en fonction
        du nom de la méthode
    */
    public Book findByTitle(String title);
}
