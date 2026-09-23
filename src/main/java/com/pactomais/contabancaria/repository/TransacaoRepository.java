package com.pactomais.contabancaria.repository;

import com.pactomais.contabancaria.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {List<Transacao> findByContaOrigemIdOrderByDataDesc(Long contaId);
}
