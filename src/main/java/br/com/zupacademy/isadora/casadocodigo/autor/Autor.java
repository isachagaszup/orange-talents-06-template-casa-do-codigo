package br.com.zupacademy.isadora.casadocodigo.autor;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Column(unique = true)
    @NotBlank
    private String email;
    @NotBlank @Size(max = 400)
    private String descricao;
    @PastOrPresent
    @CreationTimestamp
    private LocalDateTime criadoEm = LocalDateTime.now();

//    hibernate only
    @Deprecated
    public Autor() {
    }

    public Autor(@NotBlank String nome, @NotBlank String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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
