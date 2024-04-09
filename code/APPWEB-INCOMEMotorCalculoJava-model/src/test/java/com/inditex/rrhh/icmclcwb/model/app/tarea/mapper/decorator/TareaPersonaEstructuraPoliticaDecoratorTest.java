package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class TareaPersonaEstructuraPoliticaDecoratorTest {

  @Mock
  private TareaPersonaEstructuraPoliticaMapper delegate;

  @Mock
  private TipoPoliticaService tipoPoliticaService;

  @Mock
  private TipoUnidadTiempoService tipoUnidadTiempoService;

  @InjectMocks
  TareaPersonaEstructuraPoliticaDecorator tareaPersonaEstructuraPoliticaDecorator = getClassMock();

  @Random
  TareaPersonaEstructuraPoliticaDto tareaPersonaEstructuraPoliticaDto;

  @Random(type = TareaPersonaEstructuraPoliticaDto.class, size = 2)
  List<TareaPersonaEstructuraPoliticaDto> tareaPersonaEstructuraPoliticaDtoList;

  @Random
  TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica;

  @Random(type = TareaPersonaEstructuraPolitica.class, size = 2)
  List<TareaPersonaEstructuraPolitica> tareaPersonaEstructuraPoliticaList;

  @Random
  ComisionEmpleadoResultItemDto comisionEmpleadoResultItemDto;

  @Random
  TareaDto tarea;

  @Random(type = ComisionEmpleadoResultItemDto.class, size = 2)
  List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDtoList;

  @Random(type = EstructurasPolResultItemDto.class, size = 2)
  List<EstructurasPolResultItemDto> estructurasPolResultItemDtoList;

  private TareaPersonaEstructuraPoliticaDecorator getClassMock() {
    return Mockito.mock(TareaPersonaEstructuraPoliticaDecorator.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPoliticaTest(
      @Random TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica,
      @Random TipoPoliticaDto politica) {

    doReturn(tareaPersonaEstructuraPolitica).when(this.delegate)
        .tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(this.tareaPersonaEstructuraPoliticaDto);

    doReturn(politica).when(this.tipoPoliticaService).findByIdMeta4(this.tareaPersonaEstructuraPoliticaDto.getIdTipoPolitica());

    TareaPersonaEstructuraPolitica result = this.tareaPersonaEstructuraPoliticaDecorator
        .tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(this.tareaPersonaEstructuraPoliticaDto);

    assertNotNull(result);
  }

  @Test
  void tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPoliticaTest2(
      @Random TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica,
      @Random TipoPoliticaDto politica) {

    for (TareaPersonaEstructuraPoliticaDto item : this.tareaPersonaEstructuraPoliticaDtoList) {
      doReturn(tareaPersonaEstructuraPolitica).when(this.delegate)
          .tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(item);

      doReturn(politica).when(this.tipoPoliticaService).findByIdMeta4(item.getIdTipoPolitica());
    }

    List<TareaPersonaEstructuraPolitica> result = this.tareaPersonaEstructuraPoliticaDecorator
        .tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(this.tareaPersonaEstructuraPoliticaDtoList);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
  }

  @Test
  void tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDtoTest(
      @Random TareaPersonaEstructuraPoliticaDto tareaPersonaEstructuraPoliticaDto,
      @Random TipoPoliticaDto politica) {

    doReturn(tareaPersonaEstructuraPoliticaDto).when(this.delegate)
        .tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(this.tareaPersonaEstructuraPolitica);

    doReturn(politica).when(this.tipoPoliticaService)
        .findById(this.tareaPersonaEstructuraPolitica.getTipoPolitica().getId());

    TareaPersonaEstructuraPoliticaDto result = this.tareaPersonaEstructuraPoliticaDecorator
        .tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(this.tareaPersonaEstructuraPolitica);

    assertNotNull(result);
  }

  @Test
  void tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDtoTest2(
      @Random TareaPersonaEstructuraPoliticaDto tareaPersonaEstructuraPoliticaDto,
      @Random TipoPoliticaDto politica) {

    for (TareaPersonaEstructuraPolitica item : this.tareaPersonaEstructuraPoliticaList) {
      doReturn(tareaPersonaEstructuraPoliticaDto).when(this.delegate)
          .tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(item);

      doReturn(politica).when(this.tipoPoliticaService)
          .findById(item.getTipoPolitica().getId());
    }

    List<TareaPersonaEstructuraPoliticaDto> result = this.tareaPersonaEstructuraPoliticaDecorator
        .tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(this.tareaPersonaEstructuraPoliticaList);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
  }

  @Test
  void comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPoliticaTest(
      @Random TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica,
      @Random TipoPoliticaDto politica) {

    doReturn(tareaPersonaEstructuraPolitica).when(this.delegate)
        .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(this.comisionEmpleadoResultItemDto, this.tarea);

    doReturn(politica).when(this.tipoPoliticaService)
        .findByIdMeta4(this.comisionEmpleadoResultItemDto.getIdTipoPolitica());

    TareaPersonaEstructuraPolitica result = this.tareaPersonaEstructuraPoliticaDecorator
        .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(this.comisionEmpleadoResultItemDto, this.tarea);

    assertNotNull(result);
  }

  @Test
  void comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPoliticaTest2(
      @Random TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica,
      @Random TipoPoliticaDto politica) {

    this.comisionEmpleadoResultItemDtoList.get(0).setIdTipoPolitica("002");
    this.comisionEmpleadoResultItemDtoList.get(0).setExcDenominador("1");
    this.comisionEmpleadoResultItemDtoList.get(1).setIdTipoPolitica("001");
    for (ComisionEmpleadoResultItemDto item : this.comisionEmpleadoResultItemDtoList) {
      doReturn(tareaPersonaEstructuraPolitica).when(this.delegate)
          .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(item, this.tarea);

      doReturn(politica).when(this.tipoPoliticaService)
          .findByIdMeta4(item.getIdTipoPolitica());
    }

    List<TareaPersonaEstructuraPolitica> result = this.tareaPersonaEstructuraPoliticaDecorator
        .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(this.comisionEmpleadoResultItemDtoList, this.tarea);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
  }

  @Test
  void estructurasPolResultItemDtoToTareaPersonaEstructuraPoliticaTest(
      @Random TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica,
      @Random TipoPoliticaDto politica, @Random TipoUnidadTiempoDto unidadTiempo) {

    for (EstructurasPolResultItemDto item : this.estructurasPolResultItemDtoList) {
      item.getIcmListaCondicionesPolitica().get(0).setIdTipoPolitica("002");
      item.getIcmListaCondicionesPolitica().get(0).setExcDenominador("1");
      for (ListaCondicionesPoliticasResultItemDto item2 : item.getIcmListaCondicionesPolitica()) {
        for (ListaValoresPoliticasResultItemDto item3 : item2.getIcmListaValoresPoliticas()) {
          item3.setValor("1");
          item3.setTramo("1");

          doReturn(tareaPersonaEstructuraPolitica).when(this.delegate)
              .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(item, this.tarea);

          doReturn(politica).when(this.tipoPoliticaService)
              .findByIdMeta4(item2.getIdTipoPolitica());

          doReturn(unidadTiempo).when(this.tipoUnidadTiempoService)
              .findByIcmIdUnidadTiempo(item3.getIdUnidadTiempo());
        }
      }
    }

    List<TareaPersonaEstructuraPolitica> result = this.tareaPersonaEstructuraPoliticaDecorator
        .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(this.estructurasPolResultItemDtoList, this.tarea);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
  }

  @Test
  void estructurasPolResultItemDtoToTareaPersonaEstructuraPoliticaTest2(
      @Random TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica,
      @Random TipoPoliticaDto politica, @Random TipoUnidadTiempoDto unidadTiempo) {

    for (EstructurasPolResultItemDto item : this.estructurasPolResultItemDtoList) {
      item.getIcmListaCondicionesPolitica().get(0).setIdTipoPolitica("002");
      item.getIcmListaCondicionesPolitica().get(0).setExcDenominador("1");
      for (ListaCondicionesPoliticasResultItemDto item2 : item.getIcmListaCondicionesPolitica()) {
        item2.setIdTipoPolitica("008");
        item2.setImporteMax("100");

        for (ListaValoresPoliticasResultItemDto item3 : item2.getIcmListaValoresPoliticas()) {
          item3.setValor("1");
          item3.setTramo("1");

          doReturn(tareaPersonaEstructuraPolitica).when(this.delegate)
              .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(item, this.tarea);

          doReturn(politica).when(this.tipoPoliticaService)
              .findByIdMeta4(item2.getIdTipoPolitica());

          doReturn(unidadTiempo).when(this.tipoUnidadTiempoService)
              .findByIcmIdUnidadTiempo(item3.getIdUnidadTiempo());
        }
      }
    }

    List<TareaPersonaEstructuraPolitica> result = this.tareaPersonaEstructuraPoliticaDecorator
        .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(this.estructurasPolResultItemDtoList, this.tarea);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
  }

  @Test
  void estructurasPolResultItemDtoToTareaPersonaEstructuraPoliticaTest3(
      @Random TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica,
      @Random TipoPoliticaDto politica, @Random TipoUnidadTiempoDto unidadTiempo) {

    for (EstructurasPolResultItemDto item : this.estructurasPolResultItemDtoList) {
      item.getIcmListaCondicionesPolitica().get(0).setIdTipoPolitica("002");
      item.getIcmListaCondicionesPolitica().get(0).setExcDenominador("1");
      for (ListaCondicionesPoliticasResultItemDto item2 : item.getIcmListaCondicionesPolitica()) {
        item2.setIdTipoPolitica("007");
        item2.setImporteMin("10");

        for (ListaValoresPoliticasResultItemDto item3 : item2.getIcmListaValoresPoliticas()) {
          item3.setValor("1");
          item3.setTramo("1");

          doReturn(tareaPersonaEstructuraPolitica).when(this.delegate)
              .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(item, this.tarea);

          doReturn(politica).when(this.tipoPoliticaService)
              .findByIdMeta4(item2.getIdTipoPolitica());

          doReturn(unidadTiempo).when(this.tipoUnidadTiempoService)
              .findByIcmIdUnidadTiempo(item3.getIdUnidadTiempo());
        }
      }
    }

    List<TareaPersonaEstructuraPolitica> result = this.tareaPersonaEstructuraPoliticaDecorator
        .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(this.estructurasPolResultItemDtoList, this.tarea);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
  }

}
