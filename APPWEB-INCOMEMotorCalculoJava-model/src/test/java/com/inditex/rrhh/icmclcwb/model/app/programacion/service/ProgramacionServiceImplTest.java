package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoService;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.Programacion;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionRepositoryCustom;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.aqsw.framework.service.aaa.userdetails.sso.model.UserSSO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        final ProgramacionDto programacion = new ProgramacionDto();
        programacion.setProgramacionHuso(TimeUtils.ofZoneId());
        programacion.setNombreUsuario("aaaa");
        programacion.setAmbito(new ArrayList<>());
        programacion.getAmbito().add(new ProgramacionAmbitoDto());
        programacion.setHoraProgramacion(LocalTime.of(0, 0));

        when(this.programacionMapper.programacionDtoToProgramacion(any(ProgramacionDto.class)))
            .thenReturn(new Programacion());
        when(this.programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
        when(this.programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
        when(this.programacionAmbitoService.create(ArgumentMatchers.<List<ProgramacionAmbitoDto>>any(),
                any(ProgramacionDto.class)))
                    .thenReturn(new ArrayList<>());

        final ProgramacionDto result = this.programacionService.create(programacion);
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
        final Authentication authentication = Mockito.mock(Authentication.class);
        // TODO [MDELRIO] Buscar manera de replicar este test con el nombre en blanco para cubrir test
        Mockito.when(authentication.getPrincipal()).thenReturn(new UserSSO(null, "name", "url", Arrays.asList()));
        final SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        final ProgramacionDto programacion = new ProgramacionDto();
        programacion.setProgramacionHuso(TimeUtils.ofZoneId());
        programacion.setAmbito(new ArrayList<>());
        programacion.getAmbito().add(new ProgramacionAmbitoDto());
        programacion.setHoraProgramacion(LocalTime.of(0, 0));

        when(this.programacionMapper.programacionDtoToProgramacion(any(ProgramacionDto.class)))
            .thenReturn(new Programacion());
        when(this.programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
        when(this.programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
        when(this.programacionAmbitoService.create(ArgumentMatchers.<List<ProgramacionAmbitoDto>>any(),
                any(ProgramacionDto.class)))
                    .thenReturn(new ArrayList<>());

        final ProgramacionDto result = this.programacionService.create(programacion);
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

        final ProgramacionDto programacion = new ProgramacionDto();
        programacion.setNombreUsuario("aaaa");
        programacion.setAmbito(new ArrayList<>());
        programacion.getAmbito().add(new ProgramacionAmbitoDto());
        programacion.setHoraProgramacion(LocalTime.of(0, 0));

        when(this.programacionMapper.programacionDtoToProgramacion(any(ProgramacionDto.class)))
            .thenReturn(new Programacion());
        when(this.programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
        when(this.programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
        when(this.programacionAmbitoService.create(ArgumentMatchers.<List<ProgramacionAmbitoDto>>any(),
                any(ProgramacionDto.class)))
                    .thenReturn(new ArrayList<>());

        final ProgramacionDto result = this.programacionService.create(programacion);
        assertNotNull(result);
        assertEquals(TimeUtils.ofZoneId(), result.getProgramacionHuso());
    }

    @Test
    public void modifyTest() {

        final ProgramacionDto programacion = mock(ProgramacionDto.class);

        when(this.programacionMapper.programacionDtoToProgramacion(any(ProgramacionDto.class)))
            .thenReturn(new Programacion());
        when(this.programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
        when(this.programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
        when(this.programacionAmbitoService.findByProgramacion(any(ProgramacionDto.class)))
            .thenReturn(new ArrayList<>());

        this.programacionService.modify(programacion);
        verify(this.programacionRepository, times(1)).save(any(Programacion.class));

    }

    @Test
    public void fechaSiguienteEjecucionAntesProgramacionTest() {

        // Si el momento actual es anterior a la hora de programación, la fecha resultado debería ser hoy
        final ProgramacionDto programacion = mock(ProgramacionDto.class);
        when(programacion.getProgramacionHuso()).thenReturn(TimeUtils.ofZoneId());
        when(programacion.getHoraProgramacion()).thenReturn(LocalTime.of(23, 59, 59));

        final LocalDateTime result = this.programacionService.fechaSiguienteEjecucion(programacion);
        assertTrue(DateUtils.isSameDay(new Date(), Date.from(result.atZone(TimeUtils.ofZone()).toInstant())));

    }

    @Test
    public void fechaSiguienteEjecucionDespuesProgramacionTest() {

        // Si el momento actual es posterior a la hora de programación, la fecha resultado debería ser
        // mañana
        final ProgramacionDto programacion = mock(ProgramacionDto.class);
        when(programacion.getProgramacionHuso()).thenReturn(TimeUtils.ofZoneId());
        when(programacion.getHoraProgramacion()).thenReturn(LocalTime.of(0, 0, 1));

        final LocalDateTime result = this.programacionService.fechaSiguienteEjecucion(programacion);
        assertTrue(DateUtils.isSameDay(DateUtils.addDays(new Date(), 1),
                Date.from(result.atZone(TimeUtils.ofZone()).toInstant())));

    }

    @Test
    public void findPendienteTest() {

        when(this.programacionMapper.programacionToProgramacionDto(ArgumentMatchers.<List<Programacion>>any()))
            .thenReturn(new ArrayList<>());
        when(this.programacionRepository.findByFechaHoraSiguienteEjecucionBeforeAndActivoTrue(any(LocalDateTime.class)))
            .thenReturn(new ArrayList<>());

        this.programacionService.findPendiente();
        verify(this.programacionRepository, times(1))
            .findByFechaHoraSiguienteEjecucionBeforeAndActivoTrue(any(LocalDateTime.class));

    }

    @Test
    public void updateEjecucionTest() {

        final ProgramacionDto programacion = new ProgramacionDto();
        programacion.setHoraProgramacion(LocalTime.of(0, 0));
        programacion.setProgramacionHuso(TimeUtils.ofZoneId());

        when(this.programacionMapper.programacionDtoToProgramacion(any(ProgramacionDto.class)))
            .thenReturn(new Programacion());
        when(this.programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
        when(this.programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
        when(this.programacionAmbitoService.findByProgramacion(any(ProgramacionDto.class)))
            .thenReturn(new ArrayList<>());

        this.programacionService.updateEjecucion(programacion);

        assertTrue(DateUtils.isSameDay(new Date(),
                Date.from(programacion.getFechaHoraUltimaEjecucion().atZone(TimeUtils.ofZone()).toInstant())));
        verify(this.programacionRepository, times(1)).save(any(Programacion.class));
        verify(this.programacionMapper, times(1)).programacionDtoToProgramacion(programacion);
        verify(this.programacionMapper, times(1)).programacionToProgramacionDto(any(Programacion.class));

    }

    @Test
    public void resetTest() {
        this.programacionService.reset();
        verify(this.programacionRepositoryCustom, times(1)).reset();
    }

    @Test
    public void activaTest() {
        this.programacionService.activa();
        verify(this.programacionRepositoryCustom, times(1)).activa();
    }

    @Test
    public void activaIdTest() {
        final Long id = 1L;
        this.programacionService.activa(id);
        verify(this.programacionRepositoryCustom, times(1)).activa(id);
    }

    @Test
    public void desactivaTest() {
        this.programacionService.desactiva();
        verify(this.programacionRepositoryCustom, times(1)).desactiva();
    }

    @Test
    public void desactivaIdTest() {
        final Long id = 1L;
        this.programacionService.desactiva(id);
        verify(this.programacionRepositoryCustom, times(1)).desactiva(id);
    }

    @Test
    public void updateFechaSiguienteEjecucionTest() {

        final ProgramacionDto programacion1 = new ProgramacionDto();
        programacion1.setHoraProgramacion(LocalTime.of(0, 0));
        programacion1.setProgramacionHuso(TimeUtils.ofZoneId());
        final ProgramacionDto programacion2 = new ProgramacionDto();
        programacion2.setHoraProgramacion(LocalTime.of(0, 0));
        programacion2.setProgramacionHuso(TimeUtils.ofZoneId());
        final ProgramacionDto programacion3 = new ProgramacionDto();
        programacion3.setHoraProgramacion(LocalTime.of(0, 1));
        programacion3.setProgramacionHuso(TimeUtils.ofZoneId());

        final List<ProgramacionDto> programaciones = Arrays.asList(programacion1, programacion2, programacion3);
        this.programacionService.updateFechaSiguienteEjecucion(programaciones);

        final ArgumentCaptor<List<IdProgramacionDto>> idsCaptor = ArgumentCaptor.forClass(List.class);
        final ArgumentCaptor<LocalDateTime> dateCaptor = ArgumentCaptor.forClass(LocalDateTime.class);

        verify(this.programacionRepositoryCustom, times(2))
            .updateFechaSiguienteEjecucion(idsCaptor.capture(), dateCaptor.capture());

        final List<List<IdProgramacionDto>> allIds = idsCaptor.getAllValues();
        assertEquals(1, allIds.stream().filter(x -> x.size() == 2).collect(Collectors.toList()).size());
        assertEquals(1, allIds.stream().filter(x -> x.size() == 1).collect(Collectors.toList()).size());

        final List<LocalDateTime> allDates = dateCaptor.getAllValues();
        final Date tomorrow = DateUtils.addDays(new Date(), 1);
        assertEquals(2, allDates.stream()
            .filter(x -> DateUtils.isSameDay(tomorrow,
                    Date.from(x.atZone(TimeUtils.ofZone()).toInstant())))
            .collect(Collectors.toList())
            .size());
        assertFalse(DateUtils.isSameInstant(
                Date.from(allDates.get(0).atZone(TimeUtils.ofZone()).toInstant()),
                Date.from(allDates.get(1).atZone(TimeUtils.ofZone()).toInstant())));

    }

}
