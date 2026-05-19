package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
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
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.util.MigrationDispatcher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Meta4IcmWsCalcIncomeSessionFacadeService implements Meta4IcmWsCalcIncomeSessionService {

  private final SoapMeta4IcmWsCalcIncomeSessionService soapService;

  private final PeopleAclService peopleAclService;

  private final MigrationDispatcher migrationDispatcher;

  @Override
  public List<GenericTiendaResultItemDto> searchTiendas(SearchTiendasRequestDto request) {
    return soapService.searchTiendas(request);
  }

  @Override
  public List<GenericTiendaResultItemDto> getTiendas(TiendasRequestDto request) {
    return migrationDispatcher.dispatch("getTiendas",
        () -> peopleAclService.getTiendas(request).getData(),
        () -> soapService.getTiendas(request),
        request);
  }

  @Override
  public List<GenericEmpleadoResultItemDto> searchEmpleados(SearchEmpleadosRequestDto request) {
    return soapService.searchEmpleados(request);
  }

  @Override
  public List<GenericEmpleadoResultItemDto> getEmpleados(EmpleadosRequestDto request) {
    return soapService.getEmpleados(request);
  }

  @Override
  public List<TiendaOnlineResultItemDto> tiendaOnline(TiendaOnlineRequestDto request) {
    return migrationDispatcher.dispatch(
        "tiendaOnline",
        () -> peopleAclService.searchTiendasOnline(request).getData(),
        () -> soapService.tiendaOnline(request),
        request);
  }

  @Override
  public List<PeriodosResultItemDto> getPeriodos(PeriodosRequestDto request) {
    return soapService.getPeriodos(request);
  }

  @Override
  public List<GenericEmpleadoResultItemDto> getEmpleadosPresencia(EmpleadosPresenciaRequestDto request) {
    return soapService.getEmpleadosPresencia(request);
  }

  @Override
  public List<GenericEmpleadoResultItemDto> getPresenciaManual(PresenciaManualRequestDto request) {
    return soapService.getPresenciaManual(request);
  }

  @Override
  public List<GenericEmpleadoResultItemDto> getCoefJornada(CoefJornadaRequestDto request) {
    return soapService.getCoefJornada(request);
  }

  @Override
  public List<GenericTiendaResultItemDto> getFestivos(FestivosRequestDto request) {
    return soapService.getFestivos(request);
  }

  @Override
  public List<GenericTiendaResultItemDto> getFlagCalcula(FlagCalculaRequestDto request) {
    return migrationDispatcher.dispatch("getFlagCalcula",
        () -> peopleAclService.getFlagCalcula(request).getData(),
        () -> soapService.getFlagCalcula(request),
        request);
  }

  @Override
  public List<ConfiguracionVentaOnlineResultItemDto> getConfiguracionVentaOnline(ConfiguracionVentaOnlineRequestDto request) {
    return migrationDispatcher.dispatch(
        "getConfiguracionVentaOnline",
        () -> peopleAclService.getConfVentaOnline(request).getData(),
        () -> soapService.getConfiguracionVentaOnline(request),
        request);
  }

  @Override
  public List<AgrupOnlineResultItemDto> getAgrupacionesOnline(AgrupOnlineRequestDto request) {
    return soapService.getAgrupacionesOnline(request);
  }

  @Override
  public List<EmpresaResultItemDto> getEmpresa(EmpresaRequestDto request) {
    return migrationDispatcher.dispatch("getEmpresa",
        () -> peopleAclService.searchEmpresas(request).getData(),
        () -> soapService.getEmpresa(request),
        request);
  }

  @Override
  public List<OrigenResultItemDto> getOrigen(OrigenRequestDto request) {
    return migrationDispatcher.dispatch("getOrigen",
        () -> peopleAclService.searchOrigenes(request).getData(),
        () -> soapService.getOrigen(request),
        request);
  }

  @Override
  public List<ConfiguracionProductoVentaResultItemDto> getConfiguracionProductoVenta(ConfiguracionProductoVentaRequestDto request) {
    return migrationDispatcher.dispatch(
        "getConfiguracionProductoVenta",
        () -> peopleAclService.getConfiguracionProductoVenta(request).getData(),
        () -> soapService.getConfiguracionProductoVenta(request),
        request);
  }

  @Override
  public List<ConfiguracionProductoVentaResultItemDto> getConfiguracionProductoVenta(Long idTarea, String cclIdOrigen) {
    var filter = new GenericFilterDto();
    filter.setIdOrigen(cclIdOrigen);
    var productoRequest = new ConfiguracionProductoVentaRequestDto();
    productoRequest.setData(filter);
    return migrationDispatcher.dispatch(
        "getConfiguracionProductoVenta",
        () -> peopleAclService.getConfiguracionProductoVenta(productoRequest).getData(),
        () -> soapService.getConfiguracionProductoVenta(idTarea, cclIdOrigen),
        productoRequest);
  }

  @Override
  public List<GenericEmpleadoResultItemDto> getEmpleadosDesplazamiento(EmpleadosDesplazamientoRequestDto request) {
    return soapService.getEmpleadosDesplazamiento(request);
  }

  @Override
  public List<EstructurasComResultItemDto> getEstructurasCom(EstructurasComRequestDto request) {
    return soapService.getEstructurasCom(request);
  }

  @Override
  public List<EstructurasPolResultItemDto> getEstructurasPol(EstructurasPolRequestDto request) {
    return soapService.getEstructurasPol(request);
  }

  @Override
  public List<AusenciasResultItemDto> getAusencias(AusenciasRequestDto request) {
    return migrationDispatcher.dispatch("getAusencias",
        () -> peopleAclService.getAusencias(request).getData(),
        () -> soapService.getAusencias(request),
        request);
  }

  @Override
  public List<ConfChDiasMinimosResultItemDto> getConfChallengeDiasMinimos(ConfChDiasMinimosRequestDto request) {
    return soapService.getConfChallengeDiasMinimos(request);
  }

  @Override
  public List<PresupuestosWlocResultItemDto> getPresupuestosWloc(PresupuestosWlocRequestDto request) {
    return soapService.getPresupuestosWloc(request);
  }

  @Override
  public List<ConfPrecioHoraResultItemDto> getConfPrecioHora(ConfPrecioHoraRequestDto request) {
    return soapService.getConfPrecioHora(request);
  }

  @Override
  public List<ConfChTpVentaResultItemDto> getConfChallengeTpVenta(ConfChTpVentaRequestDto request) {
    return soapService.getConfChallengeTpVenta(request);
  }

  @Override
  public List<PresupuestosRangoResultItemDto> getPresupuestosRango(PresupuestosRangoRequestDto request) {
    return soapService.getPresupuestosRango(request);
  }

  @Override
  public List<VentaCongeladaResultItemDto> getVentaCongelada(VentaCongeladaRequestDto request) {
    return soapService.getVentaCongelada(request);
  }

  @Override
  public List<DesplazamientoRealResultItemDto> getDesplazReal(DesplazamientoRealRequestDto request) {
    return soapService.getDesplazReal(request);
  }

  @Override
  public List<DesplazamientosMultiempresaItemDto> getDesplazamientoMultiempresa(DesplazamientosMultiempresaRequestDto request) {
    return soapService.getDesplazamientoMultiempresa(request);
  }

  @Override
  public List<PresenciaManualWlocResultItemDto> getPresenciaManualWloc(PresenciaManualWlocRequestDto request) {
    return soapService.getPresenciaManualWloc(request);
  }

  @Override
  public List<VentaManualWlocResultItemDto> getVentaManualWloc(VentaManualWlocRequestDto request) {
    return soapService.getVentaManualWloc(request);
  }

  @Override
  public List<EstadoWlocResultItemDto> getEstadoWloc(EstadoWlocRequestDto request) {
    return soapService.getEstadoWloc(request);
  }

}
