package com.inditex.rrhh.icmclcwb.model.app.calcular.resaltamanual.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoResaltaManualV1RepositoryCustom;
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
public class ResaltaManualV1RunAlgoritmoTest {

    private final static String SQL_CALCULAR = "SQLECT * FROM TABLE WHERE 1";

    @Mock
    private Logger log;

    @Mock
    private TareaCalculoAlgoritmoResaltaManualV1RepositoryCustom tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom;

    @Mock
    private RunAlgoritmoPropertiesDto runAlgoritmoPropertiesDto;

    @Mock
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @InjectMocks
    private ResaltaManualV1RunAlgoritmo resaltaManualV1RunAlgoritmo;

    @Test
    public void getSqlCalcularTest() {
        when(this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom.getSqlCalcular(any(AlgoritmoDTO.class)))
            .thenReturn(SQL_CALCULAR);
        assertEquals(SQL_CALCULAR, this.resaltaManualV1RunAlgoritmo.getSqlCalcular(new AlgoritmoDTO()));
    }

    @Test
    public void calcularTest() {

        final List<IdPersonaLocalDto> personas = new ArrayList<>();
        final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
        personas.add(p1);
        final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
        personas.add(p2);
        final IdPersonaLocalDto p3 = new IdPersonaLocalDto();
        personas.add(p3);
        when(this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom
            .ids(any(AlgoritmoDTO.class), any(TareaDto.class))).thenReturn(personas);

        final RunTareaDto runTarea = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        runTarea.setTarea(tarea);
        final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
        this.resaltaManualV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(this.log, times(1)).info("Inicio :: ResaltaManualV1RunAlgoritmo :: Personas: {}", 3);
        verify(this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom, times(1)).calcular(algoritmo, tarea,
                personas);
        verify(this.log, times(1)).info("Fin :: ResaltaManualV1RunAlgoritmo :: Personas: {}", 3);

    }

    @Test
    public void calcularExceptionTest() {

        final List<IdPersonaLocalDto> personas = new ArrayList<>();
        final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
        personas.add(p1);
        final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
        personas.add(p2);
        when(this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom
            .ids(any(AlgoritmoDTO.class), any(TareaDto.class))).thenReturn(personas);

        final RuntimeException exception = new RuntimeException("EEEE");
        doThrow(exception).when(this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom)
            .calcular(any(AlgoritmoDTO.class), any(TareaDto.class),
                    ArgumentMatchers.<List<IdPersonaLocalDto>>any());

        final RunTareaDto runTarea = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        runTarea.setTarea(tarea);
        final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
        this.resaltaManualV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(this.log, times(1)).error("ResaltaManualV1RunAlgoritmo :: KO :: Personas: {}", 2, exception);
        verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
                EstadoTareaCalculoPersonaEnum.KO.getDto());

    }

}
