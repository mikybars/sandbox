package com.inditex.rrhh.icmclcwb.query;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class QueryTest {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoGlobalTiendaRepository.calcular.WhereIdTarea']}")
    private String sqlCalcularGlobalTiendaWhereIdTarea;
    
    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoGlobalSeccionRepository.calcular.WhereIdTarea']}")
    private String sqlCalcularGlobalSeccionWhereIdTarea;

    @Test
    @Ignore("Se necesita una tarea para probar este calculo")
    public void sqlCalcularGlobalTiendaWhereIdTarea() {
        MapSqlParameterSource arg = new MapSqlParameterSource();
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PROCESO, 1L);
        namedParameterJdbcTemplate.update(sqlCalcularGlobalTiendaWhereIdTarea, arg);
    }
    
    
    @Test
    @Ignore("Se necesita una tarea para probar este calculo")
    public void sqlCalcularGlobalSeccionWhereIdTarea() {
        MapSqlParameterSource arg = new MapSqlParameterSource();
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PROCESO, 1L);
        namedParameterJdbcTemplate.update(sqlCalcularGlobalSeccionWhereIdTarea, arg);
    }
}
