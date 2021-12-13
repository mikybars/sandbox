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
class TareaCalculoAjusteVacacionesRepositoryCustomImplTest {

  private final static Long ID_TAREA = 8919L;

  private final static String ID_PERSONA = "AT1001";

  private final static String OR_PERSONA = "01";

  private final static String SQL_AJUSTAR_BASE = "SQL CALCULAR BASE";

  private final static String SQL_AJUSTAR = "SQL CALCULAR";

  public static final int ID_ALGORITMO = 11003;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPerosnaService;

  @InjectMocks
  private TareaCalculoAjusteVacacionesRepositoryCustomImpl tareaCalculoAjusteVacacionesRepositoryCustomImpl;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAjusteVacacionesRepositoryCustomImpl, "sqlAjustar", SQL_AJUSTAR, true);
    FieldUtils.writeField(this.tareaCalculoAjusteVacacionesRepositoryCustomImpl, "sqlAjustarBase", SQL_AJUSTAR_BASE,
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
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAjusteVacacionesRepositoryCustomImpl.ids(tarea);

    assertEquals(personas, ids);
  }

  @Test
  void getMapValuesNumParamsTareaPersonaNullTest() {
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();

    final Map<String, Object> result = this.tareaCalculoAjusteVacacionesRepositoryCustomImpl.getMapValues(
        algoritmoAjuste, null, null);
    assertEquals(2, result.size());
  }

  @Test
  void getMapValuesNumParamsTareaNotNullPersonaNullTest() {
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    final TareaDto tarea = this.createTarea();

    final Map<String, Object> result = this.tareaCalculoAjusteVacacionesRepositoryCustomImpl.getMapValues(
        algoritmoAjuste, tarea, null);
    assertEquals(3, result.size());
  }

  @Test
  void getMapValuesNumParamsTareaNullPersonaNotNullTest() {
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    final IdPersonaLocalDto persona1 = this.createPersonaLocal();

    final Map<String, Object> result = this.tareaCalculoAjusteVacacionesRepositoryCustomImpl.getMapValues(
        algoritmoAjuste, null, persona1);
    assertEquals(4, result.size());
  }

  @Test
  void getMapValuesNumParamsTareaPersonaNotNullTest() {
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    final TareaDto tarea = this.createTarea();
    final IdPersonaLocalDto persona1 = this.createPersonaLocal();

    final Map<String, Object> result = this.tareaCalculoAjusteVacacionesRepositoryCustomImpl.getMapValues(
        algoritmoAjuste, tarea, persona1);
    assertEquals(5, result.size());
  }

  @Test
  void getMapValuesParamIdTareaTest() {
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    final TareaDto tarea = this.createTarea();
    final IdPersonaLocalDto persona1 = this.createPersonaLocal();

    final Map<String, Object> result = this.tareaCalculoAjusteVacacionesRepositoryCustomImpl.getMapValues(
        algoritmoAjuste, tarea,
        persona1);
    // idTarea
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(ID_TAREA, result.get(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
  }

  @Test
  void getMapValuesParamPersonaTest() {
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    final TareaDto tarea = this.createTarea();
    final IdPersonaLocalDto persona1 = this.createPersonaLocal();

    final Map<String, Object> result = this.tareaCalculoAjusteVacacionesRepositoryCustomImpl.getMapValues(
        algoritmoAjuste, tarea,
        persona1);
    // cclIdPerson
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
    assertEquals(persona1.getIdPersonaLocal(), result.get(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
    // stdOrHrPeriod
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
    assertEquals(persona1.getStdOrHrPeriod(), result.get(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
  }

  @Test
  void getMapValuesParamIdAlgoritmoAjusteTest() {
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    final TareaDto tarea = this.createTarea();
    final IdPersonaLocalDto persona1 = this.createPersonaLocal();

    final Map<String, Object> result = this.tareaCalculoAjusteVacacionesRepositoryCustomImpl.getMapValues(
        algoritmoAjuste, tarea,
        persona1);
    // idAlgoritmoAjuste
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE));
    assertEquals(algoritmoAjuste.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE));
  }

  @Test
  void getMapValuesParamInactivoTest() {
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    final TareaDto tarea = this.createTarea();
    final IdPersonaLocalDto persona1 = this.createPersonaLocal();

    final Map<String, Object> result = this.tareaCalculoAjusteVacacionesRepositoryCustomImpl.getMapValues(
        algoritmoAjuste, tarea,
        persona1);
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
    final IdPersonaLocalDto persona1 = IdPersonaLocalDto
        .builder()
        .idPersonaLocal(ID_PERSONA)
        .stdOrHrPeriod(OR_PERSONA)
        .build();
    return persona1;
  }

}
