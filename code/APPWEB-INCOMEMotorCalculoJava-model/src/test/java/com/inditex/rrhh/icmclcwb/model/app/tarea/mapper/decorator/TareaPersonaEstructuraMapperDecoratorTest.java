package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoOpcionCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoOpcionCalculoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoOpcionCalculoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaCondicionesBaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaCondicionesDestinoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaValoresBaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaValoresDestinoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class TareaPersonaEstructuraMapperDecoratorTest {

  @Mock
  private TareaPersonaEstructuraMapper delegate;

  @Mock
  private TipoOpcionCalculoService tipoOpcionCalculoService;

  @InjectMocks
  private final TareaPersonaEstructuraMapperDecorator tareaPersonaEstructuraMapperDecorator = this.getClassMock();

  private TareaPersonaEstructuraMapperDecorator getClassMock() {
    return Mockito.mock(TareaPersonaEstructuraMapperDecorator.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoEmptyListTest(@Random final TareaDto tarea) {

    final List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(new ArrayList<>(), tarea);
    assertNotNull(result);
    assertTrue(result.isEmpty());

  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoSinCondicionesBaseTest(
      @Random final EstructurasComResultItemDto itemPadre, @Random final TareaDto tarea) {

    itemPadre.setIcmListaCondicionesBase(new ArrayList<>());
    final List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);
    assertNotNull(result);
    assertTrue(result.isEmpty());

  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoSinTipoCalculoTest(
      @Random final EstructurasComResultItemDto itemPadre,
      @Random final ListaCondicionesBaseResultItemDto itemBase, @Random final TareaDto tarea,
      @Random final TareaPersonaEstructuraDto estructura) {

    when(this.delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
        any(EstructurasComResultItemDto.class),
        any(ListaCondicionesBaseResultItemDto.class), any(TareaDto.class))).thenReturn(estructura);
    itemBase.setIdTipoCalculo("");
    itemBase.setIcmListaValoresBase(new ArrayList<>());
    itemPadre.setIcmListaCondicionesBase(Collections.singletonList(itemBase));
    itemPadre.setIcmListaCondicionesDestino(new ArrayList<>());
    final List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(itemPadre, itemBase, tarea);
    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(estructura, result.get(0));
    assertEquals(TipoCalculoEnum.NINGUNO.getId(), itemBase.getIdTipoCalculo());

  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoSeccion4NoChallengeTest(
      @Random final EstructurasComResultItemDto itemPadre,
      @Random final ListaCondicionesBaseResultItemDto itemBase, @Random final TareaDto tarea,
      @Random final ListaValoresBaseResultItemDto valorBase,
      @Random final TareaPersonaEstructuraDto estructura) {

    when(this.delegate
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaValoresBaseResultItemDtoAndIdSerccionAndTareaToTareaPersonaEstructuraDto(
            any(EstructurasComResultItemDto.class),
            any(ListaCondicionesBaseResultItemDto.class), any(ListaValoresBaseResultItemDto.class), any(Integer.class),
            any(TareaDto.class))).thenReturn(estructura);
    valorBase.setIdSeccion(AppConstants.SECCION_4.toString());
    itemBase.setIdTipoCalculo(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId());
    itemBase.setIcmListaValoresBase(Collections.singletonList(valorBase));
    itemPadre.setIcmListaCondicionesBase(Collections.singletonList(itemBase));
    itemPadre.setIcmListaCondicionesDestino(new ArrayList<>());
    final List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);
    for (final Integer idSeccion : AppConstants.getSECCIONES()) {
      verify(this.delegate, times(1))
          .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaValoresBaseResultItemDtoAndIdSerccionAndTareaToTareaPersonaEstructuraDto(
              itemPadre, itemBase, valorBase, idSeccion, tarea);
    }
    assertNotNull(result);
    assertEquals(3, result.size());

  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoSeccion4ChallengePrecioHoraTiendaTest(
      @Random final EstructurasComResultItemDto itemPadre,
      @Random final ListaCondicionesBaseResultItemDto itemBase, @Random final TareaDto tarea,
      @Random final ListaValoresBaseResultItemDto valorBase,
      @Random final TareaPersonaEstructuraDto estructura) {

    when(this.delegate
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaValoresBaseResultItemDtoAndIdSerccionAndTareaToTareaPersonaEstructuraDto(
            any(EstructurasComResultItemDto.class),
            any(ListaCondicionesBaseResultItemDto.class), any(ListaValoresBaseResultItemDto.class), any(Integer.class),
            any(TareaDto.class))).thenReturn(estructura);
    valorBase.setIdSeccion(AppConstants.SECCION_4.toString());
    itemBase.setIdTipoCalculo(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId());
    itemBase.setIcmListaValoresBase(Collections.singletonList(valorBase));
    itemPadre.setIcmListaCondicionesBase(Collections.singletonList(itemBase));
    itemPadre.setIcmListaCondicionesDestino(new ArrayList<>());

    final List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaValoresBaseResultItemDtoAndIdSerccionAndTareaToTareaPersonaEstructuraDto(
            itemPadre, itemBase, valorBase, AppConstants.SECCION_4, tarea);
    assertNotNull(result);
    assertEquals(1, result.size());

  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoSeccion4ChallengeImporteTiendaTest(
      @Random final EstructurasComResultItemDto itemPadre,
      @Random final ListaCondicionesBaseResultItemDto itemBase, @Random final TareaDto tarea,
      @Random final ListaValoresBaseResultItemDto valorBase,
      @Random final TareaPersonaEstructuraDto estructura) {

    when(this.delegate
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaValoresBaseResultItemDtoAndIdSerccionAndTareaToTareaPersonaEstructuraDto(
            any(EstructurasComResultItemDto.class),
            any(ListaCondicionesBaseResultItemDto.class), any(ListaValoresBaseResultItemDto.class), any(Integer.class),
            any(TareaDto.class))).thenReturn(estructura);
    valorBase.setIdSeccion(AppConstants.SECCION_4.toString());
    itemBase.setIdTipoCalculo(TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId());
    itemBase.setIcmListaValoresBase(Collections.singletonList(valorBase));
    itemPadre.setIcmListaCondicionesBase(Collections.singletonList(itemBase));
    itemPadre.setIcmListaCondicionesDestino(new ArrayList<>());
    final List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaValoresBaseResultItemDtoAndIdSerccionAndTareaToTareaPersonaEstructuraDto(
            itemPadre, itemBase, valorBase, AppConstants.SECCION_4, tarea);
    assertNotNull(result);
    assertEquals(1, result.size());

  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoDesplazamientoSinValoresDestinoTest(
      @Random final EstructurasComResultItemDto itemPadre,
      @Random final ListaCondicionesBaseResultItemDto itemBase, @Random final ListaCondicionesDestinoResultItemDto itemDestino,
      @Random final TareaDto tarea) {

    final TipoOpcionCalculoDto opcionCalculo = new TipoOpcionCalculoDto();
    opcionCalculo.setId(TipoOpcionCalculoEnum.DESTINO.getId());
    when(this.tipoOpcionCalculoService.findByIdMeta4(any(String.class))).thenReturn(opcionCalculo);

    when(this.delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
        any(EstructurasComResultItemDto.class),
        any(ListaCondicionesBaseResultItemDto.class), any(TareaDto.class))).thenReturn(new TareaPersonaEstructuraDto());
    itemBase.setIdTipoCalculo(TipoCalculoEnum.GLOBAL_SECCION.getId());
    itemBase.setIcmListaValoresBase(new ArrayList<>());
    itemPadre.setIcmListaCondicionesBase(Collections.singletonList(itemBase));
    itemPadre.setIcmListaCondicionesDestino(Collections.singletonList(itemDestino));
    itemDestino.setIcmListaValoresDestino(new ArrayList<>());
    itemDestino.setHorasOrigen(Meta4Constants.FALSE);
    itemDestino.setHorasDestino(Meta4Constants.TRUE);
    itemDestino.setTotalCondiciones(Meta4Constants.TRUE);

    List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, tarea, 1, opcionCalculo.getId(), opcionCalculo.getId(), Boolean.FALSE, Boolean.TRUE,
            Boolean.TRUE);
    assertNotNull(result);
    // estructura base y estructura desplazamiento
    assertEquals(2, result.size());

    itemDestino.setHorasOrigen(Meta4Constants.TRUE);
    itemDestino.setHorasDestino(Meta4Constants.FALSE);
    itemDestino.setTotalCondiciones(Meta4Constants.FALSE);
    result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, tarea, 1, opcionCalculo.getId(), opcionCalculo.getId(), Boolean.TRUE, Boolean.FALSE,
            Boolean.FALSE);
    assertNotNull(result);
    // estructura base y estructura desplazamiento
    assertEquals(2, result.size());

  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoDesplazamientoSinValoresDestinoMejorOpcionTest(
      @Random final EstructurasComResultItemDto itemPadre,
      @Random final ListaCondicionesBaseResultItemDto itemBase, @Random final ListaCondicionesDestinoResultItemDto itemDestino,
      @Random final TareaDto tarea) {

    final TipoOpcionCalculoDto opcionCalculo = new TipoOpcionCalculoDto();
    opcionCalculo.setId(TipoOpcionCalculoEnum.MEJOR_OPCION.getId());
    when(this.tipoOpcionCalculoService.findByIdMeta4(any(String.class))).thenReturn(opcionCalculo);

    when(this.delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
        any(EstructurasComResultItemDto.class),
        any(ListaCondicionesBaseResultItemDto.class), any(TareaDto.class))).thenReturn(new TareaPersonaEstructuraDto());
    itemBase.setIdTipoCalculo(TipoCalculoEnum.GLOBAL_SECCION.getId());
    itemBase.setIcmListaValoresBase(new ArrayList<>());
    itemPadre.setIcmListaCondicionesBase(Collections.singletonList(itemBase));
    itemPadre.setIcmListaCondicionesDestino(Collections.singletonList(itemDestino));
    itemDestino.setIcmListaValoresDestino(new ArrayList<>());
    itemDestino.setHorasOrigen(Meta4Constants.FALSE);
    itemDestino.setHorasDestino(Meta4Constants.TRUE);
    itemDestino.setTotalCondiciones(Meta4Constants.TRUE);

    List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(), opcionCalculo.getId(), Boolean.FALSE,
            Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, tarea, 2, TipoOpcionCalculoEnum.DESTINO.getId(), opcionCalculo.getId(), Boolean.FALSE,
            Boolean.TRUE, Boolean.TRUE);
    assertNotNull(result);
    // estructura base y 2 estructuras desplazamiento
    assertEquals(3, result.size());

    itemDestino.setHorasOrigen(Meta4Constants.TRUE);
    itemDestino.setHorasDestino(Meta4Constants.FALSE);
    itemDestino.setTotalCondiciones(Meta4Constants.FALSE);
    result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(), opcionCalculo.getId(), Boolean.TRUE,
            Boolean.FALSE, Boolean.FALSE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, tarea, 2, TipoOpcionCalculoEnum.DESTINO.getId(), opcionCalculo.getId(), Boolean.TRUE,
            Boolean.FALSE, Boolean.FALSE);
    assertNotNull(result);
    // estructura base y 2 estructuras desplazamiento
    assertEquals(3, result.size());

  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoDesplazamientoSeccion4NoChallengeTest(
      @Random final EstructurasComResultItemDto itemPadre,
      @Random final ListaCondicionesBaseResultItemDto itemBase, @Random final ListaCondicionesDestinoResultItemDto itemDestino,
      @Random final ListaValoresDestinoResultItemDto valorDestino, @Random final TareaDto tarea) {

    final TipoOpcionCalculoDto opcionCalculo = new TipoOpcionCalculoDto();
    opcionCalculo.setId(TipoOpcionCalculoEnum.ORIGEN.getId());
    when(this.tipoOpcionCalculoService.findByIdMeta4(any(String.class))).thenReturn(opcionCalculo);

    when(this.delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
        any(EstructurasComResultItemDto.class),
        any(ListaCondicionesBaseResultItemDto.class), any(TareaDto.class))).thenReturn(new TareaPersonaEstructuraDto());
    itemBase.setIdTipoCalculo(TipoCalculoEnum.GLOBAL_SECCION.getId());
    itemBase.setIcmListaValoresBase(new ArrayList<>());
    itemPadre.setIcmListaCondicionesBase(Collections.singletonList(itemBase));
    itemPadre.setIcmListaCondicionesDestino(Collections.singletonList(itemDestino));
    itemDestino.setIdTipoOpCalculo(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId());
    itemDestino.setIcmListaValoresDestino(Collections.singletonList(valorDestino));
    itemDestino.setHorasOrigen(Meta4Constants.FALSE);
    itemDestino.setHorasDestino(Meta4Constants.TRUE);
    itemDestino.setTotalCondiciones(Meta4Constants.TRUE);
    valorDestino.setIdSeccion(AppConstants.SECCION_4.toString());

    List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.ORIGEN.getId(), AppConstants.SECCION_1, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 2, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.ORIGEN.getId(), AppConstants.SECCION_2, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 3, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.ORIGEN.getId(), AppConstants.SECCION_3, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    assertNotNull(result);
    // estructura base y 3 estructuras desplazamiento
    assertEquals(4, result.size());

    itemDestino.setHorasOrigen(Meta4Constants.TRUE);
    itemDestino.setHorasDestino(Meta4Constants.FALSE);
    itemDestino.setTotalCondiciones(Meta4Constants.FALSE);
    result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.ORIGEN.getId(), AppConstants.SECCION_1, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 2, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.ORIGEN.getId(), AppConstants.SECCION_2, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 3, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.ORIGEN.getId(), AppConstants.SECCION_3, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    assertNotNull(result);
    // estructura base y 3 estructuras desplazamiento
    assertEquals(4, result.size());

  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoDesplazamientoSeccion4NoChallengeMejorOpcionTest(
      @Random final EstructurasComResultItemDto itemPadre,
      @Random final ListaCondicionesBaseResultItemDto itemBase, @Random final ListaCondicionesDestinoResultItemDto itemDestino,
      @Random final ListaValoresDestinoResultItemDto valorDestino, @Random final TareaDto tarea) {

    final TipoOpcionCalculoDto opcionCalculo = new TipoOpcionCalculoDto();
    opcionCalculo.setId(TipoOpcionCalculoEnum.MEJOR_OPCION.getId());
    when(this.tipoOpcionCalculoService.findByIdMeta4(any(String.class))).thenReturn(opcionCalculo);

    when(this.delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
        any(EstructurasComResultItemDto.class),
        any(ListaCondicionesBaseResultItemDto.class), any(TareaDto.class))).thenReturn(new TareaPersonaEstructuraDto());
    itemBase.setIdTipoCalculo(TipoCalculoEnum.GLOBAL_SECCION.getId());
    itemBase.setIcmListaValoresBase(new ArrayList<>());
    itemPadre.setIcmListaCondicionesBase(Collections.singletonList(itemBase));
    itemPadre.setIcmListaCondicionesDestino(Collections.singletonList(itemDestino));
    itemDestino.setIdTipoCalculo(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId());
    itemDestino.setIcmListaValoresDestino(Collections.singletonList(valorDestino));
    itemDestino.setHorasOrigen(Meta4Constants.FALSE);
    itemDestino.setHorasDestino(Meta4Constants.TRUE);
    itemDestino.setTotalCondiciones(Meta4Constants.TRUE);
    valorDestino.setIdSeccion(AppConstants.SECCION_4.toString());

    List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_1, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 2, TipoOpcionCalculoEnum.DESTINO.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_1, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 3, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_2, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 4, TipoOpcionCalculoEnum.DESTINO.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_2, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 5, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_3, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 6, TipoOpcionCalculoEnum.DESTINO.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_3, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    assertNotNull(result);
    // estructura base y 6 estructuras desplazamiento (2 mejor opcion * 3 secciones)
    assertEquals(7, result.size());

    itemDestino.setHorasOrigen(Meta4Constants.TRUE);
    itemDestino.setHorasDestino(Meta4Constants.FALSE);
    itemDestino.setTotalCondiciones(Meta4Constants.FALSE);
    result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_1, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 2, TipoOpcionCalculoEnum.DESTINO.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_1, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 3, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_2, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 4, TipoOpcionCalculoEnum.DESTINO.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_2, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 5, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_3, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 6, TipoOpcionCalculoEnum.DESTINO.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_3, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    assertNotNull(result);
    // estructura base y 6 estructuras desplazamiento (2 mejor opcion * 3 secciones)
    assertEquals(7, result.size());

  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoDesplazamientoSeccion4ChallengeTest(
      @Random final EstructurasComResultItemDto itemPadre,
      @Random final ListaCondicionesBaseResultItemDto itemBase, @Random final ListaCondicionesDestinoResultItemDto itemDestino,
      @Random final ListaValoresDestinoResultItemDto valorDestino, @Random final TareaDto tarea) {

    final TipoOpcionCalculoDto opcionCalculo = new TipoOpcionCalculoDto();
    opcionCalculo.setId(TipoOpcionCalculoEnum.ORIGEN.getId());

    when(this.tipoOpcionCalculoService.findByIdMeta4(any(String.class))).thenReturn(opcionCalculo);
    when(this.delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
        any(EstructurasComResultItemDto.class),
        any(ListaCondicionesBaseResultItemDto.class), any(TareaDto.class))).thenReturn(new TareaPersonaEstructuraDto());

    final List<String> tiposCalculo =
        Arrays.asList(TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId());
    for (final String tipoCalculo : tiposCalculo) {
      itemBase.setIdTipoCalculo(tipoCalculo);
      itemBase.setIcmListaValoresBase(new ArrayList<>());
      itemPadre.setIcmListaCondicionesBase(Collections.singletonList(itemBase));
      itemPadre.setIcmListaCondicionesDestino(Collections.singletonList(itemDestino));
      itemDestino.setIdTipoCalculo(tipoCalculo);
      itemDestino.setIcmListaValoresDestino(Collections.singletonList(valorDestino));
      itemDestino.setHorasOrigen(Meta4Constants.FALSE);
      itemDestino.setHorasDestino(Meta4Constants.TRUE);
      itemDestino.setTotalCondiciones(Meta4Constants.TRUE);
      valorDestino.setIdSeccion(AppConstants.SECCION_4.toString());

      List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
          .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

      assertNotNull(result);
      // estructura base y 3 estructuras desplazamiento (una por seccion)
      assertEquals(2, result.size());

      itemDestino.setHorasOrigen(Meta4Constants.TRUE);
      itemDestino.setHorasDestino(Meta4Constants.FALSE);
      itemDestino.setTotalCondiciones(Meta4Constants.FALSE);
      result = this.tareaPersonaEstructuraMapperDecorator
          .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

      assertNotNull(result);
      // estructura base y 3 estructuras desplazamiento (una por seccion)
      assertEquals(2, result.size());

    }

    // Se llama dos veces a cada metodo, una para el challenge importe y otra para el challenge precio / hora
    verify(this.delegate, times(2))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.ORIGEN.getId(), AppConstants.SECCION_4, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(2))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.ORIGEN.getId(), AppConstants.SECCION_4, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);

  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoDesplazamientoSeccion4ChallengeMejorOpcionTest(
      @Random final EstructurasComResultItemDto itemPadre,
      @Random final ListaCondicionesBaseResultItemDto itemBase, @Random final ListaCondicionesDestinoResultItemDto itemDestino,
      @Random final ListaValoresDestinoResultItemDto valorDestino, @Random final TareaDto tarea) {

    final TipoOpcionCalculoDto opcionCalculo = new TipoOpcionCalculoDto();
    opcionCalculo.setId(TipoOpcionCalculoEnum.MEJOR_OPCION.getId());

    when(this.tipoOpcionCalculoService.findByIdMeta4(any(String.class))).thenReturn(opcionCalculo);
    when(this.delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
        any(EstructurasComResultItemDto.class),
        any(ListaCondicionesBaseResultItemDto.class), any(TareaDto.class))).thenReturn(new TareaPersonaEstructuraDto());

    final List<String> tiposCalculo =
        Arrays.asList(TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId());
    for (final String tipoCalculo : tiposCalculo) {
      itemBase.setIdTipoCalculo(tipoCalculo);
      itemBase.setIcmListaValoresBase(new ArrayList<>());
      itemPadre.setIcmListaCondicionesBase(Collections.singletonList(itemBase));
      itemPadre.setIcmListaCondicionesDestino(Collections.singletonList(itemDestino));
      itemDestino.setIdTipoCalculo(TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId());
      itemDestino.setIcmListaValoresDestino(Collections.singletonList(valorDestino));
      itemDestino.setHorasOrigen(Meta4Constants.FALSE);
      itemDestino.setHorasDestino(Meta4Constants.TRUE);
      itemDestino.setTotalCondiciones(Meta4Constants.TRUE);
      valorDestino.setIdSeccion(AppConstants.SECCION_4.toString());

      List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
          .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

      assertNotNull(result);
      // estructura base y 2 estructuras desplazamiento
      assertEquals(3, result.size());

      itemDestino.setHorasOrigen(Meta4Constants.TRUE);
      itemDestino.setHorasDestino(Meta4Constants.FALSE);
      itemDestino.setTotalCondiciones(Meta4Constants.FALSE);
      result = this.tareaPersonaEstructuraMapperDecorator
          .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

      assertNotNull(result);
      // estructura base y 2 estructuras desplazamiento
      assertEquals(3, result.size());

    }

    // Se llama dos veces a cada metodo, una para el challenge importe y otra para el challenge precio / hora
    verify(this.delegate, times(2))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_4, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(2))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 2, TipoOpcionCalculoEnum.DESTINO.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_4, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);
    verify(this.delegate, times(2))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_4, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);
    verify(this.delegate, times(2))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 2, TipoOpcionCalculoEnum.DESTINO.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), AppConstants.SECCION_4, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);

  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoDesplazamientoNoSeccion4NoChallengeTest(
      @Random final EstructurasComResultItemDto itemPadre,
      @Random final ListaCondicionesBaseResultItemDto itemBase, @Random final ListaCondicionesDestinoResultItemDto itemDestino,
      @Random final ListaValoresDestinoResultItemDto valorDestino, @Random final TareaDto tarea) {

    final TipoOpcionCalculoDto opcionCalculo = new TipoOpcionCalculoDto();
    opcionCalculo.setId(TipoOpcionCalculoEnum.ORIGEN.getId());
    when(this.tipoOpcionCalculoService.findByIdMeta4(any(String.class))).thenReturn(opcionCalculo);
    final Integer idSeccion = 1;

    when(this.delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
        any(EstructurasComResultItemDto.class),
        any(ListaCondicionesBaseResultItemDto.class), any(TareaDto.class))).thenReturn(new TareaPersonaEstructuraDto());
    itemBase.setIdTipoCalculo(TipoCalculoEnum.GLOBAL_SECCION.getId());
    itemBase.setIcmListaValoresBase(new ArrayList<>());
    itemPadre.setIcmListaCondicionesBase(Collections.singletonList(itemBase));
    itemPadre.setIcmListaCondicionesDestino(Collections.singletonList(itemDestino));
    itemDestino.setIdTipoOpCalculo(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId());
    itemDestino.setIcmListaValoresDestino(Collections.singletonList(valorDestino));
    itemDestino.setHorasOrigen(Meta4Constants.FALSE);
    itemDestino.setHorasDestino(Meta4Constants.TRUE);
    itemDestino.setTotalCondiciones(Meta4Constants.TRUE);
    valorDestino.setIdSeccion(idSeccion.toString());

    List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.ORIGEN.getId(), idSeccion, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    assertNotNull(result);
    // estructura base y 1 estructuras desplazamiento
    assertEquals(2, result.size());

    itemDestino.setHorasOrigen(Meta4Constants.TRUE);
    itemDestino.setHorasDestino(Meta4Constants.FALSE);
    itemDestino.setTotalCondiciones(Meta4Constants.FALSE);
    result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.ORIGEN.getId(), idSeccion, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    assertNotNull(result);
    // estructura base y 1 estructuras desplazamiento
    assertEquals(2, result.size());

  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoDesplazamientoNoSeccion4NoChallengeMejorOpcionTest(
      @Random final EstructurasComResultItemDto itemPadre,
      @Random final ListaCondicionesBaseResultItemDto itemBase, @Random final ListaCondicionesDestinoResultItemDto itemDestino,
      @Random final ListaValoresDestinoResultItemDto valorDestino, @Random final TareaDto tarea) {

    final TipoOpcionCalculoDto opcionCalculo = new TipoOpcionCalculoDto();
    opcionCalculo.setId(TipoOpcionCalculoEnum.MEJOR_OPCION.getId());
    when(this.tipoOpcionCalculoService.findByIdMeta4(any(String.class))).thenReturn(opcionCalculo);
    final Integer idSeccion = 1;

    when(this.delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
        any(EstructurasComResultItemDto.class),
        any(ListaCondicionesBaseResultItemDto.class), any(TareaDto.class))).thenReturn(new TareaPersonaEstructuraDto());
    itemBase.setIdTipoCalculo(TipoCalculoEnum.GLOBAL_SECCION.getId());
    itemBase.setIcmListaValoresBase(new ArrayList<>());
    itemPadre.setIcmListaCondicionesBase(Collections.singletonList(itemBase));
    itemPadre.setIcmListaCondicionesDestino(Collections.singletonList(itemDestino));
    itemDestino.setIdTipoOpCalculo(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId());
    itemDestino.setIcmListaValoresDestino(Collections.singletonList(valorDestino));
    itemDestino.setHorasOrigen(Meta4Constants.FALSE);
    itemDestino.setHorasDestino(Meta4Constants.TRUE);
    itemDestino.setTotalCondiciones(Meta4Constants.TRUE);
    valorDestino.setIdSeccion(idSeccion.toString());

    List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), idSeccion, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 2, TipoOpcionCalculoEnum.DESTINO.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), idSeccion, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    assertNotNull(result);
    // estructura base y 2 estructuras desplazamiento
    assertEquals(3, result.size());

    itemDestino.setHorasOrigen(Meta4Constants.TRUE);
    itemDestino.setHorasDestino(Meta4Constants.FALSE);
    itemDestino.setTotalCondiciones(Meta4Constants.FALSE);
    result = this.tareaPersonaEstructuraMapperDecorator
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), idSeccion, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(1))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 2, TipoOpcionCalculoEnum.DESTINO.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), idSeccion, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    assertNotNull(result);
    // estructura base y 2 estructuras desplazamiento
    assertEquals(3, result.size());

  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoDesplazamientoNoSeccion4ChallengeTest(
      @Random final EstructurasComResultItemDto itemPadre,
      @Random final ListaCondicionesBaseResultItemDto itemBase, @Random final ListaCondicionesDestinoResultItemDto itemDestino,
      @Random final ListaValoresDestinoResultItemDto valorDestino, @Random final TareaDto tarea) {

    final TipoOpcionCalculoDto opcionCalculo = new TipoOpcionCalculoDto();
    opcionCalculo.setId(TipoOpcionCalculoEnum.ORIGEN.getId());
    final Integer idSeccion = 1;

    when(this.tipoOpcionCalculoService.findByIdMeta4(any(String.class))).thenReturn(opcionCalculo);
    when(this.delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
        any(EstructurasComResultItemDto.class),
        any(ListaCondicionesBaseResultItemDto.class), any(TareaDto.class))).thenReturn(new TareaPersonaEstructuraDto());

    final List<String> tiposCalculo =
        Arrays.asList(TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId());
    for (final String tipoCalculo : tiposCalculo) {
      itemBase.setIdTipoCalculo(tipoCalculo);
      itemBase.setIcmListaValoresBase(new ArrayList<>());
      itemPadre.setIcmListaCondicionesBase(Collections.singletonList(itemBase));
      itemPadre.setIcmListaCondicionesDestino(Collections.singletonList(itemDestino));
      itemDestino.setIdTipoOpCalculo(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId());
      itemDestino.setIcmListaValoresDestino(Collections.singletonList(valorDestino));
      itemDestino.setHorasOrigen(Meta4Constants.FALSE);
      itemDestino.setHorasDestino(Meta4Constants.TRUE);
      itemDestino.setTotalCondiciones(Meta4Constants.TRUE);
      valorDestino.setIdSeccion(idSeccion.toString());

      List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
          .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

      assertNotNull(result);
      // estructura base y 1 estructuras desplazamiento
      assertEquals(2, result.size());

      itemDestino.setHorasOrigen(Meta4Constants.TRUE);
      itemDestino.setHorasDestino(Meta4Constants.FALSE);
      itemDestino.setTotalCondiciones(Meta4Constants.FALSE);
      result = this.tareaPersonaEstructuraMapperDecorator
          .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

      assertNotNull(result);
      // estructura base y 1 estructuras desplazamiento
      assertEquals(2, result.size());

    }

    // Se llama dos veces a cada metodo, una para el challenge importe y otra para el challenge precio / hora
    verify(this.delegate, times(2))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.ORIGEN.getId(), idSeccion, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(2))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.ORIGEN.getId(), idSeccion, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
  }

  @Test
  void estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDtoDesplazamientoNoSeccion4ChallengeMejorOpcionTest(
      @Random final EstructurasComResultItemDto itemPadre,
      @Random final ListaCondicionesBaseResultItemDto itemBase, @Random final ListaCondicionesDestinoResultItemDto itemDestino,
      @Random final ListaValoresDestinoResultItemDto valorDestino, @Random final TareaDto tarea) {

    final TipoOpcionCalculoDto opcionCalculo = new TipoOpcionCalculoDto();
    opcionCalculo.setId(TipoOpcionCalculoEnum.MEJOR_OPCION.getId());
    final Integer idSeccion = 1;

    when(this.tipoOpcionCalculoService.findByIdMeta4(any(String.class))).thenReturn(opcionCalculo);
    when(this.delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
        any(EstructurasComResultItemDto.class),
        any(ListaCondicionesBaseResultItemDto.class), any(TareaDto.class))).thenReturn(new TareaPersonaEstructuraDto());

    final List<String> tiposCalculo =
        Arrays.asList(TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId());
    for (final String tipoCalculo : tiposCalculo) {
      itemBase.setIdTipoCalculo(tipoCalculo);
      itemBase.setIcmListaValoresBase(new ArrayList<>());
      itemPadre.setIcmListaCondicionesBase(Collections.singletonList(itemBase));
      itemPadre.setIcmListaCondicionesDestino(Collections.singletonList(itemDestino));
      itemDestino.setIdTipoOpCalculo(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId());
      itemDestino.setIcmListaValoresDestino(Collections.singletonList(valorDestino));
      itemDestino.setHorasOrigen(Meta4Constants.FALSE);
      itemDestino.setHorasDestino(Meta4Constants.TRUE);
      itemDestino.setTotalCondiciones(Meta4Constants.TRUE);
      valorDestino.setIdSeccion(idSeccion.toString());

      List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapperDecorator
          .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

      assertNotNull(result);
      // estructura base y 2 estructuras desplazamiento
      assertEquals(3, result.size());

      itemDestino.setHorasOrigen(Meta4Constants.TRUE);
      itemDestino.setHorasDestino(Meta4Constants.FALSE);
      itemDestino.setTotalCondiciones(Meta4Constants.FALSE);
      result = this.tareaPersonaEstructuraMapperDecorator
          .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(Collections.singletonList(itemPadre), tarea);

      assertNotNull(result);
      // estructura base y 2 estructuras desplazamiento
      assertEquals(3, result.size());

    }

    // Se llama dos veces a cada metodo, una para el challenge importe y otra para el challenge precio / hora
    verify(this.delegate, times(2))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), idSeccion, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(2))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 2, TipoOpcionCalculoEnum.DESTINO.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), idSeccion, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(2))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 1, TipoOpcionCalculoEnum.ORIGEN.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), idSeccion, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
    verify(this.delegate, times(2))
        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            itemPadre, itemBase, itemDestino, valorDestino, tarea, 2, TipoOpcionCalculoEnum.DESTINO.getId(),
            TipoOpcionCalculoEnum.MEJOR_OPCION.getId(), idSeccion, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
  }

}
