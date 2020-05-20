package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoCalculoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustomImplTest {

    private final static String SQL_BASE = "SQL CALCULAR BASE";

    private final static String SQL_CALCULAR = "SQL CALCULAR";

    @Mock
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Mock
    private TipoDatoService tipoDatoService;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource[]> params;

    @InjectMocks
    private TareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustomImpl tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustomImpl;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustomImpl,
                "sqlCalcular", SQL_CALCULAR, true);
        FieldUtils.writeField(tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustomImpl,
                "sqlCalcularBase", SQL_BASE, true);
    }

    @Test
    public void idsTest() {
        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        TareaCalculoPersonaDto persona2 = mock(TareaCalculoPersonaDto.class);
        List<TareaCalculoPersonaDto> personas = Arrays.asList(persona1, persona2);
        when(tareaCalculoPersonaService.findByAlgoritmo(any(TareaDto.class), any(AlgoritmoDto.class)))
            .thenReturn(personas);

        TareaDto tarea = mock(TareaDto.class);
        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);

        List<TareaCalculoPersonaDto> ids = tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustomImpl
            .ids(algoritmo, tarea);

        assertEquals(2, ids.size());
        assertEquals(personas, ids);
    }


    @Test
    public void getMapValuesTest() {
        when(tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(Arrays.asList(
                IdTipoDatoDto.builder()
                    .id(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                    .build(),
                IdTipoDatoDto.builder()
                    .id(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                    .build(),
                IdTipoDatoDto.builder()
                    .id(TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                    .build()));
        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(1001);
        when(algoritmo.getTipoCalculo()).thenReturn(
                Arrays.asList(
                        TipoCalculoDto
                            .builder()
                            .id("011")
                            .build()));
        when(algoritmo.getTipoComision()).thenReturn(
                Arrays.asList(
                        TipoComisionDto
                            .builder()
                            .id("011")
                            .build(),
                        TipoComisionDto
                            .builder()
                            .id("012")
                            .build()));
        when(algoritmo.getDesplazamiento()).thenReturn(Boolean.TRUE);
        when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(101L);
        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        when(persona1.getCclIdPerson()).thenReturn("AT1001");
        when(persona1.getStdOrHrPeriod()).thenReturn("01");

        Map<String, Object> result = tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);

        // Parámetros de la consulta: activo, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod,
        // comisionable, calcula
        assertEquals(14, result.size());
        // idTarea
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // cclIdPerson
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
        assertEquals(persona1.getCclIdPerson(), result.get(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
        // stdOrHrPeriod
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
        assertEquals(persona1.getStdOrHrPeriod(), result.get(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
        // idAlgoritmo
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO));
        assertEquals(algoritmo.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO));
        // comisionable
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
                result.get(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE));
        // calcula
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_CALCULA));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, result.get(SqlPrimaryConstants.SQL_PARAM_CALCULA));
        // activo
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, result.get(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        // activo
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, result.get(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        // tipocomision
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
        assertEquals(Arrays.asList("011", "012"), result.get(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
        // tipocalculo
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
        assertEquals(Arrays.asList("011"), result.get(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
        // esDesplazamiento
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
                result.get(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO));
        // esDesplazamientoBase
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                result.get(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
        // tipoDatoLocalizacionPersonaPresencia
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
        assertEquals(Arrays.asList(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
                TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
                TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()),
                result.get(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
    }


    @Test
    public void calcularTest() {
        when(tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(Arrays.asList(
                IdTipoDatoDto.builder()
                    .id(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                    .build(),
                IdTipoDatoDto.builder()
                    .id(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                    .build(),
                IdTipoDatoDto.builder()
                    .id(TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                    .build()));
        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(1001);
        when(algoritmo.getTipoCalculo()).thenReturn(
                Arrays.asList(
                        TipoCalculoDto
                            .builder()
                            .id("011")
                            .build()));
        when(algoritmo.getTipoComision()).thenReturn(
                Arrays.asList(
                        TipoComisionDto
                            .builder()
                            .id("011")
                            .build(),
                        TipoComisionDto
                            .builder()
                            .id("012")
                            .build()));
        when(algoritmo.getDesplazamiento()).thenReturn(Boolean.TRUE);
        when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(101L);
        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        when(persona1.getCclIdPerson()).thenReturn("AT1001");
        when(persona1.getStdOrHrPeriod()).thenReturn("01");
        TareaCalculoPersonaDto persona2 = mock(TareaCalculoPersonaDto.class);
        when(persona2.getCclIdPerson()).thenReturn("AT1002");
        when(persona2.getStdOrHrPeriod()).thenReturn("02");
        List<TareaCalculoPersonaDto> personas = Arrays.asList(persona1, persona2);

        tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustomImpl.calcular(algoritmo,
                tarea, personas);

        // parametros de la consulta: activo, tipoDatoLocalizacionVentaSeccion,
        // idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
        verify(namedParameterJdbcTemplate).batchUpdate(any(String.class), params.capture());
        MapSqlParameterSource[] values = params.getValue();
        assertEquals(2, values.length);
        for (int i = 0; i < values.length; i++) {
            MapSqlParameterSource value = values[i];
            assertEquals(14, value.getValues().size());
            // activo
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
            assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
                    value.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
            // excluidoCalculo
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO));
            assertEquals(algoritmo.getId(), value.getValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO));
            // idTarea
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
            assertEquals(tarea.getId(), value.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
            // comisionable
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE));
            assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
                    value.getValue(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE));
            // calcula
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_CALCULA));
            assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
                    value.getValue(SqlPrimaryConstants.SQL_PARAM_CALCULA));
            // inactivo
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
            assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                    value.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
            // tipocomision
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
            assertEquals(Arrays.asList("011", "012"), value.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
            // tipocalculo
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
            assertEquals(Arrays.asList("011"), value.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
            // esDesplazamiento
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO));
            assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
                    value.getValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO));
            // esDesplazamientoBase
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
            assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                    value.getValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
            // cclIdPerson, stdOrHrPeriod - existencia del parámetro
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
            // tipoDatoLocalizacionPersonaPresencia
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
            assertEquals(Arrays.asList(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
                    TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
                    TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()),
                    value.getValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));

        }

        // cclIdPerson, stdOrHrPeriod - valores del parámetro
        assertEquals(1,
                Arrays.stream(values)
                    .filter(value -> persona1.getCclIdPerson()
                        .equals(value.getValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON))
                            && persona1.getStdOrHrPeriod()
                                .equals(value.getValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD)))
                    .toArray().length);
        assertEquals(1,
                Arrays.stream(values)
                    .filter(value -> persona2.getCclIdPerson()
                        .equals(value.getValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON))
                            && persona2.getStdOrHrPeriod()
                                .equals(value.getValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD)))

                    .toArray().length);
    }

    @Test
    public void getSqlCalcularTest() {

        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(21);

        String result = tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustomImpl
            .getSqlCalcular(algoritmo);
        assertEquals(SQL_BASE, result);

    }

}
