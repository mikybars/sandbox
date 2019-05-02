package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaEmpleadoEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaManualAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
@Validated
public class RunTareaRecolectarMeta4IcmWsCalcIncomeServiceImpl
        implements RunTareaRecolectarMeta4IcmWsCalcIncomeService {

    @Autowired
    @Qualifier("meta4Properties")
    private Map<String, Meta4PropertiesDto> meta4Properties;

    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;

    @Autowired
    private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

    @Autowired
    private TareaTiendaHistoricoAsyncService tareaTiendaHistoricoAsyncService;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    private TareaPersonaHistoricoAsyncService tareaPersonaHistoricoAsyncService;

    @Autowired
    private TareaPersonaHistoricoService tareaPersonaHistoricoervice;

    @Autowired
    private TareaTiendaHistoricoService tareaTiendaHistoricoService;

    @Autowired
    private TareaEmpleadoEstructuraAsyncService tareaEmpleadoEstructuraAsyncService;

    @Autowired
    private TareaTiendaComisionHistoricoAsyncService tareaTiendaComisionHistoricoAsyncService;

    @Autowired
    private TareaLocalizacionPersonaPresenciaManualAsyncService tareaLocalizacionPersonaPresenciaManualAsyncService;

    @Override
    public void personaByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            personaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    @Override
    public void personaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();

            SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
            request.setPage(meta4Properties.get(Meta4Constants.SEARCH_EMPLEADOS).getPage());
            request.setData(tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndTareaAmbitoLocalizacionDtoAndTareaAmbitoPersonaDtoToGenericFilterDto(
                            trabajo, tarea, tareaAmbito, tarea.getLocalizacion(), tarea.getPersona()));
            boolean hasNext = false;
            do {
                CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .searchEmpleados(request);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist,
                        meta4Properties.get(Meta4Constants.SEARCH_EMPLEADOS).getFilter().getMaxPersistenceSize());
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
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Override
    public void localizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            localizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    @Override
    public void localizacionByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            SearchTiendasRequestDto request = new SearchTiendasRequestDto();
            request.setPage(meta4Properties.get(Meta4Constants.SEARCH_TIENDAS).getPage());
            request.setData(tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndTareaAmbitoLocalizacionDtoAndTareaAmbitoPersonaDtoToGenericFilterDto(
                            trabajo, tarea, tareaAmbito, tarea.getLocalizacion(), tarea.getPersona()));

            boolean hasNext = false;
            do {
                CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .searchTiendas(request);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericTiendaResultItemDto> data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist,
                        meta4Properties.get(Meta4Constants.SEARCH_TIENDAS).getFilter().getMaxPersistenceSize());
                CompletableFuture<Void> cfSave = tareaTiendaHistoricoAsyncService.saveGenericTiendaResultItemDto(data,
                        tarea);
                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                hasNext = request.nextPage();
            } while (hasNext);
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Override
    public void empleadosPresenciaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            empleadosPresenciaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    @Override
    public void empleadosPresenciaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
            request.setPage(meta4Properties.get(Meta4Constants.EMPLEADOS_PRESENCIA).getPage());
            request.setData(tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndTareaAmbitoLocalizacionDtoAndTareaAmbitoPersonaDtoToGenericFilterDto(
                            trabajo, tarea, tareaAmbito, tarea.getLocalizacion(), tarea.getPersona()));
            CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                    .getEmpleadosPresencia(request);
            AsyncUtils.exceptionally(cfData, cf);
            List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
            AsyncUtils.checkAsyncAvaliable(cfPersist,
                    meta4Properties.get(Meta4Constants.EMPLEADOS_PRESENCIA).getFilter().getMaxPersistenceSize());
            CompletableFuture<Void> cfSave = tareaLocalizacionPersonaPresenciaManualAsyncService
                    .saveGenericEmpleadoResultItemDto(data, tarea);
            AsyncUtils.exceptionally(cfSave, cf, cfPersist);
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Override
    public void presenciaManualByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            presenciaManualByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    @Override
    public void presenciaManualByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            PresenciaManualRequestDto request = new PresenciaManualRequestDto();
            request.setPage(meta4Properties.get(Meta4Constants.PRESENCIA_MANUAL).getPage());
            request.setData(tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndTareaAmbitoLocalizacionDtoAndTareaAmbitoPersonaDtoToGenericFilterDto(
                            trabajo, tarea, tareaAmbito, tarea.getLocalizacion(), tarea.getPersona()));
            CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                    .getPresenciaManual(request);
            AsyncUtils.exceptionally(cfData, cf);
            List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
            AsyncUtils.checkAsyncAvaliable(cfPersist,
                    meta4Properties.get(Meta4Constants.PRESENCIA_MANUAL).getFilter().getMaxPersistenceSize());
            // TODO: Persistir
//                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Override
    public void periodosByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            periodosByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    @Override
    public void periodosByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            PeriodosRequestDto request = new PeriodosRequestDto();
            request.setPage(meta4Properties.get(Meta4Constants.PERIODOS).getPage());
            request.setData(tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndTareaAmbitoLocalizacionDtoAndTareaAmbitoPersonaDtoToGenericFilterDto(
                            trabajo, tarea, tareaAmbito, tarea.getLocalizacion(), tarea.getPersona()));
