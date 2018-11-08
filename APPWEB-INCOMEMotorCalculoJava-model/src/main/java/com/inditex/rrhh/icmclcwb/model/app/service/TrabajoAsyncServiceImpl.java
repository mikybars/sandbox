package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.Constants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.service.Meta4SessionService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseItemDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PTRVentaService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.poc.PocTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTienda;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;
import com.inditex.rrhh.icmclcwb.model.primary.repository.SessionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaRepository;

@Service
@Validated
public class TrabajoAsyncServiceImpl implements TrabajoAsyncService {

	@Autowired
	private Logger LOG;

	@Autowired
	private Meta4SessionService meta4Service;

	@Autowired
	private PTRVentaService ptrVentaService;

	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private TrabajoEmpleadoEstadoService trabajoEmpleadoService;
	
	@Autowired
	private TrabajoTiendaSeccionVentaService trabajoTiendaSeccionVentaService;

	@Autowired
	private TrabajoMapper trabajoMapper;

	@Autowired
	private TrabajoTiendaRepository trabajoTiendaRepository;

	@Autowired
	private TrabajoTiendaEstadoRepository trabajoTiendaEstadoRepository;

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
	@Qualifier("ptrClientVentaDto")
	private PtrPropertiesDto ptrClientVentaDto;

	@Async
	@Override
	public CompletableFuture<Void> empleadosTienda(@Valid final TrabajoDto trabajo) {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.empleadosTienda(): {}", trabajo.getId(), trabajo);

		// TODO ¡¡ Deberíamos poder buscar por tienda/s, pais + empresa y pais !!
		// Cuando tengamos tiendas de tipo parametro se busca directamente, sino podemos
		// decidir si usar las tiendas o buscar directamente por pais/empresa

		// Request para la consulta de tiendas
		PageRequest pageable = new PageRequest(0, getEmpleadosTiendaDto.getFilter().getMaxPageSize());
		Page<TrabajoTiendaEstado> tiendasPage;

		// Request para la consulta en meta4
		EmpleadosTiendaRequestDto request = new EmpleadosTiendaRequestDto();
		EmpleadosTiendaFilterDto data = trabajoMapper.trabajoDtotoEmpleadosTiendaFilterDto(trabajo);
		request.setPage(getEmpleadosTiendaDto.getPage());
		request.setData(data);

		List<EmpleadosTiendaResultItemDto> result = new ArrayList<>();

		do {
			// Se recuperan las tiendas por id de trabajo y estado de forma paginada.
			tiendasPage = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoId(trabajo.getId(),
					Constants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), pageable);
			LOG.info(
					"Trabajo[{}] :: Inicio :: TrabajoAsyncService.empleadosTienda(): trabajoTiendaRepository.findByTrabajoIdEstadoId(): {}",
					trabajo.getId(), tiendasPage);

			List<CompletableFuture<Void>> cfTrabajoEmpleadoSaveList = new ArrayList<>();

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
						throw new ApplicationException("Futuro completado de forma excepcional: {}" + e.getMessage());
					}

					result.addAll(persist);

					List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoDto = trabajoEmpleadoEstadoMapper
							.empleadosTiendaResultItemDtoToTrabajoEmpleadoEstadoDto(persist, trabajo);

					CompletableFuture<Void> cfTrabajoEmpleadoSave = new CompletableFuture<>();

					if (cfTrabajoEmpleadoSaveList.size() < getEmpleadosTiendaDto.getFilter().getMaxPersistenceSize()) {
						// Comprobamos que tenemos asíncronos libres y persistimos los datos.

						cfTrabajoEmpleadoSave = trabajoEmpleadoService.save(trabajoEmpleadoDto);
						cfTrabajoEmpleadoSaveList.add(cfTrabajoEmpleadoSave);
					} else {
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
						cfTrabajoEmpleadoSaveList.add(trabajoEmpleadoService.save(trabajoEmpleadoDto));
					}

