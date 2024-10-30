package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPipeConstants;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith({SpringExtension.class})
class TareaMigrarComisionRepositoryCustomImplTest {


    public static final String SQL_RESULT_ICM_ID_PERIODO = "ICM_ID_PERIODO";

    private final static String SQL_FIND_CALCULO_COMISION = "SQL FIND CALCULO COMISION";
    @InjectMocks
    private TareaMigrarComisionRepositoryCustomImpl tareaMigrarComisionRepositoryCustomImpl;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @BeforeEach
    public void setUp() throws IllegalAccessException{

        MockitoAnnotations.openMocks(this);
        FieldUtils.writeField(this.tareaMigrarComisionRepositoryCustomImpl,
            "sqlFindCalculoComision",
            SQL_FIND_CALCULO_COMISION ,
            true);
    }


    @Test
    void findCalculoComisionByTareaActualTest() {
        final TareaDto tarea = new TareaDto();
        tarea.setId(1L);
        final TareaMigrarComisionDto expectedDto = new TareaMigrarComisionDto();
        expectedDto.setIcmIdPeriodo(1L);
        this.tareaMigrarComisionRepositoryCustomImpl.findCalculoComisionByTareaActual(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
            ArgumentMatchers.<RowMapper<IdPersonaLocalFechaIncidenciaDto>>any());
        assertEquals(SQL_FIND_CALCULO_COMISION,
            this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertEquals(1, params.getValues().size());

        assertTrue(params.hasValue(SqlPipeConstants.SQL_RESULT_ICM_ID_PERIODO));
    }
}
