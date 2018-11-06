package com.inditex.rrhh.icmclcwb.model.secondary.repository;

import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.esotericsoftware.minlog.Log;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiendaSeccionDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleComisionableMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.TiposHorasMock;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PresenciaDetalleRowMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PresenciaTotalTiendaRowMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PresenciaTotalTiendaSeccionRowMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.TiposHorasRowMapper;

@Repository("PTRPresenciasRepositoryJDBCTemplate")
public class PTRPresenciasRepositoryImplMock implements PTRPresenciasRepositoryMock{
	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	private String consultaTiposHorasEspana ="SELECT 'TRUE' EXCLUIDODENOM, 'FALSE' EXCLUIDOCALCULO ,[TIPO] ,[CCL_ID_ORIGEN] FROM [dbo].[PRESENCIAS_HORARIOS] P INNER JOIN M4CCL_ORGANIZACION_PAIS OP ON  P.ID_ORGANIZATION=OP.ID_ORGANIZATION WHERE  ERROR = 'OK'  ";
	private String groupByTiposHoras = " GROUP BY OP.CCL_ID_ORIGEN, TIPO";			
	private String whereTiposHorasOrigen= " AND OP.CCL_ID_ORIGEN= ? ";
	

	@Override
	public List<PresenciaDetalleMock> findPresencias(PresenciasDetalleRequestDTO params) {
	
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		StringBuilder query= new StringBuilder();
		
		
		
		
		param.addValue("cadena", params.getCadena());
		query.append( "SELECT PH.PERSONA AS 'EMPLEADO'"
				+ ",PH.TIENDA AS 'ID_TIENDA',PH.SECCION AS 'ID_SECCION',PH.TIPO AS 'ID_TIPO',PH.FECHA AS 'FECHA', SP.CCL_ID_CADENA AS 'CADENA',"
				+ " (CAST(PH.HORAS AS INT) * 60) + PARSENAME(PH.HORAS, 1) AS 'MINUTOS','FALSE' 'MODIFICADO_INCOME' "
				+ " FROM PRESENCIAS_HORARIOS PH WITH (NOLOCK) "
				+ "INNER JOIN M4CCL_ORGANIZACION_PAIS OP WITH (NOLOCK)"
					+ "ON PH.ID_ORGANIZATION = OP.ID_ORGANIZATION "
				+ "INNER JOIN STD_WORK_LOCATION SW WITH (NOLOCK) "
					+" ON SW.CCL_ID_COD_ORIGEN = CAST(PH.TIENDA AS NVARCHAR) "
				+ " INNER JOIN M4CCL_ATRIB_WLOC SP WITH (NOLOCK) "
					+ " ON SP.STD_ID_WORK_LOCAT=SW.STD_ID_WORK_LOCAT AND"
					+ " SP.CCL_DT_START <= FECHA AND FECHA <= SP.CCL_DT_END"
				+ " WHERE SP.CCL_ID_CADENA IN ( :cadena ) AND ERROR = 'OK' ");
				
		if (params.getOrigen()!=null){
			query.append(" AND OP.CCL_ID_ORIGEN = :origen ");
			param.addValue("origen", params.getOrigen());
		}
		if(params.getFechaDesde()!=null){
			String fecha1= formatter.format(params.getFechaDesde());
			query.append(" AND FECHA >=  :fechadesde ");
			param.addValue("fechadesde", fecha1);
		}
		if(params.getFechaHasta()!=null){
			String fecha2= formatter.format(params.getFechaHasta());
			query.append(" AND FECHA < :fechahasta ");
			param.addValue("fechahasta", fecha2);
		}
		if (params.getSeccion()!=null){
			query.append(" AND PH.SECCION IN ( :seccion ) ");
			param.addValue("seccion",params.getSeccion());
		}
		if (params.getTipo()!=null){
			query.append(" AND PH.TIPO IN ( :tipo )");
			param.addValue("tipo", params.getTipo());
		}
		if (params.getPersonas()!=null){
			int size= params.getPersonas().size();
			if (size>0){
				query.append(" AND (PH.PERSONA IN ( :persona0");
				param.addValue("persona0", params.getPersonas().get(0));
				for (Integer i=1;i<size;i++){
						query.append(" , :persona"+i.toString()+" ");
						param.addValue("persona"+i.toString(), params.getPersonas().get(i));
				}
				query.append(" ))");
			}
		}
		return namedParameterJdbcTemplate.query(query.toString(), param, new PresenciaDetalleRowMapper());
	}
	
	
	@Override
	public List<PresenciaDetalleComisionableMock> findPresenciasComisionable(Object[] Params) {
		return null;
	}
	
