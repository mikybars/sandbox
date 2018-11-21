package com.inditex.rrhh.icmclcwb.model.secondary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockDetalleComisionable;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockDetalle;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTotalTienda;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTotalTiendaSeccion;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTiposHoras;

public interface PtrPresenciasMockRepository {

	List<PtrPresenciasMockDetalle> findPresencias(PtrPresenciasMockDetalleRequestDto request);

	List<PtrPresenciasMockDetalleComisionable> findPresenciasComisionable(Object[] request);

	List<PtrPresenciasMockTotalTienda> findPresenciasTotalTienda(PtrPresenciasMockTotalTiendaRequestDto request);

	List<PtrPresenciasMockTotalTiendaSeccion> findPresenciasTotalTiendaSeccion(
			PtrPresenciasMockTotalTiendaSeccionRequestDto request);

	List<PtrPresenciasMockTiposHoras> findTiposHoras(PtrPresenciasMockTiposHorasRequestDto request);

}