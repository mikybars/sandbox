package com.inditex.rrhh.icmclcwb.model.app.calcular.directoventa.v1;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class DirectoVentaPorcentajeDesplazamientoV1RunAlgoritmoTest {

    private final static String SQL_CALCULAR = "SELECT * FROM TABLE WHERE 1";

    @Mock
    private Logger log;

    @Mock
    private TareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom;

    @Mock
    private RunAlgoritmoPropertiesDto runAlgoritmoPropertiesDto;

    @Mock
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @InjectMocks
    private DirectoVentaPorcentajeDesplazamientoV1RunAlgoritmo directoVentaPorcentajeDesplazamientoV1RunAlgoritmo;

    @Test
    public void getSqlCalcularTest() {
        when(tareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom
            .getSqlCalcular(any(AlgoritmoDto.class))).thenReturn(SQL_CALCULAR);
        assertEquals(SQL_CALCULAR, directoVentaPorcentajeDesplazamientoV1RunAlgoritmo.getSqlCalcular(new AlgoritmoDto()));
    }
    
    @Test
    public void calcularTest() {

        when(runAlgoritmoPropertiesDto.getBatchSize()).thenReturn(10);

        List<TareaCalculoPersonaDto> personas = new ArrayList<>();
        TareaCalculoPersonaDto p1 = new TareaCalculoPersonaDto();
        p1.setId("1");
        personas.add(p1);
        TareaCalculoPersonaDto p2 = new TareaCalculoPersonaDto();
        p1.setId("2");
        personas.add(p2);
        TareaCalculoPersonaDto p3 = new TareaCalculoPersonaDto();
        p1.setId("3");
        personas.add(p3);
        when(tareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom
            .ids(any(AlgoritmoDto.class), any(TareaDto.class))).thenReturn(personas);

        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        runTarea.setTarea(tarea);
        AlgoritmoDto algoritmo = new AlgoritmoDto();
        directoVentaPorcentajeDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(log, times(1)).info("Inicio :: DirectoVentaPorcentajeDesplazamientoV1RunAlgoritmo :: Personas: {}", 3);
        verify(tareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom, times(1))
            .calcular(algoritmo, tarea, personas);
        verify(log, times(1)).info("Fin :: DirectoVentaPorcentajeDesplazamientoV1RunAlgoritmo :: Personas: {}", 3);
    }

    @Test
    public void calcularExceptionTest() {

        List<TareaCalculoPersonaDto> personas = new ArrayList<>();
        TareaCalculoPersonaDto p1 = new TareaCalculoPersonaDto();
        p1.setId("1");
        personas.add(p1);
        TareaCalculoPersonaDto p2 = new TareaCalculoPersonaDto();
        p1.setId("2");
        personas.add(p2);
        when(tareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom
            .ids(any(AlgoritmoDto.class), any(TareaDto.class))).thenReturn(personas);

        when(runAlgoritmoPropertiesDto.getBatchSize()).thenReturn(2);
        RuntimeException exception = new RuntimeException("EEEE");
        doThrow(exception).when(tareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom)
            .calcular(any(AlgoritmoDto.class), any(TareaDto.class), any(List.class));

        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        runTarea.setTarea(tarea);
        AlgoritmoDto algoritmo = new AlgoritmoDto();
        directoVentaPorcentajeDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(log, times(1))
            .error("DirectoVentaPorcentajeDesplazamientoV1RunAlgoritmo :: KO :: Personas: {}", 2, exception);
        verify(tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
    }
    
}
