package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.test.context.junit.jupiter.SpringExtension;

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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        final ProgramacionDto programacion = new ProgramacionDto();
        final ProgramacionAmbitoDto programacionAmbito = new ProgramacionAmbitoDto();
        final ProgramacionAmbitoOrigenDto programacionAmbitoOrigen = new ProgramacionAmbitoOrigenDto();
        final ProgramacionAmbitoEmpresaDto programacionAmbitoEmpresa = new ProgramacionAmbitoEmpresaDto();
        final ProgramacionAmbitoPersonaDto programacionAmbitoPersona = new ProgramacionAmbitoPersonaDto();

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


        when(this.programacionAmbitoMapper.mergeProgramacionAmbitoDtoAndProgramacionDtoToProgramacionAmbito(
                any(ProgramacionAmbitoDto.class), any(ProgramacionDto.class))).thenReturn(new ProgramacionAmbito());
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
        final ProgramacionDto programacion = new ProgramacionDto();
        programacion.setId(1L);
        final List<ProgramacionAmbitoDto> programacionAmbito = new ArrayList<ProgramacionAmbitoDto>();
        final ProgramacionAmbitoDto ambito = new ProgramacionAmbitoDto();
        ambito.setIdOrgenization("test");
        programacionAmbito.add(ambito);
        when(this.programacionAmbitoRepository.findByProgramacionId(any(Long.class)))
            .thenReturn(Arrays.asList(new ProgramacionAmbito()));
        when(this.programacionAmbitoMapper
            .programacionAmbitoToProgramacionAmbitoDto(ArgumentMatchers.<List<ProgramacionAmbito>>any()))
                .thenReturn(programacionAmbito);

        this.programacionAmbitoServiceMock.findByProgramacion(programacion);

        verify(this.programacionAmbitoOrigenService, times(1))
            .findByProgramacionAmbito(any(ProgramacionAmbitoDto.class));
        verify(this.programacionAmbitoEmpresaService, times(1))
            .findByProgramacionAmbito(any(ProgramacionAmbitoDto.class));
        verify(this.programacionAmbitoPersonaService, times(1))
            .findByProgramacionAmbito(any(ProgramacionAmbitoDto.class));
        verify(this.programacionAmbitoLocalizacionService, times(1))
            .findByProgramacionAmbito(any(ProgramacionAmbitoDto.class));

    }

}
