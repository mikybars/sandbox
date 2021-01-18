/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

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

}
