package com.inditex.rrhh.icmclcwb.api.ventaintegra.dto;

/*
 * Copyright (c) 2022. Inditex
 */

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
@Builder
public class VentaIntegraRequestDto implements Serializable {

  @NonNull
  private Integer idOrigen;

  @NonNull
  private Integer idEmpresa;

  @NonNull
  private String fechaDesde;

  @NonNull
  private String fechaHasta;

  @NonNull
  private List<Integer> listaTiendas;

  private LocalDateTime fechaLimite;

}
