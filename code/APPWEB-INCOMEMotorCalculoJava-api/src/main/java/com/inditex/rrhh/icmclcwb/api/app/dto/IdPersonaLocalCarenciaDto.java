package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class IdPersonaLocalCarenciaDto implements Serializable {

  @NotBlank
  private String idPersonaLocal;

  @NotNull
  private LocalDate fechaInicioCalculo;

  @NotNull
  private LocalDate fechaAlta;

  private String cclIdCodOrigen;

}
