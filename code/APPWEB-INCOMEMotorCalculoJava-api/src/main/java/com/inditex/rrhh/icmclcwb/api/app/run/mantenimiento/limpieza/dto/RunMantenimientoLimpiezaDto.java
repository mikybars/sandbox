package com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.dto;

import java.io.Serializable;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RunMantenimientoLimpiezaDto implements Serializable {

  private static final long serialVersionUID = 7293424922072873504L;

  private Integer tareasProcesadas;

  private List<IdTareaDto> idTarea;

  private Integer tareasPendientes;

}
