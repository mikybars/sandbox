package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoAmbitoOrigenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
        return trabajoAmbitoOrigenMapper.trabajoAmbitoOrigenToTrabajoAmbitoOrigenDto(
                trabajoAmbitoOrigenRepository.saveAll(trabajoAmbitoOrigenMapper
                        .mergeTrabajoAmbitoOrigenDtoAndTrabajoDtoToTrabajoAmbitoOrigen(trabajoAmbitoOrigen, trabajo)));
    }

    @Override
    public List<TrabajoAmbitoOrigenDto> findByTrabajo(@Valid @NotNull final TrabajoDto trabajo) {
        return trabajoAmbitoOrigenMapper.trabajoAmbitoOrigenToTrabajoAmbitoOrigenDto(
                trabajoAmbitoOrigenRepository.findByTrabajoId(trabajo.getId()));
    }

}
