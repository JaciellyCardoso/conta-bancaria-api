package com.pactomais.contabancaria.repository;

import com.pactomais.contabancaria.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista, Long> {
}
