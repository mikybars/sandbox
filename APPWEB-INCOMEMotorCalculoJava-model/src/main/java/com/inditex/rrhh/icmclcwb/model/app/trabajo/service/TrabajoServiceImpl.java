package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import com.inditex.aqsw.framework.service.aaa.classic.serviciossso.UserSSO;
import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepository;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class TrabajoServiceImpl implements TrabajoService {

    @Autowired
    private TrabajoRepository trabajoRepository;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoAmbitoOrigenService trabajoAmbitoOrigenService;

    @Autowired
    private TrabajoAmbitoEmpresaService trabajoAmbitoEmpresaService;

    @Autowired
    private TrabajoAmbitoLocalizacionService trabajoAmbitoLocalizacionService;

    @Autowired
    private TrabajoAmbitoPersonaService trabajoAmbitoPersonaService;

    @Override
    public TrabajoDto create(@Valid final TrabajoDto trabajo) {
        trabajo.setFechaCreacion(LocalDateTime.now());
        if (StringUtils.isBlank(trabajo.getIdUsuario())) {
            UserSSO userSSO = SsoUtils.getUserSSO();
            if (StringUtils.isNotBlank(userSSO.getUsername())) {
                trabajo.setIdUsuario(userSSO.getUsername());
            }
        }
        TrabajoDto result = trabajoMapper
                .trabajoToTrabajoDto(trabajoRepository.save(trabajoMapper.trabajoDtoToTrabajo(trabajo)));
        if (CollectionUtils.isNotEmpty(trabajo.getOrigen())) {
            result.setOrigen(trabajoAmbitoOrigenService.create(trabajo.getOrigen(), result));
        }
        if (CollectionUtils.isNotEmpty(trabajo.getEmpresa())) {
            result.setEmpresa(trabajoAmbitoEmpresaService.create(trabajo.getEmpresa(), result));
        }
        if (CollectionUtils.isNotEmpty(trabajo.getLocalizacion())) {
            result.setLocalizacion(trabajoAmbitoLocalizacionService.create(trabajo.getLocalizacion(), result));
        }
        if (CollectionUtils.isNotEmpty(trabajo.getPersona())) {
            result.setPersona(trabajoAmbitoPersonaService.create(trabajo.getPersona(), result));
        }
        return result;
    }

    @Override
    public List<TrabajoDto> create(@Valid @NotNull final ProgramacionDto programacion,
            @Valid @NotNull final PeriodoDto periodo) {
        List<TrabajoDto> result = new ArrayList<>();
        trabajoMapper.mergeProgramacionAmbitoDtoAndProgramacionDtoAndPeriodoDtoToTrabajoDto(programacion.getAmbito(),
                programacion, periodo).forEach(item -> result.add(create(item)));
        return result;
    }

}