package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

@Repository
public class TrabajoTiendaVentaSeccionRepositoryImpl implements TrabajoTiendaVentaSeccionRepository {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Logger LOG;
	
	private static final String SAVE = "MERGE INTO DESARROLLO_RRHH.INCOME_TRABAJO_TIENDA_VENTA_SECCION "
			+ " USING ("
			+ " SELECT FECHA, ID_TIENDA, COALESCE(MAX(Q1),0) AS IMPORTE_1, COALESCE(MAX(Q2),0) AS IMPORTE_2, COALESCE(MAX(Q3),0) AS IMPORTE_3, ID_TRABAJO"
			+ " FROM( "
			+ " SELECT A.ID_TRABAJO, A.FECHA, A.ID_TIENDA, A.ID_SECCION,"
			+ " MAX(CASE WHEN A.ID_SECCION = 1 THEN A.IMPORTE END) AS Q1,"
			+ " MAX(CASE WHEN A.ID_SECCION = 2 THEN A.IMPORTE END) AS Q2,"
			+ " MAX(CASE WHEN A.ID_SECCION = 3 THEN A.IMPORTE END) AS Q3 "
			+ " FROM DESARROLLO_RRHH.INCOME_TRABAJO_TIENDA_SECCION_VENTA A "
			+ " WHERE A.ID_TRABAJO = ? "
			+ " GROUP BY A.ID_TRABAJO, A.FECHA, A.ID_TIENDA, A.ID_SECCION) "
			+ " GROUP BY ID_TRABAJO, FECHA, ID_TIENDA"
			+ " ) AS S "
			+ " ON 1 = 0 "
			+ " WHEN NOT MATCHED THEN"
			+ " INSERT (FECHA, ID_TIENDA, IMPORTE_1, IMPORTE_2, IMPORTE_3, ID_TRABAJO ) "
			+ " VALUES (S.FECHA, S.ID_TIENDA, S.IMPORTE_1, S.IMPORTE_2, S.IMPORTE_3, S.ID_TRABAJO)";
	
	@Override
	public void save(@NotNull Long trabajoId){
    	LOG.debug("Inicio :: TrabajoTiendaVentaSeccionRepository.save() :: {}", trabajoId);

        int row = jdbcTemplate.update(new PreparedStatementCreator(){
            public PreparedStatement createPreparedStatement(Connection connection)
                throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SAVE);
                ps.setLong(1, trabajoId);
                return ps;
            }
        });

        if(row > 0){
        	LOG.debug("Fin :: TrabajoTiendaVentaSeccionRepository.save() :: Number of rows inserted: {} :: Trabajo id: {} ", row, trabajoId);
        }
	}
}
