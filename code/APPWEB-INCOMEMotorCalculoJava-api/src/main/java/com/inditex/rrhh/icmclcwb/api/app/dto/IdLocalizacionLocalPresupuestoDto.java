package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdLocalizacionLocalPresupuestoDto implements Serializable {

  private static final long serialVersionUID = 9216418821010267785L;

  private String id;

  @NonNull
  private Integer idTipoPresupuesto;

  @NonNull
  private LocalDate fechaInicio;

  @NonNull
  private LocalDate fechaFin;

}
