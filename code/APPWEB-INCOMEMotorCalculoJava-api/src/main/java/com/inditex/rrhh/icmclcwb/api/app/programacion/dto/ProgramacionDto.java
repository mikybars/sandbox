package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoAmbitoDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramacionDto implements Serializable {

  private static final long serialVersionUID = 3665361916795418905L;

  private Long id;

  @NotNull
  private LocalTime horaProgramacion;

  private String programacionHuso;

  @NotNull
  private Boolean activo;

  private String nombreUsuario;

  private LocalDateTime fechaHoraCreacion;

  private LocalDateTime fechaHoraUltimaEjecucion;

  private LocalDateTime fechaHoraSiguienteEjecucion;

  @NotNull
  private TipoAmbitoDto tipoAmbito;

  @NotNull
  @NotEmpty
  private List<ProgramacionAmbitoDto> ambito;

}
