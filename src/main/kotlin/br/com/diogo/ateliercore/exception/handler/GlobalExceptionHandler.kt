package br.com.diogo.ateliercore.exception.handler

import br.com.diogo.ateliercore.exception.ClienteNaoEncontradoException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNaoEncontradoException::class)
    fun handleClienteNaoEncontrado(
        ex: ClienteNaoEncontradoException,
        request: HttpServletRequest
    ): ResponseEntity<ApiError> {
        val error = ApiError(
            status = HttpStatus.NOT_FOUND.value(),
            error = "Not Found",
            message = ex.message ?: "Cliente não encontrado",
            path = request.requestURI
        )

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error)
    }
}