package fr.efrei.springrag.web.rest;

import fr.efrei.springrag.dto.DocumentDTO;
import fr.efrei.springrag.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documents")
public class DocumentResource {

    private final DocumentService documentService;

    @Autowired
    public DocumentResource(DocumentService documentService) {
        this.documentService = documentService;
    }

    // Récupérer tous les documents
    @GetMapping
    public List<DocumentDTO> getAllDocuments() {
        return documentService.getAllDocuments(); // Service retourne des DTOs
    }

    // Récupérer un document par son ID
    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> getDocumentById(@PathVariable Long id) {
        Optional<DocumentDTO> document = documentService.getDocumentById(id); // Le service retourne un DTO
        return document.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Créer un nouveau document
    @PostMapping
    public DocumentDTO createDocument(@RequestBody DocumentDTO documentDTO) {
        return documentService.saveDocument(documentDTO); // Passer le DTO au service
    }

    // Mettre à jour un document
    @PutMapping("/{id}")
    public ResponseEntity<DocumentDTO> updateDocument(@PathVariable Long id, @RequestBody DocumentDTO documentDTO) {
        try {
            return ResponseEntity.ok(documentService.updateDocument(id, documentDTO)); // Passer le DTO au service
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un document
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }
}
