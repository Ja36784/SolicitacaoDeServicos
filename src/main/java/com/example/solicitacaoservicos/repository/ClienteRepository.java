package com.example.solicitacaoservicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.solicitacaoservicos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> { 

}
