package br.com.zupacademy.isadora.casadocodigo.autor;

import java.time.LocalDateTime;

public class AutorResponse {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime criadoEm = LocalDateTime.now();

    public AutorResponse(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.criadoEm = autor.getCriadoEm();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
}
