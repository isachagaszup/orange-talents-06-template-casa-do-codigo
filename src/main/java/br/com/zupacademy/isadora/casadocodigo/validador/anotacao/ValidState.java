package br.com.zupacademy.isadora.casadocodigo.validador.anotacao;

import br.com.zupacademy.isadora.casadocodigo.validador.ValidStateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidStateValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidState {
    String message() default "País exige estado!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String field();
    String joinField();
}
