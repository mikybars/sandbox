package com.inditex.rrhh.icmclcwb.model.primary.repository;

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

	private final static String CREATE_TABLE_BASE = "DECLARE GLOBAL TEMPORARY TABLE ${table} (${field}) ON COMMIT PRESERVE ROWS NOT LOGGED";
	private final static String CREATE_INDEX_TABLE_BASE = "CREATE INDEX ${table}_${id} ON ${table} (${field})";
	private final static String CREATE_INSERT_BASE = "INSERT INTO ${table} (${field}) VALUES ${value}";
	private final static String CREATE_INSERT_VALUE_BASE = "(${value})";
	
	private final static String TABLE_EMPLEADO_NAME = "SESSION.EMPLEADO";
	private final static String CREATE_TABLE_EMPLEADO_FIELD = "ID BIGINT, ID_DATA BIGINT";
	private final static List<String> CREATE_INDEX_TABLE_EMPLEADO_NAME = Arrays.asList("ID, ID_DATA", "ID_DATA");

	@Override
	public void jdbcTemplate() {
		if (jdbcTemplate != null) {
			LOG.info("Tenemos jdbcTemplate");
			// jdbcTemplate.execute(crearTablaTemporal(TABLE_EMPLEADO_NAME,
			// CREATE_TABLE_EMPLEADO_FIELD));
			// IntStream.range(0, CREATE_INDEX_TABLE_EMPLEADO_NAME.size())
			// .forEach(idx ->
			// jdbcTemplate.execute(crearIndiceTablaTemporal(TABLE_EMPLEADO_NAME,
			// idx, CREATE_INDEX_TABLE_EMPLEADO_NAME.get(idx))));
			LOG.info(crearTablaTemporal(TABLE_EMPLEADO_NAME, CREATE_TABLE_EMPLEADO_FIELD));
			IntStream.range(0, CREATE_INDEX_TABLE_EMPLEADO_NAME.size())
							.forEach(idx -> LOG.info(crearIndiceTablaTemporal(TABLE_EMPLEADO_NAME, idx,
											CREATE_INDEX_TABLE_EMPLEADO_NAME.get(idx))));
			
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
		return sub.replace(CREATE_TABLE_BASE);
	}

	private String crearIndiceTablaTemporal(String table, int id, String field) {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("table", table);
		valuesMap.put("id", String.valueOf(id));
		valuesMap.put("field", field);
		StrSubstitutor sub = new StrSubstitutor(valuesMap);
		return sub.replace(CREATE_INDEX_TABLE_BASE);
	}
	
	private String createInsert(String table, String field, List<String> values) {
		String value = null;
		if (CollectionUtils.isEmpty(values)) {
			int valueLength = StringUtils.join(field, ",").length();
		} else {
			
		}
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("table", table);
		valuesMap.put("field", field);
		valuesMap.put("value", value);
		StrSubstitutor sub = new StrSubstitutor(valuesMap);
		return sub.replace(CREATE_INDEX_TABLE_BASE);
	}

}