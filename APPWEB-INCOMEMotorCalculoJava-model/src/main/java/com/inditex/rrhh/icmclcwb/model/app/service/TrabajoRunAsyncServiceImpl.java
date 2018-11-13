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
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.service.Meta4SessionService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiendaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciasServiceMock;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleResponseItemDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseItemDTO;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.poc.PocTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTienda;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaRepository;

@Service
@Validated
public class TrabajoRunAsyncServiceImpl implements TrabajoRunAsyncService {

	@Autowired
	private Logger LOG;

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
	private TrabajoMapper trabajoMapper;

	@Autowired
	private TrabajoTiendaRepository trabajoTiendaRepository;

	@Autowired
	private TrabajoTiendaEstadoRepository trabajoTiendaEstadoRepository;

	@Autowired
	private TrabajoEmpleadoEstadoRepository trabajoEmpleadoEstadoRepository;

	@Autowired
	private TrabajoTiendaEstadoMapper trabajoTiendaEstadoMapper;

	@Autowired
	private PocTiendaMapper pocTiendaMapper;

	@Autowired
	private TrabajoTiendaMapper trabajoTiendaMapper;

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

	@Async
	@Override
	public CompletableFuture<Void> empleadosTienda(@Valid final TrabajoDto trabajo) {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.empleadosTienda(): {}", trabajo.getId(), trabajo);

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

		List<EmpleadosTiendaResultItemDto> result = new ArrayList<>();
		List<CompletableFuture<Void>> cfTrabajoEmpleadoSaveList = new ArrayList<>();

		do {
			// Se recuperan las tiendas por id de trabajo y estado de forma paginada.

			tiendasPage = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoIdAndTipoIdIn(trabajo.getId(),
					AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), tipoTrabajoTiendaId, pageable);
			LOG.info(
					"Trabajo[{}] :: Inicio :: TrabajoAsyncService.empleadosTienda(): trabajoTiendaRepository.findByTrabajoIdAndEstadoIdAndTipoIdIn(): {}",
					trabajo.getId(), tiendasPage);

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
							LOG.error("Error consultando en meta4: ", e.getMessage());
							throw new ApplicationException("Error consultando en meta4: {}" + e.getMessage());
						}

						List<EmpleadosTiendaResultItemDto> persist = null;

						try {
							persist = cfEmpleadosTienda.get();
						} catch (InterruptedException | ExecutionException e) {
							LOG.error("Futuro completado de forma excepcional: ", e.getMessage());
							throw new ApplicationException(
									"Futuro completado de forma excepcional: {}" + e.getMessage());
						}
						
						if(CollectionUtils.isNotEmpty(persist)){
							result.addAll(persist);
						}

						List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoDto = trabajoEmpleadoEstadoMapper
								.empleadosTiendaResultItemDtoToTrabajoEmpleadoEstadoDto(persist, trabajo);

						if (cfTrabajoEmpleadoSaveList.size() >= getEmpleadosTiendaDto.getFilter()
								.getMaxPersistenceSize()) {
							// Comprobamos que tenemos asíncronos libres y persistimos los datos.
							// En caso de no tener asíncronos libres esperamos a que alguno de los que está
							// en ejecución
							// termine, lo sacamos de la lista de futuros y persistimos.

							CompletableFuture.anyOf(cfTrabajoEmpleadoSaveList
									.toArray(new CompletableFuture[cfTrabajoEmpleadoSaveList.size()]));
							Map<Boolean, List<CompletableFuture<Void>>> resultPersistence = cfTrabajoEmpleadoSaveList
									.stream().collect(Collectors.partitioningBy(CompletableFuture::isDone));
							List<CompletableFuture<Void>> cfPersistence = resultPersistence.values().stream()
									.flatMap(List::stream).collect(Collectors.toList());
							cfTrabajoEmpleadoSaveList.removeAll(cfPersistence);
						}

