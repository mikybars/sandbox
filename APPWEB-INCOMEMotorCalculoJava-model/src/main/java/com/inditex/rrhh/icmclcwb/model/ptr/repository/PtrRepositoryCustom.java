package com.inditex.rrhh.icmclcwb.model.ptr.repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface PtrRepositoryCustom {

    /**
     * @param tarea
     * @param ambito
     * @return
     */
    PresenciaOrigenDto findPresenciasOrigenAndFecha(TareaDto tarea, TareaAmbitoDto ambito);

}
