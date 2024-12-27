package com.example.solicitacaoservicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.solicitacaoservicos.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
