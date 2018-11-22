package com.inditex.rrhh.icmclcwb.model.app.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionEmpleadoPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.service.Meta4SessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTiendaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseDTO;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.poc.PocTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.RunUtils;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaVentaSeccionRepository;

@Service
@Validated
public class TrabajoDatosServiceImpl implements TrabajoDatosService {

    @Autowired
    private Meta4SessionAsyncService meta4SessionAsyncService;

    @Autowired
    private PtrPresenciaMockAsyncService ptrPresenciaMockAsyncService;

    @Autowired
    private PtrVentaAsyncService ptrVentaAsyncService;

    @Autowired
    private TrabajoEmpleadoEstadoAsyncService trabajoEmpleadoEstadoAsyncService;

    @Autowired
    private TrabajoTiendaSeccionVentaAsyncService trabajoTiendaSeccionVentaAsyncService;

    @Autowired
    private TrabajoTiendaSeccionPresenciaService trabajoTiendaSeccionPresenciaService;

    @Autowired
    private TrabajoTiendaSeccionEmpleadoPresenciaService trabajoTiendaSeccionEmpleadoPresenciaService;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoTiendaEstadoRepository trabajoTiendaEstadoRepository;

    @Autowired
    private TrabajoEmpleadoEstadoRepository trabajoEmpleadoEstadoRepository;

    @Autowired
    private TrabajoTiendaEstadoMapper trabajoTiendaEstadoMapper;

    @Autowired
    private PocTiendaMapper pocTiendaMapper;

    @Autowired
    private TrabajoEmpleadoEstadoMapper trabajoEmpleadoEstadoMapper;
    
    @Autowired
    private TrabajoTiendaVentaSeccionRepository trabajoTiendaVentaSeccionRepository;

    @Autowired
    @Qualifier("getEmpleadosTiendaDto")
    private Meta4PropertiesDto getEmpleadosTiendaDto;

    @Autowired
    @Qualifier("ventaTotalizadoDto")
    private PtrPropertiesDto ventaTotalizadoDto;

    @Autowired
    @Qualifier("ventaIndividualDetalleDto")
    private PtrPropertiesDto ventaIndividualDetalleDto;

    @Autowired
    @Qualifier("presenciasTotalTiendaSeccionDto")
    private PtrPropertiesDto presenciasTotalTiendaSeccionDto;

    @Autowired
    @Qualifier("presenciasDetalleDto")
    private PtrPropertiesDto presenciasDetalleDto;

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
        EmpleadosTiendaRequestDto request = new EmpleadosTiendaRequestDto();
        EmpleadosTiendaFilterDto data = trabajoMapper.trabajoDtotoEmpleadosTiendaFilterDto(trabajo);
        request.setPage(getEmpleadosTiendaDto.getPage());
        request.setData(data);

        List<Long> tipoTrabajoTiendaId = Stream
                .of(AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto(),
                        AppConstants.TipoTrabajoTiendaEnum.PARAMETRO.getDto(),
                        AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto())
                .map(t -> t.getId()).collect(Collectors.toList());

        List<CompletableFuture<Void>> cfTrabajoEmpleadoSaveList = new ArrayList<>();

