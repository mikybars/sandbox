package com.inditex.rrhh.icmclcwb.api.ptr.venta;

import java.io.Serializable;

import lombok.Data;

@Data
public class MccType implements Serializable {

  private static final long serialVersionUID = -3680210925154606054L;

  private String model;

  private String quality;

  private String colour;

}
