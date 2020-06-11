package com.inditex.rrhh.icmclcwb.model.app.calcular.porventaindividual.v1;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDesplazamientoV1RepositoryCustom;
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
public class PorVentaIndividualPorcentajeDesplazamientoV1RunAlgoritmoTest {

    private final static String SQL_CALCULAR = "SELECT * FROM TABLE WHERE 1";

    @Mock
    private Logger log;

    @Mock
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Mock
    private RunAlgoritmoPropertiesDto runAlgoritmoPropertiesDto;

    @Mock
    private TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoPorVentaIndividualPorcentajeDesplazamientoV1RepositoryCustom;

    @InjectMocks
    private PorVentaIndividualPorcentajeDesplazamientoV1RunAlgoritmo porVentaIndividualPorcentajeDesplazamientoV1RunAlgoritmo;

    @Test
    public void getSqlCalcularTest() {
        when(this.tareaCalculoAlgoritmoPorVentaIndividualPorcentajeDesplazamientoV1RepositoryCustom
            .getSqlCalcular(any(AlgoritmoDto.class))).thenReturn(SQL_CALCULAR);

        final String result = this.porVentaIndividualPorcentajeDesplazamientoV1RunAlgoritmo
            .getSqlCalcular(new AlgoritmoDto());

        assertEquals(SQL_CALCULAR, result);
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
        when(this.tareaCalculoAlgoritmoPorVentaIndividualPorcentajeDesplazamientoV1RepositoryCustom
            .ids(any(AlgoritmoDto.class), any(TareaDto.class))).thenReturn(personas);

        final RunTareaDto runTarea = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        runTarea.setTarea(tarea);
        final AlgoritmoDto algoritmo = new AlgoritmoDto();
        this.porVentaIndividualPorcentajeDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(this.log, times(1)).info(
                "Inicio :: PorVentaIndividualPorcentajeDesplazamientoV1RunAlgoritmo :: Personas: {}",
                3);
        verify(this.tareaCalculoAlgoritmoPorVentaIndividualPorcentajeDesplazamientoV1RepositoryCustom, times(1))
            .calcular(algoritmo, tarea, personas);
        verify(this.log, times(1)).info(
                "Fin :: PorVentaIndividualPorcentajeDesplazamientoV1RunAlgoritmo :: Personas: {}",
                3);
    }

    @Test
    public void calcularExceptionTest() {

        final List<IdPersonaLocalDto> personas = new ArrayList<>();
        final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
        personas.add(p1);
        final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
        personas.add(p2);
        when(this.tareaCalculoAlgoritmoPorVentaIndividualPorcentajeDesplazamientoV1RepositoryCustom
            .ids(any(AlgoritmoDto.class), any(TareaDto.class))).thenReturn(personas);

        when(this.runAlgoritmoPropertiesDto.getBatchSize()).thenReturn(2);
        final RuntimeException exception = new RuntimeException("EEEE");
        doThrow(exception).when(this.tareaCalculoAlgoritmoPorVentaIndividualPorcentajeDesplazamientoV1RepositoryCustom)
            .calcular(any(AlgoritmoDto.class), any(TareaDto.class),
                    ArgumentMatchers.<List<IdPersonaLocalDto>>any());

        final RunTareaDto runTarea = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        runTarea.setTarea(tarea);
        final AlgoritmoDto algoritmo = new AlgoritmoDto();
        this.porVentaIndividualPorcentajeDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(this.log, times(1))
            .error("PorVentaIndividualPorcentajeDesplazamientoV1RunAlgoritmo :: KO :: Personas: {}", 2, exception);
        verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
                EstadoTareaCalculoPersonaEnum.KO.getDto());
    }

}
