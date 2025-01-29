package fr.efrei.springrag.service;

import fr.efrei.springrag.domain.Document;
import fr.efrei.springrag.dto.DocumentDTO;
import fr.efrei.springrag.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    // Récupérer tous les documents en tant que DTO
    public List<DocumentDTO> getAllDocuments() {
        List<Document> documents = documentRepository.findAll();
        return documents.stream()
                .map(DocumentDTO::fromEntity) // Convertir chaque entité en DTO
                .collect(Collectors.toList());
    }

    // Récupérer un document par son ID en tant que DTO
    public Optional<DocumentDTO> getDocumentById(Long id) {
        Optional<Document> document = documentRepository.findById(id);
        return document.map(DocumentDTO::fromEntity); // Convertir l'entité en DTO
    }

    // Créer un nouveau document à partir d'un DTO
    public DocumentDTO saveDocument(DocumentDTO documentDTO) {
        Document document = documentDTO.toEntity(); // Convertir le DTO en entité
        Document savedDocument = documentRepository.save(document);
        return DocumentDTO.fromEntity(savedDocument); // Convertir l'entité sauvegardée en DTO
    }

    // Mettre à jour un document à partir d'un DTO
    public DocumentDTO updateDocument(Long id, DocumentDTO documentDTO) {
        Optional<Document> existingDocument = documentRepository.findById(id);
        if (existingDocument.isPresent()) {
            Document document = existingDocument.get();
            document.setTitle(documentDTO.getTitle()); // Mettre à jour les propriétés de l'entité
            Document updatedDocument = documentRepository.save(document);
            return DocumentDTO.fromEntity(updatedDocument); // Convertir l'entité mise à jour en DTO
        } else {
            throw new RuntimeException("Document not found");
        }
    }

    // Supprimer un document par son ID
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}
