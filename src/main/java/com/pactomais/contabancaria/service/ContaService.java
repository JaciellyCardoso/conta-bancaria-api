package com.pactomais.contabancaria.service;

import com.pactomais.contabancaria.model.Conta;
import com.pactomais.contabancaria.model.ContaCorrente;
import com.pactomais.contabancaria.model.ContaPoupanca;
import com.pactomais.contabancaria.model.Transacao;
import com.pactomais.contabancaria.model.TipoTransacao;
import com.pactomais.contabancaria.repository.ContaRepository;
import com.pactomais.contabancaria.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final TransacaoRepository transacaoRepository;

    public ContaService(ContaRepository contaRepository,
                        TransacaoRepository transacaoRepository) {
        this.contaRepository = contaRepository;
        this.transacaoRepository = transacaoRepository;
    }

    public Conta salvar(Conta conta) {
        return contaRepository.save(conta);
    }

    public List<Conta> listarTodas() {
        return contaRepository.findAll();
    }

    public Conta buscarPorId(Long id) {
        return contaRepository.findById(id).orElse(null);
    }

    public Conta depositar(Long id, BigDecimal valor) {
        Conta conta = buscarPorId(id);

        if (conta == null) {
            throw new RuntimeException("Conta não encontrada.");
        }

        conta.setSaldo(conta.getSaldo().add(valor));
        contaRepository.save(conta);

        registrarTransacao(conta, valor, TipoTransacao.DEPOSITO);

        return conta;
    }

    public Conta sacar(Long id, BigDecimal valor) {
        Conta conta = buscarPorId(id);

        if (conta == null) {
            throw new RuntimeException("Conta não encontrada.");
        }

        BigDecimal limiteDisponivel = conta.getSaldo();

        if (conta instanceof ContaCorrente) {
            ContaCorrente corrente = (ContaCorrente) conta;
            limiteDisponivel = limiteDisponivel.add(corrente.getLimite());
        }

        if (valor.compareTo(limiteDisponivel) > 0) {
            throw new RuntimeException("Saldo insuficiente.");
        }

        conta.setSaldo(conta.getSaldo().subtract(valor));
        contaRepository.save(conta);

        registrarTransacao(conta, valor, TipoTransacao.SAQUE);

        return conta;
    }

    private void registrarTransacao(Conta conta, BigDecimal valor,
                                    TipoTransacao tipo) {
        Transacao transacao = new Transacao();
        transacao.setTipo(tipo);
        transacao.setValor(valor);
        transacao.setData(LocalDateTime.now());
        transacao.setContaOrigem(conta);

        transacaoRepository.save(transacao);
    }
}
