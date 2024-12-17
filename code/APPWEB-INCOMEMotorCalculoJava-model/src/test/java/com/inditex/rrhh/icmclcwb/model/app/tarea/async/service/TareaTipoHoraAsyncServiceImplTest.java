package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaTipoHoraAsyncServiceImplTest {
  @Mock
  private TareaTipoHoraService tareaTipoHoraService;

  @InjectMocks
  private TareaTipoHoraAsyncServiceImpl tareaTipoHoraAsyncService;

  @Test
  void saveTest() {
    final TiposHoraResponseDto dto = new TiposHoraResponseDto();
    final TareaDto tarea = new TareaDto();

    this.tareaTipoHoraAsyncService.save(dto, tarea);

    verify(this.tareaTipoHoraService).save(any(TiposHoraResponseDto.class), any(TareaDto.class));
  }
}
