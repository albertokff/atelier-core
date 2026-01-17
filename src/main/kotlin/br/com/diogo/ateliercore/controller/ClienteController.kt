package br.com.diogo.ateliercore.controller

import br.com.diogo.ateliercore.domain.Cliente
import br.com.diogo.ateliercore.service.ClienteService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
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
    fun criar(@RequestBody cliente: Cliente): Cliente {
        return clienteService.criar(cliente)
    }

    @GetMapping
    fun listar(): List<Cliente> {
        return clienteService.listar()
    }
}