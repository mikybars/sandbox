package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.inditex.aqsw.framework.service.aaa.classic.serviciossso.UserSSO;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoService;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.Programacion;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class ProgramacionServiceImplTest {

    @Mock
    private ProgramacionRepositoryCustom programacionRepositoryCustom;

    @Mock
    private ProgramacionRepository programacionRepository;

    @Mock
    private ProgramacionMapper programacionMapper;

    @Mock
    private ProgramacionAmbitoService programacionAmbitoService;

    @InjectMocks
    private ProgramacionServiceImpl programacionService;

    @Test
    public void createTest() {

        ProgramacionDto programacion = new ProgramacionDto();
        programacion.setProgramacionHuso(TimeUtils.ofZoneId());
        programacion.setNombreUsuario("aaaa");
        programacion.setAmbito(new ArrayList<>());
        programacion.getAmbito().add(new ProgramacionAmbitoDto());
        programacion.setHoraProgramacion(LocalTime.of(0, 0));

        when(programacionMapper.programacionDtoToProgramacion(any(ProgramacionDto.class)))
            .thenReturn(new Programacion());
        when(programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
        when(programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
        when(programacionAmbitoService.create(any(List.class), any(ProgramacionDto.class)))
            .thenReturn(new ArrayList<>());

        ProgramacionDto result = programacionService.create(programacion);
        assertNotNull(result);
        assertNotNull(result.getFechaHoraCreacion());
        assertEquals(DateUtils.truncate(TimeUtils.nowDate(), Calendar.SECOND),
                DateUtils.truncate(Date.from(result.getFechaHoraCreacion().atZone(TimeUtils.ofZone()).toInstant()),
                        Calendar.SECOND));
        assertEquals(programacion.getProgramacionHuso(), result.getProgramacionHuso());
        assertEquals(programacion.getNombreUsuario(), result.getNombreUsuario());
        assertEquals(programacion.getAmbito(), result.getAmbito());
        // Solo se comprueba si existe fecha, la comprobacion de la fecha correcta se hace en otro test de
        // esta clase
        assertNotNull(result.getFechaHoraSiguienteEjecucion());
    }

    @Test
    public void createTestSso() {
        Authentication authentication = Mockito.mock(Authentication.class);
        // TODO [MDELRIO] Buscar manera de replicar este test con el nombre en blanco para cubrir test
        Mockito.when(authentication.getPrincipal()).thenReturn(new UserSSO(null, "name", "url", Arrays.asList()));
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        ProgramacionDto programacion = new ProgramacionDto();
        programacion.setProgramacionHuso(TimeUtils.ofZoneId());
        programacion.setAmbito(new ArrayList<>());
        programacion.getAmbito().add(new ProgramacionAmbitoDto());
        programacion.setHoraProgramacion(LocalTime.of(0, 0));

        when(programacionMapper.programacionDtoToProgramacion(any(ProgramacionDto.class)))
            .thenReturn(new Programacion());
        when(programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
        when(programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
        when(programacionAmbitoService.create(any(List.class), any(ProgramacionDto.class)))
            .thenReturn(new ArrayList<>());

        ProgramacionDto result = programacionService.create(programacion);
        assertNotNull(result);
        assertNotNull(result.getFechaHoraCreacion());
        assertEquals(DateUtils.truncate(TimeUtils.nowDate(), Calendar.SECOND),
                DateUtils.truncate(Date.from(result.getFechaHoraCreacion().atZone(TimeUtils.ofZone()).toInstant()),
                        Calendar.SECOND));
        assertEquals(programacion.getProgramacionHuso(), result.getProgramacionHuso());
        assertEquals(programacion.getNombreUsuario(), result.getNombreUsuario());
        assertEquals(programacion.getAmbito(), result.getAmbito());
        // Solo se comprueba si existe fecha, la comprobacion de la fecha correcta se hace en otro test de
        // esta clase
        assertNotNull(result.getFechaHoraSiguienteEjecucion());
    }


    @Test
    public void createSinProgramacionHusoTest() {

        ProgramacionDto programacion = new ProgramacionDto();
        programacion.setNombreUsuario("aaaa");
        programacion.setAmbito(new ArrayList<>());
        programacion.getAmbito().add(new ProgramacionAmbitoDto());
        programacion.setHoraProgramacion(LocalTime.of(0, 0));

        when(programacionMapper.programacionDtoToProgramacion(any(ProgramacionDto.class)))
            .thenReturn(new Programacion());
        when(programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
        when(programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
        when(programacionAmbitoService.create(any(List.class), any(ProgramacionDto.class)))
            .thenReturn(new ArrayList<>());

        ProgramacionDto result = programacionService.create(programacion);
        assertNotNull(result);
        assertEquals(TimeUtils.ofZoneId(), result.getProgramacionHuso());
    }

    @Test
    public void modifyTest() {

        ProgramacionDto programacion = mock(ProgramacionDto.class);

        when(programacionMapper.programacionDtoToProgramacion(any(ProgramacionDto.class)))
            .thenReturn(new Programacion());
        when(programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
        when(programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
        when(programacionAmbitoService.findByProgramacion(any(ProgramacionDto.class))).thenReturn(new ArrayList<>());

        programacionService.modify(programacion);
        verify(programacionRepository, times(1)).save(any(Programacion.class));

    }

    @Test
    public void fechaSiguienteEjecucionAntesProgramacionTest() {

        // Si el momento actual es anterior a la hora de programación, la fecha resultado debería ser hoy
        ProgramacionDto programacion = mock(ProgramacionDto.class);
        when(programacion.getProgramacionHuso()).thenReturn(TimeUtils.ofZoneId());
        when(programacion.getHoraProgramacion()).thenReturn(LocalTime.of(23, 59, 59));

        LocalDateTime result = programacionService.fechaSiguienteEjecucion(programacion);
        assertTrue(DateUtils.isSameDay(new Date(), Date.from(result.atZone(TimeUtils.ofZone()).toInstant())));

    }

    @Test
    public void fechaSiguienteEjecucionDespuesProgramacionTest() {

        // Si el momento actual es posterior a la hora de programación, la fecha resultado debería ser
        // mañana
        ProgramacionDto programacion = mock(ProgramacionDto.class);
        when(programacion.getProgramacionHuso()).thenReturn(TimeUtils.ofZoneId());
        when(programacion.getHoraProgramacion()).thenReturn(LocalTime.of(0, 0, 1));

        LocalDateTime result = programacionService.fechaSiguienteEjecucion(programacion);
        assertTrue(DateUtils.isSameDay(DateUtils.addDays(new Date(), 1),
                Date.from(result.atZone(TimeUtils.ofZone()).toInstant())));

    }

    @Test
    public void findPendienteTest() {

        when(programacionMapper.programacionToProgramacionDto(any(List.class))).thenReturn(new ArrayList<>());
        when(programacionRepository.findByFechaHoraSiguienteEjecucionBeforeAndActivoTrue(any(LocalDateTime.class)))
            .thenReturn(new ArrayList<>());

        programacionService.findPendiente();
        verify(programacionRepository, times(1))
            .findByFechaHoraSiguienteEjecucionBeforeAndActivoTrue(any(LocalDateTime.class));

    }

    @Test
    public void updateEjecucionTest() {

        ProgramacionDto programacion = new ProgramacionDto();
        programacion.setHoraProgramacion(LocalTime.of(0, 0));
        programacion.setProgramacionHuso(TimeUtils.ofZoneId());

        when(programacionMapper.programacionDtoToProgramacion(any(ProgramacionDto.class)))
            .thenReturn(new Programacion());
        when(programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
        when(programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
        when(programacionAmbitoService.findByProgramacion(any(ProgramacionDto.class))).thenReturn(new ArrayList<>());

        programacionService.updateEjecucion(programacion);

        assertTrue(DateUtils.isSameDay(new Date(),
                Date.from(programacion.getFechaHoraUltimaEjecucion().atZone(TimeUtils.ofZone()).toInstant())));
        assertNotNull(programacion.getFechaHoraSiguienteEjecucion());

    }

    @Test
    public void resetTest() {
        programacionService.reset();
        verify(programacionRepositoryCustom, times(1)).reset();
    }

    @Test
    public void activaTest() {
        programacionService.activa();
        verify(programacionRepositoryCustom, times(1)).activa();
    }

    @Test
    public void activaIdTest() {
        Long id = 1L;
        programacionService.activa(id);
        verify(programacionRepositoryCustom, times(1)).activa(id);
    }

    @Test
    public void desactivaTest() {
        programacionService.desactiva();
        verify(programacionRepositoryCustom, times(1)).desactiva();
    }

    @Test
    public void desactivaIdTest() {
        Long id = 1L;
        programacionService.desactiva(id);
        verify(programacionRepositoryCustom, times(1)).desactiva(id);
    }

}
