package br.com.zupacademy.isadora.casadocodigo.livro;

public class DetalhesDoLivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer numeroPaginas;
    private String isbn;
    private String nomeAutor;
    private String descricaoAutor;

    public DetalhesDoLivroResponse (Livro livro){
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.nomeAutor = livro.getAutor().getNome();
        this.descricaoAutor = livro.getAutor().getDescricao();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
}
