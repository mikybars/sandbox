package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockDetalle;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTotalTienda;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTotalTiendaSeccion;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTiposHoras;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface PtrPresenciasMockMapper {
	// PRESENCIAS DETALLE
	PtrPresenciasMockDetalleResponseDto asPresenciaDetalleDTO(PtrPresenciasMockDetalle src);

	List<PtrPresenciasMockDetalleResponseDto> asPresenciaDetalleDTOs(List<PtrPresenciasMockDetalle> src);
	
	// PRESENCIAS DETALLE COMISIONABLE
	PtrPresenciasMockDetalleComisionableResponseDto asPresenciaDetalleComisionableDTO(PtrPresenciasMockDetalle src);

	List<PtrPresenciasMockDetalleComisionableResponseDto> asPresenciaDetalleComisionableDTOs(List<PtrPresenciasMockDetalle> src);

	// PRESENCIAS TIENDA
	PtrPresenciasMockTotalTiendaResponseDto asPresenciasTotalTiendaDTO(PtrPresenciasMockTotalTienda src);

	List<PtrPresenciasMockTotalTiendaResponseDto> asPresenciasTotalTiendaDTOs(List<PtrPresenciasMockTotalTienda> src);

	// PRESENCIAS TIENDA SECCION
	PtrPresenciasMockTotalTiendaSeccionResponseDto asPresenciasTotalTiendaSeccionDTO(PtrPresenciasMockTotalTiendaSeccion src);

	List<PtrPresenciasMockTotalTiendaSeccionResponseDto> asPresenciasTotalTiendaSeccionDTOs(
			List<PtrPresenciasMockTotalTiendaSeccion> src);

	// TIPOS HORAS
	PtrPresenciasMockTiposHorasResponseDto asTiposHorasDTO(PtrPresenciasMockTiposHoras src);

	List<PtrPresenciasMockTiposHorasResponseDto> asTiposHorasDTOs(List<PtrPresenciasMockTiposHoras> src);

	
}