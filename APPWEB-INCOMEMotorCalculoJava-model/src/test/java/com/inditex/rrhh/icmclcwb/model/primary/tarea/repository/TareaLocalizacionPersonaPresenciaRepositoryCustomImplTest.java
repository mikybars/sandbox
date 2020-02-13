package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresenciaPk;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionPersonaPresenciaRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SAVE";
    private final static String SQL_UPDATE_ACTIVO = "UPDATE ACTIVO";
    private final static String SQL_UPDATE_ACTIVO_VACIO = "UPDATE ACTIVO VACIO";
    private final static String SQL_COMPENSAR = "COMPENSAR";
    private final static String SQL_INDICADOR_PRESENCIA = "INDICADOR PRESENCIA";
    private final static String SQL_INDICADOR_PRESENCIA_DESPLAZAMIENTO = "INDICADOR PRESENCIA DESPLAZAMIENTO";
    private final static String SQL_PRESENCIAS_HORAS_FIJAS = "PRESENCIAS HORAS FIJAS";
    private final static String SQL_PRESENCIAS_HORAS_FIJAS_DESPLAZAMIENTO = "PRESENCIAS HORAS FIJAS DESPLAZAMIENTO";
    private final static String SQL_INDICADOR_PERSONA_POR_VENTA = "SQL INDICADOR PERSONA POR VENTA";
    private final static String SQL_INDICADOR_PERSONA_POR_VENTA_SIMPLIFICADA = "SQL INDICADOR PERSONA POR VENTA SIMPLIFICADA";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Mock
    private TipoDatoService tipoDatoService;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TareaLocalizacionPersonaPresenciaRepositoryCustomImpl tareaLocalizacionPersonaPresenciaRepositoryCustom;

    @Captor
    ArgumentCaptor<String> sqlCaptor;

    @Captor
    ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlUpdateActivo", SQL_UPDATE_ACTIVO,
                true);
        FieldUtils.writeField(tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlUpdateActivoVacio",
                SQL_UPDATE_ACTIVO_VACIO, true);
        FieldUtils.writeField(tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlCompensar", SQL_COMPENSAR, true);
        FieldUtils.writeField(tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlIndicadorPresencia",
                SQL_INDICADOR_PRESENCIA, true);
        FieldUtils.writeField(tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlIndicadorPresenciaDesplazamiento",
                SQL_INDICADOR_PRESENCIA_DESPLAZAMIENTO, true);
        FieldUtils.writeField(tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlProcesarPresenciasHorasFijas",
            SQL_PRESENCIAS_HORAS_FIJAS, true);
        FieldUtils.writeField(tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlProcesarPresenciasHorasFijasDesplazamientos",
            SQL_PRESENCIAS_HORAS_FIJAS_DESPLAZAMIENTO, true);
        FieldUtils.writeField(tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlIndicadorPersonaPorVenta",
                SQL_INDICADOR_PERSONA_POR_VENTA, true);
            FieldUtils.writeField(tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlIndicadorPersonaPorVentaSimplificada",
                SQL_INDICADOR_PERSONA_POR_VENTA_SIMPLIFICADA, true);
        FieldUtils.writeField(tareaLocalizacionPersonaPresenciaRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void indicadorPresenciaTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(199L);
        when(runTarea.getTarea()).thenReturn(tarea);

        tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresencia(runTarea);

        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_INDICADOR_PRESENCIA, sqlCaptor.getValue());
        // Parámetros de la consulta: idTarea, activo, idTipoDatoIndicadorPresencia,
        // tiposCalculo, excluidoCalculo
        MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertEquals(6, params.getValues().size());
        // id tarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // activo
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
        // idTipoDatoIndicadorPresencia
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
        assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA.getId(),
                params.getValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
        // tiposCalculo
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
        assertEquals(
                Arrays.asList(TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA.getId(),
                        TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA_Y_REDUCCION_DE_JORNADA.getId()),
                params.getValue(SQL_PARAM_IDS_TIPOS_CALCULO));
        // excluidoCalculo
        assertTrue(params.hasValue(SQL_PARAM_EXCLUIDO_CALCULO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_EXCLUIDO_CALCULO));
    }

    @Test
    public void indicadorPresenciaDesplazamientoTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(199L);
        when(runTarea.getTarea()).thenReturn(tarea);

        tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresenciaDesplazamiento(runTarea);

        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_INDICADOR_PRESENCIA_DESPLAZAMIENTO, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: idTarea, activo, idTipoDatoIndicadorPresencia,
        // excluidoCalculo
        assertEquals(6, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // activo
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
        // idTipoDatoIndicadorPresencia
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
        assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO.getId(),
                params.getValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
        // tiposCalculo
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
        assertEquals(
                Arrays.asList(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId(),
                        TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA.getId(),
                        TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_REDUCCION_DE_JORNADA.getId(),
                        TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA_Y_REDUCCION_DE_JORNADA.getId()),
                params.getValue(SQL_PARAM_IDS_TIPOS_CALCULO));
        // excluidoCalculo
        assertTrue(params.hasValue(SQL_PARAM_EXCLUIDO_CALCULO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_EXCLUIDO_CALCULO));
    }

    @Test
    public void updateActivoVacioTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(199L);
        when(runTarea.getTarea()).thenReturn(tarea);

        tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoVacio(runTarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_UPDATE_ACTIVO_VACIO, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: idTarea, activo, minutos
        assertEquals(4, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // activo
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_ACTIVO));
        // minutos
        assertTrue(params.hasValue(SQL_PARAM_MINUTOS));
        assertEquals(SQL_VALUE_MINUTOS_CERO, params.getValue(SQL_PARAM_MINUTOS));
        // Grupo dato
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
        assertEquals(TipoGrupoDatoEnum.PRESENCIA_PERSONA_TIPOHORA.getId(), params.getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
    }

    @Test
    public void updateActivoTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(199L);
        when(runTarea.getTarea()).thenReturn(tarea);

        when(tipoDatoService
                .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                        .thenReturn(Arrays.asList(new IdTipoDatoDto(12), new IdTipoDatoDto(89)));

        tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivo(runTarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_UPDATE_ACTIVO, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: idTarea, excluidoDenominador, tiposDato,
        // nuevoActivo
        assertEquals(4, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // idTiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Arrays.asList(12, 89), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // excluidoDenominador
        assertTrue(params.hasValue(SQL_PARAM_EXCLUIDO_DENOMINADOR));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_EXCLUIDO_DENOMINADOR));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));

    }

    @Test
    public void compensarTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(199L);
        when(runTarea.getTarea()).thenReturn(tarea);

        when(tipoDatoService
                .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                        .thenReturn(Arrays.asList(new IdTipoDatoDto(12), new IdTipoDatoDto(89)));
        tareaLocalizacionPersonaPresenciaRepositoryCustom.compensar(runTarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_COMPENSAR, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: idTarea, nuevoIdSeccion, nuevoIdTipoDato,
        // excluidoDenominador, idTipoPolitica, tiposDato, activo
        assertEquals(7, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // nuevoIdSeccion
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_SECCION));
        assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_NUEVO_ID_SECCION));
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_INCLUIDODENOMINADOR.getId(),
                params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // excluidoDenominador
        assertTrue(params.hasValue(SQL_PARAM_EXCLUIDO_DENOMINADOR));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_EXCLUIDO_DENOMINADOR));
        // idTipoPolitica
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId(), params.getValue(SQL_PARAM_ID_TIPO_POLITICA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Arrays.asList(12, 89), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // activo
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }

    @Test
    public void presenciasHorasFijasTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(199L);
        when(runTarea.getTarea()).thenReturn(tarea);

        tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciasHorasFijas(runTarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_PRESENCIAS_HORAS_FIJAS, sqlCaptor.getValue());

        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, abierto, idTarea, idTipoPolitica
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(), params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // abierto
        assertTrue(params.hasValue(SQL_PARAM_ABIERTO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ABIERTO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // idTipoPolitica
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.HORAS_FIJAS.getId(), params.getValue(SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    public void presenciasHorasFijasDesplazamientoTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(199L);
        when(runTarea.getTarea()).thenReturn(tarea);

        tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciasHorasFijasDesplazamiento(runTarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_PRESENCIAS_HORAS_FIJAS_DESPLAZAMIENTO, sqlCaptor.getValue());

        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, abierto, idTarea, idTipoPolitica
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(), params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // abierto
        assertTrue(params.hasValue(SQL_PARAM_ABIERTO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ABIERTO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // idTipoPolitica
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.HORAS_FIJAS.getId(), params.getValue(SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    public void indicadorPersonaPorVentaTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(199L);
        when(runTarea.getTarea()).thenReturn(tarea);

        tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPersonaPorVenta(runTarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_INDICADOR_PERSONA_POR_VENTA, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, nuevoIdSeccion, idTarea, idTipoCalculo,
        // activo, idTipoGrupoDato, idTipoGrupoDatoVenta
        assertEquals(8, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId(), params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // nuevoIdSeccion
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_SECCION));
        assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_NUEVO_ID_SECCION));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // idTipoCalculo
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_CALCULO));
        assertEquals(TipoCalculoEnum.POR_VENTA.getId(), params.getValue(SQL_PARAM_ID_TIPO_CALCULO));
        // activo
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
        // idTipoGrupoDato
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
        assertEquals(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(), params.getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
        // idTipoGrupoDatoVenta
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA));
        assertEquals(TipoGrupoDatoEnum.VENTA_INDIVIDUAL_LOCALIZACION.getId(), params.getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA));
    }

    @Test
    public void indicadorPersonaPorVentaSimplificadaTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(199L);
        when(runTarea.getTarea()).thenReturn(tarea);

        tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPersonaPorVentaSimplificada(runTarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_INDICADOR_PERSONA_POR_VENTA_SIMPLIFICADA, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, nuevoIdSeccion, idTarea, idTipoCalculo,
        // activo, idTipoGrupoDatoVenta
        assertEquals(7, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA_SIMPLIFICADA.getId(), params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // nuevoIdSeccion
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_SECCION));
        assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_NUEVO_ID_SECCION));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // idTipoCalculo
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_CALCULO));
        assertEquals(TipoCalculoEnum.POR_VENTA.getId(), params.getValue(SQL_PARAM_ID_TIPO_CALCULO));
        // activo
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
        // idTipoGrupoDatoVenta
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA));
        assertEquals(TipoGrupoDatoEnum.VENTA_INDIVIDUAL_LOCALIZACION.getId(), params.getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA));
    }
    
    @Test
    public void setParametersTest() throws SQLException {

        PreparedStatement pstmt = mock(PreparedStatement.class);
        TareaLocalizacionPersonaPresenciaPk pk = mock(TareaLocalizacionPersonaPresenciaPk.class);
        when(pk.getFechaInicioPeriodo()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(789L);
        TipoDato td = mock(TipoDato.class);
        when(td.getId()).thenReturn(900);
        TareaLocalizacionPersonaPresencia entity = mock(TareaLocalizacionPersonaPresencia.class);
        when(entity.getActivo()).thenReturn(Boolean.TRUE);
        when(entity.getCclIdCadena()).thenReturn("CADENA");
        when(entity.getCclIdCodOrigen()).thenReturn("Id localización");
        when(entity.getCclIdOrigen()).thenReturn("Id origen");
        when(entity.getStdIdLegEnt()).thenReturn("Id empresa");
        when(entity.getCclIdPerson()).thenReturn("Id persona");
        when(entity.getCclIdSeccion()).thenReturn("Id seccion");
        when(entity.getCodTipoHora()).thenReturn(1);
        when(entity.getPk()).thenReturn(pk);
        when(entity.getMinutos()).thenReturn(123);
        when(entity.getTarea()).thenReturn(tarea);
        when(entity.getTipoDato()).thenReturn(td);
        when(entity.getFecha()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));

        tareaLocalizacionPersonaPresenciaRepositoryCustom.setParameters(pstmt, entity);

        // Parámetros de la consulta: CclIdCodOrigen, CclIdOrigen, CclIdPerson,
        // StdIdLegEnt, CclIdSeccion,
        // fecha, minutos, IcmIdTpHora, activo, tipo dato, id tarea, CclIdCadena
        verify(pstmt, times(1)).setString(1, entity.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(2, entity.getCclIdOrigen());
        verify(pstmt, times(1)).setString(3, entity.getCclIdPerson());
        verify(pstmt, times(1)).setString(4, entity.getStdIdLegEnt());
        verify(pstmt, times(1)).setString(5, entity.getCclIdSeccion());
        verify(pstmt, times(1)).setObject(6, entity.getFecha());
        verify(pstmt, times(1)).setLong(7, entity.getMinutos());
        verify(pstmt, times(1)).setInt(8, entity.getCodTipoHora());
        verify(pstmt, times(1)).setBoolean(9, entity.getActivo());
        verify(pstmt, times(1)).setLong(10, td.getId());
        verify(pstmt, times(1)).setLong(11, tarea.getId());
        verify(pstmt, times(1)).setString(12, entity.getCclIdCadena());
        verify(pstmt, times(1)).setObject(13, pk.getFechaInicioPeriodo());
    }

    @Test
    public void saveTest() {

        List<TareaLocalizacionPersonaPresencia> items = Arrays.asList(mock(TareaLocalizacionPersonaPresencia.class));
        tareaLocalizacionPersonaPresenciaRepositoryCustom.save(items);
        verify(namedParameterJdbcTemplate).batchUpdate(sqlCaptor.capture(), any(SqlParameterSource[].class));
        assertEquals(SQL_SAVE, sqlCaptor.getValue());

    }
}
