package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionPersonaVentaDto implements Serializable {

  private static final long serialVersionUID = 2095913202391554577L;

  private Long id;

  @NotNull
  private Long idTarea;

  private LocalDate fecha;

  @NotBlank
  private String cclIdCodOrigen;

  @NotBlank
  private String cclIdPerson;

  @NotNull
  private Double importeSinImpuestos;

  @NotNull
  private Double importeConImpuestos;

  private Long idTipoImporteVenta;

}
