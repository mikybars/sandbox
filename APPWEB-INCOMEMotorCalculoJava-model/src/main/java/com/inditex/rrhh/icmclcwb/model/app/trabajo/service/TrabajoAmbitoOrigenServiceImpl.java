package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoAmbitoOrigenRepository;

@Service
@Validated
public class TrabajoAmbitoOrigenServiceImpl implements TrabajoAmbitoOrigenService {

    @Autowired
    private TrabajoAmbitoOrigenRepository trabajoAmbitoOrigenRepository;

    @Autowired
    private TrabajoAmbitoOrigenMapper trabajoAmbitoOrigenMapper;

    @Override
    public List<TrabajoAmbitoOrigenDto> create(
            @Valid @NotNull @NotEmpty final List<TrabajoAmbitoOrigenDto> trabajoAmbitoOrigen,
            @NotNull final TrabajoDto trabajo) {
        return this.trabajoAmbitoOrigenMapper.trabajoAmbitoOrigenToTrabajoAmbitoOrigenDto(
                this.trabajoAmbitoOrigenRepository.saveAll(this.trabajoAmbitoOrigenMapper
                    .mergeTrabajoAmbitoOrigenDtoAndTrabajoDtoToTrabajoAmbitoOrigen(trabajoAmbitoOrigen, trabajo)));
    }

    @Override
    public List<TrabajoAmbitoOrigenDto> findByTrabajo(@Valid @NotNull final TrabajoDto trabajo) {
        return this.trabajoAmbitoOrigenMapper.trabajoAmbitoOrigenToTrabajoAmbitoOrigenDto(
                this.trabajoAmbitoOrigenRepository.findByTrabajoId(trabajo.getId()));
    }

}
