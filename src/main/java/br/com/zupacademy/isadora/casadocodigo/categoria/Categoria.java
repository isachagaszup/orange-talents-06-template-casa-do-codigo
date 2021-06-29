package br.com.zupacademy.isadora.casadocodigo.categoria;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.context.annotation.DependsOn;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true, nullable = false)
    private String nome;

    //hibernate only
    @Deprecated
    public Categoria() {
    }

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }
}
