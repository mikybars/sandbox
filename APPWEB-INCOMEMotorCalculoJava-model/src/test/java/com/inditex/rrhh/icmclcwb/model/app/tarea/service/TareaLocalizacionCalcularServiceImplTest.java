package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.service.TipoDatoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionCalcularMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionCalcular;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionCalcularRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionCalcularServiceImplTest {

  @Mock
  private TareaLocalizacionCalcularRepositoryCustom tareaLocalizacionCalcularRepositoryCustom;

  @InjectMocks
  private TareaLocalizacionCalcularServiceImpl tareaLocalizacionCalcularServiceImpl;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Mock
  private TipoDatoServiceImpl tipoDatoService;

  @Mock
  private TareaLocalizacionCalcularMapper tareaLocalizacionCalcularMapper;

  @Test
  public void saveCerradoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<GenericTiendaResultItemDto> genericTiendaResultItemDto = new ArrayList<>();

    this.tareaLocalizacionCalcularServiceImpl.save(genericTiendaResultItemDto, tarea);
    verify(this.tareaLocalizacionCalcularRepositoryCustom, times(1))
        .save(ArgumentMatchers.<List<TareaLocalizacionCalcular>>any());
  }

}
