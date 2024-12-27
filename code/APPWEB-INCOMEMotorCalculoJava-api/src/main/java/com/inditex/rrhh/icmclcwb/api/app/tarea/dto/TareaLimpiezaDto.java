package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoLimpiezaDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaLimpiezaDto implements Serializable {

  private static final long serialVersionUID = -170294147407207684L;

  @NonNull
  private Long id;

  @NonNull
  private Long idTarea;

  @NonNull
  private EstadoLimpiezaDto estado;

  @NonNull
  private TipoLimpiezaDto tipo;

  private LocalDateTime fechaHoraCreacion;

  private LocalDateTime fechaHoraInicio;

  private LocalDateTime fechaHoraFin;

  private String nombreUsuario;

}
