package br.com.diogo.ateliercore.exception

class ClienteNaoEncontradoException(
    id: Long
) : RuntimeException("Cliente com id $id não encontrado")