package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.EstadoTrabajo;

import org.mapstruct.Mapper;

@Mapper
public interface EstadoTrabajoMapper {

	EstadoTrabajoDto estadoTrabajoToEstadoTrabajoDto(EstadoTrabajo src);

	EstadoTrabajo estadoTrabajoDtoToEstadoTrabajo(EstadoTrabajoDto src);

}