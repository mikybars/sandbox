package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.TipoProcesoTiendaEnum;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoEmpleadoEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoEmpleadoHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoTiendaComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoTiendaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoRecolectarMeta4IcmWsCalcIncomeService;
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
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoEmpleadoEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoEmpleadoHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoMapper;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaComisionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
@Validated
public class ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl implements ProcesoRecolectarMeta4IcmWsCalcIncomeService {

    @Autowired
    private Logger log;

    @Autowired
    private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

    @Autowired
    private ProcesoTiendaHistoricoAsyncService procesoTiendaHistoricoAsyncService;

    @Autowired
    private ProcesoMapper procesoMapper;

    @Autowired
    private ProcesoTiendaHistoricoMapper procesoTiendaHistoricoMapper;

    @Autowired
    private ProcesoTiendaEstadoMapper procesoTiendaEstadoMapper;

    @Autowired
    private ProcesoEmpleadoEstadoMapper procesoEmpleadoEstadoMapper;

    @Autowired
    private ProcesoEmpleadoHistoricoMapper procesoEmpleadoHistoricoMapper;

    @Autowired
    private ProcesoEmpleadoEstructuraMapper procesoEmpleadoEstructuraMapper;

    @Autowired
    private ProcesoTiendaComisionHistoricoMapper procesoTiendaComisionHistoricoMapper;

    @Autowired
    private ProcesoEmpleadoHistoricoAsyncService procesoEmpleadoHistoricoAsyncService;

    @Autowired
    private ProcesoEmpleadoEstructuraAsyncService procesoEmpleadoEstructuraAsyncService;

