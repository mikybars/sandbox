package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPersonaVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
public class TareaLocalizacionPersonaVentaDecoratorTest {

  @Mock
  private Logger log;

  @Mock
  private TareaLocalizacionPersonaVentaMapper delegate;

  @InjectMocks
  TareaLocalizacionPersonaVentaDecorator tareaLocalizacionPersonaVentaDecorator = getClassMock();

  @Random
  PtrVentaIndividualDetalleResultItemDto ptrVentaIndividualDetalleResultItemDto;

  @Random
  TareaDto tarea;

  @Random
  PtrSeccionVentaOnlineGenericType ptrSeccionVentaOnlineGenericType;

  @Random
  PtrVentaOnlineIpodIndividualDetalleResultItemDto ptrVentaOnlineIpodIndividualDetalleResultItemDto;

  @Random(type = PtrVentaIndividualDetalleResultItemDto.class, size = 1)
  List<PtrVentaIndividualDetalleResultItemDto> ptrVentaIndividualDetalleResultItemDtoList;

  @Random(type = PtrVentaOnlineIpodIndividualDetalleResultItemDto.class, size = 1)
  List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> ptrVentaOnlineIpodIndividualDetalleResultItemDtoList;

  private TareaLocalizacionPersonaVentaDecorator getClassMock() {
    return Mockito.mock(TareaLocalizacionPersonaVentaDecorator.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaTest(
      @Random TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVenta) {

    PtrVentaIndividualDetalleResultItemDto ptrVentaIndividualDetalleResult = this.ptrVentaIndividualDetalleResultItemDto;
    ptrVentaIndividualDetalleResult.setOperacion("V");

    tareaLocalizacionPersonaVenta.setCclIdPerson("1");
    doReturn(tareaLocalizacionPersonaVenta).when(this.delegate)
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(ptrVentaIndividualDetalleResult, this.tarea);

    final TareaLocalizacionPersonaVenta result = this.tareaLocalizacionPersonaVentaDecorator
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(ptrVentaIndividualDetalleResult, this.tarea);

    assertNotNull(result);
  }

  @Test
  void ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaTest2(
      @Random TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVenta) {

    PtrVentaIndividualDetalleResultItemDto ptrVentaIndividualDetalleResult = this.ptrVentaIndividualDetalleResultItemDto;
    ptrVentaIndividualDetalleResult.setOperacion("D");

    tareaLocalizacionPersonaVenta.setCclIdPerson("1");
    doReturn(tareaLocalizacionPersonaVenta).when(this.delegate)
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(ptrVentaIndividualDetalleResult, this.tarea);

    final TareaLocalizacionPersonaVenta result = this.tareaLocalizacionPersonaVentaDecorator
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(ptrVentaIndividualDetalleResult, this.tarea);

    assertNotNull(result);
  }

  @Test
  void ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaTest3(
      @Random TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVenta) {

    PtrVentaIndividualDetalleResultItemDto ptrVentaIndividualDetalleResult = this.ptrVentaIndividualDetalleResultItemDto;
    ptrVentaIndividualDetalleResult.setOperacion("");

    tareaLocalizacionPersonaVenta.setCclIdPerson("0");
    doReturn(tareaLocalizacionPersonaVenta).when(this.delegate)
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(ptrVentaIndividualDetalleResult, this.tarea);

    final TareaLocalizacionPersonaVenta result = this.tareaLocalizacionPersonaVentaDecorator
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(ptrVentaIndividualDetalleResult, this.tarea);

    assertNotNull(result);
  }

  @Test
  void ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaTest4(
      @Random TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVenta) {

    PtrSeccionVentaOnlineGenericType seccion4 = PtrSeccionVentaOnlineGenericType.builder().build();
    seccion4.setSeccion(4);
    seccion4.setImporteConIVA(this.ptrSeccionVentaOnlineGenericType.getImporteConIVA());
    seccion4.setImporteSinIVA(this.ptrSeccionVentaOnlineGenericType.getImporteSinIVA());

    List<PtrSeccionVentaOnlineGenericType> listaSeccion = Arrays.asList(this.ptrSeccionVentaOnlineGenericType, seccion4);
    List<PtrVentaIndividualDetalleResultItemDto> list = this.ptrVentaIndividualDetalleResultItemDtoList;
    list.get(0).setListaSeccion(listaSeccion);

    tareaLocalizacionPersonaVenta.setCclIdPerson("0");
    doReturn(tareaLocalizacionPersonaVenta).when(this.delegate)
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(list.get(0), this.tarea);

    final List<TareaLocalizacionPersonaVenta> result = this.tareaLocalizacionPersonaVentaDecorator
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(list, this.tarea);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
  }

  @Test
  void ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaTest(
      @Random TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVenta) {

    this.ptrVentaOnlineIpodIndividualDetalleResultItemDto.setOperacion("V");

    doReturn(tareaLocalizacionPersonaVenta).when(this.delegate)
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            this.ptrVentaOnlineIpodIndividualDetalleResultItemDto, this.tarea);

    final TareaLocalizacionPersonaVenta result = this.tareaLocalizacionPersonaVentaDecorator
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            this.ptrVentaOnlineIpodIndividualDetalleResultItemDto, this.tarea);

    assertNotNull(result);
  }

  @Test
  void ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaTest2(
      @Random TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVenta) {

    this.ptrVentaOnlineIpodIndividualDetalleResultItemDto.setOperacion("D");

    doReturn(tareaLocalizacionPersonaVenta).when(this.delegate)
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            this.ptrVentaOnlineIpodIndividualDetalleResultItemDto, this.tarea);

    final TareaLocalizacionPersonaVenta result = this.tareaLocalizacionPersonaVentaDecorator
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            this.ptrVentaOnlineIpodIndividualDetalleResultItemDto, this.tarea);

    assertNotNull(result);
  }

  @Test
  void ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaTest3(
      @Random TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVenta) {

    this.ptrVentaOnlineIpodIndividualDetalleResultItemDto.setOperacion("");

    doReturn(tareaLocalizacionPersonaVenta).when(this.delegate)
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            this.ptrVentaOnlineIpodIndividualDetalleResultItemDto, this.tarea);

    final TareaLocalizacionPersonaVenta result = this.tareaLocalizacionPersonaVentaDecorator
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            this.ptrVentaOnlineIpodIndividualDetalleResultItemDto, this.tarea);

    assertNotNull(result);
  }

  @Test
  void ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaTest4(
      @Random TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVenta) {

    PtrSeccionVentaOnlineGenericType seccion4 = PtrSeccionVentaOnlineGenericType.builder().build();
    seccion4.setSeccion(4);
    seccion4.setImporteConIVA(this.ptrSeccionVentaOnlineGenericType.getImporteConIVA());
    seccion4.setImporteSinIVA(this.ptrSeccionVentaOnlineGenericType.getImporteSinIVA());

    List<PtrSeccionVentaOnlineGenericType> listaSeccion = Arrays.asList(this.ptrSeccionVentaOnlineGenericType, seccion4);
    this.ptrVentaOnlineIpodIndividualDetalleResultItemDtoList.get(0).setListaSeccion(listaSeccion);

    doReturn(tareaLocalizacionPersonaVenta).when(this.delegate)
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            ptrVentaOnlineIpodIndividualDetalleResultItemDtoList.get(0), this.tarea);

    final List<TareaLocalizacionPersonaVenta> result = this.tareaLocalizacionPersonaVentaDecorator
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            this.ptrVentaOnlineIpodIndividualDetalleResultItemDtoList, this.tarea);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
  }

}
