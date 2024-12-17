package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLimpiezaService;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaLimpiezaAsynServiceImplTest {
  @Mock
  private TareaLimpiezaService tareaLimpiezaService;

  @InjectMocks
  private TareaLimpiezaAsynServiceImpl tareaLimpiezaAsynService;

  @Test
  void saveTest() {
    final TareaLimpiezaDto tarea = new TareaLimpiezaDto();
    this.tareaLimpiezaAsynService.save(tarea);

    verify(this.tareaLimpiezaService).save(any(TareaLimpiezaDto.class));
  }

  @Test
  void saveTestId() {
    final List<IdTareaDTO> id = new ArrayList<>();

    this.tareaLimpiezaAsynService.save(id);

    verify(this.tareaLimpiezaService).save(anyList());
  }
}
