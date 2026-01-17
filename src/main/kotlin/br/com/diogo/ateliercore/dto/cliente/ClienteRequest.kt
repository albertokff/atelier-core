package br.com.diogo.ateliercore.dto.cliente

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class ClienteRequest(

    @field:NotBlank(message = "Nome é obrigatório")
    val nome: String,

    @field:NotBlank(message = "Telefone é obrigatório")
    val telefone: String
)
