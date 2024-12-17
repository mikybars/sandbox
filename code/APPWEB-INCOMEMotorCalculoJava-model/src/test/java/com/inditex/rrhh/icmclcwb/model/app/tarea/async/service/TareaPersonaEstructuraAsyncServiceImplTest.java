package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaPersonaEstructuraAsyncServiceImplTest {

  @InjectMocks
  private TareaPersonaEstructuraAsyncServiceImpl tareaPersonaEstructuraAsyncService;

  @Mock
  private TareaPersonaEstructuraService tareaPersonaEstructuraService;

  @Test
  void saveTest() {
    final List<TareaPersonaEstructuraDto> lista = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaPersonaEstructuraAsyncService.save(lista, tarea);

    verify(this.tareaPersonaEstructuraService).save(anyList(), any(TareaDto.class));
  }

  @Test
  void saveEstructurasComResultItemDtoTest() {
    final List<EstructurasComResultItemDto> estructurasComResultItemDto = new ArrayList<>();
    final TareaDto tareaDto = new TareaDto();

    this.tareaPersonaEstructuraAsyncService.saveEstructurasComResultItemDto(estructurasComResultItemDto, tareaDto);
    verify(this.tareaPersonaEstructuraService).save(anyList(), any(TareaDto.class));
    verify(this.tareaPersonaEstructuraService).mergeEstructurasComResultItemDto(anyList(), any(TareaDto.class));

  }
}
