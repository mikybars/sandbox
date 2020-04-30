package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoCalculoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

@RunWith(MockitoJUnitRunner.class)
public class TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImplTest {

    private final static String SQL_BASE = "SQL CALCULAR BASE";

    private final static String SQL_CALCULAR = "SQL CALCULAR";

    @Mock
    private TareaCalculoPersonaService tareaCalculoPerosnaService;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Mock
    private TipoDatoService tipoDatoService;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource[]> paramsCaptor;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @InjectMocks
    private TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
        tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom, "sqlCalcular", SQL_CALCULAR, true);
        FieldUtils.writeField(tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom, "sqlCalcularBase", SQL_BASE, true);
    }

    @Test
    public void idsTest() {

        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        TareaCalculoPersonaDto persona2 = mock(TareaCalculoPersonaDto.class);
        List<TareaCalculoPersonaDto> personas = Arrays.asList(persona1, persona2);
        when(tareaCalculoPerosnaService.findByAlgoritmo(any(TareaDto.class), any(AlgoritmoDto.class)))
            .thenReturn(personas);

        TareaDto tarea = mock(TareaDto.class);
        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);

        List<TareaCalculoPersonaDto> ids =
            tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.ids(algoritmo, tarea);

        assertEquals(2, ids.size());
        assertEquals(personas, ids);
    }

    @Test
    public void getMapValuesTest() {

        when(tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_INCLUIDODENOMINADOR.getId())).thenReturn(
            Arrays.asList(
                IdTipoDatoDto
                    .builder()
                    .id(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId())
                    .build(),
                IdTipoDatoDto
                    .builder()
                    .id(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId())
                    .build()));

        when(tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())).thenReturn(
            Arrays.asList(
                IdTipoDatoDto
                    .builder()
                    .id(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                    .build(),
                IdTipoDatoDto
                    .builder()
                    .id(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                    .build(),
                IdTipoDatoDto
                    .builder()
                    .id(TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                    .build()));

        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(8001);
        when(algoritmo.getTipoCalculo()).thenReturn(
            Arrays.asList(
                TipoCalculoDto
                    .builder()
                    .id("011")
                    .build(),
                TipoCalculoDto
                    .builder()
                    .id("012")
                    .build()));
        when(algoritmo.getTipoComision()).thenReturn(
            Arrays.asList(
                TipoComisionDto
                    .builder()
                    .id("001")
                    .build(),
                TipoComisionDto
                    .builder()
                    .id("002")
                    .build(),
                TipoComisionDto
                    .builder()
                    .id("003")
                    .build()));
        when(algoritmo.getDesplazamiento()).thenReturn(Boolean.TRUE);
        when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(101L);
        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        when(persona1.getCclIdPerson()).thenReturn("AT1001");
        when(persona1.getStdOrHrPeriod()).thenReturn("01");

        Map<String, Object> result = tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.getMapValues(algoritmo, tarea, persona1);

        //Parámetros de la consulta: idAlgoritmo, activo, idTipoDatoIndicadorPresencia, idTipoDatoDevolucionLocalizacionPersona,
        // idTipoDatoDevolucionLocalizacion, fechaInicioPeriodo, idTipoDatoImporteComisionDevolucion, cclIdPersonVendedor0,
        // idTipoPresencia, idTarea, cclIdPerson, stdOrHrPeriod, tiposCalculo, tiposComision, esDesplazamiento,
        // esDesplazamientoBase, comisionable, calcula, idTipoDatoIndicadorPresenciaDesplazamientoBase
        assertEquals(19, result.size());
        //activo
        assertTrue(result.containsKey(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ACTIVO));
        //idTipoDatoIndicadorPresencia
        assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
        assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId(), result.get(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
        //tipoDatoLocalizacionPersonaPresencia
        assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
        assertEquals(
            Arrays.asList(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
                TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(), TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()),
            result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
        //idTipoDatoDevolucionLocalizacionPersona
        assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_IMPORTE_DEVOLUCION_LOCALIZACION_PERSONA));
        assertEquals(TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId(), result.get(SQL_PARAM_ID_TIPO_IMPORTE_DEVOLUCION_LOCALIZACION_PERSONA));
        //idTipoDatoDevolucionLocalizacion
        assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION));
        assertEquals(TipoDatoEnum.DEVOLUCION_LOCALIZACION_SECCION.getId(), result.get(SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION));
        //idTipoDatoImporteComisionDevolucion
        assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_DEVOLUCION));
        assertEquals(TipoDatoEnum.IMPORTE_COMISION_DEVOLUCIONES_LOCALIZACION_POR_VENTA.getId(), result.get(SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_DEVOLUCION));
        //cclIdPersonVendedor0
        assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_DATO_REPARTO_VENDEDOR_0));
        assertEquals(TipoDatoEnum.REPARTO_DEVOLUCION_VENDEDOR_0_LOCALIZACION_SECCION.getId(), result.get(SQL_PARAM_ID_TIPO_DATO_REPARTO_VENDEDOR_0));
        //idTipoPresencia
        assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION));
        assertEquals(
            Arrays.asList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId(), TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId()),
            result.get(SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION));
        //idAlgoritmo
        assertTrue(result.containsKey(SQL_PARAM_ID_ALGORITMO));
        assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));
        //idTarea
        assertTrue(result.containsKey(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));
        //cclIdPerson
        assertTrue(result.containsKey(SQL_PARAM_CCL_ID_PERSON));
        assertEquals(persona1.getCclIdPerson(), result.get(SQL_PARAM_CCL_ID_PERSON));
        //stdOrHrPeriod
        assertTrue(result.containsKey(SQL_PARAM_STD_OR_HR_PERIOD));
        assertEquals(persona1.getStdOrHrPeriod(), result.get(SQL_PARAM_STD_OR_HR_PERIOD));
        //comisionable
        assertTrue(result.containsKey(SQL_PARAM_COMISIONABLE));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_COMISIONABLE));
        //calcula
        assertTrue(result.containsKey(SQL_PARAM_CALCULA));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_CALCULA));
        //tiposComision
        assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_COMISION));
        assertEquals(Arrays.asList("001", "002", "003"), result.get(SQL_PARAM_IDS_TIPOS_COMISION));
        //tiposCalculo
        assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_CALCULO));
        assertEquals(Arrays.asList("011", "012"), result.get(SQL_PARAM_IDS_TIPOS_CALCULO));
        //esDesplazamiento
        assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
        //esDesplazamientoBase
        assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
        //idTipoDatoIndicadorPresenciaDesplazamientoBase
        assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE));
        assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId(), result.get(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE));
    }

    @Test
    public void calcularTest() {

        when(tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_INCLUIDODENOMINADOR.getId())).thenReturn(
            Arrays.asList(
                IdTipoDatoDto
                    .builder()
                    .id(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId())
                    .build(),
                IdTipoDatoDto
                    .builder()
                    .id(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId())
                    .build()));

        when(tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())).thenReturn(
            Arrays.asList(
                IdTipoDatoDto
                    .builder()
                    .id(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                    .build(),
                IdTipoDatoDto
                    .builder()
                    .id(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                    .build(),
                IdTipoDatoDto
                    .builder()
                    .id(TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                    .build()));

        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(8001);
        when(algoritmo.getTipoCalculo()).thenReturn(
            Arrays.asList(
                TipoCalculoDto
                    .builder()
                    .id("011")
                    .build(),
                TipoCalculoDto
                    .builder()
                    .id("012")
                    .build()));
        when(algoritmo.getTipoComision()).thenReturn(
            Arrays.asList(
                TipoComisionDto
                    .builder()
                    .id("001")
                    .build(),
                TipoComisionDto
                    .builder()
                    .id("002")
                    .build(),
                TipoComisionDto
                    .builder()
                    .id("003")
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

        tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo, tarea, personas);

        //Parámetros de la consulta: idAlgoritmo, activo, idTipoDatoIndicadorPresencia, idTipoDatoDevolucionLocalizacionPersona,
        // idTipoDatoDevolucionLocalizacion, fechaInicioPeriodo, idTipoDatoImporteComisionDevolucion, cclIdPersonVendedor0,
        // idTipoPresencia, idTarea, cclIdPerson, stdOrHrPeriod, tiposCalculo, tiposComision, esDesplazamiento,
        // esDesplazamientoBase, comisionable, calcula, idTipoDatoIndicadorPresenciaDesplazamientoBase
        verify(namedParameterJdbcTemplate).batchUpdate(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_CALCULAR, sqlCaptor.getValue());
        MapSqlParameterSource[] values = paramsCaptor.getValue();
        //2 elementos, porque se envían dos personas
        assertEquals(2, values.length);
        for (MapSqlParameterSource value : values) {
            assertEquals(19, value.getValues().size());
            //activo
            assertTrue(value.hasValue(SQL_PARAM_ACTIVO));
            assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ACTIVO));
            //idTipoDatoIndicadorPresencia
            assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
            assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId(), value.getValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
            //tipoDatoLocalizacionPersonaPresencia
            assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
            assertEquals(
                Arrays.asList(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
                    TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(), TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()),
                value.getValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
            //idTipoDatoDevolucionLocalizacionPersona
            assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_IMPORTE_DEVOLUCION_LOCALIZACION_PERSONA));
            assertEquals(TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId(), value.getValue(SQL_PARAM_ID_TIPO_IMPORTE_DEVOLUCION_LOCALIZACION_PERSONA));
            //idTipoDatoDevolucionLocalizacion
            assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION));
            assertEquals(TipoDatoEnum.DEVOLUCION_LOCALIZACION_SECCION.getId(), value.getValue(SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION));
            //idTipoDatoImporteComisionDevolucion
            assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_DEVOLUCION));
            assertEquals(TipoDatoEnum.IMPORTE_COMISION_DEVOLUCIONES_LOCALIZACION_POR_VENTA.getId(), value.getValue(SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_DEVOLUCION));
            //cclIdPersonVendedor0
            assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_DATO_REPARTO_VENDEDOR_0));
            assertEquals(TipoDatoEnum.REPARTO_DEVOLUCION_VENDEDOR_0_LOCALIZACION_SECCION.getId(), value.getValue(SQL_PARAM_ID_TIPO_DATO_REPARTO_VENDEDOR_0));
            //idTipoPresencia
            assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION));
            assertEquals(
                Arrays.asList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId(), TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId()),
                value.getValue(SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION));
            //idAlgoritmo
            assertTrue(value.hasValue(SQL_PARAM_ID_ALGORITMO));
            assertEquals(algoritmo.getId(), value.getValue(SQL_PARAM_ID_ALGORITMO));
            //idTarea
            assertTrue(value.hasValue(SQL_PARAM_ID_TAREA));
            assertEquals(tarea.getId(), value.getValue(SQL_PARAM_ID_TAREA));
            //comisionable
            assertTrue(value.hasValue(SQL_PARAM_COMISIONABLE));
            assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_COMISIONABLE));
            //calcula
            assertTrue(value.hasValue(SQL_PARAM_CALCULA));
            assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_CALCULA));
            //tiposComision
            assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_COMISION));
            assertEquals(Arrays.asList("001", "002", "003"), value.getValue(SQL_PARAM_IDS_TIPOS_COMISION));
            //tiposCalculo
            assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
            assertEquals(Arrays.asList("011", "012"), value.getValue(SQL_PARAM_IDS_TIPOS_CALCULO));
            //esDesplazamiento
            assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO));
            assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO));
            //esDesplazamientoBase
            assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
            assertEquals(SQL_VALUE_BOOLEAN_FALSE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
            //idTipoDatoIndicadorPresenciaDesplazamiento
            assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE));
            assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId(), value.getValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE));
            // cclIdPerson, stdOrHrPeriod - existencia del parámetro
            assertTrue(value.hasValue(SQL_PARAM_CCL_ID_PERSON));
            assertTrue(value.hasValue(SQL_PARAM_STD_OR_HR_PERIOD));
        }

        // cclIdPerson, stdOrHrPeriod - valores del parámetro
        assertEquals(1,
            Arrays.stream(values)
                .filter(value ->
                    persona1.getCclIdPerson().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON))
                        && persona1.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))
                .toArray()
                .length);
        assertEquals(1,
            Arrays.stream(values)
                .filter(value ->
                    persona2.getCclIdPerson().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON))
                        && persona2.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))
                .toArray()
                .length);
    }

    @Test
    public void getSqlCalcularTest() {

        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(21);

        String result = tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
            .getSqlCalcular(algoritmo);
        assertEquals(SQL_BASE, result);

    }
}
