/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.service;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.ComisClaseEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalFechaService;
import com.inditex.rrhh.icmclcwb.model.comis.repository.ComisRepositoryCustom;
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
public class ComisServiceImplTest {

    @Mock
    private ComisRepositoryCustom comisRepositoryCustom;

    @InjectMocks
    private ComisServiceImpl comisServiceImpl;

    @Mock
    private TareaAmbitoGlobalFechaService tareaAmbitoGlobalFechaService;

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
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findFechasIncidencias(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findFechasIncidencias(any(TareaDto.class));
    }

    @Test
    public void findFechasDesplazamientos() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findFechasDesplazamientos(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findFechasDesplazamientos(any(TareaDto.class));
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
    public void findCondicionesHistoricoEs() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findCondicionesHistoricoEs(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findCondicionesHistoricoEs(any(TareaDto.class));
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
    public void findCondicionesDesplazamientoEs() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findCondicionesDesplazamientoEs(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findCondicionesDesplazamientoEs(any(TareaDto.class));
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
    public void findCondicionesResaltaSinPrimas() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findCondicionesResaltaSinPrimas(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findCondicionesResaltaSinPrimas(any(TareaDto.class));
    }

    @Test
    public void findCondicionesResaltaEs() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findCondicionesResaltaEs(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findCondicionesResaltaEs(any(TareaDto.class));
    }

    @Test
    public void findCondicionesPrimas() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findCondicionesPrimas(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findCondicionesPrimas(any(TareaDto.class));
    }

    @Test
    public void findBajasIt() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                ArgumentMatchers.any(Long.class), ArgumentMatchers.any(Integer.class)))
                    .thenReturn(new PeriodoDto());

        this.comisServiceImpl.findBajasIt(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findBajasIt(any(TareaDto.class), any(PeriodoDto.class));
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

    @Test
    public void findEmpleadosExterosByClaseTest() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findExternosByClase(runTareaDto, tareaAmbitoDto,
                ComisClaseEmpleadoEnum.EMPLEADO_EXTERNO_BRASIL);
        verify(this.comisRepositoryCustom, times(1)).findExternosByClase(tarea,
                ComisClaseEmpleadoEnum.EMPLEADO_EXTERNO_BRASIL);
    }

    @Test
    public void findEmpleadosExternosByMinIdPersonaTest() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        final Long idEmpleado = 898989L;
        this.comisServiceImpl.findExternosByMinIdPersona(runTareaDto, tareaAmbitoDto,
                idEmpleado);
        verify(this.comisRepositoryCustom, times(1)).findExternosByMinIdPersona(tarea,
                idEmpleado);
    }

    @Test
    public void findBajasItEs() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.comisServiceImpl.findBajasItEs(runTareaDto, tareaAmbitoDto);
        verify(this.comisRepositoryCustom, times(1))
            .findBajasItEs(any(TareaDto.class));
    }

}
