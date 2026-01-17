package br.com.diogo.ateliercore.service

import br.com.diogo.ateliercore.domain.Cliente
import br.com.diogo.ateliercore.repository.ClienteRepository
import org.springframework.stereotype.Service

@Service
class ClienteService(
    private val clienteRepository: ClienteRepository
) {
    fun criar(cliente: Cliente): Cliente {
        return clienteRepository.save(cliente)
    }

    fun listar(): List<Cliente> {
        return clienteRepository.findAll()
    }
}