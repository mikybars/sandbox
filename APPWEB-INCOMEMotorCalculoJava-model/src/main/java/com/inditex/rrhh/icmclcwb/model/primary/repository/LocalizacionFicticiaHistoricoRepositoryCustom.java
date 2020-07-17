package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.LocalizacionFicticiaHistorico;

public interface LocalizacionFicticiaHistoricoRepositoryCustom {

    List<LocalizacionFicticiaHistorico> findLocalizacionFicticiaHistoricoByIdOrigenAndIdEmpresaAndFecha(
            final TareaDto tarea,
            final TareaAmbitoDto ambito);

}
