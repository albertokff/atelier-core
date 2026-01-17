package br.com.diogo.ateliercore.controller

import br.com.diogo.ateliercore.domain.Cliente
import br.com.diogo.ateliercore.dto.cliente.ClienteRequest
import br.com.diogo.ateliercore.dto.cliente.ClienteResponse
import br.com.diogo.ateliercore.service.ClienteService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/clientes")
class ClienteController(
    private val clienteService: ClienteService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@Valid @RequestBody request: ClienteRequest) =
        clienteService.criar(request)

    @GetMapping
    fun listar() = clienteService.listar()

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Cliente {
        return clienteService.buscarPorId(id)
    }

    @PutMapping("/{id}")
    fun atualizar(
        @PathVariable id: Long,
        @Valid @RequestBody cliente: Cliente
    ): Cliente {
        return clienteService.atualizar(id, cliente)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        return clienteService.deletar(id)
    }
}