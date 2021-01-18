package com.inditex.rrhh.icmclcwb.model.meta4.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.MotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface Meta4RepositoryCustom {

    /**
     * @param tarea
     * @return
     */
    List<MotivoDesplazamientoDto> findMotivosDesplazamientoAux(TareaDto tarea);

    /**
     * @param tarea
     * @return
     */
    List<MotivoDesplazamientoDto> findMotivosDesplazamientoGlobal(TareaDto tarea);

}
