package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdLocalizacionLocalPresupuestoDto implements Serializable {

  private static final long serialVersionUID = 9216418821010267785L;

  private String id;

  @NotNull
  private Integer idTipoPresupuesto;

  @NotNull
  private LocalDate fechaInicio;

  @NotNull
  private LocalDate fechaFin;

}
