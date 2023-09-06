package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalFechaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractRunTareaAmbitoRecolectarPtrPresenciaService {

  @Autowired
  private PtrPresenciaAsyncService ptrPresenciaAsyncService;

  @Autowired
  private TareaLocalizacionHistoricoService tareaTiendaHistoricoService;

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService tareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService;

  @Autowired
  private TareaMapper tareaMapper;

  @Autowired
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @Autowired
  private TareaAmbitoGlobalFechaService tareaAmbitoGlobalFechaService;

  @Autowired
  @Qualifier("presenciasProperties")
  private Map<String, PtrPropertiesDto> presenciasProperties;

  protected abstract String getFechaInicioPeriodo(TareaDto tarea);

  public void presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final TareaDto tarea = runTarea.getTarea();
    final PtrFilterPropertiesDto filter = this.presenciasProperties
        .get(PtrPropertiesConstants.PRESENCIA_EMPLEADOS_TIENDA)
        .getFilter();
    final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
        .findIdEmpresaByIdTarea(tarea.getId())
        .stream()
        .map(IdEmpresaDto::getStdIdLegEnt)
        .collect(Collectors.toList());
    for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
        this.tareaTiendaHistoricoService
            .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(
                tarea.getId(),
                tareaAmbito.getCclIdOrigen(),
                empresasAmbito),
        filter.getMaxPageSize())) {

      final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
      final PtrPresenciaEmpleadosTiendaRequestDto request = this.tareaMapper
          .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciaEmpleadosTiendaRequestDto(tarea,
              tareaAmbito,
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  tarea.getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId()),
              iter);

      request.setEmpresa(empresasAmbito.stream().map(Integer::parseInt).collect(Collectors.toList()));
      request.setAgrupacion(PtrGroupTypeEnum.PERSONA_TIENDA.getValue());
      request.setFechaDesde(this.getFechaInicioPeriodo(tarea));
      request.setTienda(iter.stream().map(x -> Integer.valueOf(x.getId())).collect(Collectors.toList()));
      final CompletableFuture<PtrPresenciaEmpleadosTiendaResponseDto> cfData = this.ptrPresenciaAsyncService
          .presenciasEmpleadosTienda(request);
      AsyncUtils.exceptionally(cfData, cf, cfPersist);
      final PtrPresenciaEmpleadosTiendaResponseDto data = AsyncUtils.get(cfData);
      if ((data != null) && CollectionUtils.isNotEmpty(data.getPresenciasTiendasEmpleado())) {
        AsyncUtils.checkAsyncAvaliable(cfPersist, filter.getMaxPersistenceSize());
        AsyncUtils.exceptionally(this.tareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService
            .savePtrPresenciaEmpleadosTiendaResponse(data, tarea), cf, cfPersist);
      }

    }
    AsyncUtils.waitAllOfIsOk(cf, cf);
  }

}
