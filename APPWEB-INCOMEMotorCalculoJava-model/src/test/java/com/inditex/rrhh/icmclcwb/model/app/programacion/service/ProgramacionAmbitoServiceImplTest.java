package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbito;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoRepository;

@RunWith(MockitoJUnitRunner.class)
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
        ProgramacionDto programacion = new ProgramacionDto();
        ProgramacionAmbitoDto programacionAmbito = new ProgramacionAmbitoDto();
        ProgramacionAmbitoOrigenDto programacionAmbitoOrigen = new ProgramacionAmbitoOrigenDto();
        ProgramacionAmbitoEmpresaDto programacionAmbitoEmpresa = new ProgramacionAmbitoEmpresaDto();
        ProgramacionAmbitoPersonaDto programacionAmbitoPersona = new ProgramacionAmbitoPersonaDto();

        programacion.setTipoAmbito(TipoAmbitoEnum.PERSONA.getDto());
        programacionAmbito.setIdOrgenization("AT");
        programacionAmbitoOrigen.setCclIdOrigen("38");
        programacionAmbitoEmpresa.setStdIdLegEnt("95");
        programacionAmbitoPersona.setCclIdOrigen("38");
        programacionAmbitoPersona.setStdIdLegEnt("95");
        programacionAmbitoPersona.setCclIdPerson("501");
        programacionAmbitoPersona.setStdOrHrPeriod("2");
        programacionAmbito.setOrigen(Arrays.asList(programacionAmbitoOrigen));
        programacionAmbito.setEmpresa(Arrays.asList(programacionAmbitoEmpresa));
        programacionAmbito.setPersona(Arrays.asList(programacionAmbitoPersona));


        when(programacionAmbitoMapper.mergeProgramacionAmbitoDtoAndProgramacionDtoToProgramacionAmbito(
                any(ProgramacionAmbitoDto.class), any(ProgramacionDto.class))).thenReturn(new ProgramacionAmbito());
        when(programacionAmbitoMapper.programacionAmbitoToProgramacionAmbitoDto(any(ProgramacionAmbito.class)))
            .thenReturn(programacionAmbito);
        when(programacionAmbitoRepository.save(any(ProgramacionAmbito.class))).thenReturn(new ProgramacionAmbito());

        programacionAmbitoServiceMock.create(Arrays.asList(programacionAmbito), programacion);
        verify(programacionAmbitoOrigenService, times(1)).create(Arrays.asList(programacionAmbitoOrigen),
                programacionAmbito);
        verify(programacionAmbitoEmpresaService, times(1)).create(Arrays.asList(programacionAmbitoEmpresa),
                programacionAmbito);
        verify(programacionAmbitoPersonaService, times(1)).create(Arrays.asList(programacionAmbitoPersona),
                programacionAmbito);
    }

    @Test
    public void findByProgramacion() {
        ProgramacionDto programacion = new ProgramacionDto();
        programacion.setId(1L);
        List<ProgramacionAmbitoDto> programacionAmbito = new ArrayList<ProgramacionAmbitoDto>();
        ProgramacionAmbitoDto ambito = new ProgramacionAmbitoDto();
        ambito.setIdOrgenization("test");
        programacionAmbito.add(ambito);
        when(programacionAmbitoRepository.findByProgramacionId(any(Long.class)))
            .thenReturn(Arrays.asList(new ProgramacionAmbito()));
        when(programacionAmbitoMapper.programacionAmbitoToProgramacionAmbitoDto(any(List.class)))
            .thenReturn(programacionAmbito);

        programacionAmbitoServiceMock.findByProgramacion(programacion);

        verify(programacionAmbitoOrigenService, times(1)).findByProgramacionAmbito(any(ProgramacionAmbitoDto.class));
        verify(programacionAmbitoEmpresaService, times(1)).findByProgramacionAmbito(any(ProgramacionAmbitoDto.class));
        verify(programacionAmbitoPersonaService, times(1)).findByProgramacionAmbito(any(ProgramacionAmbitoDto.class));
        verify(programacionAmbitoLocalizacionService, times(1))
            .findByProgramacionAmbito(any(ProgramacionAmbitoDto.class));

    }

}
