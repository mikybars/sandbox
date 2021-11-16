
package com.inditex.rrhh.icmclcwb.api.app.exception;

public class ValidationException extends IcmclcwbException {

  public ValidationException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ValidationException(final String message) {
    super(message);
  }

}
