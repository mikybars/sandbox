package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPersonaVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;

import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TareaLocalizacionPersonaVentaDecoratorTest {

  @Mock
  private Logger log;

  @Mock
  private TareaLocalizacionPersonaVentaMapper delegate;

  @InjectMocks
  TareaLocalizacionPersonaVentaDecorator tareaLocalizacionPersonaVentaDecorator = this.getClassMock();

  private TareaLocalizacionPersonaVentaDecorator getClassMock() {
    return Mockito.mock(TareaLocalizacionPersonaVentaDecorator.class, Mockito.CALLS_REAL_METHODS);
  }

  private static Stream<Arguments> parameters() {
    return Stream.of(
        arguments("V", 1),
        arguments("D", 1),
        arguments("", 0));
  }

  @ParameterizedTest
  @InstancioSource
  void ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaTest(final String arg, final int intArgs,
      final TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVenta) {
    final var ptrVentaIndividualDetalleResultItemDto = Instancio.create(PtrVentaIndividualDetalleResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);

    final PtrVentaIndividualDetalleResultItemDto ptrVentaIndividualDetalleResult = ptrVentaIndividualDetalleResultItemDto;
    ptrVentaIndividualDetalleResult.setOperacion(arg);

    tareaLocalizacionPersonaVenta.setCclIdPerson("" + intArgs);
    doReturn(tareaLocalizacionPersonaVenta).when(this.delegate)
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(ptrVentaIndividualDetalleResult, tarea);

    final TareaLocalizacionPersonaVenta result = this.tareaLocalizacionPersonaVentaDecorator
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(ptrVentaIndividualDetalleResult, tarea);

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource
  void ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaTest4(
      final TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVenta) {
    final var ptrSeccionVentaOnlineGenericType = Instancio.create(PtrSeccionVentaOnlineGenericType.class);
    final var ptrVentaIndividualDetalleResultItemDtoList = Instancio.ofList(PtrVentaIndividualDetalleResultItemDto.class).size(1).create();
    final var tarea = Instancio.create(TareaDto.class);

    final PtrSeccionVentaOnlineGenericType seccion4 = PtrSeccionVentaOnlineGenericType.builder().build();
    seccion4.setSeccion(4);
    seccion4.setImporteConIVA(ptrSeccionVentaOnlineGenericType.getImporteConIVA());
    seccion4.setImporteSinIVA(ptrSeccionVentaOnlineGenericType.getImporteSinIVA());

    final List<PtrSeccionVentaOnlineGenericType> listaSeccion = Arrays.asList(ptrSeccionVentaOnlineGenericType, seccion4);
    final List<PtrVentaIndividualDetalleResultItemDto> list = ptrVentaIndividualDetalleResultItemDtoList;
    list.get(0).setListaSeccion(listaSeccion);

    tareaLocalizacionPersonaVenta.setCclIdPerson("0");
    doReturn(tareaLocalizacionPersonaVenta).when(this.delegate)
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(any(PtrVentaIndividualDetalleResultItemDto.class), any(
            TareaDto.class));

    final List<TareaLocalizacionPersonaVenta> result = this.tareaLocalizacionPersonaVentaDecorator
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(list, tarea);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @ParameterizedTest
  @InstancioSource
  void ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaTest(final String arg,
      final TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVenta) {
    final var ptrVentaOnlineIpodIndividualDetalleResultItemDto = Instancio.create(PtrVentaOnlineIpodIndividualDetalleResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);

    ptrVentaOnlineIpodIndividualDetalleResultItemDto.setOperacion(arg);

    doReturn(tareaLocalizacionPersonaVenta).when(this.delegate)
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            ptrVentaOnlineIpodIndividualDetalleResultItemDto, tarea);

    final TareaLocalizacionPersonaVenta result = this.tareaLocalizacionPersonaVentaDecorator
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            ptrVentaOnlineIpodIndividualDetalleResultItemDto, tarea);

    assertNotNull(result);
  }

  @Test
  void ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaTest2() {
    final TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVenta = new TareaLocalizacionPersonaVenta();
    tareaLocalizacionPersonaVenta.setActivo(Boolean.TRUE);
    final var tarea = Instancio.create(TareaDto.class);
    final List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> ptrVentaOnlineIpodIndividualDetalleResultItemDtoList =
        Instancio.ofList(PtrVentaOnlineIpodIndividualDetalleResultItemDto.class).size(1).create();

    final PtrSeccionVentaOnlineGenericType seccion4 = PtrSeccionVentaOnlineGenericType.builder().build();
    seccion4.setSeccion(4);
    seccion4.setImporteConIVA(BigDecimal.valueOf(1L));
    seccion4.setImporteSinIVA(BigDecimal.valueOf(1L));

    final List<PtrSeccionVentaOnlineGenericType> listaSeccion = List.of(seccion4);
    ptrVentaOnlineIpodIndividualDetalleResultItemDtoList.get(0).setListaSeccion(listaSeccion);
    tareaLocalizacionPersonaVenta.setCclIdPerson("0");
    tareaLocalizacionPersonaVenta.setTipoDato(TipoDato.builder().build());

    doReturn(tareaLocalizacionPersonaVenta).when(this.delegate)
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            any(PtrVentaOnlineIpodIndividualDetalleResultItemDto.class), any(TareaDto.class));

    final List<TareaLocalizacionPersonaVenta> result = this.tareaLocalizacionPersonaVentaDecorator
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            ptrVentaOnlineIpodIndividualDetalleResultItemDtoList, tarea);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

}
