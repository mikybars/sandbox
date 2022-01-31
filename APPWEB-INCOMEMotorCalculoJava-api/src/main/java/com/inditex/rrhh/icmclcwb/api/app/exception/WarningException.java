package com.inditex.rrhh.icmclcwb.api.app.exception;

/*
 * Copyright (c) 2022. Inditex
 */

public class WarningException extends IcmclcwbException {

  public WarningException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public WarningException(final String message) {
    super(message);
  }

}
