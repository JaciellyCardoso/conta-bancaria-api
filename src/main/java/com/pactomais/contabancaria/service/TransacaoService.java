package com.pactomais.contabancaria.service;

import com.pactomais.contabancaria.model.Transacao;
import com.pactomais.contabancaria.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public List<Transacao> listarPorConta(Long contaId) {
        return repository.findByContaOrigemIdOrderByDataDesc(contaId);
    }
}