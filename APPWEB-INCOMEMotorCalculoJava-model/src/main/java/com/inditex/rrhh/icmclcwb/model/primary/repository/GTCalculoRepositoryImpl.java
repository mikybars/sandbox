package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
public class GTCalculoRepositoryImpl implements GTCalculoRepository {

    private static final String ID_TIENDA = "idTienda";

    private static final String ID_EMPLEADO = "idEmpleado";

    private static final String ID_TRABAJO = "idTrabajo";

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Value("#{primaryQuery['GTCalculoRepository.calcular']}")
    private String sqlCalcular;

    private StringBuilder queryCalculoGT() {
        return new StringBuilder(sqlCalcular);
    }

    @Override
    public void calcular(Long idTrabajo) {
        NamedParameterJdbcTemplate namedJdbc = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue(ID_TRABAJO, idTrabajo);
        namedJdbc.update(queryCalculoGT().toString(), param);
    }

    @Override
    public void calcularByEmpleadoBatch(Long idTrabajo, List<Long> idsEmpleados) {
        NamedParameterJdbcTemplate namedJdbc = new NamedParameterJdbcTemplate(jdbcTemplate);
        List<Map<String, Object>> batchValues = new ArrayList<>(idsEmpleados.size());
        idsEmpleados.forEach(idEmpleado -> batchValues
                .add(new MapSqlParameterSource(ID_TRABAJO, idTrabajo).addValue(ID_EMPLEADO, idEmpleado).getValues()));

        StringBuilder whereEmpleado = new StringBuilder().append(" AND EMPLEADO_PRESENCIA.ID_EMPLEADO = :idEmpleado ");
        namedJdbc.batchUpdate(queryCalculoGT().append(whereEmpleado).toString(),
                batchValues.toArray(new Map[idsEmpleados.size()]));
    }

    @Override
    public void calcularByTiendaBatch(Long idTrabajo, List<Long> idsTiendas) {
        NamedParameterJdbcTemplate namedJdbc = new NamedParameterJdbcTemplate(jdbcTemplate);
        List<Map<String, Object>> batchValues = new ArrayList<>(idsTiendas.size());
        idsTiendas.forEach(idTienda -> batchValues
                .add(new MapSqlParameterSource(ID_TRABAJO, idTrabajo).addValue(ID_TIENDA, idTienda).getValues()));

        SqlParameterSource[] batch = SqlParameterSourceUtils
                .createBatch(batchValues.toArray(new Map[idsTiendas.size()]));
        StringBuilder whereTienda = new StringBuilder();
        whereTienda.append(" AND TIENDA_VENTA.ID_TIENDA = :idTienda ");
        namedJdbc.batchUpdate(queryCalculoGT().append(whereTienda.toString()).toString(), batch);
    }

}
