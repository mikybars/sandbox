package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoAmbitoEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class TrabajoAmbitoEmpresaServiceImpl implements TrabajoAmbitoEmpresaService {

    @Autowired
    private TrabajoAmbitoEmpresaRepository trabajoAmbitoEmpresaRepository;

    @Autowired
    private TrabajoAmbitoEmpresaMapper trabajoAmbitoEmpresaMapper;

    @Transactional
    @Override
    public List<TrabajoAmbitoEmpresaDto> create(
            @Valid @NotNull @NotEmpty final List<TrabajoAmbitoEmpresaDto> trabajoAmbitoEmpresa,
            @NotNull final TrabajoDto trabajo) {
        return trabajoAmbitoEmpresaMapper.trabajoAmbitoEmpresaToTrabajoAmbitoEmpresaDto(trabajoAmbitoEmpresaRepository
                .saveAll(trabajoAmbitoEmpresaMapper.mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTrabajoAmbitoEmpresa(
                        trabajoAmbitoEmpresa, trabajo)));
    }

    @Override
    public List<TrabajoAmbitoEmpresaDto> findByTrabajo(@Valid @NotNull final TrabajoDto trabajo) {
        return trabajoAmbitoEmpresaMapper.trabajoAmbitoEmpresaToTrabajoAmbitoEmpresaDto(
                trabajoAmbitoEmpresaRepository.findByTrabajoId(trabajo.getId()));
    }

}
