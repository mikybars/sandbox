package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

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
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoCustomRepository;

@Service
@Validated
public class TrabajoDatosMeta4IcmWsCalcIncomeServiceImpl implements TrabajoDatosMeta4IcmWsCalcIncomeService {

    @Autowired
    private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

    @Autowired
    private TrabajoTiendaEstadoAsyncService trabajoTiendaEstadoAsyncService;
    
    @Autowired
    private TrabajoEmpleadoEstadoAsyncService trabajoEmpleadoEstadoAsyncService;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoTiendaEstadoMapper trabajotiendaEstadoMapper;
    
    @Autowired
    private TrabajoEmpleadoEstadoMapper trabajoEmpleadoEstadoMapper;

    @Autowired
    private TrabajoTiendaEstadoCustomRepository trabajoTiendaEstadoCustomRepository;
    
    @Autowired
    private TrabajoEmpleadoEstadoRepository trabajoEmpleadoEstadoRepository; 

    @Autowired
    @Qualifier("getTiendasEmpleadoDto")
    private Meta4PropertiesDto getTiendasEmpleadoDto;
    
    @Autowired
    @Qualifier("getComisionEmpleadoDto")
    private Meta4PropertiesDto getComisionEmpleadoDto;


    @AuditoriaTrabajo
    @Override
    public void tiendasEmpleado(@Valid final TrabajoDto trabajo) throws Exception {

        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            trabajo.getTrabajoRunDatos().setTiendasPresenciaNuevas(trabajoTiendaEstadoCustomRepository
                    .customFindByIdTiendaNotExists(trabajo.getTrabajoRunDatos().getTiendasPresencia()));
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            GenericFilterDto filter = trabajoMapper.trabajoDtoToGenericFilterDto(trabajo);
            List<Integer> tiendas = trabajo.getTrabajoRunDatos().getTiendasPresenciaNuevas();
            filter.setItems(tiendas.stream().map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(String.valueOf(e)).build())
            		.collect(Collectors.toList()));
            TiendasEmpleadoRequestDto tiendasEmpleadoRequest = new TiendasEmpleadoRequestDto();
            tiendasEmpleadoRequest.setPage(getTiendasEmpleadoDto.getPage());
            tiendasEmpleadoRequest.setData(filter);
            boolean hasNext = false;
            do {
                // Consultamos en meta4 los empleados por tienda de forma paginada.
                CompletableFuture<List<TiendasEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .getTiendasEmpleado(tiendasEmpleadoRequest);
                AsyncUtils.exceptionally(cfData, cf);

                List<TiendasEmpleadoResultItemDto> data = cfData.get();
                if (CollectionUtils.isNotEmpty(data)) {
                    /*-------------------------------------------------------------*/
                    trabajo.getTrabajoRunDatosAuditoria().setTiendasPresencia(
                            trabajo.getTrabajoRunDatosAuditoria().getTiendasPresencia() + data.size());
                    /*-------------------------------------------------------------*/
                    List<TrabajoTiendaEstadoDto> trabajoEmpleadoEstado = trabajotiendaEstadoMapper
                            .tiendasEmpleadoResultItemDtoToTrabajoTiendaEstadoDto(data);
                    if (CollectionUtils.isNotEmpty(trabajoEmpleadoEstado)) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                getTiendasEmpleadoDto.getFilter().getMaxPersistenceSize());
                        CompletableFuture<Void> cfSave = trabajoTiendaEstadoAsyncService.save(trabajoEmpleadoEstado,
                                trabajo);
                        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    }
                }
                hasNext = tiendasEmpleadoRequest.nextPage();
            } while (hasNext);

            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }

    }
    
    @AuditoriaTrabajo
    @Override
    public void condicionesEmpleados(@Valid final TrabajoDto trabajo) throws Exception {
    	 List<CompletableFuture<?>> cf = new ArrayList<>();
         try {
             // TODO ¡¡ Deberíamos poder buscar por tienda/s, pais + empresa y pais !!
             // Cuando tengamos tiendas de tipo parametro se busca directamente, sino podemos
             // decidir si usar las tiendas o buscar directamente por pais/empresa

             List<CompletableFuture<?>> cfPersist = new ArrayList<>();

             // Request para la consulta de tiendas
             Pageable pageable = new PageRequest(0, getComisionEmpleadoDto.getFilter().getMaxPageSize());
             Page<TrabajoEmpleadoEstado> empleadosPage;

             // Request para la consulta en meta4
             GenericFilterDto comisionEmpleadoFilter = trabajoMapper
                     .trabajoDtoToGenericFilterDto(trabajo);
             ComisionEmpleadoRequestDto comisionEmpleadoRequest = new ComisionEmpleadoRequestDto();
             comisionEmpleadoRequest.setPage(getTiendasEmpleadoDto.getPage());
             comisionEmpleadoRequest.setData(comisionEmpleadoFilter);

             do {
                 // Se recuperan los empleados.
                 empleadosPage = trabajoEmpleadoEstadoRepository.findByTrabajoIdAndEstadoId(trabajo.getId(),
                         AppConstants.EstadoTrabajoEmpleadoEnum.PENDIENTE.getId(),  pageable);
                 if (CollectionUtils.isNotEmpty(empleadosPage.getContent())) {
                     boolean hasNext = false;
                     do {
                         // Consultamos en meta4 los empleados comisionables
                         CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                                 .getComisionEmpleado(comisionEmpleadoRequest);
                         AsyncUtils.exceptionally(cfData, cf);

                         List<GenericEmpleadoResultItemDto> data = cfData.get();
                         if (CollectionUtils.isNotEmpty(data)) {
                             /*-------------------------------------------------------------*/
                             trabajo.getTrabajoRunDatosAuditoria().setEmpleados(
                                     trabajo.getTrabajoRunDatosAuditoria().getEmpleados() + data.size());
                             /*-------------------------------------------------------------*/
                             List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado = trabajoEmpleadoEstadoMapper
                                     .genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(data, trabajo);
                             if (CollectionUtils.isNotEmpty(trabajoEmpleadoEstado)) {
                                 AsyncUtils.checkAsyncAvaliable(cfPersist,
                                		 getComisionEmpleadoDto.getFilter().getMaxPersistenceSize());
                                 CompletableFuture<Void> cfSave = trabajoEmpleadoEstadoAsyncService
                                         .save(trabajoEmpleadoEstado);
                                 AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                             }
                         }
                         hasNext = comisionEmpleadoRequest.nextPage();
                     } while (hasNext);
                 }
                 pageable = empleadosPage.nextPageable();
             } while (empleadosPage.hasNext());

             AsyncUtils.waitAllOfIsOk(cf);
         } catch (Exception e) {
             AsyncUtils.cancel(cf);
             throw e;
         }
    	
    }
    
    @AuditoriaTrabajo
    @Override
    public void searchTiendas(@Valid final TrabajoDto trabajo) throws Exception {

        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            trabajo.getTrabajoRunDatos().setTiendasPresenciaNuevas(trabajoTiendaEstadoCustomRepository
                    .customFindByIdTiendaNotExists(trabajo.getTrabajoRunDatos().getTiendasPresencia()));
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            GenericFilterDto filter = trabajoMapper.trabajoDtoToGenericFilterDto(trabajo);

            if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
                filter.setItems(trabajo.getEmpleados().stream().map(e -> GenericFilterParametersDto.builder().idEmpleado(String.valueOf(e)).build())
                		.collect(Collectors.toList()));
            } else if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
                filter.setItems(trabajo.getTiendas().stream().map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(String.valueOf(e)).build())
                		.collect(Collectors.toList()));
            } else if (StringUtils.isNotBlank(trabajo.getIdPaisOrigen())
                    && StringUtils.isNotBlank(trabajo.getIdEmpresa())) {
            	filter.setItems(new ArrayList<>());
            } else if (StringUtils.isNotBlank(trabajo.getIdPaisOrigen())) {
            	filter.setItems(new ArrayList<>());
            }
            
            SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
            searchTiendasRequest.setPage(getTiendasEmpleadoDto.getPage());
            searchTiendasRequest.setData(filter);
            boolean hasNext = false;
            do {
                // Consultamos en meta4 los empleados por tienda de forma paginada.
                CompletableFuture<List<SearchTiendasResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .searchTiendas(searchTiendasRequest);
                AsyncUtils.exceptionally(cfData, cf);

                List<SearchTiendasResultItemDto> data = cfData.get();
                if (CollectionUtils.isNotEmpty(data)) {
                    /*-------------------------------------------------------------*/
                    trabajo.getTrabajoRunDatosAuditoria().setTiendasPresencia(
                            trabajo.getTrabajoRunDatosAuditoria().getTiendasPresencia() + data.size());
                    /*-------------------------------------------------------------*/
                    List<TrabajoTiendaEstadoDto> trabajoEmpleadoEstado = trabajotiendaEstadoMapper
                            .searchTiendasResultItemDtoToTrabajoTiendaEstadoDto(data);
                    if (CollectionUtils.isNotEmpty(trabajoEmpleadoEstado)) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                getTiendasEmpleadoDto.getFilter().getMaxPersistenceSize());
                        CompletableFuture<Void> cfSave = trabajoTiendaEstadoAsyncService.save(trabajoEmpleadoEstado,
                                trabajo);
                        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    }
                }
                hasNext = searchTiendasRequest.nextPage();
            } while (hasNext);

            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }

    }
    
}