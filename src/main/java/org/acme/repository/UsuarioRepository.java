package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.acme.entity.Usuario;

import java.util.List;

@ApplicationScoped
public class UsuarioRepository {

    @PersistenceContext
    EntityManager em;

    public List<Usuario> listAll() {
        return em.createQuery("FROM Usuario", Usuario.class).getResultList();
    }

    public Usuario findById(Long id) {
        return em.find(Usuario.class, id);
    }

    @Transactional
    public void insert(Usuario usuario) {
        em.persist(usuario);
    }

    @Transactional
    public Usuario update(Usuario usuario) {
        return em.merge(usuario);
    }

    @Transactional
    public void delete(Long id) {
        Usuario usuario = em.find(Usuario.class, id);
        if (usuario != null) {
            em.remove(usuario);
        }
    }
}
