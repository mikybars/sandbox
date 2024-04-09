package com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto;

import java.io.Serializable;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RunTareaPrevalidarDto implements Serializable {

  @NotNull
  private List<TareaFaseAccionDto> tareaFaseAccion;

}
