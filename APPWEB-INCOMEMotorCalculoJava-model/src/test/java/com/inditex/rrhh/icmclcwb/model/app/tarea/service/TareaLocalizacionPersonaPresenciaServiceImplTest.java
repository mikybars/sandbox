package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaPresenciaRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionPersonaPresenciaServiceImplTest {

    @Mock
    private TareaLocalizacionPersonaPresenciaRepositoryCustom tareaLocalizacionPersonaPresenciaRepositoryCustom;

    @InjectMocks
    private TareaLocalizacionPersonaPresenciaServiceImpl tareaLocalizacionPersonaPresenciaServiceImpl;

    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;

    @Mock
    private TareaLocalizacionPersonaPresenciaMapper tareaLocalizacionPersonaPresenciaMapper;

    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto = new ArrayList<>();

        tareaLocalizacionPersonaPresenciaServiceImpl.save(genericEmpleadoResultItemDto, tarea);

        verify(tareaLocalizacionPersonaPresenciaMapper, times(1))
            .genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(any(List.class), any(TareaDto.class));
        verify(tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1)).save(any(List.class));
    }

    @Test
    public void savePtrPresenciaDetalleTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<PtrPresenciaDetalleResultItemDto> ptrPresenciaDetalleDto = new ArrayList<>();

        tareaLocalizacionPersonaPresenciaServiceImpl.savePtrPresenciaDetalle(ptrPresenciaDetalleDto, tarea);

        verify(tareaLocalizacionPersonaPresenciaMapper, times(1))
            .presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(any(List.class), any(TareaDto.class));
        verify(tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1)).save(any(List.class));
    }

    @Test
    public void updateActivoTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPersonaPresenciaServiceImpl.updateActivo(runTarea);
        verify(tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1)).updateActivo(any(RunTareaDto.class));
    }

    @Test
    public void updateActivoVacioTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPersonaPresenciaServiceImpl.updateActivoVacio(runTarea);
        verify(tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1)).updateActivoVacio(any(RunTareaDto.class));
    }

    @Test
    public void compensarTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPersonaPresenciaServiceImpl.compensar(runTarea);
        verify(tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1)).compensar(any(RunTareaDto.class));
    }

    @Test
    public void presenciasIncluidoVentaTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPersonaPresenciaServiceImpl.presenciasIncluidoVenta(runTarea);
        verify(tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .presenciasIncluidoVenta(any(RunTareaDto.class));
    }

    @Test
    public void indicadorPresenciaTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPersonaPresenciaServiceImpl.indicadorPresencia(runTarea);
        verify(tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1)).indicadorPresencia(any(RunTareaDto.class));
    }

    @Test
    public void indicadorPresenciaDesplazamientoTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPersonaPresenciaServiceImpl.indicadorPresenciaDesplazamiento(runTarea);
        verify(tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .indicadorPresenciaDesplazamiento(any(RunTareaDto.class));
    }

    @Test
    public void indicadorPresenciaDesplazamientoBaseTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPersonaPresenciaServiceImpl.indicadorPresenciaDesplazamientoBase(runTarea);
        verify(tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .indicadorPresenciaDesplazamientoBase(any(RunTareaDto.class));
    }

    @Test
    public void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPersonaPresenciaServiceImpl
            .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTarea);
        verify(tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(any(RunTareaDto.class));
    }

    @Test
    public void presenciasHorasFijasTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPersonaPresenciaServiceImpl.presenciasHorasFijas(runTarea);
        verify(tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .presenciasHorasFijas(any(RunTareaDto.class));
    }

    @Test
    public void presenciasHorasFijasDesplazamientosTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPersonaPresenciaServiceImpl.presenciasHorasFijasDesplazamientos(runTarea);
        verify(tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .presenciasHorasFijasDesplazamiento(any(RunTareaDto.class));
    }

    @Test
    public void indicadorPersonaPorVentaTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPersonaPresenciaServiceImpl.indicadorPersonaPorVenta(runTarea);
        verify(tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .indicadorPersonaPorVenta(any(RunTareaDto.class));
    }

    @Test
    public void indicadorPersonaPorVentaSimplificadaTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPersonaPresenciaServiceImpl.indicadorPersonaPorVentaSimplificada(runTarea);
        verify(tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .indicadorPersonaPorVentaSimplificada(any(RunTareaDto.class));
    }

}
