package com.inditex.rrhh.icmclcwb.model.repository;

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

import com.inditex.rrhh.icmclcwb.api.dto.VentaDTO;

@Repository
public class SQLServerRepositoryImpl implements SQLServerRepository {
	@Autowired
	private Logger logger;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public void crearTemporalTest1() {
		final java.util.Date time1 = new java.util.Date();
		
		// Creacion tabla temporal
		logger.info("Se crea temporal TEST1");
		borrarTemporal("TEST1");
		jdbcTemplate.execute("CREATE TABLE #TEST1 (_id bigint primary key identity, log XML);");
		logger.info("Se crea temporal TEST1: OK : " + getLogTiempo(time1));
	}

	@Override
	public void crearTemporalTest2() {
		java.util.Date time1 = new java.util.Date();
		
		// Creacion tabla temporal
		logger.info("Se crea temporal TEST2");
		borrarTemporal("TEST2");
		jdbcTemplate.execute("CREATE TABLE #TEST2 (_id bigint primary key identity, fecha datetime, IDPAIS bigint, IDCADENA bigint, IDTIENDA bigint, importeSinIVA float, importeConIVA float);");
		logger.info("Se crea temporal TEST2: OK : " + getLogTiempo(time1));
		
		time1 = new java.util.Date();
		logger.info("Se crea indice TEST2");
		jdbcTemplate.execute("CREATE NONCLUSTERED INDEX INDICE_TEST2 ON #TEST2 (FECHA, IDPAIS, IDCADENA, IDTIENDA);");
		logger.info("Se crea indice TEST2: OK : " + getLogTiempo(time1));
		
	}

	@Override
	public void crearTemporalTest3() {
		java.util.Date time1 = new java.util.Date();
		
		// Creacion tabla temporal
		logger.info("Se crea temporal TEST3");
		borrarTemporal("TEST3");
		jdbcTemplate.execute("CREATE TABLE #TEST3 (_id bigint primary key identity, fecha datetime, idPais bigint, idCadena bigint, idTienda bigint, importeSinIVA float, importeConIVA float);");
		logger.info("Se crea temporal TEST3: OK : " + getLogTiempo(time1));
		
		time1 = new java.util.Date();
		logger.info("Se crea indice TEST3");
		jdbcTemplate.execute("CREATE NONCLUSTERED INDEX INDICE_TEST3 ON #TEST3 (FECHA, IDPAIS, IDCADENA, IDTIENDA);");
		logger.info("Se crea indice TEST3: OK : " + getLogTiempo(time1));
	}

	@Override
	public void insertarDatosXMLCompleto(final String contenidoFichero) {
		java.util.Date time1 = new java.util.Date();
		logger.info("Se insertan datos TEST1");
		//final String sql = new StringBuffer().append("INSERT INTO #TEST1 (log) VALUES (CONVERT(XML, N'")
//		.append(contenidoFichero).append("', 2));").toString();
		final String sql = new StringBuffer().append("INSERT INTO #TEST1 (log) VALUES ('")
				.append(contenidoFichero).append("');").toString();
		jdbcTemplate.update(sql);
		logger.info("Se insertan datos TEST1: OK : " + getLogTiempo(time1));
	}

	@Override
	public List<VentaDTO> getDatosXMLCompleto() {
		java.util.Date time1 = new java.util.Date();
		logger.info("Se obtienen datos TEST1");
		final String sql = new StringBuffer()
				.append("SELECT A.*")
				.append("FROM ")
				.append("(SELECT ")
				.append(" p.value('(./fecha/node())[1]', 'datetime') as fecha,")
				.append(" p.value('(./pais/node())[1]', 'bigint') as idPais,")
				.append(" p.value('(./cadena/node())[1]', 'bigint') as idCadena,")
				.append(" p.value('(./tienda/node())[1]', 'bigint') as idTienda,")
				.append(" p.value('(./importeSinIVA/node())[1]', 'float') as importeSinIVA,")
				.append(" p.value('(./importeConIVA/node())[1]', 'float') as importeConIVA")
				.append(" FROM #TEST1 T1")
				.append(" CROSS APPLY log.nodes('/ventaTotalizadoResponse/ventaTotalizado') t(p)")
				.append(") A")
				.append(" WHERE A.idTienda=224")
				.toString();
		final List<VentaDTO> resultado = jdbcTemplate.query(sql, new BeanPropertyRowMapper(VentaDTO.class));
		logger.info("Se obtienen datos TEST1: OK : " + getLogTiempo(time1));
		return resultado;
	}

