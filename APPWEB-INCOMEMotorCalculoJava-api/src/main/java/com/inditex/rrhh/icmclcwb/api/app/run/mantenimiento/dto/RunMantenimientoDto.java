package com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.dto.RunMantenimientoLimpiezaDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RunMantenimientoDto implements Serializable {

  private static final long serialVersionUID = 7293424922072873504L;

  private RunMantenimientoLimpiezaDto runMantenimientoLimpieza;

}
