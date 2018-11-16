package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.TiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleComisionableMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.TiposHorasMock;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface PresenciasMapper {

	// PRESENCIAS DETALLE COMISIONABLE
	PresenciasDetalleComisionableResponseDto asPresenciaDetalleComisionableDTO(PresenciaDetalleMock src);

	PresenciaDetalleMock asPresenciaDetalleComisionable(PresenciasDetalleComisionableRequestDto src);

	List<PresenciasDetalleComisionableResponseDto> asPresenciaDetalleComisionableDTOs(List<PresenciaDetalleMock> src);

	// PRESENCIAS DETALLE
	PresenciasDetalleResponseDto asPresenciaDetalleDTO(PresenciaDetalleMock src);

	List<PresenciasDetalleResponseDto> asPresenciaDetalleDTOs(List<PresenciaDetalleMock> src);

	// PRESENCIAS TIENDA
	PresenciasTotalTiendaResponseDto asPresenciasTotalTiendaDTO(PresenciaTotalTiendaMock src);

	PresenciaTotalTiendaMock asPresenciasTotalTienda(PresenciasTotalTiendaRequestDto src);

	List<PresenciasTotalTiendaResponseDto> asPresenciasTotalTiendaDTOs(List<PresenciaTotalTiendaMock> src);

	// PRESENCIAS TIENDA SECCION
	PresenciasTotalTiendaSeccionResponseDto asPresenciasTotalTiendaSeccionDTO(PresenciaTotalTiendaSeccionMock src);

	PresenciaTotalTiendaSeccionMock asPresenciasTotalTiendaSeccion(PresenciasTotalTiendaSeccionRequestDto src);

	List<PresenciasTotalTiendaSeccionResponseDto> asPresenciasTotalTiendaSeccionDTOs(
			List<PresenciaTotalTiendaSeccionMock> src);

	// TIPOS HORAS
	TiposHorasResponseDto asTiposHorasDTO(TiposHorasMock src);

	TiposHorasMock asTiposHoras(TiposHorasRequestDto src);

	List<TiposHorasResponseDto> asTiposHorasDTOs(List<TiposHorasMock> src);

	// COMISIONABLE A DETALLE REQUEST

	PresenciasDetalleRequestDto asPresenciaComisionableToDetalle(PresenciasDetalleComisionableRequestDto src);

}