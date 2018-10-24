package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ChunkService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.Constants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoRepository;
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
	private ChunkService chunkService;

	@Autowired
	private Sender sender;

	@Override
	public TrabajoDto createTrabajo(@Valid TrabajoDto trabajo) {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.createTrabajo(): {}", trabajo.getId(), trabajo);
		TrabajoDto result = trabajoMapper
				.trabajoToTrabajoDto(trabajoRepository.save(trabajoMapper.trabajoDtoToTrabajo(trabajo)));
		sender.send(result);
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.createTrabajo(): {}", trabajo.getId(), result);
		return result;
	}

	@Override
	public TrabajoDto run(@NotNull @NegativeOrZero Long id) throws Exception {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.run()", id);
		TrabajoDto result = runTrabajo(trabajoMapper.trabajoToTrabajoDto(trabajoRepository.findOne(id)));
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.run(): {}", id, result);
		return result;
	}

	@Override
	public TrabajoDto runTrabajo(@Valid TrabajoDto trabajo) throws Exception {
		
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.runTrabajo(): {}", trabajo.getId(), trabajo);

		trabajo = modifyEstadoTrabajo(EstadoTrabajoEnum.ESTADO_TRABAJO_EN_CURSO_VALIDACIONES_INICIALES.getId(),
				trabajo);

		// Almacenamos las tiendas relacionadas con el trabajo
		CompletableFuture<Void> cfTiendas = chunkService.tiendas(trabajo);
		// TODO Se valida (si no se ha validado antes) que las tiendas sean comisionables
		CompletableFuture<Void> cfTiposHoras = chunkService.tiposHoras(trabajo);
		
		cfTiendas.get();
		// TODO ¡¡ Deberíamos poder buscar por tienda/s, pais + cadena y pais !!
		CompletableFuture<Void> cfEmpleados = chunkService.empleadosTienda(trabajo);
		
		CompletableFuture<Void> cfVentaTotalizadaTienda = chunkService.ventaTotalizadaTienda(trabajo);
		
		cfEmpleados.get();
		CompletableFuture<Void> cfVentaDetalleEmpleado = chunkService.ventaDetalleEmpleado(trabajo);
		CompletableFuture<Void> cfCondicionesEmpleados = chunkService.condicionesEmpleados(trabajo);

		CompletableFuture.allOf(cfTiposHoras, cfVentaTotalizadaTienda, cfVentaDetalleEmpleado, cfCondicionesEmpleados);
		
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.runTrabajo(): {}", trabajo.getId(), trabajo);
		
		return trabajo;
	}

	@Override
	public TrabajoDto modifyTrabajo(@Valid TrabajoDto trabajo) {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.modifyTrabajo(): {}", trabajo.getId(), trabajo);
		TrabajoDto result = trabajoMapper
				.trabajoToTrabajoDto(trabajoRepository.save(trabajoMapper.trabajoDtoToTrabajo(trabajo)));
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.modifyTrabajo(): {}", trabajo.getId(), trabajo);
		return result;
	}

	@Override
	public TrabajoDto modifyEstadoTrabajo(@NotNull @NegativeOrZero final Long id, @Valid TrabajoDto trabajo) {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.modifyTrabajo(): {} {}", trabajo.getId(), id, trabajo);
		trabajo.setEstado(EstadoTrabajoDto.builder().id(id).build());
		TrabajoDto result = modifyTrabajo(trabajo);
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.modifyTrabajo(): {} {}", trabajo.getId(), id, trabajo);
		return result;
	}

}