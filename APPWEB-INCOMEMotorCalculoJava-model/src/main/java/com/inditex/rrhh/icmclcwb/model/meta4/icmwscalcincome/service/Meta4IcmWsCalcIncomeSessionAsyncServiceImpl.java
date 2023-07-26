package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Meta4IcmWsCalcIncomeSessionAsyncServiceImpl implements Meta4IcmWsCalcIncomeSessionAsyncService {

  @Autowired
  private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  @Override
  public CompletableFuture<List<GenericTiendaResultItemDto>> getFlagCalcula(final FlagCalculaRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getFlagCalcula(request));
  }

  @Override
  public CompletableFuture<List<GenericEmpleadoResultItemDto>> getCoefJornada(final CoefJornadaRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getCoefJornada(request));
  }

  @Override
  public CompletableFuture<List<GenericTiendaResultItemDto>> getFestivos(final FestivosRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getFestivos(request));
  }

  @Override
  public CompletableFuture<List<GenericEmpleadoResultItemDto>> getPresenciaManual(
      final PresenciaManualRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getPresenciaManual(request));
  }

  @Override
  public CompletableFuture<List<GenericEmpleadoResultItemDto>> getEmpleadosPresencia(
      final EmpleadosPresenciaRequestDto request) {
    return CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionService.getEmpleadosPresencia(request));
  }

  @Override
  public CompletableFuture<List<PeriodosResultItemDto>> getPeriodos(final PeriodosRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getPeriodos(request));
  }

  @Override
  public CompletableFuture<List<GenericTiendaResultItemDto>> searchTiendas(final SearchTiendasRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.searchTiendas(request));
  }

  @Override
  public CompletableFuture<List<GenericTiendaResultItemDto>> getTiendas(final TiendasRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getTiendas(request));
  }

  @Override
  public CompletableFuture<List<GenericEmpleadoResultItemDto>> searchEmpleados(
      final SearchEmpleadosRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.searchEmpleados(request));
  }

  @Override
  public CompletableFuture<List<EstructurasComResultItemDto>> getEstructurasCom(
      final EstructurasComRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getEstructurasCom(request));
  }

  @Override
  public CompletableFuture<List<EstructurasPolResultItemDto>> getEstructurasPol(
      final EstructurasPolRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getEstructurasPol(request));
  }

  @Override
  public CompletableFuture<List<GenericEmpleadoResultItemDto>> getEmpleados(final EmpleadosRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getEmpleados(request));
  }

  @Override
  public CompletableFuture<List<ConfiguracionVentaOnlineResultItemDto>> getConfiguracionVentaOnline(
      final ConfiguracionVentaOnlineRequestDto request) {
    return CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionService.getConfiguracionVentaOnline(request));
  }

  @Override
  public CompletableFuture<List<AgrupOnlineResultItemDto>> getAgrupacionesOnline(
      final AgrupOnlineRequestDto request) {
    return CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionService.getAgrupacionesOnline(request));
  }

  @Override
  public CompletableFuture<List<TiendaOnlineResultItemDto>> getTiendasOnline(final TiendaOnlineRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.tiendaOnline(request));
  }

  @Override
  public CompletableFuture<List<EmpresaResultItemDto>> getEmpresa(final EmpresaRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getEmpresa(request));
  }

  @Override
  public CompletableFuture<List<OrigenResultItemDto>> getOrigen(final OrigenRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getOrigen(request));
  }

  @Override
  public CompletableFuture<List<AusenciasResultItemDto>> getAusencias(final AusenciasRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getAusencias(request));
  }

  @Override
  public CompletableFuture<List<ConfiguracionProductoVentaResultItemDto>> getConfiguracionProductoVenta(
      final ConfiguracionProductoVentaRequestDto request) {
    return CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(request));
  }

  @Override
  public CompletableFuture<List<GenericEmpleadoResultItemDto>> getEmpleadosDesplazamiento(
      final EmpleadosDesplazamientoRequestDto request) {
    return CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionService.getEmpleadosDesplazamiento(request));
  }

  @Override
  public CompletableFuture<List<ConfChDiasMinimosResultItemDto>> getConfChallengeDiasMinimos(
      final ConfChDiasMinimosRequestDto request) {
    return CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionService.getConfChallengeDiasMinimos(request));
  }

  @Override
  public CompletableFuture<List<PresupuestosWlocResultItemDto>> getPresupuestosWloc(
      final PresupuestosWlocRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getPresupuestosWloc(request));
  }

  @Override
  public CompletableFuture<List<ConfPrecioHoraResultItemDto>> getConfPrecioHora(
      final ConfPrecioHoraRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getConfPrecioHora(request));
  }

  @Override
  public CompletableFuture<List<ConfChTpVentaResultItemDto>> getConfChallengeTpVenta(
      final ConfChTpVentaRequestDto request) {
    return CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionService.getConfChallengeTpVenta(request));
  }

  @Override
  public CompletableFuture<List<PresupuestosRangoResultItemDto>> getPresupuestosRango(
      final PresupuestosRangoRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getPresupuestosRango(request));
  }

  @Override
  public CompletableFuture<List<VentaCongeladaResultItemDto>> getVentaCongelada(
      final VentaCongeladaRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getVentaCongelada(request));
  }

  @Override
  public CompletableFuture<List<DesplazamientoRealResultItemDto>> getDesplazReal(
      final DesplazamientoRealRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionService.getDesplazReal(request));
  }

  @Override
  public CompletableFuture<List<DesplazamientosMultiempresaItemDto>> getDesplazamientosMultiempresa(
      final DesplazamientosMultiempresaRequestDto request) {
    return CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionService.getDesplazamientoMultiempresa(request));
  }

  @Override
  public CompletableFuture<List<PresenciaManualWlocResultItemDto>> getPresenciaManualWloc(
      final PresenciaManualWlocRequestDto request) {
    return CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionService.getPresenciaManualWloc(request));
  }

  @Override
  public CompletableFuture<List<VentaManualWlocResultItemDto>> getVentaManualWloc(
      final VentaManualWlocRequestDto request) {
    return CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionService.getVentaManualWloc(request));
  }

  @Override
  public CompletableFuture<List<EstadoWlocResultItemDto>> estadoWloc(
      final EstadoWlocRequestDto request) {
    return CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionService.estadoWloc(request));
  }

}
