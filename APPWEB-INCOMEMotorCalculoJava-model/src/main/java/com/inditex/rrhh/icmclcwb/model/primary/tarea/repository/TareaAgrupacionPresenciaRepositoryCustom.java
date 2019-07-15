package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionPresencia;

import java.util.List;

public interface TareaAgrupacionPresenciaRepositoryCustom {

    void updateActivo(TareaDto tarea);

    void calcularPresenciasTotalesAgrupacion(TareaDto tarea);

}
