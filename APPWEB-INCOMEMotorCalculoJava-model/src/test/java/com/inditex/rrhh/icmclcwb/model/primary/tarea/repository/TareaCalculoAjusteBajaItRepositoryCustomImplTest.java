package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.calcular.SistemaDestinoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoAusenciaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoUnidadTiempoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoResponseDto;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class TareaCalculoAjusteBajaItRepositoryCustomImplTest {

    private final static Long ID_TAREA = 8919L;

    private final static String ID_PERSONA = "AT1001";

    private final static String OR_PERSONA = "01";

    private final static String SQL_AJUSTAR_BASE = "SQL CALCULAR BASE";

    private final static String SQL_AJUSTAR = "SQL CALCULAR";

    public static final int ID_ALGORITMO = 11003;

    @Mock
    private TareaCalculoPersonaService tareaCalculoPerosnaService;

    @Mock
    private TareaAmbitoService tareaAmbitoService;

    @Mock
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource[]> params;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @InjectMocks
    private TareaCalculoAjusteBajaItRepositoryCustomImpl tareaCalculoAjusteBajaItRepositoryCustomImpl;

    @BeforeEach
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.tareaCalculoAjusteBajaItRepositoryCustomImpl, "sqlAjustar", SQL_AJUSTAR, true);
        FieldUtils.writeField(this.tareaCalculoAjusteBajaItRepositoryCustomImpl, "sqlAjustarBase", SQL_AJUSTAR_BASE,
                true);
    }

    @Test
    void idsTest() {
        final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
        final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);
        when(this.tareaCalculoPerosnaService.findByTareaAndIdEstadoAndIdTipoPolitica(any(TareaDto.class),
                any(String.class)))
                    .thenReturn(personas);
        final TareaDto tarea = mock(TareaDto.class);
        final List<IdPersonaLocalDto> ids = this.tareaCalculoAjusteBajaItRepositoryCustomImpl.ids(tarea);

        assertEquals(personas, ids);
    }

    @Test
    void getMapValuesTest() {
        final AlgoritmoAjusteDto algoritmoAjuste = mock(AlgoritmoAjusteDto.class);
        when(algoritmoAjuste.getId()).thenReturn(11003);
        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(101L);
        final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
        when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
        when(persona1.getStdOrHrPeriod()).thenReturn("01");

        when(this.tareaAmbitoService.findByTarea(tarea)).thenReturn(
                Collections.singletonList(TareaAmbitoDto.builder().cclIdOrigen("2").build()));
        final SistemaDestinoResponseDto sistemaDestino = SistemaDestinoResponseDto.builder()
            .idSistemaDestino("01")
            .build();
        when(this.meta4IcmWsCalcIncomeService.getSistemaDestino(any(SistemaDestinoRequestDto.class))).thenReturn(
                sistemaDestino);

        final Map<String, Object> result = this.tareaCalculoAjusteBajaItRepositoryCustomImpl.getMapValues(
                algoritmoAjuste, tarea,
                persona1);
        assertEquals(14, result.size());

        // idTarea
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // cclIdPerson
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
        assertEquals(persona1.getIdPersonaLocal(), result.get(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
        // stdOrHrPeriod
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
        assertEquals(persona1.getStdOrHrPeriod(), result.get(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
        // idAlgoritmo
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE));
        assertEquals(algoritmoAjuste.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE));
        // idTipoPolitica
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.BAJA_IT.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        // idTipoAusencia
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA));
        assertEquals(TipoAusenciaEnum.BAJA_IT.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA));
        // inactivo
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, result.get(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        // idTipoPoliticaAjuste
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
        assertEquals(Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD.getIdMeta4()),
                result.get(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
        // idTipoUnidadtiempoAnos
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
        assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
                result.get(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
        // idTipoUnidadtiempoMeses
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
        assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
                result.get(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
        // idTipoUnidadtiempoSemanas
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
        assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
                result.get(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
        // idTipoUnidadtiempoDias
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
        assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
                result.get(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
        // idSistemaDestino
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO));
        assertEquals(sistemaDestino.getIdSistemaDestino(),
                result.get(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO));
        // idSistemaDestinoSolucionGlobal
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO_SOLUCION_GLOBAL));
        assertEquals(SistemaDestinoEnum.SOLUCION_GLOBAL.getIdMeta4(),
                result.get(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO_SOLUCION_GLOBAL));

    }

}
