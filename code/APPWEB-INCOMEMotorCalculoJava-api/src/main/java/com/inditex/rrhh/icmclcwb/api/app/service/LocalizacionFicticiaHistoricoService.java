package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.LocalizacionFicticiaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface LocalizacionFicticiaHistoricoService {

  List<LocalizacionFicticiaHistoricoDto> findLocalizacionFicticiaHistoricoByIdOrigenAndIdEmpresaAndFecha(
      final TareaDto tarea,
      final TareaAmbitoDto ambito);

}
