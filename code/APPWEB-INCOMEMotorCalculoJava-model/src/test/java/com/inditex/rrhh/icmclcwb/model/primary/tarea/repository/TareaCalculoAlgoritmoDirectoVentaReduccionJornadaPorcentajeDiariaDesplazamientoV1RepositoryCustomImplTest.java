package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImplTest {

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private TipoDatoService tipoDatoService;

  @Spy
  @InjectMocks
  private TareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl;

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void idsTest(final List<IdPersonaLocalDto> idPersonaLocalDtoList) {
    final var algoritmo = Instancio.create(AlgoritmoDTO.class);
    final var tarea = Instancio.create(TareaDto.class);
    doReturn(idPersonaLocalDtoList).when(this.tareaCalculoPersonaService).findByAlgoritmo(tarea, algoritmo);

    final List<IdPersonaLocalDto> result =
        this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl
            .ids(algoritmo, tarea);

    assertNotNull(result);
    assertFalse(result.isEmpty());
    for (final IdPersonaLocalDto item : result) {
      assertNotNull(item);
    }
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void getMapvaluesTest(final List<IdTipoDatoDto> idTipoDatoDtoList) {
    final var algoritmo = Instancio.create(AlgoritmoDTO.class);
    final var tarea = Instancio.create(TareaDto.class);
    final var persona = Instancio.create(IdPersonaLocalDto.class);
    doReturn(idTipoDatoDtoList).when(this.tipoDatoService)
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());

    final Map<String, Object> result =
        this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona);

    assertNotNull(result);
    assertFalse(result.isEmpty());
    for (final Object obj : result.values()) {
      assertNotNull(obj);
    }
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void getMapvaluesTest2(final List<IdTipoDatoDto> idTipoDatoDtoList) {
    final var algoritmo = Instancio.create(AlgoritmoDTO.class);
    final var tarea = Instancio.create(TareaDto.class);
    final var persona = Instancio.create(IdPersonaLocalDto.class);
    doReturn(idTipoDatoDtoList).when(this.tipoDatoService)
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());

    final AlgoritmoDTO alg = algoritmo;
    alg.setDesplazamiento(true);
    alg.setDesplazamientoBase(false);

    final Map<String, Object> result =
        this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl
            .getMapValues(alg, tarea, persona);

    assertNotNull(result);
    assertFalse(result.isEmpty());
    for (final Object obj : result.values()) {
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
