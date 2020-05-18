package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TareaPersonaEstructuraDesplazamientoRepositoryCustomImplTest {

    private static final String SQL_SAVE = "SQL SAVE";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @InjectMocks
    private TareaPersonaEstructuraDesplazamientoRepositoryCustomImpl tareaPersonaEstructuraDesplazamientoRepositoryCustom;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.tareaPersonaEstructuraDesplazamientoRepositoryCustom,
                "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(this.tareaPersonaEstructuraDesplazamientoRepositoryCustom,
                "batchSize", 100, true);
    }

    @Test
    public void saveTest() {
        final List<TareaPersonaEstructuraDesplazamiento> items = Arrays
            .asList(mock(TareaPersonaEstructuraDesplazamiento.class));
        this.tareaPersonaEstructuraDesplazamientoRepositoryCustom.save(items);
        verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
        assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
    }

}
