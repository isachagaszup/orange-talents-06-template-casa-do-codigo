package br.com.zupacademy.isadora.casadocodigo.cliente;

public class ClienteResponse {

    private Long id;

    public ClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }
}
