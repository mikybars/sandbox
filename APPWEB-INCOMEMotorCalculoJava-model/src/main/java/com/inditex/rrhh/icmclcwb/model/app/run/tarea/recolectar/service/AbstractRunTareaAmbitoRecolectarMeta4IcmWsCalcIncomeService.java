package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
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
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

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
    private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

    protected abstract LocalDateTime getFechaInicioPeriodo(TareaDto tarea);

    public void personaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
                                                @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
            request.setPage(meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS).getPage());
            request.setData(tareaMapper
                .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(tarea, tareaAmbito, tareaPersonaHistoricoService.findPeriodoByIdTareaDto(tarea.getId())));
            if (request.getData() != null) {
                request.getData().setFechaInicio(getFechaInicioPeriodo(tarea));
            }
            boolean hasNext = false;
            do {
                CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                    .searchEmpleados(request);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS)
                    .getFilter().getMaxPersistenceSize());
                CompletableFuture<Void> cfSave = tareaPersonaHistoricoAsyncService
                    .saveGenericEmpleadoResultItemDto(data, tarea);
                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                hasNext = request.nextPage();
            } while (hasNext);
            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    public void localizacionByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
                                                     @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            SearchTiendasRequestDto request = new SearchTiendasRequestDto();
            request.setPage(meta4Properties.get(Meta4PropertiesConstants.SEARCH_TIENDAS).getPage());
            request.setData(tareaMapper
                .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(tarea, tareaAmbito, tareaPersonaHistoricoService.findPeriodoByIdTareaDto(tarea.getId())));
            if (request.getData() != null) {
                request.getData().setFechaInicio(getFechaInicioPeriodo(tarea));
            }
            boolean hasNext = false;
            do {
                CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                    .searchTiendas(request);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericTiendaResultItemDto> data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, meta4Properties.get(Meta4PropertiesConstants.SEARCH_TIENDAS)
                    .getFilter().getMaxPersistenceSize());
                CompletableFuture<Void> cfSave = tareaLocalizacionHistoricoAsyncService
                    .saveGenericTiendaResultItemDto(data, tarea);
                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                hasNext = request.nextPage();
            } while (hasNext);
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    public void empleadosPresenciaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
                                                           @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
            request.setPage(meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_PRESENCIA).getPage());
            request.setData(
                tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea, tareaAmbito));
            if (request.getData() != null) {
                request.getData().setFechaInicio(getFechaInicioPeriodo(tarea));
            }
            boolean hasNext = false;
            do {
                CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                    .getEmpleadosPresencia(request);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_PRESENCIA)
                    .getFilter().getMaxPersistenceSize());
                CompletableFuture<Void> cfSave = tareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService
                    .saveGenericEmpleadoResultItemDto(data, tarea);
                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                hasNext = request.nextPage();
            } while (hasNext);
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    public void empleadosDesplazamientoByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
                                                                @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
            request.setPage(meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_DESPLAZAMIENTO).getPage());
            request.setData(tareaMapper
                .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea, tareaAmbito));
            if (request.getData() != null) {
                request.getData().setFechaInicio(getFechaInicioPeriodo(tarea));
            }
            boolean hasNext = false;
            do {
                CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                    .getEmpleadosDesplazamiento(request);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                if (CollectionUtils.isNotEmpty(data)) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist, meta4Properties
                        .get(Meta4PropertiesConstants.EMPLEADOS_DESPLAZAMIENTO).getFilter().getMaxPersistenceSize());
                    CompletableFuture<Void> cfSave = tareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService
                        .saveGenericEmpleadoResultItemDto(data, tarea);
                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    hasNext = request.nextPage();
                }
            } while (hasNext);
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
