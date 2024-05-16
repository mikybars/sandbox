package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaseAccionDto implements Serializable {

  private Integer idFase;

  private Integer idAccion;

  private Integer idPuntoEjecucion;

  private Integer peso;

}
