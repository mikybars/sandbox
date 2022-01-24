package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionPrecioHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionPrecioHoraMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaConfiguracionPrecioHoraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionPrecioHora;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaConfiguracionPrecioHoraRepositoryCustomImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaConfiguracionPrecioHoraServiceImplTest {

  @Mock
  private TareaConfiguracionPrecioHoraRepositoryCustomImpl tareaConfiguracionPrecioHoraRepositoryCustomImpl;

  @InjectMocks
  private TareaConfiguracionPrecioHoraServiceImpl tareaLocalizacionPresupuestoService;

  @Mock
  private TareaConfiguracionPrecioHoraMapper tareaConfiguracionPrecioHoraMapper;

  @Mock
  private TareaConfiguracionPrecioHoraDecorator tareaConfiguracionPrecioHoraDecorator;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final TareaConfiguracionPrecioHoraDto tareaConfiguracionPrecioHora = mock(
        TareaConfiguracionPrecioHoraDto.class);
    final List<TareaConfiguracionPrecioHoraDto> dtoList = new ArrayList<TareaConfiguracionPrecioHoraDto>();
    final List<TareaConfiguracionPrecioHora> list = new ArrayList<TareaConfiguracionPrecioHora>();
    dtoList.add(tareaConfiguracionPrecioHora);
    when(this.tareaConfiguracionPrecioHoraRepositoryCustomImpl
        .save(ArgumentMatchers.<List<TareaConfiguracionPrecioHora>>any())).thenReturn(list);

    this.tareaLocalizacionPresupuestoService.save(dtoList, tarea);

    verify(this.tareaConfiguracionPrecioHoraRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaConfiguracionPrecioHora>>any());

  }

  @Test
  public void saveConfPrecioHoraResultItemDtoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final ConfPrecioHoraResultItemDto tareaConfiguracionPrecioHora = mock(ConfPrecioHoraResultItemDto.class);
    final List<ConfPrecioHoraResultItemDto> dtoList = new ArrayList<ConfPrecioHoraResultItemDto>();
    final List<TareaConfiguracionPrecioHora> list = new ArrayList<TareaConfiguracionPrecioHora>();
    dtoList.add(tareaConfiguracionPrecioHora);
    when(this.tareaConfiguracionPrecioHoraRepositoryCustomImpl
        .save(ArgumentMatchers.<List<TareaConfiguracionPrecioHora>>any())).thenReturn(list);

    this.tareaLocalizacionPresupuestoService.saveConfPrecioHoraResultItemDto(dtoList, tarea);

    verify(this.tareaConfiguracionPrecioHoraRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaConfiguracionPrecioHora>>any());

  }

}