        do {
            // Se recuperan las tiendas por id de trabajo y estado de forma paginada.
            tiendasPage = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoIdAndTipoIdIn(trabajo.getId(),
                    AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), tipoTrabajoTiendaId, pageable);
            if (CollectionUtils.isNotEmpty(tiendasPage.getContent())) {
                PageDto page = null;

                // Para cada tienda recuperamos y persistimos los datos de los empleados
                // asociados.
                for (TrabajoTiendaEstado tienda : tiendasPage.getContent()) {
                    request.getData().setIdLugarTrabajo(tienda.getIdTiendaMeta4());
                    do {
                        // Consultamos en meta4 los empleados por tienda de forma paginada.
                        List<EmpleadosTiendaResultItemDto> persist = meta4SessionAsyncService
                                .getEmpleadosTienda(request).get();
                        if (CollectionUtils.isNotEmpty(persist)) {
                            List<TrabajoEmpleadoEstadoDto> response = trabajoEmpleadoEstadoMapper
                                    .empleadosTiendaResultItemDtoToTrabajoEmpleadoEstadoDto(persist, trabajo);
                            if (CollectionUtils.isNotEmpty(response)) {
                                if (cfTrabajoEmpleadoSaveList.size() >= getEmpleadosTiendaDto.getFilter()
                                        .getMaxPersistenceSize()) {
                                    // Comprobamos que tenemos asíncronos libres y persistimos los datos.
                                    // En caso de no tener asíncronos libres esperamos a que alguno de los que está
                                    // en ejecución
                                    // termine, lo sacamos de la lista de futuros y persistimos.
                                    AsyncUtils.checkAsyncAvaliable(cfTrabajoEmpleadoSaveList);
                                }
                                cfTrabajoEmpleadoSaveList.add(trabajoEmpleadoEstadoAsyncService.save(response));
                            }
                        }
                        page = new PageDto();
                        page.setNumeroPagina(request.getPage().getNumeroPagina());
                        page.setNumeroTotalPaginas(request.getPage().getNumeroTotalPaginas());
                        request.getPage().setNumeroPagina(request.getPage().getNumeroPagina() + 1);
                    } while (page.hasNext());
                }
            }
            pageable = tiendasPage.nextPageable();
        } while (tiendasPage.hasNext());

        // Comprobamos que todas las persistencias se han realizado y esperamos en caso
        // negativo.
        CompletableFuture
                .allOf(cfTrabajoEmpleadoSaveList.toArray(new CompletableFuture[cfTrabajoEmpleadoSaveList.size()]))
                .join();
    }

    @AuditoriaTrabajo
    @Override
    public void tiendasParametro(@Valid final TrabajoDto trabajo) throws Exception {
        List<TrabajoTiendaEstadoDto> tienda = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
            throw new UnsupportedOperationException();
        } else if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
            tienda.addAll(pocTiendaMapper
                    .pocTiendaDtoToTrabajoTiendaEstadoDto(meta4SessionAsyncService.getTiendas(trabajo).get()));
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
    public void ventaTotalizadaTienda(@Valid final TrabajoDto trabajo,
            @NotNull final List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {

        Pageable pageable = new PageRequest(0, ventaTotalizadoDto.getFilter().getMaxPageSize());
        Page<TrabajoTiendaEstado> tiendasPage;

        List<Long> tipoTrabajoTiendaId = tipoTrabajoTienda.stream().map(TipoTrabajoTiendaDto::getId)
                .collect(Collectors.toList());

        List<CompletableFuture<Void>> cfTrabajoTiendaSeccionVentaList = new ArrayList<>();

        do {
            // Se recuperan las tiendas por id de trabajo y estado de forma paginada.
            tiendasPage = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoIdAndTipoIdIn(trabajo.getId(),
                    AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), tipoTrabajoTiendaId, pageable);
            if (CollectionUtils.isNotEmpty(tiendasPage.getContent())) {
                List<String> tiendas = tiendasPage.getContent().stream().map(e -> e.getIdTienda())
                        .collect(Collectors.toList());
                GetVentaTotalizadoRequestDTO paramGetVentaTotalizado = trabajoMapper
                        .trabajoDtoToGetVentaTotalizadoRequestDTO(trabajo);
                paramGetVentaTotalizado.setTienda(tiendas);
                paramGetVentaTotalizado.setCadena(trabajo.getCadenasEmpresa());
                paramGetVentaTotalizado.setAgrupacion(PtrConstants.AGRUPACION_TOTALIZADA);
                GetVentaTotalizadoResponseDTO response = ptrVentaAsyncService
                        .getVentaTotalizado(paramGetVentaTotalizado).get();
                if (CollectionUtils.isNotEmpty(response.getVentaTotalizado())) {
                    if (cfTrabajoTiendaSeccionVentaList.size() >= ventaTotalizadoDto.getFilter()
                            .getMaxPersistenceSize()) {
                        AsyncUtils.checkAsyncAvaliable(cfTrabajoTiendaSeccionVentaList);
                    }
                    cfTrabajoTiendaSeccionVentaList
                            .add(trabajoTiendaSeccionVentaAsyncService.save(response.getVentaTotalizado(), trabajo));
                }
            }

            pageable = tiendasPage.nextPageable();

        } while (tiendasPage.hasNext());

        CompletableFuture.allOf(
                cfTrabajoTiendaSeccionVentaList.toArray(new CompletableFuture[cfTrabajoTiendaSeccionVentaList.size()]))
                .join();

        if (RunUtils.isPivot(trabajo, tipoTrabajoTienda)) {
            // TODO Pivotado de la informacion
        	trabajoTiendaVentaSeccionRepository.save(trabajo.getId());
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
    public void ventaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception {
        Pageable pageable = new PageRequest(0, ventaIndividualDetalleDto.getFilter().getMaxPageSize());
        Page<TrabajoEmpleadoEstado> empleadosPage;
        List<CompletableFuture<Void>> cfTrabajoTiendaSeccionEmpleadoVentaList = new ArrayList<>();
        do {
            // Se recuperan los empleados por id de trabajo y estado de forma paginada.
            empleadosPage = trabajoEmpleadoEstadoRepository.findByTrabajoIdAndEstadoId(trabajo.getId(),
                    AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), pageable);
            if (CollectionUtils.isNotEmpty(empleadosPage.getContent())) {
                List<Integer> empleados = empleadosPage.getContent().stream()
                        .map(e -> Integer.valueOf(e.getIdEmpleado())).collect(Collectors.toList());
                GetVentaIndividualDetalleRequestDTO paramGetVentaIndividualDetalle = trabajoMapper
                        .trabajoDtoToGetVentaIndividualDetalleRequestDTO(trabajo);
                paramGetVentaIndividualDetalle.setVendedores(empleados);
                paramGetVentaIndividualDetalle.setCadena(trabajo.getCadenasEmpresa());
                paramGetVentaIndividualDetalle.setTienda(new ArrayList<>());
                paramGetVentaIndividualDetalle.setAgrupacion(PtrConstants.AGRUPACION_INDIVIDUAL);
                GetVentaIndividualDetalleResponseDTO response = ptrVentaAsyncService
                        .getVentaIndividualDetalle(paramGetVentaIndividualDetalle).get();
                if (CollectionUtils.isNotEmpty(response.getVentaIndividualDetalle())) {
                    if (cfTrabajoTiendaSeccionEmpleadoVentaList.size() >= ventaIndividualDetalleDto.getFilter()
                            .getMaxPersistenceSize()) {
                        AsyncUtils.checkAsyncAvaliable(cfTrabajoTiendaSeccionEmpleadoVentaList);
                    }
                    // TODO PERSISTIR
                }
            }
            pageable = empleadosPage.nextPageable();
        } while (empleadosPage.hasNext());
        CompletableFuture.allOf(cfTrabajoTiendaSeccionEmpleadoVentaList
                .toArray(new CompletableFuture[cfTrabajoTiendaSeccionEmpleadoVentaList.size()])).join();
    }

    @AuditoriaTrabajo
    @Override
    public void tiposHoras(@Valid final TrabajoDto trabajo) throws Exception {
        Random random = new Random();
        LongStream ls = random.longs(1000, 5000);
        long time = ls.findFirst().getAsLong();
        ls.close();
        Thread.sleep(time);
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

    @AuditoriaTrabajo
    @Override
    public void presenciaTotalizadaTienda(@Valid TrabajoDto trabajo,
            @NotNull final List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {
        Pageable pageable = new PageRequest(0, presenciasTotalTiendaSeccionDto.getFilter().getMaxPageSize());
        Page<TrabajoTiendaEstado> tiendasPage;

        List<Long> tipoTrabajoTiendaId = tipoTrabajoTienda.stream().map(t -> t.getId()).collect(Collectors.toList());

        List<CompletableFuture<Void>> cfTrabajoTiendaPresenciaList = new ArrayList<>();

        do {
            // Se recuperan las tiendas por id de trabajo y estado de forma paginada.
            tiendasPage = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoIdAndTipoIdIn(trabajo.getId(),
                    AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), tipoTrabajoTiendaId, pageable);
            if (tiendasPage != null && CollectionUtils.isNotEmpty(tiendasPage.getContent())) {
                // CompletableFuture<List<PresenciasTotalTiendaSeccionResponseDto>> cfResponse =
                // new CompletableFuture<>();
                List<PtrPresenciasMockTiendaSeccionDto> tiendas = tiendasPage.getContent().stream()
                        .map(t -> new PtrPresenciasMockTiendaSeccionDto(Integer.valueOf(t.getIdTienda()), null))
                        .collect(Collectors.toList());
                List<Integer> cadenasMap = trabajo.getCadenasEmpresa().stream().map(Integer::valueOf)
                        .collect(Collectors.toList());

                PtrPresenciasMockTotalTiendaSeccionRequestDto paramPresenciasTotalTiendaSeccion = trabajoMapper
                        .trabajoDtoToPresenciasTotalTiendaSeccionRequestDto(trabajo);
                paramPresenciasTotalTiendaSeccion.setCadena(cadenasMap);
                paramPresenciasTotalTiendaSeccion.setTiendaSeccion(tiendas);
                // TODO (PENDIENTE ANALIZAR) Enviar la lista de horas comisionables y cambiar el objeto a una lista
                //paramPresenciasTotalTiendaSeccion.setTipo(tipo);
                List<PtrPresenciasMockTotalTiendaSeccionResponseDto> response = ptrPresenciaMockAsyncService
                        .presenciasTotalTiendaSeccion(paramPresenciasTotalTiendaSeccion).get();
                if (CollectionUtils.isNotEmpty(response)) {
                    if (cfTrabajoTiendaPresenciaList.size() >= presenciasTotalTiendaSeccionDto.getFilter()
                            .getMaxPersistenceSize()) {
                        AsyncUtils.checkAsyncAvaliable(cfTrabajoTiendaPresenciaList);
                    }
                    cfTrabajoTiendaPresenciaList.add(trabajoTiendaSeccionPresenciaService.save(response));
                }
                pageable = tiendasPage.nextPageable();
            } else {
                break;
            }

        } while (tiendasPage.hasNext());

        CompletableFuture
                .allOf(cfTrabajoTiendaPresenciaList.toArray(new CompletableFuture[cfTrabajoTiendaPresenciaList.size()]))
                .join();
        
        if (RunUtils.isPivot(trabajo, tipoTrabajoTienda)) {
            // TODO Pivotado de la informacion
        }
    }

    @AuditoriaTrabajo
    @Override
    public void presenciaDetalleEmpleado(@Valid TrabajoDto trabajo) throws Exception {
        Pageable pageable = new PageRequest(0, presenciasDetalleDto.getFilter().getMaxPageSize());
        Page<TrabajoEmpleadoEstado> empleadosPage;

        List<CompletableFuture<Void>> cfTrabajoDetallePresenciaList = new ArrayList<>();
        
        do {
            // Se recuperan las tiendas por id de trabajo y estado de forma paginada.
            empleadosPage = trabajoEmpleadoEstadoRepository.findByTrabajoIdAndEstadoId(trabajo.getId(),
                    AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), pageable);

            if (CollectionUtils.isNotEmpty(empleadosPage.getContent())) {
                List<Integer> empleados = empleadosPage.getContent().stream()
                        .map(s -> Integer.valueOf(s.getIdEmpleado())).collect(Collectors.toList());
                List<Integer> cadenasMap = trabajo.getCadenasEmpresa().stream().map(Integer::valueOf)
                        .collect(Collectors.toList());
                PtrPresenciasMockDetalleRequestDto paramPresenciasDetalle = trabajoMapper
                        .trabajoDtoToPresenciasDetalleRequestDto(trabajo);
                paramPresenciasDetalle.setPersonas(empleados);
                paramPresenciasDetalle.setCadena(cadenasMap);
                List<PtrPresenciasMockDetalleResponseDto> response = ptrPresenciaMockAsyncService
                        .presenciasDetalle(paramPresenciasDetalle).get();
                if (CollectionUtils.isNotEmpty(response)) {
                    if (cfTrabajoDetallePresenciaList.size() >= presenciasDetalleDto.getFilter()
                            .getMaxPersistenceSize()) {
                        AsyncUtils.checkAsyncAvaliable(cfTrabajoDetallePresenciaList);
                    }
                    cfTrabajoDetallePresenciaList
                            .add(trabajoTiendaSeccionEmpleadoPresenciaService.save(response, trabajo));
                    
                    // TODO Recuperar tiendas de las presencias
                    
                }
            }
            pageable = empleadosPage.nextPageable();
        } while (empleadosPage.hasNext());

        CompletableFuture.allOf(
                cfTrabajoDetallePresenciaList.toArray(new CompletableFuture[cfTrabajoDetallePresenciaList.size()]))
                .join();
        
        // TODO Revisar si las tiendas recuperadas de las presencias estan en las tiendas de BBDB
        // Si no estan consultar a Meta4 e insertar los datos
        
        // TODO Pivotado de la informacion
    }
    
    
    @AuditoriaTrabajo
    @Override
    public void ventaTotalizadaTiendaTest(@Valid final TrabajoDto trabajo,
            List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {
    	Integer maxPersistenceSize = ventaTotalizadoDto.getFilter()
                .getMaxPersistenceSize();
    	Integer maxPageSize = ventaTotalizadoDto.getFilter().getMaxPageSize();
        List<Long> tipoTrabajoTiendaId = tipoTrabajoTienda.stream().map(t -> t.getId()).collect(Collectors.toList());

        GetVentaTotalizadoRequestDTO paramGetVentaTotalizado = trabajoMapper
                .trabajoDtoToGetVentaTotalizadoRequestDTO(trabajo);
        paramGetVentaTotalizado.setCadena(trabajo.getCadenasEmpresa());
        paramGetVentaTotalizado.setAgrupacion(PtrConstants.AGRUPACION_TOTALIZADA);
        
        Object[] helperParams = new Object[3];
        helperParams[0] = trabajo.getId();
        helperParams[1] = AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId();
        helperParams[2] = tipoTrabajoTiendaId;
        
        ServiceDefinitionHelper elementsHelper = ServiceDefinitionHelper.builder()
        		.methodName("findByTrabajoIdAndEstadoIdAndTipoIdIn")
        		.objectParams(helperParams)
        		.service(trabajoTiendaEstadoRepository)
        		.build();

        ServiceDefinitionHelper ptr = ServiceDefinitionHelper.builder()
				.methodName("getVentaTotalizado")
				.service(ptrVentaAsyncService)
				.build();
        
        Class[] saveType = new Class[2];
        saveType[0] = List.class;
        saveType[1] = TrabajoDto.class;
        
        ServiceDefinitionHelper save = ServiceDefinitionHelper.builder()
        		.methodName("save")
        		.objectType(saveType)
        		.service(trabajoTiendaSeccionVentaAsyncService)
        		.build();

    	genericPtrCall(trabajo, paramGetVentaTotalizado, maxPageSize, maxPersistenceSize, ptr, elementsHelper, save, "tienda", "ventaTotalizado");
    }
    
    private <T, U extends Object, Z extends Object> void genericPtrCall(TrabajoDto trabajo, U request, 
    		Integer maxPageSize, Integer maxPersistenceSize, ServiceDefinitionHelper ptr, 
    		ServiceDefinitionHelper elementsHelper, ServiceDefinitionHelper save, 
    		String field, String fieldResult) throws Exception{
        Pageable pageable = new PageRequest(0, maxPageSize);
        Page page = null;
        
        List<CompletableFuture<Void>> cfList = new ArrayList<>();
        do {
        	Object[] params = new Object[elementsHelper.getObjectParams().length + 1];
        	Class[] paramsType = new Class[elementsHelper.getObjectParams().length + 1];
        	
        	for(int i = 0; i < elementsHelper.getObjectParams().length; i++){
        		params[i] = elementsHelper.getObjectParams()[i];
        		if (elementsHelper.getObjectParams()[i] instanceof ArrayList) {
					paramsType[i] = List.class ;
				}else{
					paramsType[i] = elementsHelper.getObjectParams()[i].getClass();	
				}
        	}
        	
        	params[params.length - 1] = pageable;
        	paramsType[paramsType.length - 1] = Pageable.class;

			Method method = elementsHelper.getService().getClass().getMethod(elementsHelper.getMethodName(), paramsType);
	        page = (Page) method.invoke(elementsHelper.getService(), params);
	        if (CollectionUtils.isNotEmpty(page.getContent())) {
				List<?> elements = (List<Integer>) page.getContent().stream()
		            .map(e -> {
		            	if(e instanceof TrabajoEmpleadoEstado){
		            		 return ((TrabajoEmpleadoEstado) e).getIdEmpleado();	
		            	}else if(e instanceof TrabajoTiendaEstado){
		            		return ((TrabajoTiendaEstado) e).getIdTienda();	
		            	}
						return null;
		            }).collect(Collectors.toList());
				
					Field setField = request.getClass().getDeclaredField(field);
					setField.setAccessible(true);
					if (setField != null) {
						setField.set(request, elements);
					}

					Method methodPtr = ptr.getService().getClass().getMethod(ptr.getMethodName(), request.getClass());
					CompletableFuture<U> result = (CompletableFuture<U>) methodPtr.invoke(ptr.getService(), request);
					
					U resultGet = result.get();
					List<U> resultArray = new ArrayList<>();
					Field setFieldSave = resultGet.getClass().getDeclaredField(fieldResult);
					setFieldSave.setAccessible(true);

					if (setFieldSave != null) {
						resultArray = (List<U>) setFieldSave.get(resultGet);
					}
					
					Method methodSave = save.getService().getClass().getMethod(save.getMethodName(), save.getObjectType());
					CompletableFuture<Void> saveResult;
					if (save.getObjectType().length == 2) {
						saveResult = (CompletableFuture<Void>) methodSave.invoke(save.getService(), resultArray,
								trabajo);
					}else{
						saveResult = (CompletableFuture<Void>) methodSave.invoke(save.getService(), resultArray);
					}
					cfList.add(saveResult);
					
				if (cfList.size() >= maxPersistenceSize) {
				    AsyncUtils.checkAsyncAvaliable(cfList);
				}
	        }
	        
            pageable = page.nextPageable();

        }while(page.hasNext());

        CompletableFuture.allOf(cfList
                .toArray(new CompletableFuture[cfList.size()])).join();
    }

}