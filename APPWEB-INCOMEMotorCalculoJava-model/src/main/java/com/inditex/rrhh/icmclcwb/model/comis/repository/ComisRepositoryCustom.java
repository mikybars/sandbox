package com.inditex.rrhh.icmclcwb.model.comis.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.ComisClaseEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
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
    List<IdPersonaLocalFechaIncidenciaDto> findFechasIncidencias(TareaDto tarea);

    /**
     * @param fechaDesde
     * @return
     */
    List<IdPersonaLocalFechaIncidenciaDto> findFechasDesplazamientos(TareaDto tarea);

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

    /**
     * @param tarea
     * @return
     */
    List<IdPersonaLocalExternaDto> findExternosByClase(TareaDto tarea, ComisClaseEmpleadoEnum clase);

    /**
     * Obtiene los empleados externos en base a los que tengan un id superior al dado.
     * @param tarea tarea
     * @param minIdPersona el id de persona que debe ser superado para ser considerado externo.
     * @return lista de externos
     */
    List<IdPersonaLocalExternaDto> findExternosByMinIdPersona(final TareaDto tarea, final Long minIdPersona);

}
