package com.inditex.rrhh.icmclcwb.model.app.service;

import java.time.LocalDateTime;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaRepository;
import com.inditex.rrhh.icmclcwb.ms.SenderTrabajo;

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
	private SenderTrabajo sender;

	@Override
	public TrabajoDto createTrabajo(@Valid final TrabajoDto trabajo) {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.createTrabajo(): {}", trabajo.getId(), trabajo);
		trabajo.setFechaCreacion(LocalDateTime.now());
		trabajo.setEstado(AppConstants.EstadoTrabajoEnum.PENDIENTE_DATOS.getDto());
		// TODO Obtener el id del usuario que lanza la petición o poner un usuario
		// generico MQ
		trabajo.setIdUsuario("MANUAL");
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
	public TrabajoDto modifyTrabajo(@Valid final TrabajoDto trabajo) {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.modifyTrabajo(): {}", trabajo.getId(), trabajo);
		TrabajoDto result = trabajoMapper
				.trabajoToTrabajoDto(trabajoRepository.save(trabajoMapper.trabajoDtoToTrabajo(trabajo)));
		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.modifyTrabajo(): {}", trabajo.getId(), trabajo);
		return result;
	}

	@Override
	public TrabajoDto modifyEstadoTrabajo(@Valid final EstadoTrabajoDto estado, @Valid final TrabajoDto trabajo) {
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.modifyTrabajo(): {} {}", trabajo.getId(), estado, trabajo);

		trabajo.setEstado(estado);
		TrabajoDto result = modifyTrabajo(trabajo);

//		int i = trabajoRepository.updateEstadoTrabajo(trabajo.getId(), trabajoMapper.estadoTrabajoDtoToEstadoTrabajo(EstadoTrabajoDto.builder().id(id).build()));
//		int i = trabajoRepository.updateEstadoTrabajo(trabajo.getId(), id);
//		if (i > 0) {
//			LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.modifyTrabajo() :: trabajoRepository.updateEstadoTrabajo(): {}", trabajo.getId(), i);
//		} else {
//			LOG.error("Trabajo[{}] :: Inicio :: TrabajoService.modifyTrabajo() :: trabajoRepository.updateEstadoTrabajo(): {}", trabajo.getId(), i);
//		}
//		TrabajoDto result = trabajoMapper.trabajoToTrabajoDto(trabajoRepository.findOne(trabajo.getId()));

		LOG.info("Trabajo[{}] :: Fin :: TrabajoService.modifyTrabajo(): {} {}", trabajo.getId(), estado, trabajo);
		return result;
	}

}