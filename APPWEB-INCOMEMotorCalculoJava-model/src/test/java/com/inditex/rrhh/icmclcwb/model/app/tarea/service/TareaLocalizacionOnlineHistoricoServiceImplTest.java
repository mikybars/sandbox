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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionOnlineHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionOnlineHistoricoRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionOnlineHistoricoServiceImplTest {

    @Mock
    private TareaLocalizacionOnlineHistoricoRepositoryCustom tareaLocalizacionOnlineHistoricoRepositoryCustom;
    
    @InjectMocks
    private TareaLocalizacionOnlineHistoricoServiceImpl tareaLocalizacionOnlineHistoricoServiceImpl;
    
    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;
    
    @Mock
    private TareaLocalizacionOnlineHistoricoMapper tareaLocalizacionOnlineHistoricoMapper;
    
    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<TiendaOnlineResultItemDto> genericTiendaResultItemDto = new ArrayList<>();

        tareaLocalizacionOnlineHistoricoServiceImpl.save(genericTiendaResultItemDto, tarea);
        
        verify(tareaLocalizacionOnlineHistoricoMapper, times(1)).getTiendaOnlineResultItemDtoToTareaTiendaOnlineHistorico(any(List.class), any(TareaDto.class));
        verify(tareaLocalizacionOnlineHistoricoMapper, times(1)).getTareaTiendaOnlineHistoricoToLocalizacionOnlineDto(any(List.class));
        verify(tareaLocalizacionOnlineHistoricoRepositoryCustom, times(1)).save(any(List.class));
    }
}
