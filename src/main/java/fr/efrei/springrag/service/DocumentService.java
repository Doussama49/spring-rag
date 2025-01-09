package fr.efrei.springrag.service;

import fr.efrei.springrag.domain.Document;
import fr.efrei.springrag.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document buildAndSaveDocument(Document document) {
        return documentRepository.save(document);
    }

    public List<Document> findAll(){
        return documentRepository.findAll();
    }

    public List<Document> deleteById(){
        return documentRepository.deleteById();
    }


    public Optional<Document> findById(Long id){
        return documentRepository.findById(id);
    }
}