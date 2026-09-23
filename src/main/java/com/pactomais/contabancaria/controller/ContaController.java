package com.pactomais.contabancaria.controller;

import com.pactomais.contabancaria.model.Conta;
import com.pactomais.contabancaria.service.ContaService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService service;

    public ContaController(ContaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Conta> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Conta buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Conta criar(@RequestBody Conta conta) {
        return service.salvar(conta);
    }

    @PostMapping("/{id}/depositos")
    public Conta depositar(@PathVariable Long id, @RequestParam BigDecimal valor) {
        return service.depositar(id, valor);
    }

    @PostMapping("/{id}/saques")
    public Conta sacar(@PathVariable Long id, @RequestParam BigDecimal valor) {
        return service.sacar(id, valor);
    }
}
