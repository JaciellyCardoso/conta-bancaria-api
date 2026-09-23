package com.pactomais.contabancaria.controller;

import com.pactomais.contabancaria.model.Transacao;
import com.pactomais.contabancaria.service.TransacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @GetMapping("/{contaId}/transacoes")
    public List<Transacao> listarPorConta(@PathVariable Long contaId) {
        return service.listarPorConta(contaId);
    }
}