	@Override
	public List<PresenciaTotalTiendaMock> findPresenciasTotalTienda(PresenciasTotalTiendaRequestDTO dto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		StringBuilder query= new StringBuilder();		
		
		param.addValue("cadena", dto.getCadena());
		query.append("SELECT PH.TIENDA AS 'ID_TIENDA',PH.FECHA AS 'FECHA',SUM((CAST(PH.HORAS AS INT) * 60) + PARSENAME(PH.HORAS, 1)) AS 'MINUTOS'FROM PRESENCIAS_HORARIOS PH WITH (NOLOCK) INNER JOIN M4CCL_ORGANIZACION_PAIS OP WITH (NOLOCK) ON PH.ID_ORGANIZATION = OP.ID_ORGANIZATION INNER JOIN STD_WORK_LOCATION SW WITH (NOLOCK) ON SW.CCL_ID_COD_ORIGEN = CAST(PH.TIENDA AS NVARCHAR) INNER JOIN M4CCL_ATRIB_WLOC SP WITH (NOLOCK) ON SP.STD_ID_WORK_LOCAT=SW.STD_ID_WORK_LOCAT AND SP.CCL_DT_START <= PH.FECHA AND PH.FECHA <= SP.CCL_DT_END WHERE ERROR = 'OK' AND SP.CCL_ID_CADENA IN ( :cadena ) ");
		if (dto.getOrigen()!=null){
			query.append(" AND OP.CCL_ID_ORIGEN = :origen ");
			param.addValue("origen", dto.getOrigen());
		}
		if(dto.getFechaDesde()!=null){
			String fecha1= formatter.format(dto.getFechaDesde());
			query.append("AND PH.FECHA >= :fechadesde ");
			param.addValue("fechadesde", fecha1);
		}
		if(dto.getFechaHasta()!=null){
			String fecha2= formatter.format(dto.getFechaHasta());
			query.append("AND PH.FECHA < :fechahasta ");
			param.addValue("fechahasta", fecha2);
		}
		if(dto.getTipo()!=null){
			query.append("AND PH.TIPO IN ( :tipo)");
			param.addValue("tipo", dto.getTipo());
		}
		
		if (dto.getTiendas()!=null){
			int size= dto.getTiendas().size();
			if (size>0){
				query.append(" AND (TIENDA IN ( :tienda0");
				param.addValue("tienda0", dto.getTiendas().get(0));
				
				for (Integer i=1;i<size;i++){
						query.append(" ,:tienda"+i.toString()+" ");
						param.addValue("tienda"+i.toString(),dto.getTiendas().get(i));
				 }
				query.append("))");
			}
		}
	
		query.append( " GROUP BY OP.CCL_ID_ORIGEN, PH.ID_ORGANIZATION, PH.TIENDA, PH.FECHA");
		return namedParameterJdbcTemplate.query(query.toString(), param, new PresenciaTotalTiendaRowMapper());
	}



