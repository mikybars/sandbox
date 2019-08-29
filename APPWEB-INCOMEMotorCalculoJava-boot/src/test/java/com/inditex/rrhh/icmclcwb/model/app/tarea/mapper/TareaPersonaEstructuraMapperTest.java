package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoOpcionCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ListaEstructuraDesplazamientosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ListaPorcentajesResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class TareaPersonaEstructuraMapperTest {

    @Autowired
    private TareaPersonaEstructuraMapper tareaPersonaEstructuraMapper;

    @Test
    public void comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDtoSeccion4SinDesplazamientoTest() {

        List<ComisionEmpleadoResultItemDto> items = new ArrayList<>();
        ComisionEmpleadoResultItemDto item = mock(ComisionEmpleadoResultItemDto.class);
        List<ListaPorcentajesResultItemDto> porcentajes = new ArrayList<>();
        ListaPorcentajesResultItemDto porcentajeS4 = mock(ListaPorcentajesResultItemDto.class);
        porcentajes.add(porcentajeS4);
        when(porcentajeS4.getIdSeccion()).thenReturn(AppConstants.SECCION_4.toString());
        when(porcentajeS4.getPorcentaje()).thenReturn("2");
        when(item.getDesplazamiento()).thenReturn(Meta4Constants.FALSE);
        when(item.getIcmListaEstrDespl()).thenReturn(null);
        when(item.getIcmListaPorcentajes()).thenReturn(porcentajes);
        when(item.getIdEmpleado()).thenReturn("E1234");
        when(item.getOrEmpleado()).thenReturn("O1");
        when(item.getIdEmpleadoLocal()).thenReturn("EL12345");
        when(item.getIdOrigen()).thenReturn("38");
        when(item.getIdTipoCalculo()).thenReturn("1");
        when(item.getIdTipoComision()).thenReturn("1");
        when(item.getIdEstructura()).thenReturn("E90909090902");
        items.add(item);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(1222L);

        List<TareaPersonaEstructuraDto> result = tareaPersonaEstructuraMapper.comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(items, tarea);
        assertEquals(3, result.size());
        result.forEach(x -> {
            assertEquals(AppConstants.SECCION_4.toString(), x.getCclIdSeccionEstructura());
            assertEquals(tarea.getId(), x.getIdTarea());
            assertEquals(porcentajeS4.getPorcentaje(), x.getValor());
            assertFalse(x.getDesplazamiento());
            assertFalse(x.getDesplazamientoBase());
            assertNull(x.getEstructuraDesplazamiento());
            assertEquals(item.getIdEmpleado(), x.getStdIdHr());
            assertEquals(item.getIdEmpleadoLocal(), x.getCclIdPerson());
            assertEquals(item.getIdOrigen(), x.getCclIdOrigen());
            assertEquals(item.getIdTipoCalculo(), x.getIcmIdTpCalculo());
            assertEquals(item.getIdTipoComision(), x.getIcmIdTpComision());
            assertEquals(item.getIdEstructura(), x.getIcmIdEstrComision());
        });
        assertEquals(1, result.stream().filter(x -> AppConstants.SECCION_1.toString().equals(x.getCclIdSeccionEfectiva())).toArray().length);
        assertEquals(1, result.stream().filter(x -> AppConstants.SECCION_2.toString().equals(x.getCclIdSeccionEfectiva())).toArray().length);
        assertEquals(1, result.stream().filter(x -> AppConstants.SECCION_3.toString().equals(x.getCclIdSeccionEfectiva())).toArray().length);
    }

    @Test
    public void comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDtoSeccionesSinDesplazamientoTest() {

        List<ComisionEmpleadoResultItemDto> items = new ArrayList<>();
        ComisionEmpleadoResultItemDto item = mock(ComisionEmpleadoResultItemDto.class);
        List<ListaPorcentajesResultItemDto> porcentajes = new ArrayList<>();
        ListaPorcentajesResultItemDto porcentajeS1 = mock(ListaPorcentajesResultItemDto.class);
        porcentajes.add(porcentajeS1);
        when(porcentajeS1.getIdSeccion()).thenReturn(AppConstants.SECCION_1.toString());
        when(item.getDesplazamiento()).thenReturn(Meta4Constants.FALSE);
        when(item.getIcmListaEstrDespl()).thenReturn(null);
        when(item.getIcmListaPorcentajes()).thenReturn(porcentajes);
        items.add(item);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(1222L);

        List<TareaPersonaEstructuraDto> result = tareaPersonaEstructuraMapper.comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(items, tarea);
        assertEquals(1, result.size());
        TareaPersonaEstructuraDto x = result.get(0);
        assertEquals(AppConstants.SECCION_1.toString(), x.getCclIdSeccionEstructura());
        assertEquals(AppConstants.SECCION_1.toString(), x.getCclIdSeccionEfectiva());
        assertEquals(tarea.getId(), x.getIdTarea());
        assertEquals(porcentajeS1.getPorcentaje(), x.getValor());
        assertFalse(x.getDesplazamiento());
        assertFalse(x.getDesplazamientoBase());
        assertNull(x.getEstructuraDesplazamiento());
        assertEquals(item.getIdEmpleado(), x.getStdIdHr());
        assertEquals(item.getIdEmpleadoLocal(), x.getCclIdPerson());
        assertEquals(item.getIdOrigen(), x.getCclIdOrigen());
        assertEquals(item.getIdTipoCalculo(), x.getIcmIdTpCalculo());
        assertEquals(item.getIdTipoComision(), x.getIcmIdTpComision());
        assertEquals(item.getIdEstructura(), x.getIcmIdEstrComision());
    }

    @Test
    public void comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDtoSeccion4ConDesplazamientoTest() {

        List<ComisionEmpleadoResultItemDto> items = new ArrayList<>();
        ComisionEmpleadoResultItemDto item = mock(ComisionEmpleadoResultItemDto.class);
        List<ListaPorcentajesResultItemDto> porcentajes = new ArrayList<>();
        ListaPorcentajesResultItemDto porcentajeS1 = mock(ListaPorcentajesResultItemDto.class);
        List<ListaEstructuraDesplazamientosResultItemDto> desplazamientos = new ArrayList<>();
        ListaEstructuraDesplazamientosResultItemDto desplazamiento = mock(ListaEstructuraDesplazamientosResultItemDto.class);
        List<ListaPorcentajesResultItemDto> porcentajesDesplazamiento = new ArrayList<>();
        ListaPorcentajesResultItemDto porcentajeDesplazamientoS1 = mock(ListaPorcentajesResultItemDto.class);
        when(porcentajeDesplazamientoS1.getPorcentaje()).thenReturn("3");
        when(porcentajeDesplazamientoS1.getIdSeccion()).thenReturn(AppConstants.SECCION_1.toString());
        porcentajesDesplazamiento.add(porcentajeDesplazamientoS1);
        when(desplazamiento.getIdLugarTrabajoDestino()).thenReturn("T8989");
        when(desplazamiento.getIdTipoOpCalculo()).thenReturn(TipoOpcionCalculoEnum.ORIGEN.getIdMeta4());
        when(desplazamiento.getHorasDestino()).thenReturn(Meta4Constants.TRUE);
        when(desplazamiento.getHorasOrigen()).thenReturn(Meta4Constants.FALSE);
        when(desplazamiento.getListaPorcentajes()).thenReturn(porcentajesDesplazamiento);
        desplazamientos.add(desplazamiento);
        porcentajes.add(porcentajeS1);
        when(porcentajeS1.getIdSeccion()).thenReturn(AppConstants.SECCION_1.toString());
        when(porcentajeS1.getPorcentaje()).thenReturn("2");
        when(item.getDesplazamiento()).thenReturn(Meta4Constants.TRUE);
        when(item.getIcmListaEstrDespl()).thenReturn(desplazamientos);
        when(item.getIcmListaPorcentajes()).thenReturn(porcentajes);
        items.add(item);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(1222L);

        List<TareaPersonaEstructuraDto> result = tareaPersonaEstructuraMapper.comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(items, tarea);
        // se generan 2: el de la base y el de la base con el desplazamiento
        assertEquals(2, result.size());
        result.forEach(x -> {
            assertEquals(AppConstants.SECCION_1.toString(), x.getCclIdSeccionEstructura());
            assertEquals(AppConstants.SECCION_1.toString(), x.getCclIdSeccionEfectiva());
            assertEquals(tarea.getId(), x.getIdTarea());
            assertEquals(porcentajeS1.getPorcentaje(), x.getValor());
            assertTrue(x.getDesplazamiento());
            if (x.getEstructuraDesplazamiento() != null) {
                assertEquals(desplazamiento.getIdLugarTrabajoDestino(),
                    x.getEstructuraDesplazamiento().getStdIdWorkLocatDestino());
                assertEquals(porcentajeDesplazamientoS1.getPorcentaje(),
                    x.getEstructuraDesplazamiento().getValor());
                assertEquals(porcentajeDesplazamientoS1.getIdSeccion(),
                    x.getEstructuraDesplazamiento().getCclIdSeccionEfectiva());
                assertEquals(porcentajeDesplazamientoS1.getIdSeccion(),
                    x.getEstructuraDesplazamiento().getCclIdSeccionEstructura());
                assertFalse(x.getDesplazamientoBase());
            } else {
                assertTrue(x.getDesplazamientoBase());
            }
        });
        assertEquals(1, result.stream().filter(x -> !x.getDesplazamientoBase()).toArray().length);
    }

}
