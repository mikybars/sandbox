package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarCondicionesService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraDesplazamientoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraRepositoryCustom;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaProcesarCondicionesServiceImpl implements RunTareaProcesarCondicionesService {

  @Autowired
  private TareaLocalizacionPresupuestoRepositoryCustom tareaLocalizacionPresupuestoService;

  @Autowired
  private TareaPersonaEstructuraRepositoryCustom tareaPersonaEstructuraRepositoryCustom;

  @Autowired
  private TareaPersonaEstructuraDesplazamientoRepositoryCustom tareaPersonaEstructuraDesplazamientoRepositoryCustom;

  @Autowired
  private TareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom;

  @Autowired
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Override
  public void updateActivoPresupuestosBandaExcepcion(final RunTareaDto runTarea) {
    this.tareaLocalizacionPresupuestoService.updateActivoBandaExcepcion(runTarea.getTarea());
  }

  @Override
  public void updateActivoPresupuestosBandasSinExcepcion(final RunTareaDto runTarea) {
    this.tareaLocalizacionPresupuestoService.updateActivoBandasSinExcepcion(runTarea.getTarea());
  }

  @Override
  public void updateActivoEstructuraTopes(@Valid final TareaDto tarea) {
    this.tareaPersonaEstructuraRepositoryCustom.updateActivoTopes(tarea);
  }

  @Override
  public void relacionarPresupuestosEstructurasSinDesplazamiento(@Valid final TareaDto tarea) {
    this.tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom
        .relacionarEstructuraSinDesplazamiento(tarea);
  }

  @Override
  public void desactivarChallengeOpcionOrigen(@Valid final TareaDto tarea) {
    this.tareaPersonaEstructuraRepositoryCustom.desactivarChallengeOpcionOrigen(tarea);
  }

  @Override
  public void desactivarManualOrdinalDoble(@Valid final TareaDto tarea) {
    this.tareaPersonaEstructuraRepositoryCustom.desactivarManualOrdinalDoble(tarea);
  }

  @Override
  public void crearChallengeOpcionOrigen(@Valid final TareaDto tarea) {
    this.tareaPersonaEstructuraRepositoryCustom.crearChallengeOpcionOrigen(tarea);
  }

  @Override
  public void desactivarGlobalSeccionOpcionOrigen(@Valid final TareaDto tarea) {
    this.tareaPersonaEstructuraRepositoryCustom.desactivarGlobalSeccionOpcionOrigen(tarea);
  }

  @Override
  public void crearGlobalSeccionOpcionOrigen(@Valid final TareaDto tarea) {
    this.tareaPersonaEstructuraRepositoryCustom.crearGlobalSeccionOpcionOrigen(tarea);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void establecerBandaOpcionOrigen(@Valid @NotNull final TareaDto tarea) {
    try {
      this.primaryTemporaryTableRepositoryCustom.createTempEstructurasBaseChallenge();
      this.primaryTemporaryTableRepositoryCustom.indexTempEstructurasBaseChallenge();
      this.primaryTemporaryTableRepositoryCustom.insertTempEstructurasBaseChallenge(tarea);
      this.primaryTemporaryTableRepositoryCustom.createTempEstructurasDesplazamientoNoChallenge();
      this.primaryTemporaryTableRepositoryCustom.indexTempEstructurasDesplazamientoNoChallenge();
      this.primaryTemporaryTableRepositoryCustom.insertTempEstructurasDesplazamientoNoChallenge(tarea);
      this.tareaPersonaEstructuraRepositoryCustom.establecerBandaOpcionOrigen();
    } finally {
      this.primaryTemporaryTableRepositoryCustom.deleteTempEstructurasBaseChallenge();
      this.primaryTemporaryTableRepositoryCustom.deleteTempEstructurasDesplazamientoNoChallenge();
    }
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  public void igualarBandasOrigenDestino(
      @Valid @NotNull final TareaDto tarea) {
    try {
      this.primaryTemporaryTableRepositoryCustom.createTempBandasOrigenSinBandaDesplazamiento();
      this.primaryTemporaryTableRepositoryCustom.insertBandasOrigenSinBandaDesplazamiento(tarea);
      this.tareaPersonaEstructuraRepositoryCustom.crearEstructurasOrigenIgualarBandas();
      this.tareaPersonaEstructuraDesplazamientoRepositoryCustom.crearEstructurasDestinoIgualarBandas();
    } finally {
      this.primaryTemporaryTableRepositoryCustom.deleteTempBandasOrigenSinBandaDesplazamiento();
    }
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  public void relacionarPresupuestosEstructurasDesplazamiento(
      @Valid @NotNull final TareaDto tarea) {
    try {
      this.primaryTemporaryTableRepositoryCustom.createTempEstructura();
      this.primaryTemporaryTableRepositoryCustom.indexTempEstructura();
      this.primaryTemporaryTableRepositoryCustom.createTempPersonas();
      this.primaryTemporaryTableRepositoryCustom.indexTempPersonas();
      this.primaryTemporaryTableRepositoryCustom.createTempPresupuestos();
      this.primaryTemporaryTableRepositoryCustom.indexTempPresupuestos();
      this.primaryTemporaryTableRepositoryCustom.insertTempEstructura(tarea);
      this.primaryTemporaryTableRepositoryCustom.insertTempPersonas();
      this.primaryTemporaryTableRepositoryCustom.insertTempPresupuestos(tarea);
      this.primaryTemporaryTableRepositoryCustom.insertTareaLocalizacionPresupuestoTareaPersonaEstructura(tarea);
    } finally {
      this.primaryTemporaryTableRepositoryCustom.deleteTempEstructura();
      this.primaryTemporaryTableRepositoryCustom.deleteTempPersonas();
      this.primaryTemporaryTableRepositoryCustom.deleteTempPresupuestos();
    }
  }

}
