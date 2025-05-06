package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionCadenaService;
import com.inditex.rrhh.icmclcwb.rest.client.dto.AgrupacionesOnlineResponseDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaAgrupacionCadenaAsyncServiceImplTest {
  @Mock
  private TareaAgrupacionCadenaService tareaAgrupacionCadenaService;

  @InjectMocks
  private TareaAgrupacionCadenaAsyncServiceImpl tareaAgrupacionCadenaAsyncService;

  @Test
  void saveTest() {
    final List<AgrupacionesOnlineResponseDTO> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaAgrupacionCadenaAsyncService.save(src, tarea);

    verify(this.tareaAgrupacionCadenaService).save(anyList(), any(TareaDto.class));

  }
}
