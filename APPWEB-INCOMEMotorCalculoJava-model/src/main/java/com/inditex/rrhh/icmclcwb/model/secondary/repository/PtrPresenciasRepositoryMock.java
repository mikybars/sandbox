package com.inditex.rrhh.icmclcwb.model.secondary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleComisionableMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.TiposHorasMock;



public interface PtrPresenciasRepositoryMock{

	List<PresenciaDetalleMock>findPresencias(PresenciasDetalleRequestDto Dto);
	List<PresenciaDetalleComisionableMock> findPresenciasComisionable( Object[] Params);
	List<PresenciaTotalTiendaMock> findPresenciasTotalTienda( PresenciasTotalTiendaRequestDto dto);
	List<PresenciaTotalTiendaSeccionMock> findPresenciasTotalTiendaSeccion(PresenciasTotalTiendaSeccionRequestDto dto);
	List<TiposHorasMock> findTiposHoras(TiposHorasRequestDto Params);
}
