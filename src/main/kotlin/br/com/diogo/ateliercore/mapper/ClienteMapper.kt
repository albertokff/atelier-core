package br.com.diogo.ateliercore.mapper

import br.com.diogo.ateliercore.domain.Cliente
import br.com.diogo.ateliercore.dto.cliente.ClienteResponse

fun Cliente.toResponse(): ClienteResponse {
    return ClienteResponse(
        id = this.id,
        nome = this.nome,
        telefone = this.telefone,
    )
}