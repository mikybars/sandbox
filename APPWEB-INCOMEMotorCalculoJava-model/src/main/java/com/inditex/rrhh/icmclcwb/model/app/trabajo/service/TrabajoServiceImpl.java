package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import com.inditex.aqsw.framework.service.aaa.classic.serviciossso.UserSSO;
import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoValidator;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.ms.app.trabajo.SenderTrabajo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
    private SenderTrabajo senderTrabajo;
    
    @Autowired
    @Qualifier("meta4Properties")
    private Map<String, Meta4PropertiesDto> meta4Properties;
    
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
    public TrabajoDto create(@Valid @TrabajoValidator final TrabajoDto trabajo){
        trabajo.setFechaHoraCreacion(TimeUtils.nowLocalDateTime());
        trabajo.setEstado(EstadoTrabajoEnum.PENDIENTE.getDto());
        if (StringUtils.isBlank(trabajo.getNombreUsuario())) {
            UserSSO userSSO = SsoUtils.getUserSSO();
            if (StringUtils.isNotBlank(userSSO.getUser())) {
                trabajo.setNombreUsuario(userSSO.getUser());
            }
        }
        
        PeriodosRequestDto request = new PeriodosRequestDto();
        request.setData(new GenericFilterDto());
        request.getData().setItem(new ArrayList<GenericFilterParametersDto>());
        request.setPage(meta4Properties.get(Meta4PropertiesConstants.PERIODOS).getPage());
        request.getData().getItem()
                .add(GenericFilterParametersDto.builder().idSociedadReg(trabajo.getIdOrganization())
                        .abierto(Meta4Constants.TRUE)
                        .vigente(Meta4Constants.TRUE).idPeriodo(trabajo.getIcmIdPeriodo().toString()).build());
        
        List<PeriodoDto> periodos = periodoMapper
                .periodoResultItemDtoToPeriodoDto(meta4IcmWsCalcIncomeSessionService.getPeriodos(request));
        if (CollectionUtils.isNotEmpty(periodos)) {
            trabajo.setFechaInicioPeriodo(periodos.get(0).getFechaInicioPeriodo());
            trabajo.setFechaFinPeriodo(periodos.get(0).getFechaFinPeriodo());
        } else {
            //TODO [JAVIEREV] Solo para pruebas por venta... ¡BORRAR ESTE CODIGO!
            trabajo.setFechaInicioPeriodo(LocalDate.of(2019, 12, 1));
            trabajo.setFechaFinPeriodo(LocalDate.of(2019, 12, 31));
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
        // Guardado del trabajo en Meta4
        meta4IcmWsCalcIncomeSessionService.saveProceso(trabajoMapper.trabajoDtoToSaveProcesoDto(result));
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

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateFechaFin(@NotNull TrabajoDto trabajo) {
        trabajoRepositoryCustom.updateFechaFin(trabajo);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateEstado(@NotNull TrabajoDto trabajo, @NotNull EstadoTrabajoDto estado) {
        trabajo.setEstado(estado);
        trabajoRepositoryCustom.updateEstado(trabajo, estado);
    }
}
