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

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaAmbitoGlobalLocalizacionServiceImplTest {

    @Mock
    private TareaAmbitoGlobalLocalizacionRepositoryCustom tareaAmbitoGlobalLocalizacionRepositoryCustom;

    @InjectMocks
    private TareaAmbitoGlobalLocalizacionServiceImpl tareaAmbitoGlobalLocalizacionServiceImpl;

    @Test
    public void mergeLocalizacion() {
        RunTareaDto runTareaDto = mock(RunTareaDto.class);
        tareaAmbitoGlobalLocalizacionServiceImpl.mergeLocalizacion(runTareaDto);

        verify(tareaAmbitoGlobalLocalizacionRepositoryCustom, times(1)).mergeLocalizacion(any(RunTareaDto.class));
    }

}
