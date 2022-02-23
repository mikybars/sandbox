package com.inditex.rrhh.icmclcwb.api.ptr.venta;

/*
 * Copyright (c) 2022. Inditex
 */
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PtrExcluirIpodEnum {

  TRUE(1), FALSE(0);

  private Integer value;

}
