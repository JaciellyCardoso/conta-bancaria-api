package com.pactomais.contabancaria.controller;

import com.pactomais.contabancaria.model.Correntista;
import com.pactomais.contabancaria.service.CorrentistaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    private final CorrentistaService service;

    public CorrentistaController(CorrentistaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Correntista> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Correntista buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Correntista criar(@RequestBody Correntista correntista) {
        return service.salvar(correntista);
    }

    @PutMapping("/{id}")
    public Correntista atualizar(@PathVariable Long id, @RequestBody Correntista correntista) {
        correntista.setId(id);
        return service.salvar(correntista);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}