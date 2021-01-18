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

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaFaseMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseRepositoryCustom;

@Service
@Validated
public class TareaFaseServiceImpl implements TareaFaseService {

    @Autowired
    private TareaFaseRepositoryCustom tareaFaseRepositoryCustom;

    @Autowired
    private TareaFaseMapper tareaFaseMapper;

    @Override
    public List<TareaFaseDto> save(
            @Valid @NotNull @NotEmpty final List<TareaFaseDto> tareaFase) {
        return this.tareaFaseMapper
            .tareaFaseToTareaFaseDto(
                    this.tareaFaseRepositoryCustom.save(this.tareaFaseMapper
                        .tareaFaseDtoToTareaFase(tareaFase)));
    }

}
