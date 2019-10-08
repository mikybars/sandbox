package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaEstructuraPoliticaAsyncService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionCadenaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionConfiguracionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionCalcularAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionFestivoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionOnlineHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaCoeficienteAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
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
    private TareaLocalizacionComisionHistoricoAsyncService tareaLocalizacionComisionHistoricoAsyncService;

    @Autowired
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService tareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService;

    @Autowired
    private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService tareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService;

    @Autowired
    private TareaLocalizacionFestivoAsyncService tareaLocalizacionFestivoAsyncService;

    @Autowired
    private TareaLocalizacionCalcularAsyncService tareaLocalizacionCalcularAsyncService;

    @Autowired
    private TareaLocalizacionPersonaPresenciaAsyncService tareaLocalizacionPersonaSeccionPresenciaAsyncService;

    @Autowired
    private TareaPersonaCoeficienteAsyncService tareaPersonaCoeficienteAsyncService;

    @Autowired
    private TareaAgrupacionConfiguracionAsyncService tareaAgrupacionConfiguracionAsyncService;

    @Autowired
    private TareaAgrupacionCadenaAsyncService tareaAgrupacionCadenaAsyncService;

    @Autowired
    private TareaLocalizacionOnlineHistoricoAsyncService tareaLocalizacionOnlineHistoricoAsyncService;

    @Autowired
    private TareaPersonaEstructuraPoliticaAsyncService tareaPersonaEstructuraPoliticaAsyncService;

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
            AsyncUtils.waitAllOfIsOk(cf, cf);
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
        AsyncUtils.waitAllOfIsOk(cf, cf);
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
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(
                            trabajo, tarea, tareaAmbito));
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
            AsyncUtils.waitAllOfIsOk(cf, cf);
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
                    tareaPersonaHistoricoService.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(tarea.getId(),
                            tareaAmbito.getCclIdOrigen(), Arrays.asList(TipoDatoEnum.PERSONA_COEFICIENTEREDUCCIONJORNADA.getId())),
                    meta4Properties.get(Meta4PropertiesConstants.COEF_JORNADA).getFilter().getMaxPageSize())) {
                CoefJornadaRequestDto request = new CoefJornadaRequestDto();
                request.setPage(meta4Properties.get(Meta4PropertiesConstants.COEF_JORNADA).getPage());
                request.setData(tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(
                                trabajo, tarea, tareaAmbito));
                request.getData().setItem(
                        iter.stream().map(e -> GenericFilterParametersDto.builder().idEmpleado(e.getStdIdHr())
                                .orEmpleado(e.getStdOrHrPeriod()).build()).collect(Collectors.toList()));
                boolean hasNext = false;
                do {
                    CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                            .getCoefJornada(request);
                    AsyncUtils.exceptionally(cfData, cf);
                    List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                    AsyncUtils.checkAsyncAvaliable(cfPersist, meta4Properties.get(Meta4PropertiesConstants.COEF_JORNADA)
                            .getFilter().getMaxPersistenceSize());
                    CompletableFuture<Void> cfSave = tareaPersonaCoeficienteAsyncService.save(data, tarea);
                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    hasNext = request.nextPage();
                } while (hasNext);
                AsyncUtils.waitAllOfIsOk(cf, cf);
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
                    tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(tarea.getId(),
                            tareaAmbito.getCclIdOrigen()),
                    meta4Properties.get(Meta4PropertiesConstants.FLAG_CALCULA).getFilter().getMaxPageSize())) {
                FlagCalculaRequestDto request = new FlagCalculaRequestDto();
                request.setPage(meta4Properties.get(Meta4PropertiesConstants.FLAG_CALCULA).getPage());
                request.setData(tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(
                                trabajo, tarea, tareaAmbito));
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
                AsyncUtils.waitAllOfIsOk(cf, cf);
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
                    tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(tarea.getId(),
                            tareaAmbito.getCclIdOrigen(), Arrays.asList(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())),
                    meta4Properties.get(Meta4PropertiesConstants.PRESENCIA_MANUAL).getFilter().getMaxPageSize())) {
                PresenciaManualRequestDto request = new PresenciaManualRequestDto();
                request.setPage(meta4Properties.get(Meta4PropertiesConstants.PRESENCIA_MANUAL).getPage());
                request.setData(tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(
                                trabajo, tarea, tareaAmbito));
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
                AsyncUtils.waitAllOfIsOk(cf, cf);
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
            for (List<IdPersonaHistoricoDto> iter : StreamUtils.partition(
                    tareaPersonaHistoricoService.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(tarea.getId(),
                            tareaAmbito.getCclIdOrigen()),
                    meta4Properties.get(Meta4PropertiesConstants.COMISION_EMPLEADO).getFilter().getMaxPageSize())) {
                ComisionEmpleadoRequestDto comisionEmpleadoRequest = new ComisionEmpleadoRequestDto();
                comisionEmpleadoRequest.setData(tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea, tareaAmbito));
                comisionEmpleadoRequest.getData().getItem()
                    .addAll(iter.stream().map(
                        item -> GenericFilterParametersDto.builder().idEmpleado(item.getStdIdHr()).orEmpleado(item.getStdOrHrPeriod()).build())
                        .collect(Collectors.toList()));
                CompletableFuture<List<ComisionEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                    .getComisionEmpleado(comisionEmpleadoRequest);
                AsyncUtils.exceptionally(cfData, cf);
                List<ComisionEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                if (CollectionUtils.isNotEmpty(data)) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist, meta4Properties
                        .get(Meta4PropertiesConstants.COMISION_EMPLEADO).getFilter().getMaxPersistenceSize());
                    CompletableFuture<Void> cfSave = tareaPersonaEstructuraAsyncService
                        .saveComisionEmpleadoResultItemDto(data, tarea);
                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                }
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void configuracionVentaOnlineByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea, @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigen(runTarea.getTarea().getId(),
                tareaAmbito.getCclIdOrigen());
            ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
            request.setData(tareaMapper
                .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(runTarea.getTrabajo(), runTarea.getTarea(), tareaAmbito));
            request.getData().setItem(cadenas.stream().map(x -> GenericFilterParametersDto.builder().idCadena(x.getId()).build()).collect(Collectors.toList()));
            request.setPage(meta4Properties.get(Meta4PropertiesConstants.CONF_VENTA_ONLINE).getPage());

            boolean hasNext = false;
            do {
                CompletableFuture<List<ConfiguracionVentaOnlineResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                    .getConfiguracionVentaOnline(request);
                AsyncUtils.exceptionally(cfData, cf);
                List<ConfiguracionVentaOnlineResultItemDto> data = AsyncUtils.get(cfData);
                if (CollectionUtils.isNotEmpty(data)) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist,
                        meta4Properties.get(Meta4PropertiesConstants.CONF_VENTA_ONLINE).getFilter().getMaxPersistenceSize());
                    CompletableFuture<Void> cfSave = tareaAgrupacionConfiguracionAsyncService.saveAgrupacionConfiguracionDto(data, runTarea);
                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                }
                hasNext = request.nextPage();
            } while (hasNext);
            AsyncUtils.waitAllOfIsOk(cf,cf);
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
                    tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(tarea.getId(),
                            tareaAmbito.getCclIdOrigen()),
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
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void agrupacionesCadenaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea, @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            AgrupOnlineRequestDto request = new AgrupOnlineRequestDto();
            request.setData(tareaMapper
                .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(runTarea.getTrabajo(), runTarea.getTarea(), tareaAmbito));
            request.getData().getItem().add(GenericFilterParametersDto.builder().idOrigenReg(tareaAmbito.getCclIdOrigen()).build());
            request.setPage(meta4Properties.get(Meta4PropertiesConstants.AGRUPACION_ONLINE).getPage());
            boolean hasNext = false;
            do {
                CompletableFuture<List<AgrupOnlineResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                    .getAgrupacionesOnline(request);
                List<AgrupOnlineResultItemDto> data = AsyncUtils.get(cfData);
                if (CollectionUtils.isNotEmpty(data)) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist,
                        meta4Properties.get(Meta4PropertiesConstants.AGRUPACION_ONLINE).getFilter().getMaxPersistenceSize());
                    CompletableFuture<Void> cfSave = tareaAgrupacionCadenaAsyncService.save(data, runTarea.getTarea());
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

    @Override
    public void localizacionesOnlineByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea, @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            for (List<IdCadenaDto> cadenas : StreamUtils.partition(
                tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigen(runTarea.getTarea().getId(),
                    tareaAmbito.getCclIdOrigen()),
                meta4Properties.get(Meta4PropertiesConstants.TIENDAS_ONLINE).getFilter().getMaxPageSize())) {

                TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
                request.setData(tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(runTarea.getTrabajo(), runTarea.getTarea(), tareaAmbito));
                request.setPage(meta4Properties.get(Meta4PropertiesConstants.TIENDAS_ONLINE).getPage());
                List<GenericFilterParametersDto> items = cadenas.stream().map(x -> GenericFilterParametersDto.builder().idCadena(x.getId()).build()).collect(Collectors.toList());
                request.getData().setItem(items);
                boolean hasNext = false;
                do {
                    CompletableFuture<List<TiendaOnlineResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService.getTiendasOnline(request);
                    List<TiendaOnlineResultItemDto> data = AsyncUtils.get(cfData);
                    if (CollectionUtils.isNotEmpty(data)) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                            meta4Properties.get(Meta4PropertiesConstants.TIENDAS_ONLINE).getFilter().getMaxPersistenceSize());
                        CompletableFuture<Void> cfSave = tareaLocalizacionOnlineHistoricoAsyncService.save(data, runTarea.getTarea());
                        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                        hasNext = request.nextPage();
                    }
                } while (hasNext);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }

    }
    
    //TODO: Revisar si no se usa borrar
    @Override
    public void estructurasDesplazamientoByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdPersonaHistoricoDto> iter : StreamUtils.partition(
                    tareaPersonaHistoricoService.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(tarea.getId(),
                            tareaAmbito.getCclIdOrigen()),
                    meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_DESPLAZ).getFilter().getMaxPageSize())) {
                ComisionEmpleadoRequestDto estructurasDesplazamientoRequest = new ComisionEmpleadoRequestDto();
                estructurasDesplazamientoRequest
                        .setPage(meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_DESPLAZ).getPage());
                estructurasDesplazamientoRequest.setData(tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea, tareaAmbito));
                estructurasDesplazamientoRequest.getData().getItem()
                        .addAll(iter.stream().map(
                                item -> GenericFilterParametersDto.builder().idEmpleado(item.getStdIdHr()).orEmpleado(item.getStdOrHrPeriod()).build())
                                .collect(Collectors.toList()));
                CompletableFuture<List<ComisionEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .getEstructurasDesplazamiento(estructurasDesplazamientoRequest);
                AsyncUtils.exceptionally(cfData, cf);
                List<ComisionEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, meta4Properties
                        .get(Meta4PropertiesConstants.ESTRUCTURAS_DESPLAZ).getFilter().getMaxPersistenceSize());
                CompletableFuture<Void> cfSave = tareaPersonaEstructuraAsyncService
                        .saveComisionEmpleadoResultItemDto(data, tarea);
                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }
    
    @Override
    public void estructurasPoliticasByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdPersonaHistoricoDto> iter : StreamUtils.partition(
                    tareaPersonaHistoricoService.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(tarea.getId(),
                            tareaAmbito.getCclIdOrigen()),
                    meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_POLITICAS).getFilter().getMaxPageSize())) {
                ComisionEmpleadoRequestDto estructurasDesplazamientoRequest = new ComisionEmpleadoRequestDto();
                estructurasDesplazamientoRequest
                        .setPage(meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_POLITICAS).getPage());
                estructurasDesplazamientoRequest.setData(tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea, tareaAmbito));
                estructurasDesplazamientoRequest.getData().getItem()
                        .addAll(iter.stream().map(
                                item -> GenericFilterParametersDto.builder().idEmpleado(item.getStdIdHr()).orEmpleado(item.getStdOrHrPeriod()).build())
                                .collect(Collectors.toList()));
                CompletableFuture<List<ComisionEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .getEstructurasPoliticas(estructurasDesplazamientoRequest);
                AsyncUtils.exceptionally(cfData, cf);
                List<ComisionEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                if (CollectionUtils.isNotEmpty(data)) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist, meta4Properties
                            .get(Meta4PropertiesConstants.ESTRUCTURAS_POLITICAS).getFilter().getMaxPersistenceSize());
                    CompletableFuture<Void> cfSave = tareaPersonaEstructuraPoliticaAsyncService.save(data, tarea);
                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                }
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }
    
    @Override
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
