package com.inditex.rrhh.icmclcwb.api.app.exception;

public class IcmclcwbException extends RuntimeException {

  private static final long serialVersionUID = 2713608924411606103L;

  public IcmclcwbException(final String message) {
    super(message);
  }

  public IcmclcwbException(final String message, final Throwable cause) {
    super(message, cause);
  }

}