					// TODO: En caso de que la persistencia termine en este punto la eliminamos de
					// la lista.
					if (cfTrabajoEmpleadoSave.isDone()) {
						cfTrabajoEmpleadoSaveList.remove(cfTrabajoEmpleadoSave);
					}

				} while (request.getPage().hasNext());

			}

			// Comprobamos que todas las persistencias se han realizado y esperamos en caso
			// negativo.
			CompletableFuture
					.allOf(cfTrabajoEmpleadoSaveList.toArray(new CompletableFuture[cfTrabajoEmpleadoSaveList.size()]));

		} while (tiendasPage.hasNext());

		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.empleadosTienda(): {}", trabajo.getId(), result);
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> tiendasParametro(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.tiendasParametro(): {}", trabajo.getId(), trabajo);
		// Se recuperan las tiendas relacionadas con la ejecucion
		List<TrabajoTiendaDto> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
			// TODO Empleado :: Obtener las tiendas comisionables en las que ha estado el
			// empleado
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.tiendasParametro(Empleado): {}", trabajo.getId(),
					trabajo.getEmpleados());
			LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.tiendasParametro(Empleado): {}", trabajo.getId(),
					result);
		} else if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.tiendasParametro(Tienda): {}", trabajo.getId(),
					trabajo.getTiendas());
			trabajoTiendaEstadoRepository.save(trabajoTiendaEstadoMapper.trabajoTiendaEstadoDtoToTrabajoTiendaEstado(
					pocTiendaMapper.pocTiendaDtoToTrabajoTiendaEstadoDto(meta4Service.getTiendas(trabajo))));
			LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.tiendasParametro(Tienda): {}", trabajo.getId(), result);
		} else if (StringUtils.isNotBlank(trabajo.getIdPais()) && StringUtils.isNotBlank(trabajo.getIdEmpresa())) {
			// TODO Pais + Empresa :: Se obtienen las tiendas por pais y empresa
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.tiendasParametro(Pais Empresa): {} {}",
					trabajo.getId(), trabajo.getIdPais(), trabajo.getIdEmpresa());
			LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.tiendasParametro(Pais Empresa): {}", trabajo.getId(),
					result);
		} else if (StringUtils.isNotBlank(trabajo.getIdPais())) {
			// TODO Pais :: Se obtienen las tiendas por pais
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.tiendasParametro(Pais): {}", trabajo.getId(),
					trabajo.getIdPais());
			LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.tiendasParametro(Pais): {}", trabajo.getId(), result);
		}

		if (CollectionUtils.isNotEmpty(result)) {
			result = trabajoTiendaMapper.trabajoTiendaToTrabajoTiendaDto(
					trabajoTiendaRepository.save(trabajoTiendaMapper.trabajoTiendaDtoToTrabajoTienda(result)));
		}

		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.tiendasParametro(): {}", trabajo.getId(), result);
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> ventaTotalizadaTienda(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.ventaTotalizadaTienda(): {}", trabajo.getId(), trabajo);

		PageRequest pageable = new PageRequest(0, ptrClientVentaDto.getFilter().getMaxPageSize());
		Page<TrabajoTiendaEstado> tiendasPage;

		List<GetVentaTotalizadoResponseItemDTO> result = new ArrayList<>();
		
		List<CompletableFuture<Void>> cfTrabajoTiendaSeccionVentaList = new ArrayList<>();

		do {
			CompletableFuture<GetVentaTotalizadoResponseDTO> cfResponse = new CompletableFuture<>(); 
			// Se recuperan las tiendas por id de trabajo y estado de forma paginada.
			tiendasPage = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoId(trabajo.getId(),
					Constants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), pageable);
			List<String> tiendas =  tiendasPage.getContent().stream().map(TrabajoTiendaEstado::getIdTienda).collect(Collectors.toList());
			GetVentaTotalizadoRequestDTO paramGetVentaTotalizado = trabajoMapper.trabajoDtoToGetVentaTotalizadoRequestDTO(trabajo);
			paramGetVentaTotalizado.setTienda(tiendas);
			paramGetVentaTotalizado.setPais("11");
			paramGetVentaTotalizado.setCadena("1");
			paramGetVentaTotalizado.setAgrupacion("FECHA_TIENDA_SECCION");
			cfResponse = ptrVentaService
					.getVentaTotalizado(paramGetVentaTotalizado);
			GetVentaTotalizadoResponseDTO response = cfResponse.get();
			
			if(cfTrabajoTiendaSeccionVentaList.size() < ptrClientVentaDto.getFilter().getMaxPersistenceSize()){
				cfTrabajoTiendaSeccionVentaList.add(trabajoTiendaSeccionVentaService.save(response.getVentaTotalizado(), trabajo));
			}else{
				CompletableFuture.anyOf(cfTrabajoTiendaSeccionVentaList
						.toArray(new CompletableFuture[cfTrabajoTiendaSeccionVentaList.size()]));
				Map<Boolean, List<CompletableFuture<Void>>> resultPersistence = cfTrabajoTiendaSeccionVentaList
						.stream().collect(Collectors.partitioningBy(CompletableFuture::isDone));
				List<CompletableFuture<Void>> cfPersistence = resultPersistence.values().stream()
						.flatMap(List::stream).collect(Collectors.toList());
				cfTrabajoTiendaSeccionVentaList.removeAll(cfPersistence);
				cfTrabajoTiendaSeccionVentaList.add(trabajoTiendaSeccionVentaService.save(response.getVentaTotalizado(), trabajo));
			}
			
			result.addAll(response.getVentaTotalizado());
		} while (tiendasPage.hasNext());
		
		CompletableFuture
		.allOf(cfTrabajoTiendaSeccionVentaList.toArray(new CompletableFuture[cfTrabajoTiendaSeccionVentaList.size()])).join();

		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.ventaTotalizadaTienda()", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}


	@Async
	@Override
	public CompletableFuture<Void> condicionesEmpleados(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.condicionesEmpleados(): {}", trabajo.getId(), trabajo);

		// TODO Recuperamos las condiciones de las estructuras
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.condicionesEmpleados() :: Thread.sleep({})",
				trabajo.getId(), time);
		Thread.sleep(time);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.condicionesEmpleados() :: Thread.sleep({})",
				trabajo.getId(), time);

		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.condicionesEmpleados(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> ventaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.ventaDetalleEmpleado(): {}", trabajo.getId(), trabajo);

		// TODO Recuperamos el detalle de la venta del empleado
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.ventaDetalleEmpleado() :: Thread.sleep({})",
				trabajo.getId(), time);
		Thread.sleep(time);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.ventaDetalleEmpleado() :: Thread.sleep({})",
				trabajo.getId(), time);

		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.ventaDetalleEmpleado(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public CompletableFuture<Void> tiposHoras(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.tiposHoras(): {}", trabajo.getId(), trabajo);

		// TODO Recuperamos los tipos de hora
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.tiposHoras() :: Thread.sleep({})", trabajo.getId(),
				time);
		Thread.sleep(time);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.tiposHoras() :: Thread.sleep({})", trabajo.getId(), time);

		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.tiposHoras(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public CompletableFuture<Void> tiendasHistorico(@Valid TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.tiendasHistorico(): {}", trabajo.getId(), trabajo);
		List<TrabajoTienda> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.tiendasHistorico(Tienda): {}", trabajo.getId(),
					trabajo.getTiendas());

			// TODO En el caso de que la ejecución se realice por tienda, se recuperan las
			// tiendas asociadas al empleado en su histórico
			Random random = new Random();
			LongStream ls = random.longs(1000, 5000);
			long time = ls.findFirst().getAsLong();
			ls.close();
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.tiendasHistorico() :: Thread.sleep({})",
					trabajo.getId(), time);
			Thread.sleep(time);
			LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.tiendasHistorico() :: Thread.sleep({})",
					trabajo.getId(), time);

			LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.tiendasHistorico(Tienda): {}", trabajo.getId(), result);
		}

		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.tiendasHistorico(): {}", trabajo.getId(), result);
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public CompletableFuture<Void> presenciaTotalizadaTienda(@Valid TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.presenciaTotalizadaTienda(): {}", trabajo.getId(),
				trabajo);

		// TODO Recuperamos el total de las presencias de la tienda
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.presenciaTotalizadaTienda() :: Thread.sleep({})",
				trabajo.getId(), time);
		Thread.sleep(time);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.presenciaTotalizadaTienda() :: Thread.sleep({})",
				trabajo.getId(), time);

		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.presenciaTotalizadaTienda(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public CompletableFuture<Void> presenciaDetalleEmpleado(@Valid TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.presenciaDetalleEmpleado(): {}", trabajo.getId(),
				trabajo);

		// TODO Recuperamos el detalle de las presencias del empleado
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.presenciaDetalleEmpleado() :: Thread.sleep({})",
				trabajo.getId(), time);
		Thread.sleep(time);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.presenciaDetalleEmpleado() :: Thread.sleep({})",
				trabajo.getId(), time);

		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.presenciaDetalleEmpleado(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

}