/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFase;

/**
 * @author mdelrio
 *
 */
public interface TareaFaseRepositoryCustom {

    /**
     * @param src
     * @return
     */
    List<TareaFase> save(List<TareaFase> src);

}
