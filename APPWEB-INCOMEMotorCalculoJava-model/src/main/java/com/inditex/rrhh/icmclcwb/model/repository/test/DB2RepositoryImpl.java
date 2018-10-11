package com.inditex.rrhh.icmclcwb.model.repository.test;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.test.VentaDto;

@Repository
public class DB2RepositoryImpl implements DB2Repository {

	@Autowired
	private Logger logger;
	
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public void crearTemporalTest1() {
		final java.util.Date time1 = new java.util.Date();

		// Creacion tabla temporal
		logger.info("Se crea temporal TEST1");
		borrarTemporal("TEST1");
		jdbcTemplate.execute("DECLARE GLOBAL TEMPORARY TABLE TEST1 (ID BIGINT, LOG XML) ON COMMIT PRESERVE ROWS NOT LOGGED");
		logger.info("Se crea temporal TEST1: OK : " + getLogTiempo(time1));
	}
	
	@Override
	public void crearTemporalTest2() {
		java.util.Date time1 = new java.util.Date();
		
		// Creacion tabla temporal
		logger.info("Se crea temporal TEST2");
		borrarTemporal("TEST2");
		jdbcTemplate.execute("DECLARE GLOBAL TEMPORARY TABLE TEST2 (id bigint, fecha timestamp, IDPAIS bigint, IDCADENA bigint, IDTIENDA bigint, importeSinIVA float, importeConIVA float) ON COMMIT PRESERVE ROWS NOT LOGGED");
		logger.info("Se crea temporal TEST2: OK : " + getLogTiempo(time1));
		
		time1 = new java.util.Date();
		logger.info("Se crea indice TEST2");
		jdbcTemplate.execute("CREATE INDEX session.INDICE_TEST2 ON session.TEST2 (FECHA, IDPAIS, IDCADENA, IDTIENDA)");
		logger.info("Se crea indice TEST2: OK : " + getLogTiempo(time1));
		
	}

	@Override
	public void crearTemporalTest3() {
		java.util.Date time1 = new java.util.Date();
		
		// Creacion tabla temporal
		logger.info("Se crea temporal TEST3");
		borrarTemporal("TEST3");
		jdbcTemplate.execute("DECLARE GLOBAL TEMPORARY TABLE TEST3 (id bigint, fecha timestamp, idPais bigint, idCadena bigint, idTienda bigint, importeSinIVA float, importeConIVA float) ON COMMIT PRESERVE ROWS NOT LOGGED");
		logger.info("Se crea temporal TEST3: OK : " + getLogTiempo(time1));
		
		time1 = new java.util.Date();
		logger.info("Se crea indice TEST3");
		jdbcTemplate.execute("CREATE INDEX session.INDICE_TEST3 ON session.TEST3 (FECHA, IDPAIS, IDCADENA, IDTIENDA)");
		logger.info("Se crea indice TEST3: OK : " + getLogTiempo(time1));
	}

	@Override
	public void insertarDatosXMLCompleto(String contenidoFichero) {
		java.util.Date time1 = new java.util.Date();
		logger.info("Se insertan datos TEST1");
		final String sql = new StringBuffer().append("INSERT INTO session.TEST1 (log) VALUES ('")
				.append(contenidoFichero).append("')").toString();
		jdbcTemplate.update(sql);
		logger.info("Se insertan datos TEST1: OK : " + getLogTiempo(time1));

	}

	@Override
	public List<VentaDto> getDatosXMLCompleto() {
		java.util.Date time1 = new java.util.Date();
		logger.info("Se obtienen datos TEST1");
		final String sql = new StringBuffer()
				.append("SELECT X.* ")
				.append("FROM session.TEST1 T1, ")
				.append("XMLTABLE ('$d/ventaTotalizadoResponse/ventaTotalizado' passing T1.log as \"d\" ")
				.append("COLUMNS ")
				.append("FECHA VARCHAR(50) PATH 'fecha',")
				.append("PAIS BIGINT PATH 'pais',")
				.append("CADENA BIGINT PATH 'cadena',")
				.append("TIENDA BIGINT PATH 'tienda',")
				.append("IMPORTE_CON_IVA FLOAT PATH 'importeConIVA',")
				.append("IMPORTE_SIN_IVA FLOAT PATH 'importeSinIVA'")
				.append(") AS X")
				.append("where tienda=224")
				.toString();
		final List<VentaDto> resultado = jdbcTemplate.query(sql, new BeanPropertyRowMapper(VentaDto.class));
		logger.info("Se obtienen datos TEST1: OK : " + getLogTiempo(time1));
		return resultado;
	}

