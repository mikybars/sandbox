package com.inditex.rrhh.icmclcwb.model.secondary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciasTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockDetalleComisionable;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockDetalle;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTotalTienda;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTotalTiendaSeccion;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTiposHoras;

public interface PtrPresenciasMockRepository {

    List<PtrPresenciasMockDetalle> findPresencias(PtrPresenciasDetalleRequestDto request);

    List<PtrPresenciasMockDetalleComisionable> findPresenciasComisionable(Object[] request);

    List<PtrPresenciasMockTotalTienda> findPresenciasTotalTienda(PtrPresenciasTotalTiendaRequestDto request);

    List<PtrPresenciasMockTotalTiendaSeccion> findPresenciasTotalTiendaSeccion(
            PtrPresenciasTotalTiendaSeccionRequestDto request);

    List<PtrPresenciasMockTiposHoras> findTiposHoras(PtrPresenciasTiposHorasRequestDto request);

}