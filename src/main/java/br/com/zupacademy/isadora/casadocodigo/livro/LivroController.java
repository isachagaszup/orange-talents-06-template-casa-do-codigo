package br.com.zupacademy.isadora.casadocodigo.livro;

import br.com.zupacademy.isadora.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.isadora.casadocodigo.categoria.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private AutorRepository autorRepository;
    private CategoriaRepository categoriaRepository;
    private LivroRepository livroRepository;

    public LivroController(AutorRepository autorRepository, CategoriaRepository categoriaRepository, LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public void cadastraLivro(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.toModel(autorRepository, categoriaRepository);
        livroRepository.save(livro);
    }

    @GetMapping
    public List<ListaLivrosResponse> lista(){
        List<Livro> livros = livroRepository.findAll();
        List<ListaLivrosResponse> listaLivrosResponse = new ArrayList<>();

        livros.forEach(livro -> listaLivrosResponse.add(new ListaLivrosResponse(livro)));

        return listaLivrosResponse;
    }
}
