package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaLocalizacionPersonaPresenciaAsyncServiceImplTest {
  @Mock
  private TareaLocalizacionPersonaPresenciaService tareaLocalizacionPersonaPresenciaService;

  @InjectMocks
  private TareaLocalizacionPersonaPresenciaAsyncServiceImpl tareaLocalizacionPersonaPresenciaAsyncService;

  @Test
  void saveTest() {
    final List<GenericEmpleadoResultItemDto> src = new ArrayList<>();

    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionPersonaPresenciaAsyncService.save(src, tarea);

    verify(this.tareaLocalizacionPersonaPresenciaService).save(anyList(), any(TareaDto.class));
  }

  @Test
  void savePtrPresenciaDetalleTest() {
    final List<PtrPresenciaDetalleResultItemDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();
    final Integer id = 3;

    this.tareaLocalizacionPersonaPresenciaAsyncService.savePtrPresenciaDetalle(src, tarea, id);

    verify(this.tareaLocalizacionPersonaPresenciaService).savePtrPresenciaDetalle(anyList(), any(TareaDto.class), any(Integer.class));
  }

  @Test
  void updateActivoTest() {
    final RunTareaDto tarea = new RunTareaDto();

    this.tareaLocalizacionPersonaPresenciaAsyncService.updateActivo(tarea);

    verify(this.tareaLocalizacionPersonaPresenciaService).updateActivo(any(RunTareaDto.class));
  }

  @Test
  void updateActivoPersonasExternasTest() {
    final RunTareaDto tarea = new RunTareaDto();

    this.tareaLocalizacionPersonaPresenciaAsyncService.updateActivoPersonasExternas(tarea);

    verify(this.tareaLocalizacionPersonaPresenciaService).updateActivoPersonasExternas(any(RunTareaDto.class));
  }
}
