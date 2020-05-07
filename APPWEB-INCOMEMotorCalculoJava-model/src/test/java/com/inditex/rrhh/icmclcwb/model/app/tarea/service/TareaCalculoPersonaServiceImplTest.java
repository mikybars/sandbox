package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
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

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaCalculoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaCalculoPersonaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersona;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoPersonaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoPersonaRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaCalculoPersonaServiceImplTest {

    @Mock
    private TareaCalculoPersonaRepository tareaCalculoPersonaRepository;

    @Mock
    private TareaCalculoPersonaRepositoryCustom tareaCalculoPersonaRepositoryCustom;

    @InjectMocks
    private TareaCalculoPersonaServiceImpl tareaCalculoPersonaServiceImpl;

    @Mock
    private TareaCalculoPersonaMapper tareaCalculoPersonaMapper;

    @Mock
    private TareaCalculoPersonaDecorator tareaCalculoPersonaDecorator;

    @Test
    public void updateWithEstadoAndidPersonaTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);
        EstadoTareaPersonaDto estadoTareaPersonaDto = mock(EstadoTareaPersonaDto.class);
        List<TareaCalculoPersonaDto> list = new ArrayList<TareaCalculoPersonaDto>();
        tareaCalculoPersonaServiceImpl.updateWithEstadoAndidPersona(list, runTarea, estadoTareaPersonaDto);

        verify(tareaCalculoPersonaRepositoryCustom, times(1)).updateWithEstadoAndidPersona(any(List.class),
                any(RunTareaDto.class), any(EstadoTareaPersonaDto.class));
    }

    @Test
    public void updateWithEstadoTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);
        EstadoTareaPersonaDto estadoTareaPersonaDto = mock(EstadoTareaPersonaDto.class);
        tareaCalculoPersonaServiceImpl.updateWithEstado(runTarea, estadoTareaPersonaDto, estadoTareaPersonaDto);

        verify(tareaCalculoPersonaRepositoryCustom, times(1)).updateWithEstado(any(RunTareaDto.class),
                any(EstadoTareaPersonaDto.class), any(EstadoTareaPersonaDto.class));
    }

    @Test
    public void mergePersonaCalculoByAmbitoTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);
        tareaCalculoPersonaServiceImpl.mergePersonaCalculoByAmbito(runTarea);

        verify(tareaCalculoPersonaRepositoryCustom, times(1)).mergePersonaCalculoByAmbito(any(RunTareaDto.class));
    }

    @Test
    public void mergePersonaCalculoByAmbitoLocalizacionTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);
        tareaCalculoPersonaServiceImpl.mergePersonaCalculoByAmbitoLocalizacion(runTarea);

        verify(tareaCalculoPersonaRepositoryCustom, times(1))
            .mergePersonaCalculoByAmbitoLocalizacion(any(RunTareaDto.class));
    }

    @Test
    public void mergePersonaCalculoByAmbitoPersonaTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);
        tareaCalculoPersonaServiceImpl.mergePersonaCalculoByAmbitoPersona(runTarea);

        verify(tareaCalculoPersonaRepositoryCustom, times(1))
            .mergePersonaCalculoByAmbitoPersona(any(RunTareaDto.class));
    }

    @Test
    public void findByTareaTest() {
        TareaDto tarea = mock(TareaDto.class);
        List<TareaCalculoPersona> list = new ArrayList<TareaCalculoPersona>();
        when(tareaCalculoPersonaRepository.findByTareaId(any(Long.class))).thenReturn(list);
        tareaCalculoPersonaServiceImpl.findByTarea(tarea);

        verify(tareaCalculoPersonaRepository, times(1)).findByTareaId(any(Long.class));
    }

    @Test
    public void findByAlgoritmoTest() {
        TareaDto tarea = mock(TareaDto.class);
        AlgoritmoDto algoritmoDto = mock(AlgoritmoDto.class);
        List<TareaCalculoPersona> list = new ArrayList<TareaCalculoPersona>();
        when(tareaCalculoPersonaRepositoryCustom.findByAlgoritmo(any(TareaDto.class), any(AlgoritmoDto.class)))
            .thenReturn(list);
        tareaCalculoPersonaServiceImpl.findByAlgoritmo(tarea, algoritmoDto);

        verify(tareaCalculoPersonaRepositoryCustom, times(1)).findByAlgoritmo(any(TareaDto.class),
                any(AlgoritmoDto.class));
    }

    @Test
    public void findByTareaAndIdEstadoAndIdTipoPoliticaTest() {
        TareaDto tarea = mock(TareaDto.class);
        String tipoPolitica = TipoPoliticaEnum.ANTIGUEDAD.getIdMeta4();
        List<TareaCalculoPersona> list = new ArrayList<TareaCalculoPersona>();
        when(tareaCalculoPersonaRepositoryCustom.findByTareaAndIdEstadoAndIdTipoPolitica(any(TareaDto.class),
                any(String.class))).thenReturn(list);
        tareaCalculoPersonaServiceImpl.findByTareaAndIdEstadoAndIdTipoPolitica(tarea, tipoPolitica);

        verify(tareaCalculoPersonaRepositoryCustom, times(1))
            .findByTareaAndIdEstadoAndIdTipoPolitica(any(TareaDto.class), any(String.class));
    }

}
