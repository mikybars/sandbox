package com.inditex.rrhh.icmclcwb.api.ventaintegra.dto;

/*
 * Copyright (c) 2022. Inditex
 */
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VentaIntegraRequestDto implements Serializable {

  @ApiModelProperty(value = "Id del pais", required = true)
  @NotNull
  private Integer idOrigen;

  @ApiModelProperty(value = "Id de la empresa", required = true)
  @NotNull
  private Integer idEmpresa;

  @ApiModelProperty(value = "Fecha que indica el inicio del intervalo", required = true, example = "2022-04-03")
  @NotNull
  private String fechaDesde;

  @ApiModelProperty(value = "Fecha que indica el final del intervalo", required = true, example = "2022-04-03")
  @NotNull
  private String fechaHasta;

  @ApiModelProperty(value = "Lista de tiendas", required = true)
  @NotNull
  private List<Integer> listaTiendas;

  @ApiModelProperty(value = "Fecha/Hora límite de final de intervalo", required = false)
  private LocalDateTime fechaLimite;

}
