package br.com.zupacademy.isadora.casadocodigo.localizacao.estado;

import br.com.zupacademy.isadora.casadocodigo.localizacao.pais.PaisRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private EstadoRepository estadoRepository;
    private PaisRepository paisRepository;

    public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public void cadastraEstado(@RequestBody @Valid EstadoRequest estadoRequest){
        Estado estado = estadoRequest.toModel(paisRepository);

        estadoRepository.save(estado);
    }
}
