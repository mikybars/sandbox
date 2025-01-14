package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncServiceImplTest {

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaService tareaAmbitoGlobalLocalizacionPersonaPresenciaService;

  @InjectMocks
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncServiceImpl tareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService;

  @Test
  void savePtrPresenciaEmpleadosTiendaResponseTest() {
    final TareaDto tarea = new TareaDto();

    this.tareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService.savePtrPresenciaEmpleadosTiendaResponse(
        PtrPresenciaEmpleadosTiendaResponseDto.builder().build(), tarea);

    verify(this.tareaAmbitoGlobalLocalizacionPersonaPresenciaService).save(any(PtrPresenciaEmpleadosTiendaResponseDto.class),
        any(TareaDto.class));

  }
}
