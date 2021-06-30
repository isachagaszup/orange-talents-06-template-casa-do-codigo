package br.com.zupacademy.isadora.casadocodigo.validador;

import br.com.zupacademy.isadora.casadocodigo.localizacao.estado.EstadoRequest;
import br.com.zupacademy.isadora.casadocodigo.validador.anotacao.EstadoUnico;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class EstadoUnicoValidator implements ConstraintValidator<EstadoUnico, Object> {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select 1 from Estado e join e.pais p where e.nome =:nomeEstado and p.id =:paisId");

        EstadoRequest estadoRequest = (EstadoRequest) o;
        query.setParameter("nomeEstado", estadoRequest.getNome());
        query.setParameter("paisId", estadoRequest.getPaisId());

        Optional<?> result = query.getResultList().stream().findFirst();

        return result.isEmpty();
    }
}
