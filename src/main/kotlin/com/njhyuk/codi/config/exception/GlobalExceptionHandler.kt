package com.njhyuk.codi.config.exception

import com.njhyuk.codi.inboud.web.WebResponse
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

private val log = KotlinLogging.logger {}

@RestControllerAdvice
class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequest(e: BusinessException): WebResponse<Any> {
        log.info("badRequestException : {}", e.message)
        return WebResponse.error(e.errorCode)
    }
}
