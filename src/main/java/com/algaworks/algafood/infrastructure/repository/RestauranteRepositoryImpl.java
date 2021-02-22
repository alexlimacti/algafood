package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
        var jpql = "from Restaurante where nome like :home" +
                " and taxaFreteFrete between :taxaFreteInicial and :taxaFinal";
        return entityManager.createQuery(jpql, Restaurante.class)
                .setParameter("taxaFreteInicial", taxaFreteInicial)
                .setParameter("taxaFreteFinal", taxaFreteFinal)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }
}
