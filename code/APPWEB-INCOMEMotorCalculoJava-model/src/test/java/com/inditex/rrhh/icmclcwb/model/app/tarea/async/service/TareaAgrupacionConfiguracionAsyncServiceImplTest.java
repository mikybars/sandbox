package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionConfiguracionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaAgrupacionConfiguracionAsyncServiceImplTest {
  @Mock
  private TareaAgrupacionConfiguracionService tareaAgrupacionConfiguracionService;

  @InjectMocks
  private TareaAgrupacionConfiguracionAsyncServiceImpl tareaAgrupacionConfiguracionAsyncService;

  @Test
  void saveAgrupacionConfiguracionDtoTest() {
    final List<ConfiguracionVentaOnlineResultItemDto> data = new ArrayList<>();
    final RunTareaDto tarea = new RunTareaDto();

    this.tareaAgrupacionConfiguracionAsyncService.saveAgrupacionConfiguracionDto(data, tarea);

    verify(this.tareaAgrupacionConfiguracionService).saveConfiguracionVentaOnline(anyList(), any(RunTareaDto.class));
  }

}
