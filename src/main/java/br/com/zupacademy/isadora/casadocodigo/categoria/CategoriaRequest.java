package br.com.zupacademy.isadora.casadocodigo.categoria;

import br.com.zupacademy.isadora.casadocodigo.validador.anotacao.NomeCategoriaUnico;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {
    @NotBlank @NomeCategoriaUnico
    private String nome;

    public Categoria toModel(){
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
