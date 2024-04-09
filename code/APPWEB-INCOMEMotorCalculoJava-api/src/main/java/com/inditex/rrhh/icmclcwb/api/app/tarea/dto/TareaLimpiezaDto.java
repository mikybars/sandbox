package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoLimpiezaDto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLimpiezaDto implements Serializable {

  private static final long serialVersionUID = -170294147407207684L;

  @NotNull
  private Long id;

  @NotNull
  private Long idTarea;

  @NotNull
  private EstadoLimpiezaDto estado;

  @NotNull
  private TipoLimpiezaDto tipo;

  private LocalDateTime fechaHoraCreacion;

  private LocalDateTime fechaHoraInicio;

  private LocalDateTime fechaHoraFin;

  private String nombreUsuario;

}
