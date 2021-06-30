package br.com.zupacademy.isadora.casadocodigo.localizacao.pais;

import br.com.zupacademy.isadora.casadocodigo.validador.anotacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public Pais toModel() {
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
