package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoValidator;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.dto.PeriodoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.ms.app.trabajo.SenderTrabajo;
import org.apache.commons.lang3.StringUtils;

import com.inditex.aqsw.framework.service.aaa.userdetails.sso.model.UserSSO;
import com.inditex.aqsw.framework.service.aaa.userdetails.sso.util.SsoUtils;


@Service
@Validated
public class TrabajoServiceImpl implements TrabajoService {

    @Autowired
    private TrabajoRepository trabajoRepository;

    @Autowired
    private TrabajoRepositoryCustom trabajoRepositoryCustom;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private PeriodoMapper periodoMapper;

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
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

    @Autowired
    private SenderTrabajo senderTrabajo;

    @Autowired
    @Qualifier("meta4Properties")
    private Map<String, Meta4PropertiesDto> meta4Properties;

    @Override
    public TrabajoDto find(@NotNull @Positive final Long id) {
        final TrabajoDto trabajo = this.trabajoMapper.trabajoToTrabajoDto(this.trabajoRepository.findById(id).get());
        trabajo.setOrigen(this.trabajoAmbitoOrigenService.findByTrabajo(trabajo));
        trabajo.setEmpresa(this.trabajoAmbitoEmpresaService.findByTrabajo(trabajo));
        trabajo.setLocalizacion(this.trabajoAmbitoLocalizacionService.findByTrabajo(trabajo));
        trabajo.setPersona(this.trabajoAmbitoPersonaService.findByTrabajo(trabajo));
        return trabajo;
    }

    // @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public TrabajoDTO create(@Valid @TrabajoValidator final TrabajoDTO trabajo) {
        trabajo.setFechaHoraCreacion(TimeUtils.nowLocalDateTime().atOffset(ZoneOffset.UTC));
        trabajo.setEstado(EstadoTrabajoEnum.PENDIENTE.getDto());
        if (StringUtils.isBlank(trabajo.getNombreUsuario())) {
            final UserSSO userSSO = SsoUtils.getUserSSO();
            if (StringUtils.isNotBlank(userSSO.getUser())) {
                trabajo.setNombreUsuario(userSSO.getUser());
            }
        }

        final PeriodosRequestDto request = new PeriodosRequestDto();
        request.setData(new GenericFilterDto());
        request.getData().setItem(new ArrayList<GenericFilterParametersDto>());
        request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.PERIODOS).getPage());
        request.getData()
            .getItem()
            .add(GenericFilterParametersDto.builder()
                .idSociedadReg(trabajo.getIdOrganization())
                .abierto(Meta4Constants.TRUE)
                .vigente(Meta4Constants.TRUE)
                .idPeriodo(trabajo.getIcmIdPeriodo().toString())
                .build());

        final List<PeriodoDto> periodos = this.periodoMapper
            .periodoResultItemDtoToPeriodoDto(this.meta4IcmWsCalcIncomeSessionService.getPeriodos(request));
        if (CollectionUtils.isNotEmpty(periodos)) {
            trabajo.setFechaInicioPeriodo(periodos.get(0).getFechaInicioPeriodo());
            trabajo.setFechaFinPeriodo(periodos.get(0).getFechaFinPeriodo());
        }
        final TrabajoDto result = this.trabajoMapper
            .trabajoToTrabajoDto(this.trabajoRepository.save(this.trabajoMapper.trabajoDtoToTrabajo(trabajo)));
        if (CollectionUtils.isNotEmpty(trabajo.getOrigen())) {
            result.setOrigen(this.trabajoAmbitoOrigenService.create(trabajo.getOrigen(), result));
        }
        if (CollectionUtils.isNotEmpty(trabajo.getEmpresa())) {
            result.setEmpresa(this.trabajoAmbitoEmpresaService.create(trabajo.getEmpresa(), result));
        }
        if (CollectionUtils.isNotEmpty(trabajo.getLocalizacion())) {
            result.setLocalizacion(this.trabajoAmbitoLocalizacionService.create(trabajo.getLocalizacion(), result));
        }
        if (CollectionUtils.isNotEmpty(trabajo.getPersona())) {
            result.setPersona(this.trabajoAmbitoPersonaService.create(trabajo.getPersona(), result));
        }
        // Guardado del trabajo en Meta4
        this.meta4IcmWsCalcIncomeService.saveProceso(this.trabajoMapper.trabajoDtoToSaveProcesoDto(result));
        // Envío del trabajo a la cola
        this.senderTrabajo.send(result);
        return result;
    }

    @Override
    public TrabajoDto merge(@Valid @NotNull final ProgramacionDTO programacion,
            @Valid @NotNull final ProgramacionAmbitoDTO programacionAmbito, @Valid @NotNull final PeriodoDTO periodo) {
        return this.trabajoMapper.mergeProgramacionAmbitoDtoAndProgramacionDtoAndPeriodoDtoToTrabajoDto(
                programacionAmbito,
                programacion, periodo);
    }

    // @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateFechaFin(@NotNull final TrabajoDto trabajo) {
        this.trabajoRepositoryCustom.updateFechaFin(trabajo);
    }

    // @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateEstado(@NotNull final TrabajoDto trabajo, @NotNull final EstadoTrabajoDto estado) {
        trabajo.setEstado(estado);
        this.trabajoRepositoryCustom.updateEstado(trabajo, estado);
    }

}
