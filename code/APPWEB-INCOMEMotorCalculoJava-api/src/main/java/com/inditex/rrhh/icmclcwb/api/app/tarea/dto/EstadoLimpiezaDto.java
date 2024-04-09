package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

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
public class EstadoLimpiezaDto implements Serializable {

  private static final long serialVersionUID = 5812871987442400781L;

  private Integer id;

}
