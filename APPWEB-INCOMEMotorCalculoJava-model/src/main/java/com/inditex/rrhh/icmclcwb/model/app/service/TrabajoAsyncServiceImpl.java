package com.inditex.rrhh.icmclcwb.model.app.service;

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
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.service.Meta4SessionService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PTRVentaService;
import com.inditex.rrhh.icmclcwb.model.primary.repository.SessionRepository;

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

	@Async
	@Override
	public CompletableFuture<Void> empleadosTienda(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.empleadosTienda(): {}", trabajo.getId(), trabajo);
		List<EmpleadosTiendaResultItemDto> result = meta4Service.getEmpleadosTienda(trabajo);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.empleadosTienda(): {}", trabajo.getId(), result);
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> tiendas(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.getTiendasTrabajo(): {}", trabajo.getId(), trabajo);
		// Se recuperan las tiendas relacionadas con la ejecucion
		Set<String> result = new HashSet<>();
		if (StringUtils.isNotBlank(trabajo.getIdEmpleado())) {
			// TODO Empleado :: Obtener las tiendas comisionables en las que ha estado el
			// empleado
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.getTiendasTrabajo(IdEmpleado): {}", trabajo.getId(),
					trabajo.getIdEmpleado());
			LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.getTiendasTrabajo(IdEmpleado): {}", trabajo.getId(), result);
		} else if (StringUtils.isNotBlank(trabajo.getIdTienda())) {
			// TODO Tienda :: Directamente se usa la tienda enviada
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.getTiendasTrabajo(IdTienda): {}", trabajo.getId(),
					trabajo.getIdTienda());
			result.add(trabajo.getIdTienda());
			LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.getTiendasTrabajo(IdTienda): {}", trabajo.getId(), result);
		} else if (StringUtils.isNotBlank(trabajo.getIdPais()) && StringUtils.isNotBlank(trabajo.getIdCadena())) {
			// TODO Pais + Cadena :: Se obtienen las tiendas por pais y cadena
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.getTiendasTrabajo(IdPais IdCadena): {} {}", trabajo.getId(),
					trabajo.getIdPais(), trabajo.getIdCadena());
			LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.getTiendasTrabajo(IdPais IdCadena): {}", trabajo.getId(),
					result);
		} else if (StringUtils.isNotBlank(trabajo.getIdPais())) {
			// TODO Pais :: Se obtienen las tiendas por pais
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.getTiendasTrabajo(IdPais IdCadena): {}", trabajo.getId(),
					trabajo.getIdPais());
			LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.getTiendasTrabajo(IdPais IdCadena): {}", trabajo.getId(),
					result);
		}
		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.getTiendasTrabajo(): {}", trabajo.getId(), result);
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> ventaTotalizadaTienda(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.ventaTotalizadaTienda(): {}", trabajo.getId(), trabajo);
		GetVentaTotalizadoRequestDTO paramGetVentaTotalizado = new GetVentaTotalizadoRequestDTO();
		paramGetVentaTotalizado.setFechaDesde("2017-11-01");
		paramGetVentaTotalizado.setFechaHasta("2017-11-30");
		paramGetVentaTotalizado.setPais("11");
		paramGetVentaTotalizado.setCadena("1");
		// paramGetVentaTotalizado.setTienda(Arrays.asList("160"));
		paramGetVentaTotalizado.setTienda(new ArrayList<>());
		GetVentaTotalizadoResponseDTO getVentaTotalizadoResponse = ptrVentaService
				.getVentaTotalizado(paramGetVentaTotalizado);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.ventaTotalizadaTienda()", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> condicionesEmpleados(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.condicionesEmpleados(): {}", trabajo.getId(), trabajo);
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.condicionesEmpleados() :: Thread.sleep({})", trabajo.getId(), time);
		Thread.sleep(time);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.condicionesEmpleados() :: Thread.sleep({})", trabajo.getId(), time);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.condicionesEmpleados(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

	@Async
	@Override
	public CompletableFuture<Void> ventaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.ventaDetalleEmpleado(): {}", trabajo.getId(), trabajo);
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.ventaDetalleEmpleado() :: Thread.sleep({})", trabajo.getId(), time);
		Thread.sleep(time);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.ventaDetalleEmpleado() :: Thread.sleep({})", trabajo.getId(), time);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.ventaDetalleEmpleado(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public CompletableFuture<Void> tiposHoras(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.tiposHoras(): {}", trabajo.getId(), trabajo);
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoAsyncService.tiposHoras() :: Thread.sleep({})", trabajo.getId(), time);
		Thread.sleep(time);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.tiposHoras() :: Thread.sleep({})", trabajo.getId(), time);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoAsyncService.tiposHoras(): {}", trabajo.getId());
		return CompletableFuture.completedFuture(null);
	}

}