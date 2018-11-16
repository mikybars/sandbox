package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionEmpleadoPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.service.Meta4SessionService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiendaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciasServiceMock;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseDTO;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.poc.PocTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepository;

@Service
@Validated
public class TrabajoRunAsyncServiceImpl implements TrabajoRunAsyncService {

    @Autowired
    private Meta4SessionService meta4Service;

    @Autowired
    private PtrPresenciasServiceMock ptrPresenciaService;

    @Autowired
    private PtrVentaService ptrVentaService;

    @Autowired
    private TrabajoEmpleadoEstadoService trabajoEmpleadoEstadoService;

    @Autowired
    private TrabajoTiendaSeccionVentaService trabajoTiendaSeccionVentaService;

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
    @Async
    @Override
    public CompletableFuture<Void> empleadosTienda(@Valid final TrabajoDto trabajo) {
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

        List<Long> tipoTrabajoTiendaId = new ArrayList<>();
        Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto(),
                AppConstants.TipoTrabajoTiendaEnum.PARAMETRO.getDto(),
                AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto()).forEach(item -> {
                    tipoTrabajoTiendaId.add(item.getId());
                });

        List<CompletableFuture<Void>> cfTrabajoEmpleadoSaveList = new ArrayList<>();

        do {
            // Se recuperan las tiendas por id de trabajo y estado de forma paginada.

            tiendasPage = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoIdAndTipoIdIn(trabajo.getId(),
                    AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), tipoTrabajoTiendaId, pageable);

