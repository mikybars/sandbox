package com.inditex.rrhh.icmclcwb.model.app.run.tarea.regularizar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.regularizar.service.RunTareaRegularizarCalculoService;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoRepositoryCustom;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRegularizarCalculoServiceImpl implements RunTareaRegularizarCalculoService {

  private final TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

  private final PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void regularizarCalculoMejorOpcion(@Valid final RunTareaDto runTarea) {
    try {
      this.primaryTemporaryTableRepositoryCustom.createTempMejorOpcion();
      this.primaryTemporaryTableRepositoryCustom.indexTempMejorOpcion();
      this.primaryTemporaryTableRepositoryCustom.insertTempMejorOpcion(runTarea.getTarea());
      this.tareaCalculoRepositoryCustom.regularizarMejorOpcion(runTarea.getTarea());
    } finally {
      this.primaryTemporaryTableRepositoryCustom.deleteTempMejorOpcion();
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void regularizarMejorOpcionSinFechas(@Valid final RunTareaDto runTarea) {
    try {
      this.primaryTemporaryTableRepositoryCustom.createTempMejorOpcionSinFechas();
      this.primaryTemporaryTableRepositoryCustom.indexTempMejorOpcionSinFechas();
      this.primaryTemporaryTableRepositoryCustom.insertTempMejorOpcionSinFechas(runTarea.getTarea());
      this.tareaCalculoRepositoryCustom.regularizarMejorOpcionSinFechas(runTarea.getTarea());
    } finally {
      this.primaryTemporaryTableRepositoryCustom.deleteTempMejorOpcionSinFechas();
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void regularizarMejorOpcionSinFechasTodoPeriodo(@Valid final RunTareaDto runTarea) {
    try {
      this.primaryTemporaryTableRepositoryCustom.createTempMejorOpcionSinFechasTodoPeriodo();
      this.primaryTemporaryTableRepositoryCustom.indexTempMejorOpcionSinFechasTodoPeriodo();
      this.primaryTemporaryTableRepositoryCustom.insertTempMejorOpcionSinFechasTodoPeriodo(runTarea.getTarea());
      this.tareaCalculoRepositoryCustom.regularizarMejorOpcionSinFechasTodoPeriodo(runTarea.getTarea());
    } finally {
      this.primaryTemporaryTableRepositoryCustom.deleteTempMejorOpcionSinFechasTodoPeriodo();
    }
  }

}
