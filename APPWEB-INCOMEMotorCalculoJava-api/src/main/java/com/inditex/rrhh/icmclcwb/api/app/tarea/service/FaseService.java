/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;

/**
 * @author mdelrio
 *
 */
public interface FaseService {

    /**
     * @return
     */
    List<FaseDto> findAll();

}
