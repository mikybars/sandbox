package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPageEnum;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuesto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoRepositoryCustomImpl;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class TareaLocalizacionPresupuestoServiceImplTest {

  @Mock
  private TareaLocalizacionPresupuestoRepositoryCustomImpl tareaLocalizacionPresupuestoRepositoryCustom;

  @Mock
  private TareaLocalizacionPresupuestoMapper tareaLocalizacionPresupuestoMapper;

  @Spy
  @InjectMocks
  private TareaLocalizacionPresupuestoServiceImpl tareaLocalizacionPresupuestoService;

  @Test
  public void findListaPeriodosPresupestoYTrabajoMesesTest() {

    final PeriodoDto periodo = mock(PeriodoDto.class);
    when(periodo.getFechaFinPeriodo()).thenReturn(LocalDate.of(2020, 1, 31));
    when(periodo.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 11, 1));
    when(this.tareaLocalizacionPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo(any(Long.class)))
        .thenReturn(periodo);

    final PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();
    filter.setPeriodSize(1);
    filter.setPeriodType(PtrPageEnum.MONTHS);
    final List<PeriodoDto> periodos = this.tareaLocalizacionPresupuestoService.findListaPeriodosPresupestoYTrabajo(1919L,
        filter);

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

    final PeriodoDto periodo = mock(PeriodoDto.class);
    when(periodo.getFechaFinPeriodo()).thenReturn(LocalDate.of(2020, 1, 31));
    when(periodo.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 11, 1));
    when(this.tareaLocalizacionPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo(any(Long.class)))
        .thenReturn(periodo);

    final RecolectarPropertiesDto recolectarProperties = new RecolectarPropertiesDto();
    recolectarProperties.setDaysNumber(3);
    final PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();
    filter.setPeriodSize(1);
    filter.setPeriodType(PtrPageEnum.MONTHS);
    final List<PeriodoDto> periodos = this.tareaLocalizacionPresupuestoService.findListaPeriodosPresupestoYTrabajo(1919L,
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

    final PeriodoDto periodo = mock(PeriodoDto.class);
    when(periodo.getFechaFinPeriodo()).thenReturn(LocalDate.of(2020, 1, 31));
    when(periodo.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 11, 1));
    when(this.tareaLocalizacionPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo(any(Long.class)))
        .thenReturn(periodo);

    final PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();
    filter.setPeriodSize(15);
    filter.setPeriodType(PtrPageEnum.DAYS);
    final List<PeriodoDto> periodos = this.tareaLocalizacionPresupuestoService.findListaPeriodosPresupestoYTrabajo(1919L,
        filter);

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

    final PeriodoDto periodo = mock(PeriodoDto.class);
    when(periodo.getFechaFinPeriodo()).thenReturn(LocalDate.of(2020, 1, 31));
    when(periodo.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 11, 1));
    when(this.tareaLocalizacionPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo(any(Long.class)))
        .thenReturn(periodo);

    final RecolectarPropertiesDto recolectarProperties = new RecolectarPropertiesDto();
    recolectarProperties.setDaysNumber(3);
    final PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();
    filter.setPeriodSize(15);
    filter.setPeriodType(PtrPageEnum.DAYS);
    final List<PeriodoDto> periodos = this.tareaLocalizacionPresupuestoService.findListaPeriodosPresupestoYTrabajo(1919L,
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

  @Test
  void saveTest() {
    final List<PresupuestosWlocResultItemDto> src = List.of(new PresupuestosWlocResultItemDto());
    final TareaDto tarea = new TareaDto();

    final List<TareaLocalizacionPresupuesto> result1 = List.of(new TareaLocalizacionPresupuesto());

    doReturn(result1).when(this.tareaLocalizacionPresupuestoMapper)
        .presupuestosWlocResultItemDtoToTareaLocalizacionPresupuesto(src, tarea);
    doReturn(result1).when(this.tareaLocalizacionPresupuestoRepositoryCustom).save(result1);

    this.tareaLocalizacionPresupuestoService.save(src, tarea);

    verify(this.tareaLocalizacionPresupuestoService, times(1))
        .save(src, tarea);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void findLocalizacionOrdinalTarea(final Long idTarea, final Integer cclIdCodOrigen, final Integer cclIdSeccion,
      final Integer idTipoPresupuesto, final List<String> stringList) {

    final LocalDate fechaInicio = LocalDate.of(1990, 2, 2);
    final LocalDate fechaFin = LocalDate.of(1990, 2, 3);

    doReturn(stringList).when(this.tareaLocalizacionPresupuestoRepositoryCustom).findLocalizacionOrdinalTarea(idTarea, cclIdCodOrigen,
        cclIdSeccion, fechaInicio, fechaFin, idTipoPresupuesto);

    final List<String> result = this.tareaLocalizacionPresupuestoService.findLocalizacionOrdinalTarea(idTarea, cclIdCodOrigen,
        cclIdSeccion, fechaInicio, fechaFin, idTipoPresupuesto);

    assertNotNull(result);
    assertFalse(result.isEmpty());

    assertEquals(stringList, result);

  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void findPresupuestosTest(final TareaDto tarea,
      final List<TareaLocalizacionPresupuestoDto> listTareas) {

    doReturn(listTareas).when(this.tareaLocalizacionPresupuestoRepositoryCustom).findPresupuestos(tarea);

    final TareaLocalizacionPresupuestoListDto result = this.tareaLocalizacionPresupuestoService.findPresupuestos(tarea);

    assertNotNull(result);
    assertEquals(listTareas, result.getPresupuestos());
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void findPeriodoPresupuestoYTrabajoTest(final Long idTarea, final PeriodoDto periodo) {
    doReturn(periodo).when(this.tareaLocalizacionPresupuestoRepositoryCustom).findPeriodoPresupuestoYTrabajo(idTarea);

    final PeriodoDto result = this.tareaLocalizacionPresupuestoService.findPeriodoPresupuestoYTrabajo(idTarea);

    assertNotNull(result);
    assertEquals(periodo, result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void findListaPeriodosPresupestoYTrabajoTest(final Long idTarea, final PtrFilterPropertiesDto filterProperties,
      final PeriodoDto periodo) {

    filterProperties.setPeriodSize(0);

    doReturn(periodo).when(this.tareaLocalizacionPresupuestoRepositoryCustom).findPeriodoPresupuestoYTrabajo(idTarea);

    final List<PeriodoDto> result = this.tareaLocalizacionPresupuestoService.findListaPeriodosPresupestoYTrabajo(idTarea,
        filterProperties);

    assertNotNull(result);
    assertFalse(result.isEmpty());
    assertEquals(Collections.singletonList(periodo), result);
  }

}
