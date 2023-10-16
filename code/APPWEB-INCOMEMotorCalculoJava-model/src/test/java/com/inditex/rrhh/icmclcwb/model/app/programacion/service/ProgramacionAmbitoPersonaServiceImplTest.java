package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoPersonaDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoPersona;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoPersonaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProgramacionAmbitoPersonaServiceImplTest {

  @Mock
  private ProgramacionAmbitoPersonaMapper programacionAmbitoPersonaMapper;

  @Mock
  private ProgramacionAmbitoPersonaRepository programacionAmbitoPersonaRepository;

  @InjectMocks
  private ProgramacionAmbitoPersonaServiceImpl programacionAmbitoPersonaServiceImpl;

  @Test
  public void create() {
    when(this.programacionAmbitoPersonaMapper
        .mergeProgramacionAmbitoPersonaDtoAndProgramacionDtoToProgramacionAmbitoPersona(
            ArgumentMatchers.<List<ProgramacionAmbitoPersonaDTO>>any(), any(ProgramacionAmbitoDTO.class)))
                .thenReturn(new ArrayList<ProgramacionAmbitoPersona>());
    when(this.programacionAmbitoPersonaRepository.saveAll(ArgumentMatchers.<List<ProgramacionAmbitoPersona>>any()))
        .thenReturn(new ArrayList<ProgramacionAmbitoPersona>());

    this.programacionAmbitoPersonaServiceImpl.create(Arrays.asList(new ProgramacionAmbitoPersonaDTO()),
        new ProgramacionAmbitoDTO());
    verify(this.programacionAmbitoPersonaRepository, times(1))
        .saveAll(ArgumentMatchers.<List<ProgramacionAmbitoPersona>>any());
  }

  @Test
  public void findByProgramacionAmbito() {
    final ProgramacionAmbitoDTO ambito = new ProgramacionAmbitoDTO();
    ambito.setId(1L);
    when(this.programacionAmbitoPersonaMapper.programacionAmbitoPersonaToProgramacionAmbitoPersonaDto(
        ArgumentMatchers.<List<ProgramacionAmbitoPersona>>any()))
            .thenReturn(new ArrayList<ProgramacionAmbitoPersonaDTO>());
    when(this.programacionAmbitoPersonaRepository.findByProgramacionAmbitoId(any(Long.class)))
        .thenReturn(new ArrayList<ProgramacionAmbitoPersona>());

    this.programacionAmbitoPersonaServiceImpl.findByProgramacionAmbito(ambito);
    verify(this.programacionAmbitoPersonaRepository, times(1)).findByProgramacionAmbitoId(any(Long.class));

  }

}
