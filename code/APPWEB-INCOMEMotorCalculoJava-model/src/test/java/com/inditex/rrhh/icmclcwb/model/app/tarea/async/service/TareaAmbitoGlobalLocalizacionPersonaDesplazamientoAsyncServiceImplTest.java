package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncServiceImplTest {
  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoService tareaAmbitoGlobalLocalizacionPersonaDesplazamientoService;

  @InjectMocks
  private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncServiceImpl tareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService;

  @Test
  void saveGenericEmpleadoResultItemDtoTest() {
    final List<GenericEmpleadoResultItemDto> src = new ArrayList<>();
    final TareaDto tareaDto = new TareaDto();

    this.tareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService.saveGenericEmpleadoResultItemDto(src, tareaDto);

    verify(this.tareaAmbitoGlobalLocalizacionPersonaDesplazamientoService).save(anyList(), any(TareaDto.class));
  }
}