//            CompletableFuture<List<PeriodosResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
//                    .getPeriodos(request);
//            AsyncUtils.exceptionally(cfData, cf);
//            List<PeriodosResultItemDto> data = AsyncUtils.get(cfData);
//            AsyncUtils.checkAsyncAvaliable(cfPersist, meta4Properties.get(Meta4Constants.PERIODOS).getFilter().getMaxPersistenceSize());
            // TODO: Persistir
//                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Override
    public void condicionPersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            condicionPersonaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    @Override
    public void condicionPersonaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdPersonaDto> iter : StreamUtils.partition(
                    tareaPersonaHistoricoervice.findIdPersonaByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    meta4Properties.get(Meta4Constants.COMISION_EMPLEADO).getFilter().getMaxPageSize())) {
                ComisionEmpleadoRequestDto comisionEmpleadoRequest = new ComisionEmpleadoRequestDto();
                comisionEmpleadoRequest.setPage(meta4Properties.get(Meta4Constants.COMISION_EMPLEADO).getPage());
                comisionEmpleadoRequest.setData(tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea, tareaAmbito));
                comisionEmpleadoRequest.getData().getItem()
                        .addAll(iter.stream().map(
                                item -> GenericFilterParametersDto.builder().idEmpleado(item.getIdPersona()).build())
                                .collect(Collectors.toList()));
                CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .getComisionEmpleado(comisionEmpleadoRequest);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist,
                        meta4Properties.get(Meta4Constants.COMISION_EMPLEADO).getFilter().getMaxPersistenceSize());
                CompletableFuture<Void> cfSave = tareaEmpleadoEstructuraAsyncService
                        .saveGenericEmpleadoResultItemDto(data, tarea);
                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                AsyncUtils.waitAllOfIsOk(cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void localizacionHistoricoByRunTarea(@Valid RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            localizacionHistoricoByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    private void localizacionHistoricoByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        TrabajoDto trabajo = runTarea.getTrabajo();
        TareaDto tarea = runTarea.getTarea();
        List<IdPersonaDto> idsPersona = tareaPersonaHistoricoervice.findIdPersonaByIdTareaAndIdOrigen(tarea.getId(),
                tareaAmbito.getIdOrigen());
        try {
            SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
            searchTiendasRequest.setPage(meta4Properties.get(Meta4Constants.SEARCH_TIENDAS).getPage());
            searchTiendasRequest.setData(
                    tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdPersonaDtoToGenericFilterDto(trabajo,
                            tarea, tareaAmbito, idsPersona));
            boolean hasNext = false;
            do {
                CompletableFuture<List<GenericTiendaResultItemDto>> cfDataSearchTiendas = meta4IcmWsCalcIncomeSessionAsyncService
                        .searchTiendas(searchTiendasRequest);
                AsyncUtils.exceptionally(cfDataSearchTiendas, cf);
                List<GenericTiendaResultItemDto> tiendas = cfDataSearchTiendas.get();
                if (CollectionUtils.isNotEmpty(tiendas)) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist,
                            meta4Properties.get(Meta4Constants.SEARCH_TIENDAS).getFilter().getMaxPersistenceSize());
                    CompletableFuture<Void> cfSave = tareaTiendaHistoricoAsyncService
                            .saveGenericTiendaResultItemDto(tiendas, tarea);
                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    hasNext = searchTiendasRequest.nextPage();
                }
            } while (hasNext);
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void tiendasComisionableByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            tiendasComisionableByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    private void tiendasComisionableByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            // TODO Falta el origen relacionado con los empleados
            for (List<IdLocalizacionDto> iter : StreamUtils.partition(
                    tareaTiendaHistoricoService.findIdLocalizacionDtoByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    meta4Properties.get(Meta4Constants.TIENDAS).getFilter().getMaxPageSize())) {
                TiendasRequestDto tiendasRequest = new TiendasRequestDto();
                tiendasRequest.setPage(meta4Properties.get(Meta4Constants.TIENDAS).getPage());
                tiendasRequest.setData(tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea, tareaAmbito));
                tiendasRequest.getData().getItem()
                        .addAll(iter.stream()
                                .map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(e.getId()).build())
                                .collect(Collectors.toList()));
                boolean hasNext = false;
                do {
                    CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                            .getTiendas(tiendasRequest);
                    AsyncUtils.exceptionally(cfData, cf);
                    List<GenericTiendaResultItemDto> data = AsyncUtils.get(cfData);
                    // TODO: Revisar esta persistencia
                    if (CollectionUtils.isNotEmpty(data)) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                meta4Properties.get(Meta4Constants.TIENDAS).getFilter().getMaxPersistenceSize());
                        CompletableFuture<Void> cfSave = tareaTiendaComisionHistoricoAsyncService
                                .saveGenericTiendaResultItemDto(data, tarea);
                        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    }
                    hasNext = tiendasRequest.nextPage();
                } while (hasNext);
            }
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

}
