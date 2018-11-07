package com.inditex.rrhh.icmclcwb.model.secondary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleComisionableMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.TiposHorasMock;



public interface PTRPresenciasRepositoryMock{

	List<PresenciaDetalleMock>findPresencias(PresenciasDetalleRequestDTO Dto);
	List<PresenciaDetalleComisionableMock> findPresenciasComisionable( Object[] Params);
	List<PresenciaTotalTiendaMock> findPresenciasTotalTienda( PresenciasTotalTiendaRequestDTO dto);
	List<PresenciaTotalTiendaSeccionMock> findPresenciasTotalTiendaSeccion(PresenciasTotalTiendaSeccionRequestDTO dto);
	List<TiposHorasMock> findTiposHoras(TiposHorasRequestDTO Params);
}
