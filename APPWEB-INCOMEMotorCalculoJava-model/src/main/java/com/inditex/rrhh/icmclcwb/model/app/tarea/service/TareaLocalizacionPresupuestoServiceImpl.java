package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoListDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.RunUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPresupuestoServiceImpl implements TareaLocalizacionPresupuestoService {

    @Autowired
    private TareaLocalizacionPresupuestoRepositoryCustom tareaLocalizacionPresupuestoRepositoryCustom;

    @Autowired
    private TareaLocalizacionPresupuestoMapper tareaLocalizacionPresupuestoMapper;

    @Override
    public void save(@Valid @NotNull @NotEmpty final List<PresupuestosWlocResultItemDto> src, @Valid @NotNull final TareaDto tarea) {
        tareaLocalizacionPresupuestoRepositoryCustom.save(
            tareaLocalizacionPresupuestoMapper.presupuestosWlocResultItemDtoToTareaLocalizacionPresupuesto(src, tarea));
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.presupuestos_by_tarea", key = "{#tarea}")
    public TareaLocalizacionPresupuestoListDto findPresupuestos(@Valid @NotNull final TareaDto tarea) {
        return TareaLocalizacionPresupuestoListDto
            .builder()
            .presupuestos(tareaLocalizacionPresupuestoRepositoryCustom.findPresupuestos(tarea))
            .build();
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.periodo_presupuestos_by_id_tarea", key = "{#idTarea}")
    public PeriodoDto findPeriodoPresupuestoYTrabajo(@NotNull Long idTarea) {
        return tareaLocalizacionPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo(idTarea);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.list_periodo_presupuestos_by_id_tarea_and_page", key = "{#idTarea, #filterProperties.periodSize, #filterProperties.periodType}")
    public List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(@NotNull Long idTarea, @NotNull PtrFilterPropertiesDto filterProperties) {
        return findListaPeriodosPresupestoYTrabajo(idTarea, filterProperties, 0);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.list_periodo_presupuestos_by_id_tarea_and_page_and_days", key = "{#idTarea, #filterProperties.periodSize, #filterProperties.periodType, #recolectarProperties.daysNumber}")
    public List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(@NotNull Long idTarea, @NotNull PtrFilterPropertiesDto filterProperties,
        RecolectarPropertiesDto recolectarProperties) {
        return findListaPeriodosPresupestoYTrabajo(idTarea, filterProperties, recolectarProperties.getDaysNumber());
    }

    private List<PeriodoDto> findListaPeriodosPresupestoYTrabajoMonths(PeriodoDto periodo, Integer numMonths) {
        List<PeriodoDto> periodos = new ArrayList<>();
        LocalDate fecha = periodo.getFechaInicioPeriodo();
        while (fecha.isBefore(periodo.getFechaFinPeriodo())) {
            LocalDate fechaFinPeriodo = fecha.plusMonths(numMonths).minusDays(1);
            fechaFinPeriodo = fechaFinPeriodo.isBefore(periodo.getFechaFinPeriodo()) ? fechaFinPeriodo : periodo.getFechaFinPeriodo();
            periodos.add(PeriodoDto
                .builder()
                .fechaInicioPeriodo(fecha)
                .fechaFinPeriodo(fechaFinPeriodo)
                .build());
            fecha = fecha.plusMonths(numMonths);
        }
        return periodos;
    }

    private List<PeriodoDto> findListaPeriodosPresupestoYTrabajoDays(PeriodoDto periodo, Integer numDays) {
        List<PeriodoDto> periodos = new ArrayList<>();
        LocalDate fecha = periodo.getFechaInicioPeriodo();
        while (fecha.isBefore(periodo.getFechaFinPeriodo())) {
            LocalDate fechaFinPeriodo = fecha.plusDays(numDays - 1);
            fechaFinPeriodo = fechaFinPeriodo.isBefore(periodo.getFechaFinPeriodo()) ? fechaFinPeriodo : periodo.getFechaFinPeriodo();
            periodos.add(PeriodoDto
                .builder()
                .fechaInicioPeriodo(fecha)
                .fechaFinPeriodo(fechaFinPeriodo)
                .build());
            fecha = fecha.plusDays(numDays);
        }
        return periodos;
    }

    private List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(Long idTarea, @NotNull PtrFilterPropertiesDto filterProperties, Integer daysToAdd) {
        PeriodoDto periodo = tareaLocalizacionPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo(idTarea);

        List<PeriodoDto> periodos = Collections.singletonList(periodo);
        if (filterProperties.getPeriodSize() > 0) {
            switch (filterProperties.getPeriodType()) {
                case DAYS:
                    periodos = findListaPeriodosPresupestoYTrabajoDays(periodo, filterProperties.getPeriodSize());
                    break;
                case MONTHS:
                    periodos = findListaPeriodosPresupestoYTrabajoMonths(periodo, filterProperties.getPeriodSize());
            }
        }

        //Al último período se le añaden los días extra
        if (CollectionUtils.isNotEmpty(periodos)) {
            PeriodoDto ultimoTramo = periodos.get(periodos.size() - 1);
            ultimoTramo.setFechaFinPeriodo(RunUtils.addDays(ultimoTramo.getFechaFinPeriodo(), daysToAdd));
        }

        return periodos;
    }
}
