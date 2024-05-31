package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaLocalizacionHistoricoAsyncServiceImplTest {
  @Mock
  private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  @InjectMocks
  private TareaLocalizacionHistoricoAsyncServiceImpl tareaLocalizacionHistoricoAsyncService;

  @Test
  void saveTest() {
    final List<TareaLocalizacionHistoricoDto> lista = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionHistoricoAsyncService.save(lista, tarea);

    verify(this.tareaLocalizacionHistoricoService).save(anyList());
  }

  @Test
  void saveGenericTiendaResultItemDtoTest() {
    final List<GenericTiendaResultItemDto> lista = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionHistoricoAsyncService.saveGenericTiendaResultItemDto(lista, tarea);

    verify(this.tareaLocalizacionHistoricoService).save(anyList());
    verify(this.tareaLocalizacionHistoricoService).merge(anyList(), any(TareaDto.class));
  }
}
