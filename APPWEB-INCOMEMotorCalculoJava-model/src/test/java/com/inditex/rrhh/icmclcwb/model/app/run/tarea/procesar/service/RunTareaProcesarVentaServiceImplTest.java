package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaVentaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class RunTareaProcesarVentaServiceImplTest {

    @Mock
    private TareaLocalizacionVentaRepositoryCustom tareaLocalizacionVentaRepositoryCustom;

    @Mock
    private TareaLocalizacionPersonaVentaRepositoryCustom tareaLocalizacionPersonaVentaRepositoryCustom;

    @InjectMocks
    RunTareaProcesarVentaServiceImpl runTareaProcesarVentaService;

    @Test
    void totalizarVentaSinDevolucionPersonaLocalizacionTest(@Random final RunTareaDto runTarea) {
        this.runTareaProcesarVentaService.totalizarVentaSinDevolucionPersonaLocalizacion(runTarea);
        verify(this.tareaLocalizacionPersonaVentaRepositoryCustom, times(1)).totalizarVentaSinDevolucionPersonaLocalizacion(runTarea.getTarea());
    }

    @Test
    void totalizarDevolucionPersonaLocalizacionTest(@Random final RunTareaDto runTarea) {
        this.runTareaProcesarVentaService.totalizarDevolucionPersonaLocalizacion(runTarea);
        verify(this.tareaLocalizacionPersonaVentaRepositoryCustom, times(1)).totalizarDevolucionPersonaLocalizacion(runTarea.getTarea());
    }

    @Test
    void totalizarDevolucionesVendedor0Test(@Random final RunTareaDto runTarea) {
        this.runTareaProcesarVentaService.totalizarDevolucionesVendedor0(runTarea);
        verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).totalizarDevolucionesVendedor0(runTarea.getTarea());
    }

}
