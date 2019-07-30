package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaAgrupacionPresenciaRepositoryCustom {

    void updateActivo(TareaDto tarea);

    void calcularPresenciasTotalesAgrupacion(TareaDto tarea);

}
