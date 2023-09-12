package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaCalculoAjusteCarenciaRepositoryCustomImplTest {

  private final static Long ID_TAREA = 8919L;

  private final static String ID_PERSONA = "AT1001";

  private final static String OR_PERSONA = "01";

  private final static String SQL_AJUSTAR_BASE = "SQL CALCULAR BASE";

  private final static String SQL_AJUSTAR = "SQL CALCULAR";

  public static final int ID_ALGORITMO = 11003;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPerosnaService;

  @InjectMocks
  private TareaCalculoAjusteCarenciaRepositoryCustomImpl tareaCalculoAjusteCarenciaRepositoryCustomImpl;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAjusteCarenciaRepositoryCustomImpl, "sqlAjustar", SQL_AJUSTAR, true);
    FieldUtils.writeField(this.tareaCalculoAjusteCarenciaRepositoryCustomImpl, "sqlAjustarBase", SQL_AJUSTAR_BASE,
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
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAjusteCarenciaRepositoryCustomImpl.ids(tarea);

    assertEquals(personas, ids);
  }

  @Test
  void getMapValuesNumParamsTareaPersonaNullTest() {
    final Map<String, Object> result = this.tareaCalculoAjusteCarenciaRepositoryCustomImpl.getMapValues(
        this.createAlgoritmoAjuste(), null, null);
    assertEquals(2, result.size());
  }

  @Test
  void getMapValuesNumParamsTareaNotNullPersonaNullTest() {
    final Map<String, Object> result = this.tareaCalculoAjusteCarenciaRepositoryCustomImpl.getMapValues(
        this.createAlgoritmoAjuste(), this.createTarea(), null);
    assertEquals(3, result.size());
  }

  @Test
  void getMapValuesNumParamsTareaNullPersonaNotNullTest() {
    final Map<String, Object> result = this.tareaCalculoAjusteCarenciaRepositoryCustomImpl.getMapValues(
        this.createAlgoritmoAjuste(), null, this.createPersonaLocal());
    assertEquals(4, result.size());
  }

  @Test
  void getMapValuesNumParamsTareaPersonaNotNullTest() {
    final Map<String, Object> result = this.tareaCalculoAjusteCarenciaRepositoryCustomImpl.getMapValues(
        this.createAlgoritmoAjuste(), this.createTarea(), this.createPersonaLocal());
    assertEquals(5, result.size());
  }

  @Test
  void getMapValuesParamIdTareaTest() {
    final Map<String, Object> result = this.tareaCalculoAjusteCarenciaRepositoryCustomImpl.getMapValues(
        this.createAlgoritmoAjuste(), this.createTarea(), this.createPersonaLocal());
    // idTarea
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(ID_TAREA, result.get(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
  }

  @Test
  void getMapValuesParamPersonaTest() {
    final Map<String, Object> result = this.tareaCalculoAjusteCarenciaRepositoryCustomImpl.getMapValues(
        this.createAlgoritmoAjuste(), this.createTarea(), this.createPersonaLocal());
    // cclIdPerson
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
    assertEquals(ID_PERSONA, result.get(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
    // stdOrHrPeriod
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
    assertEquals(OR_PERSONA, result.get(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
  }

  @Test
  void getMapValuesParamIdAlgoritmoAjusteTest() {
    final Map<String, Object> result = this.tareaCalculoAjusteCarenciaRepositoryCustomImpl.getMapValues(
        this.createAlgoritmoAjuste(), this.createTarea(), this.createPersonaLocal());
    // idAlgoritmoAjuste
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE));
    assertEquals(ID_ALGORITMO, result.get(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE));
  }

  @Test
  void getMapValuesParamInactivoTest() {
    final Map<String, Object> result = this.tareaCalculoAjusteCarenciaRepositoryCustomImpl.getMapValues(
        this.createAlgoritmoAjuste(), this.createTarea(), this.createPersonaLocal());
    // inactivo
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, result.get(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
  }

  private AlgoritmoAjusteDto createAlgoritmoAjuste() {
    final AlgoritmoAjusteDto algoritmoAjuste = new AlgoritmoAjusteDto();
    algoritmoAjuste.setId(ID_ALGORITMO);
    return algoritmoAjuste;
  }

  private TareaDto createTarea() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    return tarea;
  }

  private IdPersonaLocalDto createPersonaLocal() {
    return IdPersonaLocalDto
        .builder()
        .idPersonaLocal(ID_PERSONA)
        .stdOrHrPeriod(OR_PERSONA)
        .build();
  }

}
