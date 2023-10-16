package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.GenericAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaCalculoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaCalculoPersonaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersona;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoPersonaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoPersonaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaCalculoPersonaServiceImplTest {

  @Mock
  private TareaCalculoPersonaRepository tareaCalculoPersonaRepository;

  @Mock
  private TareaCalculoPersonaRepositoryCustom tareaCalculoPersonaRepositoryCustom;

  @InjectMocks
  private TareaCalculoPersonaServiceImpl tareaCalculoPersonaServiceImpl;

  @Mock
  private TareaCalculoPersonaMapper tareaCalculoPersonaMapper;

  @Mock
  private TareaCalculoPersonaDecorator tareaCalculoPersonaDecorator;

  @Mock
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Test
  public void updateWithEstadoAndidPersonaTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final EstadoTareaPersonaDto estadoTareaPersonaDto = mock(EstadoTareaPersonaDto.class);
    final List<IdPersonaLocalDto> list = new ArrayList<IdPersonaLocalDto>();
    this.tareaCalculoPersonaServiceImpl.updateWithEstadoAndidPersona(list, runTarea, estadoTareaPersonaDto);

    verify(this.tareaCalculoPersonaRepositoryCustom, times(1)).updateWithEstadoAndidPersona(
        ArgumentMatchers.<List<String>>any(),
        any(RunTareaDto.class), any(EstadoTareaPersonaDto.class));
  }

  @Test
  public void updateWithEstadoTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final EstadoTareaPersonaDto estadoTareaPersonaDto = mock(EstadoTareaPersonaDto.class);
    this.tareaCalculoPersonaServiceImpl.updateWithEstado(runTarea, estadoTareaPersonaDto, estadoTareaPersonaDto);

    verify(this.tareaCalculoPersonaRepositoryCustom, times(1)).updateWithEstado(any(RunTareaDto.class),
        any(EstadoTareaPersonaDto.class), any(EstadoTareaPersonaDto.class));
  }

  @Test
  public void mergePersonaCalculoByAmbitoTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    this.tareaCalculoPersonaServiceImpl.mergePersonaCalculoByAmbito(runTarea);

    verify(this.tareaCalculoPersonaRepositoryCustom, times(1)).mergePersonaCalculoByAmbito(any(RunTareaDto.class));
  }

  @Test
  public void mergePersonaCalculoByAmbitoLocalizacionTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    this.tareaCalculoPersonaServiceImpl.mergePersonaCalculoByAmbitoLocalizacion(runTarea);

    verify(this.tareaCalculoPersonaRepositoryCustom, times(1))
        .mergePersonaCalculoByAmbitoLocalizacion(any(RunTareaDto.class));
  }

  @Test
  public void mergePersonaCalculoByAmbitoPersonaTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    this.tareaCalculoPersonaServiceImpl.mergePersonaCalculoByAmbitoPersona(runTarea);

    verify(this.tareaCalculoPersonaRepositoryCustom, times(1))
        .mergePersonaCalculoByAmbitoPersona(any(RunTareaDto.class));
  }

  @Test
  public void findByTareaTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final List<TareaCalculoPersona> list = new ArrayList<TareaCalculoPersona>();
    when(this.tareaCalculoPersonaRepository.findByTareaId(any(Long.class))).thenReturn(list);
    this.tareaCalculoPersonaServiceImpl.findByTarea(tarea);

    verify(this.tareaCalculoPersonaRepository, times(1)).findByTareaId(any(Long.class));
  }

  @Test
  public void findByAlgoritmoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final AlgoritmoDTO algoritmoDto = mock(AlgoritmoDTO.class);
    final List<IdPersonaLocalDto> list = new ArrayList<IdPersonaLocalDto>();
    when(this.tareaCalculoPersonaRepositoryCustom.findByAlgoritmo(any(TareaDto.class), any(AlgoritmoDTO.class)))
        .thenReturn(list);
    final List<GenericAlgoritmoPropertiesDto> algoritmos = Arrays.asList(new GenericAlgoritmoPropertiesDto());
    when(this.tareaCalculoPersonaRepositoryCustom
        .findIdTipoCalculoAndIdTipoComisionByIdAlgoritmo(any(AlgoritmoDTO.class)))
            .thenReturn(algoritmos);
    this.tareaCalculoPersonaServiceImpl.findByAlgoritmo(tarea, algoritmoDto);

    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).createTempAlgoritmo();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).indexTempAlgoritmo();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).insertTempAlgoritmo(algoritmos);
    verify(this.tareaCalculoPersonaRepositoryCustom, times(1)).findByAlgoritmo(any(TareaDto.class),
        any(AlgoritmoDTO.class));
  }

  @Test
  public void findByTareaAndIdEstadoAndIdTipoPoliticaTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final String tipoPolitica = TipoPoliticaEnum.ANTIGUEDAD.getIdMeta4();
    final List<IdPersonaLocalDto> list = new ArrayList<IdPersonaLocalDto>();
    when(this.tareaCalculoPersonaRepositoryCustom.findByTareaAndIdEstadoAndIdTipoPolitica(any(TareaDto.class),
        any(String.class))).thenReturn(list);
    this.tareaCalculoPersonaServiceImpl.findByTareaAndIdEstadoAndIdTipoPolitica(tarea, tipoPolitica);

    verify(this.tareaCalculoPersonaRepositoryCustom, times(1))
        .findByTareaAndIdEstadoAndIdTipoPolitica(any(TareaDto.class), any(String.class));
  }

}
