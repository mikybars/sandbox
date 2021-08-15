package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoAmbitoPersonaRepository;

@Service
@Validated
public class TrabajoAmbitoPersonaServiceImpl implements TrabajoAmbitoPersonaService {

    @Autowired
    private TrabajoAmbitoPersonaRepository trabajoAmbitoPersonaRepository;

    @Autowired
    private TrabajoAmbitoPersonaMapper trabajoAmbitoPersonaMapper;

    @Override
    public List<TrabajoAmbitoPersonaDto> create(
            @Valid @NotNull @NotEmpty final List<TrabajoAmbitoPersonaDto> trabajoAmbitoPersona,
            @NotNull final TrabajoDto trabajo) {
        return this.trabajoAmbitoPersonaMapper.trabajoAmbitoPersonaToTrabajoAmbitoPersonaDto(
                this.trabajoAmbitoPersonaRepository
                    .saveAll(this.trabajoAmbitoPersonaMapper
                        .mergeTrabajoAmbitoPersonaDtoAndTrabajoDtoToTrabajoAmbitoPersona(
                                trabajoAmbitoPersona, trabajo)));
    }

    @Override
    public List<TrabajoAmbitoPersonaDto> findByTrabajo(@Valid @NotNull final TrabajoDto trabajo) {
        return this.trabajoAmbitoPersonaMapper.trabajoAmbitoPersonaToTrabajoAmbitoPersonaDto(
                this.trabajoAmbitoPersonaRepository.findByTrabajoId(trabajo.getId()));
    }

}
