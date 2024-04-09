package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarVentaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePorVentaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionAbiertaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaVentaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoVentaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryProcesarCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRespositoryProcesarCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraPoliticaRepositoryCustom;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaProcesarVentaServiceImpl implements RunTareaProcesarVentaService {

  @Autowired
  private TareaLocalizacionVentaRespositoryProcesarCustom tareaTiendaVentaSeccionRepository;

  @Autowired
  private TareaLocalizacionVentaRepositoryProcesarCustom tareaTiendaVentaRepository;

  @Autowired
  private TareaLocalizacionAbiertaRepositoryCustom tareaLocalizacionAbiertaRepositoryCustom;

  @Autowired
  private TareaLocalizacionVentaRepositoryCustom tareaLocalizacionVentaRepositoryCustom;

  @Autowired
  private TareaPersonaEstructuraPoliticaRepositoryCustom tareaPersonaEstructuraPoliticaRepositoryCustom;

  @Autowired
  private TareaLocalizacionPersonaVentaRepositoryCustom tareaLocalizacionPersonaVentaRepositoryCustom;

  @Autowired
  private TareaLocalizacionPresupuestoVentaRepositoryCustom tareaLocalizacionPresupuestoVentaRepositoryCustom;

  @Autowired
  private TipoDatoService tipoDatoService;

  @Autowired
  private PrimaryTemporaryTablePorVentaRepositoryCustom primaryTemporaryTablePorVentaRepositoryCustom;

  @Override
  public void saveAbierto(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionAbiertaRepositoryCustom.saveAbierto(runTarea.getTarea(), runTarea.getTrabajo());
  }

  @Override
  public void saveAbiertoSeccion(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionAbiertaRepositoryCustom.saveAbiertoSeccion(runTarea.getTarea(), runTarea.getTrabajo());
  }

  @Override
  public void compensarOnlineSeccionCerrada(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionAbiertaRepositoryCustom.compensarOnlineSeccionCerrada(runTarea.getTarea(),
        runTarea.getTrabajo());
  }

  @Override
  public void saveCerrado(@Valid final RunTareaDto runTarea) {
    final List<IdTipoDatoDto> ids = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_LOCALIZACION.getId());
    this.tareaLocalizacionAbiertaRepositoryCustom.saveCerrado(runTarea.getTarea(), runTarea.getTrabajo(),
        ids.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
  }

  @Override
  public void saveCerradoSeccion(@Valid final RunTareaDto runTarea) {
    final List<IdTipoDatoDto> ids = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_LOCALIZACION.getId());
    this.tareaLocalizacionAbiertaRepositoryCustom.saveCerradoSeccion(runTarea.getTarea(), runTarea.getTrabajo(),
        ids.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
  }

  @Override
  public void trasladar(@Valid final RunTareaDto runTarea) {
    final List<IdTipoDatoDto> ids = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_EXCLUIDO_ENTREGA_DOMICILIO.getId());
    this.tareaLocalizacionAbiertaRepositoryCustom.trasladar(runTarea.getTarea(),
        ids.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
  }

  @Override
  public void compensar(@Valid final RunTareaDto runTarea) {
    final List<IdTipoDatoDto> ids = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_EXCLUIDO_ENTREGA_DOMICILIO.getId());
    this.tareaLocalizacionAbiertaRepositoryCustom.compensar(runTarea.getTarea(),
        ids.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
  }

  @Override
  public void repartoVentaEntregaDomicilioPorVentasAgrupaciones(@Valid final RunTareaDto runTarea) {
    this.tareaTiendaVentaRepository.procesarRepartoEntregaDomicilioPorVentasAgrupaciones(runTarea.getTarea());
  }

  @Override
  public void repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(@Valid final RunTareaDto runTarea) {
    this.tareaTiendaVentaRepository.procesarRepartoEntregaDomicilioPorPresenciaAgrupaciones(runTarea.getTarea());
  }

  @Override
  public void repartoVentaEntregaDomicilioSeccion(@Valid final RunTareaDto runTarea) {
    this.tareaTiendaVentaSeccionRepository.procesarRepartoEntregaDomicilio(runTarea.getTarea());
  }

  @Override
  public void updateActivoTrasladadas(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionVentaRepositoryCustom.updateActivoTrasladadas(runTarea.getTarea());
  }

  @Override
  public void updateActivoExcepcionada(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPresupuestoVentaRepositoryCustom.updateActivoExcepcionada(runTarea);
  }

  @Override
  public void updateActivoCongelada(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPresupuestoVentaRepositoryCustom.updateActivoCongelada(runTarea);
  }

  @Override
  public void updateActivoCongeladaSeccion(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPresupuestoVentaRepositoryCustom.updateActivoCongeladaSeccion(runTarea);
  }

  @Override
  public void totalizarPresupuesto(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPresupuestoVentaRepositoryCustom.totalizar(runTarea);
  }

  @Override
  public void updateActivoTrasladadasSeccion(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionAbiertaRepositoryCustom.updateActivoTrasladadasSeccion(runTarea.getTarea(),
        runTarea.getTrabajo());
  }

  @Override
  public void agruparOnlineSeccionDia(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionAbiertaRepositoryCustom.agruparOnlineSeccionDia(runTarea.getTarea(),
        runTarea.getTrabajo());
  }

  @Override
  public void updateActivoTrasladadasTotalizado(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionAbiertaRepositoryCustom.updateActivoTrasladadasTotalizado(runTarea.getTarea(),
        runTarea.getTrabajo());
  }

  @Override
  public void updateImporteEstructuraPoliticas(@Valid final RunTareaDto runTarea) {
    this.tareaPersonaEstructuraPoliticaRepositoryCustom.updateImporteEstructuraPoliticas(runTarea.getTarea(),
        runTarea.getTrabajo());
  }

  @Override
  public void totalizarDevolucionLocalizacionSeccion(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionVentaRepositoryCustom.totalizarDevolucionLocalizacionSeccion(runTarea.getTarea());
  }

  @Override
  public void totalizarDevolucionLocalizacion(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionVentaRepositoryCustom.totalizarDevolucionLocalizacion(runTarea.getTarea());
  }

  @Override
  public void totalizarVentasSinDevolucionLocalizacionSeccion(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionVentaRepositoryCustom
        .totalizarVentasSinDevolucionLocalizacionSeccion(runTarea.getTarea());
  }

  @Override
  public void totalizarVentaSinDevolucionPersonasPorVenta(@Valid final RunTareaDto tarea) {
    this.tareaLocalizacionVentaRepositoryCustom.totalizarVentaSinDevolucionPersonasPorVenta(tarea.getTarea());
  }

  @Override
  public void totalizarVentaSinDevolucionPersonaLocalizacion(@Valid final RunTareaDto tarea) {
    this.tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaSinDevolucionPersonaLocalizacion(tarea.getTarea());
  }

  @Override
  public void totalizarDevolucionPersonaLocalizacion(@Valid final RunTareaDto tarea) {
    this.tareaLocalizacionPersonaVentaRepositoryCustom.totalizarDevolucionPersonaLocalizacion(tarea.getTarea());
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void calcularImporteComisionVendedores(@Valid final RunTareaDto tarea) {
    try {
      this.primaryTemporaryTablePorVentaRepositoryCustom.createTempVentaFisicaLocalizacionSeccion();
      this.primaryTemporaryTablePorVentaRepositoryCustom.createIndexTempVentaFisicaLocalizacionSeccion();
      this.primaryTemporaryTablePorVentaRepositoryCustom.insertTempVentaFisicaLocalizacionSeccion(tarea.getTarea());
      this.tareaLocalizacionVentaRepositoryCustom.calcularImporteComisionVendedores(tarea.getTarea());
    } finally {
      this.primaryTemporaryTablePorVentaRepositoryCustom.deleteTempVentaFisicaLocalizacionSeccion();
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void calcularImporteComisionVentaODevolucion(@Valid final RunTareaDto tarea) {
    try {
      this.primaryTemporaryTablePorVentaRepositoryCustom.createTempVentaFisicaLocalizacionSeccion();
      this.primaryTemporaryTablePorVentaRepositoryCustom.createIndexTempVentaFisicaLocalizacionSeccion();
      this.primaryTemporaryTablePorVentaRepositoryCustom.insertTempVentaFisicaLocalizacionSeccion(tarea.getTarea());
      this.tareaLocalizacionVentaRepositoryCustom.calcularImporteComisionVentaODevolucion(tarea.getTarea());
    } finally {
      this.primaryTemporaryTablePorVentaRepositoryCustom.deleteTempVentaFisicaLocalizacionSeccion();
    }
  }

  @Override
  public void updateActivoNegativoTotalizado(@Valid final RunTareaDto tarea) {
    this.tareaLocalizacionVentaRepositoryCustom.updateActivoNegativoTotalizado(tarea.getTarea());
  }

  @Override
  public void totalizarDevolucionesVendedor0(@Valid final RunTareaDto tarea) {
    this.tareaLocalizacionVentaRepositoryCustom.totalizarDevolucionesVendedor0(tarea.getTarea());
  }

  @Override
  public void repartoDevolucionVendedor0(@Valid final RunTareaDto tarea) {
    this.tareaLocalizacionVentaRepositoryCustom.repartoDevolucionVendedor0(tarea.getTarea());
  }

  @Override
  public void updateActivoManual(@Valid final RunTareaDto tarea) {
    this.tareaLocalizacionVentaRepositoryCustom.updateActivoManual(tarea.getTarea());
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void devolucionImporte0(@Valid final RunTareaDto tarea) {
    try {
      this.primaryTemporaryTablePorVentaRepositoryCustom.createTempDatesEstructurasPorVenta();
      this.primaryTemporaryTablePorVentaRepositoryCustom.indexTempDatesEstructurasPorVenta();
      this.primaryTemporaryTablePorVentaRepositoryCustom.insertTempDatesEstructurasPorVenta(tarea.getTarea());
      this.tareaLocalizacionPersonaVentaRepositoryCustom.devolucionImporte0(tarea.getTarea());
    } finally {
      this.primaryTemporaryTablePorVentaRepositoryCustom.deleteTempDatesEstructurasPorVenta();
    }
  }

  @Override
  public void totalizarVentaFisicaSinDevolucionPersonaSeccion(@Valid final RunTareaDto tarea) {
    this.tareaLocalizacionPersonaVentaRepositoryCustom
        .totalizarVentaFisicaSinDevolucionPersonaSeccion(tarea.getTarea());
  }

  @Override
  public void totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(@Valid final RunTareaDto tarea) {
    this.tareaLocalizacionPersonaVentaRepositoryCustom
        .totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(tarea.getTarea());
  }

  @Override
  public void totalizarDevolucionFisicaPersonaSeccion(@Valid final RunTareaDto tarea) {
    this.tareaLocalizacionPersonaVentaRepositoryCustom.totalizarDevolucionFisicaPersonaSeccion(tarea.getTarea());
  }

  @Override
  public void totalizarDevolucionOnlineIpodPersonaSeccion(@Valid final RunTareaDto tarea) {
    this.tareaLocalizacionPersonaVentaRepositoryCustom
        .totalizarDevolucionOnlineIpodPersonaSeccion(tarea.getTarea());
  }

}
