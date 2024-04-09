package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Map;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class TareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImplTest {

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private TipoDatoService tipoDatoService;

  @Spy
  @InjectMocks
  private TareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl;

  @Random
  private AlgoritmoDTO algoritmo;

  @Random
  private TareaDto tarea;

  @Random
  private IdPersonaLocalDto persona;

  @Test
  void idsTest(@Random(type = IdPersonaLocalDto.class, size = 2) List<IdPersonaLocalDto> idPersonaLocalDtoList) {

    doReturn(idPersonaLocalDtoList).when(this.tareaCalculoPersonaService).findByAlgoritmo(this.tarea, this.algoritmo);

    final List<IdPersonaLocalDto> result =
        this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl
            .ids(this.algoritmo, this.tarea);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
    for (IdPersonaLocalDto item : result) {
      assertNotNull(item);
    }
  }

  @Test
  void getMapvaluesTest(@Random(type = IdTipoDatoDto.class, size = 2) List<IdTipoDatoDto> idTipoDatoDtoList) {

    doReturn(idTipoDatoDtoList).when(this.tipoDatoService)
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());

    final Map<String, Object> result =
        this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl
            .getMapValues(this.algoritmo, this.tarea, this.persona);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
    for (Object obj : result.values()) {
      assertNotNull(obj);
    }
  }

  @Test
  void getMapvaluesTest2(@Random(type = IdTipoDatoDto.class, size = 2) List<IdTipoDatoDto> idTipoDatoDtoList) {

    doReturn(idTipoDatoDtoList).when(this.tipoDatoService)
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());

    AlgoritmoDTO alg = this.algoritmo;
    alg.setDesplazamiento(true);
    alg.setDesplazamientoBase(false);

    final Map<String, Object> result =
        this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl
            .getMapValues(alg, this.tarea, this.persona);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
    for (Object obj : result.values()) {
      assertNotNull(obj);
    }
  }

  @Test
  void getSqlCalcularTest() {
    this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl
        .getSqlCalcular();

    verify(this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl,
        times(1)).getSqlCalcular();
  }

  @Test
  void getSqlCalcularBaseTest() {
    this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl
        .getSqlCalcularBase();

    verify(this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl,
        times(1)).getSqlCalcularBase();
  }

}
