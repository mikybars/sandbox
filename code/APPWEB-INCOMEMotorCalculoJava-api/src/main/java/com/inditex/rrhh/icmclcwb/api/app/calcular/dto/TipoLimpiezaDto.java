package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

/*
 * Copyright (c) 2021. Inditex
 */
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class TipoLimpiezaDto implements Serializable {

  private static final long serialVersionUID = -8639414587126123438L;

  private Integer id;

}
