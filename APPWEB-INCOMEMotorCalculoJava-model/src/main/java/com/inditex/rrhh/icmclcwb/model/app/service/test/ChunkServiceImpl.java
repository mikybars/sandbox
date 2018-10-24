package com.inditex.rrhh.icmclcwb.model.app.service.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.LongStream;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ChunkService;
import com.inditex.rrhh.icmclcwb.api.app.service.Meta4Service;
import com.inditex.rrhh.icmclcwb.api.app.service.PTRVentaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseDTO;
import com.inditex.rrhh.icmclcwb.model.primary.repository.SessionRepository;

@Service
@Validated
public class ChunkServiceImpl implements ChunkService {

	@Autowired
	private Logger LOG;

	@Autowired
	private Meta4Service meta4Service;

	@Autowired
	private PTRVentaService ptrVentaService;

	@Autowired
	private SessionRepository sessionRepository;

	@Async
	@Override
	public CompletableFuture<Void> empleadosTienda(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: ChunkService.empleadosTienda(): {}", trabajo.getId(), trabajo);
		List<EmpleadosTiendaResultItemDto> result = meta4Service.getEmpleadosTienda(trabajo);
		LOG.info("Trabajo[{}] :: Fin :: ChunkService.empleadosTienda(): {}", trabajo.getId(), result);
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> tiendas(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: ChunkService.getTiendasTrabajo(): {}", trabajo.getId(), trabajo);
		// Se recuperan las tiendas relacionadas con la ejecucion
		Set<String> result = new HashSet<>();
		if (StringUtils.isNotBlank(trabajo.getIdEmpleado())) {
			// TODO Empleado :: Obtener las tiendas comisionables en las que ha estado el
			// empleado
			LOG.info("Trabajo[{}] :: Inicio :: ChunkService.getTiendasTrabajo(IdEmpleado): {}", trabajo.getId(),
					trabajo.getIdEmpleado());
			LOG.info("Trabajo[{}] :: Fin :: ChunkService.getTiendasTrabajo(IdEmpleado): {}", trabajo.getId(), result);
		} else if (StringUtils.isNotBlank(trabajo.getIdTienda())) {
			// TODO Tienda :: Directamente se usa la tienda enviada
			LOG.info("Trabajo[{}] :: Inicio :: ChunkService.getTiendasTrabajo(IdTienda): {}", trabajo.getId(),
					trabajo.getIdTienda());
			result.add(trabajo.getIdTienda());
			LOG.info("Trabajo[{}] :: Fin :: ChunkService.getTiendasTrabajo(IdTienda): {}", trabajo.getId(), result);
		} else if (StringUtils.isNotBlank(trabajo.getIdPais()) && StringUtils.isNotBlank(trabajo.getIdCadena())) {
			// TODO Pais + Cadena :: Se obtienen las tiendas por pais y cadena
			LOG.info("Trabajo[{}] :: Inicio :: ChunkService.getTiendasTrabajo(IdPais IdCadena): {} {}", trabajo.getId(),
					trabajo.getIdPais(), trabajo.getIdCadena());
			LOG.info("Trabajo[{}] :: Fin :: ChunkService.getTiendasTrabajo(IdPais IdCadena): {}", trabajo.getId(),
					result);
		} else if (StringUtils.isNotBlank(trabajo.getIdPais())) {
			// TODO Pais :: Se obtienen las tiendas por pais
			LOG.info("Trabajo[{}] :: Inicio :: ChunkService.getTiendasTrabajo(IdPais IdCadena): {}", trabajo.getId(),
					trabajo.getIdPais());
			LOG.info("Trabajo[{}] :: Fin :: ChunkService.getTiendasTrabajo(IdPais IdCadena): {}", trabajo.getId(),
					result);
		}
		LOG.info("Trabajo[{}] :: Fin :: ChunkService.getTiendasTrabajo(): {}", trabajo.getId(), result);
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> ventaTotalizadaTienda(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: ChunkService.ventaTotalizadaTienda(): {}", trabajo.getId(), trabajo);
		GetVentaTotalizadoRequestDTO paramGetVentaTotalizado = new GetVentaTotalizadoRequestDTO();
		paramGetVentaTotalizado.setFechaDesde("2017-11-01");
		paramGetVentaTotalizado.setFechaHasta("2017-11-30");
		paramGetVentaTotalizado.setPais("11");
		paramGetVentaTotalizado.setCadena("1");
		// paramGetVentaTotalizado.setTienda(Arrays.asList("160"));
		paramGetVentaTotalizado.setTienda(new ArrayList<>());
		GetVentaTotalizadoResponseDTO getVentaTotalizadoResponse = ptrVentaService
				.getVentaTotalizado(paramGetVentaTotalizado);
		LOG.info("Trabajo[{}] :: Fin :: ChunkService.ventaTotalizadaTienda()", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> condicionesEmpleados(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: ChunkService.condicionesEmpleados(): {}", trabajo.getId(), trabajo);
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("Trabajo[{}] :: Inicio :: ChunkService.condicionesEmpleados() :: Thread.sleep({})", trabajo.getId(), time);
		Thread.sleep(time);
		LOG.info("Trabajo[{}] :: Fin :: ChunkService.condicionesEmpleados() :: Thread.sleep({})", trabajo.getId(), time);
		LOG.info("Trabajo[{}] :: Fin :: ChunkService.condicionesEmpleados(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> ventaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: ChunkService.ventaDetalleEmpleado(): {}", trabajo.getId(), trabajo);
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("Trabajo[{}] :: Inicio :: ChunkService.ventaDetalleEmpleado() :: Thread.sleep({})", trabajo.getId(), time);
		Thread.sleep(time);
		LOG.info("Trabajo[{}] :: Fin :: ChunkService.ventaDetalleEmpleado() :: Thread.sleep({})", trabajo.getId(), time);
		LOG.info("Trabajo[{}] :: Fin :: ChunkService.ventaDetalleEmpleado(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public CompletableFuture<Void> tiposHoras(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: ChunkService.tiposHoras(): {}", trabajo.getId(), trabajo);
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("Trabajo[{}] :: Inicio :: ChunkService.tiposHoras() :: Thread.sleep({})", trabajo.getId(), time);
		Thread.sleep(time);
		LOG.info("Trabajo[{}] :: Fin :: ChunkService.tiposHoras() :: Thread.sleep({})", trabajo.getId(), time);
		LOG.info("Trabajo[{}] :: Fin :: ChunkService.tiposHoras(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

}