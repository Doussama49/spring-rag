package fr.efrei.springrag.dto;


import fr.efrei.springrag.domain.Document;

public class DocumentDTO {

    private final String title;

    private final String content;

    public DocumentDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
