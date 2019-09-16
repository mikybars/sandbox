package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import com.inditex.aqsw.framework.service.aaa.classic.serviciossso.UserSSO;
import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoValidator;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.ms.app.trabajo.SenderTrabajo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
    public TrabajoDto create(@Valid @TrabajoValidator final TrabajoDto trabajo) {
        trabajo.setFechaHoraCreacion(TimeUtils.nowLocalDateTime());
        if (StringUtils.isBlank(trabajo.getNombreUsuario())) {
            UserSSO userSSO = SsoUtils.getUserSSO();
            if (StringUtils.isNotBlank(userSSO.getUser())) {
                trabajo.setNombreUsuario(userSSO.getUser());
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
        //TODO[JESTEVEZ] Está fallando el servicio, por lo que se desactiva de momento
        //meta4IcmWsCalcIncomeSessionService.saveProceso(trabajoMapper.trabajoDtoToSaveProcesoDto(trabajo));
        // Envío del trabajo a la cola
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
