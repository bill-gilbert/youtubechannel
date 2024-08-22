package com.example.ss_2022_c3_e1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity<Void> handleNotFoundException(RuntimeException ex) {
    log.error(ex.toString());
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  }
}
