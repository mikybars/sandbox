package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionCadenaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAgrupacionCadenaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionCadenaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionCadenaRepositoryCustomImpl;
import com.inditex.rrhh.icmclcwb.rest.client.dto.AgrupacionesOnlineResponseDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAgrupacionCadenaServiceImplTest {

  @Mock
  private TareaAgrupacionCadenaRepositoryCustomImpl tareaAgrupacionCadenaRepositoryCustomImpl;

  @Mock
  private TareaAgrupacionCadenaRepository tareaAgrupacionCadenaRepository;

  @InjectMocks
  private TareaAgrupacionCadenaServiceImpl tareaAgrupacionCadenaServiceImpl;

  @Mock
  private TareaAgrupacionCadenaMapper tareaAgrupacionCadenaMapper;

  @Mock
  private TareaAgrupacionCadenaMapperDecorator tareaAgrupacionCadenaMapperDecorator;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final AgrupacionesOnlineResponseDTO agrupacionesOnlineResponseDTO = mock(AgrupacionesOnlineResponseDTO.class);
    final List<AgrupacionesOnlineResponseDTO> dtoList = new ArrayList<AgrupacionesOnlineResponseDTO>();
    dtoList.add(agrupacionesOnlineResponseDTO);
    final List<TareaAgrupacionCadena> list = new ArrayList<TareaAgrupacionCadena>();
    when(this.tareaAgrupacionCadenaRepositoryCustomImpl.save(ArgumentMatchers.any()))
        .thenReturn(list);

    this.tareaAgrupacionCadenaServiceImpl.save(dtoList, tarea);

    verify(this.tareaAgrupacionCadenaRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.any());
  }

  @Test
  public void findAgrupacionesByTarea() {
    final TareaDto tarea = mock(TareaDto.class);
    final List<TareaAgrupacionCadena> agrupaciones = new ArrayList<>();
    when(this.tareaAgrupacionCadenaRepository.findByTareaId(any(Long.class))).thenReturn(agrupaciones);

    this.tareaAgrupacionCadenaServiceImpl.findAgrupacionesByTarea(tarea);

    verify(this.tareaAgrupacionCadenaRepository, times(1)).findByTareaId(any(Long.class));
  }

}
