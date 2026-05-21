package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;

public interface TareaCalculoPresenciasMismaFechaDistintaTiendaService {

    List<IdPersonaLocalDto> findPersonaPresenciasMismaFechaDistintaTienda(Long idTarea);

}
