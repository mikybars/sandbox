package com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaSeccionRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleComisionableMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.TiposHorasMock;



public interface PTRPresenciasRepositoryMock{

	List<PresenciaDetalleMock>findPresencias(PresenciasDetalleRequestDTO Dto);
	List<PresenciaDetalleComisionableMock> findPresenciasComisionable( Object[] Params);
	List<PresenciaTotalTiendaMock> findPresenciasTotalTienda( PresenciasTotalTiendaRequestDTO dto);
	List<PresenciaTotalTiendaSeccionMock> findPresenciasTotalTiendaSeccion(PresenciasTotalTiendaSeccionRequestDTO dto);
	List<TiposHorasMock> findTiposHoras(TiposHorasRequestDTO Params);
}
