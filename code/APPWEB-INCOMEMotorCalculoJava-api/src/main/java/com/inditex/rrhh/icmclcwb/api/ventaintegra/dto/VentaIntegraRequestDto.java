package com.inditex.rrhh.icmclcwb.api.ventaintegra.dto;

/*
 * Copyright (c) 2022. Inditex
 */

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VentaIntegraRequestDto implements Serializable {

  @NotNull
  private Integer idOrigen;

  @NotNull
  private Integer idEmpresa;

  @NotNull
  private String fechaDesde;

  @NotNull
  private String fechaHasta;

  @NotNull
  private List<Integer> listaTiendas;

  private LocalDateTime fechaLimite;

}