    @Autowired
    private ProcesoTiendaComisionHistoricoAsyncService procesoTiendaComisionHistoricoAsyncService;

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
    public void tiendasHistorico(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            Set<String> tiendas = new HashSet<>();
            if (CollectionUtils.isNotEmpty(proceso.getEmpleados())) {
                for (List<ProcesoEmpleadoDto> iter : StreamUtils.partition(proceso.getEmpleados(),
                        searchEmpleadosDto.getFilter().getMaxPageSize())) {
                    SearchEmpleadosRequestDto searchEmpleadosRequest = new SearchEmpleadosRequestDto();
                    searchEmpleadosRequest.setPage(searchEmpleadosDto.getPage());
                    searchEmpleadosRequest.setData(procesoMapper.procesoDtoToGenericFilterDto(proceso));
                    searchEmpleadosRequest.getData().getItem()
                            .addAll(iter
                                    .stream().map(item -> GenericFilterParametersDto.builder()
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
                            List<ProcesoEmpleadoHistoricoDto> procesoEmpleadoHistorico = procesoEmpleadoHistoricoMapper
                                    .genericEmpleadoResultItemDtoToProcesoEmpleadoHistoricoDto(dataSearchEmpleados);
                            if (CollectionUtils.isNotEmpty(procesoEmpleadoHistorico)) {
                                AsyncUtils.checkAsyncAvaliable(cfPersist,
                                        searchEmpleadosDto.getFilter().getMaxPersistenceSize());
                                CompletableFuture<Void> cfSave = procesoEmpleadoHistoricoAsyncService
                                        .save(procesoEmpleadoHistorico, proceso);
                                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                            }

                            dataSearchEmpleados.stream().forEach(item -> {
                                if (StringUtils.isNotBlank(item.getIdEmpleadoLocal())) {
                                    runProcesoRecolectarBloque.getEmpleadoLocal().add(item.getIdEmpleadoLocal());
                                } else {
                                    log.error(
                                            "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdEmpleadoLocal() :: null :: {}",
                                            item);
                                }
                                if (StringUtils.isNotBlank(item.getIdEmpleado())
                                        && StringUtils.isNotBlank(item.getOrEmpleado())) {
                                    runProcesoRecolectarBloque.getEmpleadoUniversal()
                                            .add(new StringBuilder(item.getIdEmpleado())
                                                    .append(AppConstants.SEPARATOR_DATA).append(item.getOrEmpleado())
                                                    .toString());
                                } else {
                                    log.error(
                                            "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdEmpleado() getOrEmpleado()  :: null :: {}",
                                            item);
                                }
                            });

                            runProcesoRecolectarBloque.getEmpleado()
                                    .addAll(procesoEmpleadoEstadoMapper
                                            .genericEmpleadoResultItemDtoToProcesoEmpleadoEstadoDto(dataSearchEmpleados,
                                                    proceso));
                        }

                        tiendas.addAll(dataSearchEmpleados.stream().map(GenericEmpleadoResultItemDto::getIdLugarTrabajo)
                                .collect(Collectors.toSet()));
                        hasNext = searchEmpleadosRequest.nextPage();
                    } while (hasNext);
                    if (CollectionUtils.isEmpty(tiendas)) {
                        throw new IcmclcwbException("Los empleados no tienen tiendas asociadas");
                    }
                }
            } else if (CollectionUtils.isNotEmpty(proceso.getTiendas())) {
                tiendas.addAll(
                        proceso.getTiendas().stream().map(ProcesoTiendaDto::getIdTienda).collect(Collectors.toSet()));
            }

            SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
            searchTiendasRequest.setPage(searchTiendasDto.getPage());
            searchTiendasRequest.setData(procesoMapper.procesoDtoToGenericFilterDto(proceso));
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
                    List<ProcesoTiendaHistoricoDto> procesoTiendaHistorico = procesoTiendaHistoricoMapper
                            .genericTiendaResultItemDtoToProcesoTiendaHistoricoDto(dataSearchTiendas);
                    if (CollectionUtils.isNotEmpty(procesoTiendaHistorico)) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist, searchTiendasDto.getFilter().getMaxPersistenceSize());
                        CompletableFuture<Void> cfSave = procesoTiendaHistoricoAsyncService.save(procesoTiendaHistorico,
                                proceso);
                        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    }

                    dataSearchTiendas.stream().forEach(item -> {
                        if (StringUtils.isNotBlank(item.getIdLugarTrabajo())) {
                            runProcesoRecolectarBloque.getTiendaMeta4().add(item.getIdLugarTrabajo());
                        } else {
                            log.error(
                                    "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdLugarTrabajo() :: null :: {}",
                                    item);
                        }
                        if (StringUtils.isNotBlank(item.getIdTiendaMtu())) {
                            runProcesoRecolectarBloque.getTiendaMtu().add(item.getIdTiendaMtu());
                        } else {
                            log.error(
                                    "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdTiendaMtu() :: null :: {}",
                                    item);
                        }
                        if (StringUtils.isNotBlank(item.getIdCadena())) {
                            runProcesoRecolectarBloque.getCadenaEmpresa().add(item.getIdCadena());
                        } else {
                            log.error(
                                    "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdCadena() :: null :: {}",
                                    item);
                        }
                    });

                    runProcesoRecolectarBloque.getTienda()
                            .addAll(procesoTiendaEstadoMapper.genericTiendaResultItemDtoToProcesoTiendaEstadoDto(
                                    dataSearchTiendas, TipoProcesoTiendaEnum.INICIAL.getDto()));
                }
                hasNext = searchTiendasRequest.nextPage();
            } while (hasNext);

            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void tiendasPresencia(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            for (List<String> iter : StreamUtils.partition(runProcesoRecolectarBloque.getTiendaPresencia(),
                    searchTiendasDto.getFilter().getMaxPageSize())) {
                SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
                searchTiendasRequest.setPage(searchTiendasDto.getPage());
                searchTiendasRequest.setData(procesoMapper.procesoDtoToGenericFilterDto(proceso));
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
                        List<ProcesoTiendaHistoricoDto> procesoTiendaHistorico = procesoTiendaHistoricoMapper
                                .genericTiendaResultItemDtoToProcesoTiendaHistoricoDto(data);
                        if (CollectionUtils.isNotEmpty(procesoTiendaHistorico)) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist,
                                    searchTiendasDto.getFilter().getMaxPersistenceSize());
                            CompletableFuture<Void> cfSave = procesoTiendaHistoricoAsyncService
                                    .save(procesoTiendaHistorico, proceso);
                            AsyncUtils.exceptionally(cfSave, cf, cfPersist);

                            data.stream().forEach(item -> {
                                if (StringUtils.isNotBlank(item.getIdLugarTrabajo())) {
                                    runProcesoRecolectarBloque.getTiendaMeta4().add(item.getIdLugarTrabajo());
                                } else {
                                    log.error(
                                            "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdLugarTrabajo() :: null :: {}",
                                            item);
                                }
                                if (StringUtils.isNotBlank(item.getIdTiendaMtu())) {
                                    runProcesoRecolectarBloque.getTiendaMtu().add(item.getIdTiendaMtu());
                                } else {
                                    log.error(
                                            "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdTiendaMtu() :: null :: {}",
                                            item);
                                }
                                if (StringUtils.isNotBlank(item.getIdCadena())) {
                                    runProcesoRecolectarBloque.getCadenaEmpresa().add(item.getIdCadena());
                                } else {
                                    log.error(
                                            "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdCadena() :: null :: {}",
                                            item);
                                }
                            });

                            runProcesoRecolectarBloque.getTienda().addAll(
                                    procesoTiendaEstadoMapper.genericTiendaResultItemDtoToProcesoTiendaEstadoDto(data,
                                            TipoProcesoTiendaEnum.PRESENCIA.getDto()));
                        }
                    }
                    hasNextTienda = searchTiendasRequest.nextPage();
                } while (hasNextTienda);
            }
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void tiendasEmpleadoHistorico(@Valid ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            if (CollectionUtils.isNotEmpty(proceso.getTiendas())) {
                Set<String> tiendas = new HashSet<>();
                for (List<GenericFilterParametersDto> iter : StreamUtils
                        .partition(
                                proceso.getTiendas().stream()
                                        .map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(e.getIdTienda())
                                                .build())
                                        .collect(Collectors.toList()),
                                getTiendasEmpleadoDto.getFilter().getMaxPageSize())) {
                    TiendasEmpleadoRequestDto tiendasEmpleadoRequest = new TiendasEmpleadoRequestDto();
                    tiendasEmpleadoRequest.setPage(getTiendasEmpleadoDto.getPage());
                    tiendasEmpleadoRequest.setData(procesoMapper.procesoDtoToGenericFilterDto(proceso));
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
                        searchTiendasRequest.setData(procesoMapper.procesoDtoToGenericFilterDto(proceso));
                        searchTiendasRequest.getData().getItem().addAll(iterSearchTiendas);

                        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                        boolean hasNextTienda = false;
                        do {
                            CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                                    .searchTiendas(searchTiendasRequest);
                            AsyncUtils.exceptionally(cfData, cf);
                            List<GenericTiendaResultItemDto> data = cfData.get();
                            if (CollectionUtils.isNotEmpty(data)) {
                                List<ProcesoTiendaHistoricoDto> procesoTiendaHistorico = procesoTiendaHistoricoMapper
                                        .genericTiendaResultItemDtoToProcesoTiendaHistoricoDto(data);
                                if (CollectionUtils.isNotEmpty(procesoTiendaHistorico)) {
                                    AsyncUtils.checkAsyncAvaliable(cfPersist,
                                            searchTiendasDto.getFilter().getMaxPersistenceSize());
                                    CompletableFuture<Void> cfSave = procesoTiendaHistoricoAsyncService
                                            .save(procesoTiendaHistorico, proceso);
                                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                                }

                                data.stream().forEach(item -> {
                                    if (StringUtils.isNotBlank(item.getIdLugarTrabajo())) {
                                        runProcesoRecolectarBloque.getTiendaMeta4().add(item.getIdLugarTrabajo());
                                    } else {
                                        log.error(
                                                "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasEmpleadoHistorico() :: GenericTiendaResultItemDto :: getIdLugarTrabajo() :: null :: {}",
                                                item);
                                    }
                                    if (StringUtils.isNotBlank(item.getIdTiendaMtu())) {
                                        runProcesoRecolectarBloque.getTiendaMtu().add(item.getIdTiendaMtu());
                                    } else {
                                        log.error(
                                                "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasEmpleadoHistorico() :: GenericTiendaResultItemDto :: getIdTiendaMtu() :: null :: {}",
                                                item);
                                    }
                                    if (StringUtils.isNotBlank(item.getIdCadena())) {
                                        runProcesoRecolectarBloque.getCadenaEmpresa().add(item.getIdCadena());
                                    } else {
                                        log.error(
                                                "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasEmpleadoHistorico() :: GenericTiendaResultItemDto :: getIdCadena() :: null :: {}",
                                                item);
                                    }
                                });

                                runProcesoRecolectarBloque.getTienda()
                                        .addAll(procesoTiendaEstadoMapper
                                                .genericTiendaResultItemDtoToProcesoTiendaEstadoDto(data,
                                                        TipoProcesoTiendaEnum.HISTORICO.getDto()));
                            }
                            hasNextTienda = searchTiendasRequest.nextPage();
                        } while (hasNextTienda);

                    }
                }
            }
            AsyncUtils.waitAllOfIsOk(cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void condicionesEmpleados(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            for (List<String> iter : StreamUtils.partition(runProcesoRecolectarBloque.getEmpleado().stream().map(ProcesoEmpleadoEstadoDto::getIdEmpleado).collect(Collectors.toList()),
                    getComisionEmpleadoDto.getFilter().getMaxPageSize())) {
                ComisionEmpleadoRequestDto comisionEmpleadoRequest = new ComisionEmpleadoRequestDto();
                comisionEmpleadoRequest.setPage(getComisionEmpleadoDto.getPage());
                comisionEmpleadoRequest.setData(procesoMapper.procesoDtoToGenericFilterDto(proceso));
                comisionEmpleadoRequest.getData().getItem()
                        .addAll(iter.stream().map(item -> GenericFilterParametersDto.builder().idEmpleado(item).build())
                                .collect(Collectors.toList()));

                CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .getComisionEmpleado(comisionEmpleadoRequest);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericEmpleadoResultItemDto> data = cfData.get();

                if (CollectionUtils.isNotEmpty(data)) {
                    List<ProcesoEmpleadoEstructuraDto> procesoEmpleadoEstructura = procesoEmpleadoEstructuraMapper
                            .genericEmpleadoResultItemDtoToProcesoEmpleadoEstructuraDto(data, proceso);
                    if (CollectionUtils.isNotEmpty(procesoEmpleadoEstructura)) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                getComisionEmpleadoDto.getFilter().getMaxPersistenceSize());
                        CompletableFuture<Void> cfSave = procesoEmpleadoEstructuraAsyncService
                                .save(procesoEmpleadoEstructura, proceso);
                        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    }
                }
            }
            AsyncUtils.waitAllOfIsOk(cf);
            // TODO Inicio :: Mock condiciones
