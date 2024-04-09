package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoAmbitoDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TrabajoDto implements Serializable {

  private static final long serialVersionUID = 6263836371385557891L;

  private Long id;

  private Long idProgramacion;

  private EstadoTrabajoDto estado;

  private String nombreUsuario;

  private LocalDateTime fechaHoraCreacion;

  @NotNull
  private Long icmIdPeriodo;

  private LocalDate fechaInicioPeriodo;

  private LocalDate fechaFinPeriodo;

  private LocalDate fechaHoraInicioTrabajo;

  private LocalDate fechaHoraFinTrabajo;

  @NotBlank
  private String idOrganization;

  @NotNull
  private TipoAmbitoDto tipoAmbito;

  private List<TrabajoAmbitoOrigenDto> origen;

  private List<TrabajoAmbitoEmpresaDto> empresa;

  private List<TrabajoAmbitoPersonaDto> persona;

  private List<TrabajoAmbitoLocalizacionDto> localizacion;

}
