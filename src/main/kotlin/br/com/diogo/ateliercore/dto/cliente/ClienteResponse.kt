package br.com.diogo.ateliercore.dto.cliente

data class ClienteResponse(
    val id: Long,
    val nome: String,
    val telefone: String,
    val observacoes: String? = ""
)
