package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomePresupuestosService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoListDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoRecolectarMeta4IcmWsCalIncomePresupuestoServiceImpl
    extends AbstractRunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
    implements RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomePresupuestosService {

  @Autowired
  private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  @Override
  protected LocalDateTime getFechaInicioPeriodo(final TareaDto tarea) {
    final TareaLocalizacionPresupuestoListDto presupuestos = this.tareaLocalizacionPresupuestoService
        .findPresupuestos(tarea);
    return TimeUtils.toLocalDateTime(presupuestos.getMinFechaInicioPeriodo(LocalDate.now()));
  }

}
