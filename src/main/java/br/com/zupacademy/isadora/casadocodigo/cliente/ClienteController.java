package br.com.zupacademy.isadora.casadocodigo.cliente;

import br.com.zupacademy.isadora.casadocodigo.localizacao.estado.EstadoRepository;
import br.com.zupacademy.isadora.casadocodigo.localizacao.pais.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;

    public ClienteController(ClienteRepository clienteRepository, PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.clienteRepository = clienteRepository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastraCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.toModel(paisRepository, estadoRepository);
        clienteRepository.save(cliente);

        ClienteResponse clienteResponse = new ClienteResponse(cliente);
        return ResponseEntity.ok(clienteResponse);
    }
}
