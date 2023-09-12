package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoPersonaDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbito;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProgramacionAmbitoServiceImplTest {

  @Mock
  private ProgramacionAmbitoMapper programacionAmbitoMapper;

  @Mock
  private ProgramacionAmbitoRepository programacionAmbitoRepository;

  @Mock
  private ProgramacionAmbitoOrigenService programacionAmbitoOrigenService;

  @Mock
  private ProgramacionAmbitoEmpresaService programacionAmbitoEmpresaService;

  @Mock
  private ProgramacionAmbitoPersonaService programacionAmbitoPersonaService;

  @Mock
  private ProgramacionAmbitoLocalizacionService programacionAmbitoLocalizacionService;

  @InjectMocks
  private ProgramacionAmbitoServiceImpl programacionAmbitoServiceMock;

  @Test
  public void create() {
    final ProgramacionDTO programacion = new ProgramacionDTO();
    final ProgramacionAmbitoDTO programacionAmbito = new ProgramacionAmbitoDTO();
    final ProgramacionAmbitoOrigenDTO programacionAmbitoOrigen = new ProgramacionAmbitoOrigenDTO();
    final ProgramacionAmbitoEmpresaDTO programacionAmbitoEmpresa = new ProgramacionAmbitoEmpresaDTO();
    final ProgramacionAmbitoPersonaDTO programacionAmbitoPersona = new ProgramacionAmbitoPersonaDTO();

    programacion.setTipoAmbito(TipoAmbitoEnum.PERSONA.getDto());
    programacionAmbito.setIdOrganization("AT");
    programacionAmbitoOrigen.setCclIdOrigen("38");
    programacionAmbitoEmpresa.setStdIdLegEnt("95");
    programacionAmbitoPersona.setCclIdOrigen("38");
    programacionAmbitoPersona.setStdIdLegEnt("95");
    programacionAmbitoPersona.setCclIdPerson("501");
    programacionAmbitoPersona.setStdOrHrPeriod("2");
    programacionAmbito.setOrigen(Arrays.asList(programacionAmbitoOrigen));
    programacionAmbito.setEmpresa(Arrays.asList(programacionAmbitoEmpresa));
    programacionAmbito.setPersona(Arrays.asList(programacionAmbitoPersona));

    when(this.programacionAmbitoMapper.mergeProgramacionAmbitoDtoAndProgramacionDtoToProgramacionAmbito(
        any(ProgramacionAmbitoDTO.class), any(ProgramacionDTO.class))).thenReturn(new ProgramacionAmbito());
    when(this.programacionAmbitoMapper.programacionAmbitoToProgramacionAmbitoDto(any(ProgramacionAmbito.class)))
        .thenReturn(programacionAmbito);
    when(this.programacionAmbitoRepository.save(any(ProgramacionAmbito.class)))
        .thenReturn(new ProgramacionAmbito());

    this.programacionAmbitoServiceMock.create(Arrays.asList(programacionAmbito), programacion);
    verify(this.programacionAmbitoOrigenService, times(1)).create(Arrays.asList(programacionAmbitoOrigen),
        programacionAmbito);
    verify(this.programacionAmbitoEmpresaService, times(1)).create(Arrays.asList(programacionAmbitoEmpresa),
        programacionAmbito);
    verify(this.programacionAmbitoPersonaService, times(1)).create(Arrays.asList(programacionAmbitoPersona),
        programacionAmbito);
  }

  @Test
  public void findByProgramacion() {
    final ProgramacionDTO programacion = new ProgramacionDTO();
    programacion.setId(1L);
    final List<ProgramacionAmbitoDTO> programacionAmbito = new ArrayList<ProgramacionAmbitoDTO>();
    final ProgramacionAmbitoDTO ambito = new ProgramacionAmbitoDTO();
    ambito.setIdOrganization("test");
    programacionAmbito.add(ambito);
    when(this.programacionAmbitoRepository.findByProgramacionId(any(Long.class)))
        .thenReturn(Arrays.asList(new ProgramacionAmbito()));
    when(this.programacionAmbitoMapper
        .programacionAmbitoToProgramacionAmbitoDto(ArgumentMatchers.<List<ProgramacionAmbito>>any()))
            .thenReturn(programacionAmbito);

    this.programacionAmbitoServiceMock.findByProgramacion(programacion);

    verify(this.programacionAmbitoOrigenService, times(1))
        .findByProgramacionAmbito(any(ProgramacionAmbitoDTO.class));
    verify(this.programacionAmbitoEmpresaService, times(1))
        .findByProgramacionAmbito(any(ProgramacionAmbitoDTO.class));
    verify(this.programacionAmbitoPersonaService, times(1))
        .findByProgramacionAmbito(any(ProgramacionAmbitoDTO.class));
    verify(this.programacionAmbitoLocalizacionService, times(1))
        .findByProgramacionAmbito(any(ProgramacionAmbitoDTO.class));

  }

}
