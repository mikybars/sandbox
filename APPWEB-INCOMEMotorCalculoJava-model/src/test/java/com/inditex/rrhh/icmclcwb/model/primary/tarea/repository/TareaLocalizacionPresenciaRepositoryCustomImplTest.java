package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ABIERTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_LOCALIZACION_PRESENCIA_MANUAL;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_REPARTIDO_PROVINCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionPresenciaRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SAVE";

    private final static String SQL_COMPENSAR_LOCALIZACION_MANUAL = "COMPENSAR_LOCALIZACION_MANUAL";

    private final static String SQL_TOTALIZAR = "TOTALIZAR";

    private final static String SQL_REPARTIR_PRESENCIAS_SINDICALES = "REPARTIR PRESENCIAS SINDICALES";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Mock
    private TipoDatoService tipoDatoService;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TareaLocalizacionPresenciaRepositoryCustomImpl tareaLocalizacionPresenciaRepositoryCustom;

    @Captor
    ArgumentCaptor<String> sqlCaptor;

    @Captor
    ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @BeforeEach
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom, "sqlCompensarLocalizacionManual",
                SQL_COMPENSAR_LOCALIZACION_MANUAL,
                true);
        FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom, "sqlTotalizar", SQL_TOTALIZAR, true);
        FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom,
                "sqlRepartirPresenciasSindicalesLocalizacionSeccion", SQL_REPARTIR_PRESENCIAS_SINDICALES, true);
    }

    @Test
    public void compensarLocalizacionManualTest() {

        final RunTareaDto runTarea = mock(RunTareaDto.class);
        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(199L);
        when(runTarea.getTarea()).thenReturn(tarea);

        this.tareaLocalizacionPresenciaRepositoryCustom.compensarLocalizacionManual(runTarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
        assertEquals(SQL_COMPENSAR_LOCALIZACION_MANUAL, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: idTarea, nuevoIdSeccion, nuevoIdTipoDato,
        // excluidoDenominador, idTipoPolitica, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // nuevoIdSeccion
        assertTrue(params.hasValue(SQL_PARAM_ID_SECCION));
        assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_ID_SECCION));
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId(),
                params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Arrays.asList(5018, 5002), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));

    }

    @Test
    public void totalizarQueryTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(),
                any(MapSqlParameterSource.class));
        assertEquals(SQL_TOTALIZAR, this.sqlCaptor.getValue());

    }

    @Test
    public void totalizarNumeroParametrosTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        // Parámetros de la consulta: nuevoIdTipoDato, excluidoDenominador, repartidoProvincia,
        // idTipoPolitica, idTarea, idTipoGrupoDato, activo, horasOrigen, horasDestino,
        // idTipoDatoPresenciasSindicales, idTipoDatoManual
        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertEquals(11, parametros.getValues().size());
    }

    @Test
    public void totalizarParametroIdTareaTest() {

        final TareaDto tarea = new TareaDto();
        final Long idTarea = 1313L;
        tarea.setId(idTarea);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, parametros.getValue(SQL_PARAM_ID_TAREA));

    }

    @Test
    public void totalizarParametroNuevoIdTipoDatoTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId(),
                parametros.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

    }

    @Test
    public void totalizarParametroExcluidoDenominadorTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_EXCLUIDO_DENOMINADOR));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, parametros.getValue(SQL_PARAM_EXCLUIDO_DENOMINADOR));

    }

    @Test
    public void totalizarParametroRepartidoProvinciaTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_REPARTIDO_PROVINCIA));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, parametros.getValue(SQL_PARAM_REPARTIDO_PROVINCIA));

    }

    @Test
    public void totalizarParametroIdTipoPoliticaTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId(), parametros.getValue(SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    public void totalizarParametroIdTipoGrupoDatoTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
        assertEquals(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
                parametros.getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));

    }

    @Test
    public void totalizarParametroActivoTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_ACTIVO));

    }

    @Test
    public void totalizarParametroHorasOrigenTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_HORAS_ORIGEN));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_HORAS_ORIGEN));

    }

    @Test
    public void totalizarParametroHorasDestinoTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_HORAS_DESTINO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, parametros.getValue(SQL_PARAM_HORAS_DESTINO));

    }

    @Test
    public void totalizarParametroIdTipoDatoPresenciasSindicalesTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES));
        assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_HORAS_SINDICALES.getId(),
                parametros.getValue(SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES));

    }

    @Test
    public void totalizarParametroIdTipoDatoManualTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_DATO_LOCALIZACION_PRESENCIA_MANUAL));
        assertEquals(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId(),
                parametros.getValue(SQL_PARAM_ID_TIPO_DATO_LOCALIZACION_PRESENCIA_MANUAL));

    }

    @Test
    public void repartirPresenciasSindicalesLocalizacionQueryTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();

        this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(),
                any(MapSqlParameterSource.class));

        assertEquals(SQL_REPARTIR_PRESENCIAS_SINDICALES, this.sqlCaptor.getValue());

    }

    @Test
    public void repartirPresenciasSindicalesLocalizacionNumeroParametrosTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();

        this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        // Parámetros de la consulta: idTarea, abierto, repartidoProvincia, idTipoGrupoDato,
        // nuevoidTipoDato, activo
        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertEquals(6, parametros.getValues().size());

    }

    @Test
    public void repartirPresenciasSindicalesLocalizacionParametroIdTareaTest() {

        final Long idTarea = 8989L;
        final TareaDto tarea = new TareaDto();
        tarea.setId(idTarea);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();

        this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, parametros.getValue(SQL_PARAM_ID_TAREA));

    }

    @Test
    public void repartirPresenciasSindicalesLocalizacionParametroAbiertoTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();

        this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_ABIERTO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_ABIERTO));

    }

    @Test
    public void repartirPresenciasSindicalesLocalizacionParametroRepartidoProvinciaTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();

        this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_REPARTIDO_PROVINCIA));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_REPARTIDO_PROVINCIA));

    }

    @Test
    public void repartirPresenciasSindicalesLocalizacionParametroNuevoIdTipoDatoTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();

        this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_HORAS_SINDICALES.getId(),
                parametros.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

    }

    @Test
    public void repartirPresenciasSindicalesLocalizacionParametroIdTipoGrupoDatoTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();

        this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
        assertEquals(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
                parametros.getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));

    }

    @Test
    public void repartirPresenciasSindicalesLocalizacionParametroActivoTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(1222L);
        final RunTareaDto runTarea = RunTareaDto
            .builder()
            .tarea(tarea)
            .build();

        this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

        final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
        assertTrue(parametros.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_ACTIVO));

    }

}
