package br.com.zupacademy.isadora.casadocodigo.livro;

import br.com.zupacademy.isadora.casadocodigo.autor.Autor;
import br.com.zupacademy.isadora.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.isadora.casadocodigo.categoria.Categoria;
import br.com.zupacademy.isadora.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.isadora.casadocodigo.validador.anotacao.ExistsId;
import br.com.zupacademy.isadora.casadocodigo.validador.anotacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull @Min(value = 20)
    private Double preco;
    @NotNull @Min(value = 100)
    private Integer numeroPaginas;
    @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @Future @NotNull @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataPublicacao;
    @NotNull @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long autorId;
    @NotNull @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long categoriaId;

    public Livro toModel(AutorRepository autorRepository, CategoriaRepository categoriaRepository){
        Autor autor = autorRepository.getById(autorId);
        Categoria categoria = categoriaRepository.getById(categoriaId);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn, this.dataPublicacao, autor, categoria);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() { return sumario; }

    public Double getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }
}
