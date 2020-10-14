package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaPresenciaRepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        final TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto = new ArrayList<>();

        this.tareaLocalizacionPersonaPresenciaServiceImpl.save(genericEmpleadoResultItemDto, tarea);

        verify(this.tareaLocalizacionPersonaPresenciaMapper, times(1))
            .genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(
                    ArgumentMatchers.<List<GenericEmpleadoResultItemDto>>any(), any(TareaDto.class));
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .save(ArgumentMatchers.<List<TareaLocalizacionPersonaPresencia>>any());
    }

    @Test
    public void savePtrPresenciaDetalleTest() {
        final TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        final List<PtrPresenciaDetalleResultItemDto> ptrPresenciaDetalleDto = new ArrayList<>();

        this.tareaLocalizacionPersonaPresenciaServiceImpl.savePtrPresenciaDetalle(ptrPresenciaDetalleDto, tarea);

        verify(this.tareaLocalizacionPersonaPresenciaMapper, times(1))
            .presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(
                    ArgumentMatchers.<List<PtrPresenciaDetalleResultItemDto>>any(), any(TareaDto.class));
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .save(ArgumentMatchers.<List<TareaLocalizacionPersonaPresencia>>any());
    }

    @Test
    public void updateActivoTest() {
        final RunTareaDto runTarea = mock(RunTareaDto.class);

        this.tareaLocalizacionPersonaPresenciaServiceImpl.updateActivo(runTarea);
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1)).updateActivo(any(RunTareaDto.class));
    }

    @Test
    public void updateActivoVacioTest() {
        final RunTareaDto runTarea = mock(RunTareaDto.class);

        this.tareaLocalizacionPersonaPresenciaServiceImpl.updateActivoVacio(runTarea);
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .updateActivoVacio(any(RunTareaDto.class));
    }

    @Test
    public void compensarTest() {
        final RunTareaDto runTarea = mock(RunTareaDto.class);

        this.tareaLocalizacionPersonaPresenciaServiceImpl.compensar(runTarea);
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1)).compensar(any(RunTareaDto.class));
    }

    @Test
    public void presenciasIncluidoVentaTest() {
        final RunTareaDto runTarea = mock(RunTareaDto.class);

        this.tareaLocalizacionPersonaPresenciaServiceImpl.presenciasIncluidoVenta(runTarea);
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .presenciasIncluidoVenta(any(RunTareaDto.class));
    }

    @Test
    public void indicadorPresenciaTest() {
        final RunTareaDto runTarea = mock(RunTareaDto.class);

        this.tareaLocalizacionPersonaPresenciaServiceImpl.indicadorPresencia(runTarea);
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .indicadorPresencia(any(RunTareaDto.class));
    }

    @Test
    public void indicadorPresenciaDesplazamientoTest() {
        final RunTareaDto runTarea = mock(RunTareaDto.class);

        this.tareaLocalizacionPersonaPresenciaServiceImpl.indicadorPresenciaDesplazamiento(runTarea);
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .indicadorPresenciaDesplazamiento(any(RunTareaDto.class));
    }

    @Test
    public void indicadorPresenciaDesplazamientoBaseTest() {
        final RunTareaDto runTarea = mock(RunTareaDto.class);

        this.tareaLocalizacionPersonaPresenciaServiceImpl.indicadorPresenciaDesplazamientoBase(runTarea);
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .indicadorPresenciaDesplazamientoBase(any(RunTareaDto.class));
    }

    @Test
    public void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionTest() {
        final RunTareaDto runTarea = mock(RunTareaDto.class);

        this.tareaLocalizacionPersonaPresenciaServiceImpl
            .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTarea);
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(any(RunTareaDto.class));
    }

    @Test
    public void presenciasHorasFijasTest() {
        final RunTareaDto runTarea = mock(RunTareaDto.class);

        this.tareaLocalizacionPersonaPresenciaServiceImpl.presenciasHorasFijas(runTarea);
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .presenciasHorasFijas(any(RunTareaDto.class));
    }

    @Test
    public void presenciasHorasFijasDesplazamientosTest() {
        final RunTareaDto runTarea = mock(RunTareaDto.class);

        this.tareaLocalizacionPersonaPresenciaServiceImpl.presenciasHorasFijasDesplazamientos(runTarea);
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .presenciasHorasFijasDesplazamiento(any(RunTareaDto.class));
    }

    @Test
    public void indicadorPersonaPorVentaTest() {
        final RunTareaDto runTarea = mock(RunTareaDto.class);

        this.tareaLocalizacionPersonaPresenciaServiceImpl.indicadorPersonaPorVenta(runTarea);
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .indicadorPersonaPorVenta(any(RunTareaDto.class));
    }

    @Test
    public void indicadorPersonaPorVentaSimplificadaTest() {
        final RunTareaDto runTarea = mock(RunTareaDto.class);

        this.tareaLocalizacionPersonaPresenciaServiceImpl.indicadorPersonaPorVentaSimplificada(runTarea);
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .indicadorPersonaPorVentaSimplificada(any(RunTareaDto.class));
    }

    @Test
    public void indicadorDesplazamientoBaseTest() {
        final RunTareaDto runTarea = mock(RunTareaDto.class);

        this.tareaLocalizacionPersonaPresenciaServiceImpl
            .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTarea);
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(any(RunTareaDto.class));
    }

    @Test
    public void indicadorDesplazamientoDirectoVentaTest() {
        final RunTareaDto runTarea = mock(RunTareaDto.class);

        this.tareaLocalizacionPersonaPresenciaServiceImpl
            .indicadorDesplazamientoDirectoVenta(runTarea);
        verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
            .indicadorDesplazamientoDirectoVenta(any(RunTareaDto.class));
    }

}
