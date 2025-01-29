package fr.efrei.springrag.dto;


import fr.efrei.springrag.domain.Document;

public class DocumentDTO {

    private Long id;
    private String title;

    // Constructeurs
    public DocumentDTO() {
    }

    public DocumentDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Méthode pour convertir l'entité en DTO
    public static DocumentDTO fromEntity(Document document) {
        return new DocumentDTO(document.getId(), document.getTitle());
    }

    // Méthode pour convertir le DTO en entité
    public Document toEntity() {
        Document document = new Document();
        document.setId(this.id);
        document.setTitle(this.title);
        return document;
    }
}
