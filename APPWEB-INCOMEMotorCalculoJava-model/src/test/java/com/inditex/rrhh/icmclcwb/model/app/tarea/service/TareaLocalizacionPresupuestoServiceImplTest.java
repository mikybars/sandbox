package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPageEnum;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoRepositoryCustomImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionPresupuestoServiceImplTest {

    @Mock
    private TareaLocalizacionPresupuestoRepositoryCustomImpl tareaLocalizacionPresupuestoRepositoryCustom;

    @InjectMocks
    private TareaLocalizacionPresupuestoServiceImpl tareaLocalizacionPresupuestoService;

    @Test
    public void findListaPeriodosPresupestoYTrabajoMesesTest() {

        PeriodoDto periodo = mock(PeriodoDto.class);
        when(periodo.getFechaFinPeriodo()).thenReturn(LocalDate.of(2020, 1, 31));
        when(periodo.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 11, 1));
        when(tareaLocalizacionPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(periodo);

        PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();
        filter.setPeriodSize(1);
        filter.setPeriodType(PtrPageEnum.MONTHS);
        List<PeriodoDto> periodos = tareaLocalizacionPresupuestoService.findListaPeriodosPresupestoYTrabajo(1919L, filter);

        // Periodos: 3 meses
        assertEquals(3, periodos.size());
        // 0: 1/11/2019 - 30/11/2019
        assertEquals(LocalDate.of(2019, 11, 1), periodos.get(0).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2019, 11, 30), periodos.get(0).getFechaFinPeriodo());
        // 1: 1/12/2019 - 31/12/2019
        assertEquals(LocalDate.of(2019, 12, 1), periodos.get(1).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2019, 12, 31), periodos.get(1).getFechaFinPeriodo());
        // 2: 1/1/2020 - 31/1/2020
        assertEquals(LocalDate.of(2020, 1, 1), periodos.get(2).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2020, 1, 31), periodos.get(2).getFechaFinPeriodo());
    }

    @Test
    public void findListaPeriodosPresupestoYTrabajoMesesAddDaysTest() {

        PeriodoDto periodo = mock(PeriodoDto.class);
        when(periodo.getFechaFinPeriodo()).thenReturn(LocalDate.of(2020, 1, 31));
        when(periodo.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 11, 1));
        when(tareaLocalizacionPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(periodo);

        RecolectarPropertiesDto recolectarProperties = new RecolectarPropertiesDto();
        recolectarProperties.setDaysNumber(3);
        PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();
        filter.setPeriodSize(1);
        filter.setPeriodType(PtrPageEnum.MONTHS);
        List<PeriodoDto> periodos = tareaLocalizacionPresupuestoService.findListaPeriodosPresupestoYTrabajo(1919L,
            filter, recolectarProperties);

        // Periodos: 3 meses, el último con 3 días extra
        assertEquals(3, periodos.size());
        // 0: 1/11/2019 - 30/11/2019
        assertEquals(LocalDate.of(2019, 11, 1), periodos.get(0).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2019, 11, 30), periodos.get(0).getFechaFinPeriodo());
        // 1: 1/12/2019 - 31/12/2019
        assertEquals(LocalDate.of(2019, 12, 1), periodos.get(1).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2019, 12, 31), periodos.get(1).getFechaFinPeriodo());
        // 2: 1/1/2020 - 3/2/2020
        assertEquals(LocalDate.of(2020, 1, 1), periodos.get(2).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2020, 2, 3), periodos.get(2).getFechaFinPeriodo());
    }

    @Test
    public void findListaPeriodosPresupestoYTrabajoDiasTest() {

        PeriodoDto periodo = mock(PeriodoDto.class);
        when(periodo.getFechaFinPeriodo()).thenReturn(LocalDate.of(2020, 1, 31));
        when(periodo.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 11, 1));
        when(tareaLocalizacionPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(periodo);

        PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();
        filter.setPeriodSize(15);
        filter.setPeriodType(PtrPageEnum.DAYS);
        List<PeriodoDto> periodos = tareaLocalizacionPresupuestoService.findListaPeriodosPresupestoYTrabajo(1919L, filter);

        // Periodos: 6 quincenas y un resto
        assertEquals(7, periodos.size());
        // 0: 1/11/2019 - 15/11/2019
        assertEquals(LocalDate.of(2019, 11, 1), periodos.get(0).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2019, 11, 15), periodos.get(0).getFechaFinPeriodo());
        // 1: 16/11/2019 - 30/11/2019
        assertEquals(LocalDate.of(2019, 11, 16), periodos.get(1).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2019, 11, 30), periodos.get(1).getFechaFinPeriodo());
        // 2: 1/12/2019 - 15/12/2019
        assertEquals(LocalDate.of(2019, 12, 1), periodos.get(2).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2019, 12, 15), periodos.get(2).getFechaFinPeriodo());
        // 3: 1/12/2019 - 15/12/2019
        assertEquals(LocalDate.of(2019, 12, 16), periodos.get(3).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2019, 12, 30), periodos.get(3).getFechaFinPeriodo());
        // 4: 31/12/2019 - 14/1/2020
        assertEquals(LocalDate.of(2019, 12, 31), periodos.get(4).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2020, 1, 14), periodos.get(4).getFechaFinPeriodo());
        // 5: 15/1/2020 - 29/1/2020
        assertEquals(LocalDate.of(2020, 1, 15), periodos.get(5).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2020, 1, 29), periodos.get(5).getFechaFinPeriodo());
        // 6: 30/1/2020 - 31/1/2020
        assertEquals(LocalDate.of(2020, 1, 30), periodos.get(6).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2020, 1, 31), periodos.get(6).getFechaFinPeriodo());
    }

    @Test
    public void findListaPeriodosPresupestoYTrabajoDiasAddDaysTest() {

        PeriodoDto periodo = mock(PeriodoDto.class);
        when(periodo.getFechaFinPeriodo()).thenReturn(LocalDate.of(2020, 1, 31));
        when(periodo.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 11, 1));
        when(tareaLocalizacionPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(periodo);

        RecolectarPropertiesDto recolectarProperties = new RecolectarPropertiesDto();
        recolectarProperties.setDaysNumber(3);
        PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();
        filter.setPeriodSize(15);
        filter.setPeriodType(PtrPageEnum.DAYS);
        List<PeriodoDto> periodos = tareaLocalizacionPresupuestoService.findListaPeriodosPresupestoYTrabajo(1919L,
            filter, recolectarProperties);

        // Periodos: 6 quincenas y un resto
        assertEquals(7, periodos.size());
        // 0: 1/11/2019 - 15/11/2019
        assertEquals(LocalDate.of(2019, 11, 1), periodos.get(0).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2019, 11, 15), periodos.get(0).getFechaFinPeriodo());
        // 1: 16/11/2019 - 30/11/2019
        assertEquals(LocalDate.of(2019, 11, 16), periodos.get(1).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2019, 11, 30), periodos.get(1).getFechaFinPeriodo());
        // 2: 1/12/2019 - 15/12/2019
        assertEquals(LocalDate.of(2019, 12, 1), periodos.get(2).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2019, 12, 15), periodos.get(2).getFechaFinPeriodo());
        // 3: 1/12/2019 - 15/12/2019
        assertEquals(LocalDate.of(2019, 12, 16), periodos.get(3).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2019, 12, 30), periodos.get(3).getFechaFinPeriodo());
        // 4: 31/12/2019 - 14/1/2020
        assertEquals(LocalDate.of(2019, 12, 31), periodos.get(4).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2020, 1, 14), periodos.get(4).getFechaFinPeriodo());
        // 5: 15/1/2020 - 29/1/2020
        assertEquals(LocalDate.of(2020, 1, 15), periodos.get(5).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2020, 1, 29), periodos.get(5).getFechaFinPeriodo());
        // 6: 30/1/2020 - 3/2/2020
        assertEquals(LocalDate.of(2020, 1, 30), periodos.get(6).getFechaInicioPeriodo());
        assertEquals(LocalDate.of(2020, 2, 3), periodos.get(6).getFechaFinPeriodo());
    }


}
