/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

/**
 * @author mdelrio
 *
 */
public interface PrimaryTemporaryTableRepositoryCustom {

    /**
     * @return
     */
    int createTempComisHistorico();

    /**
     * @return
     */
    int deleteTempComisHistorico();

    /**
     * @param listado
     */
    void insertTempComisHistorico(List<IdPersonaLocalCondicionesDto> listado);

    /**
     * @return
     */
    int createTempComisDesplazamiento();

    /**
     * @return
     */
    int deleteTempComisDesplazamiento();

    /**
     * @param listado
     */
    void insertTempComisDesplazamiento(List<IdPersonaLocalCondicionesDto> listado);

    /**
     * @return
     */
    int createTempComisResalta();

    /**
     * @return
     */
    int deleteTempComisResalta();

    /**
     * @param listado
     */
    void insertTempComisResalta(List<IdPersonaLocalCondicionesDto> listado);

    /**
     * @return
     */
    int createTempComisBajaIt();

    /**
     * @return
     */
    int deleteTempComisBajaIt();

    /**
     * @param listado
     */
    void insertTempComisBajaIt(List<IdPersonaLocalCondicionesDto> listado);

    /**
     * @return
     */
    int createTempComisCarencia();

    /**
     * @return
     */
    int deleteTempComisCarencia();

    /**
     * @param listado
     */
    void insertTempComisCarencia(List<IdPersonaLocalCarenciaDto> listado);

    /**
     * @return
     */
    int createTempMotivoDesplazamientoComis();

    /**
     * @return
     */
    int deleteTempMotivoDesplazamientoComis();

    /**
     * @param listado
     */
    void insertTempMotivoDesplazamientoComis(List<IdMotivoDesplazamientoDto> listado);

    /**
     * @return
     */
    int deleteTempMotivoDesplazamientoMeta4();

    /**
     * @return
     */
    int createTempMotivoDesplazamientoMeta4();

    /**
     * @param listado
     */
    void insertTempMotivoDesplazamientoMeta4(List<IdMotivoDesplazamientoDto> listado);

    /**
     * @return
     */
    List<IdMotivoDesplazamientoDto> validateTempMotivoDesplazamiento();

    /**
     * @return
     */
    List<IdPersonaLocalDto> validateTempComisBajaIt(@NotNull TareaDto tarea);

    /**
     * @return
     */
    List<IdPersonaLocalDto> validateTempComisCarencia(@NotNull TareaDto tarea);

    /**
     * @param tarea
     * @return
     */
    List<IdPersonaLocalDto> validateTempComisHistorico(TareaDto tarea);

    /**
     * @param tarea
     * @return
     */
    List<IdPersonaLocalDto> validateTempComisDesplazamiento(TareaDto tarea);

    /**
     * @param tarea
     * @return
     */
    List<IdPersonaLocalDto> validateTempComisResalta(TareaDto tarea);

}
