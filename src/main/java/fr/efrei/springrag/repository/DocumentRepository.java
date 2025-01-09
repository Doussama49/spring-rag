package fr.efrei.springrag.repository;

import fr.efrei.springrag.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    Document save(Document document);

    Optional<Document> findById(Long id);

    List<Document> deleteById();

    List<Document> id(Long id);
}
