package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccionDto implements Serializable {

  private Integer id;

  private String nombre;

  private String descripcion;

  private Integer peso;

  private Boolean esReaccionEsperar;

  private Boolean esReaccionReintento;

  private Integer reintentoMax;

  private Integer reintentoDelay;

}
