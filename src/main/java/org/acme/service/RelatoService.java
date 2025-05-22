package org.acme.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.Relato;
import org.acme.repository.RelatoRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RelatoService {

    @Inject
    RelatoRepository repository;

    public List<Relato> listarTodos() {
        return repository.listAll();
    }

    public Optional<Relato> buscarPorId(Long id) {
        return Optional.ofNullable(repository.findById(id));
    }

    public void criarRelato(Relato relato) {
        repository.insert(relato);
    }

    public boolean atualizarRelato(Long id, Relato novoRelato) {
        Relato existente = repository.findById(id);
        if (existente != null) {
            existente.setDescricao(novoRelato.getDescricao());
            existente.setTipoUrgencia(novoRelato.getTipoUrgencia());
            existente.setDataHora(novoRelato.getDataHora());
            existente.setIdUsuario(novoRelato.getIdUsuario());
            existente.setIdEstacao(novoRelato.getIdEstacao());
            existente.setIdProblemaComum(novoRelato.getIdProblemaComum());
            repository.update(existente);
            return true;
        }
        return false;
    }

    public boolean deletarRelato(Long id) {
        Relato existente = repository.findById(id);
        if (existente != null) {
            repository.delete(id);
            return true;
        }
        return false;
    }
}

