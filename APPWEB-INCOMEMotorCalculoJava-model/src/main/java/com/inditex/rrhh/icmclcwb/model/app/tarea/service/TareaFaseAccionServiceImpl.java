/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaFaseAccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseAccionRepositoryCustom;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class TareaFaseAccionServiceImpl implements TareaFaseAccionService {

    @Autowired
    private TareaFaseAccionRepositoryCustom tareaFaseAccionRepositoryCustom;

    @Autowired
    private TareaFaseAccionMapper tareaFaseAccionMapper;

    @Override
    public List<TareaFaseAccionDto> save(
            @Valid @NotNull @NotEmpty final List<TareaFaseAccionDto> tareaFaseAccion) {
        return this.tareaFaseAccionMapper
            .tareaFaseAccionToTareaFaseAccionDto(
                    this.tareaFaseAccionRepositoryCustom.save(this.tareaFaseAccionMapper
                        .tareaFaseAccionDtoToTareaFaseAccion(tareaFaseAccion)));
    }

}
