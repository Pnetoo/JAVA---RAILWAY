package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.Usuario;
import org.acme.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository repository;

    public List<Usuario> listarTodos() {
        return repository.listAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return Optional.ofNullable(repository.findById(id));
    }

    public void criarUsuario(Usuario usuario) {
        repository.insert(usuario);
    }

    public boolean atualizarUsuario(Long id, Usuario novoUsuario) {
        return buscarPorId(id).map(existente -> {
            existente.setNome(novoUsuario.getNome());
            existente.setEmail(novoUsuario.getEmail());
            existente.setSenha(novoUsuario.getSenha());
            repository.update(existente);
            return true;
        }).orElse(false);
    }

    public boolean deletarUsuario(Long id) {
        return buscarPorId(id).map(usuario -> {
            repository.delete(id);
            return true;
        }).orElse(false);
    }
}
