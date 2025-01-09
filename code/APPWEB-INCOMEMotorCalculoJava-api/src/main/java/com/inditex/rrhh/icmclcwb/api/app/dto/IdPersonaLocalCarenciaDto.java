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
public class IdPersonaLocalCarenciaDto implements Serializable {

  @NotBlank
  private String idPersonaLocal;

  @NonNull
  private LocalDate fechaInicioCalculo;

  @NonNull
  private LocalDate fechaAlta;

  private String cclIdCodOrigen;

}
