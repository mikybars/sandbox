package com.inditex.rrhh.icmclcwb.model.app.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.LongStream;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoRepository;

@Service
@Validated
public class TrabajoRunServiceImpl implements TrabajoRunService {

	@Autowired
	private Logger LOG;

	@Autowired
	private TrabajoService trabajoService;

	@Autowired
	private TrabajoRepository trabajoRepository;

	@Autowired
	private TrabajoMapper trabajoMapper;

	@Autowired
	private TrabajoRunAsyncService trabajoAsyncService;

	@Override
	public TrabajoDto run(@NotNull @Positive final Long id) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.run()", id);
		TrabajoDto result = trabajoMapper.trabajoToTrabajoDto(trabajoRepository.findOne(id));
		if (result != null) {
			result = runTrabajo(result);
		} else {
			LOG.error("Trabajo[{}] :: TrabajoService.run() :: No existe el trabajo en BBDD", id);
		}
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.run(): {}", id, result);
		return result;
	}

	@AuditoriaTrabajo
	@Override
	public TrabajoDto runTrabajo(@NotNull @Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.runTrabajo(): {}", trabajo.getId(), trabajo);
		runTrabajoDatos(trabajo);
		runTrabajoCalculado(trabajo);
		runTrabajoConsolidacion(trabajo);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.runTrabajo(): {}", trabajo.getId(), trabajo);
		return trabajo;
	}

	@AuditoriaTrabajo
	@Override
	public TrabajoDto runTrabajoDatos(@Valid final TrabajoDto trabajo) throws Exception {
		List<CompletableFuture<?>> cf = new ArrayList<>();
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.runTrabajoDatos(): {}", trabajo.getId(), trabajo);
		if (EstadoTrabajoEnum.PENDIENTE_DATOS.getId().equals(trabajo.getEstado().getId())) {
			trabajo.setFechaInicioTrabajo(LocalDateTime.now());
			trabajo.setEstado(EstadoTrabajoDto.builder().id(EstadoTrabajoEnum.EN_CURSO_DATOS.getId()).build());
			trabajoService.modifyTrabajo(trabajo);

			CompletableFuture<Void> cfTiendasParametro = trabajoAsyncService.tiendasParametro(trabajo);
			trabajoAsyncService.exceptionally(trabajo, cfTiendasParametro, cf);

			CompletableFuture<Void> cfTiendasHistorico = trabajoAsyncService.tiendasHistorico(trabajo);
			trabajoAsyncService.exceptionally(trabajo, cfTiendasHistorico, cf);

			cfTiendasParametro.get();
			if (trabajoAsyncService.isOk(trabajo, cf)) {
				CompletableFuture<Void> cfTiposHoras = trabajoAsyncService.tiposHoras(trabajo);
				trabajoAsyncService.exceptionally(trabajo, cfTiposHoras, cf);

				CompletableFuture<Void> cfEmpleados = trabajoAsyncService.empleadosTienda(trabajo);
				trabajoAsyncService.exceptionally(trabajo, cfEmpleados, cf);

				CompletableFuture<Void> cfVentaTotalizadaTienda = trabajoAsyncService.ventaTotalizadaTienda(trabajo,
						Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto(),
								AppConstants.TipoTrabajoTiendaEnum.PARAMETRO.getDto(),
								AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto()));
				trabajoAsyncService.exceptionally(trabajo, cfVentaTotalizadaTienda, cf);

				CompletableFuture<Void> cfPresenciaTotalizadaTienda = trabajoAsyncService.presenciaTotalizadaTienda(
						trabajo,
						Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto(),
								AppConstants.TipoTrabajoTiendaEnum.PARAMETRO.getDto(),
								AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto()));
				trabajoAsyncService.exceptionally(trabajo, cfPresenciaTotalizadaTienda, cf);

				cfEmpleados.get();
				if (trabajoAsyncService.isOk(trabajo, cf)) {
					CompletableFuture<Void> cfPresenciaDetalleEmpleado = trabajoAsyncService
							.presenciaDetalleEmpleado(trabajo);
					trabajoAsyncService.exceptionally(trabajo, cfPresenciaDetalleEmpleado, cf);

					CompletableFuture<Void> cfVentaDetalleEmpleado = trabajoAsyncService.ventaDetalleEmpleado(trabajo);
					trabajoAsyncService.exceptionally(trabajo, cfVentaDetalleEmpleado, cf);

					CompletableFuture<Void> cfCondicionesEmpleados = trabajoAsyncService.condicionesEmpleados(trabajo);
					trabajoAsyncService.exceptionally(trabajo, cfCondicionesEmpleados, cf);

					
					cfPresenciaDetalleEmpleado.get();
					if (trabajoAsyncService.isOk(trabajo, cf)) {
						if (CollectionUtils.isNotEmpty(trabajo.getTiendas())
								|| CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
							// Si la ejecución es de un tipo que puede agregar tiendas adicionales se llama
							// al proceso que recupera la informacion
							CompletableFuture<Void> cfVentaTotalizadaTiendaPresencia = trabajoAsyncService.ventaTotalizadaTienda(trabajo,
									Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.PRESENCIA.getDto()));
							trabajoAsyncService.exceptionally(trabajo, cfVentaTotalizadaTiendaPresencia, cf);
	
							CompletableFuture<Void> cfPresenciaTotalizadaTiendaPresencia = trabajoAsyncService.presenciaTotalizadaTienda(trabajo,
									Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.PRESENCIA.getDto()));
							trabajoAsyncService.exceptionally(trabajo, cfPresenciaTotalizadaTiendaPresencia, cf);
						}
	
						CompletableFuture.allOf(cf.toArray(new CompletableFuture[cf.size()]));
						if (trabajoAsyncService.isOk(trabajo, cf)) {
							trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.PENDIENTE_CALCULO.getDto(), trabajo);
						} else {
							trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.ERROR.getDto(), trabajo);
						}
					} else {
						trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.ERROR.getDto(), trabajo);
					}
				} else {
					trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.ERROR.getDto(), trabajo);
				}
			} else {
				trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.ERROR.getDto(), trabajo);
			}
		} else {
			LOG.warn("Trabajo[{}] :: TrabajoService.runTrabajoDatos() :: El estado del trabajo no es correcto",
					trabajo.getId());
		}
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.runTrabajoDatos(): {}", trabajo.getId(), trabajo);
		return trabajo;
	}

	@AuditoriaTrabajo
	@Override
	public TrabajoDto runTrabajoCalculado(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.runTrabajoCalculado(): {}", trabajo.getId(), trabajo);
		if (EstadoTrabajoEnum.PENDIENTE_CALCULO.getId().equals(trabajo.getEstado().getId())) {
			trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.EN_CURSO_CALCULO.getDto(), trabajo);
			Random random = new Random();
			LongStream ls = random.longs(1000, 5000);
			long time = ls.findFirst().getAsLong();
			ls.close();
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.runTrabajoCalculado() :: Thread.sleep({})",
					trabajo.getId(), time);
			Thread.sleep(time);
			LOG.info("Trabajo[{}] :: Fin :: TrabajoService.runTrabajoCalculado() :: Thread.sleep({})", trabajo.getId(),
					time);
			trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.PENDIENTE_CONSOLIDACION.getDto(), trabajo);
		} else {
			LOG.warn("Trabajo[{}] :: TrabajoService.runTrabajoCalculado() :: El estado del trabajo no es correcto",
					trabajo.getId());
		}
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.runTrabajoCalculado(): {}", trabajo.getId(), trabajo);
		return trabajo;
	}

	@AuditoriaTrabajo
	@Override
	public TrabajoDto runTrabajoConsolidacion(@Valid final TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.runTrabajoConsolidacion(): {}", trabajo.getId(), trabajo);
		if (EstadoTrabajoEnum.PENDIENTE_CONSOLIDACION.getId().equals(trabajo.getEstado().getId())) {
			trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.EN_CURSO_CONSOLIDACION.getDto(), trabajo);
			Random random = new Random();
			LongStream ls = random.longs(1000, 5000);
			long time = ls.findFirst().getAsLong();
			ls.close();
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.runTrabajoConsolidacion() :: Thread.sleep({})",
					trabajo.getId(), time);
			Thread.sleep(time);
			LOG.info("Trabajo[{}] :: Fin :: TrabajoService.runTrabajoConsolidacion() :: Thread.sleep({})",
					trabajo.getId(), time);
			trabajo.setFechaFinTrabajo(LocalDateTime.now());
			trabajo.setEstado(EstadoTrabajoEnum.FINALIZADO_SIN_ERRORES.getDto());
			trabajoService.modifyTrabajo(trabajo);
		} else {
			LOG.warn("Trabajo[{}] :: TrabajoService.runTrabajoConsolidacion() :: El estado del trabajo no es correcto",
					trabajo.getId());
		}
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.runTrabajoConsolidacion(): {}", trabajo.getId(), trabajo);
		return trabajo;
	}

}