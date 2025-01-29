package fr.efrei.springrag.web.rest;

import fr.efrei.springrag.service.AssistantAiService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AssistantResource {
    private final AssistantAiService assistantAiService;

    public AssistantResource(AssistantAiService assistantAiService) {
        this.assistantAiService = assistantAiService;
    }

    @PostMapping("/assistants/chat")
    public String hello(@RequestBody String query){
        return assistantAiService.chat(query);
    }
}
