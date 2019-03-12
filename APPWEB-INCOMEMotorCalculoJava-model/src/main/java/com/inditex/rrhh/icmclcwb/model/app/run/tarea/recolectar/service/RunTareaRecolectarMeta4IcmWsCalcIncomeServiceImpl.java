package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoTareaTiendaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaEmpleadoEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaEmpleadoHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaComisionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
@Validated
public class RunTareaRecolectarMeta4IcmWsCalcIncomeServiceImpl
        implements RunTareaRecolectarMeta4IcmWsCalcIncomeService {

    @Autowired
    private Logger log;

    @Autowired
    private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

    @Autowired
    private TareaTiendaHistoricoAsyncService tareaTiendaHistoricoAsyncService;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    private TareaTiendaEstadoMapper tareaTiendaEstadoMapper;

    @Autowired
    private TareaEmpleadoEstadoMapper tareaEmpleadoEstadoMapper;

    @Autowired
    private TareaTiendaComisionHistoricoMapper tareaTiendaComisionHistoricoMapper;

    @Autowired
    private TareaEmpleadoHistoricoAsyncService tareaEmpleadoHistoricoAsyncService;

    @Autowired
    private TareaEmpleadoHistoricoService tareaEmpleadoHistoricoervice;

    @Autowired
    private TareaEmpleadoEstructuraAsyncService tareaEmpleadoEstructuraAsyncService;

    @Autowired
    private TareaTiendaComisionHistoricoAsyncService tareaTiendaComisionHistoricoAsyncService;

    @Autowired
    @Qualifier("getTiendasEmpleadoDto")
    private Meta4PropertiesDto getTiendasEmpleadoDto;

    @Autowired
    @Qualifier("searchTiendasDto")
    private Meta4PropertiesDto searchTiendasDto;

    @Autowired
    @Qualifier("getTiendasDto")
    private Meta4PropertiesDto getTiendasDto;

    @Autowired
    @Qualifier("searchEmpleadosDto")
    private Meta4PropertiesDto searchEmpleadosDto;

    @Autowired
    @Qualifier("getComisionEmpleadoDto")
    private Meta4PropertiesDto getComisionEmpleadoDto;

    @Autowired
    @Qualifier("getEmpleadosDto")
    private Meta4PropertiesDto getEmpleadosDto;

    @Auditoria
    @Override
    public void tiendasHistorico(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                Set<String> tiendas = new HashSet<>();
                if (CollectionUtils.isNotEmpty(tarea.getPersona())) {
                    for (List<TareaAmbitoPersonaDto> iter : StreamUtils.partition(tarea.getPersona().stream()
                            .filter(item -> tareaAmbito.getIdOrigen().equals(item.getIdOrigen()))
                            .collect(Collectors.toList()), searchEmpleadosDto.getFilter().getMaxPageSize())) {
                        SearchEmpleadosRequestDto searchEmpleadosRequest = new SearchEmpleadosRequestDto();
                        searchEmpleadosRequest.setPage(searchEmpleadosDto.getPage());
                        searchEmpleadosRequest.setData(
                                tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo,
                                        tarea, tareaAmbito));
                        searchEmpleadosRequest.getData().getItem().addAll(iter
                                .stream().map(item -> GenericFilterParametersDto.builder()
                                        .idEmpleado(item.getIdPersona()).orEmpleado(item.getOrPersona()).build())
                                .collect(Collectors.toSet()));

                        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                        boolean hasNext = false;
                        do {
                            CompletableFuture<List<GenericEmpleadoResultItemDto>> cfDataSearchEmpleados = meta4IcmWsCalcIncomeSessionAsyncService
                                    .searchEmpleados(searchEmpleadosRequest);
                            AsyncUtils.exceptionally(cfDataSearchEmpleados, cf);
                            List<GenericEmpleadoResultItemDto> dataSearchEmpleados = cfDataSearchEmpleados.get();
                            if (CollectionUtils.isNotEmpty(dataSearchEmpleados)) {
                                AsyncUtils.checkAsyncAvaliable(cfPersist,
                                        searchEmpleadosDto.getFilter().getMaxPersistenceSize());
                                CompletableFuture<Void> cfSave = tareaEmpleadoHistoricoAsyncService
                                        .saveGenericEmpleadoResultItemDto(dataSearchEmpleados, tarea);
                                AsyncUtils.exceptionally(cfSave, cf, cfPersist);

                                dataSearchEmpleados.stream().forEach(item -> {
                                    if (StringUtils.isNotBlank(item.getIdEmpleadoLocal())) {
                                        runTareaRecolectarBloque.getEmpleadoLocal().add(item.getIdEmpleadoLocal());
                                    } else {
                                        log.error(
                                                "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdEmpleadoLocal() :: null :: {}",
                                                item);
                                    }
                                    if (StringUtils.isNotBlank(item.getIdEmpleado())
                                            && StringUtils.isNotBlank(item.getOrEmpleado())) {
                                        runTareaRecolectarBloque.getEmpleadoUniversal()
                                                .add(new StringBuilder(item.getIdEmpleado())
                                                        .append(AppConstants.SEPARATOR_DATA)
                                                        .append(item.getOrEmpleado()).toString());
                                    } else {
                                        log.error(
                                                "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdEmpleado() getOrEmpleado()  :: null :: {}",
                                                item);
                                    }
                                });

                                runTareaRecolectarBloque.getEmpleado().addAll(
                                        tareaEmpleadoEstadoMapper.genericEmpleadoResultItemDtoToTareaEmpleadoEstadoDto(
                                                dataSearchEmpleados, tarea));
                            }

                            tiendas.addAll(dataSearchEmpleados.stream()
                                    .map(GenericEmpleadoResultItemDto::getIdLugarTrabajo).collect(Collectors.toSet()));
                            hasNext = searchEmpleadosRequest.nextPage();
                        } while (hasNext);
                        if (CollectionUtils.isEmpty(tiendas)) {
                            throw new IcmclcwbException("Los empleados no tienen tiendas asociadas");
                        }
                    }
                } else if (CollectionUtils.isNotEmpty(tarea.getLocalizacion())) {
                    tiendas.addAll(tarea.getLocalizacion().stream()
                            .filter(item -> tareaAmbito.getIdOrigen().equals(item.getIdOrigen()))
                            .map(TareaAmbitoLocalizacionDto::getIdLocalizacion).collect(Collectors.toSet()));
                }

                SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
                searchTiendasRequest.setPage(searchTiendasDto.getPage());
                searchTiendasRequest.setData(tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea, tareaAmbito));
                if (CollectionUtils.isNotEmpty(tiendas)) {
                    searchTiendasRequest.getData().getItem()
                            .addAll(tiendas.stream()
                                    .map(item -> GenericFilterParametersDto.builder().idLugarTrabajo(item).build())
                                    .collect(Collectors.toList()));
                }

                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                boolean hasNext = false;
                do {
                    CompletableFuture<List<GenericTiendaResultItemDto>> cfDataSearchTiendas = meta4IcmWsCalcIncomeSessionAsyncService
                            .searchTiendas(searchTiendasRequest);
                    AsyncUtils.exceptionally(cfDataSearchTiendas, cf);
                    List<GenericTiendaResultItemDto> dataSearchTiendas = cfDataSearchTiendas.get();
                    if (CollectionUtils.isNotEmpty(dataSearchTiendas)) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist, searchTiendasDto.getFilter().getMaxPersistenceSize());
                        CompletableFuture<Void> cfSave = tareaTiendaHistoricoAsyncService
                                .saveGenericTiendaResultItemDto(dataSearchTiendas, tarea);
                        AsyncUtils.exceptionally(cfSave, cf, cfPersist);

                        dataSearchTiendas.stream().forEach(item -> {
                            if (StringUtils.isNotBlank(item.getIdLugarTrabajo())) {
                                runTareaRecolectarBloque.getTiendaMeta4().add(item.getIdLugarTrabajo());
                            } else {
                                log.error(
                                        "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdLugarTrabajo() :: null :: {}",
                                        item);
                            }
                            if (StringUtils.isNotBlank(item.getIdTiendaMtu())) {
                                runTareaRecolectarBloque.getTiendaMtu().add(item.getIdTiendaMtu());
                            } else {
                                log.error(
                                        "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdTiendaMtu() :: null :: {}",
                                        item);
                            }
                            if (StringUtils.isNotBlank(item.getIdCadena())) {
                                runTareaRecolectarBloque.getCadenaEmpresa().add(item.getIdCadena());
                            } else {
                                log.error(
                                        "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdCadena() :: null :: {}",
                                        item);
                            }
                        });

                        runTareaRecolectarBloque.getTienda()
                                .addAll(tareaTiendaEstadoMapper.genericTiendaResultItemDtoToTareaTiendaEstadoDto(
                                        dataSearchTiendas, TipoTareaTiendaEnum.INICIAL.getDto()));
                    }
                    hasNext = searchTiendasRequest.nextPage();
                } while (hasNext);

                AsyncUtils.waitAllOfIsOk(cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void tiendasPresencia(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                // TODO Falta el origen relacionado con las tiendas de las presencias
                for (List<String> iter : StreamUtils.partition(runTareaRecolectarBloque.getTiendaPresencia(),
                        searchTiendasDto.getFilter().getMaxPageSize())) {
                    SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
                    searchTiendasRequest.setPage(searchTiendasDto.getPage());
                    searchTiendasRequest
                            .setData(tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo,
                                    tarea, tareaAmbito));
                    searchTiendasRequest.getData().getItem()
                            .addAll(iter.stream()
                                    .map(item -> GenericFilterParametersDto.builder().idLugarTrabajo(item).build())
                                    .collect(Collectors.toList()));

                    boolean hasNextTienda = false;
                    do {
                        CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                                .searchTiendas(searchTiendasRequest);
                        AsyncUtils.exceptionally(cfData, cf);
                        List<GenericTiendaResultItemDto> data = cfData.get();
                        if (CollectionUtils.isNotEmpty(data)) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist,
                                    searchTiendasDto.getFilter().getMaxPersistenceSize());
                            CompletableFuture<Void> cfSave = tareaTiendaHistoricoAsyncService
                                    .saveGenericTiendaResultItemDto(data, tarea);
                            AsyncUtils.exceptionally(cfSave, cf, cfPersist);

                            data.stream().forEach(item -> {
                                if (StringUtils.isNotBlank(item.getIdLugarTrabajo())) {
                                    runTareaRecolectarBloque.getTiendaMeta4().add(item.getIdLugarTrabajo());
                                } else {
                                    log.error(
                                            "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdLugarTrabajo() :: null :: {}",
                                            item);
                                }
                                if (StringUtils.isNotBlank(item.getIdTiendaMtu())) {
                                    runTareaRecolectarBloque.getTiendaMtu().add(item.getIdTiendaMtu());
                                } else {
                                    log.error(
                                            "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdTiendaMtu() :: null :: {}",
                                            item);
                                }
                                if (StringUtils.isNotBlank(item.getIdCadena())) {
                                    runTareaRecolectarBloque.getCadenaEmpresa().add(item.getIdCadena());
                                } else {
                                    log.error(
                                            "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdCadena() :: null :: {}",
                                            item);
                                }
                            });

                            runTareaRecolectarBloque.getTienda().addAll(
                                    tareaTiendaEstadoMapper.genericTiendaResultItemDtoToTareaTiendaEstadoDto(data,
                                            TipoTareaTiendaEnum.PRESENCIA.getDto()));

                        }
                        hasNextTienda = searchTiendasRequest.nextPage();
                    } while (hasNextTienda);
                }
                AsyncUtils.waitAllOfIsOk(cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void tiendasEmpleadoHistorico(@Valid RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                if (CollectionUtils.isNotEmpty(tarea.getLocalizacion())) {
                    Set<String> tiendas = new HashSet<>();
                    for (List<GenericFilterParametersDto> iter : StreamUtils.partition(
                            tarea.getLocalizacion().stream()
                                    .filter(item -> tareaAmbito.getIdOrigen().equals(item.getIdOrigen()))
                                    .map(item -> GenericFilterParametersDto.builder()
                                            .idLugarTrabajo(item.getIdLocalizacion()).build())
                                    .collect(Collectors.toList()),
                            getTiendasEmpleadoDto.getFilter().getMaxPageSize())) {
                        TiendasEmpleadoRequestDto tiendasEmpleadoRequest = new TiendasEmpleadoRequestDto();
                        tiendasEmpleadoRequest.setPage(getTiendasEmpleadoDto.getPage());
                        tiendasEmpleadoRequest.setData(
                                tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo,
                                        tarea, tareaAmbito));
                        tiendasEmpleadoRequest.getData().getItem().addAll(iter);
                        boolean hasNext = false;
                        do {
                            CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                                    .getTiendasEmpleado(tiendasEmpleadoRequest);
                            AsyncUtils.exceptionally(cfData, cf);
                            List<GenericTiendaResultItemDto> data = cfData.get();
                            if (CollectionUtils.isNotEmpty(data)) {
                                tiendas.addAll(data.stream().map(GenericTiendaResultItemDto::getIdLugarTrabajo)
                                        .collect(Collectors.toSet()));
                            }
                            hasNext = tiendasEmpleadoRequest.nextPage();
                        } while (hasNext);

                    }

                    if (CollectionUtils.isNotEmpty(tiendas)) {
                        for (List<GenericFilterParametersDto> iterSearchTiendas : StreamUtils
                                .partition(
                                        tiendas.stream()
                                                .map(item -> GenericFilterParametersDto.builder().idLugarTrabajo(item)
                                                        .build())
                                                .collect(Collectors.toList()),
                                        searchTiendasDto.getFilter().getMaxPageSize())) {
                            SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
                            searchTiendasRequest.setPage(searchTiendasDto.getPage());
                            searchTiendasRequest.setData(
                                    tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo,
                                            tarea, tareaAmbito));
                            searchTiendasRequest.getData().getItem().addAll(iterSearchTiendas);

                            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                            boolean hasNextTienda = false;
                            do {
                                CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                                        .searchTiendas(searchTiendasRequest);
                                AsyncUtils.exceptionally(cfData, cf);
                                List<GenericTiendaResultItemDto> data = cfData.get();
                                if (CollectionUtils.isNotEmpty(data)) {
                                    AsyncUtils.checkAsyncAvaliable(cfPersist,
                                            searchTiendasDto.getFilter().getMaxPersistenceSize());
                                    CompletableFuture<Void> cfSave = tareaTiendaHistoricoAsyncService
                                            .saveGenericTiendaResultItemDto(data, tarea);
                                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);

                                    data.stream().forEach(item -> {
                                        if (StringUtils.isNotBlank(item.getIdLugarTrabajo())) {
                                            runTareaRecolectarBloque.getTiendaMeta4().add(item.getIdLugarTrabajo());
                                        } else {
                                            log.error(
                                                    "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasEmpleadoHistorico() :: GenericTiendaResultItemDto :: getIdLugarTrabajo() :: null :: {}",
                                                    item);
                                        }
                                        if (StringUtils.isNotBlank(item.getIdTiendaMtu())) {
                                            runTareaRecolectarBloque.getTiendaMtu().add(item.getIdTiendaMtu());
                                        } else {
                                            log.error(
                                                    "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasEmpleadoHistorico() :: GenericTiendaResultItemDto :: getIdTiendaMtu() :: null :: {}",
                                                    item);
                                        }
                                        if (StringUtils.isNotBlank(item.getIdCadena())) {
                                            runTareaRecolectarBloque.getCadenaEmpresa().add(item.getIdCadena());
                                        } else {
                                            log.error(
                                                    "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasEmpleadoHistorico() :: GenericTiendaResultItemDto :: getIdCadena() :: null :: {}",
                                                    item);
                                        }
                                    });

                                    runTareaRecolectarBloque.getTienda()
                                            .addAll(tareaTiendaEstadoMapper
                                                    .genericTiendaResultItemDtoToTareaTiendaEstadoDto(data,
                                                            TipoTareaTiendaEnum.HISTORICO.getDto()));
                                }
                                hasNextTienda = searchTiendasRequest.nextPage();
                            } while (hasNextTienda);

                        }
                    }
                }
                AsyncUtils.waitAllOfIsOk(cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void condicionesEmpleados(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                // TODO Falta el origen relacionado con los empleados
                for (List<String> iter : StreamUtils
                        .partition(
                                runTareaRecolectarBloque.getEmpleado().stream()
                                        .map(TareaEmpleadoEstadoDto::getIdEmpleado).collect(Collectors.toList()),
                                getComisionEmpleadoDto.getFilter().getMaxPageSize())) {
                    ComisionEmpleadoRequestDto comisionEmpleadoRequest = new ComisionEmpleadoRequestDto();
                    comisionEmpleadoRequest.setPage(getComisionEmpleadoDto.getPage());
                    comisionEmpleadoRequest
                            .setData(tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo,
                                    tarea, tareaAmbito));
                    comisionEmpleadoRequest.getData().getItem()
                            .addAll(iter.stream()
                                    .map(item -> GenericFilterParametersDto.builder().idEmpleado(item).build())
                                    .collect(Collectors.toList()));

                    CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                            .getComisionEmpleado(comisionEmpleadoRequest);
                    AsyncUtils.exceptionally(cfData, cf);
                    List<GenericEmpleadoResultItemDto> data = cfData.get();
                    AsyncUtils.checkAsyncAvaliable(cfPersist,
                            getComisionEmpleadoDto.getFilter().getMaxPersistenceSize());
                    CompletableFuture<Void> cfSave = tareaEmpleadoEstructuraAsyncService
                            .saveGenericEmpleadoResultItemDto(data, tarea);
                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                }
                AsyncUtils.waitAllOfIsOk(cf);
                // TODO Inicio :: Mock condiciones
//                Random random = new Random();
//                List<TareaEmpleadoEstructuraDto> mockDataList = new ArrayList<>();
//                runTareaRecolectarBloque.getEmpleado().stream().forEach(item -> {
//                    for (int x = 1; x < 3; x++) {
//                        for (int y = 1; y < 3; y++) {
//                            TareaEmpleadoEstructuraDto mockData = new TareaEmpleadoEstructuraDto();
//                            mockData.setFechaInicio(Date
//                                    .from(tarea.getFechaInicioPeriodo().atZone(ZoneId.systemDefault()).toInstant()));
//                            mockData.setFechaFin(
//                                    Date.from(tarea.getFechaFinPeriodo().atZone(ZoneId.systemDefault()).toInstant()));
//                            mockData.setIdEmpleado(item.getIdEmpleado());
//                            mockData.setIdEmpleadoLocal(item.getIdEmpleadoLocal());
//                            mockData.setOrEmpleado(item.getOrEmpleado());
//                            mockData.setIdEstructura(1L);
//                            mockData.setIdTipoCalculo(Long.valueOf(x));
//                            mockData.setIdTipoComision(Long.valueOf(y));
//                            mockData.setIdTarea(tarea.getId());
//                            if (random.nextInt(2) == 0) {
//                                mockData.setPorcentaje(Double.valueOf(random.nextInt(20)) + random.nextDouble());
//                                mockData.setPorcentaje1(NumberUtils.DOUBLE_ZERO);
//                                mockData.setPorcentaje2(NumberUtils.DOUBLE_ZERO);
//                                mockData.setPorcentaje3(NumberUtils.DOUBLE_ZERO);
//                            } else {
//                                mockData.setPorcentaje(NumberUtils.DOUBLE_ZERO);
//                                mockData.setPorcentaje1(Double.valueOf(random.nextInt(20)) + random.nextDouble());
//                                mockData.setPorcentaje2(Double.valueOf(random.nextInt(20)) + random.nextDouble());
//                                mockData.setPorcentaje3(Double.valueOf(random.nextInt(20)) + random.nextDouble());
//                            }
//                            mockDataList.add(mockData);
//                        }
//                    }
//                });
//                if (CollectionUtils.isNotEmpty(mockDataList)) {
//                    AsyncUtils.checkAsyncAvaliable(cfPersist,
//                            getComisionEmpleadoDto.getFilter().getMaxPersistenceSize());
//                    CompletableFuture<Void> cfSave = tareaEmpleadoEstructuraAsyncService.save(mockDataList, tarea);
//                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);
//                }
                // TODO Fin :: Mock condiciones
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void tiendasComisionable(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                // TODO Falta el origen relacionado con los empleados
                for (List<String> iter : StreamUtils.partition(runTareaRecolectarBloque.getTiendaMeta4(),
                        getTiendasDto.getFilter().getMaxPageSize())) {
                    TiendasRequestDto tiendasRequest = new TiendasRequestDto();
                    tiendasRequest.setPage(getTiendasDto.getPage());
                    tiendasRequest.setData(tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(
                            trabajo, tarea, tareaAmbito));
                    tiendasRequest.getData().getItem()
                            .addAll(iter.stream()
                                    .map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(e).build())
                                    .collect(Collectors.toList()));
                    boolean hasNext = false;
                    do {
                        CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                                .getTiendas(tiendasRequest);
                        AsyncUtils.exceptionally(cfData, cf);
                        List<GenericTiendaResultItemDto> data = cfData.get();
                        if (CollectionUtils.isNotEmpty(data)) {

                            List<TareaTiendaComisionHistoricoDto> tareaTiendaComision = tareaTiendaComisionHistoricoMapper
                                    .genericTiendaResultItemDtoToTareaTiendaComisionHistoricoDto(data, tarea);
                            if (CollectionUtils.isNotEmpty(tareaTiendaComision)) {
                                AsyncUtils.checkAsyncAvaliable(cfPersist,
                                        getTiendasDto.getFilter().getMaxPersistenceSize());
                                CompletableFuture<Void> cfSave = tareaTiendaComisionHistoricoAsyncService
                                        .save(tareaTiendaComision);
                                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                            }
                        }
                        hasNext = tiendasRequest.nextPage();
                    } while (hasNext);
                }
                AsyncUtils.waitAllOfIsOk(cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void empleadosTienda(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                if (CollectionUtils.isEmpty(tarea.getPersona())) {
                    EmpleadosRequestDto empleadosRequest = new EmpleadosRequestDto();
                    empleadosRequest.setPage(getEmpleadosDto.getPage());
                    empleadosRequest.setData(tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(
                            trabajo, tarea, tareaAmbito));
                    if (CollectionUtils.isNotEmpty(tarea.getLocalizacion())) {
                        Set<GenericFilterParametersDto> empleadosRequestItem = new HashSet<>();
                        tarea.getLocalizacion().stream()
                                .filter(item -> tareaAmbito.getIdOrigen().equals(item.getIdOrigen())).forEach(item -> {
                                    if (StringUtils.isNotBlank(item.getIdLocalizacion())) {
                                        empleadosRequestItem.add(GenericFilterParametersDto.builder()
                                                .idLugarTrabajo(item.getIdLocalizacion()).build());
                                    } else {
                                        log.warn(
                                                "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl :: meta4IcmWsCalcIncomeSessionAsyncService.getEmpleados() :: isBlank() :: {}",
                                                item);
                                    }
                                });
                        if (CollectionUtils.isNotEmpty(empleadosRequestItem)) {
                            empleadosRequest.getData().getItem().addAll(empleadosRequestItem);
                        } else {
                            throw new IcmclcwbException("Hay tiendas pero no ids");
                        }
                    }

                    Set<GenericFilterParametersDto> searchEmpleadosRequestItem = new HashSet<>();
                    boolean hasNext = false;
                    do {
                        CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                                .getEmpleados(empleadosRequest);
                        AsyncUtils.exceptionally(cfData, cf);
                        List<GenericEmpleadoResultItemDto> data = cfData.get();
                        if (CollectionUtils.isNotEmpty(data)) {
                            data.stream().forEach(item -> {
                                if (StringUtils.isNotBlank(item.getIdEmpleado())
                                        && StringUtils.isNotBlank(item.getOrEmpleado())) {
                                    searchEmpleadosRequestItem.add(GenericFilterParametersDto.builder()
                                            .idEmpleado(item.getIdEmpleado()).orEmpleado(item.getOrEmpleado()).build());
                                } else {
                                    log.warn(
                                            "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl :: meta4IcmWsCalcIncomeSessionAsyncService.getEmpleados() :: isBlank() :: {}",
                                            item);
                                }
                            });
                        }
                        hasNext = empleadosRequest.nextPage();
                    } while (hasNext);

                    List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                    if (CollectionUtils.isNotEmpty(searchEmpleadosRequestItem)) {
                        for (List<GenericFilterParametersDto> iter : StreamUtils.partition(searchEmpleadosRequestItem,
                                searchEmpleadosDto.getFilter().getMaxPageSize())) {
                            SearchEmpleadosRequestDto searchEmpleadosRequest = new SearchEmpleadosRequestDto();
                            searchEmpleadosRequest.setPage(searchEmpleadosDto.getPage());
                            searchEmpleadosRequest.setData(
                                    tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo,
                                            tarea, tareaAmbito));
                            searchEmpleadosRequest.getData().getItem().addAll(iter);
                            do {
                                CompletableFuture<List<GenericEmpleadoResultItemDto>> cfSearchEmpleados = meta4IcmWsCalcIncomeSessionAsyncService
                                        .searchEmpleados(searchEmpleadosRequest);
                                AsyncUtils.exceptionally(cfSearchEmpleados, cf);
                                List<GenericEmpleadoResultItemDto> dataSearchEmpleados = cfSearchEmpleados.get();
                                if (CollectionUtils.isNotEmpty(dataSearchEmpleados)) {
                                    AsyncUtils.checkAsyncAvaliable(cfPersist,
                                            searchEmpleadosDto.getFilter().getMaxPersistenceSize());
                                    CompletableFuture<Void> cfSave = tareaEmpleadoHistoricoAsyncService
                                            .saveGenericEmpleadoResultItemDto(dataSearchEmpleados, tarea);
                                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);

                                    dataSearchEmpleados.stream().forEach(item -> {
                                        if (StringUtils.isNotBlank(item.getIdEmpleadoLocal())) {
                                            runTareaRecolectarBloque.getEmpleadoLocal().add(item.getIdEmpleadoLocal());
                                        } else {
                                            log.error(
                                                    "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosTienda() :: GenericTiendaResultItemDto :: getIdEmpleadoLocal() :: null :: {}",
                                                    item);
                                        }
                                        if (StringUtils.isNotBlank(item.getIdEmpleado())
                                                && StringUtils.isNotBlank(item.getOrEmpleado())) {
                                            runTareaRecolectarBloque.getEmpleadoUniversal()
                                                    .add(new StringBuilder(item.getIdEmpleado())
                                                            .append(AppConstants.SEPARATOR_DATA)
                                                            .append(item.getOrEmpleado()).toString());
                                        } else {
                                            log.error(
                                                    "TareaRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosTienda() :: GenericTiendaResultItemDto :: getIdEmpleado() getOrEmpleado()  :: null :: {}",
                                                    item);
                                        }
                                    });

                                    runTareaRecolectarBloque.getEmpleado()
                                            .addAll(tareaEmpleadoEstadoMapper
                                                    .genericEmpleadoResultItemDtoToTareaEmpleadoEstadoDto(
                                                            dataSearchEmpleados, tarea));
                                }
                                hasNext = searchEmpleadosRequest.nextPage();
                            } while (hasNext);
                        }
                    }
                    AsyncUtils.waitAllOfIsOk(cf);
                }
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

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

            EmpleadosRequestDto request = new EmpleadosRequestDto();
            request.setPage(getEmpleadosDto.getPage());
            request.setData(tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndTareaAmbitoLocalizacionDtoToGenericFilterDto(trabajo,
                            tarea, tareaAmbito, tarea.getLocalizacion()));
            boolean hasNext = false;
            do {
                CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .getEmpleados(request);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, searchEmpleadosDto.getFilter().getMaxPersistenceSize());
                CompletableFuture<Void> cfSave = tareaEmpleadoHistoricoAsyncService
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
            request.setPage(searchTiendasDto.getPage());
            request.setData(tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndTareaAmbitoLocalizacionDtoToGenericFilterDto(trabajo,
                            tarea, tareaAmbito, tarea.getLocalizacion()));
            boolean hasNext = false;
            do {
                CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .searchTiendas(request);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericTiendaResultItemDto> data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, searchTiendasDto.getFilter().getMaxPersistenceSize());
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
            for (List<String> iter : StreamUtils.partition(tareaEmpleadoHistoricoervice
                    .findIdEmpleadoByIdTareaAndIdOrigen(tarea.getId(), tareaAmbito.getIdOrigen()),
                    getComisionEmpleadoDto.getFilter().getMaxPageSize())) {
                ComisionEmpleadoRequestDto comisionEmpleadoRequest = new ComisionEmpleadoRequestDto();
                comisionEmpleadoRequest.setPage(getComisionEmpleadoDto.getPage());
                comisionEmpleadoRequest.setData(tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea, tareaAmbito));
                comisionEmpleadoRequest.getData().getItem()
                        .addAll(iter.stream().map(item -> GenericFilterParametersDto.builder().idEmpleado(item).build())
                                .collect(Collectors.toList()));
                CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .getComisionEmpleado(comisionEmpleadoRequest);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, getComisionEmpleadoDto.getFilter().getMaxPersistenceSize());
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

}
