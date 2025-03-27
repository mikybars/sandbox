package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.IncomeMetaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalEmpresaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalFechaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalFechaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalFechaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaRequestItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractRunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService {

  @Autowired
  @Qualifier("meta4Properties")
  private Map<String, Meta4PropertiesDto> meta4Properties;

  @Autowired
  private TareaMapper tareaMapper;

  @Autowired
  private TareaLocalizacionHistoricoAsyncService tareaLocalizacionHistoricoAsyncService;

  @Autowired
  private TareaPersonaHistoricoAsyncService tareaPersonaHistoricoAsyncService;

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService tareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService;

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService tareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService;

  @Autowired
  private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  @Autowired
  private TareaAmbitoGlobalFechaAsyncService tareaAmbitoGlobalFechaAsyncService;

  @Autowired
  private TareaAmbitoGlobalFechaService tareaAmbitoGlobalFechaService;

  @Autowired
  private TareaAmbitoGlobalEmpresaAsyncService tareaAmbitoGlobalEmpresaAsyncService;

  @Autowired
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @Autowired
  private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

  @Autowired
  private IncomeMetaService incomeMetaService;

  protected abstract LocalDateTime getFechaInicioPeriodo(TareaDto tarea);

  public void fechaAmbitoAndEmpresaByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      final TareaDto tarea = runTarea.getTarea();
      final DesplazamientosMultiempresaRequestItemDto item = DesplazamientosMultiempresaRequestItemDto
          .builder()
          .fechaFin(trabajo.getFechaFinPeriodo().toLocalDate())
          .fechaInicio(trabajo.getFechaInicioPeriodo().toLocalDate())
          .idEmpresa(tarea.getStdIdLegEnt())
          .idOrigen(tareaAmbito.getCclIdOrigen())
          .build();
      final DesplazamientosMultiempresaRequestDto request = new DesplazamientosMultiempresaRequestDto();
      request.setData(item);
      final CompletableFuture<List<DesplazamientosMultiempresaItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
          .getDesplazamientosMultiempresa(request);
      AsyncUtils.exceptionally(cfData, cf);
      final List<DesplazamientosMultiempresaItemDto> data = AsyncUtils.get(cfData);
      if (CollectionUtils.isNotEmpty(data)) {

        // Guardado fechas
        AsyncUtils.checkAsyncAvaliable(cfPersist,
            this.meta4Properties.get(Meta4PropertiesConstants.MULTIEMPRESA)
                .getFilter()
                .getMaxPersistenceSize());
        final TareaAmbitoGlobalFechaDto fecha = this.tareaMapper
            .mergeTareaDtoAndDesplazamientosMultiempresaItemDtoToTareaAmbitoGlobalFechaDto(tarea, data.get(0));
        final CompletableFuture<Void> cfSaveFecha = this.tareaAmbitoGlobalFechaAsyncService.save(fecha, tarea);
        AsyncUtils.exceptionally(cfSaveFecha, cf, cfPersist);

        // Guardado empresas
        final List<TareaAmbitoGlobalEmpresaDto> empresas = this.tareaMapper
            .mergeTareaDtoAndDesplazamientosMultiempresaItemDtoToAmbitoGlobalEmpresaDto(tarea, data);
        AsyncUtils.checkAsyncAvaliable(cfPersist,
            this.meta4Properties.get(Meta4PropertiesConstants.MULTIEMPRESA)
                .getFilter()
                .getMaxPersistenceSize());
        final CompletableFuture<Void> cfSaveEmpresa = this.tareaAmbitoGlobalEmpresaAsyncService.save(empresas,
            tarea);
        AsyncUtils.exceptionally(cfSaveEmpresa, cf, cfPersist);

      }

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cf);
      /*-------------------------------------------------------------*/
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  public void personaByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
      final List<IdEmpresaDto> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId());
      request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS).getPage());
      request.setData(this.tareaMapper
          .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtotoSearchEmpleadosFilterDto(tarea, tareaAmbito,
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  tarea.getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId())));
      request.getData()
          .setIdsEmpresa(empresasAmbito.stream().map(IdEmpresaDto::getStdIdLegEnt).collect(Collectors.toList()));

      final List<EmpleadoDTO> data = this.incomeMetaService.searchEmpleados(request);

      if (CollectionUtils.isNotEmpty(data)) {
        final CompletableFuture<Void> cfSave = this.tareaPersonaHistoricoAsyncService.saveEmpleadoDto(data, tarea);
        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
      }

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cf);
      /*-------------------------------------------------------------*/
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  public void localizacionByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final SearchTiendasRequestDto request = new SearchTiendasRequestDto();
      this.tareaLocalizacionHistoricoService.mergeLocalizacionFicticia(tarea.getId(),
          tareaAmbito.getCclIdOrigen(), AppConstants.EMPRESA_0);
      final List<IdEmpresaDto> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId());
      request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_TIENDAS).getPage());
      request.setData(this.tareaMapper
          .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToSearchTiendasFilterDto(tarea, tareaAmbito,
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  tarea.getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId())));
      request.getData()
          .setIdsEmpresa(empresasAmbito.stream().map(IdEmpresaDto::getStdIdLegEnt).collect(Collectors.toList()));

      boolean hasNext = false;
      do {
        final CompletableFuture<List<GenericTiendaResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
            .searchTiendas(request);
        AsyncUtils.exceptionally(cfData, cf);
        final List<GenericTiendaResultItemDto> data = AsyncUtils.get(cfData);
        if (CollectionUtils.isNotEmpty(data)) {
          AsyncUtils.checkAsyncAvaliable(cfPersist,
              this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_TIENDAS)
                  .getFilter()
                  .getMaxPersistenceSize());
          final CompletableFuture<Void> cfSave = this.tareaLocalizacionHistoricoAsyncService
              .saveGenericTiendaResultItemDto(data, tarea);
          AsyncUtils.exceptionally(cfSave, cf, cfPersist);
          hasNext = request.nextPage();
        }
      } while (hasNext);
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  public void empleadosPresenciaByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      final TareaDto tarea = runTarea.getTarea();
      final EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
      final List<IdEmpresaDto> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId());
      request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_PRESENCIA).getPage());
      request.setData(
          this.tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo,
              tarea,
              tareaAmbito,
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  tarea.getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId())));
      request.getData()
          .setIdsEmpresa(empresasAmbito.stream().map(IdEmpresaDto::getStdIdLegEnt).collect(Collectors.toList()));
      boolean hasNext = false;
      do {
        final CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
            .getEmpleadosPresencia(request);
        AsyncUtils.exceptionally(cfData, cf);
        final List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
        if (CollectionUtils.isNotEmpty(data)) {
          AsyncUtils.checkAsyncAvaliable(cfPersist,
              this.meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_PRESENCIA)
                  .getFilter()
                  .getMaxPersistenceSize());
          final CompletableFuture<Void> cfSave = this.tareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService
              .saveGenericEmpleadoResultItemDto(data, tarea);
          AsyncUtils.exceptionally(cfSave, cf, cfPersist);
          hasNext = request.nextPage();
        }
      } while (hasNext);
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  public void empleadosDesplazamientoByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      final TareaDto tarea = runTarea.getTarea();
      final List<IdEmpresaDto> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId());
      final EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
      request
          .setPage(this.meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_DESPLAZAMIENTO).getPage());
      request.setData(this.tareaMapper
          .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea, tareaAmbito,
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  tarea.getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId())));
      request.getData()
          .setIdsEmpresa(empresasAmbito.stream().map(IdEmpresaDto::getStdIdLegEnt).collect(Collectors.toList()));
      boolean hasNext = false;
      do {
        final CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
            .getEmpleadosDesplazamiento(request);
        AsyncUtils.exceptionally(cfData, cf);
        final List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
        if (CollectionUtils.isNotEmpty(data)) {
          AsyncUtils.checkAsyncAvaliable(cfPersist, this.meta4Properties
              .get(Meta4PropertiesConstants.EMPLEADOS_DESPLAZAMIENTO)
              .getFilter()
              .getMaxPersistenceSize());
          final CompletableFuture<Void> cfSave = this.tareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService
              .saveGenericEmpleadoResultItemDto(data, tarea);
          AsyncUtils.exceptionally(cfSave, cf, cfPersist);
          hasNext = request.nextPage();
        }
      } while (hasNext);
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
