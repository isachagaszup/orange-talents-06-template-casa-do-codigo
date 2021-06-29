package br.com.zupacademy.isadora.casadocodigo.livro;

import br.com.zupacademy.isadora.casadocodigo.autor.Autor;
import br.com.zupacademy.isadora.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) @NotBlank
    private String titulo;
    @Column(nullable = false) @NotBlank @Size(max = 500)
    private String resumo;
    @Column(nullable = false) @NotNull @Min(value = 20)
    private Double preco;
    @Column(nullable = false) @NotNull @Min(value = 100)
    private Integer numeroPaginas;
    @Column(nullable = false) @NotBlank
    private String isbn;
    @Future
    private LocalDate dataPublicacao;
    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Categoria categoria;

    //hibernate only
    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotNull @Min(value = 20) Double preco, @NotNull @Min(value = 100) Integer numeroPaginas, @NotBlank String isbn, @Future LocalDate dataPublicacao, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }
}
