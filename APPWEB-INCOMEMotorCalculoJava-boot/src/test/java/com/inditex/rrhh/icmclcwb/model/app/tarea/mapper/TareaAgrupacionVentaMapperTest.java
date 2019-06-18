package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionVenta;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class TareaAgrupacionVentaMapperTest {

    @Autowired
    private TareaAgrupacionVentaMapper tareaAgrupacionVentaMapper;

    @Test
    public void ventaTotalizadoVariasFechasTest() {
        List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
        PtrVentaTotalizadoResultItemDto unoEnero = createTotalizadoResultItem(1, 1, "2015-01-01",
            25000, 22300, 38, 4);
        PtrVentaTotalizadoResultItemDto dosFebrero = createTotalizadoResultItem(1, 1, "2015-01-02",
            15000, 12600, 38, 4);
        list.add(unoEnero);
        list.add(dosFebrero);
        List<TareaAgrupacionVenta> ventas = tareaAgrupacionVentaMapper
            .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, createTarea(), createAgrupaciones());
        assertNotNull(ventas);
        assertEquals(2, ventas.size());
    }

    @Test
    public void ventaTotalizadoVariasCadenasMismoGrupoTest() {
        List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
        PtrVentaTotalizadoResultItemDto cadena1 = createTotalizadoResultItem(1, 1, "2015-01-01",
            25000, 22300, 38, 4);
        PtrVentaTotalizadoResultItemDto cadena163 = createTotalizadoResultItem(163, 1, "2015-01-01",
            15000, 12600, 38, 4);
        list.add(cadena1);
        list.add(cadena163);
        List<TareaAgrupacionVenta> presencias = tareaAgrupacionVentaMapper
            .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(1, presencias.size());
        assertEquals(40000D, presencias.get(0).getImporteConImpuestos().doubleValue(), 0.001);
        assertEquals(34900D, presencias.get(0).getImporte().doubleValue(), 0.001);
    }

    @Test
    public void ventaTotalizadoVariasCadenasDistintoGrupoTest() {
        List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
        PtrVentaTotalizadoResultItemDto cadena1 = createTotalizadoResultItem(1, 1, "2015-01-01",
            25000, 22300, 38, 4);
        PtrVentaTotalizadoResultItemDto cadena2 = createTotalizadoResultItem(2, 1, "2015-01-01",
            15000, 12600, 38, 4);
        list.add(cadena1);
        list.add(cadena2);
        List<TareaAgrupacionVenta> presencias = tareaAgrupacionVentaMapper
            .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(2, presencias.size());
    }

    @Test
    public void ventaTotalizadoVariosPaisesTest() {
        List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
        PtrVentaTotalizadoResultItemDto pais38 = createTotalizadoResultItem(1, 1, "2015-01-01",
            25000, 22300, 38, 4);
        PtrVentaTotalizadoResultItemDto pais11 = createTotalizadoResultItem(1, 1, "2015-01-01",
            15000, 12600, 11, 4);
        list.add(pais38);
        list.add(pais11);
        List<TareaAgrupacionVenta> presencias = tareaAgrupacionVentaMapper
            .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(1, presencias.size());
        assertEquals(40000D, presencias.get(0).getImporteConImpuestos().doubleValue(), 0.001);
        assertEquals(34900D, presencias.get(0).getImporte().doubleValue(), 0.001);
    }

    @Test
    public void ventaTotalizadoVariasEmpresasTest() {
        List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
        PtrVentaTotalizadoResultItemDto empresa1 = createTotalizadoResultItem(1, 1, "2015-01-01",
            25000, 22300, 38, 4);
        PtrVentaTotalizadoResultItemDto empresa3 = createTotalizadoResultItem(1, 3, "2015-01-01",
            15000, 12600, 38, 4);
        list.add(empresa1);
        list.add(empresa3);
        List<TareaAgrupacionVenta> presencias = tareaAgrupacionVentaMapper
            .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(1, presencias.size());
        assertEquals(40000D, presencias.get(0).getImporteConImpuestos().doubleValue(), 0.001);
        assertEquals(34900D, presencias.get(0).getImporte().doubleValue(), 0.001);
    }

    @Test
    public void ventaTotalizadoVariasSeccionesTest() {
        List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
        PtrVentaTotalizadoResultItemDto seccion1 = createTotalizadoResultItem(1, 1, "2015-01-01",
            25000, 22300, 38, 1);
        PtrVentaTotalizadoResultItemDto seccion2 = createTotalizadoResultItem(1, 1, "2015-01-01",
            15000, 12600, 38, 2);
        list.add(seccion1);
        list.add(seccion2);
        List<TareaAgrupacionVenta> presencias = tareaAgrupacionVentaMapper
            .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(2, presencias.size());
    }


    @Test
    public void ventaEntregaDomicilioVariasFechasTest() {
        List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
        PtrVentaOnlineEntregaDomicilioResultItemDto unoEnero = createEntregaDomicilioResultItem(1, 1, "2015-01-01",
            25000, 22300, 38, 4);
        PtrVentaOnlineEntregaDomicilioResultItemDto dosFebrero = createEntregaDomicilioResultItem(1, 1, "2015-01-02",
            15000, 12600, 38, 4);
        list.add(unoEnero);
        list.add(dosFebrero);
        List<TareaAgrupacionVenta> ventas = tareaAgrupacionVentaMapper
            .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, createTarea(), createAgrupaciones());
        assertNotNull(ventas);
        assertEquals(2, ventas.size());
    }

    @Test
    public void ventaEntregaDomicilioVariasCadenasMismoGrupoTest() {
        List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
        PtrVentaOnlineEntregaDomicilioResultItemDto cadena1 = createEntregaDomicilioResultItem(1, 1, "2015-01-01",
            25000, 22300, 38, 4);
        PtrVentaOnlineEntregaDomicilioResultItemDto cadena163 = createEntregaDomicilioResultItem(163, 1, "2015-01-01",
            15000, 12600, 38, 4);
        list.add(cadena1);
        list.add(cadena163);
        List<TareaAgrupacionVenta> presencias = tareaAgrupacionVentaMapper
            .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(1, presencias.size());
        assertEquals(40000D, presencias.get(0).getImporteConImpuestos().doubleValue(), 0.001);
        assertEquals(34900D, presencias.get(0).getImporte().doubleValue(), 0.001);
    }

    @Test
    public void ventaEntregaDomicilioVariasCadenasDistintoGrupoTest() {
        List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
        PtrVentaOnlineEntregaDomicilioResultItemDto cadena1 = createEntregaDomicilioResultItem(1, 1, "2015-01-01",
            25000, 22300, 38, 4);
        PtrVentaOnlineEntregaDomicilioResultItemDto cadena2 = createEntregaDomicilioResultItem(2, 1, "2015-01-01",
            15000, 12600, 38, 4);
        list.add(cadena1);
        list.add(cadena2);
        List<TareaAgrupacionVenta> presencias = tareaAgrupacionVentaMapper
            .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(2, presencias.size());
    }

    @Test
    public void ventaEntregaDomicilioVariosPaisesTest() {
        List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
        PtrVentaOnlineEntregaDomicilioResultItemDto pais38 = createEntregaDomicilioResultItem(1, 1, "2015-01-01",
            25000, 22300, 38, 4);
        PtrVentaOnlineEntregaDomicilioResultItemDto pais11 = createEntregaDomicilioResultItem(1, 1, "2015-01-01",
            15000, 12600, 11, 4);
        list.add(pais38);
        list.add(pais11);
        List<TareaAgrupacionVenta> presencias = tareaAgrupacionVentaMapper
            .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(1, presencias.size());
        assertEquals(40000D, presencias.get(0).getImporteConImpuestos().doubleValue(), 0.001);
        assertEquals(34900D, presencias.get(0).getImporte().doubleValue(), 0.001);
    }

    @Test
    public void ventaEntregaDomicilioVariasEmpresasTest() {
        List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
        PtrVentaOnlineEntregaDomicilioResultItemDto empresa1 = createEntregaDomicilioResultItem(1, 1, "2015-01-01",
            25000, 22300, 38, 4);
        PtrVentaOnlineEntregaDomicilioResultItemDto empresa3 = createEntregaDomicilioResultItem(1, 3, "2015-01-01",
            15000, 12600, 38, 4);
        list.add(empresa1);
        list.add(empresa3);
        List<TareaAgrupacionVenta> presencias = tareaAgrupacionVentaMapper
            .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(1, presencias.size());
        assertEquals(40000D, presencias.get(0).getImporteConImpuestos().doubleValue(), 0.001);
        assertEquals(34900D, presencias.get(0).getImporte().doubleValue(), 0.001);
    }

    @Test
    public void ventaEntregaDomicilioVariasSeccionesTest() {
        List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
        PtrVentaOnlineEntregaDomicilioResultItemDto seccion1 = createEntregaDomicilioResultItem(1, 1, "2015-01-01",
            25000, 22300, 38, 1);
        PtrVentaOnlineEntregaDomicilioResultItemDto seccion2 = createEntregaDomicilioResultItem(1, 1, "2015-01-01",
            15000, 12600, 38, 2);
        list.add(seccion1);
        list.add(seccion2);
        List<TareaAgrupacionVenta> presencias = tareaAgrupacionVentaMapper
            .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(2, presencias.size());
    }
    

    private List<TareaAgrupacionCadenasDto> createAgrupaciones() {
        List<TareaAgrupacionCadenasDto> agrupaciones = new ArrayList<>();
        TareaAgrupacionCadenasDto agrupacion1 = new TareaAgrupacionCadenasDto();
        agrupacion1.setCadenas(new ArrayList<>());
        agrupacion1.getCadenas().add("1");
        agrupacion1.getCadenas().add("163");
        agrupacion1.setId(1L);
        TareaAgrupacionCadenasDto agrupacion2 = new TareaAgrupacionCadenasDto();
        agrupacion2.setCadenas(new ArrayList<>());
        agrupacion2.getCadenas().add("2");
        agrupacion2.setId(2L);
        agrupaciones.add(agrupacion1);
        agrupaciones.add(agrupacion2);
        return agrupaciones;
    }

    private TareaDto createTarea() {
        TareaDto tarea = new TareaDto();
        tarea.setId(100L);
        return tarea;
    }

    private PtrVentaOnlineEntregaDomicilioResultItemDto createEntregaDomicilioResultItem(int cadena, int empresa,
                String fecha, double importeIVA, double importe, int origen, int seccion) {
        PtrVentaOnlineEntregaDomicilioResultItemDto item = new PtrVentaOnlineEntregaDomicilioResultItemDto();
        item.setCadena(cadena);
        item.setEmpresa(empresa);
        item.setFecha(fecha);
        item.setImporteConIVA(BigDecimal.valueOf(importeIVA));
        item.setImporteSinIVA(BigDecimal.valueOf(importe));
        item.setSeccion(seccion);
        item.setPais(origen);
        return item;
    }

    private PtrVentaTotalizadoResultItemDto createTotalizadoResultItem(int cadena, int empresa,
                String fecha, double importeIVA, double importe, int origen, int seccion) {
        PtrVentaTotalizadoResultItemDto item = new PtrVentaTotalizadoResultItemDto();
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
