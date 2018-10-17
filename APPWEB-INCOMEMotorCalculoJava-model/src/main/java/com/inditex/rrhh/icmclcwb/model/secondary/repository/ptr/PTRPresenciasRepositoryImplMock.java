package com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.mapper.ptr.PresenciaGHRSRowMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleComisionableMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaGHRS;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.TiposHorasMock;

@Repository
public class PTRPresenciasRepositoryImplMock implements PTRPresenciasRepositoryMock{

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	//CONSULTA ORIGINAL CON JOIN
	//SELECT top 5 P.[TIPO], P.[TIENDA], P.[FECHA], P.[SECCION], P.[PERSONA], P.[HORAS], P.[CCL_ID_ORIGEN] FROM [dbo].[M4CCL_PRESENCIAS_TA] P INNER JOIN M4CCL_ORGANIZACION_PAIS OP ON  P.ID_ORGANIZATION=OP.ID_ORGANIZATION where ERROR = 'OK'
	
	private String consultaGHRS ="SELECT top 1 [TIPO],[TIENDA],[FECHA],[SECCION],[PERSONA],[HORAS],OP.[CCL_ID_ORIGEN]FROM [dbo].[M4CCL_PRESENCIAS_TA] P INNER JOIN M4CCL_ORGANIZACION_PAIS OP ON  P.ID_ORGANIZATION=OP.ID_ORGANIZATION where ERROR = 'OK'";
	
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
		List<PresenciaGHRS> presencias=(List<PresenciaGHRS>) jdbcTemplate.query(consultaGHRS,new PresenciaGHRSRowMapper());
		TiposHorasMock tiposHoras= new TiposHorasMock();
		tiposHoras.setTipoHora(presencias.get(0).getTipo());
		tiposHoras.setOrigen(presencias.get(0).getCcl_id_origen());
		return tiposHoras;

	}

}
