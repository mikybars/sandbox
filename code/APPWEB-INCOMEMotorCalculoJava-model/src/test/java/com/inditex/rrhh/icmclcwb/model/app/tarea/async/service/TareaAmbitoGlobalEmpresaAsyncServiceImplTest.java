package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaAmbitoGlobalEmpresaAsyncServiceImplTest {
  @Mock
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @InjectMocks
  private TareaAmbitoGlobalEmpresaAsyncServiceImpl tareaAmbitoGlobalEmpresaAsyncService;

  @Test
  void saveTest() {
    final List<TareaAmbitoGlobalEmpresaDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaAmbitoGlobalEmpresaAsyncService.save(src, tarea);

    verify(this.tareaAmbitoGlobalEmpresaService).save(anyList(), any(TareaDto.class));
  }

}
