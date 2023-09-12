package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraPoliticaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraPoliticaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaPersonaEstructuraPoliticaServiceImplTest {

  @Mock
  private TareaPersonaEstructuraPoliticaRepositoryCustom tareaPersonaEstructuraPoliticaRepositoryCustom;

  @InjectMocks
  private TareaPersonaEstructuraPoliticaServiceImpl tareaPersonaEstructuraPoliticaServiceImpl;

  @Mock
  private TareaPersonaEstructuraPoliticaMapper tareaPersonaEstructuraPoliticaMapper;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  private TareaDto createTarea() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(190L);
    return tarea;
  }

  private List<TipoPoliticaEnum> createPoliticasList() {
    return Arrays.asList(TipoPoliticaEnum.CARENCIA, TipoPoliticaEnum.HORAS_FIJAS);
  }

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<ComisionEmpleadoResultItemDto> comisionEmpleado = new ArrayList<>();

    this.tareaPersonaEstructuraPoliticaServiceImpl.save(comisionEmpleado, tarea);
    verify(this.tareaPersonaEstructuraPoliticaRepositoryCustom, times(1)).save(ArgumentMatchers
        .<List<TareaPersonaEstructuraPolitica>>any());
  }

  @Test
  public void saveEstructurasPolResultItemDtoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<EstructurasPolResultItemDto> estructurasPol = new ArrayList<>();

    this.tareaPersonaEstructuraPoliticaServiceImpl.saveEstructurasPolResultItemDto(estructurasPol, tarea);
    verify(this.tareaPersonaEstructuraPoliticaRepositoryCustom, times(1)).save(ArgumentMatchers
        .<List<TareaPersonaEstructuraPolitica>>any());
  }

  @Test
  void existePoliticaTest() {
    final TareaDto tarea = this.createTarea();
    final List<TipoPoliticaEnum> politicas = this.createPoliticasList();
    this.tareaPersonaEstructuraPoliticaServiceImpl.existePolitica(tarea, politicas);
    verify(this.tareaPersonaEstructuraPoliticaRepositoryCustom, times(1)).existePolitica(tarea, politicas);
  }

  @Test
  void existePoliticaResultTest() {
    when(this.tareaPersonaEstructuraPoliticaRepositoryCustom
        .existePolitica(any(TareaDto.class), ArgumentMatchers.<List<TipoPoliticaEnum>>any())).thenReturn(true);
    final Boolean result = this.tareaPersonaEstructuraPoliticaServiceImpl
        .existePolitica(this.createTarea(), this.createPoliticasList());
    assertTrue(result);
  }

}
