package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.LIST_PERIODO_PRESUPUESTOS_BY_ID_TAREA_AND_PAGE;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.LIST_PERIODO_PRESUPUESTOS_BY_ID_TAREA_AND_PAGE_AND_DAYS;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.PERIODO_PRESUPUESTOS_BY_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.PRESUPUESTOS_BY_TAREA;

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

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
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
  public void save(@Valid @NonNull @NotEmpty final List<PresupuestosWlocResultItemDto> src,
      @Valid @NonNull final TareaDto tarea) {
    this.tareaLocalizacionPresupuestoRepositoryCustom.save(
        this.tareaLocalizacionPresupuestoMapper.presupuestosWlocResultItemDtoToTareaLocalizacionPresupuesto(src,
            tarea));
  }

  @Override
  public List<String> findLocalizacionOrdinalTarea(
      @NonNull final Long idTarea, @NonNull final Integer cclIdCodOrigen, @NonNull final Integer cclIdSeccion,
      @NonNull final LocalDate fechaInicio, @NonNull final LocalDate fechaFin,
      @NonNull final Integer idTipoPresupuesto) {
    return this.tareaLocalizacionPresupuestoRepositoryCustom.findLocalizacionOrdinalTarea(idTarea,
        cclIdCodOrigen,
        cclIdSeccion, fechaInicio, fechaFin, idTipoPresupuesto);
  }

  @Override
  @Cacheable(value = PRESUPUESTOS_BY_TAREA, key = "{#tarea}")
  public TareaLocalizacionPresupuestoListDto findPresupuestos(@Valid @NonNull final TareaDto tarea) {
    return TareaLocalizacionPresupuestoListDto
        .builder()
        .presupuestos(this.tareaLocalizacionPresupuestoRepositoryCustom.findPresupuestos(tarea))
        .build();
  }

  @Override
  @Cacheable(value = PERIODO_PRESUPUESTOS_BY_ID_TAREA, key = "{#idTarea}")
  public PeriodoDto findPeriodoPresupuestoYTrabajo(@NonNull final Long idTarea) {
    return this.tareaLocalizacionPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo(idTarea);
  }

  @Override
  @Cacheable(value = LIST_PERIODO_PRESUPUESTOS_BY_ID_TAREA_AND_PAGE,
      key = "{#idTarea, #filterProperties.periodSize, #filterProperties.periodType}")
  public List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(@NonNull final Long idTarea,
      @NonNull final PtrFilterPropertiesDto filterProperties) {
    return this.findListaPeriodosPresupestoYTrabajo(idTarea, filterProperties, 0);
  }

  @Override
  @Cacheable(value = LIST_PERIODO_PRESUPUESTOS_BY_ID_TAREA_AND_PAGE_AND_DAYS,
      key = "{#idTarea, #filterProperties.periodSize, #filterProperties.periodType, #recolectarProperties.daysNumber}")
  public List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(@NonNull final Long idTarea,
      @NonNull final PtrFilterPropertiesDto filterProperties,
      final RecolectarPropertiesDto recolectarProperties) {
    return this.findListaPeriodosPresupestoYTrabajo(idTarea, filterProperties,
        recolectarProperties.getDaysNumber());
  }

  private List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(final Long idTarea,
      @NonNull final PtrFilterPropertiesDto filterProperties, final Integer daysToAdd) {
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
