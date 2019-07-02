package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.service.aaa.classic.serviciossso.UserSSO;
import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.ms.app.trabajo.SenderTrabajo;

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
    
    @Autowired
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Autowired
    private SenderTrabajo senderTrabajo;

    @Override
    public TrabajoDto find(@NotNull @Positive final Long id) {
        TrabajoDto trabajo = trabajoMapper.trabajoToTrabajoDto(trabajoRepository.findById(id).get());
        trabajo.setOrigen(trabajoAmbitoOrigenService.findByTrabajo(trabajo));
        trabajo.setEmpresa(trabajoAmbitoEmpresaService.findByTrabajo(trabajo));
        trabajo.setLocalizacion(trabajoAmbitoLocalizacionService.findByTrabajo(trabajo));
        trabajo.setPersona(trabajoAmbitoPersonaService.findByTrabajo(trabajo));
        return trabajo;
    }

    @Transactional
    @Override
    public TrabajoDto create(@Valid final TrabajoDto trabajo) {
        trabajo.setFechaCreacion(TimeUtils.nowLocalDateTime());
        if (StringUtils.isBlank(trabajo.getIdUsuario())) {
            UserSSO userSSO = SsoUtils.getUserSSO();
            if (StringUtils.isNotBlank(userSSO.getUser())) {
                trabajo.setIdUsuario(userSSO.getUser());
            }
        }
        TrabajoDto result = trabajoMapper
                .trabajoToTrabajoDto(trabajoRepository.save(trabajoMapper.trabajoDtoToTrabajo(trabajo)));
        if (CollectionUtils.isNotEmpty(trabajo.getOrigen())) {
            OrigenRequestDto request = new OrigenRequestDto();
            request.setData(new GenericFilterDto());
            request.setPage(new PageDto());
            request.getData().setFechaInicio(trabajo.getFechaInicioPeriodo());
            request.getData().setFechaFin(trabajo.getFechaFinPeriodo());
            request.getData().setItem(new ArrayList<>());
            request.getData().getItem().add(GenericFilterParametersDto.builder().idSociedadReg(trabajo.getIdSociedad()).build());
            List<OrigenResultItemDto> origen = meta4IcmWsCalcIncomeSessionService.getOrigen(request);
            List<TrabajoAmbitoOrigenDto> trabajoAmbitoOrigen = origen.stream().map(e-> TrabajoAmbitoOrigenDto.builder().idOrigen(e.getIdOrigen()).idTrabajo(trabajo.getId()).build()).collect(Collectors.toList());
            result.setOrigen(trabajoAmbitoOrigenService.create(trabajoAmbitoOrigen, result));
        }
        if (CollectionUtils.isNotEmpty(trabajo.getEmpresa())) {
            EmpresaRequestDto request = new EmpresaRequestDto();
            request.setData(new GenericFilterDto());
            request.setPage(new PageDto());
            request.getData().setFechaInicio(trabajo.getFechaInicioPeriodo());
            request.getData().setFechaFin(trabajo.getFechaFinPeriodo());
            request.getData().setItem(new ArrayList<>());
            trabajo.getOrigen().stream().forEach(e -> request.getData().getItem().add(GenericFilterParametersDto.builder().idOrigenReg(e.getIdOrigen()).build()));
            List<EmpresaResultItemDto> origen = meta4IcmWsCalcIncomeSessionService.getEmpresa(request);
            List<TrabajoAmbitoEmpresaDto> trabajoAmbitoEmpresa = origen.stream().map(e-> TrabajoAmbitoEmpresaDto.builder().idEmpresa(e.getIdEmpresa()).idTrabajo(trabajo.getId()).build()).collect(Collectors.toList());
            result.setEmpresa(trabajoAmbitoEmpresaService.create(trabajoAmbitoEmpresa, result));
        }
        if (CollectionUtils.isNotEmpty(trabajo.getLocalizacion())) {
            result.setLocalizacion(trabajoAmbitoLocalizacionService.create(trabajo.getLocalizacion(), result));
        }
        if (CollectionUtils.isNotEmpty(trabajo.getPersona())) {
            result.setPersona(trabajoAmbitoPersonaService.create(trabajo.getPersona(), result));
        }
        senderTrabajo.send(result);
        return result;
    }

    @Override
    public TrabajoDto merge(@Valid @NotNull final ProgramacionDto programacion,
            @Valid @NotNull final ProgramacionAmbitoDto programacionAmbito, @Valid @NotNull final PeriodoDto periodo) {
        return trabajoMapper.mergeProgramacionAmbitoDtoAndProgramacionDtoAndPeriodoDtoToTrabajoDto(programacionAmbito,
                programacion, periodo);
    }

}