//            Random random = new Random();
//            List<ProcesoEmpleadoEstructuraDto> mockDataList = new ArrayList<>();
//            runProcesoRecolectarBloque.getEmpleado().stream().forEach(item -> {
//                for (int x = 1; x < 3; x++) {
//                    for (int y = 1; y < 3; y++) {
//                        ProcesoEmpleadoEstructuraDto mockData = new ProcesoEmpleadoEstructuraDto();
//                        mockData.setFechaInicio(
//                                Date.from(proceso.getFechaInicioPeriodo().atZone(ZoneId.systemDefault()).toInstant()));
//                        mockData.setFechaFin(
//                                Date.from(proceso.getFechaFinPeriodo().atZone(ZoneId.systemDefault()).toInstant()));
//                        mockData.setIdEmpleado(item.getIdEmpleado());
//                        mockData.setIdEmpleadoLocal(item.getIdEmpleadoLocal());
//                        mockData.setOrEmpleado(item.getOrEmpleado());
//                        mockData.setIdEstructura(1L);
//                        mockData.setIdTipoCalculo(Long.valueOf(x));
//                        mockData.setIdTipoComision(Long.valueOf(y));
//                        mockData.setIdProceso(proceso.getId());
//                        if (random.nextInt(2) == 0) {
//                            mockData.setPorcentaje(Double.valueOf(random.nextInt(20)) + random.nextDouble());
//                            mockData.setPorcentaje1(NumberUtils.DOUBLE_ZERO);
//                            mockData.setPorcentaje2(NumberUtils.DOUBLE_ZERO);
//                            mockData.setPorcentaje3(NumberUtils.DOUBLE_ZERO);
//                        } else {
//                            mockData.setPorcentaje(NumberUtils.DOUBLE_ZERO);
//                            mockData.setPorcentaje1(Double.valueOf(random.nextInt(20)) + random.nextDouble());
//                            mockData.setPorcentaje2(Double.valueOf(random.nextInt(20)) + random.nextDouble());
//                            mockData.setPorcentaje3(Double.valueOf(random.nextInt(20)) + random.nextDouble());
//                        }
//                        mockDataList.add(mockData);
//                    }
//                }
//            });
//            if (CollectionUtils.isNotEmpty(mockDataList)) {
//                AsyncUtils.checkAsyncAvaliable(cfPersist, getComisionEmpleadoDto.getFilter().getMaxPersistenceSize());
//                CompletableFuture<Void> cfSave = procesoEmpleadoEstructuraAsyncService.save(mockDataList, proceso);
//                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
//            }
            // TODO Fin :: Mock condiciones
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void tiendasComisionable(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            for (List<String> iter : StreamUtils.partition(runProcesoRecolectarBloque.getTiendaMeta4(),
                    getTiendasDto.getFilter().getMaxPageSize())) {
                TiendasRequestDto tiendasRequest = new TiendasRequestDto();
                tiendasRequest.setPage(getTiendasDto.getPage());
                tiendasRequest.setData(procesoMapper.procesoDtoToGenericFilterDto(proceso));
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

                        List<ProcesoTiendaComisionHistoricoDto> procesoTiendaComision = procesoTiendaComisionHistoricoMapper
                                .genericTiendaResultItemDtoToProcesoTiendaComisionHistoricoDto(data, proceso);
                        if (CollectionUtils.isNotEmpty(procesoTiendaComision)) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist,
                                    getTiendasDto.getFilter().getMaxPersistenceSize());
                            CompletableFuture<Void> cfSave = procesoTiendaComisionHistoricoAsyncService
                                    .save(procesoTiendaComision);
                            AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                        }
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

    @Auditoria
    @Override
    public void empleadosTienda(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            if (CollectionUtils.isEmpty(proceso.getEmpleados())) {
                EmpleadosRequestDto empleadosRequest = new EmpleadosRequestDto();
                empleadosRequest.setPage(getEmpleadosDto.getPage());
                empleadosRequest.setData(procesoMapper.procesoDtoToGenericFilterDto(proceso));
                if (CollectionUtils.isNotEmpty(proceso.getTiendas())) {
                    Set<GenericFilterParametersDto> empleadosRequestItem = new HashSet<>();
                    proceso.getTiendas().stream().forEach(item -> {
                        if (StringUtils.isNotBlank(item.getIdTienda())) {
                            empleadosRequestItem.add(
                                    GenericFilterParametersDto.builder().idLugarTrabajo(item.getIdTienda()).build());
                        } else {
                            log.warn(
                                    "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl :: meta4IcmWsCalcIncomeSessionAsyncService.getEmpleados() :: isBlank() :: {}",
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
                                        "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl :: meta4IcmWsCalcIncomeSessionAsyncService.searchEmpleados() :: isBlank() :: {}",
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
                        searchEmpleadosRequest.setData(procesoMapper.procesoDtoToGenericFilterDto(proceso));
                        searchEmpleadosRequest.getData().getItem().addAll(iter);
                        do {
                            CompletableFuture<List<GenericEmpleadoResultItemDto>> cfSearchEmpleados = meta4IcmWsCalcIncomeSessionAsyncService
                                    .searchEmpleados(searchEmpleadosRequest);
                            AsyncUtils.exceptionally(cfSearchEmpleados, cf);
                            List<GenericEmpleadoResultItemDto> dataSearchEmpleados = cfSearchEmpleados.get();
                            if (CollectionUtils.isNotEmpty(dataSearchEmpleados)) {
                                List<ProcesoEmpleadoHistoricoDto> procesoEmpleadoHistorico = procesoEmpleadoHistoricoMapper
                                        .genericEmpleadoResultItemDtoToProcesoEmpleadoHistoricoDto(dataSearchEmpleados);
                                AsyncUtils.checkAsyncAvaliable(cfPersist,
                                        searchEmpleadosDto.getFilter().getMaxPersistenceSize());
                                CompletableFuture<Void> cfSave = procesoEmpleadoHistoricoAsyncService
                                        .save(procesoEmpleadoHistorico, proceso);
                                AsyncUtils.exceptionally(cfSave, cf, cfPersist);

                                dataSearchEmpleados.stream().forEach(item -> {
                                    if (StringUtils.isNotBlank(item.getIdEmpleadoLocal())) {
                                        runProcesoRecolectarBloque.getEmpleadoLocal().add(item.getIdEmpleadoLocal());
                                    } else {
                                        log.error(
                                                "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosTienda() :: GenericTiendaResultItemDto :: getIdEmpleadoLocal() :: null :: {}",
                                                item);
                                    }
                                    if (StringUtils.isNotBlank(item.getIdEmpleado())
                                            && StringUtils.isNotBlank(item.getOrEmpleado())) {
                                        runProcesoRecolectarBloque.getEmpleadoUniversal()
                                                .add(new StringBuilder(item.getIdEmpleado())
                                                        .append(AppConstants.SEPARATOR_DATA)
                                                        .append(item.getOrEmpleado()).toString());
                                    } else {
                                        log.error(
                                                "ProcesoRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosTienda() :: GenericTiendaResultItemDto :: getIdEmpleado() getOrEmpleado()  :: null :: {}",
                                                item);
                                    }
                                });

                                runProcesoRecolectarBloque.getEmpleado()
                                        .addAll(procesoEmpleadoEstadoMapper
                                                .genericEmpleadoResultItemDtoToProcesoEmpleadoEstadoDto(
                                                        dataSearchEmpleados, proceso));
                            }
                            hasNext = searchEmpleadosRequest.nextPage();
                        } while (hasNext);
                    }
                }
                AsyncUtils.waitAllOfIsOk(cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

}