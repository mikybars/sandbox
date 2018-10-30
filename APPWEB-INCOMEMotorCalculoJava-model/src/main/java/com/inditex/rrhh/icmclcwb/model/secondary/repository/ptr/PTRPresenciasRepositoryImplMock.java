package com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.esotericsoftware.minlog.Log;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiendaSeccionDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.model.mapper.ptr.PresenciaDetalleRowMapper;
import com.inditex.rrhh.icmclcwb.model.mapper.ptr.PresenciaTotalTiendaRowMapper;
import com.inditex.rrhh.icmclcwb.model.mapper.ptr.PresenciaTotalTiendaSeccionRowMapper;
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
	
	private String consultaPresenciaDetalleEspana = "SELECT PH.ID_ORGANIZATION AS 'ORGANIZACION',OP.CCL_ID_ORIGEN AS 'ID_PAIS',PH.PERSONA AS 'EMPLEADO'"
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
			+ " WHERE OP.CCL_ID_ORIGEN = ? "
			+ "AND  FECHA >= ? AND FECHA < ? "
			+ "AND TIENDA IN ( ? ) "
			+ "AND PH.SECCION IN ( ? ) "
			+ "AND PH.TIPO IN ( ? ) "
			+ "AND SP.CCL_ID_CADENA IN ( ? ) "
			+ "AND ERROR = 'OK'";

	
	
	
	

	private String consultapresenciasTotalTienda = 
			"SELECT PH.ID_ORGANIZATION AS 'ORGANIZACION',"
		        +"OP.CCL_ID_ORIGEN AS 'ID_PAIS',"
		        +"PH.TIENDA AS 'ID_TIENDA',"
		        +"PH.FECHA AS 'FECHA',"
			    +"SUM((CAST(PH.HORAS AS INT) * 60) + PARSENAME(PH.HORAS, 1)) AS 'MINUTOS'"
			+"FROM PRESENCIAS_HORARIOS PH WITH (NOLOCK) "
				+"INNER JOIN M4CCL_ORGANIZACION_PAIS OP WITH (NOLOCK) "
				    +"ON PH.ID_ORGANIZATION = OP.ID_ORGANIZATION "
				+"INNER JOIN STD_WORK_LOCATION SW WITH (NOLOCK) "
					+"ON SW.CCL_ID_COD_ORIGEN = CAST(PH.TIENDA AS NVARCHAR) "
				+" INNER JOIN M4CCL_ATRIB_WLOC SP WITH (NOLOCK) "
					 +"ON SP.STD_ID_WORK_LOCAT=SW.STD_ID_WORK_LOCAT "
					 +"AND SP.CCL_DT_START <= PH.FECHA AND PH.FECHA <= SP.CCL_DT_END "
			+"WHERE "
				+"OP.CCL_ID_ORIGEN = ? "
				+"AND PH.FECHA >= ? "
				+"AND PH.FECHA < ? "
				+"AND PH.TIPO IN (?) "
				+"AND SP.CCL_ID_CADENA IN (? ) "
				+"AND ERROR = 'OK' ";
	private String groupByTotalTienda = " GROUP BY OP.CCL_ID_ORIGEN, PH.ID_ORGANIZATION, PH.TIENDA, PH.FECHA";
													
 
	private String consultapresenciasTotalTiendaSeccion = 
		 "SELECT"
			    +" PH.ID_ORGANIZATION AS 'ORGANIZACION',"
			    +" OP.CCL_ID_ORIGEN AS 'ID_PAIS',"
			    +" PH.TIENDA AS 'ID_TIENDA',"
			    +" PH.SECCION AS 'ID_SECCION',"
			    +" PH.FECHA AS 'FECHA',"
			    +" SUM((CAST(PH.HORAS AS INT) * 60) + PARSENAME(PH.HORAS, 1)) AS 'MINUTOS'"
			+" FROM PRESENCIAS_HORARIOS PH WITH (NOLOCK)"
				+" INNER JOIN M4CCL_ORGANIZACION_PAIS OP WITH (NOLOCK)"
					+" ON PH.ID_ORGANIZATION = OP.ID_ORGANIZATION"
				+" INNER JOIN STD_WORK_LOCATION SW WITH (NOLOCK)"
					+" ON SW.CCL_ID_COD_ORIGEN = CAST(PH.TIENDA AS NVARCHAR)"
				+" INNER JOIN M4CCL_ATRIB_WLOC SP WITH (NOLOCK) "
				 	+" ON SP.STD_ID_WORK_LOCAT=SW.STD_ID_WORK_LOCAT"
				 	+" AND SP.CCL_DT_START <= PH.FECHA AND PH.FECHA <= SP.CCL_DT_END"
			+" WHERE "
				+" OP.CCL_ID_ORIGEN = ? "
				+" AND FECHA >=  ? "
				+" AND FECHA < ? "
				+" AND PH.TIPO IN ( ? )"
				+" AND SP.CCL_ID_CADENA IN ( ? )"
				+" AND ERROR = 'OK' ";

	 private String groupByTotalTiendaSeccion = " GROUP BY OP.CCL_ID_ORIGEN, PH.ID_ORGANIZATION, PH.TIENDA, PH.SECCION,PH.FECHA";
	

		private String consultaTiposHorasEspana ="SELECT TOP 10 'TRUE' EXCLUIDODENOM, 'FALSE' EXCLUIDOCALCULO ,[TIPO] ,[CCL_ID_ORIGEN] FROM [dbo].[PRESENCIAS_HORARIOS] P INNER JOIN M4CCL_ORGANIZACION_PAIS OP ON  P.ID_ORGANIZATION=OP.ID_ORGANIZATION WHERE  ERROR = 'OK'  ";
		private String groupByTiposHoras = " GROUP BY OP.CCL_ID_ORIGEN, TIPO";			
		private String whereTiposHorasOrigen= " AND OP.CCL_ID_ORIGEN= ? ";
		
	@Override
	public List<PresenciaDetalleMock> findPresencias(Object[] Params) {
		List<Integer> lista =(List<Integer>) Params[7];
		String wherePersonas= "";
		//CONSTRUIMOS LA PARTE DEL WHERE DE LA CONSULTA
		for (int i=0;i<lista.size();i++){
			if (i==0){
				wherePersonas=" AND (";
				wherePersonas= wherePersonas + " PH.PERSONA IN ( ?";
			}
			else{
				wherePersonas= wherePersonas + ", ?";
			}
			if (i==(lista.size()-1)){
				wherePersonas= wherePersonas + "))";
			}
		}
		String consulta = consultaPresenciaDetalleEspana+wherePersonas;
		Log.info(consulta);
		
		//CONSTRUIMOS EL ARRAY CON TODOS LOS PARAMETROS
		Object[]  primeraParteParametros = {Params[0],Params[1],Params[2],Params[3],Params[4],Params[5],Params[6]};
		Object[]  segundaParteParametros = lista.toArray();
	
		int aLen = primeraParteParametros.length;
	    int bLen = segundaParteParametros.length;
	    Object[] result = new Object[aLen + bLen];
	
	    System.arraycopy(primeraParteParametros, 0, result, 0, aLen);
	    System.arraycopy(segundaParteParametros, 0, result, aLen, bLen);
	    
	    
	   //EJECUTAMOS LA SENTENCIA
		List<PresenciaDetalleMock> presencias=(List<PresenciaDetalleMock>) jdbcTemplate.query(consulta,result,new PresenciaDetalleRowMapper());
		return presencias;
	}

	@Override
	public List<PresenciaDetalleComisionableMock> findPresenciasComisionable(Object[] Params) {
		return null;
	}

	@Override
	public List<PresenciaTotalTiendaMock> findPresenciasTotalTienda(Object[] Params) {
		List<Integer> lista =(List<Integer>) Params[5];
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
		String consulta = consultapresenciasTotalTienda+whereTienda+groupByTotalTienda;
		Log.info(consulta);
		
		Object[]  primeraParteParametros = {Params[0],Params[1],Params[2],Params[3],Params[4]};
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
		List<TiendaSeccionDTO> lista =(List<TiendaSeccionDTO>) Params[5];

		String whereTiendaSeccion= "";
		List<Integer> tiendaSeccion= new ArrayList<Integer>();
		
		for (int i=0;i<lista.size();i++){
			if (i==0){
				Log.info("TIENDA: "+ lista.get(i).getTienda()+"    SECCION: "+lista.get(i).getSeccion());
				whereTiendaSeccion=" AND  ((PH.TIENDA = ? AND PH.SECCION = ?) ";
				tiendaSeccion.add(lista.get(i).getTienda());
				tiendaSeccion.add(lista.get(i).getSeccion());
			}
			else{
				Log.info("TIENDA: "+ lista.get(i).getTienda()+"    SECCION: "+lista.get(i).getSeccion());
				if (lista.get(i).getSeccion()==null){
					whereTiendaSeccion= whereTiendaSeccion + " OR (PH.TIENDA = ?)";
					tiendaSeccion.add(lista.get(i).getTienda());
				}
				else{
				whereTiendaSeccion= whereTiendaSeccion + " OR (PH.TIENDA = ? AND PH.SECCION = ?)";
				tiendaSeccion.add(lista.get(i).getTienda());
				tiendaSeccion.add(lista.get(i).getSeccion());
				}
				if (i==(lista.size()-1)){
					whereTiendaSeccion= whereTiendaSeccion + ")";
				}
			}
		}
		String consulta = consultapresenciasTotalTiendaSeccion+whereTiendaSeccion+groupByTotalTiendaSeccion;
		Log.info(consulta);
		
		Object[]  primeraParteParametros = {Params[0],Params[1],Params[2],Params[3],Params[4]};
		Object[]  segundaParteParametros = tiendaSeccion.toArray();

		
		int aLen = primeraParteParametros.length;
        int bLen = segundaParteParametros.length;

        Object[] result = new Object[aLen + bLen];


        System.arraycopy(primeraParteParametros, 0, result, 0, aLen);
        System.arraycopy(segundaParteParametros, 0, result, aLen, bLen);

        
        for(int e=0;e<(aLen + bLen);e++){
        	Log.info("ARGUMENT "+e+":   "+result[e]+"   ");
        }
		List<PresenciaTotalTiendaSeccionMock> presencias= (List<PresenciaTotalTiendaSeccionMock>) jdbcTemplate.query(consulta,result,new PresenciaTotalTiendaSeccionRowMapper());
		return presencias;
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



}
