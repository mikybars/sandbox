package com.inditex.rrhh.icmclcwb.model.app.calcular.porventasimplificado.v1;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeDesplazamientoBaseV1RepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeDesplazamientoV1RepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PorVentaSimplificadoPorcentajeDesplazamientoBaseV1RunAlgoritmoTest {

    private final static String SQL_CALCULAR = "SELECT * FROM TABLE WHERE 1";

    @Mock
    private Logger log;

    @Mock
    private TareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeDesplazamientoBaseV1RepositoryCustom
        tareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeDesplazamientoBaseV1RepositoryCustom;

    @Mock
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Mock
    private RunAlgoritmoPropertiesDto runAlgoritmoPropertiesDto;

    @InjectMocks
    private PorVentaSimplificadoPorcentajeDesplazamientoBaseV1RunAlgoritmo
        porVentaSimplificadoPorcentajeDesplazamientoBaseV1RunAlgoritmo;

    @Test
    public void getSqlCalcularTest() {
        when(tareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeDesplazamientoBaseV1RepositoryCustom
            .getSqlCalcular(any(AlgoritmoDto.class))).thenReturn(SQL_CALCULAR);

        String result = porVentaSimplificadoPorcentajeDesplazamientoBaseV1RunAlgoritmo.getSqlCalcular(new AlgoritmoDto());

        assertEquals(SQL_CALCULAR, result);
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
        when(tareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeDesplazamientoBaseV1RepositoryCustom
            .ids(any(AlgoritmoDto.class), any(TareaDto.class))).thenReturn(personas);

        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        runTarea.setTarea(tarea);
        AlgoritmoDto algoritmo = new AlgoritmoDto();
        porVentaSimplificadoPorcentajeDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(log, times(1)).info("Inicio :: PorVentaSimplificadoPorcentajeDesplazamientoBaseV1RunAlgoritmo :: Personas: {}", 3);
        verify(tareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeDesplazamientoBaseV1RepositoryCustom, times(1))
            .calcular(algoritmo, tarea, personas);
        verify(log, times(1)).info("Fin :: PorVentaSimplificadoPorcentajeDesplazamientoBaseV1RunAlgoritmo :: Personas: {}", 3);
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
        when(tareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeDesplazamientoBaseV1RepositoryCustom
            .ids(any(AlgoritmoDto.class), any(TareaDto.class))).thenReturn(personas);

        when(runAlgoritmoPropertiesDto.getBatchSize()).thenReturn(2);
        RuntimeException exception = new RuntimeException("EEEE");
        doThrow(exception).when(tareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeDesplazamientoBaseV1RepositoryCustom)
            .calcular(any(AlgoritmoDto.class), any(TareaDto.class), any(List.class));

        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        runTarea.setTarea(tarea);
        AlgoritmoDto algoritmo = new AlgoritmoDto();
        porVentaSimplificadoPorcentajeDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(log, times(1))
            .error("PorVentaSimplificadoPorcentajeDesplazamientoBaseV1RunAlgoritmo :: KO :: Personas: {}", 2, exception);
        verify(tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
    }

}
