package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionOnlineHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOnlineHistorico;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionOnlineHistoricoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionOnlineHistoricoServiceImplTest {

  @Mock
  private TareaLocalizacionOnlineHistoricoRepositoryCustom tareaLocalizacionOnlineHistoricoRepositoryCustom;

  @InjectMocks
  private TareaLocalizacionOnlineHistoricoServiceImpl tareaLocalizacionOnlineHistoricoServiceImpl;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Mock
  private TareaLocalizacionOnlineHistoricoMapper tareaLocalizacionOnlineHistoricoMapper;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<TiendaOnlineResultItemDto> genericTiendaResultItemDto = new ArrayList<>();

    this.tareaLocalizacionOnlineHistoricoServiceImpl.save(genericTiendaResultItemDto, tarea);

    verify(this.tareaLocalizacionOnlineHistoricoMapper, times(1))
        .getTiendaOnlineResultItemDtoToTareaTiendaOnlineHistorico(
            ArgumentMatchers.<List<TiendaOnlineResultItemDto>>any(), any(TareaDto.class));
    verify(this.tareaLocalizacionOnlineHistoricoMapper, times(1))
        .getTareaTiendaOnlineHistoricoToLocalizacionOnlineDto(
            ArgumentMatchers.<List<TareaLocalizacionOnlineHistorico>>any());
    verify(this.tareaLocalizacionOnlineHistoricoRepositoryCustom, times(1))
        .save(ArgumentMatchers.<List<TareaLocalizacionOnlineHistorico>>any());
  }

}
