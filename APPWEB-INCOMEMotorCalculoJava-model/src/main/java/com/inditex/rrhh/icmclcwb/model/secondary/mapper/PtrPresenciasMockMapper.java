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
    PtrPresenciasMockDetalleResponseDto asPresenciaDetalleDto(PtrPresenciasMockDetalle src);

    List<PtrPresenciasMockDetalleResponseDto> asPresenciaDetalleDtos(List<PtrPresenciasMockDetalle> src);

    // PRESENCIAS DETALLE COMISIONABLE
    PtrPresenciasMockDetalleComisionableResponseDto asPresenciaDetalleComisionableDto(PtrPresenciasMockDetalle src);

    List<PtrPresenciasMockDetalleComisionableResponseDto> asPresenciaDetalleComisionableDtos(
            List<PtrPresenciasMockDetalle> src);

    // PRESENCIAS TIENDA
    PtrPresenciasMockTotalTiendaResponseDto asPresenciasTotalTiendaDto(PtrPresenciasMockTotalTienda src);

    List<PtrPresenciasMockTotalTiendaResponseDto> asPresenciasTotalTiendaDtos(List<PtrPresenciasMockTotalTienda> src);

    // PRESENCIAS TIENDA SECCION
    PtrPresenciasMockTotalTiendaSeccionResponseDto asPresenciasTotalTiendaSeccionDto(
            PtrPresenciasMockTotalTiendaSeccion src);

    List<PtrPresenciasMockTotalTiendaSeccionResponseDto> asPresenciasTotalTiendaSeccionDtos(
            List<PtrPresenciasMockTotalTiendaSeccion> src);

    // TIPOS HORAS
    PtrPresenciasMockTiposHorasResponseDto asTiposHorasDto(PtrPresenciasMockTiposHoras src);

    List<PtrPresenciasMockTiposHorasResponseDto> asTiposHorasDtos(List<PtrPresenciasMockTiposHoras> src);

}