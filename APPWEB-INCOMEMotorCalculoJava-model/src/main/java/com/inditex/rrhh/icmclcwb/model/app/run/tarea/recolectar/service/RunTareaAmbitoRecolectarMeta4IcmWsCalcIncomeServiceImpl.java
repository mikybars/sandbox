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

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionCalcularAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionFestivoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaSeccionPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaCoeficienteAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaSeccionEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
@Validated
public class RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl
        implements RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService {

    @Autowired
    @Qualifier("meta4Properties")
    private Map<String, Meta4PropertiesDto> meta4Properties;

    @Autowired
    private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

    @Autowired
    private TareaLocalizacionHistoricoAsyncService tareaLocalizacionHistoricoAsyncService;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    private TareaPersonaHistoricoAsyncService tareaPersonaHistoricoAsyncService;

    @Autowired
    private TareaPersonaHistoricoService tareaPersonaHistoricoService;

    @Autowired
    private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

    @Autowired
    private TareaPersonaEstructuraAsyncService tareaPersonaEstructuraAsyncService;

    @Autowired
    private TareaPersonaSeccionEstructuraAsyncService tareaPersonaSeccionEstructuraAsyncService;

    @Autowired
    private TareaLocalizacionComisionHistoricoAsyncService tareaLocalizacionComisionHistoricoAsyncService;

    @Autowired
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService tareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService;

    @Autowired
    private TareaLocalizacionFestivoAsyncService tareaLocalizacionFestivoAsyncService;

    @Autowired
    private TareaLocalizacionCalcularAsyncService tareaLocalizacionCalcularAsyncService;

    @Autowired
    private TareaLocalizacionPersonaSeccionPresenciaAsyncService tareaLocalizacionPersonaSeccionPresenciaAsyncService;

    @Autowired
    private TareaPersonaCoeficienteAsyncService tareaPersonaCoeficienteAsyncService;

    @Override
    public void personaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
            request.setPage(meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS).getPage());
            request.setData(tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea,
                    tareaAmbito));
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

    @Override
    public void localizacionByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            SearchTiendasRequestDto request = new SearchTiendasRequestDto();
            request.setPage(meta4Properties.get(Meta4PropertiesConstants.SEARCH_TIENDAS).getPage());
            request.setData(tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea,
                    tareaAmbito));
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
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void empleadosPresenciaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        final TrabajoDto trabajo = runTarea.getTrabajo();
        final TareaDto tarea = runTarea.getTarea();
        EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
        request.setPage(meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_PRESENCIA).getPage());
        request.setData(
                tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea, tareaAmbito));
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
        AsyncUtils.waitAllOfIsOk(cf);
    }

    @Override
    public void festivosByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            FestivosRequestDto request = new FestivosRequestDto();
            request.setPage(meta4Properties.get(Meta4PropertiesConstants.FESTIVOS).getPage());
            request.setData(tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndTareaAmbitoLocalizacionDtoAndTareaAmbitoPersonaDtoToGenericFilterDto(
                            trabajo, tarea, tareaAmbito, tarea.getLocalizacion(), tarea.getPersona()));
            boolean hasNext = false;
            do {
                CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .getFestivos(request);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericTiendaResultItemDto> data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist,
                        meta4Properties.get(Meta4PropertiesConstants.FESTIVOS).getFilter().getMaxPersistenceSize());
                CompletableFuture<Void> cfSave = tareaLocalizacionFestivoAsyncService.save(data, tarea);
                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                hasNext = request.nextPage();
            } while (hasNext);
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void coefJornadaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdPersonaHistoricoDto> iter : StreamUtils.partition(
                    tareaPersonaHistoricoService.findIdPersonaHistoricoByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    meta4Properties.get(Meta4PropertiesConstants.COEF_JORNADA).getFilter().getMaxPageSize())) {
                CoefJornadaRequestDto request = new CoefJornadaRequestDto();
                request.setPage(meta4Properties.get(Meta4PropertiesConstants.COEF_JORNADA).getPage());
                request.setData(tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndTareaAmbitoLocalizacionDtoAndTareaAmbitoPersonaDtoToGenericFilterDto(
                                trabajo, tarea, tareaAmbito, tarea.getLocalizacion(), tarea.getPersona()));
                request.getData().setItem(
                        iter.stream().map(e -> GenericFilterParametersDto.builder().idEmpleado(e.getIdPersona())
                                .orEmpleado(e.getOrPersona()).build()).collect(Collectors.toList()));
                boolean hasNext = false;
                do {
                    CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                            .getCoefJornada(request);
                    AsyncUtils.exceptionally(cfData, cf);
                    List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                    AsyncUtils.checkAsyncAvaliable(cfPersist,
                            meta4Properties.get(Meta4PropertiesConstants.COEF_JORNADA).getFilter().getMaxPersistenceSize());
                    CompletableFuture<Void> cfSave = tareaPersonaCoeficienteAsyncService.save(data, tarea);
                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    hasNext = request.nextPage();
                } while (hasNext);
                AsyncUtils.waitAllOfIsOk(cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void flagCalculaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdLocalizacionDto> iter : StreamUtils.partition(
                    tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    meta4Properties.get(Meta4PropertiesConstants.FLAG_CALCULA).getFilter().getMaxPageSize())) {
                FlagCalculaRequestDto request = new FlagCalculaRequestDto();
                request.setPage(meta4Properties.get(Meta4PropertiesConstants.FLAG_CALCULA).getPage());
                request.setData(tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndTareaAmbitoLocalizacionDtoAndTareaAmbitoPersonaDtoToGenericFilterDto(
                                trabajo, tarea, tareaAmbito, tarea.getLocalizacion(), tarea.getPersona()));
                request.getData().getItem()
                        .addAll(iter.stream()
                                .map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(e.getId()).build())
                                .collect(Collectors.toList()));
                boolean hasNext = false;
                do {
                    CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                            .getFlagCalcula(request);
                    AsyncUtils.exceptionally(cfData, cf);
                    List<GenericTiendaResultItemDto> data = AsyncUtils.get(cfData);
                    AsyncUtils.checkAsyncAvaliable(cfPersist, meta4Properties.get(Meta4PropertiesConstants.FLAG_CALCULA)
                            .getFilter().getMaxPersistenceSize());
                    CompletableFuture<Void> cfSave = tareaLocalizacionCalcularAsyncService.save(data, tarea);
                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    hasNext = request.nextPage();
                } while (hasNext);
                AsyncUtils.waitAllOfIsOk(cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
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
            for (List<IdLocalizacionDto> iter : StreamUtils.partition(
                    tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    meta4Properties.get(Meta4PropertiesConstants.PRESENCIA_MANUAL).getFilter().getMaxPageSize())) {
                PresenciaManualRequestDto request = new PresenciaManualRequestDto();
                request.setPage(meta4Properties.get(Meta4PropertiesConstants.PRESENCIA_MANUAL).getPage());
                request.setData(tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndTareaAmbitoLocalizacionDtoAndTareaAmbitoPersonaDtoToGenericFilterDto(
                                trabajo, tarea, tareaAmbito, tarea.getLocalizacion(), tarea.getPersona()));
                request.getData().getItem()
                        .addAll(iter.stream()
                                .map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(e.getId()).build())
                                .collect(Collectors.toList()));
                boolean hasNext = false;
                do {
                    CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                            .getPresenciaManual(request);
                    AsyncUtils.exceptionally(cfData, cf);
                    List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                    AsyncUtils.checkAsyncAvaliable(cfPersist, meta4Properties
                            .get(Meta4PropertiesConstants.PRESENCIA_MANUAL).getFilter().getMaxPersistenceSize());
                    CompletableFuture<Void> cfSave = tareaLocalizacionPersonaSeccionPresenciaAsyncService.save(data,
                            tarea);
                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    hasNext = request.nextPage();
                } while (hasNext);
                AsyncUtils.waitAllOfIsOk(cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
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
                    tareaPersonaHistoricoService.findIdPersonaByIdTareaAndIdOrigenInAmbito(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    meta4Properties.get(Meta4PropertiesConstants.COMISION_EMPLEADO).getFilter().getMaxPageSize())) {
                ComisionEmpleadoRequestDto comisionEmpleadoRequest = new ComisionEmpleadoRequestDto();
                comisionEmpleadoRequest.setPage(meta4Properties.get(Meta4PropertiesConstants.COMISION_EMPLEADO).getPage());
                comisionEmpleadoRequest.setData(tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea, tareaAmbito));
                comisionEmpleadoRequest.getData().getItem()
                        .addAll(iter.stream().map(
                                item -> GenericFilterParametersDto.builder().idEmpleado(item.getIdPersona()).build())
                                .collect(Collectors.toList()));
                CompletableFuture<List<ComisionEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .getComisionEmpleado(comisionEmpleadoRequest);
                AsyncUtils.exceptionally(cfData, cf);
                List<ComisionEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist,
                        meta4Properties.get(Meta4PropertiesConstants.COMISION_EMPLEADO).getFilter().getMaxPersistenceSize());
                CompletableFuture<Void> cfSavePivotado = tareaPersonaEstructuraAsyncService
                        .saveComisionEmpleadoResultItemDto(data, tarea);
                AsyncUtils.checkAsyncAvaliable(cfPersist,
                        meta4Properties.get(Meta4PropertiesConstants.COMISION_EMPLEADO).getFilter().getMaxPersistenceSize());
                CompletableFuture<Void> cfSaveNoPivotado = tareaPersonaSeccionEstructuraAsyncService
                        .saveComisionEmpleadoResultItemDto(data, tarea);
                AsyncUtils.exceptionally(cfSavePivotado, cf, cfPersist);
                AsyncUtils.exceptionally(cfSaveNoPivotado, cf, cfPersist);
                AsyncUtils.waitAllOfIsOk(cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void tiendasComisionableByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdLocalizacionDto> iter : StreamUtils.partition(
                    tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    meta4Properties.get(Meta4PropertiesConstants.TIENDAS).getFilter().getMaxPageSize())) {
                TiendasRequestDto tiendasRequest = new TiendasRequestDto();
                tiendasRequest.setPage(meta4Properties.get(Meta4PropertiesConstants.TIENDAS).getPage());
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
                    if (CollectionUtils.isNotEmpty(data)) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist, meta4Properties.get(Meta4PropertiesConstants.TIENDAS)
                                .getFilter().getMaxPersistenceSize());
                        CompletableFuture<Void> cfSave = tareaLocalizacionComisionHistoricoAsyncService
                                .saveGenericTiendaResultItemDto(data, tarea);
                        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    }
                    hasNext = tiendasRequest.nextPage();
                } while (hasNext);
            }
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
