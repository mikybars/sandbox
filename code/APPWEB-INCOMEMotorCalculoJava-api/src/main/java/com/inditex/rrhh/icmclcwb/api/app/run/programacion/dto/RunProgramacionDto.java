package com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto;

import java.io.Serializable;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RunProgramacionDto implements Serializable {

  private static final long serialVersionUID = 8443425889094187729L;

  @NonNull
  private ProgramacionDto programacion;

  @NonNull
  @NotEmpty
  private List<RunProgramacionPeriodoDto> runProgramacionPeriodo;

}
