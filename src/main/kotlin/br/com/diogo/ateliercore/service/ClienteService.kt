package br.com.diogo.ateliercore.service

import br.com.diogo.ateliercore.domain.Cliente
import br.com.diogo.ateliercore.dto.cliente.ClienteRequest
import br.com.diogo.ateliercore.dto.cliente.ClienteResponse
import br.com.diogo.ateliercore.mapper.toResponse
import br.com.diogo.ateliercore.repository.ClienteRepository
import org.springframework.stereotype.Service

@Service
class ClienteService(
    private val clienteRepository: ClienteRepository
) {
    fun criar(request: ClienteRequest): ClienteResponse {
        val cliente = Cliente(
            nome = request.nome,
            telefone = request.telefone,
            email = request.email,
        )

        val salvo = clienteRepository.save(cliente)

        return salvo.toResponse()
    }

    fun listar(): List<ClienteResponse> =
        clienteRepository.findAll().map { it.toResponse() }

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