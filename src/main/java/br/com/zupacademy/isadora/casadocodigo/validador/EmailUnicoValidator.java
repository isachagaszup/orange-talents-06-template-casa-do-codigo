package br.com.zupacademy.isadora.casadocodigo.validador;

import br.com.zupacademy.isadora.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.isadora.casadocodigo.validador.anotacao.EmailUnico;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String> {

    private AutorRepository autorRepository;

    public EmailUnicoValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !autorRepository.existsByEmail(s);
    }
}
