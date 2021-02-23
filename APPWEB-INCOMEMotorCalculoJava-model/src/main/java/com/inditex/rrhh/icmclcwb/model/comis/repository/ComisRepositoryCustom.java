package com.inditex.rrhh.icmclcwb.model.comis.repository;

import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface ComisRepositoryCustom {

    /**
     * @param tarea
     * @return
     */
    PresenciaOrigenDto findPresenciasOrigenAndFecha(TareaDto tarea);

    /**
     * @param tarea
     * @return
     */
    List<IdMotivoDesplazamientoDto> findMotivoDesplazamiento(TareaDto tarea);

    /**
     * @param fechaDesde
     * @return
     */
    List<IdPersonaLocalFechaIncidenciaDto> findFechasIncidencias(LocalDate fechaDesde);

    /**
     * @param fechaDesde
     * @return
     */
    List<IdPersonaLocalFechaIncidenciaDto> findFechasDesplazamientos(LocalDate fechaDesde);

    /**
     * @param tarea
     * @return
     */
    List<IdPersonaLocalCondicionesDto> findCondicionesHistorico(TareaDto tarea);

    /**
     * @param tarea
     * @return
     */
    List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamiento(TareaDto tarea);

    /**
     * @param tarea
     * @return
     */
    List<IdPersonaLocalCondicionesDto> findCondicionesResalta(TareaDto tarea);

    /**
     * @param tarea
     * @return
     */
    List<IdPersonaLocalCondicionesDto> findBajasIt(TareaDto tarea);

    /**
     * @param tarea
     * @return
     */
    List<IdPersonaLocalCarenciaDto> findCarencia(TareaDto tarea);

}
