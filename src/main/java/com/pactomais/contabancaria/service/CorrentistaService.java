package com.pactomais.contabancaria.service;

import com.pactomais.contabancaria.model.Correntista;
import com.pactomais.contabancaria.repository.CorrentistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorrentistaService {

    private final CorrentistaRepository repository;

    public CorrentistaService(CorrentistaRepository repository) {
        this.repository = repository;
    }

    public List<Correntista> listarTodos() {
        return repository.findAll();
    }

    public Correntista buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Correntista salvar(Correntista correntista) {
        return repository.save(correntista);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}