package com.agendamento.crm.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.agendamento.crm.model.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    Clientes findByCpf(String cpf);
    Optional<Clientes> findById(Long id);
}