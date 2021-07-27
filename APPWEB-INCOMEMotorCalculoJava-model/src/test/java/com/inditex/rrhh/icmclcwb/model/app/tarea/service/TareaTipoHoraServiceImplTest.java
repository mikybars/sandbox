package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTipoHora;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTipoHoraRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTipoHoraRepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TareaTipoHoraServiceImplTest {

    @Mock
    private TareaTipoHoraRepositoryCustom tareaTipoHoraRepositoryCustom;

    @Mock
    private TareaTipoHoraRepository tareaTipoHoraRepository;

    @InjectMocks
    private TareaTipoHoraServiceImpl tareaTipoHoraServiceImpl;

    @Mock
    private TareaTipoHoraMapper tareaTipoHoraMapper;

    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;

    @Test
    public void saveOldTest() {
        final TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        final List<PtrPresenciaTiposHorasResultItemDto> tiposHora = new ArrayList<>();
        when(this.tareaTipoHoraMapper.ptrPresenciaTipoHoraResponsesDtoToTareaTipoHoraDto(
                ArgumentMatchers.<List<PtrPresenciaTiposHorasResultItemDto>>any(),
                any(TareaDto.class))).thenReturn(new ArrayList<TareaTipoHora>());

        this.tareaTipoHoraServiceImpl.save(tiposHora, tarea);

        verify(this.tareaTipoHoraRepositoryCustom, times(1))
            .save(ArgumentMatchers.<List<TareaTipoHora>>any());
    }

    @Test
    public void saveTest() {
        final TareaDto tarea = new TareaDto();
        final TiposHoraResponseDto tiposHora = new TiposHoraResponseDto();
        when(this.tareaTipoHoraMapper.tiposHorasResponseDtoToTareaTipoHora(tiposHora, tarea))
            .thenReturn(new ArrayList<>());

        this.tareaTipoHoraServiceImpl.save(tiposHora, tarea);

        verify(this.tareaTipoHoraRepositoryCustom, times(1)).save(ArgumentMatchers.<List<TareaTipoHora>>any());
    }

}
