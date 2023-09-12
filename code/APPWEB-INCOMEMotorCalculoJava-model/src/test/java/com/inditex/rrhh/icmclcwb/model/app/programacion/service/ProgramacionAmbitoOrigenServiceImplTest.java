package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoOrigen;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoOrigenRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProgramacionAmbitoOrigenServiceImplTest {

  @Mock
  private ProgramacionAmbitoOrigenMapper programacionAmbitooOrigenMapper;

  @Mock
  private ProgramacionAmbitoOrigenRepository programacionAmbitooOrigenRepository;

  @InjectMocks
  private ProgramacionAmbitoOrigenServiceImpl programacionAmbitoOrigenServiceImpl;

  @Test
  public void create() {
    when(this.programacionAmbitooOrigenMapper
        .mergeProgramacionAmbitoOrigenDtoAndProgramacionDtoToProgramacionAmbitoOrigen(
            ArgumentMatchers.<List<ProgramacionAmbitoOrigenDTO>>any(), any(ProgramacionAmbitoDTO.class)))
                .thenReturn(new ArrayList<ProgramacionAmbitoOrigen>());
    when(this.programacionAmbitooOrigenRepository.saveAll(ArgumentMatchers.<List<ProgramacionAmbitoOrigen>>any()))
        .thenReturn(new ArrayList<ProgramacionAmbitoOrigen>());

    this.programacionAmbitoOrigenServiceImpl.create(Arrays.asList(new ProgramacionAmbitoOrigenDTO()),
        new ProgramacionAmbitoDTO());
    verify(this.programacionAmbitooOrigenRepository, times(1))
        .saveAll(ArgumentMatchers.<List<ProgramacionAmbitoOrigen>>any());
  }

  @Test
  public void findByProgramacionAmbito() {
    final ProgramacionAmbitoDTO ambito = new ProgramacionAmbitoDTO();
    ambito.setId(1L);
    when(this.programacionAmbitooOrigenMapper.programacionAmbitoOrigenToProgramacionAmbitoOrigenDto(
        ArgumentMatchers.<List<ProgramacionAmbitoOrigen>>any()))
            .thenReturn(new ArrayList<ProgramacionAmbitoOrigenDTO>());
    when(this.programacionAmbitooOrigenRepository.findByProgramacionAmbitoId(any(Long.class)))
        .thenReturn(new ArrayList<ProgramacionAmbitoOrigen>());

    this.programacionAmbitoOrigenServiceImpl.findByProgramacionAmbito(ambito);
    verify(this.programacionAmbitooOrigenRepository, times(1)).findByProgramacionAmbitoId(any(Long.class));

  }

}
