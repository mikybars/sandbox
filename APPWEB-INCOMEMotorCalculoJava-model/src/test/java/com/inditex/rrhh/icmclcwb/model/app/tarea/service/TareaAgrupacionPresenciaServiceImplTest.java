package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionPresenciaRepositoryCustomImpl;

@RunWith(MockitoJUnitRunner.class)
public class TareaAgrupacionPresenciaServiceImplTest {

    @Mock
    private TareaAgrupacionPresenciaRepositoryCustomImpl tareaAgrupacionPresenciaRepositoryCustomImpl;

    @InjectMocks
    private TareaAgrupacionPresenciaServiceImpl tareaAgrupacionPresenciaServiceImpl;

    @Test
    public void calcularPresenciasTotalesAgrupacion() {
        TareaDto runTarea = mock(TareaDto.class);
        tareaAgrupacionPresenciaServiceImpl.calcularPresenciasTotalesAgrupacion(runTarea);
        verify(tareaAgrupacionPresenciaRepositoryCustomImpl, times(1))
            .calcularPresenciasTotalesAgrupacion(any(TareaDto.class));
    }

}
