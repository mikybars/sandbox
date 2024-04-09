package com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RunProgramacionPeriodoDto implements Serializable {

  private static final long serialVersionUID = 8443425889094187729L;

  @NotNull
  private ProgramacionAmbitoDto programacionAmbito;

  @NotNull
  private PeriodoDto periodo;

  private TrabajoDto trabajo;

}
