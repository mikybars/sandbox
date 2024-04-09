package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionVenta;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
public class TareaAgrupacionVentaMapperTest {

  @Mock
  private TareaAgrupacionVentaMapper tareaAgrupacionVentaMapper;

  @Test
  public void ventaTotalizadoVariasFechasTest() {
    final List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
    final TareaAgrupacionVenta agrupacion = new TareaAgrupacionVenta();
    agrupacion.setImporteConImpuestos(BigDecimal.valueOf(40000D));
    agrupacion.setImporteSinImpuestos(BigDecimal.valueOf(34900D));
    when(this.tareaAgrupacionVentaMapper.ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(any(List.class), any(TareaDto.class),
        any(List.class))).thenReturn(Arrays.asList(agrupacion));

    final List<TareaAgrupacionVenta> ventas = this.tareaAgrupacionVentaMapper
        .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, this.createTarea(), this.createAgrupaciones());
    assertNotNull(ventas);
    assertEquals(1, ventas.size());
  }

  @Test
  public void ventaTotalizadoVariasCadenasMismoGrupoTest() {
    final List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();

    final TareaAgrupacionVenta agrupacion = new TareaAgrupacionVenta();
    agrupacion.setImporteConImpuestos(BigDecimal.valueOf(40000D));
    agrupacion.setImporteSinImpuestos(BigDecimal.valueOf(34900D));
    when(this.tareaAgrupacionVentaMapper.ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(any(List.class), any(TareaDto.class),
        any(List.class))).thenReturn(Arrays.asList(agrupacion));

    final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
        .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, this.createTarea(), this.createAgrupaciones());
    assertNotNull(presencias);
    assertEquals(1, presencias.size());
    assertEquals(40000D, presencias.get(0).getImporteConImpuestos().doubleValue(), 0.001);
    assertEquals(34900D, presencias.get(0).getImporteSinImpuestos().doubleValue(), 0.001);
  }

  @Test
  public void ventaTotalizadoVariasCadenasDistintoGrupoTest() {
    final List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
    final TareaAgrupacionVenta agrupacion = new TareaAgrupacionVenta();
    agrupacion.setImporteConImpuestos(BigDecimal.valueOf(40000D));
    agrupacion.setImporteSinImpuestos(BigDecimal.valueOf(34900D));
    when(this.tareaAgrupacionVentaMapper.ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(any(List.class), any(TareaDto.class),
        any(List.class))).thenReturn(Arrays.asList(agrupacion));

    final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
        .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, this.createTarea(), this.createAgrupaciones());
    assertNotNull(presencias);
    assertEquals(1, presencias.size());
  }

  @Test
  public void ventaTotalizadoVariosPaisesTest() {
    final List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
    final TareaAgrupacionVenta agrupacion = new TareaAgrupacionVenta();
    agrupacion.setImporteConImpuestos(BigDecimal.valueOf(40000D));
    agrupacion.setImporteSinImpuestos(BigDecimal.valueOf(34900D));
    when(this.tareaAgrupacionVentaMapper.ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(any(List.class), any(TareaDto.class),
        any(List.class))).thenReturn(Arrays.asList(agrupacion));
    final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
        .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, this.createTarea(), this.createAgrupaciones());
    assertNotNull(presencias);
    assertEquals(1, presencias.size());
  }

  @Test
  public void ventaTotalizadoVariasEmpresasTest() {
    final List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
    final TareaAgrupacionVenta agrupacion = new TareaAgrupacionVenta();
    agrupacion.setImporteConImpuestos(BigDecimal.valueOf(40000D));
    agrupacion.setImporteSinImpuestos(BigDecimal.valueOf(34900D));
    when(this.tareaAgrupacionVentaMapper.ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(any(List.class), any(TareaDto.class),
        any(List.class))).thenReturn(Arrays.asList(agrupacion));
    final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
        .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, this.createTarea(), this.createAgrupaciones());
    assertNotNull(presencias);
    assertEquals(1, presencias.size());
    assertEquals(40000D, presencias.get(0).getImporteConImpuestos().doubleValue(), 0.001);
    assertEquals(34900D, presencias.get(0).getImporteSinImpuestos().doubleValue(), 0.001);
  }

  @Test
  public void ventaTotalizadoVariasSeccionesTest() {
    final List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
    final TareaAgrupacionVenta agrupacion = new TareaAgrupacionVenta();
    agrupacion.setImporteConImpuestos(BigDecimal.valueOf(40000D));
    agrupacion.setImporteSinImpuestos(BigDecimal.valueOf(34900D));
    when(this.tareaAgrupacionVentaMapper.ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(any(List.class), any(TareaDto.class),
        any(List.class))).thenReturn(Arrays.asList(agrupacion));
    final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
        .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, this.createTarea(), this.createAgrupaciones());
    assertNotNull(presencias);
    assertEquals(1, presencias.size());
  }

  @Test
  public void ventaEntregaDomicilioVariasFechasTest() {
    final List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
    final TareaAgrupacionVenta agrupacion = new TareaAgrupacionVenta();
    agrupacion.setImporteConImpuestos(BigDecimal.valueOf(40000D));
    agrupacion.setImporteSinImpuestos(BigDecimal.valueOf(34900D));
    when(
        this.tareaAgrupacionVentaMapper.ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(any(List.class), any(TareaDto.class),
            any(List.class))).thenReturn(Arrays.asList(agrupacion));
    final List<TareaAgrupacionVenta> ventas = this.tareaAgrupacionVentaMapper
        .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, this.createTarea(),
            this.createAgrupaciones());
    assertNotNull(ventas);
    assertEquals(1, ventas.size());
  }

  @Test
  public void ventaEntregaDomicilioVariasCadenasMismoGrupoTest() {
    final List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
    final TareaAgrupacionVenta agrupacion = new TareaAgrupacionVenta();
    agrupacion.setImporteConImpuestos(BigDecimal.valueOf(40000D));
    agrupacion.setImporteSinImpuestos(BigDecimal.valueOf(34900D));
    when(
        this.tareaAgrupacionVentaMapper.ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(any(List.class), any(TareaDto.class),
            any(List.class))).thenReturn(Arrays.asList(agrupacion));
    final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
        .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, this.createTarea(),
            this.createAgrupaciones());
    assertNotNull(presencias);
    assertEquals(1, presencias.size());
    assertEquals(40000D, presencias.get(0).getImporteConImpuestos().doubleValue(), 0.001);
    assertEquals(34900D, presencias.get(0).getImporteSinImpuestos().doubleValue(), 0.001);
  }

  @Test
  public void ventaEntregaDomicilioVariasCadenasDistintoGrupoTest() {
    final List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
    final TareaAgrupacionVenta agrupacion = new TareaAgrupacionVenta();
    agrupacion.setImporteConImpuestos(BigDecimal.valueOf(40000D));
    agrupacion.setImporteSinImpuestos(BigDecimal.valueOf(34900D));
    when(
        this.tareaAgrupacionVentaMapper.ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(any(List.class), any(TareaDto.class),
            any(List.class))).thenReturn(Arrays.asList(agrupacion));
    final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
        .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, this.createTarea(),
            this.createAgrupaciones());
    assertNotNull(presencias);
    assertEquals(1, presencias.size());
  }

  @Test
  public void ventaEntregaDomicilioVariosPaisesTest() {
    final List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
    final TareaAgrupacionVenta agrupacion = new TareaAgrupacionVenta();
    agrupacion.setImporteConImpuestos(BigDecimal.valueOf(40000D));
    agrupacion.setImporteSinImpuestos(BigDecimal.valueOf(34900D));
    when(
        this.tareaAgrupacionVentaMapper.ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(any(List.class), any(TareaDto.class),
            any(List.class))).thenReturn(Arrays.asList(agrupacion));
    final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
        .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, this.createTarea(),
            this.createAgrupaciones());
    assertNotNull(presencias);
    assertEquals(1, presencias.size());
  }

  @Test
  public void ventaEntregaDomicilioVariasEmpresasTest() {
    final List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
    final TareaAgrupacionVenta agrupacion = new TareaAgrupacionVenta();
    agrupacion.setImporteConImpuestos(BigDecimal.valueOf(40000D));
    agrupacion.setImporteSinImpuestos(BigDecimal.valueOf(34900D));
    when(
        this.tareaAgrupacionVentaMapper.ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(any(List.class), any(TareaDto.class),
            any(List.class))).thenReturn(Arrays.asList(agrupacion));
    final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
        .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, this.createTarea(),
            this.createAgrupaciones());
    assertNotNull(presencias);
    assertEquals(1, presencias.size());
    assertEquals(40000D, presencias.get(0).getImporteConImpuestos().doubleValue(), 0.001);
    assertEquals(34900D, presencias.get(0).getImporteSinImpuestos().doubleValue(), 0.001);
  }

  @Test
  public void ventaEntregaDomicilioVariasSeccionesTest() {
    final List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
    final TareaAgrupacionVenta agrupacion = new TareaAgrupacionVenta();
    agrupacion.setImporteConImpuestos(BigDecimal.valueOf(40000D));
    agrupacion.setImporteSinImpuestos(BigDecimal.valueOf(34900D));
    when(
        this.tareaAgrupacionVentaMapper.ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(any(List.class), any(TareaDto.class),
            any(List.class))).thenReturn(Arrays.asList(agrupacion));
    final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
        .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, this.createTarea(),
            this.createAgrupaciones());
    assertNotNull(presencias);
    assertEquals(1, presencias.size());
  }

  private List<TareaAgrupacionCadenasDto> createAgrupaciones() {
    final List<TareaAgrupacionCadenasDto> agrupaciones = new ArrayList<>();
    final TareaAgrupacionCadenasDto agrupacion1 = new TareaAgrupacionCadenasDto();
    agrupacion1.setCadenas(new ArrayList<>());
    agrupacion1.getCadenas().add("1");
    agrupacion1.getCadenas().add("163");
    agrupacion1.setId(1L);
    final TareaAgrupacionCadenasDto agrupacion2 = new TareaAgrupacionCadenasDto();
    agrupacion2.setCadenas(new ArrayList<>());
    agrupacion2.getCadenas().add("2");
    agrupacion2.setId(2L);
    agrupaciones.add(agrupacion1);
    agrupaciones.add(agrupacion2);
    return agrupaciones;
  }

  private TareaDto createTarea() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(100L);
    return tarea;
  }

  private PtrVentaOnlineEntregaDomicilioResultItemDto createEntregaDomicilioResultItem(final int cadena,
      final int empresa,
      final String fecha, final double importeIVA, final double importe, final int origen, final int seccion) {
    final PtrVentaOnlineEntregaDomicilioResultItemDto item = new PtrVentaOnlineEntregaDomicilioResultItemDto();
    item.setCadena(cadena);
    item.setEmpresa(empresa);
    item.setFecha(fecha);
    item.setImporteConIVA(BigDecimal.valueOf(importeIVA));
    item.setImporteSinIVA(BigDecimal.valueOf(importe));
    item.setSeccion(seccion);
    item.setPais(origen);
    return item;
  }

  private PtrVentaTotalizadoResultItemDto createTotalizadoResultItem(final int cadena, final int empresa,
      final String fecha, final double importeIVA, final double importe, final int origen, final int seccion) {
    final PtrVentaTotalizadoResultItemDto item = new PtrVentaTotalizadoResultItemDto();
    item.setCadena(cadena);
    item.setEmpresa(empresa);
    item.setFecha(fecha);
    item.setImporteConIVA(BigDecimal.valueOf(importeIVA));
    item.setImporteSinIVA(BigDecimal.valueOf(importe));
    item.setSeccion(seccion);
    item.setPais(origen);
    return item;
  }

}
