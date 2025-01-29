package fr.efrei.springrag.web.rest;
import fr.efrei.springrag.dto.SampleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleResource {

    @GetMapping("/samples/{value}")
    public String hello(@PathVariable(value = "value") String value) {
        return "Hello " + value + "!";
    }
    // Endpoint pour retourner un DTO en JSON
    @GetMapping("/samples/dto/{value}")
    public ResponseEntity<SampleDTO> helloDto(@PathVariable(value = "value") String value) {
        SampleDTO sampleDTO = new SampleDTO("Hello " + value + "!");
        return ResponseEntity.ok(sampleDTO);
    }
}