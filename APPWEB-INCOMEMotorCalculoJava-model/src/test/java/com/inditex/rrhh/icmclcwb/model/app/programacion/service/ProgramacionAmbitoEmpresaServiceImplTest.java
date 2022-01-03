package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoEmpresa;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoEmpresaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProgramacionAmbitoEmpresaServiceImplTest {

  @Mock
  private ProgramacionAmbitoEmpresaMapper programacionAmbitoEmpresaMapper;

  @Mock
  private ProgramacionAmbitoEmpresaRepository programacionAmbitoEmpresaRepository;

  @InjectMocks
  private ProgramacionAmbitoEmpresaServiceImpl programacionAmbitoEmpresaServiceImpl;

  @Test
  public void create() {
    when(this.programacionAmbitoEmpresaMapper
        .mergeProgramacionAmbitoEmpresaDtoAndProgramacionDtoToProgramacionAmbitoEmpresa(
            ArgumentMatchers.<List<ProgramacionAmbitoEmpresaDTO>>any(), any(ProgramacionAmbitoDTO.class)))
                .thenReturn(new ArrayList<ProgramacionAmbitoEmpresa>());
    when(this.programacionAmbitoEmpresaRepository.saveAll(ArgumentMatchers.<List<ProgramacionAmbitoEmpresa>>any()))
        .thenReturn(new ArrayList<ProgramacionAmbitoEmpresa>());

    this.programacionAmbitoEmpresaServiceImpl.create(Arrays.asList(new ProgramacionAmbitoEmpresaDTO()),
        new ProgramacionAmbitoDTO());
    verify(this.programacionAmbitoEmpresaRepository, times(1))
        .saveAll(ArgumentMatchers.<List<ProgramacionAmbitoEmpresa>>any());
  }

  @Test
  public void findByProgramacionAmbito() {
    final ProgramacionAmbitoDTO ambito = new ProgramacionAmbitoDTO();
    ambito.setId(1L);
    when(this.programacionAmbitoEmpresaMapper.programacionAmbitoEmpresaToProgramacionAmbitoEmpresaDto(
        ArgumentMatchers.<List<ProgramacionAmbitoEmpresa>>any()))
            .thenReturn(new ArrayList<ProgramacionAmbitoEmpresaDTO>());
    when(this.programacionAmbitoEmpresaRepository.findByProgramacionAmbitoId(any(Long.class)))
        .thenReturn(new ArrayList<ProgramacionAmbitoEmpresa>());

    this.programacionAmbitoEmpresaServiceImpl.findByProgramacionAmbito(ambito);
    verify(this.programacionAmbitoEmpresaRepository, times(1)).findByProgramacionAmbitoId(any(Long.class));

  }

}
