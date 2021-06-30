package br.com.zupacademy.isadora.casadocodigo.localizacao.pais;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public void cadastraPais(@Valid @RequestBody PaisRequest paisRequest){
        Pais pais = paisRequest.toModel();
        paisRepository.save(pais);
    }
}
