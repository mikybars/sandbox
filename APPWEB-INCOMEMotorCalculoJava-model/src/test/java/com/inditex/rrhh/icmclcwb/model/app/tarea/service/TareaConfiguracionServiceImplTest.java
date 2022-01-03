package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaConfiguracionRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaConfiguracionServiceImplTest {

  @Mock
  private TareaConfiguracionRepositoryCustom tareaConfiguracionRepositoryCustom;

  @InjectMocks
  private TareaConfiguracionServiceImpl tareaConfiguracionServiceImpl;

  @Mock
  private TareaConfiguracionMapper tareaConfiguracionMapper;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final ConfiguracionItemDto configuracionItemDto = mock(ConfiguracionItemDto.class);
    final List<ConfiguracionItemDto> dtoList = new ArrayList<ConfiguracionItemDto>();
    final List<TareaConfiguracion> list = new ArrayList<TareaConfiguracion>();
    dtoList.add(configuracionItemDto);
    when(this.tareaConfiguracionRepositoryCustom.save(ArgumentMatchers.<List<TareaConfiguracion>>any()))
        .thenReturn(list);

    this.tareaConfiguracionServiceImpl.save(dtoList, tarea);

    verify(this.tareaConfiguracionRepositoryCustom, times(1))
        .save(ArgumentMatchers.<List<TareaConfiguracion>>any());
  }

}
