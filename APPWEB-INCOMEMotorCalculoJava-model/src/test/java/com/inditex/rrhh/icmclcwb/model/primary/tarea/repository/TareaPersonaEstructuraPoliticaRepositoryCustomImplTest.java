package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class TareaPersonaEstructuraPoliticaRepositoryCustomImplTest {

    private static final String SQL_SAVE = "SQL_SAVE";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @InjectMocks
    private TareaPersonaEstructuraPoliticaRepositoryCustomImpl tareaPersonaEstructuraPoliticaRepositoryCustom;

    @BeforeEach
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.tareaPersonaEstructuraPoliticaRepositoryCustom,
                "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(this.tareaPersonaEstructuraPoliticaRepositoryCustom,
                "batchSize", 100, true);
    }

    @Test
    public void saveTest() {
        final List<TareaPersonaEstructuraPolitica> items = Arrays.asList(mock(TareaPersonaEstructuraPolitica.class));
        this.tareaPersonaEstructuraPoliticaRepositoryCustom.save(items);
        verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
        assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
    }

}
