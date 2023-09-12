package com.inditex.rrhh.icmclcwb.api.app.exception;

/*
 * Copyright (c) 2022. Inditex
 */

public class ValidationException extends WarningException {

  public ValidationException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ValidationException(final String message) {
    super(message);
  }

}
