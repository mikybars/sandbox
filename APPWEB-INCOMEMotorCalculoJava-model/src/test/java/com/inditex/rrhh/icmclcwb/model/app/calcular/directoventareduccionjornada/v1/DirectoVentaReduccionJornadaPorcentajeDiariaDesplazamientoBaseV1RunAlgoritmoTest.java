package com.inditex.rrhh.icmclcwb.model.app.calcular.directoventareduccionjornada.v1;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmoTest {

    private final static String SQL_CALCULAR = "SELECT * FROM TABLE WHERE 1";

    @Mock
    private Logger log;

    @Mock
    private TareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom;

    @InjectMocks
    private DirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo directoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo;

    @Mock
    private RunAlgoritmoPropertiesDto runAlgoritmoPropertiesDto;

    @Mock
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Test
    public void getSqlCalcularTest() {
        when(this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
            .getSqlCalcular(any(AlgoritmoDto.class))).thenReturn(SQL_CALCULAR);
        assertEquals(SQL_CALCULAR, this.directoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo
            .getSqlCalcular(new AlgoritmoDto()));
    }

    @Test
    public void calcularTest() {

        when(this.runAlgoritmoPropertiesDto.getBatchSize()).thenReturn(10);

        final List<TareaCalculoPersonaDto> personas = new ArrayList<>();
        final TareaCalculoPersonaDto p1 = new TareaCalculoPersonaDto();
        p1.setId("1");
        personas.add(p1);
        final TareaCalculoPersonaDto p2 = new TareaCalculoPersonaDto();
        p1.setId("2");
        personas.add(p2);
        final TareaCalculoPersonaDto p3 = new TareaCalculoPersonaDto();
        p1.setId("3");
        personas.add(p3);
        when(this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
            .ids(any(AlgoritmoDto.class), any(TareaDto.class))).thenReturn(personas);

        final RunTareaDto runTarea = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        runTarea.setTarea(tarea);
        final AlgoritmoDto algoritmo = new AlgoritmoDto();
        this.directoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(this.log, times(1)).info(
                "Inicio :: DirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo :: Personas: {}",
                3);
        verify(this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom,
                times(1))
                    .calcular(algoritmo, tarea, personas);
        verify(this.log, times(1)).info(
                "Fin :: DirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo :: Personas: {}",
                3);
    }

    @Test
    public void calcularExceptionTest() {

        final List<TareaCalculoPersonaDto> personas = new ArrayList<>();
        final TareaCalculoPersonaDto p1 = new TareaCalculoPersonaDto();
        p1.setId("1");
        personas.add(p1);
        final TareaCalculoPersonaDto p2 = new TareaCalculoPersonaDto();
        p1.setId("2");
        personas.add(p2);
        when(this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
            .ids(any(AlgoritmoDto.class), any(TareaDto.class))).thenReturn(personas);

        when(this.runAlgoritmoPropertiesDto.getBatchSize()).thenReturn(2);
        final RuntimeException exception = new RuntimeException("EEEE");
        doThrow(exception)
            .when(this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom)
            .calcular(any(AlgoritmoDto.class), any(TareaDto.class),
                    ArgumentMatchers.<List<TareaCalculoPersonaDto>>any());

        final RunTareaDto runTarea = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        runTarea.setTarea(tarea);
        final AlgoritmoDto algoritmo = new AlgoritmoDto();
        this.directoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(this.log, times(1))
            .error("DirectoVentaReduccionJornadaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo :: KO :: Personas: {}",
                    2, exception);
        verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
                EstadoTareaCalculoPersonaEnum.KO.getDto());
    }

}
