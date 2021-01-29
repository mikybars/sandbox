/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseAccionDto;

/**
 * @author mdelrio
 *
 */
public interface FaseAccionRepositoryCustom {

    /**
     * @param idFase
     * @return
     */
    List<FaseAccionDto> findByIdFase(@NotNull @Positive Integer idFase);

}