						cfTrabajoEmpleadoSaveList.add(trabajoEmpleadoEstadoService.save(trabajoEmpleadoDto));

					} while (request.getPage().hasNext());
				}
			}
			pageable = tiendasPage.nextPageable();
		} while (tiendasPage.hasNext());
		
		// Comprobamos que todas las persistencias se han realizado y esperamos en caso
		// negativo.
		CompletableFuture.allOf(
				cfTrabajoEmpleadoSaveList.toArray(new CompletableFuture[cfTrabajoEmpleadoSaveList.size()]))
				.join();

		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.empleadosTienda(): {}", trabajo.getId(), result);
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> tiendasParametro(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.tiendasParametro(): {}", trabajo.getId(), trabajo);
		// Se recuperan las tiendas relacionadas con la ejecucion
		List<TrabajoTiendaDto> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
			// TODO Empleado :: Obtener las tiendas comisionables en las que ha estado el
			// empleado
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.tiendasParametro(Empleado): {}", trabajo.getId(),
					trabajo.getEmpleados());
			LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.tiendasParametro(Empleado): {}", trabajo.getId(),
					result);
		} else if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.tiendasParametro(Tienda): {}", trabajo.getId(),
					trabajo.getTiendas());
			trabajoTiendaEstadoRepository
					.save(trabajoTiendaEstadoMapper.mergeTrabajoTiendaEstadoDtoAndTrabajoDtoToTrabajoTiendaEstado(
							pocTiendaMapper.pocTiendaDtoToTrabajoTiendaEstadoDto(meta4Service.getTiendas(trabajo)),
							trabajo));
			LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.tiendasParametro(Tienda): {}", trabajo.getId(),
					result);
		} else if (StringUtils.isNotBlank(trabajo.getIdPais()) && StringUtils.isNotBlank(trabajo.getIdEmpresa())) {
			// TODO Pais + Empresa :: Se obtienen las tiendas por pais y empresa
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.tiendasParametro(Pais Empresa): {} {}",
					trabajo.getId(), trabajo.getIdPais(), trabajo.getIdEmpresa());
			LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.tiendasParametro(Pais Empresa): {}", trabajo.getId(),
					result);
		} else if (StringUtils.isNotBlank(trabajo.getIdPais())) {
			// TODO Pais :: Se obtienen las tiendas por pais
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.tiendasParametro(Pais): {}", trabajo.getId(),
					trabajo.getIdPais());
			LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.tiendasParametro(Pais): {}", trabajo.getId(),
					result);
		}

		if (CollectionUtils.isNotEmpty(result)) {
			result = trabajoTiendaMapper.trabajoTiendaToTrabajoTiendaDto(
					trabajoTiendaRepository.save(trabajoTiendaMapper.trabajoTiendaDtoToTrabajoTienda(result)));
		}

		LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.tiendasParametro(): {}", trabajo.getId(), result);
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> ventaTotalizadaTienda(@Valid final TrabajoDto trabajo,
			@NotNull List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.ventaTotalizadaTienda(): {} {}", trabajo.getId(),
				trabajo, tipoTrabajoTienda);

		Pageable pageable = new PageRequest(0, ventaTotalizadoDto.getFilter().getMaxPageSize());
		Page<TrabajoTiendaEstado> tiendasPage;

		List<Long> tipoTrabajoTiendaId = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(tipoTrabajoTienda)) {
			tipoTrabajoTienda.forEach(item -> {
				tipoTrabajoTiendaId.add(item.getId());
			});
		}

		List<GetVentaTotalizadoResponseItemDTO> result = new ArrayList<>();
		List<CompletableFuture<Void>> cfTrabajoTiendaSeccionVentaList = new ArrayList<>();
		
		do {
			CompletableFuture<GetVentaTotalizadoResponseDTO> cfResponse = new CompletableFuture<>();
			// Se recuperan las tiendas por id de trabajo y estado de forma paginada.
			tiendasPage = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoIdAndTipoIdIn(trabajo.getId(),
					AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), tipoTrabajoTiendaId, pageable);
			if (CollectionUtils.isNotEmpty(tiendasPage.getContent())) {
				List<String> tiendas = tiendasPage.getContent().stream().map(TrabajoTiendaEstado::getIdTienda)
						.collect(Collectors.toList());
				GetVentaTotalizadoRequestDTO paramGetVentaTotalizado = trabajoMapper
						.trabajoDtoToGetVentaTotalizadoRequestDTO(trabajo);
				paramGetVentaTotalizado.setTienda(tiendas);
				paramGetVentaTotalizado.setPais("11");
				paramGetVentaTotalizado.setCadena("1");
				paramGetVentaTotalizado.setAgrupacion(PtrConstants.AGRUPACION_TOTALIZADA);
				cfResponse = ptrVentaService.getVentaTotalizado(paramGetVentaTotalizado);
				GetVentaTotalizadoResponseDTO response = cfResponse.get();

				if (cfTrabajoTiendaSeccionVentaList.size() >= ventaTotalizadoDto.getFilter().getMaxPersistenceSize()) {
					CompletableFuture.anyOf(cfTrabajoTiendaSeccionVentaList
							.toArray(new CompletableFuture[cfTrabajoTiendaSeccionVentaList.size()]));
					Map<Boolean, List<CompletableFuture<Void>>> resultPersistence = cfTrabajoTiendaSeccionVentaList
							.stream().collect(Collectors.partitioningBy(CompletableFuture::isDone));
					List<CompletableFuture<Void>> cfPersistence = resultPersistence.values().stream()
							.flatMap(List::stream).collect(Collectors.toList());
					cfTrabajoTiendaSeccionVentaList.removeAll(cfPersistence);
				}

				cfTrabajoTiendaSeccionVentaList
						.add(trabajoTiendaSeccionVentaService.save(response.getVentaTotalizado(), trabajo));

				if (CollectionUtils.isNotEmpty(response.getVentaTotalizado())) {
					result.addAll(response.getVentaTotalizado());
				}
				
			}
			
			pageable = tiendasPage.nextPageable();
			
		} while (tiendasPage.hasNext());

		CompletableFuture.allOf(
				cfTrabajoTiendaSeccionVentaList.toArray(new CompletableFuture[cfTrabajoTiendaSeccionVentaList.size()]))
				.join();

		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.ventaTotalizadaTienda()", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> condicionesEmpleados(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.condicionesEmpleados(): {}", trabajo.getId(),
				trabajo);

		// TODO Recuperamos las condiciones de las estructuras
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.condicionesEmpleados() :: Thread.sleep({})",
				trabajo.getId(), time);
		Thread.sleep(time);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.condicionesEmpleados() :: Thread.sleep({})",
				trabajo.getId(), time);

		LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.condicionesEmpleados(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> ventaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.ventaDetalleEmpleado(): {}", trabajo.getId(), trabajo);

		Pageable pageable = new PageRequest(0, ventaIndividualDetalleDto.getFilter().getMaxPageSize());
		Page<TrabajoEmpleadoEstado> empleadosPage;

		List<GetVentaIndividualDetalleResponseItemDTO> result = new ArrayList<>();

		List<CompletableFuture<Void>> cfTrabajoTiendaSeccionEmpleadoVentaList = new ArrayList<>();

		do {
			CompletableFuture<GetVentaIndividualDetalleResponseDTO> cfResponse = new CompletableFuture<>();
			// Se recuperan los empleados por id de trabajo y estado de forma paginada.

			empleadosPage = trabajoEmpleadoEstadoRepository.findByTrabajoIdAndEstadoId(trabajo.getId(),
					AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), pageable);
	
			if(CollectionUtils.isNotEmpty(empleadosPage.getContent())){
				List<String> empleados = empleadosPage.getContent().stream().map(TrabajoEmpleadoEstado::getIdEmpleado)
						.collect(Collectors.toList());
				GetVentaIndividualDetalleRequestDTO paramGetVentaIndividualDetalle = trabajoMapper
						.trabajoDtoToGetVentaIndividualDetalleRequestDTO(trabajo);
				paramGetVentaIndividualDetalle.setVendedores(empleados);
				paramGetVentaIndividualDetalle.setPais("11");
				paramGetVentaIndividualDetalle.setCadena("1");
				paramGetVentaIndividualDetalle.setAgrupacion(PtrConstants.AGRUPACION_INDIVIDUAL);
				cfResponse = ptrVentaService.getVentaIndividualDetalle(paramGetVentaIndividualDetalle);
				GetVentaIndividualDetalleResponseDTO response = cfResponse.get();
	
				if (cfTrabajoTiendaSeccionEmpleadoVentaList.size() >= ventaIndividualDetalleDto.getFilter()
						.getMaxPersistenceSize()) {
					CompletableFuture.anyOf(cfTrabajoTiendaSeccionEmpleadoVentaList
							.toArray(new CompletableFuture[cfTrabajoTiendaSeccionEmpleadoVentaList.size()]));
					Map<Boolean, List<CompletableFuture<Void>>> resultPersistence = cfTrabajoTiendaSeccionEmpleadoVentaList
							.stream().collect(Collectors.partitioningBy(CompletableFuture::isDone));
					List<CompletableFuture<Void>> cfPersistence = resultPersistence.values().stream().flatMap(List::stream)
							.collect(Collectors.toList());
					cfTrabajoTiendaSeccionEmpleadoVentaList.removeAll(cfPersistence);
				}
				// TODO: PERSISTIR
	//			cfTrabajoTiendaSeccionEmpleadoVentaList.add(trabajoTiendaSeccionVentaService.save(response.getVentaTotalizado(), trabajo));
	
				if (response != null && response.getVentaIndividualDetalle() != null
						&& response.getVentaIndividualDetalle().size() > 0) {
					result.addAll(response.getVentaIndividualDetalle());
				}
			}
			
			pageable = empleadosPage.nextPageable();
			
		} while (empleadosPage.hasNext());

		CompletableFuture.allOf(cfTrabajoTiendaSeccionEmpleadoVentaList
				.toArray(new CompletableFuture[cfTrabajoTiendaSeccionEmpleadoVentaList.size()])).join();

		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.ventaDetalleEmpleado(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> tiposHoras(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.tiposHoras(): {}", trabajo.getId(), trabajo);

		// TODO Recuperamos los tipos de hora
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.tiposHoras() :: Thread.sleep({})", trabajo.getId(),
				time);
		Thread.sleep(time);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.tiposHoras() :: Thread.sleep({})", trabajo.getId(),
				time);

		LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.tiposHoras(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> tiendasHistorico(@Valid TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.tiendasHistorico(): {}", trabajo.getId(), trabajo);
		List<TrabajoTienda> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.tiendasHistorico(Tienda): {}", trabajo.getId(),
					trabajo.getTiendas());

			// TODO En el caso de que la ejecución se realice por tienda, se recuperan las
			// tiendas asociadas al empleado en su histórico
			Random random = new Random();
			LongStream ls = random.longs(1000, 5000);
			long time = ls.findFirst().getAsLong();
			ls.close();
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.tiendasHistorico() :: Thread.sleep({})",
					trabajo.getId(), time);
			Thread.sleep(time);
			LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.tiendasHistorico() :: Thread.sleep({})",
					trabajo.getId(), time);

			LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.tiendasHistorico(Tienda): {}", trabajo.getId(),
					result);
		}

		LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.tiendasHistorico(): {}", trabajo.getId(), result);
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public CompletableFuture<Void> presenciaTotalizadaTienda(@Valid TrabajoDto trabajo,
			@NotNull List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.presenciaTotalizadaTienda(): {} {}", trabajo.getId(),
				trabajo, tipoTrabajoTienda);

		Pageable pageable = new PageRequest(0, presenciasTotalTiendaSeccionDto.getFilter().getMaxPageSize());
		Page<TrabajoTiendaEstado> tiendasPage;
		
		List<Long> tipoTrabajoTiendaId = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(tipoTrabajoTienda)) {
			tipoTrabajoTienda.forEach(item -> {
				tipoTrabajoTiendaId.add(item.getId());
			});
		}

		List<PresenciasTotalTiendaSeccionResponseDto> result = new ArrayList<>();
		List<CompletableFuture<Void>> cfTrabajoTiendaPresenciaList = new ArrayList<>();

		do {
			// Se recuperan las tiendas por id de trabajo y estado de forma paginada.
			tiendasPage = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoIdAndTipoIdIn(trabajo.getId(),
					AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), tipoTrabajoTiendaId, pageable);
		
			if(tiendasPage != null && !tiendasPage.getContent().isEmpty()){
			
				CompletableFuture<List<PresenciasTotalTiendaSeccionResponseDto>> cfResponse = new CompletableFuture<>(); 
				List<TiendaSeccionDto> tiendas = tiendasPage.getContent().stream().map(t -> new TiendaSeccionDto(Integer.valueOf(t.getIdTienda()), null))
						.collect(Collectors.toList());
				PresenciasTotalTiendaSeccionRequestDto paramPresenciasTotalTiendaSeccion = trabajoMapper
						.trabajoDtoToPresenciasTotalTiendaSeccionRequestDto(trabajo);
				paramPresenciasTotalTiendaSeccion.setCadena(1);
				paramPresenciasTotalTiendaSeccion.setTiendaSeccion(tiendas);
				List<PresenciasTotalTiendaSeccionResponseDto> response = ptrPresenciaService.PresenciasTotalTiendaSeccion(paramPresenciasTotalTiendaSeccion);

				if(cfTrabajoTiendaPresenciaList.size() >= ventaIndividualDetalleDto.getFilter().getMaxPersistenceSize()){
					CompletableFuture.anyOf(cfTrabajoTiendaPresenciaList
							.toArray(new CompletableFuture[cfTrabajoTiendaPresenciaList.size()]));
					Map<Boolean, List<CompletableFuture<Void>>> resultPersistence = cfTrabajoTiendaPresenciaList
							.stream().collect(Collectors.partitioningBy(CompletableFuture::isDone));
					List<CompletableFuture<Void>> cfPersistence = resultPersistence.values().stream()
							.flatMap(List::stream).collect(Collectors.toList());
					cfTrabajoTiendaPresenciaList.removeAll(cfPersistence);
				}
				
				//TODO: Persist
				
				trabajoTiendaSeccionPresenciaService.save(response);

				if (response != null && !response.isEmpty()) {
					result.addAll(response);
				}
				
				pageable = tiendasPage.nextPageable();
			}
			
		}while(tiendasPage.hasNext());

		CompletableFuture.allOf(
				cfTrabajoTiendaPresenciaList.toArray(new CompletableFuture[cfTrabajoTiendaPresenciaList.size()]))
				.join();
		
		LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.presenciaTotalizadaTienda(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> presenciaDetalleEmpleado(@Valid TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.presenciaDetalleEmpleado(): {}", trabajo.getId(),
				trabajo);

		// TODO Recuperamos el detalle de las presencias del empleado
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoRunAsyncService.presenciaDetalleEmpleado() :: Thread.sleep({})",
				trabajo.getId(), time);
		Thread.sleep(time);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.presenciaDetalleEmpleado() :: Thread.sleep({})",
				trabajo.getId(), time);

		LOG.info("Trabajo[{}] :: Fin :: TrabajoRunAsyncService.presenciaDetalleEmpleado(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public void exceptionally(TrabajoDto trabajo, CompletableFuture<?> cf, List<CompletableFuture<?>> cfList)
			throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: AsyncService.exceptionally()", trabajo.getId());
		// Agregamos el cf a la lista del ejecutor
		cfList.add(cf);
		// Si falla, dejamos traza, y cancelamos todos los pendientes.
		cf.exceptionally(e -> {
			LOG.error("Trabajo[{}] :: Inicio :: AsyncService.exceptionally() :: cf.exceptionally()", trabajo.getId());
			cfList.stream().forEach(item -> {
				if (item.isDone()) {
					LOG.info("Trabajo[{}] :: AsyncService.exceptionally() :: cf.exceptionally() :: isDone()",
							trabajo.getId());
				} else {
					LOG.info("Trabajo[{}] :: Inicio :: AsyncService.exceptionally() :: cf.exceptionally() :: cancel()",
							trabajo.getId());
					item.cancel(true);
					LOG.info("Trabajo[{}] :: Fin :: AsyncService.exceptionally() :: cf.exceptionally() :: cancel()",
							trabajo.getId());
				}
			});
			LOG.error("Trabajo[{}] :: Fin :: AsyncService.exceptionally() :: cf.exceptionally()", trabajo.getId());
			return null;
		});
		LOG.info("Trabajo[{}] :: Fin :: AsyncService.exceptionally()", trabajo.getId());
	}

	@Override
	public boolean isOk(TrabajoDto trabajo, List<CompletableFuture<?>> cfList) throws Exception {
		boolean result = true;
		LOG.info("Trabajo[{}] :: Inicio :: AsyncService.isOk()", trabajo.getId());
		for (CompletableFuture<?> item : cfList) {
			if (item.isCompletedExceptionally()) {
				result = false;
				LOG.error("Trabajo[{}] :: AsyncService.isOk(): {}", trabajo.getId(), result);
				break;
			}
		}
		LOG.info("Trabajo[{}] :: Fin :: AsyncService.isOk(): {}", trabajo.getId(), result);
		return result;
	}

}