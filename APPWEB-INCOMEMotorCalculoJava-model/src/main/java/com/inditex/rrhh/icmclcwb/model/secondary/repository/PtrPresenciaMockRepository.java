package com.inditex.rrhh.icmclcwb.model.secondary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciaMockDetalleComisionable;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciaMockDetalle;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciaMockTotalTienda;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciaMockTotalTiendaSeccion;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciaMockTiposHoras;

public interface PtrPresenciaMockRepository {

    List<PtrPresenciaMockDetalle> findPresencias(PtrPresenciaDetalleRequestDto request);

    List<PtrPresenciaMockDetalleComisionable> findPresenciasComisionable(Object[] request);

    List<PtrPresenciaMockTotalTienda> findPresenciasTotalTienda(PtrPresenciaTotalTiendaRequestDto request);

    List<PtrPresenciaMockTotalTiendaSeccion> findPresenciasTotalTiendaSeccion(
            PtrPresenciaTotalTiendaSeccionRequestDto request);
    
    List<PtrPresenciaMockTiposHoras> findTiposHoras(PtrPresenciaTiposHorasRequestDto request);
    
    List<PtrPresenciaMockTiposHoras> findTiposHorasGroupBy(PtrPresenciaTiposHorasRequestDto request);

}