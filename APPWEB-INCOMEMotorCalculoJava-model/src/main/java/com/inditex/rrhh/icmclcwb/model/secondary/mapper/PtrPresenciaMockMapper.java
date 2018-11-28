package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciaMockDetalle;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciaMockTotalTienda;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciaMockTotalTiendaSeccion;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciaMockTiposHoras;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface PtrPresenciaMockMapper {

    // PRESENCIAS DETALLE
    PtrPresenciaDetalleResultItemDto asPresenciaDetalleDto(PtrPresenciaMockDetalle src);

    List<PtrPresenciaDetalleResultItemDto> asPresenciaDetalleDtos(List<PtrPresenciaMockDetalle> src);

    // PRESENCIAS DETALLE COMISIONABLE
    PtrPresenciaDetalleComisionableResultItemDto asPresenciaDetalleComisionableDto(PtrPresenciaMockDetalle src);

    List<PtrPresenciaDetalleComisionableResultItemDto> asPresenciaDetalleComisionableDtos(
            List<PtrPresenciaMockDetalle> src);

    // PRESENCIAS TIENDA
    PtrPresenciaTotalTiendaResultItemDto asPresenciasTotalTiendaDto(PtrPresenciaMockTotalTienda src);

    List<PtrPresenciaTotalTiendaResultItemDto> asPresenciasTotalTiendaDtos(List<PtrPresenciaMockTotalTienda> src);

    // PRESENCIAS TIENDA SECCION
    PtrPresenciaTotalTiendaSeccionResultItemDto asPresenciasTotalTiendaSeccionDto(
            PtrPresenciaMockTotalTiendaSeccion src);

    List<PtrPresenciaTotalTiendaSeccionResultItemDto> asPresenciasTotalTiendaSeccionDtos(
            List<PtrPresenciaMockTotalTiendaSeccion> src);

    // TIPOS HORAS
    PtrPresenciaTiposHorasResultItemDto asTiposHorasDto(PtrPresenciaMockTiposHoras src);

    List<PtrPresenciaTiposHorasResultItemDto> asTiposHorasDtos(List<PtrPresenciaMockTiposHoras> src);

}