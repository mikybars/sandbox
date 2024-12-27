package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class IdPersonaLocalCondicionesDto implements Serializable {

  private static final long serialVersionUID = -4235085358661235034L;

  @NotBlank
  private String idPersonaLocal;

  @NonNull
  private LocalDate fechaDesde;

  @NonNull
  private LocalDate fechaHasta;

  private String cclIdCodOrigen;

  private String cclIdSeccion;

  private String cclIdCodOrigenDestino;

  private String cclIdSeccionDestino;

  private String idTipoCalculo;

  private String idTipoOpcionCalculo;

  private Boolean esIncluirTotalCondiciones;

  private String porcentaje;

  private String banda;

  private String importe;

  private String puesto;

  private String secciones;

}
