package com.inditex.rrhh.icmclcwb.api.ptr.exception;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;

public class PtrIcmclcwbException extends IcmclcwbException {

  private static final long serialVersionUID = 827035738919100848L;

  public PtrIcmclcwbException(String message) {
    super(message);
  }

  public PtrIcmclcwbException(String message, Throwable cause) {
    super(message, cause);
  }

}
