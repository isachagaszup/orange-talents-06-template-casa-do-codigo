package br.com.zupacademy.isadora.casadocodigo.autor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<AutorResponse> cadastraAutor(@Valid @RequestBody AutorRequest autorRequest) {
        Autor autor = autorRequest.toModel();
        autorRepository.save(autor);

        AutorResponse autorResponse = new AutorResponse(autor);
        return ResponseEntity.ok(autorResponse);
    }
}
