package com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto;

import java.io.Serializable;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
@Builder
@AllArgsConstructor
public class RunTareaPrevalidarDto implements Serializable {

  @NonNull
  private List<TareaFaseAccionDto> tareaFaseAccion;

}
