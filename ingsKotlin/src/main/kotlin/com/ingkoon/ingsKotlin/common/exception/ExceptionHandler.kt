package com.ingkoon.ingsKotlin.common.exception

import com.ingkoon.ingsKotlin.common.exception.attribute.ErrorResponseDto
import com.ingkoon.ingsKotlin.common.exception.common.PreconditionFailedException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(value = [PreconditionFailedException::class])
    fun handlingCustomException(ex: PreconditionFailedException): ResponseEntity<ErrorResponseDto> {
        val errorCode: HttpStatus  = HttpStatus.PRECONDITION_FAILED
        val errorDto = ErrorResponseDto(errorCode.toString() ,ex.message)
        return ResponseEntity(errorDto, errorCode)
    }
}