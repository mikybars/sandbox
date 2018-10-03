package com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleComisionableMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.TiposHorasMock;

@Repository
public class PTRPresenciasRepositoryImplMock implements PTRPresenciasRepositoryMock{

	@Override
	public PresenciaDetalleMock findPresencias(PresenciaDetalleMock presencia) {
		return presencia;
	}

	@Override
	public PresenciaDetalleComisionableMock findPresenciasComisionable(PresenciaDetalleComisionableMock presencia) {
		return presencia;
	}

	@Override
	public PresenciaTotalTiendaMock findPresenciasTotalTienda(PresenciaTotalTiendaMock presencia) {
		return presencia;

	}

	@Override
	public PresenciaTotalTiendaSeccionMock findPresenciasTotalTiendaSeccion(PresenciaTotalTiendaSeccionMock presencia) {
		return presencia;

	}

	@Override
	public TiposHorasMock findTiposHorass(TiposHorasMock presencia) {
		return presencia;

	}

}
