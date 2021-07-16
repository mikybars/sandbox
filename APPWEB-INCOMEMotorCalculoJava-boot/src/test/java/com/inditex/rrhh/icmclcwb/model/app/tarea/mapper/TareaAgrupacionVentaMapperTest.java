package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionVenta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class TareaAgrupacionVentaMapperTest {

    @Autowired
    private TareaAgrupacionVentaMapper tareaAgrupacionVentaMapper;

    @Test
    public void ventaTotalizadoVariasFechasTest() {
        final List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
        final PtrVentaTotalizadoResultItemDto unoEnero = this.createTotalizadoResultItem(1, 1, "2015-01-01",
                25000, 22300, 38, 4);
        final PtrVentaTotalizadoResultItemDto dosFebrero = this.createTotalizadoResultItem(1, 1, "2015-01-02",
                15000, 12600, 38, 4);
        list.add(unoEnero);
        list.add(dosFebrero);
        final List<TareaAgrupacionVenta> ventas = this.tareaAgrupacionVentaMapper
            .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, this.createTarea(), this.createAgrupaciones());
        assertNotNull(ventas);
        assertEquals(2, ventas.size());
    }

    @Test
    public void ventaTotalizadoVariasCadenasMismoGrupoTest() {
        final List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
        final PtrVentaTotalizadoResultItemDto cadena1 = this.createTotalizadoResultItem(1, 1, "2015-01-01",
                25000, 22300, 38, 4);
        final PtrVentaTotalizadoResultItemDto cadena163 = this.createTotalizadoResultItem(163, 1, "2015-01-01",
                15000, 12600, 38, 4);
        list.add(cadena1);
        list.add(cadena163);
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
        final PtrVentaTotalizadoResultItemDto cadena1 = this.createTotalizadoResultItem(1, 1, "2015-01-01",
                25000, 22300, 38, 4);
        final PtrVentaTotalizadoResultItemDto cadena2 = this.createTotalizadoResultItem(2, 1, "2015-01-01",
                15000, 12600, 38, 4);
        list.add(cadena1);
        list.add(cadena2);
        final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
            .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, this.createTarea(), this.createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(2, presencias.size());
    }

    @Test
    public void ventaTotalizadoVariosPaisesTest() {
        final List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
        final PtrVentaTotalizadoResultItemDto pais38 = this.createTotalizadoResultItem(1, 1, "2015-01-01",
                25000, 22300, 38, 4);
        final PtrVentaTotalizadoResultItemDto pais11 = this.createTotalizadoResultItem(1, 1, "2015-01-01",
                15000, 12600, 11, 4);
        list.add(pais38);
        list.add(pais11);
        final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
            .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, this.createTarea(), this.createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(2, presencias.size());
    }

    @Test
    public void ventaTotalizadoVariasEmpresasTest() {
        final List<PtrVentaTotalizadoResultItemDto> list = new ArrayList<>();
        final PtrVentaTotalizadoResultItemDto empresa1 = this.createTotalizadoResultItem(1, 1, "2015-01-01",
                25000, 22300, 38, 4);
        final PtrVentaTotalizadoResultItemDto empresa3 = this.createTotalizadoResultItem(1, 3, "2015-01-01",
                15000, 12600, 38, 4);
        list.add(empresa1);
        list.add(empresa3);
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
        final PtrVentaTotalizadoResultItemDto seccion1 = this.createTotalizadoResultItem(1, 1, "2015-01-01",
                25000, 22300, 38, 1);
        final PtrVentaTotalizadoResultItemDto seccion2 = this.createTotalizadoResultItem(1, 1, "2015-01-01",
                15000, 12600, 38, 2);
        list.add(seccion1);
        list.add(seccion2);
        final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
            .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(list, this.createTarea(), this.createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(2, presencias.size());
    }


    @Test
    public void ventaEntregaDomicilioVariasFechasTest() {
        final List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
        final PtrVentaOnlineEntregaDomicilioResultItemDto unoEnero = this.createEntregaDomicilioResultItem(1, 1,
                "2015-01-01",
                25000, 22300, 38, 4);
        final PtrVentaOnlineEntregaDomicilioResultItemDto dosFebrero = this.createEntregaDomicilioResultItem(1, 1,
                "2015-01-02",
                15000, 12600, 38, 4);
        list.add(unoEnero);
        list.add(dosFebrero);
        final List<TareaAgrupacionVenta> ventas = this.tareaAgrupacionVentaMapper
            .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, this.createTarea(),
                    this.createAgrupaciones());
        assertNotNull(ventas);
        assertEquals(2, ventas.size());
    }

    @Test
    public void ventaEntregaDomicilioVariasCadenasMismoGrupoTest() {
        final List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
        final PtrVentaOnlineEntregaDomicilioResultItemDto cadena1 = this.createEntregaDomicilioResultItem(1, 1,
                "2015-01-01",
                25000, 22300, 38, 4);
        final PtrVentaOnlineEntregaDomicilioResultItemDto cadena163 = this.createEntregaDomicilioResultItem(163, 1,
                "2015-01-01",
                15000, 12600, 38, 4);
        list.add(cadena1);
        list.add(cadena163);
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
        final PtrVentaOnlineEntregaDomicilioResultItemDto cadena1 = this.createEntregaDomicilioResultItem(1, 1,
                "2015-01-01",
                25000, 22300, 38, 4);
        final PtrVentaOnlineEntregaDomicilioResultItemDto cadena2 = this.createEntregaDomicilioResultItem(2, 1,
                "2015-01-01",
                15000, 12600, 38, 4);
        list.add(cadena1);
        list.add(cadena2);
        final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
            .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, this.createTarea(),
                    this.createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(2, presencias.size());
    }

    @Test
    public void ventaEntregaDomicilioVariosPaisesTest() {
        final List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
        final PtrVentaOnlineEntregaDomicilioResultItemDto pais38 = this.createEntregaDomicilioResultItem(1, 1,
                "2015-01-01",
                25000, 22300, 38, 4);
        final PtrVentaOnlineEntregaDomicilioResultItemDto pais11 = this.createEntregaDomicilioResultItem(1, 1,
                "2015-01-01",
                15000, 12600, 11, 4);
        list.add(pais38);
        list.add(pais11);
        final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
            .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, this.createTarea(),
                    this.createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(2, presencias.size());
    }

    @Test
    public void ventaEntregaDomicilioVariasEmpresasTest() {
        final List<PtrVentaOnlineEntregaDomicilioResultItemDto> list = new ArrayList<>();
        final PtrVentaOnlineEntregaDomicilioResultItemDto empresa1 = this.createEntregaDomicilioResultItem(1, 1,
                "2015-01-01",
                25000, 22300, 38, 4);
        final PtrVentaOnlineEntregaDomicilioResultItemDto empresa3 = this.createEntregaDomicilioResultItem(1, 3,
                "2015-01-01",
                15000, 12600, 38, 4);
        list.add(empresa1);
        list.add(empresa3);
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
        final PtrVentaOnlineEntregaDomicilioResultItemDto seccion1 = this.createEntregaDomicilioResultItem(1, 1,
                "2015-01-01",
                25000, 22300, 38, 1);
        final PtrVentaOnlineEntregaDomicilioResultItemDto seccion2 = this.createEntregaDomicilioResultItem(1, 1,
                "2015-01-01",
                15000, 12600, 38, 2);
        list.add(seccion1);
        list.add(seccion2);
        final List<TareaAgrupacionVenta> presencias = this.tareaAgrupacionVentaMapper
            .ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(list, this.createTarea(),
                    this.createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(2, presencias.size());
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
