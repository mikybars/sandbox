package com.inditex.rrhh.icmclcwb.model.app.calcular.directoventapresencia.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class DirectoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmoTest {

    private final static String SQL_CALCULAR = "SELECT * FROM TABLE WHERE 1";

    @Mock
    private Logger log;

    @Mock
    private TareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom;

    @InjectMocks
    private DirectoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo directoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo;

    @Mock
    private RunAlgoritmoPropertiesDto runAlgoritmoPropertiesDto;

    @Mock
    private TareaCalculoPersonaService tareaCalculoPersonaService;


    @Test
    public void getSqlCalcularTest() {
        when(this.tareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
            .getSqlCalcular(any(AlgoritmoDto.class))).thenReturn(SQL_CALCULAR);
        assertEquals(SQL_CALCULAR, this.directoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo
            .getSqlCalcular(new AlgoritmoDto()));
    }

    @Test
    public void calcularTest() {

        when(this.runAlgoritmoPropertiesDto.getBatchSize()).thenReturn(10);

        final List<IdPersonaLocalDto> personas = new ArrayList<>();
        final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
        personas.add(p1);
        final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
        personas.add(p2);
        final IdPersonaLocalDto p3 = new IdPersonaLocalDto();
        personas.add(p3);
        when(this.tareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
            .ids(any(AlgoritmoDto.class), any(TareaDto.class))).thenReturn(personas);

        final RunTareaDto runTarea = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        runTarea.setTarea(tarea);
        final AlgoritmoDto algoritmo = new AlgoritmoDto();
        this.directoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(this.log, times(1))
            .info("Inicio :: DirectoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo :: Personas: {}", 3);
        verify(this.tareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom,
                times(1))
                    .calcular(algoritmo, tarea, personas);
        verify(this.log, times(1))
            .info("Fin :: DirectoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo :: Personas: {}", 3);
    }

    @Test
    public void calcularExceptionTest() {

        final List<IdPersonaLocalDto> personas = new ArrayList<>();
        final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
        personas.add(p1);
        final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
        personas.add(p2);
        when(this.tareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
            .ids(any(AlgoritmoDto.class), any(TareaDto.class))).thenReturn(personas);

        when(this.runAlgoritmoPropertiesDto.getBatchSize()).thenReturn(2);
        final RuntimeException exception = new RuntimeException("EEEE");
        doThrow(exception)
            .when(this.tareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom)
            .calcular(any(AlgoritmoDto.class), any(TareaDto.class),
                    ArgumentMatchers.<List<IdPersonaLocalDto>>any());

        final RunTareaDto runTarea = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        runTarea.setTarea(tarea);
        final AlgoritmoDto algoritmo = new AlgoritmoDto();
        this.directoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(this.log, times(1))
            .error("DirectoVentaPresenciaPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo :: KO :: Personas: {}", 2,
                    exception);
        verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
                EstadoTareaCalculoPersonaEnum.KO.getDto());
    }

}
