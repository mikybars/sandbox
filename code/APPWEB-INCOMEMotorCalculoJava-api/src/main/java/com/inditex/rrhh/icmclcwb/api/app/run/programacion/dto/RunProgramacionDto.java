package com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto;

import java.io.Serializable;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RunProgramacionDto implements Serializable {

  private static final long serialVersionUID = 8443425889094187729L;

  @NotNull
  private ProgramacionDto programacion;

  @NotNull
  @NotEmpty
  private List<RunProgramacionPeriodoDto> runProgramacionPeriodo;

}
