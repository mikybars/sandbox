package com.inditex.rrhh.icmclcwb.model.app.calcular.porventa.v1;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RepositoryCustom;
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
public class PorVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RunAlgoritmoTest {

    private final static String SQL_CALCULAR = "SELECT * FROM TABLE WHERE 1";

    @Mock
    private Logger log;

    @Mock
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Mock
    private TareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RepositoryCustom;

    @Mock
    private RunAlgoritmoPropertiesDto runAlgoritmoPropertiesDto;

    @InjectMocks
    PorVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RunAlgoritmo porVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RunAlgoritmo;

    @Test
    public void getSqlCalcularTest() {
        when(this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RepositoryCustom
            .getSqlCalcular(any(AlgoritmoDto.class))).thenReturn(SQL_CALCULAR);

        final String result = this.porVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RunAlgoritmo
            .getSqlCalcular(new AlgoritmoDto());

        assertEquals(SQL_CALCULAR, result);
    }

    @Test
    public void executeTest() {

        when(this.runAlgoritmoPropertiesDto.getBatchSize()).thenReturn(10);

        final List<IdPersonaLocalDto> personas = new ArrayList<>();
        final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
        personas.add(p1);
        final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
        personas.add(p2);
        final IdPersonaLocalDto p3 = new IdPersonaLocalDto();
        personas.add(p3);
        when(this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RepositoryCustom
            .ids(any(AlgoritmoDto.class), any(TareaDto.class))).thenReturn(personas);

        // El algoritmo no esta desarrollado, por lo que de momento se comprueba que lanza el warning
        final AlgoritmoDto algoritmo = new AlgoritmoDto();
        final RunTareaDto runTarea = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        runTarea.setTarea(tarea);
        this.porVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(this.log, times(1))
            .info("Inicio :: PorVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RunAlgoritmo :: Personas: {}", 3);
        verify(this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RepositoryCustom,
                times(1))
                    .calcular(algoritmo, tarea, personas);
        verify(this.log, times(1))
            .info("Fin :: PorVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RunAlgoritmo :: Personas: {}", 3);
    }

    @Test
    public void executeExceptionTest() {

        final List<IdPersonaLocalDto> personas = new ArrayList<>();
        final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
        personas.add(p1);
        final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
        personas.add(p2);
        when(this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RepositoryCustom
            .ids(any(AlgoritmoDto.class), any(TareaDto.class))).thenReturn(personas);

        when(this.runAlgoritmoPropertiesDto.getBatchSize()).thenReturn(2);
        final RuntimeException exception = new RuntimeException("EEEE");
        doThrow(exception)
            .when(this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RepositoryCustom)
            .calcular(any(AlgoritmoDto.class), any(TareaDto.class),
                    ArgumentMatchers.<List<IdPersonaLocalDto>>any());

        final RunTareaDto runTarea = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        runTarea.setTarea(tarea);
        final AlgoritmoDto algoritmo = new AlgoritmoDto();
        this.porVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(this.log, times(1))
            .error("PorVentaSinDevolucionPorcentajeDiariaDesplazamientoV1RunAlgoritmo :: KO :: Personas: {}", 2,
                    exception);
        verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
                EstadoTareaCalculoPersonaEnum.KO.getDto());
    }

}
