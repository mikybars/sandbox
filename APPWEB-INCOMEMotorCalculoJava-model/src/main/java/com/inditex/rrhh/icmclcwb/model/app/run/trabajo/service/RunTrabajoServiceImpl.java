package com.inditex.rrhh.icmclcwb.model.app.run.trabajo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoValidator;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;

@Service
@Validated
public class RunTrabajoServiceImpl implements RunTrabajoService {

    @Autowired
    private TareaService tareaService;
    
    @Autowired
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;
    
    @Auditoria
    @CounterMetric
    @TimerMetric 
    @Override
    public RunTrabajoDto run(@NotNull @Valid @TrabajoValidator final RunTrabajoDto runTrabajo) {
        try {

            final TrabajoDto trabajo = runTrabajo.getTrabajo();
            
            if (TipoAmbitoEnum.SOCIEDAD.getId().equals(trabajo.getTipoAmbito().getId())){
                OrigenRequestDto request = new OrigenRequestDto();
                request.setData(new GenericFilterDto());
                request.setPage(new PageDto());
                request.getData().setFechaInicio(LocalDateTime.from(trabajo.getFechaInicioPeriodo()));
                request.getData().setFechaFin(LocalDateTime.from(trabajo.getFechaFinPeriodo()));
                request.getData().setItem(new ArrayList<>());
                request.getData().getItem().add(GenericFilterParametersDto.builder().idSociedadReg(trabajo.getIdOrganization()).build());
                List<OrigenResultItemDto> origen = meta4IcmWsCalcIncomeSessionService.getOrigen(request);
                List<TrabajoAmbitoOrigenDto> trabajoAmbitoOrigen = origen.stream().map(e-> TrabajoAmbitoOrigenDto.builder().idOrigen(e.getIdOrigen()).idTrabajo(trabajo.getId()).build()).collect(Collectors.toList());
                runTrabajo.getTrabajo().setOrigen(trabajoAmbitoOrigen);
            }
            
            if (TipoAmbitoEnum.SOCIEDAD.getId().equals(trabajo.getTipoAmbito().getId()) || TipoAmbitoEnum.ORIGEN.getId().equals(trabajo.getTipoAmbito().getId())) {
                EmpresaRequestDto request = new EmpresaRequestDto();
                request.setData(new GenericFilterDto());
                request.setPage(new PageDto());
                request.getData().setFechaInicio(LocalDateTime.from(trabajo.getFechaInicioPeriodo()));
                request.getData().setFechaFin(LocalDateTime.from(trabajo.getFechaFinPeriodo()));
                request.getData().setItem(new ArrayList<>());
                trabajo.getOrigen().stream().forEach(e -> request.getData().getItem().add(GenericFilterParametersDto.builder().idOrigenReg(e.getIdOrigen()).build()));
                List<EmpresaResultItemDto> origen = meta4IcmWsCalcIncomeSessionService.getEmpresa(request);
                List<TrabajoAmbitoEmpresaDto> trabajoAmbitoEmpresa = origen.stream().map(e-> TrabajoAmbitoEmpresaDto.builder().idEmpresa(e.getIdEmpresa()).idTrabajo(trabajo.getId()).build()).collect(Collectors.toList());
                runTrabajo.getTrabajo().setEmpresa(trabajoAmbitoEmpresa);
            }
    
            runTrabajo.setTarea(tareaService.create(runTrabajo.getTrabajo()));
        } catch (Exception e) {
            //TODO ESTADO
            throw e;
        } finally {
            //TODO fecha fin
        }
        return runTrabajo;
    }

}