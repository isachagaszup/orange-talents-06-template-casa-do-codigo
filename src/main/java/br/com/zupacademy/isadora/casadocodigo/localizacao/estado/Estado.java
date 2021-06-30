package br.com.zupacademy.isadora.casadocodigo.localizacao.estado;

import br.com.zupacademy.isadora.casadocodigo.localizacao.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @NotBlank
    private String nome;
    @ManyToOne
    private Pais pais;

    /**
     * hibernate only
     */
    @Deprecated
    public Estado() {
    }

    public Estado(@NotBlank String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }
}
