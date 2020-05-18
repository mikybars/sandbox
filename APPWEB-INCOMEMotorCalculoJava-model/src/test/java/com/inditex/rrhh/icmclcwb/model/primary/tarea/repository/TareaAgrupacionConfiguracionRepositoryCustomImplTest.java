package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracion;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TareaAgrupacionConfiguracionRepositoryCustomImplTest {

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @InjectMocks
    private TareaAgrupacionConfiguracionRepositoryCustomImpl tareaAgrupacionConfiguracionRepositoryCustom;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.tareaAgrupacionConfiguracionRepositoryCustom, "sqlSave", "", true);
        FieldUtils.writeField(this.tareaAgrupacionConfiguracionRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void mergePersonaLocalizacionTest() {

        final List<TareaAgrupacionConfiguracion> items = new ArrayList<>();
        items.add(mock(TareaAgrupacionConfiguracion.class));

        this.tareaAgrupacionConfiguracionRepositoryCustom.save(items);
        verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));

    }

}