	@Override
	public List<VentaDto> getDatosJoinXMLCompleto() {
		crearTemporalTest2();
		crearTemporalTest3();

		java.util.Date time1 = new java.util.Date();
		logger.info("Se inserta datos en temporal TEST2");
		String sql = new StringBuffer()
				.append("INSERT INTO session.TEST2 ")
				.append("(fecha, idPais, idCadena, idTienda, importeSinIVA, importeConIVA) ")
				.append("SELECT X.fecha, X.pais, X.cadena, X.tienda, X.importeSinIVA, X.importeConIVA ")
				.append("FROM session.TEST1 T1, ")
				.append("XMLTABLE ('$d/ventaTotalizadoResponse/ventaTotalizado' passing T1.log as \"d\" ")
				.append("COLUMNS ")
				.append("FECHA VARCHAR(50) PATH 'fecha',")
				.append("PAIS BIGINT PATH 'pais',")
				.append("CADENA BIGINT PATH 'cadena',")
				.append("TIENDA BIGINT PATH 'tienda',")
				.append("IMPORTE_CON_IVA FLOAT PATH 'importeConIVA',")
				.append("IMPORTE_SIN_IVA FLOAT PATH 'importeSinIVA'")
				.append(") AS X")
				.toString();
		jdbcTemplate.execute(sql);
		logger.info("Se inserta datos en temporal TEST2: OK : " + getLogTiempo(time1));

		time1 = new java.util.Date();
		logger.info("Se inserta datos en temporal TEST3");
		sql = new StringBuffer()
				.append("INSERT INTO session.TEST3 ")
				.append("(fecha, idPais, idCadena, idTienda, importeSinIVA, importeConIVA) ")
				.append("SELECT fecha, idPais, idCadena, idTienda, importeSinIVA, importeConIVA")
				.append(" FROM session.TEST2")
				.toString();
		jdbcTemplate.execute(sql);
		logger.info("Se inserta datos en temporal TEST3: OK : " + getLogTiempo(time1));

		time1 = new java.util.Date();
		logger.info("Se obtienen datos TEST3");
		sql = new StringBuffer().append("SELECT t1.fecha, t1.idPais, t1.idCadena, t1.idTienda, t1.importeSinIVA, t1.importeConIVA ")
				.append("FROM session.TEST2 t1 ")
				.append("INNER JOIN session.TEST3 t2 ")
				.append(" ON t1.fecha=t2.fecha")
				.append(" AND t1.idPais=t2.idPais")
				.append(" AND t1.idCadena=t2.idCadena")
				.append(" AND t1.idTienda=t2.idTienda")
				.append(" AND t1.idTienda=224")
				.toString();
		final List<VentaDto> resultado = jdbcTemplate.query(sql, new BeanPropertyRowMapper(VentaDto.class));
		logger.info("Se obtienen datos TEST3: OK : " + getLogTiempo(time1));
		return resultado;
	}

	private void borrarTemporal(final String nombre) {
		try {
			jdbcTemplate.execute("DROP TABLE session." + nombre);
		} catch (Exception e) {}
	}
	
	private String getLogTiempo(final java.util.Date fechaInicio) {
		final Long milliseconds = (((new java.util.Date()).getTime()) - fechaInicio.getTime());
		return milliseconds + " ms";
	}

	@Override
	public void insertarDatosXMLTrozos(List<VentaDto> ventas) {
		java.util.Date time1 = new java.util.Date();
		logger.info("Se inserta datos en temporal TEST2");
		final String sql = new StringBuffer()
				.append("INSERT INTO session.TEST2 ")
				.append("(fecha, idPais, idCadena, idTienda, importeSinIVA, importeConIVA) ")
				.append("VALUES (?, ?, ?, ?, ?, ?) ").toString();

		final int[] result = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				VentaDto v = ventas.get(i);
				ps.setDate(1, new Date(v.getFecha().getTime()));
				ps.setInt(2, v.getIdPais());
				ps.setInt(3, v.getIdCadena());
				ps.setInt(4, v.getIdTienda());
				ps.setFloat(5, v.getImporteSinIva());
				ps.setFloat(6, v.getImporteConIva());
			}

			@Override
			public int getBatchSize() {
				return ventas.size();
			}
		});
		logger.info("Se inserta datos en temporal TEST2: OK : " + getLogTiempo(time1));
	}

	@Override
	public List<VentaDto> getDatosXMLTrozos() {
		java.util.Date time1 = new java.util.Date();
		logger.info("Se obtienen datos TEST2");
		final String sql = new StringBuffer().append("SELECT ")
				.append(" fecha, idPais, idCadena, idTienda, importeSinIVA, importeConIVA")
				.append(" FROM session.TEST2")
				.append(" WHERE idTienda=224")
				.toString();
		final List<VentaDto> resultado = jdbcTemplate.query(sql, new BeanPropertyRowMapper(VentaDto.class));
		logger.info("Se obtienen datos TEST2: OK : " + getLogTiempo(time1));
		return resultado;
	}

	@Override
	public List<VentaDto> getDatosJoinXMLTrozos() {
		crearTemporalTest3();

		java.util.Date time1 = new java.util.Date();
		logger.info("Se inserta datos en temporal TEST3");
		String sql = new StringBuffer()
				.append("INSERT INTO session.TEST3 ")
				.append("(fecha, idPais, idCadena, idTienda, importeSinIVA, importeConIVA) ")
				.append("SELECT fecha, idPais, idCadena, idTienda, importeSinIVA, importeConIVA")
				.append(" FROM session.TEST2")
				.toString();
		jdbcTemplate.execute(sql);
		logger.info("Se inserta datos en temporal TEST3: OK : " + getLogTiempo(time1));

		time1 = new java.util.Date();
		logger.info("Se obtienen datos TEST3");
		sql = new StringBuffer().append("SELECT t1.fecha, t1.idPais, t1.idCadena, t1.idTienda, t1.importeSinIVA, t1.importeConIVA ")
				.append("FROM session.TEST2 t1 ")
				.append("INNER JOIN session.TEST3 t2 ")
				.append(" ON t1.fecha=t2.fecha")
				.append(" AND t1.idPais=t2.idPais")
				.append(" AND t1.idCadena=t2.idCadena")
				.append(" AND t1.idTienda=t2.idTienda")
				.append(" AND t1.idTienda=224")
				.toString();
		final List<VentaDto> resultado = jdbcTemplate.query(sql, new BeanPropertyRowMapper(VentaDto.class));
		logger.info("Se obtienen datos TEST3: OK : " + getLogTiempo(time1));
		return resultado;
	}

	@Override
	public void insertarDatosJSONCompleto(String contenidoFichero) {
		// TODO Completar
	}

	@Override
	public List<VentaDto> getDatosJSONCompleto() {
		// TODO Completar
		return null;
	}

	@Override
	public List<VentaDto> getDatosJoinJSONCompleto() {
		// TODO Completar
		return null;
	}
}
