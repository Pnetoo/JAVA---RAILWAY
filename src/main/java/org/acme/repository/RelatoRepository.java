package org.acme.repository;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.acme.entity.Relato;

import java.util.List;

@ApplicationScoped
public class RelatoRepository {

    @PersistenceContext
    EntityManager em;

    public List<Relato> listAll() {
        return em.createQuery("FROM Relato", Relato.class).getResultList();
    }

    public Relato findById(Long id) {
        return em.find(Relato.class, id);
    }

    @Transactional
    public void insert(Relato relato) {
        em.persist(relato);
    }

    @Transactional
    public Relato update(Relato relato) {
        return em.merge(relato);
    }

    @Transactional
    public void delete(Long id) {
        Relato relato = em.find(Relato.class, id);
        if (relato != null) {
            em.remove(relato);
        }
    }
}