	public List<VentaDTO> getDatosJoinXMLCompleto() {
		crearTemporalTest2();
		crearTemporalTest3();

		java.util.Date time1 = new java.util.Date();
		logger.info("Se inserta datos en temporal TEST2");
		String sql = new StringBuffer()
				.append("INSERT INTO #TEST2 ")
				.append("(fecha, idPais, idCadena, idTienda, importeSinIVA, importeConIVA) ")
				.append("SELECT ")
				.append(" p.value('(./fecha/node())[1]', 'datetime') as fecha,")
				.append(" p.value('(./pais/node())[1]', 'bigint') as idPais,")
				.append(" p.value('(./cadena/node())[1]', 'bigint') as idCadena,")
				.append(" p.value('(./tienda/node())[1]', 'bigint') as idTienda,")
				.append(" p.value('(./importeSinIVA/node())[1]', 'float') as importeSinIVA,")
				.append(" p.value('(./importeConIVA/node())[1]', 'float') as importeConIVA")
				.append(" FROM #TEST1 T1")
				.append(" CROSS APPLY log.nodes('/ventaTotalizadoResponse/ventaTotalizado') t(p);")
				.toString();
		jdbcTemplate.execute(sql);
		logger.info("Se inserta datos en temporal TEST2: OK : " + getLogTiempo(time1));

		time1 = new java.util.Date();
		logger.info("Se inserta datos en temporal TEST3");
		sql = new StringBuffer()
				.append("INSERT INTO #TEST3 ")
				.append("(fecha, idPais, idCadena, idTienda, importeSinIVA, importeConIVA) ")
				.append("SELECT fecha, idPais, idCadena, idTienda, importeSinIVA, importeConIVA")
				.append(" FROM #TEST2;")
				.toString();
		jdbcTemplate.execute(sql);
		logger.info("Se inserta datos en temporal TEST3: OK : " + getLogTiempo(time1));

		time1 = new java.util.Date();
		logger.info("Se obtienen datos TEST3");
		sql = new StringBuffer().append("SELECT t1.fecha, t1.idPais, t1.idCadena, t1.idTienda, t1.importeSinIVA, t1.importeConIVA ")
				.append("FROM #TEST2 t1 ")
				.append("INNER JOIN #TEST3 t2 ")
				.append(" ON t1.fecha=t2.fecha")
				.append(" AND t1.idPais=t2.idPais")
				.append(" AND t1.idCadena=t2.idCadena")
				.append(" AND t1.idTienda=t2.idTienda")
				.append(" AND t1.idTienda=224")
				.toString();
		final List<VentaDTO> resultado = jdbcTemplate.query(sql, new BeanPropertyRowMapper(VentaDTO.class));
		logger.info("Se obtienen datos TEST3: OK : " + getLogTiempo(time1));
		return resultado;
	}

	@Override
	public void insertarDatosXMLTrozos(final List<VentaDTO> ventas) {
		java.util.Date time1 = new java.util.Date();
		logger.info("Se inserta datos en temporal TEST2");
		final String sql = new StringBuffer()
				.append("INSERT INTO #TEST2 ")
				.append("(fecha, idPais, idCadena, idTienda, importeSinIVA, importeConIVA) ")
				.append("VALUES (?, ?, ?, ?, ?, ?) ").toString();

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				VentaDTO v = ventas.get(i);
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
	public List<VentaDTO> getDatosXMLTrozos() {
		java.util.Date time1 = new java.util.Date();
		logger.info("Se obtienen datos TEST2");
		final String sql = new StringBuffer().append("SELECT ")
				.append(" fecha, idPais, idCadena, idTienda, importeSinIVA, importeConIVA")
				.append(" FROM #TEST2")
				.append(" WHERE idTienda=224")
				.toString();
		final List<VentaDTO> resultado = jdbcTemplate.query(sql, new BeanPropertyRowMapper(VentaDTO.class));
		logger.info("Se obtienen datos TEST2: OK : " + getLogTiempo(time1));
		return resultado;
	}

	@Override
	public List<VentaDTO> getDatosJoinXMLTrozos() {
		crearTemporalTest3();

		java.util.Date time1 = new java.util.Date();
		logger.info("Se inserta datos en temporal TEST3");
		String sql = new StringBuffer()
				.append("INSERT INTO #TEST3 ")
				.append("(fecha, idPais, idCadena, idTienda, importeSinIVA, importeConIVA) ")
				.append("SELECT fecha, idPais, idCadena, idTienda, importeSinIVA, importeConIVA")
				.append(" FROM #TEST2;")
				.toString();
		jdbcTemplate.execute(sql);
		logger.info("Se inserta datos en temporal TEST3: OK : " + getLogTiempo(time1));

		time1 = new java.util.Date();
		logger.info("Se obtienen datos TEST3");
		sql = new StringBuffer().append("SELECT t1.fecha, t1.idPais, t1.idCadena, t1.idTienda, t1.importeSinIVA, t1.importeConIVA ")
				.append("FROM #TEST2 t1 ")
				.append("INNER JOIN #TEST3 t2 ")
				.append(" ON t1.fecha=t2.fecha")
				.append(" AND t1.idPais=t2.idPais")
				.append(" AND t1.idCadena=t2.idCadena")
				.append(" AND t1.idTienda=t2.idTienda")
				.append(" AND t1.idTienda=224")
				.toString();
		final List<VentaDTO> resultado = jdbcTemplate.query(sql, new BeanPropertyRowMapper(VentaDTO.class));
		logger.info("Se obtienen datos TEST3: OK : " + getLogTiempo(time1));
		return resultado;
	}

	private void borrarTemporal(final String nombre) {
		jdbcTemplate.execute("IF OBJECT_ID('tempdb..#"+nombre+"') IS NOT NULL BEGIN  DROP TABLE #"+nombre+" END;");
	}
	
	private String getLogTiempo(final java.util.Date fechaInicio) {
		final Long milliseconds = (((new java.util.Date()).getTime()) - fechaInicio.getTime());
		return milliseconds + " ms";
	}

	@Override
	public void insertarDatosJSONCompleto(String contenidoFichero) {
		// TODO Completar
	}

	@Override
	public List<VentaDTO> getDatosJSONCompleto() {
		// TODO completar
		return null;
	}

	@Override
	public List<VentaDTO> getDatosJoinJSONCompleto() {
		// TODO Completar
		return null;
	}
}
