package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionChallengeTipoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionConfiguracionChallengeTipoVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAgrupacionConfiguracionChallengeTipoVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracionChallengeTipoVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAgrupacionConfiguracionChallengeTipoVentaServiceImplTest {

  @Mock
  private TareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl;

  @InjectMocks
  private TareaAgrupacionConfiguracionChallengeTipoVentaServiceImpl tareaAgrupacionConfiguracionChallengeTipoVentaServiceImpl;

  @Mock
  private TareaAgrupacionConfiguracionChallengeTipoVentaMapper tareaAgrupacionConfiguracionChallengeTipoVentaMapper;

  @Mock
  private TareaAgrupacionConfiguracionChallengeTipoVentaDecorator tareaAgrupacionConfiguracionChallengeTipoVentaDecorator;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final TareaAgrupacionConfiguracionChallengeTipoVentaDto tareaAgrupacionConfiguracionChallengeTipoVentaDto = mock(
        TareaAgrupacionConfiguracionChallengeTipoVentaDto.class);
    final List<TareaAgrupacionConfiguracionChallengeTipoVentaDto> dtoList =
        new ArrayList<TareaAgrupacionConfiguracionChallengeTipoVentaDto>();
    final List<TareaAgrupacionConfiguracionChallengeTipoVenta> list = new ArrayList<TareaAgrupacionConfiguracionChallengeTipoVenta>();
    dtoList.add(tareaAgrupacionConfiguracionChallengeTipoVentaDto);
    when(this.tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl
        .save(ArgumentMatchers.<List<TareaAgrupacionConfiguracionChallengeTipoVenta>>any())).thenReturn(list);

    this.tareaAgrupacionConfiguracionChallengeTipoVentaServiceImpl.save(dtoList, tarea);

    verify(this.tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaAgrupacionConfiguracionChallengeTipoVenta>>any());
  }

  @Test
  public void saveConfChTpVentaResultItemDtoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final ConfChTpVentaResultItemDto confChTpVentaResultItemDto = mock(ConfChTpVentaResultItemDto.class);
    final List<ConfChTpVentaResultItemDto> dtoList = new ArrayList<ConfChTpVentaResultItemDto>();
    final List<TareaAgrupacionConfiguracionChallengeTipoVenta> list = new ArrayList<TareaAgrupacionConfiguracionChallengeTipoVenta>();

    dtoList.add(confChTpVentaResultItemDto);
    when(this.tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl
        .save(ArgumentMatchers.<List<TareaAgrupacionConfiguracionChallengeTipoVenta>>any()))
            .thenReturn(list);

    this.tareaAgrupacionConfiguracionChallengeTipoVentaServiceImpl.saveConfChTpVentaResultItemDto(dtoList, tarea);

    verify(this.tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaAgrupacionConfiguracionChallengeTipoVenta>>any());
  }

}
