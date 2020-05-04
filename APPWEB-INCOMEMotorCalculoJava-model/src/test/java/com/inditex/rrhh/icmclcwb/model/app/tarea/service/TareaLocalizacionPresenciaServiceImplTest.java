package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresenciaRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionPresenciaServiceImplTest {

    @Mock
    private TareaLocalizacionPresenciaRepositoryCustom tareaLocalizacionPresenciaRepositoryCustom;

    @InjectMocks
    private TareaLocalizacionPresenciaServiceImpl tareaLocalizacionPresenciaServiceImpl;

    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;

    @Test
    public void updateActivoVacioTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPresenciaServiceImpl.updateActivoVacio(runTarea);
        verify(tareaLocalizacionPresenciaRepositoryCustom, times(1)).updateActivoVacio(any(RunTareaDto.class));
    }

    @Test
    public void compensarTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPresenciaServiceImpl.compensar(runTarea);
        verify(tareaLocalizacionPresenciaRepositoryCustom, times(1)).compensar(any(RunTareaDto.class));
    }

    @Test
    public void totalizarTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPresenciaServiceImpl.totalizar(runTarea);
        verify(tareaLocalizacionPresenciaRepositoryCustom, times(1)).totalizar(any(RunTareaDto.class));
    }

    @Test
    public void totalizarEcommerceTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPresenciaServiceImpl.totalizarEcommerce(runTarea);
        verify(tareaLocalizacionPresenciaRepositoryCustom, times(1)).totalizarEcommerce(any(RunTareaDto.class));
    }

    @Test
    public void compensarEcommerceTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPresenciaServiceImpl.compensarEcommerce(runTarea);
        verify(tareaLocalizacionPresenciaRepositoryCustom, times(1)).compensarEcommerce(any(RunTareaDto.class));
    }

    @Test
    public void totalizarEmpleadosPorVentaTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);

        tareaLocalizacionPresenciaServiceImpl.totalizarEmpleadosPorVenta(runTarea);
        verify(tareaLocalizacionPresenciaRepositoryCustom, times(1)).totalizarEmpleadosPorVenta(any(RunTareaDto.class));
    }

}
