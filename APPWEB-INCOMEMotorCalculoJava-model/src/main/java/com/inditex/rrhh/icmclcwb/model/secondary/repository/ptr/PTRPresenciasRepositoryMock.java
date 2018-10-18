package com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleComisionableMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaGHRS;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.TiposHorasMock;



public interface PTRPresenciasRepositoryMock{

	List<PresenciaDetalleMock>findPresencias(Object[] Params);
	PresenciaDetalleComisionableMock findPresenciasComisionable( PresenciaDetalleComisionableMock presencia);
	PresenciaTotalTiendaMock findPresenciasTotalTienda( PresenciaTotalTiendaMock presencia);
	PresenciaTotalTiendaSeccionMock findPresenciasTotalTiendaSeccion( PresenciaTotalTiendaSeccionMock presencia);
	TiposHorasMock findTiposHoras( TiposHorasMock presencia);
}
