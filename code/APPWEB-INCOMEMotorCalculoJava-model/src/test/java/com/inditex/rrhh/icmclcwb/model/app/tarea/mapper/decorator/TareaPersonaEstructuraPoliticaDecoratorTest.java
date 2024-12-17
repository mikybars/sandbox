package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoUnidadTiempoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoPoliticaService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoUnidadTiempoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.ListaCondicionesPoliticasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.ListaValoresPoliticasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraPoliticaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;

import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TareaPersonaEstructuraPoliticaDecoratorTest {

  @Mock
  private TareaPersonaEstructuraPoliticaMapper delegate;

  @Mock
  private TipoPoliticaService tipoPoliticaService;

  @Mock
  private TipoUnidadTiempoService tipoUnidadTiempoService;

  @InjectMocks
  TareaPersonaEstructuraPoliticaDecorator tareaPersonaEstructuraPoliticaDecorator = this.getClassMock();

  private TareaPersonaEstructuraPoliticaDecorator getClassMock() {
    return Mockito.mock(TareaPersonaEstructuraPoliticaDecorator.class, Mockito.CALLS_REAL_METHODS);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPoliticaTest(
      final TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica,
      final TipoPoliticaDto politica) {
    final TareaPersonaEstructuraPoliticaDto tareaPersonaEstructuraPoliticaDto = Instancio.create(TareaPersonaEstructuraPoliticaDto.class);
    doReturn(tareaPersonaEstructuraPolitica).when(this.delegate)
        .tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(tareaPersonaEstructuraPoliticaDto);

    doReturn(politica).when(this.tipoPoliticaService).findByIdMeta4(tareaPersonaEstructuraPoliticaDto.getIdTipoPolitica());

    final TareaPersonaEstructuraPolitica result = this.tareaPersonaEstructuraPoliticaDecorator
        .tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(tareaPersonaEstructuraPoliticaDto);

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPoliticaTest2(
      final TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica,
      final TipoPoliticaDto politica) {
    final List<TareaPersonaEstructuraPoliticaDto> tareaPersonaEstructuraPoliticaDtoList =
        Instancio.createList(TareaPersonaEstructuraPoliticaDto.class);

    for (final TareaPersonaEstructuraPoliticaDto item : tareaPersonaEstructuraPoliticaDtoList) {
      doReturn(tareaPersonaEstructuraPolitica).when(this.delegate)
          .tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(item);

      doReturn(politica).when(this.tipoPoliticaService).findByIdMeta4(item.getIdTipoPolitica());
    }

    final List<TareaPersonaEstructuraPolitica> result = this.tareaPersonaEstructuraPoliticaDecorator
        .tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(tareaPersonaEstructuraPoliticaDtoList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDtoTest(
      final TareaPersonaEstructuraPoliticaDto tareaPersonaEstructuraPoliticaDto,
      final TipoPoliticaDto politica) {
    final TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica = Instancio.create(TareaPersonaEstructuraPolitica.class);

    doReturn(tareaPersonaEstructuraPoliticaDto).when(this.delegate)
        .tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(tareaPersonaEstructuraPolitica);

    doReturn(politica).when(this.tipoPoliticaService)
        .findById(tareaPersonaEstructuraPolitica.getTipoPolitica().getId());

    final TareaPersonaEstructuraPoliticaDto result = this.tareaPersonaEstructuraPoliticaDecorator
        .tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(tareaPersonaEstructuraPolitica);

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDtoTest2(
      final TareaPersonaEstructuraPoliticaDto tareaPersonaEstructuraPoliticaDto,
      final TipoPoliticaDto politica) {
    final List<TareaPersonaEstructuraPolitica> tareaPersonaEstructuraPoliticaList =
        Instancio.createList(TareaPersonaEstructuraPolitica.class);

    for (final TareaPersonaEstructuraPolitica item : tareaPersonaEstructuraPoliticaList) {
      doReturn(tareaPersonaEstructuraPoliticaDto).when(this.delegate)
          .tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(item);

      doReturn(politica).when(this.tipoPoliticaService)
          .findById(item.getTipoPolitica().getId());
    }

    final List<TareaPersonaEstructuraPoliticaDto> result = this.tareaPersonaEstructuraPoliticaDecorator
        .tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(tareaPersonaEstructuraPoliticaList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPoliticaTest(
      final TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica,
      final TipoPoliticaDto politica) {
    final ComisionEmpleadoResultItemDto comisionEmpleadoResultItemDto = Instancio.create(ComisionEmpleadoResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);

    doReturn(tareaPersonaEstructuraPolitica).when(this.delegate)
        .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(comisionEmpleadoResultItemDto, tarea);

    doReturn(politica).when(this.tipoPoliticaService)
        .findByIdMeta4(comisionEmpleadoResultItemDto.getIdTipoPolitica());

    final TareaPersonaEstructuraPolitica result = this.tareaPersonaEstructuraPoliticaDecorator
        .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(comisionEmpleadoResultItemDto, tarea);

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPoliticaTest2(
      final TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica,
      final TipoPoliticaDto politica) {
    final List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDtoList = Instancio.createList(ComisionEmpleadoResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);

    comisionEmpleadoResultItemDtoList.get(0).setIdTipoPolitica("002");
    comisionEmpleadoResultItemDtoList.get(0).setExcDenominador("1");
    comisionEmpleadoResultItemDtoList.get(1).setIdTipoPolitica("001");
    for (final ComisionEmpleadoResultItemDto item : comisionEmpleadoResultItemDtoList) {
      doReturn(tareaPersonaEstructuraPolitica).when(this.delegate)
          .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(item, tarea);

      doReturn(politica).when(this.tipoPoliticaService)
          .findByIdMeta4(item.getIdTipoPolitica());
    }

    final List<TareaPersonaEstructuraPolitica> result = this.tareaPersonaEstructuraPoliticaDecorator
        .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(comisionEmpleadoResultItemDtoList, tarea);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void estructurasPolResultItemDtoToTareaPersonaEstructuraPoliticaTest(
      final TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica,
      final TipoPoliticaDto politica, final TipoUnidadTiempoDto unidadTiempo) {
    final List<EstructurasPolResultItemDto> estructurasPolResultItemDtoList = Instancio.createList(EstructurasPolResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);

    for (final EstructurasPolResultItemDto item : estructurasPolResultItemDtoList) {
      item.getIcmListaCondicionesPolitica().get(0).setIdTipoPolitica("002");
      item.getIcmListaCondicionesPolitica().get(0).setExcDenominador("1");
      for (final ListaCondicionesPoliticasResultItemDto item2 : item.getIcmListaCondicionesPolitica()) {
        for (final ListaValoresPoliticasResultItemDto item3 : item2.getIcmListaValoresPoliticas()) {
          item3.setValor("1");
          item3.setTramo("1");

          doReturn(tareaPersonaEstructuraPolitica).when(this.delegate)
              .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(item, tarea);

          doReturn(politica).when(this.tipoPoliticaService)
              .findByIdMeta4(item2.getIdTipoPolitica());

          doReturn(unidadTiempo).when(this.tipoUnidadTiempoService)
              .findByIcmIdUnidadTiempo(item3.getIdUnidadTiempo());
        }
      }
    }

    final List<TareaPersonaEstructuraPolitica> result = this.tareaPersonaEstructuraPoliticaDecorator
        .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(estructurasPolResultItemDtoList, tarea);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void estructurasPolResultItemDtoToTareaPersonaEstructuraPoliticaTest2(
      final TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica,
      final TipoPoliticaDto politica, final TipoUnidadTiempoDto unidadTiempo) {
    final List<EstructurasPolResultItemDto> estructurasPolResultItemDtoList = Instancio.createList(EstructurasPolResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);
    for (final EstructurasPolResultItemDto item : estructurasPolResultItemDtoList) {
      item.getIcmListaCondicionesPolitica().get(0).setIdTipoPolitica("002");
      item.getIcmListaCondicionesPolitica().get(0).setExcDenominador("1");
      for (final ListaCondicionesPoliticasResultItemDto item2 : item.getIcmListaCondicionesPolitica()) {
        item2.setIdTipoPolitica("008");
        item2.setImporteMax("100");

        for (final ListaValoresPoliticasResultItemDto item3 : item2.getIcmListaValoresPoliticas()) {
          item3.setValor("1");
          item3.setTramo("1");

          doReturn(tareaPersonaEstructuraPolitica).when(this.delegate)
              .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(item, tarea);

          doReturn(politica).when(this.tipoPoliticaService)
              .findByIdMeta4(item2.getIdTipoPolitica());

          doReturn(unidadTiempo).when(this.tipoUnidadTiempoService)
              .findByIcmIdUnidadTiempo(item3.getIdUnidadTiempo());
        }
      }
    }

    final List<TareaPersonaEstructuraPolitica> result = this.tareaPersonaEstructuraPoliticaDecorator
        .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(estructurasPolResultItemDtoList, tarea);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void estructurasPolResultItemDtoToTareaPersonaEstructuraPoliticaTest3(
      final TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica,
      final TipoPoliticaDto politica, final TipoUnidadTiempoDto unidadTiempo) {
    final List<EstructurasPolResultItemDto> estructurasPolResultItemDtoList = Instancio.createList(EstructurasPolResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);
    for (final EstructurasPolResultItemDto item : estructurasPolResultItemDtoList) {
      item.getIcmListaCondicionesPolitica().get(0).setIdTipoPolitica("002");
      item.getIcmListaCondicionesPolitica().get(0).setExcDenominador("1");
      for (final ListaCondicionesPoliticasResultItemDto item2 : item.getIcmListaCondicionesPolitica()) {
        item2.setIdTipoPolitica("007");
        item2.setImporteMin("10");

        for (final ListaValoresPoliticasResultItemDto item3 : item2.getIcmListaValoresPoliticas()) {
          item3.setValor("1");
          item3.setTramo("1");

          doReturn(tareaPersonaEstructuraPolitica).when(this.delegate)
              .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(item, tarea);

          doReturn(politica).when(this.tipoPoliticaService)
              .findByIdMeta4(item2.getIdTipoPolitica());

          doReturn(unidadTiempo).when(this.tipoUnidadTiempoService)
              .findByIcmIdUnidadTiempo(item3.getIdUnidadTiempo());
        }
      }
    }

    final List<TareaPersonaEstructuraPolitica> result = this.tareaPersonaEstructuraPoliticaDecorator
        .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(estructurasPolResultItemDtoList, tarea);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

}
