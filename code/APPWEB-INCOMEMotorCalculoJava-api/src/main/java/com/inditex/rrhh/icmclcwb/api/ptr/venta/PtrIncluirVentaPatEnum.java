package com.inditex.rrhh.icmclcwb.api.ptr.venta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PtrIncluirVentaPatEnum {

  TRUE(1), FALSE(0);

  private Integer value;

}
