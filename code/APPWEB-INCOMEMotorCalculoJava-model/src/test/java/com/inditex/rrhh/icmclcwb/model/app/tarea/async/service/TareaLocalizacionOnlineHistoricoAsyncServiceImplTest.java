package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionOnlineHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaLocalizacionOnlineHistoricoAsyncServiceImplTest {
  @Mock
  private TareaLocalizacionOnlineHistoricoService tareaLocalizacionOnlineHistoricoService;

  @InjectMocks
  private TareaLocalizacionOnlineHistoricoAsyncServiceImpl tareaLocalizacionOnlineHistoricoAsyncService;

  @Test
  void saveTest() {
    final List<TiendaOnlineResultItemDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionOnlineHistoricoAsyncService.save(src, tarea);

    verify(this.tareaLocalizacionOnlineHistoricoService).save(anyList(), any(TareaDto.class));
  }
}
