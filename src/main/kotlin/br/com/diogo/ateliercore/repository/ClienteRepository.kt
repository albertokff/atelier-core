package br.com.diogo.ateliercore.repository

import br.com.diogo.ateliercore.domain.Cliente
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository : JpaRepository<Cliente, Long>