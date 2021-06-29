package br.com.zupacademy.isadora.casadocodigo.validador;

import br.com.zupacademy.isadora.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.isadora.casadocodigo.validador.anotacao.NomeCategoriaUnico;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NomeCategoriaUnicoValidator implements ConstraintValidator<NomeCategoriaUnico, String> {

    private CategoriaRepository categoriaRepository;

    public NomeCategoriaUnicoValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !categoriaRepository.existsByNome(s);
    }
}
