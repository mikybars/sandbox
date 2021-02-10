/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.AccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.AccionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.AccionRepositoryCustom;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class AccionServiceImpl implements AccionService {

    @Autowired
    private AccionRepository accionRepository;

    @Autowired
    private AccionRepositoryCustom accionRepositoryCustom;

    @Autowired
    private AccionMapper accionMapper;

    @Override
    public AccionDto findAccionDtoById(@NotNull final Integer id) {
        return this.accionMapper.accionToAccionDto(this.accionRepository.findById(id).get());
    }

    @Override
    public Boolean findByIdAccionAndIdOrigenAndStdIdLegEnt(@NotNull @Positive final Integer idAccion,
            @NotBlank final String cclIdOrigen, @NotBlank final String stdIdLegEnt) {
        return this.accionRepositoryCustom.findByIdAccionAndIdOrigenAndStdIdLegEnt(idAccion, cclIdOrigen, stdIdLegEnt);
    }

}