            if (CollectionUtils.isNotEmpty(tiendasPage.getContent())) {

                // Para cada tienda recuperamos y persistimos los datos de los empleados
                // asociados.
                for (TrabajoTiendaEstado tienda : tiendasPage.getContent()) {

                    request.getData().setIdLugarTrabajo(tienda.getIdTiendaMeta4());

                    do {
                        // Consultamos en meta4 los empleados por tienda de forma paginada.
                        CompletableFuture<List<EmpleadosTiendaResultItemDto>> cfEmpleadosTienda = null;

                        try {
                            cfEmpleadosTienda = meta4Service.getEmpleadosTienda(request);
                        } catch (Exception e) {
                            throw new ApplicationException("Error consultando en meta4: {}" + e.getMessage());
                        }

                        List<EmpleadosTiendaResultItemDto> persist = null;

                        try {
                            persist = cfEmpleadosTienda.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new ApplicationException(
                                    "Futuro completado de forma excepcional: {}" + e.getMessage());
                        }

                        List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoDto = trabajoEmpleadoEstadoMapper
                                .empleadosTiendaResultItemDtoToTrabajoEmpleadoEstadoDto(persist, trabajo);

                        if (cfTrabajoEmpleadoSaveList.size() >= getEmpleadosTiendaDto.getFilter()
                                .getMaxPersistenceSize()) {
                            // Comprobamos que tenemos asíncronos libres y persistimos los datos.
                            // En caso de no tener asíncronos libres esperamos a que alguno de los que está
                            // en ejecución
                            // termine, lo sacamos de la lista de futuros y persistimos.

							AsyncUtils.checkAsyncAvaliable(cfTrabajoEmpleadoSaveList);
                      }

                        cfTrabajoEmpleadoSaveList.add(trabajoEmpleadoEstadoService.save(trabajoEmpleadoDto));

                    } while (request.getPage().hasNext());
                }
            }
            pageable = tiendasPage.nextPageable();
        } while (tiendasPage.hasNext());

        // Comprobamos que todas las persistencias se han realizado y esperamos en caso
        // negativo.
        CompletableFuture
                .allOf(cfTrabajoEmpleadoSaveList.toArray(new CompletableFuture[cfTrabajoEmpleadoSaveList.size()]))
                .join();

        return CompletableFuture.completedFuture(null);
    }

    @AuditoriaTrabajo
    @Async
    @Override
    public CompletableFuture<Void> tiendasParametro(@Valid final TrabajoDto trabajo) throws Exception {
        List<TrabajoTiendaEstadoDto> tienda = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
            throw new UnsupportedOperationException();
        } else if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
            tienda.addAll(pocTiendaMapper.pocTiendaDtoToTrabajoTiendaEstadoDto(meta4Service.getTiendas(trabajo)));
            trabajoTiendaEstadoRepository.save(trabajoTiendaEstadoMapper
                    .mergeTrabajoTiendaEstadoDtoAndTrabajoDtoToTrabajoTiendaEstado(tienda, trabajo));
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
        return CompletableFuture.completedFuture(null);
    }

    @AuditoriaTrabajo
    @Async
    @Override
    public CompletableFuture<Void> ventaTotalizadaTienda(@Valid final TrabajoDto trabajo,
            @NotNull List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {

        Pageable pageable = new PageRequest(0, ventaTotalizadoDto.getFilter().getMaxPageSize());
        Page<TrabajoTiendaEstado> tiendasPage;

        List<Long> tipoTrabajoTiendaId = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(tipoTrabajoTienda)) {
            tipoTrabajoTienda.forEach(item -> {
                tipoTrabajoTiendaId.add(item.getId());
            });
        }

        List<CompletableFuture<Void>> cfTrabajoTiendaSeccionVentaList = new ArrayList<>();

		do {
			CompletableFuture<GetVentaTotalizadoResponseDTO> cfResponse = new CompletableFuture<>();
			// Se recuperan las tiendas por id de trabajo y estado de forma paginada.
			tiendasPage = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoIdAndTipoIdIn(trabajo.getId(),
					AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), tipoTrabajoTiendaId, pageable);
			if (CollectionUtils.isNotEmpty(tiendasPage.getContent())) {
				
				List<String> tiendas = tiendasPage.getContent().stream().map(e-> e.getIdTienda())
						.collect(Collectors.toList());
				GetVentaTotalizadoRequestDTO paramGetVentaTotalizado = trabajoMapper
						.trabajoDtoToGetVentaTotalizadoRequestDTO(trabajo);
				paramGetVentaTotalizado.setTienda(tiendas);
				paramGetVentaTotalizado.setCadena(trabajo.getCadenas());
				paramGetVentaTotalizado.setAgrupacion(PtrConstants.AGRUPACION_TOTALIZADA);
				cfResponse = ptrVentaService.getVentaTotalizado(paramGetVentaTotalizado);
				GetVentaTotalizadoResponseDTO response = cfResponse.get();

				if (cfTrabajoTiendaSeccionVentaList.size() >= ventaTotalizadoDto.getFilter().getMaxPersistenceSize()) {
					AsyncUtils.checkAsyncAvaliable(cfTrabajoTiendaSeccionVentaList);
				}

				cfTrabajoTiendaSeccionVentaList
						.add(trabajoTiendaSeccionVentaService.save(response.getVentaTotalizado(), trabajo));
			}
			
			pageable = tiendasPage.nextPageable();
			
		} while (tiendasPage.hasNext());

        CompletableFuture.allOf(
                cfTrabajoTiendaSeccionVentaList.toArray(new CompletableFuture[cfTrabajoTiendaSeccionVentaList.size()]))
                .join();

        return CompletableFuture.completedFuture(null);
    }

    @AuditoriaTrabajo
    @Async
    @Override
    public CompletableFuture<Void> condicionesEmpleados(@Valid final TrabajoDto trabajo) throws Exception {
        Random random = new Random();
        LongStream ls = random.longs(1000, 5000);
        long time = ls.findFirst().getAsLong();
        Thread.sleep(time);
        ls.close();
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> ventaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception {
        Pageable pageable = new PageRequest(0, ventaIndividualDetalleDto.getFilter().getMaxPageSize());
        Page<TrabajoEmpleadoEstado> empleadosPage;

        List<CompletableFuture<Void>> cfTrabajoTiendaSeccionEmpleadoVentaList = new ArrayList<>();
		do {
			CompletableFuture<GetVentaIndividualDetalleResponseDTO> cfResponse = new CompletableFuture<>();
			// Se recuperan los empleados por id de trabajo y estado de forma paginada.

			empleadosPage = trabajoEmpleadoEstadoRepository.findByTrabajoIdAndEstadoId(trabajo.getId(),
					AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), pageable);
	
			if(CollectionUtils.isNotEmpty(empleadosPage.getContent())){
				List<Integer> empleados = empleadosPage.getContent().stream().map(e -> Integer.valueOf(e.getIdEmpleado()))
						.collect(Collectors.toList());
				GetVentaIndividualDetalleRequestDTO paramGetVentaIndividualDetalle = trabajoMapper
						.trabajoDtoToGetVentaIndividualDetalleRequestDTO(trabajo);
				paramGetVentaIndividualDetalle.setVendedores(empleados);
				paramGetVentaIndividualDetalle.setCadena(trabajo.getCadenas());
				paramGetVentaIndividualDetalle.setTienda(new ArrayList<>());
				paramGetVentaIndividualDetalle.setAgrupacion(PtrConstants.AGRUPACION_INDIVIDUAL);
				cfResponse = ptrVentaService.getVentaIndividualDetalle(paramGetVentaIndividualDetalle);
				GetVentaIndividualDetalleResponseDTO response = cfResponse.get();
	
				if (cfTrabajoTiendaSeccionEmpleadoVentaList.size() >= ventaIndividualDetalleDto.getFilter()
						.getMaxPersistenceSize()) {
					AsyncUtils.checkAsyncAvaliable(cfTrabajoTiendaSeccionEmpleadoVentaList);
				}
				// TODO: PERSISTIR
			}
			
			pageable = empleadosPage.nextPageable();
			
		} while (empleadosPage.hasNext());

        CompletableFuture.allOf(cfTrabajoTiendaSeccionEmpleadoVentaList
                .toArray(new CompletableFuture[cfTrabajoTiendaSeccionEmpleadoVentaList.size()])).join();

        return CompletableFuture.completedFuture(null);
    }

    @AuditoriaTrabajo
    @Async
    @Override
    public CompletableFuture<Void> tiposHoras(@Valid final TrabajoDto trabajo) throws Exception {
        Random random = new Random();
        LongStream ls = random.longs(1000, 5000);
        long time = ls.findFirst().getAsLong();
        ls.close();
        Thread.sleep(time);
        return CompletableFuture.completedFuture(null);
    }

    @AuditoriaTrabajo
    @Async
    @Override
    public CompletableFuture<Void> tiendasHistorico(@Valid TrabajoDto trabajo) throws Exception {
        if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
            Random random = new Random();
            LongStream ls = random.longs(1000, 5000);
            long time = ls.findFirst().getAsLong();
            ls.close();
            Thread.sleep(time);
        }
        return CompletableFuture.completedFuture(null);
    }

    @AuditoriaTrabajo
    @Override
    public CompletableFuture<Void> presenciaTotalizadaTienda(@Valid TrabajoDto trabajo,
            @NotNull List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {
        Pageable pageable = new PageRequest(0, presenciasTotalTiendaSeccionDto.getFilter().getMaxPageSize());
        Page<TrabajoTiendaEstado> tiendasPage;

        List<Long> tipoTrabajoTiendaId = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(tipoTrabajoTienda)) {
            tipoTrabajoTienda.forEach(item -> {
                tipoTrabajoTiendaId.add(item.getId());
            });
        }

        List<CompletableFuture<Void>> cfTrabajoTiendaPresenciaList = new ArrayList<>();

        do {
            // Se recuperan las tiendas por id de trabajo y estado de forma paginada.
            tiendasPage = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoIdAndTipoIdIn(trabajo.getId(),
                    AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), tipoTrabajoTiendaId, pageable);

            if (tiendasPage != null && !tiendasPage.getContent().isEmpty()) {

                // CompletableFuture<List<PresenciasTotalTiendaSeccionResponseDto>> cfResponse =
                // new CompletableFuture<>();
                List<TiendaSeccionDto> tiendas = tiendasPage.getContent().stream()
                        .map(t -> new TiendaSeccionDto(Integer.valueOf(t.getIdTienda()), null))
                        .collect(Collectors.toList());
				List<Integer> cadenasMap = trabajo.getCadenas().stream().map(a -> Integer.valueOf(a)).collect(Collectors.toList());

                PresenciasTotalTiendaSeccionRequestDto paramPresenciasTotalTiendaSeccion = trabajoMapper
                        .trabajoDtoToPresenciasTotalTiendaSeccionRequestDto(trabajo);
                paramPresenciasTotalTiendaSeccion.setCadena(cadenasMap);
                paramPresenciasTotalTiendaSeccion.setTiendaSeccion(tiendas);
                List<PresenciasTotalTiendaSeccionResponseDto> response = ptrPresenciaService
                        .presenciasTotalTiendaSeccion(paramPresenciasTotalTiendaSeccion);

                if (cfTrabajoTiendaPresenciaList.size() >= presenciasTotalTiendaSeccionDto.getFilter()
                        .getMaxPersistenceSize()) {
					AsyncUtils.checkAsyncAvaliable(cfTrabajoTiendaPresenciaList);
               }

                // TODO: PERSISTIR
                cfTrabajoTiendaPresenciaList.add(trabajoTiendaSeccionPresenciaService.save(response));

            }
            pageable = tiendasPage.nextPageable();

        } while (tiendasPage.hasNext());

        CompletableFuture
                .allOf(cfTrabajoTiendaPresenciaList.toArray(new CompletableFuture[cfTrabajoTiendaPresenciaList.size()]))
                .join();

        return CompletableFuture.completedFuture(null);
    }

    @AuditoriaTrabajo
    @Async
    @Override
    public CompletableFuture<Void> presenciaDetalleEmpleado(@Valid TrabajoDto trabajo) throws Exception {
        Pageable pageable = new PageRequest(0, presenciasDetalleDto.getFilter().getMaxPageSize());
        Page<TrabajoEmpleadoEstado> empleadosPage;

        List<CompletableFuture<Void>> cfTrabajoDetallePresenciaList = new ArrayList<>();

		do {
			// Se recuperan las tiendas por id de trabajo y estado de forma paginada.
			empleadosPage = trabajoEmpleadoEstadoRepository.findByTrabajoIdAndEstadoId(trabajo.getId(),
					AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), pageable);

			if(CollectionUtils.isNotEmpty(empleadosPage.getContent())){
				List<Integer> empleados = empleadosPage.getContent().stream().map(s -> Integer.valueOf(s.getIdEmpleado()))
						.collect(Collectors.toList());
				List<Integer> cadenasMap = trabajo.getCadenas().stream().map(a -> Integer.valueOf(a)).collect(Collectors.toList());
				PresenciasDetalleRequestDto paramPresenciasDetalle = trabajoMapper
						.trabajoDtoToPresenciasDetalleRequestDto(trabajo);
				paramPresenciasDetalle.setPersonas(empleados);
				paramPresenciasDetalle.setCadena(cadenasMap);
				List<PresenciasDetalleResponseDto> response = ptrPresenciaService.presenciasDetalle(paramPresenciasDetalle);
			
				if(cfTrabajoDetallePresenciaList.size() >= presenciasDetalleDto.getFilter().getMaxPersistenceSize()){
					AsyncUtils.checkAsyncAvaliable(cfTrabajoDetallePresenciaList);
				}
				
				cfTrabajoDetallePresenciaList.add(trabajoTiendaSeccionEmpleadoPresenciaService.save(response));
			}
			
			pageable = empleadosPage.nextPageable();
					
		}while(empleadosPage.hasNext());

        CompletableFuture.allOf(
                cfTrabajoDetallePresenciaList.toArray(new CompletableFuture[cfTrabajoDetallePresenciaList.size()]))
                .join();

        return CompletableFuture.completedFuture(null);
    }

    @AuditoriaTrabajo
    @Override
    public void exceptionally(TrabajoDto trabajo, CompletableFuture<?> cf, List<CompletableFuture<?>> cfList)
            throws Exception {
        cfList.add(cf);
        cf.exceptionally(e -> {
            cfList.stream().forEach(item -> {
                if (item.isDone()) {
                } else {
                    item.cancel(true);
                }
            });
            return null;
        });
    }

    @AuditoriaTrabajo
    @Override
    public boolean isOk(TrabajoDto trabajo, List<CompletableFuture<?>> cfList) throws Exception {
        boolean result = true;
        for (CompletableFuture<?> item : cfList) {
            if (item.isCompletedExceptionally()) {
                result = false;
                break;
            }
        }
        return result;
    }

}