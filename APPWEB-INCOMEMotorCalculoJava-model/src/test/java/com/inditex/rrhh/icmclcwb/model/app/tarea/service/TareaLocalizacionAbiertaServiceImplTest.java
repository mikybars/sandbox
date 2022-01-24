package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.service.TipoDatoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionAbiertaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionAbiertaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionAbiertaServiceImplTest {

  @Mock
  private TareaLocalizacionAbiertaRepositoryCustom tareaLocalizacionAbiertaRepositoryCustom;

  @InjectMocks
  private TareaLocalizacionAbiertaServiceImpl tareaLocalizacionAbiertaServiceImpl;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Mock
  private TipoDatoServiceImpl tipoDatoService;

  @Mock
  private TareaLocalizacionAbiertaMapper tareaLocalizacionAbiertaMapper;

  @Test
  public void saveCerradoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final TrabajoDTO trabajo = mock(TrabajoDTO.class);
    final List<IdTipoDatoDto> tipoDato = new ArrayList<>();
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(tipoDato);

    this.tareaLocalizacionAbiertaServiceImpl.saveCerrado(tarea, trabajo);
    verify(this.tareaLocalizacionAbiertaRepositoryCustom, times(1)).saveCerrado(any(TareaDto.class),
        any(TrabajoDTO.class), ArgumentMatchers.<List<Integer>>any());
  }

}