	@Override
	public List<PresenciaTotalTiendaSeccionMock> findPresenciasTotalTiendaSeccion(PresenciasTotalTiendaSeccionRequestDTO dto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		StringBuilder query= new StringBuilder();		
		
		param.addValue("cadena", dto.getCadena());
		query.append("SELECT PH.TIENDA AS 'ID_TIENDA', PH.SECCION AS 'ID_SECCION',PH.FECHA AS 'FECHA', SUM((CAST(PH.HORAS AS INT) * 60) + PARSENAME(PH.HORAS, 1)) AS 'MINUTOS' FROM PRESENCIAS_HORARIOS PH WITH (NOLOCK) INNER JOIN M4CCL_ORGANIZACION_PAIS OP WITH (NOLOCK) ON PH.ID_ORGANIZATION = OP.ID_ORGANIZATION INNER JOIN STD_WORK_LOCATION SW WITH (NOLOCK) ON SW.CCL_ID_COD_ORIGEN = CAST(PH.TIENDA AS NVARCHAR) INNER JOIN M4CCL_ATRIB_WLOC SP WITH (NOLOCK) ON SP.STD_ID_WORK_LOCAT=SW.STD_ID_WORK_LOCAT AND SP.CCL_DT_START <= PH.FECHA AND PH.FECHA <= SP.CCL_DT_END WHERE ERROR = 'OK' AND SP.CCL_ID_CADENA IN ( :cadena )");
		if (dto.getOrigen()!=null){
			query.append(" AND OP.CCL_ID_ORIGEN = :origen ");
			param.addValue("origen", dto.getOrigen());
		}
		if(dto.getFechaDesde()!=null){
			String fecha1= formatter.format(dto.getFechaDesde());
			query.append("AND PH.FECHA >= :fechadesde ");
			param.addValue("fechadesde", fecha1);
		}
		if(dto.getFechaHasta()!=null){
			String fecha2= formatter.format(dto.getFechaHasta());
			query.append("AND PH.FECHA < :fechahasta ");
			param.addValue("fechahasta", fecha2);
		}
		if(dto.getTipo()!=null){
			query.append("AND PH.TIPO = :tipo");
			param.addValue("tipo", dto.getTipo());
		}
		if (dto.getTiendaSeccion()!=null){
			int size = dto.getTiendaSeccion().size();
			if (size > 0){
				if (dto.getTiendaSeccion().get(0).getSeccion()==null){
					query.append(" AND  ((PH.TIENDA = :tienda0 )" );
					param.addValue("tienda0", dto.getTiendaSeccion().get(0).getTienda());
				}else{
					query.append(" AND  ((PH.TIENDA = :tienda0 AND PH.SECCION = :seccion0 )" );
					param.addValue("tienda0", dto.getTiendaSeccion().get(0).getTienda());	
					param.addValue("seccion0", dto.getTiendaSeccion().get(0).getSeccion());
				}
			
				for (Integer i=1;i<size;i++){
	
					if (dto.getTiendaSeccion().get(i).getSeccion()==null){
					query.append(" OR  (PH.TIENDA = :tienda"+i.toString()+" )" );
					param.addValue("tienda"+i.toString(), dto.getTiendaSeccion().get(i).getTienda());
					}else{
						query.append(" OR  (PH.TIENDA = :tienda"+i.toString()+" AND PH.SECCION = :seccion"+i.toString()+" )" );
						param.addValue("tienda"+i.toString(), dto.getTiendaSeccion().get(i).getTienda());	
						param.addValue("seccion"+i.toString(), dto.getTiendaSeccion().get(i).getSeccion());
					}
					
				}
					query.append(")");
			}
		
		}
		query.append( " GROUP BY OP.CCL_ID_ORIGEN, PH.ID_ORGANIZATION, PH.TIENDA,PH.SECCION,  PH.FECHA");
		return namedParameterJdbcTemplate.query(query.toString(), param, new PresenciaTotalTiendaSeccionRowMapper());
	}
	
	
	@Override
	public List<TiposHorasMock> findTiposHoras(TiposHorasRequestDTO dto) {
		List<TiposHorasMock> presencias;
		String consulta;
		
		if (dto.getOrigen()==null){
			consulta =consultaTiposHorasEspana+groupByTiposHoras;
			presencias=(List<TiposHorasMock>) jdbcTemplate.query(consulta,new TiposHorasRowMapper());
			return presencias;
		}
		else{
			consulta=consultaTiposHorasEspana+whereTiposHorasOrigen+groupByTiposHoras;
			Object[] Params = {dto.getOrigen()};
			presencias=(List<TiposHorasMock>) jdbcTemplate.query(consulta,Params ,new TiposHorasRowMapper());
			return presencias;
		}
	}
	
	
	
	
	//SELECT PH.ID_ORGANIZATION AS 'ORGANIZACION',OP.CCL_ID_ORIGEN AS 'ID_PAIS',PH.PERSONA AS 'EMPLEADO',PH.TIENDA AS 'ID_TIENDA',PH.SECCION AS 'ID_SECCION',PH.TIPO AS 'ID_TIPO',PH.FECHA AS 'FECHA', SP.CCL_ID_CADENA AS 'CADENA',(CAST(PH.HORAS AS INT) * 60) + PARSENAME(PH.HORAS, 1) AS 'MINUTOS','FALSE' 'MODIFICADO_INCOME' FROM PRESENCIAS_HORARIOS PH WITH (NOLOCK) INNER JOIN M4CCL_ORGANIZACION_PAIS OP WITH (NOLOCK)ON PH.ID_ORGANIZATION = OP.ID_ORGANIZATION INNER JOIN STD_WORK_LOCATION SW WITH (NOLOCK) ON SW.CCL_ID_COD_ORIGEN = CAST(PH.TIENDA AS NVARCHAR) INNER JOIN M4CCL_ATRIB_WLOC SP WITH (NOLOCK) ON SP.STD_ID_WORK_LOCAT=SW.STD_ID_WORK_LOCAT ANDSP.CCL_DT_START <= FECHA AND FECHA <= SP.CCL_DT_ENDWHERE OP.CCL_ID_ORIGEN = ? AND  FECHA >= ? AND FECHA < ? AND TIENDA IN ( ? ) AND PH.SECCION IN ( ? ) AND PH.TIPO IN ( ? ) AND SP.CCL_ID_CADENA IN ( ? ) AND ERROR = 'OK'
	//SELECT PH.ID_ORGANIZATION AS 'ORGANIZACION',OP.CCL_ID_ORIGEN AS 'ID_PAIS',PH.TIENDA AS 'ID_TIENDA',PH.FECHA AS 'FECHA',SUM((CAST(PH.HORAS AS INT) * 60) + PARSENAME(PH.HORAS, 1)) AS 'MINUTOS'FROM PRESENCIAS_HORARIOS PH WITH (NOLOCK) INNER JOIN M4CCL_ORGANIZACION_PAIS OP WITH (NOLOCK) ON PH.ID_ORGANIZATION = OP.ID_ORGANIZATION INNER JOIN STD_WORK_LOCATION SW WITH (NOLOCK) ON SW.CCL_ID_COD_ORIGEN = CAST(PH.TIENDA AS NVARCHAR) INNER JOIN M4CCL_ATRIB_WLOC SP WITH (NOLOCK) ON SP.STD_ID_WORK_LOCAT=SW.STD_ID_WORK_LOCAT AND SP.CCL_DT_START <= PH.FECHA AND PH.FECHA <= SP.CCL_DT_END WHERE OP.CCL_ID_ORIGEN = ? AND PH.FECHA >= ? AND PH.FECHA < ? AND PH.TIPO IN (?) AND SP.CCL_ID_CADENA IN (? ) AND ERROR = 'OK' AND TIENDA IN ( ? , ?)  GROUP BY OP.CCL_ID_ORIGEN, PH.ID_ORGANIZATION, PH.TIENDA, PH.FECHA
	//SELECT PH.ID_ORGANIZATION AS 'ORGANIZACION',OP.CCL_ID_ORIGEN AS 'ID_PAIS',PH.TIENDA AS 'ID_TIENDA', PH.SECCION AS 'ID_SECCION',PH.FECHA AS 'FECHA',SUM((CAST(PH.HORAS AS INT) * 60) + PARSENAME(PH.HORAS, 1)) AS 'MINUTOS' FROM PRESENCIAS_HORARIOS PH WITH (NOLOCK) INNER JOIN M4CCL_ORGANIZACION_PAIS OP WITH (NOLOCK) ON PH.ID_ORGANIZATION = OP.ID_ORGANIZATION INNER JOIN STD_WORK_LOCATION SW WITH (NOLOCK) ON SW.CCL_ID_COD_ORIGEN = CAST(PH.TIENDA AS NVARCHAR) INNER JOIN M4CCL_ATRIB_WLOC SP WITH (NOLOCK) ON SP.STD_ID_WORK_LOCAT=SW.STD_ID_WORK_LOCAT AND SP.CCL_DT_START <= PH.FECHA AND PH.FECHA <= SP.CCL_DT_END WHERE ERROR = 'OK' AND SP.CCL_ID_CADENA IN ( :cadena ) AND OP.CCL_ID_ORIGEN = ? AND TIPO = ?  AND FECHA >=  ?  AND FECHA < ?  AND ((TIENDA = :tienda0 AND SECCION = :seccion0) OR (TIENDA = :tienda1 AND SECCION = :seccion1)) GROUP BY OP.CCL_ID_ORIGEN, PH.ID_ORGANIZATION, PH.TIENDA, PH.SECCION,PH.FECHA	
	//SELECT TOP 10 'TRUE' EXCLUIDODENOM, 'FALSE' EXCLUIDOCALCULO ,[TIPO] ,[CCL_ID_ORIGEN] FROM [dbo].[PRESENCIAS_HORARIOS] P INNER JOIN M4CCL_ORGANIZACION_PAIS OP ON  P.ID_ORGANIZATION=OP.ID_ORGANIZATION WHERE  ERROR = 'OK' GROUP BY OP.CCL_ID_ORIGEN, TIPO AND OP.CCL_ID_ORIGEN= ?
		
}
