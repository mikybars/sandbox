package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.TrabajoAuditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoEmpleadoEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoEmpleadoHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoTiendaComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoTiendaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoEmpleadoEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoEmpleadoHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTiendaComisionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTiendaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl implements TrabajoRecolectarMeta4IcmWsCalcIncomeService {

    @Autowired
    private Logger log;

    @Autowired
    private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

    @Autowired
    private TrabajoTiendaHistoricoAsyncService trabajoTiendaHistoricoAsyncService;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoTiendaHistoricoMapper trabajoTiendaHistoricoMapper;

    @Autowired
    private TrabajoTiendaEstadoMapper trabajoTiendaEstadoMapper;

    @Autowired
    private TrabajoEmpleadoEstadoMapper trabajoEmpleadoEstadoMapper;

    @Autowired
    private TrabajoEmpleadoHistoricoMapper trabajoEmpleadoHistoricoMapper;

    @Autowired
    private TrabajoEmpleadoEstructuraMapper trabajoEmpleadoEstructuraMapper;

    @Autowired
    private TrabajoTiendaComisionHistoricoMapper trabajoTiendaComisionHistoricoMapper;

    @Autowired
    private TrabajoEmpleadoHistoricoAsyncService trabajoEmpleadoHistoricoAsyncService;

    @Autowired
    private TrabajoEmpleadoEstructuraAsyncService trabajoEmpleadoEstructuraAsyncService;

    @Autowired
    private TrabajoTiendaComisionHistoricoAsyncService trabajoTiendaComisionHistoricoAsyncService;

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

    @TrabajoAuditoria
    @Override
    public void tiendasHistorico(@Valid final TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            Set<String> tiendas = new HashSet<>();
            if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
                
                final AtomicInteger counter = new AtomicInteger(0);
                for (List<TrabajoEmpleadoDto> iter : trabajo.getEmpleados().stream()
                        .collect(Collectors.groupingBy(
                                item -> counter.getAndIncrement() / searchEmpleadosDto.getFilter().getMaxPageSize()))
                        .values()) {
             
                    SearchEmpleadosRequestDto searchEmpleadosRequest = new SearchEmpleadosRequestDto();
                    searchEmpleadosRequest.setPage(searchEmpleadosDto.getPage());
                    searchEmpleadosRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
                    searchEmpleadosRequest.getData().getItem()
                            .addAll(iter.stream().map(item -> GenericFilterParametersDto.builder()
                                            .idEmpleado(item.getIdEmpleado()).orEmpleado(item.getOrEmpleado()).build())
                                    .collect(Collectors.toSet()));
    
                    List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                    boolean hasNext = false;
                    do {
                        CompletableFuture<List<GenericEmpleadoResultItemDto>> cfDataSearchEmpleados = meta4IcmWsCalcIncomeSessionAsyncService
                                .searchEmpleados(searchEmpleadosRequest);
                        AsyncUtils.exceptionally(cfDataSearchEmpleados, cf);
                        List<GenericEmpleadoResultItemDto> dataSearchEmpleados = cfDataSearchEmpleados.get();
                        if (CollectionUtils.isNotEmpty(dataSearchEmpleados)) {
                            List<TrabajoEmpleadoHistoricoDto> trabajoEmpleadoHistorico = trabajoEmpleadoHistoricoMapper
                                    .genericEmpleadoResultItemDtoToTrabajoEmpleadoHistoricoDto(dataSearchEmpleados);
                            if (CollectionUtils.isNotEmpty(trabajoEmpleadoHistorico)) {
                                AsyncUtils.checkAsyncAvaliable(cfPersist,
                                        searchEmpleadosDto.getFilter().getMaxPersistenceSize());
                                CompletableFuture<Void> cfSave = trabajoEmpleadoHistoricoAsyncService
                                        .save(trabajoEmpleadoHistorico, trabajo);
                                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                            }
    
                            dataSearchEmpleados.stream().forEach(item -> {
                                if (StringUtils.isNotBlank(item.getIdEmpleadoLocal())) {
                                    runTrabajoRecolectarBloque.getEmpleadoLocal().add(item.getIdEmpleadoLocal());
                                } else {
                                    log.error(
                                            "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdEmpleadoLocal() :: null :: {}",
                                            item);
                                }
                                if (StringUtils.isNotBlank(item.getIdEmpleado())
                                        && StringUtils.isNotBlank(item.getOrEmpleado())) {
                                    runTrabajoRecolectarBloque.getEmpleadoUniversal().add(new StringBuilder(item.getIdEmpleado())
                                            .append(AppConstants.SEPARATOR_DATA).append(item.getOrEmpleado()).toString());
                                } else {
                                    log.error(
                                            "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdEmpleado() getOrEmpleado()  :: null :: {}",
                                            item);
                                }
                            });
    
                            runTrabajoRecolectarBloque.getEmpleado().addAll(trabajoEmpleadoEstadoMapper
                                    .genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(dataSearchEmpleados, trabajo));
                        }
    
                        tiendas.addAll(dataSearchEmpleados.stream().map(GenericEmpleadoResultItemDto::getIdLugarTrabajo)
                                .collect(Collectors.toSet()));
                        hasNext = searchEmpleadosRequest.nextPage();
                    } while (hasNext);
                    if (CollectionUtils.isEmpty(tiendas)) {
                        throw new ApplicationException("Los empleados no tienen tiendas asociadas");
                    }
                }
            } else if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
                tiendas.addAll(
                        trabajo.getTiendas().stream().map(TrabajoTiendaDto::getIdTienda).collect(Collectors.toSet()));
            }

            SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
            searchTiendasRequest.setPage(searchTiendasDto.getPage());
            searchTiendasRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
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
                    List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico = trabajoTiendaHistoricoMapper
                            .genericTiendaResultItemDtoToTrabajoTiendaHistoricoDto(dataSearchTiendas);
                    if (CollectionUtils.isNotEmpty(trabajoTiendaHistorico)) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist, searchTiendasDto.getFilter().getMaxPersistenceSize());
                        CompletableFuture<Void> cfSave = trabajoTiendaHistoricoAsyncService.save(trabajoTiendaHistorico,
                                trabajo);
                        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    }

                    dataSearchTiendas.stream().forEach(item -> {
                        if (StringUtils.isNotBlank(item.getIdLugarTrabajo())) {
                            runTrabajoRecolectarBloque.getTiendaMeta4().add(item.getIdLugarTrabajo());
                        } else {
                            log.error(
                                    "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdLugarTrabajo() :: null :: {}",
                                    item);
                        }
                        if (StringUtils.isNotBlank(item.getIdTiendaMtu())) {
                            runTrabajoRecolectarBloque.getTiendaMtu().add(item.getIdTiendaMtu());
                        } else {
                            log.error(
                                    "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdTiendaMtu() :: null :: {}",
                                    item);
                        }
                        if (StringUtils.isNotBlank(item.getIdCadena())) {
                            runTrabajoRecolectarBloque.getCadenaEmpresa().add(item.getIdCadena());
                        } else {
                            log.error(
                                    "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdCadena() :: null :: {}",
                                    item);
                        }
                    });

                    runTrabajoRecolectarBloque.getTienda()
                            .addAll(trabajoTiendaEstadoMapper.genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(
                                    dataSearchTiendas, AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto()));
                }
                hasNext = searchTiendasRequest.nextPage();
            } while (hasNext);

            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @TrabajoAuditoria
    @Override
    public void tiendasPresencia(@Valid final TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            final AtomicInteger counter = new AtomicInteger(0);
            for (List<String> iter : runTrabajoRecolectarBloque.getTiendaPresencia().stream()
                    .collect(Collectors.groupingBy(
                            item -> counter.getAndIncrement() / searchTiendasDto.getFilter().getMaxPageSize()))
                    .values()) {
                SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
                searchTiendasRequest.setPage(searchTiendasDto.getPage());
                searchTiendasRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
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
                        List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico = trabajoTiendaHistoricoMapper
                                .genericTiendaResultItemDtoToTrabajoTiendaHistoricoDto(data);
                        if (CollectionUtils.isNotEmpty(trabajoTiendaHistorico)) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist,
                                    searchTiendasDto.getFilter().getMaxPersistenceSize());
                            CompletableFuture<Void> cfSave = trabajoTiendaHistoricoAsyncService
                                    .save(trabajoTiendaHistorico, trabajo);
                            AsyncUtils.exceptionally(cfSave, cf, cfPersist);

                            data.stream().forEach(item -> {
                                if (StringUtils.isNotBlank(item.getIdLugarTrabajo())) {
                                    runTrabajoRecolectarBloque.getTiendaMeta4().add(item.getIdLugarTrabajo());
                                } else {
                                    log.error(
                                            "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdLugarTrabajo() :: null :: {}",
                                            item);
                                }
                                if (StringUtils.isNotBlank(item.getIdTiendaMtu())) {
                                    runTrabajoRecolectarBloque.getTiendaMtu().add(item.getIdTiendaMtu());
                                } else {
                                    log.error(
                                            "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdTiendaMtu() :: null :: {}",
                                            item);
                                }
                                if (StringUtils.isNotBlank(item.getIdCadena())) {
                                    runTrabajoRecolectarBloque.getCadenaEmpresa().add(item.getIdCadena());
                                } else {
                                    log.error(
                                            "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdCadena() :: null :: {}",
                                            item);
                                }
                            });
                            
                            runTrabajoRecolectarBloque.getTienda().addAll(
                                    trabajoTiendaEstadoMapper.genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(data,
                                            AppConstants.TipoTrabajoTiendaEnum.PRESENCIA.getDto()));
                        }
                    }
                    hasNextTienda = searchTiendasRequest.nextPage();
                } while (hasNextTienda);
            }
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @TrabajoAuditoria
    @Override
    public void tiendasEmpleadoHistorico(@Valid TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
                Set<String> tiendas = new HashSet<>();
                final AtomicInteger counter = new AtomicInteger(0);
                for (List<GenericFilterParametersDto> iter : trabajo.getTiendas().stream().map(
                        e -> GenericFilterParametersDto.builder().idLugarTrabajo(e.getIdTienda()).build())
                        .collect(Collectors.groupingBy(
                                item -> counter.getAndIncrement() / getTiendasEmpleadoDto.getFilter().getMaxPageSize()))
                        .values()) {
                    TiendasEmpleadoRequestDto tiendasEmpleadoRequest = new TiendasEmpleadoRequestDto();
                    tiendasEmpleadoRequest.setPage(getTiendasEmpleadoDto.getPage());
                    tiendasEmpleadoRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
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
                    
                    final AtomicInteger counterSearchTiendas = new AtomicInteger(0);
                    for (List<GenericFilterParametersDto> iterSearchTiendas : tiendas.stream().map(item -> GenericFilterParametersDto.builder().idLugarTrabajo(item).build())
                            .collect(Collectors
                                    .groupingBy(item -> counterSearchTiendas.getAndIncrement() / searchTiendasDto.getFilter().getMaxPageSize()))
                            .values()) {
                  
                        SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
                        searchTiendasRequest.setPage(searchTiendasDto.getPage());
                        searchTiendasRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
                        searchTiendasRequest.getData().getItem().addAll(iterSearchTiendas);

                        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                        boolean hasNextTienda = false;
                        do {
                            CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                                    .searchTiendas(searchTiendasRequest);
                            AsyncUtils.exceptionally(cfData, cf);
                            List<GenericTiendaResultItemDto> data = cfData.get();
                            if (CollectionUtils.isNotEmpty(data)) {
                                List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico = trabajoTiendaHistoricoMapper
                                        .genericTiendaResultItemDtoToTrabajoTiendaHistoricoDto(data);
                                if (CollectionUtils.isNotEmpty(trabajoTiendaHistorico)) {
                                    AsyncUtils.checkAsyncAvaliable(cfPersist,
                                            searchTiendasDto.getFilter().getMaxPersistenceSize());
                                    CompletableFuture<Void> cfSave = trabajoTiendaHistoricoAsyncService
                                            .save(trabajoTiendaHistorico, trabajo);
                                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                                }

                                data.stream().forEach(item -> {
                                    if (StringUtils.isNotBlank(item.getIdLugarTrabajo())) {
                                        runTrabajoRecolectarBloque.getTiendaMeta4().add(item.getIdLugarTrabajo());
                                    } else {
                                        log.error(
                                                "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasEmpleadoHistorico() :: GenericTiendaResultItemDto :: getIdLugarTrabajo() :: null :: {}",
                                                item);
                                    }
                                    if (StringUtils.isNotBlank(item.getIdTiendaMtu())) {
                                        runTrabajoRecolectarBloque.getTiendaMtu().add(item.getIdTiendaMtu());
                                    } else {
                                        log.error(
                                                "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasEmpleadoHistorico() :: GenericTiendaResultItemDto :: getIdTiendaMtu() :: null :: {}",
                                                item);
                                    }
                                    if (StringUtils.isNotBlank(item.getIdCadena())) {
                                        runTrabajoRecolectarBloque.getCadenaEmpresa().add(item.getIdCadena());
                                    } else {
                                        log.error(
                                                "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasEmpleadoHistorico() :: GenericTiendaResultItemDto :: getIdCadena() :: null :: {}",
                                                item);
                                    }
                                });

                                runTrabajoRecolectarBloque.getTienda()
                                        .addAll(trabajoTiendaEstadoMapper
                                                .genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(data,
                                                        AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto()));
                            }
                            hasNextTienda = searchTiendasRequest.nextPage();
                        } while (hasNextTienda);
                        
                    }
                }
            }
            AsyncUtils.waitAllOfIsOk(cf);
            
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @TrabajoAuditoria
    @Override
    public void condicionesEmpleados(@Valid final TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            final AtomicInteger counter = new AtomicInteger(0);
            for (List<String> iter : runTrabajoRecolectarBloque.getEmpleadoLocal().stream()
                    .collect(Collectors.groupingBy(
                            item -> counter.getAndIncrement() / getComisionEmpleadoDto.getFilter().getMaxPageSize()))
                    .values()) {
                ComisionEmpleadoRequestDto comisionEmpleadoRequest = new ComisionEmpleadoRequestDto();
                comisionEmpleadoRequest.setPage(getComisionEmpleadoDto.getPage());
                comisionEmpleadoRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
                comisionEmpleadoRequest.getData().getItem()
                        .addAll(iter.stream().map(item -> GenericFilterParametersDto.builder().idEmpleado(item).build())
                                .collect(Collectors.toList()));

                CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .getComisionEmpleado(comisionEmpleadoRequest);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericEmpleadoResultItemDto> data = cfData.get();
                if (CollectionUtils.isNotEmpty(data)) {
                    List<TrabajoEmpleadoEstructuraDto> trabajoEmpleadoEstructura = trabajoEmpleadoEstructuraMapper
                            .genericEmpleadoResultItemDtoToTrabajoEmpleadoEstructuraDto(data, trabajo);
                    if (CollectionUtils.isNotEmpty(trabajoEmpleadoEstructura)) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                getComisionEmpleadoDto.getFilter().getMaxPersistenceSize());
                        CompletableFuture<Void> cfSave = trabajoEmpleadoEstructuraAsyncService
                                .save(trabajoEmpleadoEstructura, trabajo);
                        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    }
                }
            }

            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }

    }

    @TrabajoAuditoria
    @Override
    public void tiendasComisionable(@Valid final TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            final AtomicInteger counter = new AtomicInteger(0);
            for (List<String> iter : runTrabajoRecolectarBloque.getTiendaMeta4().stream()
                    .collect(Collectors
                            .groupingBy(item -> counter.getAndIncrement() / getTiendasDto.getFilter().getMaxPageSize()))
                    .values()) {
                TiendasRequestDto tiendasRequest = new TiendasRequestDto();
                tiendasRequest.setPage(getTiendasDto.getPage());
                tiendasRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
                tiendasRequest.getData().getItem()
                        .addAll(iter.stream().map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(e).build())
                                .collect(Collectors.toList()));
                boolean hasNext = false;
                do {
                    CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                            .getTiendas(tiendasRequest);
                    AsyncUtils.exceptionally(cfData, cf);
                    List<GenericTiendaResultItemDto> data = cfData.get();
                    if (CollectionUtils.isNotEmpty(data)) {

                        List<TrabajoTiendaComisionHistoricoDto> trabajoTiendaComision = trabajoTiendaComisionHistoricoMapper
                                .genericTiendaResultItemDtoToTrabajoTiendaComisionHistoricoDto(data, trabajo);
                        if (CollectionUtils.isNotEmpty(trabajoTiendaComision)) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist,
                                    getTiendasDto.getFilter().getMaxPersistenceSize());
                            CompletableFuture<Void> cfSave = trabajoTiendaComisionHistoricoAsyncService
                                    .save(trabajoTiendaComision);
                            AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                        }
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

    @TrabajoAuditoria
    @Override
    public void empleadosTienda(@Valid final TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            if (CollectionUtils.isEmpty(trabajo.getEmpleados())) {
                EmpleadosRequestDto empleadosRequest = new EmpleadosRequestDto();
                empleadosRequest.setPage(getEmpleadosDto.getPage());
                empleadosRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
                if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
                    Set<GenericFilterParametersDto> empleadosRequestItem = new HashSet<>();
                    trabajo.getTiendas().stream().forEach(item -> {
                        if (StringUtils.isNotBlank(item.getIdTienda())) {
                            empleadosRequestItem.add(
                                    GenericFilterParametersDto.builder().idLugarTrabajo(item.getIdTienda()).build());
                        } else {
                            log.warn(
                                    "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl :: meta4IcmWsCalcIncomeSessionAsyncService.getEmpleados() :: isBlank() :: {}",
                                    item);
                        }
                    });
                    if (CollectionUtils.isNotEmpty(empleadosRequestItem)) {
                        empleadosRequest.getData().getItem().addAll(empleadosRequestItem);
                    } else {
                        throw new ApplicationException("Hay tiendas pero no ids");
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
                                        "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl :: meta4IcmWsCalcIncomeSessionAsyncService.searchEmpleados() :: isBlank() :: {}",
                                        item);
                            }
                        });
                    }
                    hasNext = empleadosRequest.nextPage();
                } while (hasNext);

                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                if (CollectionUtils.isNotEmpty(searchEmpleadosRequestItem)) {
                    final AtomicInteger counter = new AtomicInteger(0);
                    for (List<GenericFilterParametersDto> iter : searchEmpleadosRequestItem.stream()
                            .collect(Collectors
                                    .groupingBy(item -> counter.getAndIncrement() / searchEmpleadosDto.getFilter().getMaxPageSize()))
                            .values()) {
                    
                        SearchEmpleadosRequestDto searchEmpleadosRequest = new SearchEmpleadosRequestDto();
                        searchEmpleadosRequest.setPage(searchEmpleadosDto.getPage());
                        searchEmpleadosRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
                        searchEmpleadosRequest.getData().getItem().addAll(iter);
                        do {
                            CompletableFuture<List<GenericEmpleadoResultItemDto>> cfSearchEmpleados = meta4IcmWsCalcIncomeSessionAsyncService
                                    .searchEmpleados(searchEmpleadosRequest);
                            AsyncUtils.exceptionally(cfSearchEmpleados, cf);
                            List<GenericEmpleadoResultItemDto> dataSearchEmpleados = cfSearchEmpleados.get();
                            if (CollectionUtils.isNotEmpty(dataSearchEmpleados)) {
                                List<TrabajoEmpleadoHistoricoDto> trabajoEmpleadoHistorico = trabajoEmpleadoHistoricoMapper
                                        .genericEmpleadoResultItemDtoToTrabajoEmpleadoHistoricoDto(dataSearchEmpleados);
                                AsyncUtils.checkAsyncAvaliable(cfPersist,
                                        searchEmpleadosDto.getFilter().getMaxPersistenceSize());
                                CompletableFuture<Void> cfSave = trabajoEmpleadoHistoricoAsyncService
                                        .save(trabajoEmpleadoHistorico, trabajo);
                                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
    
                                dataSearchEmpleados.stream().forEach(item -> {
                                    if (StringUtils.isNotBlank(item.getIdEmpleadoLocal())) {
                                        runTrabajoRecolectarBloque.getEmpleadoLocal().add(item.getIdEmpleadoLocal());
                                    } else {
                                        log.error(
                                                "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosTienda() :: GenericTiendaResultItemDto :: getIdEmpleadoLocal() :: null :: {}",
                                                item);
                                    }
                                    if (StringUtils.isNotBlank(item.getIdEmpleado())
                                            && StringUtils.isNotBlank(item.getOrEmpleado())) {
                                        runTrabajoRecolectarBloque.getEmpleadoUniversal()
                                                .add(new StringBuilder(item.getIdEmpleado())
                                                        .append(AppConstants.SEPARATOR_DATA).append(item.getOrEmpleado())
                                                        .toString());
                                    } else {
                                        log.error(
                                                "TrabajoRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosTienda() :: GenericTiendaResultItemDto :: getIdEmpleado() getOrEmpleado()  :: null :: {}",
                                                item);
                                    }
                                });
    
                                runTrabajoRecolectarBloque.getEmpleado()
                                        .addAll(trabajoEmpleadoEstadoMapper
                                                .genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(dataSearchEmpleados,
                                                        trabajo));
                            }
                            hasNext = searchEmpleadosRequest.nextPage();
                        } while (hasNext);
                    }
                }
                AsyncUtils.waitAllOfIsOk(cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}