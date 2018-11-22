package com.inditex.rrhh.icmclcwb.model.primary.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

@Repository
public class GTCalculoRepositoryImpl  implements GTCalculoRepository{
	
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	@AuditoriaTrabajo		
	public void calcular(TrabajoDto trabajo) 		
	{			
				
		NamedParameterJdbcTemplate namedJdbc = new NamedParameterJdbcTemplate(jdbcTemplate);
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idTrabajo", trabajo.getId());									
		StringBuilder query = new StringBuilder();
			
		query.append("INSERT INTO DESARROLLO_RRHH.INCOME_TRABAJO_CALCULO (").
		append(" COMISION_PORCENTAJE_1 ").
		append(",COMISION_PORCENTAJE_2 ").
		append(",COMISION_PORCENTAJE_3 ").
		append(",EMPLEADO_PRESENCIA_MINUTOS_1 ").
		append(",EMPLEADO_PRESENCIA_MINUTOS_2 ").
		append(",EMPLEADO_PRESENCIA_MINUTOS_3 ").
		append(",ID_EMPLEADO ").
		append(",ID_ESTRUCTURA "). 
		append(",ID_TIENDA ").
		append(",IMPORTE_1 ").
		append(",IMPORTE_2 ").
		append(",IMPORTE_3 ").
		append(",TIENDA_PRESENCIA_MINUTOS_1 ").
		append(",TIENDA_PRESENCIA_MINUTOS_2 ").
		append(",TIENDA_PRESENCIA_MINUTOS_3 ").
		append(",TIENDA_VENTA_IMPORTE_1 ").
		append(",TIENDA_VENTA_IMPORTE_2 ").
		append(",TIENDA_VENTA_IMPORTE_3 ").
		append(",ID_TIPO_CALCULO ").
		append(",ID_TIPO_COMISION ").
		append(",ID_TIPO_HORA ").
		append(",ID_TRABAJO) ").
		
		append("SELECT ").
		append("  ESTRUCTURA.PORCENTAJE_1 AS COMISION_PORCENTAJE_1 "). 
		append(" ,ESTRUCTURA.PORCENTAJE_2 AS COMISION_PORCENTAJE_2 "). 
		append(" ,ESTRUCTURA.PORCENTAJE_3 AS COMISION_PORCENTAJE_3 ").
		
		append(" ,EMPLEADO.MINUTOS_1 AS EMPLEADO_PRESENCIA_MINUTOS_1 ").
		append(" ,EMPLEADO.MINUTOS_2 AS EMPLEADO_PRESENCIA_MINUTOS_2 ").
		append(" ,EMPLEADO.MINUTOS_3 AS EMPLEADO_PRESENCIA_MINUTOS_3 ").
		
		append(" ,TIENDA.MINUTOS_1 AS TIENDA_PRESENCIA_MINUTOS_1 ").
		append(" ,TIENDA.MINUTOS_2 AS TIENDA_PRESENCIA_MINUTOS_2 ").
		append(" ,TIENDA.MINUTOS_3 AS TIENDA_PRESENCIA_MINUTOS_3 ").
		
		append(" ,TIENDA_VENTA.IMPORTE_1 AS TIENDA_VENTA_IMPORTE_1 ").
		append(" ,TIENDA_VENTA.IMPORTE_2 AS TIENDA_VENTA_IMPORTE_2 ").
		append(" ,TIENDA_VENTA.IMPORTE_3 AS TIENDA_VENTA_IMPORTE_3 ").  
		
		append(" ,(TIENDA_VENTA.IMPORTE_1) * CAST (ESTRUCTURA.PORCENTAJE_2 AS FLOAT) * ( CAST (EMPLEADO.MINUTOS_1 AS FLOAT) / TIENDA.MINUTOS_1) AS IMPORTE_1 ").   
		append(" ,(TIENDA_VENTA.IMPORTE_2) * CAST (ESTRUCTURA.PORCENTAJE_2 AS FLOAT) * ( CAST (EMPLEADO.MINUTOS_2 AS FLOAT) / TIENDA.MINUTOS_2) AS IMPORTE_2  ").  
		append(" ,(TIENDA_VENTA.IMPORTE_3) * CAST (ESTRUCTURA.PORCENTAJE_3 AS FLOAT) * ( CAST (EMPLEADO.MINUTOS_3 AS FLOAT) / TIENDA.MINUTOS_3) AS IMPORTE_3  ").
		
		append(" ,EMPLEADO.ID_EMPLEADO AS ID_EMPLEADO "). 
		append(" ,TIENDA.ID_TIENDA AS ID_TIENDA ").
		append(" ,ESTRUCTURA.ID_ESTRUCTURA AS ID_ESTRUCTURA ").
		append(" ,ESTRUCTURA.ID_TIPO_CALCULO AS ID_TIPO_CALCULO ").
		append(" ,ESTRUCTURA.ID_TIPO_COMISION AS ID_TIPO_COMISION ").
		append(" ,EMPLEADO.ID_TIPO_HORA AS ID_TIPO_HORA "). 
		append(" ,ESTRUCTURA.ID_TRABAJO AS ID_TRABAJO ").
		
		append("	FROM DESARROLLO_RRHH.INCOME_TRABAJO_EMPLEADO_ESTRUCTURA AS ESTRUCTURA ").
		append("		INNER JOIN DESARROLLO_RRHH.INCOME_TRABAJO_TIENDA_EMPLEADO_PRESENCIA_SECCION AS EMPLEADO ").
		append(" 	ON EMPLEADO.ID_EMPLEADO = ESTRUCTURA.ID_EMPLEADO AND EMPLEADO.FECHA = ESTRUCTURA.FECHA "). 
		append("		INNER JOIN DESARROLLO_RRHH.INCOME_TRABAJO_TIENDA_PRESENCIA_SECCION AS TIENDA ").
		append("  ON TIENDA.ID_TIENDA = EMPLEADO.ID_TIENDA AND TIENDA.FECHA = EMPLEADO.FECHA ").
		append("		INNER JOIN DESARROLLO_RRHH.INCOME_TRABAJO_TIENDA_VENTA_SECCION AS TIENDA_VENTA ").
		append("  ON TIENDA_VENTA.ID_TIENDA = TIENDA.ID_TIENDA AND TIENDA_VENTA.FECHA = TIENDA.FECHA ").
		
		append("		WHERE ESTRUCTURA.ID_TRABAJO = :idTrabajo ").
		append("		AND EMPLEADO.ID_TRABAJO = :idTrabajo ").
		append("		AND TIENDA.ID_TRABAJO = :idTrabajo ").
		append("		AND TIENDA_VENTA.ID_TRABAJO = :idTrabajo ");
					
		namedJdbc.update(query.toString(), param);
				
	}
	
		
	
}

