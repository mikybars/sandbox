package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SessionRepositoryImpl implements SessionRepository {

	@Autowired
	private Logger LOG;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	private final static String CREATE_TABLE_BASE_H2 = "CREATE MEMORY LOCAL TEMPORARY TABLE ${table} (${field})";
	@SuppressWarnings("unused")
	private final static String CREATE_TABLE_BASE_SQL = "DECLARE GLOBAL TEMPORARY TABLE ${table} (${field}) ON COMMIT PRESERVE ROWS NOT LOGGED";
	private final static String CREATE_TABLE_BASE = CREATE_TABLE_BASE_H2;
	private final static String CREATE_INDEX_TABLE_BASE = "CREATE INDEX ${table}_${id} ON ${table} (${field})";
	private final static String INSERT_BASE = "INSERT INTO ${table} (${field})";
	@SuppressWarnings("unused")
	private final static String INSERT_SELECT_BASE = INSERT_BASE + " ${value}";
	private final static String INSERT_VALUES_BASE = INSERT_BASE + " VALUES ${value}";
	private final static String INSERT_VALUES_VALUE_BASE = "(${value})";
	private final static String INSERT_VALUES_VALUE_PARAMETER_BASE = "?";

	private final static String TABLE_EMPLEADO_NAME = "SESSION.EMPLEADO";
	private final static String CREATE_TABLE_EMPLEADO_FIELD = "ID BIGINT, ID_DATA BIGINT";
	private final static List<String> CREATE_INDEX_TABLE_EMPLEADO_NAME = Arrays.asList("ID, ID_DATA", "ID_DATA");
	private final static String INSERT_EMPLEADO_FIELD = "ID, ID_DATA";

	@Override
	public void jdbcTemplate() {
		if (jdbcTemplate != null) {
			LOG.info("Tenemos jdbcTemplate");
			// Tablas
			jdbcTemplate.execute(crearTablaTemporal(TABLE_EMPLEADO_NAME, CREATE_TABLE_EMPLEADO_FIELD));
			// Índices
			IntStream.range(0, CREATE_INDEX_TABLE_EMPLEADO_NAME.size())
							.forEach(idx -> jdbcTemplate.execute(crearIndiceTablaTemporal(TABLE_EMPLEADO_NAME, idx,
											CREATE_INDEX_TABLE_EMPLEADO_NAME.get(idx))));
			// Insert
			jdbcTemplate.batchUpdate(createInsertValues(TABLE_EMPLEADO_NAME, INSERT_EMPLEADO_FIELD, new ArrayList<>()),
							new BatchPreparedStatementSetter() {

								@Override
								public void setValues(PreparedStatement ps, int i) throws SQLException {
									ps.setInt(1, i + 100);
									ps.setInt(2, i + 1000);
								}

								@Override
								public int getBatchSize() {
									return 3;
								}

							});
			jdbcTemplate.execute(createInsertValues(TABLE_EMPLEADO_NAME, INSERT_EMPLEADO_FIELD,
							new ArrayList<>(Arrays.asList("1, 17", "2, 18", "3, 20"))));
			jdbcTemplate.batchUpdate(createInsertValues(TABLE_EMPLEADO_NAME, INSERT_EMPLEADO_FIELD,
							new ArrayList<>(Arrays.asList("61, 117", "62, 118", "63, 120"))));

		} else {
			LOG.info("No tenemos jdbcTemplate");
		}
	}

	@Override
	public void entityManager() {
		if (entityManager != null) {
			LOG.info("Tenemos entityManager");
		} else {
			LOG.info("No tenemos entityManager");
		}
	}

	private String crearTablaTemporal(String table, String field) {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("table", table);
		valuesMap.put("field", field);
		StrSubstitutor sub = new StrSubstitutor(valuesMap);
		String result = sub.replace(CREATE_TABLE_BASE);
		LOG.info("crearTablaTemporal: " + result);
		return result;
	}

	private String crearIndiceTablaTemporal(String table, int id, String field) {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("table", table);
		valuesMap.put("id", String.valueOf(id));
		valuesMap.put("field", field);
		StrSubstitutor sub = new StrSubstitutor(valuesMap);
		String result = sub.replace(CREATE_INDEX_TABLE_BASE);
		LOG.info("crearIndiceTablaTemporal: " + result);
		return result;
	}

	private String createInsertValues(String table, String field, List<String> values) {
		if (CollectionUtils.isEmpty(values)) {
			// if (values == null) {
			// values = new ArrayList<>();
			// }
			final int fieldLength = StringUtils.split(field, ",").length;
			List<String> valueParam = new ArrayList<>();
			IntStream.range(0, fieldLength).forEach(idx -> {
				LOG.info("INSERT_VALUE_PARAMETER_BASE: " + idx);
				valueParam.add(INSERT_VALUES_VALUE_PARAMETER_BASE);
			});
			values.add(StringUtils.join(valueParam, ","));
		}

		final int valuesLength = values.size();
		IntStream.range(0, valuesLength).forEach(idx -> {
			LOG.info("INSERT_VALUE_BASE: " + idx);
			Map<String, String> valuesMap = new HashMap<>();
			valuesMap.put("value", values.get(idx));
			StrSubstitutor sub = new StrSubstitutor(valuesMap);
			values.set(idx, sub.replace(INSERT_VALUES_VALUE_BASE));
		});

		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("table", table);
		valuesMap.put("field", field);
		valuesMap.put("value", StringUtils.join(values, ","));
		StrSubstitutor sub = new StrSubstitutor(valuesMap);
		String result = sub.replace(INSERT_VALUES_BASE);
		LOG.info("createInsertValues: " + result);
		return result;
	}

}