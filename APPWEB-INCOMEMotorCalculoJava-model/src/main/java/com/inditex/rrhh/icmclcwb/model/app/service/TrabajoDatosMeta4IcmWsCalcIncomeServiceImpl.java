package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
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
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepositoryCustom;

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
    private TrabajoTiendaEstadoRepositoryCustom trabajoTiendaEstadoRepositoryCustom;
    
    @Autowired
    private TrabajoTiendaEstadoRepository trabajoTiendaEstadoRepository;
    
    @Autowired
    private TrabajoEmpleadoEstadoRepository trabajoEmpleadoEstadoRepository; 

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

    @AuditoriaTrabajo
    @Override
    public void tiendasParametro(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception {
        if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
            searchEmpleados(trabajo, trabajoRunDatos);
        } else if (CollectionUtils.isNotEmpty(trabajo.getTiendas()) || StringUtils.isNotBlank(trabajo.getIdPaisOrigen())
                && StringUtils.isNotBlank(trabajo.getIdEmpresa()) || StringUtils.isNotBlank(trabajo.getIdPaisOrigen())) {
            searchTiendas(trabajo, trabajoRunDatos);
        } 
    }
    
    @AuditoriaTrabajo
    @Override
    public void tiendasHistorico(@Valid TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception {
        tiendasEmpleado(trabajo, trabajoRunDatos);
        tiendas(trabajo, trabajoRunDatos);
    }
    
    @AuditoriaTrabajo
    @Override
    public void tiendasEmpleado(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception {

        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            trabajoRunDatos.setTiendasPresenciaNuevas(trabajoTiendaEstadoRepositoryCustom
                    .customFindByIdTiendaNotExists(trabajoRunDatos.getTiendasPresencia()));
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            GenericFilterDto filter = trabajoMapper.trabajoDtoToGenericFilterDto(trabajo);
            filter.setItem(trabajo.getEmpleados().stream().map(e -> GenericFilterParametersDto.builder().idEmpleado(e.getIdEmpleado()).build())
                    .collect(Collectors.toList()));
            TiendasEmpleadoRequestDto tiendasEmpleadoRequest = new TiendasEmpleadoRequestDto();
            tiendasEmpleadoRequest.setPage(getTiendasEmpleadoDto.getPage());
            tiendasEmpleadoRequest.setData(filter);
            
            Pageable pageable = new PageRequest(0, getTiendasEmpleadoDto.getFilter().getMaxPageSize());

            List<Long> tipoTrabajoTiendaId = Stream
                    .of(AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto(),
                            AppConstants.TipoTrabajoTiendaEnum.PARAMETRO.getDto(),
                            AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto())
                    .map(TipoTrabajoTiendaDto::getId).collect(Collectors.toList());
            
            Page<TrabajoTiendaEstado> tiendasPage;
          
            do {
                tiendasPage = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoIdAndTipoIdIn(trabajo.getId(),
                        AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), tipoTrabajoTiendaId, pageable);
                
                List<Long> tiendasParametro = tiendasPage.getContent().stream().map(TrabajoTiendaEstado::getId).collect(Collectors.toList());
                
                if (CollectionUtils.isNotEmpty(tiendasPage.getContent())) {
                    
                    boolean hasNext = false;

                    do {
                        // Consultamos en meta4 los empleados por tienda de forma paginada.
                        CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                                .getTiendasEmpleado(tiendasEmpleadoRequest);
                        AsyncUtils.exceptionally(cfData, cf);
                        List<GenericTiendaResultItemDto> data = cfData.get();
                        
                        if (CollectionUtils.isNotEmpty(data)) {
                            List<TrabajoTiendaEstadoDto> trabajoTiendaEstado = trabajotiendaEstadoMapper
                                    .genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(data);
                            if (CollectionUtils.isNotEmpty(trabajoTiendaEstado)) {
                                AsyncUtils.checkAsyncAvaliable(cfPersist,
                                        getTiendasEmpleadoDto.getFilter().getMaxPersistenceSize());
                                CompletableFuture<Void> cfSave = trabajoTiendaEstadoAsyncService.save(trabajoTiendaEstado,
                                        trabajo);
                                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                            }
                        }

                        filter.setItem(data.stream().map(e -> GenericFilterParametersDto.builder().idLugarTrabajo("T" + e.getIdLugarTrabajo()).build())
                                .collect(Collectors.toList()));
                  
                        TiendasRequestDto tiendasRequest = new TiendasRequestDto();
                        tiendasRequest.setPage(getTiendasEmpleadoDto.getPage());
                        tiendasRequest.setData(filter);
                        // TODO Pendiente revision Soap vs Java
                        CompletableFuture<List<GenericTiendaResultItemDto>> cfDataTiendas = meta4IcmWsCalcIncomeSessionAsyncService
                                .getTiendas(tiendasRequest);
                        AsyncUtils.exceptionally(cfData, cf);
                        List<GenericTiendaResultItemDto> dataTC = cfDataTiendas.get();
                        
                        if (CollectionUtils.isNotEmpty(dataTC)) {
                            List<TrabajoTiendaEstadoDto> trabajoTiendaEstado = trabajotiendaEstadoMapper
                                    .genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(dataTC);
                            if (CollectionUtils.isNotEmpty(trabajoTiendaEstado)) {
                                AsyncUtils.checkAsyncAvaliable(cfPersist,
                                        getTiendasEmpleadoDto.getFilter().getMaxPersistenceSize());
                                CompletableFuture<Void> cfSave = trabajoTiendaEstadoAsyncService.save(trabajoTiendaEstado,
                                        trabajo);
                                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                            }
                        }
                        hasNext = tiendasEmpleadoRequest.nextPage();
                    } while (hasNext);
                }
                pageable = tiendasPage.nextPageable();
            } while (tiendasPage.hasNext());

            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }

    }
    
    @AuditoriaTrabajo
    @Override
    public void condicionesEmpleados(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception {
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
                     // Consultamos en meta4 los empleados comisionables
                     CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                             .getComisionEmpleado(comisionEmpleadoRequest);
                     AsyncUtils.exceptionally(cfData, cf);

                     List<GenericEmpleadoResultItemDto> data = cfData.get();
                     if (CollectionUtils.isNotEmpty(data)) {
                         List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado = trabajoEmpleadoEstadoMapper
                                 .genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(data, trabajo);
                         if (CollectionUtils.isNotEmpty(trabajoEmpleadoEstado)) {
//                             AsyncUtils.checkAsyncAvaliable(cfPersist,
//                            		 getComisionEmpleadoDto.getFilter().getMaxPersistenceSize());
//                             CompletableFuture<Void> cfSave = trabajoEmpleadoEstadoAsyncService
//                                     .save(trabajoEmpleadoEstado);
//                             AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                         }
                     }
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
    public void searchTiendas(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception {

        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            
            trabajoRunDatos.setTiendasPresenciaNuevas(trabajoTiendaEstadoRepositoryCustom
                    .customFindByIdTiendaNotExists(trabajoRunDatos.getTiendasPresencia()));
           
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            GenericFilterDto filter = trabajoMapper.trabajoDtoToGenericFilterDto(trabajo);

            if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
                filter.setItem(trabajo.getTiendas().stream().map(e -> GenericFilterParametersDto.builder().idLugarTrabajo("T" + e.getIdTienda()).build())
                        .collect(Collectors.toList()));
            } else if (StringUtils.isNotBlank(trabajo.getIdPaisOrigen())
                    && StringUtils.isNotBlank(trabajo.getIdEmpresa())) {
                filter.setItem(new ArrayList<>());
            } else if (StringUtils.isNotBlank(trabajo.getIdPaisOrigen())) {
                filter.setItem(new ArrayList<>());
            }
            
            SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
            searchTiendasRequest.setPage(searchTiendasDto.getPage());
            searchTiendasRequest.setData(filter);
            
            TiendasRequestDto tiendasRequest = new TiendasRequestDto();
            tiendasRequest.setPage(getTiendasDto.getPage());
            tiendasRequest.setData(filter);
            
            boolean hasNext = false;
            do {
                // Consultamos en meta4 los empleados por tienda de forma paginada.
                CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .searchTiendas(searchTiendasRequest);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericTiendaResultItemDto> dataTiendas = cfData.get();
                
                CompletableFuture<List<GenericTiendaResultItemDto>> cfDataTC = meta4IcmWsCalcIncomeSessionAsyncService
                        .getTiendas(tiendasRequest);
                AsyncUtils.exceptionally(cfData, cf);
                List<GenericTiendaResultItemDto> dataTiendasComisionables = cfDataTC.get();

                if (CollectionUtils.isNotEmpty(dataTiendasComisionables) && CollectionUtils.isNotEmpty(dataTiendas)) {
                    
                    dataTiendas.stream()
                            .filter(p1 -> dataTiendas.stream()
                            .anyMatch(p2 -> p1.getIdTiendaMtu().equals(p2.getIdTiendaMtu()) && !p2.isEsComisionable()))
                            .forEach(dataTiendas::remove);
                    
                    List<TrabajoTiendaEstadoDto> trabajoTiendaEstado = trabajotiendaEstadoMapper
                            .genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(dataTiendas);
                    if (CollectionUtils.isNotEmpty(trabajoTiendaEstado)) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                getTiendasEmpleadoDto.getFilter().getMaxPersistenceSize());
                        CompletableFuture<Void> cfSave = trabajoTiendaEstadoAsyncService.save(trabajoTiendaEstado,
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
    
    
    @Override
    public void tiendas(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception {

        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            GenericFilterDto filter = trabajoMapper.trabajoDtoToGenericFilterDto(trabajo);

            if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
                filter.setItem(trabajo.getEmpleados().stream().map(e -> GenericFilterParametersDto.builder().idEmpleado(e.getIdEmpleado()).build())
                        .collect(Collectors.toList()));
            } else if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
                filter.setItem(trabajo.getTiendas().stream().map(e -> GenericFilterParametersDto.builder().idLugarTrabajo("T" + e.getIdTienda()).build())
                        .collect(Collectors.toList()));
            } else if (StringUtils.isNotBlank(trabajo.getIdPaisOrigen())
                    && StringUtils.isNotBlank(trabajo.getIdEmpresa())) {
                filter.setItem(new ArrayList<>());
            } else if (StringUtils.isNotBlank(trabajo.getIdPaisOrigen())) {
                filter.setItem(new ArrayList<>());
            }
            
            TiendasRequestDto tiendasRequest = new TiendasRequestDto();
            tiendasRequest.setPage(getTiendasEmpleadoDto.getPage());
            tiendasRequest.setData(filter);
            boolean hasNext = false;
            do {
                // Consultamos en meta4 los empleados por tienda de forma paginada.
                CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .getTiendas(tiendasRequest);
                AsyncUtils.exceptionally(cfData, cf);

                List<GenericTiendaResultItemDto> data = cfData.get();
                if (CollectionUtils.isNotEmpty(data)) {
                    List<TrabajoTiendaEstadoDto> trabajoTiendaEstado = trabajotiendaEstadoMapper
                            .genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(data);
                    if (CollectionUtils.isNotEmpty(trabajoTiendaEstado)) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                getTiendasEmpleadoDto.getFilter().getMaxPersistenceSize());
                        CompletableFuture<Void> cfSave = trabajoTiendaEstadoAsyncService.save(trabajoTiendaEstado,
                                trabajo);
                        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    }
                }
                hasNext = tiendasRequest.nextPage();
            } while (hasNext);

            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }
    
    @AuditoriaTrabajo
    public void searchEmpleados(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception {

        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            trabajoRunDatos.setTiendasPresenciaNuevas(trabajoTiendaEstadoRepositoryCustom
                    .customFindByIdTiendaNotExists(trabajoRunDatos.getTiendasPresencia()));
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            GenericFilterDto filter = trabajoMapper.trabajoDtoToGenericFilterDto(trabajo);

            if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
                filter.setIdEmpresa(null);
                filter.setIdOrigen(null);
                filter.setItem(trabajo.getEmpleados().stream().map(e -> GenericFilterParametersDto.builder().idEmpleado(e.getIdEmpleado()).build())
                        .collect(Collectors.toList()));
            }
            
            SearchEmpleadosRequestDto searchEmpleadosRequest = new SearchEmpleadosRequestDto();
            //TODO: Cambiar esto
            searchEmpleadosRequest.setPage(getTiendasEmpleadoDto.getPage());
            searchEmpleadosRequest.setData(filter);
            
            SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
            //TODO: Cambiar esto
            searchTiendasRequest.setPage(getTiendasEmpleadoDto.getPage());
            searchTiendasRequest.setData(filter);
            
            TiendasRequestDto tiendasRequest = new TiendasRequestDto();
            //TODO: Cambiar esto
            tiendasRequest.setPage(getTiendasEmpleadoDto.getPage());
            tiendasRequest.setData(filter);

            boolean hasNext = false;
            do {
                // Consultamos en meta4 los empleados por tienda de forma paginada.
                CompletableFuture<List<GenericEmpleadoResultItemDto>> cfDataEmpleados = meta4IcmWsCalcIncomeSessionAsyncService
                        .searchEmpleados(searchEmpleadosRequest);
                AsyncUtils.exceptionally(cfDataEmpleados, cf);

                List<GenericEmpleadoResultItemDto> dataE = cfDataEmpleados.get();
                
                filter.setItem(dataE.stream().map(e -> GenericFilterParametersDto.builder().idEmpleado(e.getIdEmpleado()).build())
                        .collect(Collectors.toList()));
                
                CompletableFuture<List<GenericTiendaResultItemDto>> cfDataTiendas = meta4IcmWsCalcIncomeSessionAsyncService
                        .searchTiendas(searchTiendasRequest);
                AsyncUtils.exceptionally(cfDataTiendas, cf);

                List<GenericTiendaResultItemDto> dataT = cfDataTiendas.get();
                
                filter.setItem(dataT.stream().map(e -> GenericFilterParametersDto.builder().idLugarTrabajo("T" + e.getIdLugarTrabajo()).build())
                        .collect(Collectors.toList()));
                
                CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .getTiendas(tiendasRequest);
                AsyncUtils.exceptionally(cfData, cf);
                
                List<GenericTiendaResultItemDto> dataTC = cfDataTiendas.get();

                
                if (CollectionUtils.isNotEmpty(dataTC)) {
                    List<TrabajoTiendaEstadoDto> trabajoTiendaEstado = trabajotiendaEstadoMapper
                            .genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(dataTC);
                    if (CollectionUtils.isNotEmpty(trabajoTiendaEstado)) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                getTiendasEmpleadoDto.getFilter().getMaxPersistenceSize());
                        CompletableFuture<Void> cfSave = trabajoTiendaEstadoAsyncService.save(trabajoTiendaEstado,
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
    
    @AuditoriaTrabajo
    @Override
    public void empleadosTienda(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            trabajoRunDatos.setTiendasPresenciaNuevas(trabajoTiendaEstadoRepositoryCustom
                    .customFindByIdTiendaNotExists(trabajoRunDatos.getTiendasPresencia()));
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            GenericFilterDto filter = trabajoMapper.trabajoDtoToGenericFilterDto(trabajo);
    
            EmpleadosRequestDto empleadosRequest = new EmpleadosRequestDto();
            //TODO: Cambiar esto
            empleadosRequest.setPage(getTiendasEmpleadoDto.getPage());
            empleadosRequest.setData(filter);
            
            boolean hasNext = false;
            do {
                // TODO Pendiente revision Soap vs Java
                CompletableFuture<List<GenericEmpleadoResultItemDto>> cfDataEmpleados = meta4IcmWsCalcIncomeSessionAsyncService
                        .getEmpleados(empleadosRequest);
                AsyncUtils.exceptionally(cfDataEmpleados, cf);
    
                List<GenericEmpleadoResultItemDto> data = cfDataEmpleados.get();
                if (CollectionUtils.isNotEmpty(data)) {
//                    List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado = trabajoEmpleadoEstadoMapper
//                            .genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(data, trabajo);
//                    if (CollectionUtils.isNotEmpty(trabajoEmpleadoEstado)) {
//                        AsyncUtils.checkAsyncAvaliable(cfPersist,
//                                getTiendasEmpleadoDto.getFilter().getMaxPersistenceSize());
//                        CompletableFuture<Void> cfSave = trabajoEmpleadoEstadoAsyncService.save(trabajoEmpleadoEstado);
//                        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
//                    }
                }
                hasNext = empleadosRequest.nextPage();
            } while(hasNext);
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }
    
}