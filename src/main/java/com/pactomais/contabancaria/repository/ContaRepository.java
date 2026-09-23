package com.pactomais.contabancaria.repository;

import com.pactomais.contabancaria.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
