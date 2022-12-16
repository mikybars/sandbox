package com.inditex.rrhh.icmclcwb.model.app.run.trabajo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.aqsw.framework.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.aqsw.framework.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdOrigenEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoValidator;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTrabajoServiceImpl implements RunTrabajoService {

  @Autowired
  @Qualifier("meta4Properties")
  private Map<String, Meta4PropertiesDto> meta4Properties;

  @Autowired
  private TareaService tareaService;

  @Autowired
  private TrabajoService trabajoService;

  @Autowired
  private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunTrabajoService.run.timer", metricGroupName = "RunTrabajoServiceGroup",
      metricDescription = "RunTrabajoService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTrabajoService.run.counter", metricGroupName = "RunTrabajoServiceGroup",
      metricDescription = "RunTrabajoService.run.counter")
  @Override
  public RunTrabajoDto run(@NotNull @Valid @TrabajoValidator final RunTrabajoDto runTrabajo) {
    final TrabajoDTO trabajo = runTrabajo.getTrabajo();
    try {
      this.trabajoService.updateEstado(trabajo, EstadoTrabajoEnum.EN_CURSO.getDto());
      List<IdOrigenEmpresaDto> empresasNoCalcular = new ArrayList<>();
      if (TipoAmbitoEnum.SOCIEDAD.getId().equals(trabajo.getTipoAmbito().getId())) {
        final OrigenRequestDto request = new OrigenRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.ORIGEN).getPage());
        request.getData().setItem(new ArrayList<>());
        request.getData()
            .getItem()
            .add(GenericFilterParametersDto.builder().idSociedadReg(trabajo.getIdOrganization()).build());
        final List<OrigenResultItemDto> origen = this.meta4IcmWsCalcIncomeSessionService.getOrigen(request);
        final List<TrabajoAmbitoOrigenDTO> trabajoAmbitoOrigen = origen.stream()
            .map(e -> {
              final TrabajoAmbitoOrigenDTO ambitoOrigen = new TrabajoAmbitoOrigenDTO();
              ambitoOrigen.setCclIdOrigen(e.getIdOrigen());
              ambitoOrigen.setIdTrabajo(trabajo.getId());
              return ambitoOrigen;
            })
            .collect(Collectors.toList());
        runTrabajo.getTrabajo().setOrigen(trabajoAmbitoOrigen);
      }
      if (TipoAmbitoEnum.SOCIEDAD.getId().equals(trabajo.getTipoAmbito().getId())
          || TipoAmbitoEnum.ORIGEN.getId().equals(trabajo.getTipoAmbito().getId())) {
        final EmpresaRequestDto request = new EmpresaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.EMPRESA).getPage());
        request.getData().setItem(new ArrayList<>());
        trabajo.getOrigen()
            .stream()
            .forEach(e -> request.getData()
                .getItem()
                .add(GenericFilterParametersDto.builder().idOrigenReg(e.getCclIdOrigen()).build()));
        final List<EmpresaResultItemDto> origen = this.meta4IcmWsCalcIncomeSessionService.getEmpresa(request);
        final List<TrabajoAmbitoEmpresaDTO> trabajoAmbitoEmpresa = origen.stream()
            .map(e -> {
              final TrabajoAmbitoEmpresaDTO ambitoEmpresa = new TrabajoAmbitoEmpresaDTO();
              ambitoEmpresa.setStdIdLegEnt(e.getIdEmpresa());
              ambitoEmpresa.setIdTrabajo(trabajo.getId());
              return ambitoEmpresa;
            })
            .collect(Collectors.toList());

        if (trabajo.getIdProgramacion() != null) {
          empresasNoCalcular = this.trabajoService.findEmpresasCalcularProgramados(trabajo,
              origen.stream().map(e -> e.getIdEmpresa()).collect(Collectors.toList()),
              trabajo.getOrigen().stream().map(e -> e.getCclIdOrigen()).collect(
                  Collectors.toList()));
        }
        final List<String> empresas = empresasNoCalcular.stream().map(e -> e.getStdIdLegEnt()).collect(Collectors.toList());
        runTrabajo.getTrabajo()
            .setEmpresa(trabajoAmbitoEmpresa.stream().filter(e -> !empresas.contains(e.getStdIdLegEnt())).collect(Collectors.toList()));
      }

      runTrabajo.setTarea(this.tareaService.create(runTrabajo.getTrabajo()));
      this.trabajoService.updateEstado(trabajo, EstadoTrabajoEnum.OK.getDto());
    } catch (final Exception e) {
      this.trabajoService.updateEstado(trabajo, EstadoTrabajoEnum.KO.getDto());
      throw e;
    } finally {
      this.trabajoService.updateFechaFin(trabajo);
    }
    return runTrabajo;
  }

}
