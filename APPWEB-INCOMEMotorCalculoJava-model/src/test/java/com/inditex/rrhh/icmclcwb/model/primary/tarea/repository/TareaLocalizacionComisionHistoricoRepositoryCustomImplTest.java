package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionComisionHistorico;
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
public class TareaLocalizacionComisionHistoricoRepositoryCustomImplTest {

    private static final String SQL_SAVE = "SAVE TEST";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @InjectMocks
    private TareaLocalizacionComisionHistoricoRepositoryCustomImpl tareaLocalizacionComisionHistoricoRepositoryCustom;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.tareaLocalizacionComisionHistoricoRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(this.tareaLocalizacionComisionHistoricoRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void saveTest() {

        final List<TareaLocalizacionComisionHistorico> entities = Arrays
            .asList(mock(TareaLocalizacionComisionHistorico.class));
        this.tareaLocalizacionComisionHistoricoRepositoryCustom.save(entities);
        verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
        assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
    }

}
