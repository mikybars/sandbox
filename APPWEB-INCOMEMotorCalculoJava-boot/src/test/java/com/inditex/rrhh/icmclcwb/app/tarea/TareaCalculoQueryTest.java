package com.inditex.rrhh.icmclcwb.app.tarea;

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
public class TareaCalculoQueryTest {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoGlobalTiendaRepository.calcular.WhereIdTarea']}")
    private String sqlCalcularGlobalTiendaWhereIdTarea;

    @Test
    @Ignore("Se necesita un tarea y un algoritmo para probar este calculo")
    public void sqlCalcularGlobalTiendaWhereIdTarea() {
        MapSqlParameterSource arg = new MapSqlParameterSource();
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, 7L);
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, 1L);
        namedParameterJdbcTemplate.update(sqlCalcularGlobalTiendaWhereIdTarea, arg);
    }

}
