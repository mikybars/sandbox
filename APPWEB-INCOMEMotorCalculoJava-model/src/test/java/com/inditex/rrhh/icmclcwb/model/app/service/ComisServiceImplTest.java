/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.service;

import java.time.LocalDate;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.comis.repository.ComisRepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ComisServiceImplTest {

    @Mock
    private ComisRepositoryCustom comisRepositoryCustom;

    @InjectMocks
    private ComisServiceImpl comisServiceImpl;

    private static final String ORIGEN = "1";

    private static final long ID_TAREA = 1L;

    @Test
    public void findPresenciasOrigenAndFecha() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findPresenciasOrigenAndFecha(any(TareaDto.class));
    }

    @Test
    public void findMotivoDesplazamiento() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findMotivoDesplazamiento(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findMotivoDesplazamiento(any(TareaDto.class));
    }

    @Test
    public void findFechasIncidencias() {
        final LocalDate fecha = LocalDate.now();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findFechasIncidencias(fecha, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findFechasIncidencias(any(LocalDate.class));
    }

    @Test
    public void findFechasDesplazamientos() {
        final LocalDate fecha = LocalDate.now();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findFechasDesplazamientos(fecha, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findFechasDesplazamientos(any(LocalDate.class));
    }

    @Test
    public void findCondicionesHistorico() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findCondicionesHistorico(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findCondicionesHistorico(any(TareaDto.class));
    }

    @Test
    public void findCondicionesDesplazamiento() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findCondicionesDesplazamiento(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findCondicionesDesplazamiento(any(TareaDto.class));
    }

    @Test
    public void findCondicionesResalta() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findCondicionesResalta(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findCondicionesResalta(any(TareaDto.class));
    }

    @Test
    public void findBajasIt() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findBajasIt(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findBajasIt(any(TareaDto.class));
    }

    @Test
    public void findCarencia() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findCarencia(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findCarencia(any(TareaDto.class));
    }

}
