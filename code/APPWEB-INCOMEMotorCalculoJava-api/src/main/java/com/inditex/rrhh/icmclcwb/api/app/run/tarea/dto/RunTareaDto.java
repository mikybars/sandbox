package com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RunTareaDto implements Serializable {

  private static final long serialVersionUID = -2999803240189313755L;

  @NonNull
  private TrabajoDTO trabajo;

  @NonNull
  private TareaDto tarea;

}
