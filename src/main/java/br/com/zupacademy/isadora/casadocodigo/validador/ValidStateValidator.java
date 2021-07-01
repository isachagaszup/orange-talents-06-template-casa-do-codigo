package br.com.zupacademy.isadora.casadocodigo.validador;

import br.com.zupacademy.isadora.casadocodigo.validador.anotacao.ValidState;
import org.springframework.beans.BeanWrapperImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

/**
 * Validador customizado criado para verificar o campo estado.
 * 1. Se estado não for nulo, verifica se o estado pertence a pais.
 * 2. Se estado for nulo, verifica se pais tem estados cadastrados.
 */

public class ValidStateValidator implements ConstraintValidator<ValidState, Object> {


    @PersistenceContext
    private EntityManager entityManager;

    private String field;
    private String joinField;

    @Override
    public void initialize(ValidState param) {
        this.field = param.field();
        this.joinField = param.joinField();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = new BeanWrapperImpl(o)
                .getPropertyValue(field);
        Object fieldJoinValue = new BeanWrapperImpl(o)
                .getPropertyValue(joinField);


        if (fieldJoinValue != null){ //estado com id, verifica se estado pertence a pais
            Query query = entityManager.createQuery("select 1 from Estado e join e.pais p where p.id =:value and e.id =:value2");
            query.setParameter("value", fieldValue);
            query.setParameter("value2", fieldJoinValue);
            Optional<?> resultList = query.getResultList().stream().findFirst();

            boolean isValid = resultList.isPresent();

            if (!isValid) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate("Id inválido!")
                        .addPropertyNode("estadoId")
                        .addConstraintViolation();
            }

            return resultList.isPresent();
        } else { //estado null verifica se pais tem estados cadastrados.
            Query query = entityManager.createQuery("select 1 from Estado e join e.pais p where p.id =:value");
            query.setParameter("value", fieldValue);
            Optional<?> resultList = query.getResultList().stream().findFirst();

            return resultList.isEmpty();
        }

    }
}


