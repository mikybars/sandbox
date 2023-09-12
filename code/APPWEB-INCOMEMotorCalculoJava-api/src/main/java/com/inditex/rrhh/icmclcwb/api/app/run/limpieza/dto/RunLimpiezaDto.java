package com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RunLimpiezaDto implements Serializable {

  private static final long serialVersionUID = 7293424922072873504L;

  private Long id;

  private TareaDto tarea;

}
