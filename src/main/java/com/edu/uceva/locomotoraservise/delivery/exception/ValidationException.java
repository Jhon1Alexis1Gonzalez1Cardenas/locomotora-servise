package com.edu.uceva.locomotoraservise.delivery.exception;

import org.springframework.validation.BindingResult;

public class ValidationException extends RuntimeException {
  private final BindingResult result;

  public ValidationException(BindingResult result) {
    super("Error de validacion: " );
    this.result = result;
  }
}
