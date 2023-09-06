package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTipoHora;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTipoHoraRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaTipoHoraServiceImplTest {

  @Mock
  private TareaTipoHoraRepositoryCustom tareaTipoHoraRepositoryCustom;

  @InjectMocks
  private TareaTipoHoraServiceImpl tareaTipoHoraServiceImpl;

  @Mock
  private TareaTipoHoraMapper tareaTipoHoraMapper;

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
