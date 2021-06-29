package br.com.zupacademy.isadora.casadocodigo.validador.anotacao;

import br.com.zupacademy.isadora.casadocodigo.validador.NomeCategoriaUnicoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NomeCategoriaUnicoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NomeCategoriaUnico {
    String message() default "Nome de Categoria já cadastrada!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
