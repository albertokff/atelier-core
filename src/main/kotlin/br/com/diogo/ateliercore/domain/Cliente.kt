package br.com.diogo.ateliercore.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "clientes")
data class Cliente(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @field:NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    val nome: String,

    @field:NotBlank(message = "Telefone é obrigatório")
    @Column(nullable = false)
    val telefone: String,

    @Column
    val observacoes: String? = null
)
