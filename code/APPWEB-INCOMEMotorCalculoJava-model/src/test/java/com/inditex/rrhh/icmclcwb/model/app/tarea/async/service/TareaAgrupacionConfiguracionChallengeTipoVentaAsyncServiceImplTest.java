package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionChallengeTipoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionConfiguracionChallengeTipoVentaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaAgrupacionConfiguracionChallengeTipoVentaAsyncServiceImplTest {
  @Mock
  private TareaAgrupacionConfiguracionChallengeTipoVentaService tareaAgrupacionConfiguracionChallengeTipoVentaService;

  @InjectMocks
  private TareaAgrupacionConfiguracionChallengeTipoVentaAsyncServiceImpl tareaAgrupacionConfiguracionChallengeTipoVentaAsyncService;

  @Test
  void saveTest() {
    final List<TareaAgrupacionConfiguracionChallengeTipoVentaDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaAgrupacionConfiguracionChallengeTipoVentaAsyncService.save(src, tarea);

    verify(this.tareaAgrupacionConfiguracionChallengeTipoVentaService).save(anyList(), any(TareaDto.class));
  }

  @Test
  void saveConfChTpVentaResultItemDtoTest() {
    final List<ConfChTpVentaResultItemDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaAgrupacionConfiguracionChallengeTipoVentaAsyncService.saveConfChTpVentaResultItemDto(src, tarea);

    verify(this.tareaAgrupacionConfiguracionChallengeTipoVentaService).saveConfChTpVentaResultItemDto(anyList(), any(TareaDto.class));
  }
}
