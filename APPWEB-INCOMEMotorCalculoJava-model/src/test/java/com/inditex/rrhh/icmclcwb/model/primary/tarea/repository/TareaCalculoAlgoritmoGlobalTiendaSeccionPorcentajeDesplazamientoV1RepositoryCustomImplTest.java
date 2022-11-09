package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

/*
 * Copyright (c) 2021. Inditex
 */
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoComisionDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class TareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustomImplTest {

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private TipoDatoService tipoDatoService;

  @Spy
  @InjectMocks
  TareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustomImpl tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustomImpl;

  @Random
  private AlgoritmoDTO algoritmo;

  @Random
  private TareaDto tarea;

  @Random
  private IdPersonaLocalDto persona;

  @Test
  void idsTest(@Random(type = IdPersonaLocalDto.class, size = 2) final List<IdPersonaLocalDto> idPersonaLocalDtoList) {

    doReturn(idPersonaLocalDtoList).when(this.tareaCalculoPersonaService).findByAlgoritmo(this.tarea, this.algoritmo);

    final List<IdPersonaLocalDto> result =
        this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustomImpl
            .ids(this.algoritmo, this.tarea);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
    for (final IdPersonaLocalDto item : result) {
      assertNotNull(item);
    }
  }

  @Test
  void getMapvaluesTest(@Random(type = IdTipoDatoDto.class, size = 2) final List<IdTipoDatoDto> tiposDatoVenta,
      @Random(type = IdTipoDatoDto.class, size = 2) final List<IdTipoDatoDto> tiposDatoPresencia,
      @Random(type = IdTipoDatoDto.class, size = 3) final List<IdTipoDatoDto> tiposDatoPersonaPresencia) {

    this.algoritmo.setDesplazamiento(true);
    this.algoritmo.setDesplazamientoBase(false);
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(tiposDatoVenta);
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()))
        .thenReturn(tiposDatoPresencia);

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustomImpl
        .getMapValues(this.algoritmo, this.tarea, this.persona);

    verify(this.tipoDatoService, times(1))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId());
    verify(this.tipoDatoService, times(1)).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SQL_PARAM_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION,
        tiposDatoVenta.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA,
        tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPO_HORA_DESPLAZAMIENTO.getId());
    expected.put(SQL_PARAM_ID_ALGORITMO, this.algoritmo.getId());
    expected.put(SQL_PARAM_FECHA_INICIO_PERIODO, TimeUtils.toDate(this.tarea.getFechaInicioPeriodo()));
    expected.put(SQL_PARAM_ID_TAREA, this.tarea.getId());
    expected.put(SQL_PARAM_EXCLUIDO_CALCULO, SQL_VALUE_BOOLEAN_FALSE);
    expected.put(SQL_PARAM_IDS_TIPOS_COMISION,
        this.algoritmo.getTipoComision().stream().map(TipoComisionDTO::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_IDS_TIPOS_CALCULO,
        this.algoritmo.getTipoCalculo().stream().map(TipoCalculoDTO::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_ES_DESPLAZAMIENTO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_ES_DESPLAZAMIENTO_BASE, SQL_VALUE_BOOLEAN_FALSE);
    expected.put(SQL_PARAM_CCL_ID_PERSON, this.persona.getIdPersonaLocal());
    expected.put(SQL_PARAM_STD_OR_HR_PERIOD, this.persona.getStdOrHrPeriod());

    assertNotNull(result);
    assertEquals(expected, result);
  }

  @Test
  void getSqlCalcularTest() {
    this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustomImpl
        .getSqlCalcular();

    verify(this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustomImpl,
        times(1)).getSqlCalcular();
  }

  @Test
  void getSqlCalcularBaseTest() {
    this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustomImpl
        .getSqlCalcularBase();

    verify(this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustomImpl,
        times(1)).getSqlCalcularBase();
  }

}
