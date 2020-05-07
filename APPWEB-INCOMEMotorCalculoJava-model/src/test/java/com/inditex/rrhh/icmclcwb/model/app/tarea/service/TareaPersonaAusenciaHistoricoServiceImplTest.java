package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaAusenciaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaAusenciaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaAusenciaHistoricoRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaPersonaAusenciaHistoricoServiceImplTest {

    @Mock
    private TareaPersonaAusenciaHistoricoRepositoryCustom tareaPersonaAusenciaHistoricoRepositoryCustom;

    @InjectMocks
    private TareaPersonaAusenciaHistoricoServiceImpl tareaPersonaAusenciaHistoricoServiceImpl;

    @Mock
    private TareaPersonaAusenciaHistoricoMapper tareaPersonaAusenciaHistoricoMapper;

    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;

    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<TareaPersonaAusenciaHistoricoDto> tareaPersonaAusencia = new ArrayList<>();

        tareaPersonaAusenciaHistoricoServiceImpl.save(tareaPersonaAusencia);
        verify(tareaPersonaAusenciaHistoricoRepositoryCustom, times(1)).save(any(List.class));
    }

    @Test
    public void saveAusenciaResultItemDtoTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<AusenciasResultItemDto> ausenciasResultItemDto = new ArrayList<>();

        tareaPersonaAusenciaHistoricoServiceImpl.saveAusenciaResultItemDto(ausenciasResultItemDto, tarea);
        verify(tareaPersonaAusenciaHistoricoRepositoryCustom, times(1)).save(any(List.class));
    }

}
