package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciasDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciasTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciasTotalTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockDetalle;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTotalTienda;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTotalTiendaSeccion;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTiposHoras;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface PtrPresenciasMockMapper {

    // PRESENCIAS DETALLE
    PtrPresenciasDetalleResultItemDto asPresenciaDetalleDto(PtrPresenciasMockDetalle src);

    List<PtrPresenciasDetalleResultItemDto> asPresenciaDetalleDtos(List<PtrPresenciasMockDetalle> src);

    // PRESENCIAS DETALLE COMISIONABLE
    PtrPresenciasDetalleComisionableResultItemDto asPresenciaDetalleComisionableDto(PtrPresenciasMockDetalle src);

    List<PtrPresenciasDetalleComisionableResultItemDto> asPresenciaDetalleComisionableDtos(
            List<PtrPresenciasMockDetalle> src);

    // PRESENCIAS TIENDA
    PtrPresenciasTotalTiendaResultItemDto asPresenciasTotalTiendaDto(PtrPresenciasMockTotalTienda src);

    List<PtrPresenciasTotalTiendaResultItemDto> asPresenciasTotalTiendaDtos(List<PtrPresenciasMockTotalTienda> src);

    // PRESENCIAS TIENDA SECCION
    PtrPresenciasTotalTiendaSeccionResultItemDto asPresenciasTotalTiendaSeccionDto(
            PtrPresenciasMockTotalTiendaSeccion src);

    List<PtrPresenciasTotalTiendaSeccionResultItemDto> asPresenciasTotalTiendaSeccionDtos(
            List<PtrPresenciasMockTotalTiendaSeccion> src);

    // TIPOS HORAS
    PtrPresenciasTiposHorasResultItemDto asTiposHorasDto(PtrPresenciasMockTiposHoras src);

    List<PtrPresenciasTiposHorasResultItemDto> asTiposHorasDtos(List<PtrPresenciasMockTiposHoras> src);

}