package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionPresencia;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class TareaAgrupacionPresenciaMapperTest {

    @Autowired
    private TareaAgrupacionPresenciaMapper tareaAgrupacionPresenciaMapper;

    @Test
    public void isInitializedTest() {
        assertNotNull(tareaAgrupacionPresenciaMapper);
    }

    @Test
    public void variasFechasTest() {
        List<PtrPresenciaTotalizadoResultItemDto> list = new ArrayList<>();
        PtrPresenciaTotalizadoResultItemDto unoEnero = createResultItem(1, 1, "2015-01-01",
            250, 38, 4);
        PtrPresenciaTotalizadoResultItemDto dosFebrero = createResultItem(1, 1, "2015-01-02",
            150, 38, 4);
        list.add(unoEnero);
        list.add(dosFebrero);
        List<TareaAgrupacionPresencia> presencias = tareaAgrupacionPresenciaMapper
            .presenciasTotalizadoResponseDtoToTareaAgrupacionPresencia(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(2, presencias.size());
    }

    @Test
    public void variasCadenasMismoGrupoTest() {
        List<PtrPresenciaTotalizadoResultItemDto> list = new ArrayList<>();
        PtrPresenciaTotalizadoResultItemDto cadena1 = createResultItem(1, 1, "2015-01-01",
            250, 38, 4);
        PtrPresenciaTotalizadoResultItemDto cadena163 = createResultItem(163, 1, "2015-01-01",
            150, 38, 4);
        list.add(cadena1);
        list.add(cadena163);
        List<TareaAgrupacionPresencia> presencias = tareaAgrupacionPresenciaMapper
            .presenciasTotalizadoResponseDtoToTareaAgrupacionPresencia(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(1, presencias.size());
        assertEquals(400L, presencias.get(0).getMinutos().longValue());
    }

    @Test
    public void variasCadenasDistintoGrupoTest() {
        List<PtrPresenciaTotalizadoResultItemDto> list = new ArrayList<>();
        PtrPresenciaTotalizadoResultItemDto cadena1 = createResultItem(1, 1, "2015-01-01",
            250, 38, 4);
        PtrPresenciaTotalizadoResultItemDto cadena2 = createResultItem(2, 1, "2015-01-01",
            150, 38, 4);
        list.add(cadena1);
        list.add(cadena2);
        List<TareaAgrupacionPresencia> presencias = tareaAgrupacionPresenciaMapper
            .presenciasTotalizadoResponseDtoToTareaAgrupacionPresencia(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(2, presencias.size());
    }

    @Test
    public void variosPaisesTest() {
        List<PtrPresenciaTotalizadoResultItemDto> list = new ArrayList<>();
        PtrPresenciaTotalizadoResultItemDto pais38 = createResultItem(1, 1, "2015-01-01",
            250, 38, 4);
        PtrPresenciaTotalizadoResultItemDto pais11 = createResultItem(1, 1, "2015-01-01",
            150, 11, 4);
        list.add(pais38);
        list.add(pais11);
        List<TareaAgrupacionPresencia> presencias = tareaAgrupacionPresenciaMapper
            .presenciasTotalizadoResponseDtoToTareaAgrupacionPresencia(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(1, presencias.size());
        assertEquals(400L, presencias.get(0).getMinutos().longValue());
    }

    @Test
    public void variasEmpresasTest() {
        List<PtrPresenciaTotalizadoResultItemDto> list = new ArrayList<>();
        PtrPresenciaTotalizadoResultItemDto empresa1 = createResultItem(1, 1, "2015-01-01",
            250, 38, 4);
        PtrPresenciaTotalizadoResultItemDto empresa3 = createResultItem(1, 3, "2015-01-01",
            150, 38, 4);
        list.add(empresa1);
        list.add(empresa3);
        List<TareaAgrupacionPresencia> presencias = tareaAgrupacionPresenciaMapper
            .presenciasTotalizadoResponseDtoToTareaAgrupacionPresencia(list, createTarea(), createAgrupaciones());
        assertNotNull(presencias);
        assertEquals(1, presencias.size());
        assertEquals(400L, presencias.get(0).getMinutos().longValue());
    }

    @Test
    public void variasSeccionesTest() {
        List<PtrPresenciaTotalizadoResultItemDto> list = new ArrayList<>();
        PtrPresenciaTotalizadoResultItemDto seccion1 = createResultItem(1, 1, "2015-01-01",
            250, 38, 1);
        PtrPresenciaTotalizadoResultItemDto seccion2 = createResultItem(1, 1, "2015-01-01",
            150, 38, 2);
        list.add(seccion1);
        list.add(seccion2);
        List<TareaAgrupacionPresencia> presencias = tareaAgrupacionPresenciaMapper
            .presenciasTotalizadoResponseDtoToTareaAgrupacionPresencia(list, createTarea(), createAgrupaciones());
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

    private PtrPresenciaTotalizadoResultItemDto createResultItem(int cadena, int empresa,
                String fecha, int minutos, int origen, int seccion) {
        PtrPresenciaTotalizadoResultItemDto item = new PtrPresenciaTotalizadoResultItemDto();
        item.setCadena(cadena);
        item.setEmpresa(empresa);
        item.setFecha(fecha);
        item.setMinutos(minutos);
        item.setOrigen(origen);
        item.setSeccion(seccion);
        return item;
    }

}
