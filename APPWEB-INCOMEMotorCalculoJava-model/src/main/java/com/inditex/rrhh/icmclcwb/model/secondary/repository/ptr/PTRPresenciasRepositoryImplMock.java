package com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.esotericsoftware.minlog.Log;
import com.inditex.rrhh.icmclcwb.model.mapper.ptr.PresenciaDetalleRowMapper;
import com.inditex.rrhh.icmclcwb.model.mapper.ptr.PresenciaTotalTiendaRowMapper;
import com.inditex.rrhh.icmclcwb.model.mapper.ptr.TiposHorasRowMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleComisionableMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.TiposHorasMock;

@Repository("PTRPresenciasRepositoryJDBCTemplate")
public class PTRPresenciasRepositoryImplMock implements PTRPresenciasRepositoryMock{
	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	//CONSULTA ORIGINAL CON JOIN
	//SELECT top 5 P.[TIPO], P.[TIENDA], P.[FECHA], P.[SECCION], P.[PERSONA], P.[HORAS], P.[CCL_ID_ORIGEN] FROM [dbo].[M4CCL_PRESENCIAS_TA] P INNER JOIN M4CCL_ORGANIZACION_PAIS OP ON  P.ID_ORGANIZATION=OP.ID_ORGANIZATION where ERROR = 'OK'
	
	//private String consultaGHRS ="SELECT top 1 [TIPO],[TIENDA],[FECHA],[SECCION],[PERSONA],[HORAS],OP.[CCL_ID_ORIGEN]FROM [dbo].[M4CCL_PRESENCIAS_TA] P INNER JOIN M4CCL_ORGANIZACION_PAIS OP ON  P.ID_ORGANIZATION=OP.ID_ORGANIZATION where ERROR = 'OK'";
	
	
	private String consultaPresenciaDetalleEspana = "SELECT TOP 100 [TIPO],[TIENDA],[FECHA],[SECCION],[PERSONA],[HORAS]*60 'MINUTOS', 'FALSE' 'MODIFICADO_INCOME' "
													+ "FROM [dbo].[PRESENCIAS_HORARIOS] P INNER JOIN M4CCL_ORGANIZACION_PAIS OP ON  P.ID_ORGANIZATION=OP.ID_ORGANIZATION AND OP.CCL_ID_ORIGEN= ? "
													+ "WHERE TIENDA = ? AND FECHA >= ? AND FECHA <= ? AND ERROR = 'OK'";
											
	private String consultaTiposHorasEspana ="SELECT TOP 100 'TRUE' EXCLUIDODENOM,'TRUE' EXCLUIDOCALCULO, [ID],[TIPO],[TIENDA],[FECHA],[SECCION],[PERSONA],[HORAS],[CCL_ID_ORIGEN]"
											+ " FROM [dbo].[PRESENCIAS_HORARIOS] P INNER JOIN M4CCL_ORGANIZACION_PAIS OP "
											+ "ON  P.ID_ORGANIZATION=OP.ID_ORGANIZATION AND OP.CCL_ID_ORIGEN= ? WHERE TIPO = ? AND ERROR = 'OK'";
		
	
	
	
	private String consultapresenciasTotalTienda1= "SELECT TOP 100 [TIENDA],[FECHA],[HORAS]*60  'MINUTOS' "
			+ "	FROM [dbo].[PRESENCIAS_HORARIOS] P "
			+ "	INNER JOIN M4CCL_ORGANIZACION_PAIS OP ON  P.ID_ORGANIZATION=OP.ID_ORGANIZATION "
			+ "	AND OP.CCL_ID_ORIGEN= ? WHERE ( FECHA >= ? AND FECHA <= ? AND ERROR = 'OK')";
	
	
	@Override
	public List<PresenciaDetalleMock> findPresencias(Object[] Params) {
		List<PresenciaDetalleMock> presencias=(List<PresenciaDetalleMock>) jdbcTemplate.query(consultaPresenciaDetalleEspana,Params,new PresenciaDetalleRowMapper());
		return presencias;
	}

	@Override
	public List<PresenciaDetalleComisionableMock> findPresenciasComisionable(Object[] Params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PresenciaTotalTiendaMock> findPresenciasTotalTienda(Object[] Params) {
		List<Integer> lista =(List<Integer>) Params[3];
		String whereTienda= "";
		for (int i=0;i<lista.size();i++){
			if (i==0){
				whereTienda=" AND (";
				whereTienda= whereTienda + " TIENDA IN ( ?";
			}
			else{
				whereTienda= whereTienda + ", ?";
				if (i==(lista.size()-1)){
					whereTienda= whereTienda + "))";
				}
			}
		}
		String consulta = consultapresenciasTotalTienda1+whereTienda;
		Log.info(consulta);
		
		Object[]  primeraParteParametros = {Params[0],Params[1],Params[2]};
		Object[]  segundaParteParametros = lista.toArray();


		int aLen = primeraParteParametros.length;
        int bLen = segundaParteParametros.length;
        Object[] result = new Object[aLen + bLen];

        System.arraycopy(primeraParteParametros, 0, result, 0, aLen);
        System.arraycopy(segundaParteParametros, 0, result, aLen, bLen);
		List<PresenciaTotalTiendaMock> presencias= (List<PresenciaTotalTiendaMock>) jdbcTemplate.query(consulta,result,new PresenciaTotalTiendaRowMapper());
		return presencias;
	}

	@Override
	public List<PresenciaTotalTiendaSeccionMock> findPresenciasTotalTiendaSeccion(Object[] Params) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<TiposHorasMock> findTiposHoras(Object[] Params) {
		List<TiposHorasMock> presencias=(List<TiposHorasMock>) jdbcTemplate.query(consultaTiposHorasEspana,Params ,new TiposHorasRowMapper());
		return presencias;
	}



}
