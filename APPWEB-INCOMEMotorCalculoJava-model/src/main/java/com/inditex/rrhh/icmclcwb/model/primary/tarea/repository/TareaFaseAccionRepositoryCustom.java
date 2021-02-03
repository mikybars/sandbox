/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccion;

/**
 * @author mdelrio
 *
 */
public interface TareaFaseAccionRepositoryCustom {

    /**
     * @param src
     * @return
     */
    List<TareaFaseAccion> save(List<TareaFaseAccion> src);


    /**
     * @param idTarea
     * @param idFase
     * @param idPuntoEjecucion
     * @param peso
     * @return
     */
    List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucionAndPeso(
            @NotNull @Positive Long idTarea, @NotBlank Integer idFase, @NotNull Integer idPuntoEjecucion,
            @NotNull Long peso);

    /**
     * @param idTarea
     * @param idFase
     * @param idPuntoEjecucion
     * @return
     */
    List<Long> findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(@NotNull @Positive Long idTarea,
            @NotBlank Integer idFase, @NotNull Integer idPuntoEjecucion);

}
