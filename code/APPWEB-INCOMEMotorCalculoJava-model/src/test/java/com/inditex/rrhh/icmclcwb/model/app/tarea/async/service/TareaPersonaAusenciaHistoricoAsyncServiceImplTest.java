package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaAusenciaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaPersonaAusenciaHistoricoAsyncServiceImplTest {
  @Mock
  private TareaPersonaAusenciaHistoricoService tareaPersonaAusenciaHistoricoService;

  @InjectMocks
  private TareaPersonaAusenciaHistoricoAsyncServiceImpl tareaPersonaAusenciaHistoricoAsyncService;

  @Test
  void saveAusenciaResultItemDtoTest() {
    final List<AusenciasResultItemDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaPersonaAusenciaHistoricoAsyncService.saveAusenciaResultItemDto(src, tarea);

    verify(this.tareaPersonaAusenciaHistoricoService).saveAusenciaResultItemDto(anyList(), any(TareaDto.class));

  }

}
