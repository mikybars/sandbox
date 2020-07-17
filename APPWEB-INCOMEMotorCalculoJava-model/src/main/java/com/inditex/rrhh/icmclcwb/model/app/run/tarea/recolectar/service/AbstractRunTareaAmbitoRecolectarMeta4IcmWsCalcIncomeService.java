package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
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
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import org.apache.commons.collections.CollectionUtils;

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
    private TareaPersonaHistoricoService tareaPersonaHistoricoService;

    @Autowired
    private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

    @Autowired
    private TareaAmbitoGlobalFechaService tareaAmbitoGlobalFechaService;

    @Autowired
    private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

    @Autowired
    private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

    protected abstract LocalDateTime getFechaInicioPeriodo(TareaDto tarea);

    // TODO: Enganchar servicio
    public void fechaAmbitoAndEmpresaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TareaAmbitoGlobalEmpresaDto dto = new TareaAmbitoGlobalEmpresaDto();
            dto.setIdTarea(runTarea.getTarea().getId());
            dto.setStdIdLegEnt(runTarea.getTarea().getStdIdLegEnt());
            dto.setCclIdOrigen(tareaAmbito.getCclIdOrigen());
            this.tareaAmbitoGlobalEmpresaService.save(
                    Arrays.asList(dto),
                    runTarea.getTarea());

            final TareaAmbitoGlobalFechaDto dtoFecha = new TareaAmbitoGlobalFechaDto();
            dtoFecha.setFechaInicio(TimeUtils.toDate(runTarea.getTrabajo().getFechaInicioPeriodo().plusMonths(2)));
            dtoFecha.setFechaFin(TimeUtils.toDate(runTarea.getTrabajo().getFechaFinPeriodo()));
            dtoFecha.setIdTarea(runTarea.getTarea().getId());

            this.tareaAmbitoGlobalFechaService.save(Arrays.asList(dtoFecha), runTarea.getTarea());
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }


    public void personaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TareaDto tarea = runTarea.getTarea();
            final SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
            this.tareaAmbitoGlobalEmpresaService
                .findIdEmpresaByIdTarea(tarea.getId())
                .stream()
                .forEach(x -> {
                    request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS).getPage());
                    request.setData(this.tareaMapper
                        .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(tarea, tareaAmbito,
                                this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                                        tarea.getId(),
                                        TipoDatoEnum.PERIODO_AMPLIADO.getId())));
                    request.getData().setIdEmpresa(x.getStdIdLegEnt());
                    boolean hasNext = false;
                    do {
                        final CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
                            .searchEmpleados(request);
                        AsyncUtils.exceptionally(cfData, cf);
                        final List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                        if (CollectionUtils.isNotEmpty(data)) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist,
                                    this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS)
                                        .getFilter()
                                        .getMaxPersistenceSize());
                            final CompletableFuture<Void> cfSave = this.tareaPersonaHistoricoAsyncService
                                .saveGenericEmpleadoResultItemDto(data, tarea);
                            AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                            hasNext = request.nextPage();
                        }
                    } while (hasNext);

                });
            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    public void localizacionByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TareaDto tarea = runTarea.getTarea();
            final SearchTiendasRequestDto request = new SearchTiendasRequestDto();
            this.tareaLocalizacionHistoricoService.mergeLocalizacionFicticia(tarea.getId(),
                    tareaAmbito.getCclIdOrigen());
            this.tareaAmbitoGlobalEmpresaService
                .findIdEmpresaByIdTarea(tarea.getId())
                .stream()
                .forEach(x -> {
                    request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_TIENDAS).getPage());
                    request.setData(this.tareaMapper
                        .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(tarea, tareaAmbito,
                                this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                                        tarea.getId(),
                                        TipoDatoEnum.PERIODO_AMPLIADO.getId())));
                    request.getData().setIdEmpresa(x.getStdIdLegEnt());

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
                });
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    public void empleadosPresenciaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            final EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
            this.tareaAmbitoGlobalEmpresaService
                .findIdEmpresaByIdTarea(tarea.getId())
                .stream()
                .forEach(x -> {
                    request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_PRESENCIA).getPage());
                    request.setData(
                            this.tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo,
                                    tarea,
                                    tareaAmbito,
                                    this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                                            tarea.getId(),
                                            TipoDatoEnum.PERIODO_AMPLIADO.getId())));

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
                });
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    public void empleadosDesplazamientoByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            this.tareaAmbitoGlobalEmpresaService
                .findIdEmpresaByIdTarea(tarea.getId())
                .stream()
                .forEach(x -> {
                    final EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
                    request
                        .setPage(this.meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_DESPLAZAMIENTO).getPage());
                    request.setData(this.tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea, tareaAmbito,
                                this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                                        tarea.getId(),
                                        TipoDatoEnum.PERIODO_AMPLIADO.getId())));

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
                });
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
