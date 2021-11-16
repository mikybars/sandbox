package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoLocalizacionDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoLocalizacion;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoLocalizacionRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProgramacionAmbitoLocalizacionServiceImplTest {

  @Mock
  private ProgramacionAmbitoLocalizacionMapper programacionAmbitoLocalizacionMapper;

  @Mock
  private ProgramacionAmbitoLocalizacionRepository programacionAmbitoLocalizacionRepository;

  @InjectMocks
  private ProgramacionAmbitoLocalizacionServiceImpl programacionAmbitoLocalizacionServiceImpl;

  @Test
  public void create() {
    when(this.programacionAmbitoLocalizacionMapper
        .mergeProgramacionAmbitoLocalizacionDtoAndProgramacionDtoToProgramacionAmbitoLocalizacion(
            ArgumentMatchers.<List<ProgramacionAmbitoLocalizacionDTO>>any(), any(ProgramacionAmbitoDTO.class)))
                .thenReturn(new ArrayList<ProgramacionAmbitoLocalizacion>());
    when(this.programacionAmbitoLocalizacionRepository
        .saveAll(ArgumentMatchers.<List<ProgramacionAmbitoLocalizacion>>any()))
            .thenReturn(new ArrayList<ProgramacionAmbitoLocalizacion>());

    this.programacionAmbitoLocalizacionServiceImpl.create(Arrays.asList(new ProgramacionAmbitoLocalizacionDTO()),
        new ProgramacionAmbitoDTO());
    verify(this.programacionAmbitoLocalizacionRepository, times(1))
        .saveAll(ArgumentMatchers.<List<ProgramacionAmbitoLocalizacion>>any());
  }

  @Test
  public void findByProgramacionAmbito() {
    final ProgramacionAmbitoDTO ambito = new ProgramacionAmbitoDTO();
    ambito.setId(1L);
    when(this.programacionAmbitoLocalizacionMapper
        .programacionAmbitoLocalizacionToProgramacionAmbitoLocalizacionDto(
            ArgumentMatchers.<List<ProgramacionAmbitoLocalizacion>>any()))
                .thenReturn(new ArrayList<ProgramacionAmbitoLocalizacionDTO>());
    when(this.programacionAmbitoLocalizacionRepository.findByProgramacionAmbitoId(any(Long.class)))
        .thenReturn(new ArrayList<ProgramacionAmbitoLocalizacion>());

    this.programacionAmbitoLocalizacionServiceImpl.findByProgramacionAmbito(ambito);
    verify(this.programacionAmbitoLocalizacionRepository, times(1)).findByProgramacionAmbitoId(any(Long.class));

  }

}
