package com.learning.spring.boot.jdbc.tennis_player.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class PlayerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> handlePlayerNotFound(PlayerNotFoundException exception, HttpServletRequest request)
    {
        PlayerErrorResponse errorResponse = new PlayerErrorResponse(ZonedDateTime.now(), HttpStatus.NOT_FOUND.value(),request.getRequestURI(),"Player not found");

        return new ResponseEntity<PlayerErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
