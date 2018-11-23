package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import javax.validation.Valid;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.service.Meta4IcmWsIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.poc.PocTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepository;

@Service
@Validated
public class TrabajoDatosMeta4IcmWsIncomeServiceImpl implements TrabajoDatosMeta4IcmWsIncomeService {

    @Autowired
    private Meta4IcmWsIncomeSessionAsyncService meta4SessionAsyncService;

    @Autowired
    private TrabajoEmpleadoEstadoAsyncService trabajoEmpleadoEstadoAsyncService;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoTiendaEstadoRepository trabajoTiendaEstadoRepository;

    @Autowired
    private TrabajoTiendaEstadoMapper trabajoTiendaEstadoMapper;

    @Autowired
    private PocTiendaMapper pocTiendaMapper;

    @Autowired
    private TrabajoEmpleadoEstadoMapper trabajoEmpleadoEstadoMapper;

    @Autowired
    @Qualifier("getEmpleadosTiendaDto")
    private Meta4PropertiesDto getEmpleadosTiendaDto;

    @AuditoriaTrabajo
    @Override
    public void empleadosTienda(@Valid final TrabajoDto trabajo) throws Exception {
        // TODO ¡¡ Deberíamos poder buscar por tienda/s, pais + empresa y pais !!
        // Cuando tengamos tiendas de tipo parametro se busca directamente, sino podemos
        // decidir si usar las tiendas o buscar directamente por pais/empresa

        // Request para la consulta de tiendas
        Pageable pageable = new PageRequest(0, getEmpleadosTiendaDto.getFilter().getMaxPageSize());
        Page<TrabajoTiendaEstado> tiendasPage;

        // Request para la consulta en meta4
        EmpleadosTiendaFilterDto empleadosTiendaFilter = trabajoMapper.trabajoDtotoEmpleadosTiendaFilterDto(trabajo);
        EmpleadosTiendaRequestDto empleadosTiendaRequest = new EmpleadosTiendaRequestDto();
        empleadosTiendaRequest.setPage(getEmpleadosTiendaDto.getPage());
        empleadosTiendaRequest.setData(empleadosTiendaFilter);

        List<Long> tipoTrabajoTiendaId = Stream
                .of(AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto(),
                        AppConstants.TipoTrabajoTiendaEnum.PARAMETRO.getDto(),
                        AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto())
                .map(TipoTrabajoTiendaDto::getId).collect(Collectors.toList());

        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();

        do {
            // Se recuperan las tiendas por id de trabajo y estado de forma paginada.
            tiendasPage = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoIdAndTipoIdIn(trabajo.getId(),
                    AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), tipoTrabajoTiendaId, pageable);
            if (CollectionUtils.isNotEmpty(tiendasPage.getContent())) {
                PageDto page = null;

                // Para cada tienda recuperamos y persistimos los datos de los empleados
                // asociados.
                for (TrabajoTiendaEstado tienda : tiendasPage.getContent()) {
                    empleadosTiendaRequest.getData().setIdLugarTrabajo(tienda.getIdTiendaMeta4());
                    do {
                        // Consultamos en meta4 los empleados por tienda de forma paginada.
                        CompletableFuture<List<EmpleadosTiendaResultItemDto>> cfData = meta4SessionAsyncService
                                .getEmpleadosTienda(empleadosTiendaRequest);
                        AsyncUtils.exceptionally(cfData, cf);
                        
                        List<EmpleadosTiendaResultItemDto> data = cfData.get();
                        if (CollectionUtils.isNotEmpty(data)) {
                            List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado = trabajoEmpleadoEstadoMapper
                                    .empleadosTiendaResultItemDtoToTrabajoEmpleadoEstadoDto(data, trabajo);
                            if (CollectionUtils.isNotEmpty(trabajoEmpleadoEstado)) {
                                AsyncUtils.checkAsyncAvaliable(cfPersist,
                                        getEmpleadosTiendaDto.getFilter().getMaxPersistenceSize());
                                CompletableFuture<Void> cfSave = trabajoEmpleadoEstadoAsyncService
                                        .save(trabajoEmpleadoEstado);
                                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                            }
                        }
                        page = new PageDto();
                        page.setNumeroPagina(empleadosTiendaRequest.getPage().getNumeroPagina());
                        page.setNumeroTotalPaginas(empleadosTiendaRequest.getPage().getNumeroTotalPaginas());
                        empleadosTiendaRequest.getPage()
                                .setNumeroPagina(empleadosTiendaRequest.getPage().getNumeroPagina() + 1);
                    } while (page.hasNext());
                }
            }
            pageable = tiendasPage.nextPageable();
        } while (tiendasPage.hasNext());

        AsyncUtils.waitAllOfIsOk(cf);
    }

    @AuditoriaTrabajo
    @Override
    public void tiendasParametro(@Valid final TrabajoDto trabajo) throws Exception {
        List<TrabajoTiendaEstadoDto> tienda = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
            throw new UnsupportedOperationException();
        } else if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
            CompletableFuture<List<PocTiendaDto>> cfTiendas = meta4SessionAsyncService.getTiendas(trabajo);
            tienda.addAll(pocTiendaMapper.pocTiendaDtoToTrabajoTiendaEstadoDto(cfTiendas.get()));
        } else if (StringUtils.isNotBlank(trabajo.getIdPaisOrigen())
                && StringUtils.isNotBlank(trabajo.getIdEmpresa())) {
            throw new UnsupportedOperationException();
        } else if (StringUtils.isNotBlank(trabajo.getIdPaisOrigen())) {
            throw new UnsupportedOperationException();
        }
        if (CollectionUtils.isNotEmpty(tienda)) {
            trabajoTiendaEstadoRepository.save(trabajoTiendaEstadoMapper
                    .mergeTrabajoTiendaEstadoDtoAndTrabajoDtoToTrabajoTiendaEstado(tienda, trabajo));
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @AuditoriaTrabajo
    @Override
    public void condicionesEmpleados(@Valid final TrabajoDto trabajo) throws Exception {
        Random random = new Random();
        LongStream ls = random.longs(1000, 5000);
        long time = ls.findFirst().getAsLong();
        Thread.sleep(time);
        ls.close();
    }

    @AuditoriaTrabajo
    @Override
    public void tiendasHistorico(@Valid TrabajoDto trabajo) throws Exception {
        if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
            Random random = new Random();
            LongStream ls = random.longs(1000, 5000);
            long time = ls.findFirst().getAsLong();
            ls.close();
            Thread.sleep(time);
        }
    }

}