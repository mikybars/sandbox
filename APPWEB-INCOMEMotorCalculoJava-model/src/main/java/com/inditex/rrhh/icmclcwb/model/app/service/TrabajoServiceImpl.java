package com.inditex.rrhh.icmclcwb.model.app.service;

import java.time.LocalDateTime;
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

import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.Constants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Programacion;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaRepository;
import com.inditex.rrhh.icmclcwb.ms.Sender;

@Service
@Validated
public class TrabajoServiceImpl implements TrabajoService {

	@Autowired
	private Logger LOG;

	@Autowired
	private TrabajoRepository trabajoRepository;

	@Autowired
	private TrabajoMapper trabajoMapper;
	
	@Autowired
	private TrabajoTiendaRepository trabajoTiendaRepository;
	
	@Autowired
	private TrabajoEmpleadoRepository trabajoEmpleadoRepository;

	@Autowired
	private TrabajoAsyncService trabajoAsyncService;

	@Autowired
	private Sender sender;

	@Override
	public TrabajoDto createTrabajo(@Valid final TrabajoDto trabajo) {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.createTrabajo(): {}", trabajo.getId(), trabajo);
		TrabajoDto parent = trabajoMapper
				.trabajoToTrabajoDto(trabajoRepository.save(trabajoMapper.trabajoDtoToTrabajo(trabajo)));
		parent.setTiendas(trabajo.getTiendas());
		parent.setEmpleados(trabajo.getEmpleados());
		Trabajo child = trabajoMapper.trabajoDtoToTrabajo(parent);
		if (CollectionUtils.isNotEmpty(child.getTiendas())) {
			child.setTiendas(trabajoTiendaRepository.save(child.getTiendas()));
		} else if (CollectionUtils.isNotEmpty(child.getEmpleados())) {
			child.setEmpleados(trabajoEmpleadoRepository.save(child.getEmpleados()));
		}
		TrabajoDto result = trabajoMapper.trabajoToTrabajoDto(child);
		sender.send(result);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.createTrabajo(): {}", result.getId(), result);
		return result;
	}

