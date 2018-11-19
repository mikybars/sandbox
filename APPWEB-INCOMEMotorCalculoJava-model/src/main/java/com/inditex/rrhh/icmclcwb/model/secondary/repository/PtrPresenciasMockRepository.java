package com.inditex.rrhh.icmclcwb.model.secondary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleComisionableMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.TiposHorasMock;

public interface PtrPresenciasMockRepository {

    List<PresenciaDetalleMock> findPresencias(PresenciasDetalleRequestDto request);

    List<PresenciaDetalleComisionableMock> findPresenciasComisionable(Object[] request);

    List<PresenciaTotalTiendaMock> findPresenciasTotalTienda(PresenciasTotalTiendaRequestDto request);

    List<PresenciaTotalTiendaSeccionMock> findPresenciasTotalTiendaSeccion(
            PresenciasTotalTiendaSeccionRequestDto request);

    List<TiposHorasMock> findTiposHoras(TiposHorasRequestDto request);

}