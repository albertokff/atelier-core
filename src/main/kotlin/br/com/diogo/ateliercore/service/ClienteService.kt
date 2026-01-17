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

    fun buscarPorId(id: Long): Cliente {
        return clienteRepository.findById(id)
            .orElseThrow { RuntimeException("Cliente não encontrado") }
    }

    fun atualizar(id: Long, clienteAtualizado: Cliente): Cliente {
        val cliente = buscarPorId(id)

        val clienteNovo = cliente.copy(
            nome = clienteAtualizado.nome,
            telefone = clienteAtualizado.telefone,
            observacoes = clienteAtualizado.observacoes
        )

        return clienteRepository.save(clienteNovo)
    }

    fun deletar(id: Long) {
        buscarPorId(id)
        clienteRepository.deleteById(id)
    }
}