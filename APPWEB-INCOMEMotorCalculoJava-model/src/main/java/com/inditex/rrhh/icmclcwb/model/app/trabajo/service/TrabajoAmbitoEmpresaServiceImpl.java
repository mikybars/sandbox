package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoAmbitoEmpresaRepository;

@Service
@Validated
public class TrabajoAmbitoEmpresaServiceImpl implements TrabajoAmbitoEmpresaService {

    @Autowired
    private TrabajoAmbitoEmpresaRepository trabajoAmbitoEmpresaRepository;

    @Autowired
    private TrabajoAmbitoEmpresaMapper trabajoAmbitoEmpresaMapper;

    // @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<TrabajoAmbitoEmpresaDto> create(
            @Valid @NotNull @NotEmpty final List<TrabajoAmbitoEmpresaDto> trabajoAmbitoEmpresa,
            @NotNull final TrabajoDto trabajo) {
        return this.trabajoAmbitoEmpresaMapper.trabajoAmbitoEmpresaToTrabajoAmbitoEmpresaDto(
                this.trabajoAmbitoEmpresaRepository
                    .saveAll(this.trabajoAmbitoEmpresaMapper
                        .mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTrabajoAmbitoEmpresa(
                                trabajoAmbitoEmpresa, trabajo)));
    }

    @Override
    public List<TrabajoAmbitoEmpresaDto> findByTrabajo(@Valid @NotNull final TrabajoDto trabajo) {
        return this.trabajoAmbitoEmpresaMapper.trabajoAmbitoEmpresaToTrabajoAmbitoEmpresaDto(
                this.trabajoAmbitoEmpresaRepository.findByTrabajoId(trabajo.getId()));
    }

}
