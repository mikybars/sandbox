package com.inditex.rrhh.icmclcwb.api.ventaintegra.exception;

/*
 * Copyright (c) 2022. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;

public class VentaIntegraIcmclcwbException extends IcmclcwbException {

  private static final long serialVersionUID = 2713608924411606103L;

  public VentaIntegraIcmclcwbException(String message) {
    super(message);
  }

  public VentaIntegraIcmclcwbException(String message, Throwable cause) {
    super(message, cause);
  }
}
