package br.com.zupacademy.isadora.casadocodigo.localizacao.pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @NotBlank
    private String nome;

    /**
     * hibernate only
     */
    @Deprecated
    public Pais() {
    }

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
