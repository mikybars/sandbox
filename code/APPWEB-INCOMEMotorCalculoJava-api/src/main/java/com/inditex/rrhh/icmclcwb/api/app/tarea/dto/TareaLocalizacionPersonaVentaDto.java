package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TareaLocalizacionPersonaVentaDto implements Serializable {

  private static final long serialVersionUID = 2095913202391554577L;

  private Long id;

  @NonNull
  private Long idTarea;

  private LocalDate fecha;

  @NotBlank
  private String cclIdCodOrigen;

  @NotBlank
  private String cclIdPerson;

  @NonNull
  private Double importeSinImpuestos;

  @NonNull
  private Double importeConImpuestos;

  private Long idTipoImporteVenta;

}
