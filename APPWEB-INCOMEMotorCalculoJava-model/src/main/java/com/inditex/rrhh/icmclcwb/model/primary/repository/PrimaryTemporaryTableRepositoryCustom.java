/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.GenericAlgoritmoPropertiesDto;
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
     * @param tarea
     * @return
     */
    void mergeDateRangesTempComisHistorico(final TareaDto tarea);

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

    /**
     * @param tarea
     */
    void mergeDateRangesSeccionNotEqualsTempComisHistorico(TareaDto tarea);

    /**
     * @return
     */
    int deleteTempAlgoritmo();

    /**
     * @return
     */
    int createTempAlgoritmo();

    /**
     * @param algoritmoDto
     */
    void insertTempAlgoritmo(@NotNull List<GenericAlgoritmoPropertiesDto> algoritmoDto);

    /**
     * @return
     */
    int indexTempAlgoritmo();

    /**
     * @return
     */
    int deleteTempEstructura();

    /**
     * @return
     */
    int createTempEstructura();

    /**
     * @return
     */
    int indexTempEstructura();

    /**
     * @return
     */
    int deleteTempPersonas();

    /**
     * @return
     */
    int createTempPersonas();

    /**
     * @return
     */
    int indexTempPersonas();

    /**
     * @param algoritmoDto
     */
    void insertTempPersonas();

    /**
     * @return
     */
    int deleteTempPresupuestos();

    /**
     * @return
     */
    int createTempPresupuestos();

    /**
     * @return
     */
    int indexTempPresupuestos();

    /**
     * @param tareaDto
     */
    void insertTempPresupuestos(@NotNull TareaDto tareaDto);

    /**
     * @param tareaDto
     */
    void insertTempEstructura(@NotNull TareaDto tareaDto);

    /**
     * @param tareaDto
     */
    void insertTareaLocalizacionPresupuestoTareaPersonaEstructura(@NotNull TareaDto tareaDto);

    /**
     * @param tarea
     */
    void mergeDateRangesSeccionNotEqualsTempComisResalta(TareaDto tarea);

    /**
     * @param tarea
     */
    void mergeDateRangesTempComisResalta(TareaDto tarea);

    /**
     * @return
     */
    int createTempComisPrimas();

    /**
     * @return
     */
    int deleteTempComisPrimas();

    /**
     * @param listado
     */
    void insertTempComisPrimas(List<IdPersonaLocalCondicionesDto> listado);

    /**
     * @param tarea
     */
    void mergeDateRangesSeccionNotEqualsTempComisPrimas(TareaDto tarea);

    /**
     * @param tarea
     */
    void mergeDateRangesTempComisPrimas(TareaDto tarea);

    /**
     * @param tarea
     * @return lista de personas que no coinciden en COMIS e INCOME
     */
    List<IdPersonaLocalDto> validateTempComisPrimas(TareaDto tarea);

    /**
     * @return
     */
    int createTempCalculoPorComision();

    /**
     * @return
     */
    int deleteTempCalculoPorComision();

    /**
     * Totaliza los valores de TAREA_CALCULO del período por persona y tipo comisón.
     * @param tarea
     */
    void mergeCalculoTempCalculoPorComision(TareaDto tarea);

    /**
     * Totaliza los valores de TAREA_CALCULO del período por persona. El tipo de comisión lo deja a
     * nulo.
     * @param tarea
     */
    void mergeCalculoTempCalculoSinComision(TareaDto tarea);

    /**
     * @return
     */
    int createTempCalculoAjusteTotalizado();

    /**
     * @return
     */
    int deleteTempCalculoAjusteTotalizado();

    /**
     * @param tarea
     */
    void mergeCalculoTempCalculoAjusteTotalizado(TareaDto tarea);

}
