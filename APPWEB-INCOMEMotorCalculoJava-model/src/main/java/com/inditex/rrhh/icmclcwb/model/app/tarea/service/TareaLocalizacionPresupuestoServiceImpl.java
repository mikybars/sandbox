package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoListDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.RunUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoRepositoryCustom;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaLocalizacionPresupuestoServiceImpl implements TareaLocalizacionPresupuestoService {

  @Autowired
  private TareaLocalizacionPresupuestoRepositoryCustom tareaLocalizacionPresupuestoRepositoryCustom;

  @Autowired
  private TareaLocalizacionPresupuestoMapper tareaLocalizacionPresupuestoMapper;

  @Override
  public void save(@Valid @NotNull @NotEmpty final List<PresupuestosWlocResultItemDto> src,
      @Valid @NotNull final TareaDto tarea) {
    this.tareaLocalizacionPresupuestoRepositoryCustom.save(
        this.tareaLocalizacionPresupuestoMapper.presupuestosWlocResultItemDtoToTareaLocalizacionPresupuesto(src,
            tarea));
  }

  @Override
  public List<String> findLocalizacionOrdinalTarea(
      @NotNull final Long idTarea, @NotNull final Integer cclIdCodOrigen, @NotNull final Integer cclIdSeccion,
      @NotNull final LocalDate fechaInicio, @NotNull final LocalDate fechaFin,
      @NotNull final Integer idTipoPresupuesto) {
    return this.tareaLocalizacionPresupuestoRepositoryCustom.findLocalizacionOrdinalTarea(idTarea,
        cclIdCodOrigen,
        cclIdSeccion, fechaInicio, fechaFin, idTipoPresupuesto);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.presupuestos_by_tarea", key = "{#tarea}")
  public TareaLocalizacionPresupuestoListDto findPresupuestos(@Valid @NotNull final TareaDto tarea) {
    return TareaLocalizacionPresupuestoListDto
        .builder()
        .presupuestos(this.tareaLocalizacionPresupuestoRepositoryCustom.findPresupuestos(tarea))
        .build();
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.periodo_presupuestos_by_id_tarea", key = "{#idTarea}")
  public PeriodoDto findPeriodoPresupuestoYTrabajo(@NotNull final Long idTarea) {
    return this.tareaLocalizacionPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo(idTarea);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.list_periodo_presupuestos_by_id_tarea_and_page",
      key = "{#idTarea, #filterProperties.periodSize, #filterProperties.periodType}")
  public List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(@NotNull final Long idTarea,
      @NotNull final PtrFilterPropertiesDto filterProperties) {
    return this.findListaPeriodosPresupestoYTrabajo(idTarea, filterProperties, 0);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.list_periodo_presupuestos_by_id_tarea_and_page_and_days",
      key = "{#idTarea, #filterProperties.periodSize, #filterProperties.periodType, #recolectarProperties.daysNumber}")
  public List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(@NotNull final Long idTarea,
      @NotNull final PtrFilterPropertiesDto filterProperties,
      final RecolectarPropertiesDto recolectarProperties) {
    return this.findListaPeriodosPresupestoYTrabajo(idTarea, filterProperties,
        recolectarProperties.getDaysNumber());
  }

  private List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(final Long idTarea,
      @NotNull final PtrFilterPropertiesDto filterProperties, final Integer daysToAdd) {
    final PeriodoDto periodo = this.tareaLocalizacionPresupuestoRepositoryCustom
        .findPeriodoPresupuestoYTrabajo(idTarea);

    List<PeriodoDto> periodos = Collections.singletonList(periodo);
    if (filterProperties.getPeriodSize() > 0) {
      switch (filterProperties.getPeriodType()) {
        case DAYS:
          periodos = this.findListaPeriodosPresupestoYTrabajoDays(periodo, filterProperties.getPeriodSize());
          break;
        case MONTHS:
          periodos = this.findListaPeriodosPresupestoYTrabajoMonths(periodo,
              filterProperties.getPeriodSize());
          break;
        default:
      }
    }

    // Al último período se le añaden los días extra
    if (CollectionUtils.isNotEmpty(periodos)) {
      final PeriodoDto ultimoTramo = periodos.get(periodos.size() - 1);
      ultimoTramo.setFechaFinPeriodo(RunUtils.addDays(ultimoTramo.getFechaFinPeriodo(), daysToAdd));
    }

    return periodos;
  }

  private List<PeriodoDto> findListaPeriodosPresupestoYTrabajoMonths(final PeriodoDto periodo,
      final Integer numMonths) {
    final List<PeriodoDto> periodos = new ArrayList<>();
    LocalDate fecha = periodo.getFechaInicioPeriodo();
    while (fecha.isBefore(periodo.getFechaFinPeriodo())) {
      LocalDate fechaFinPeriodo = fecha.plusMonths(numMonths).minusDays(1);
      fechaFinPeriodo = fechaFinPeriodo.isBefore(periodo.getFechaFinPeriodo()) ? fechaFinPeriodo
          : periodo.getFechaFinPeriodo();
      periodos.add(PeriodoDto
          .builder()
          .fechaInicioPeriodo(fecha)
          .fechaFinPeriodo(fechaFinPeriodo)
          .build());
      fecha = fecha.plusMonths(numMonths);
    }
    return periodos;
  }

  private List<PeriodoDto> findListaPeriodosPresupestoYTrabajoDays(final PeriodoDto periodo, final Integer numDays) {
    final List<PeriodoDto> periodos = new ArrayList<>();
    LocalDate fecha = periodo.getFechaInicioPeriodo();
    while (fecha.isBefore(periodo.getFechaFinPeriodo())) {
      LocalDate fechaFinPeriodo = fecha.plusDays(numDays - 1L);
      fechaFinPeriodo = fechaFinPeriodo.isBefore(periodo.getFechaFinPeriodo()) ? fechaFinPeriodo
          : periodo.getFechaFinPeriodo();
      periodos.add(PeriodoDto
          .builder()
          .fechaInicioPeriodo(fecha)
          .fechaFinPeriodo(fechaFinPeriodo)
          .build());
      fecha = fecha.plusDays(numDays);
    }
    return periodos;
  }

}
