package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

@Repository
public class TrabajoTiendaEmpleadoPresenciaSeccionRepositoryImpl
		implements TrabajoTiendaEmpleadoPresenciaSeccionRepository {
	
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	private static final String SAVE = "MERGE INTO DESARROLLO_RRHH.INCOME_TRABAJO_TIENDA_EMPLEADO_PRESENCIA_SECCION "
			+ " USING ("
			+ " SELECT FECHA, "
			+ " ID_TIENDA, "
			+ " COALESCE(MAX(Q1),0) AS MINUTOS_1, "
			+ " COALESCE(MAX(Q2),0) AS MINUTOS_2, "
			+ " COALESCE(MAX(Q3),0) AS MINUTOS_3, "
			+ " ID_TRABAJO, "
			+ " ID_EMPLEADO "
			+ " FROM( "
			+ " SELECT A.ID_TRABAJO, A.FECHA, A.ID_TIENDA, A.ID_SECCION, A.ID_EMPLEADO,"
			+ " MAX(CASE WHEN A.ID_SECCION = 1 THEN A.MINUTOS END) AS Q1,"
			+ " MAX(CASE WHEN A.ID_SECCION = 2 THEN A.MINUTOS END) AS Q2,"
			+ " MAX(CASE WHEN A.ID_SECCION = 3 THEN A.MINUTOS END) AS Q3 "
			+ " FROM DESARROLLO_RRHH.INCOME_TRABAJO_TIENDA_SECCION_EMPLEADO_PRESENCIA A "
			+ " WHERE A.ID_TRABAJO = ? "
			+ " GROUP BY A.ID_TRABAJO, A.FECHA, A.ID_TIENDA, A.ID_SECCION, A.ID_EMPLEADO) "
			+ " GROUP BY ID_TRABAJO, FECHA, ID_TIENDA, ID_EMPLEADO) AS S "
			+ " ON (1 = 0) "
			+ " WHEN NOT MATCHED THEN "
			+ " INSERT (FECHA, ID_TIENDA, MINUTOS_1, MINUTOS_2, MINUTOS_3, ID_TRABAJO, ID_EMPLEADO ) "
			+ " VALUES (S.FECHA, S.ID_TIENDA, S.MINUTOS_1, S.MINUTOS_2, S.MINUTOS_3, S.ID_TRABAJO, S.ID_EMPLEADO)";
	
	@Override
	@Auditoria
	public void save(@NotNull TrabajoDto trabajoDto){
        jdbcTemplate.update(new PreparedStatementCreator(){
            public PreparedStatement createPreparedStatement(Connection connection)
                throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SAVE);
                ps.setLong(1, trabajoDto.getId());
                return ps;
            }
        });
	}

}
