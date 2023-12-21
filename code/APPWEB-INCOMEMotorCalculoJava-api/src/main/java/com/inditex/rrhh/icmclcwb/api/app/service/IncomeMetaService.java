package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;

import javax.validation.constraints.NotNull;

public interface IncomeMetaService {

  List<IdPersonaLocalExternaDto> getEmpleadosExternosExcluidosDenominador(@NotNull ReglaEmpleadoExternoMeta4RequestDto request);

}
