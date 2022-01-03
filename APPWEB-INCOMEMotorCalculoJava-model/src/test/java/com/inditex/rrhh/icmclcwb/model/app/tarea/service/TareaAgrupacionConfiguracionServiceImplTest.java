package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionConfiguracionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAgrupacionAgrupacionConfiguracionDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionConfiguracionRepositoryCustomImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAgrupacionConfiguracionServiceImplTest {

  @Mock
  private TareaAgrupacionConfiguracionRepositoryCustomImpl tareaAgrupacionConfiguracionRepositoryCustomImpl;

  @InjectMocks
  private TareaAgrupacionConfiguracionServiceImpl tareaAgrupacionConfiguracionServiceImpl;

  @Mock
  private TareaAgrupacionConfiguracionMapper tareaAgrupacionConfiguracionMapper;

  @Mock
  private TareaAgrupacionAgrupacionConfiguracionDecorator tareaAgrupacionConfiguracionMapperDecorator;

  @Test
  public void saveConfiguracionVentaOnlineTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final ConfiguracionVentaOnlineResultItemDto configuracionVentaOnlineResultItemDto = mock(
        ConfiguracionVentaOnlineResultItemDto.class);
    final List<ConfiguracionVentaOnlineResultItemDto> dtoList = new ArrayList<ConfiguracionVentaOnlineResultItemDto>();
    final List<TareaAgrupacionConfiguracion> list = new ArrayList<TareaAgrupacionConfiguracion>();
    dtoList.add(configuracionVentaOnlineResultItemDto);
    when(this.tareaAgrupacionConfiguracionRepositoryCustomImpl
        .save(ArgumentMatchers.<List<TareaAgrupacionConfiguracion>>any())).thenReturn(list);

    this.tareaAgrupacionConfiguracionServiceImpl.saveConfiguracionVentaOnline(dtoList, runTarea);

    verify(this.tareaAgrupacionConfiguracionRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaAgrupacionConfiguracion>>any());
  }

}