	@Override
	public TrabajoDto run(@NotNull @Positive final Long id) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.run()", id);
		TrabajoDto result = runTrabajo(trabajoMapper.trabajoToTrabajoDto(trabajoRepository.findOne(id)));
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.run(): {}", id, result);
		return result;
	}

	@Override
	public TrabajoDto runTrabajo(@NotNull @Valid TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.runTrabajo(): {}", trabajo.getId(), trabajo);
		trabajo = runTrabajoDatos(trabajo);
		trabajo = runTrabajoCalculado(trabajo);
		trabajo = runTrabajoConsolidacion(trabajo);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.runTrabajo(): {}", trabajo.getId(), trabajo);
		return trabajo;
	}

	@Override
	public TrabajoDto modifyTrabajo(@Valid final TrabajoDto trabajo) {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.modifyTrabajo(): {}", trabajo.getId(), trabajo);
		TrabajoDto result = trabajoMapper
				.trabajoToTrabajoDto(trabajoRepository.save(trabajoMapper.trabajoDtoToTrabajo(trabajo)));
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.modifyTrabajo(): {}", trabajo.getId(), trabajo);
		return result;
	}

	@Override
	public TrabajoDto modifyEstadoTrabajo(@NotNull @Positive final Long id, @Valid final TrabajoDto trabajo) {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.modifyTrabajo(): {} {}", trabajo.getId(), id, trabajo);

		trabajo.setEstado(EstadoTrabajoDto.builder().id(id).build());
		TrabajoDto result = modifyTrabajo(trabajo);

//		int i = trabajoRepository.updateEstadoTrabajo(trabajo.getId(), trabajoMapper.estadoTrabajoDtoToEstadoTrabajo(EstadoTrabajoDto.builder().id(id).build()));
//		int i = trabajoRepository.updateEstadoTrabajo(trabajo.getId(), id);
//		if (i > 0) {
//			LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.modifyTrabajo() :: trabajoRepository.updateEstadoTrabajo(): {}", trabajo.getId(), i);
//		} else {
//			LOG.error("Trabajo[{}] :: Inicio :: TrabajoService.modifyTrabajo() :: trabajoRepository.updateEstadoTrabajo(): {}", trabajo.getId(), i);
//		}
//		TrabajoDto result = trabajoMapper.trabajoToTrabajoDto(trabajoRepository.findOne(trabajo.getId()));

		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.modifyTrabajo(): {} {}", trabajo.getId(), id, trabajo);
		return result;
	}

	@Override
	public TrabajoDto runTrabajoDatos(@Valid TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.runTrabajoDatos(): {}", trabajo.getId(), trabajo);
		if (EstadoTrabajoEnum.PENDIENTE_DATOS.getId().equals(trabajo.getEstado().getId())) {
			trabajo.setFechaInicioTrabajo(LocalDateTime.now());
			trabajo.setEstado(EstadoTrabajoDto.builder().id(EstadoTrabajoEnum.EN_CURSO_DATOS.getId()).build());
			trabajo = modifyTrabajo(trabajo);

			// Almacenamos las tiendas relacionadas con el trabajo
			CompletableFuture<Void> cfTiendas = trabajoAsyncService.tiendas(trabajo);
			// TODO Se valida (si no se ha validado antes) que las tiendas sean
			// comisionables
			CompletableFuture<Void> cfTiposHoras = trabajoAsyncService.tiposHoras(trabajo);

			cfTiendas.get();
			// TODO ¡¡ Deberíamos poder buscar por tienda/s, pais + cadena y pais !!
			CompletableFuture<Void> cfEmpleados = trabajoAsyncService.empleadosTienda(trabajo);

			CompletableFuture<Void> cfVentaTotalizadaTienda = trabajoAsyncService.ventaTotalizadaTienda(trabajo);

			cfEmpleados.get();
			CompletableFuture<Void> cfVentaDetalleEmpleado = trabajoAsyncService.ventaDetalleEmpleado(trabajo);
			CompletableFuture<Void> cfCondicionesEmpleados = trabajoAsyncService.condicionesEmpleados(trabajo);

			CompletableFuture.allOf(cfTiposHoras, cfVentaTotalizadaTienda, cfVentaDetalleEmpleado,
					cfCondicionesEmpleados);

			trabajo = modifyEstadoTrabajo(EstadoTrabajoEnum.PENDIENTE_CALCULO.getId(), trabajo);
		} else {
			LOG.warn("Trabajo[{}] :: TrabajoService.runTrabajoDatos() :: El estado del trabajo no es correcto", trabajo.getId());
		}
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.runTrabajoDatos(): {}", trabajo.getId(), trabajo);
		return trabajo;
	}

	@Override
	public TrabajoDto runTrabajoCalculado(@Valid TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.runTrabajoCalculado(): {}", trabajo.getId(), trabajo);
		if (EstadoTrabajoEnum.PENDIENTE_CALCULO.getId().equals(trabajo.getEstado().getId())) {
			trabajo = modifyEstadoTrabajo(EstadoTrabajoEnum.EN_CURSO_CALCULO.getId(), trabajo);
			Random random = new Random();
			LongStream ls = random.longs(1000, 5000);
			long time = ls.findFirst().getAsLong();
			ls.close();
			LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.runTrabajoCalculado() :: Thread.sleep({})",
					trabajo.getId(), time);
			Thread.sleep(time);
			LOG.info("Trabajo[{}] :: Fin :: TrabajoService.runTrabajoCalculado() :: Thread.sleep({})",
					trabajo.getId(), time);
			trabajo = modifyEstadoTrabajo(EstadoTrabajoEnum.PENDIENTE_CONSOLIDACION.getId(), trabajo);
		} else {
			LOG.warn("Trabajo[{}] :: TrabajoService.runTrabajoCalculado() :: El estado del trabajo no es correcto", trabajo.getId());
		}
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.runTrabajoCalculado(): {}", trabajo.getId(), trabajo);
		return trabajo;
	}

	@Override
	public TrabajoDto runTrabajoConsolidacion(@Valid TrabajoDto trabajo) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.runTrabajoConsolidacion(): {}", trabajo.getId(), trabajo);
		if (EstadoTrabajoEnum.PENDIENTE_CONSOLIDACION.getId().equals(trabajo.getEstado().getId())) {
			trabajo = modifyEstadoTrabajo(EstadoTrabajoEnum.EN_CURSO_CONSOLIDACION.getId(), trabajo);
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
			trabajo.setEstado(EstadoTrabajoDto.builder().id(EstadoTrabajoEnum.FINALIZADO_SIN_ERRORES.getId()).build());
			trabajo = modifyTrabajo(trabajo);
		} else {
			LOG.warn("Trabajo[{}] :: TrabajoService.runTrabajoConsolidacion() :: El estado del trabajo no es correcto", trabajo.getId());
		}
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.runTrabajoConsolidacion(): {}", trabajo.getId(), trabajo);
		return trabajo;
	}

}