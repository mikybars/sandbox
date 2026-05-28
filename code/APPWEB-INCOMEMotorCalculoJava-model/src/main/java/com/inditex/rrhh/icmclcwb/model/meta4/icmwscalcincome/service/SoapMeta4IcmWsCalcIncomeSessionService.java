package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.ID_PRODUCTO_BY_ID_TAREA_AND_ID_ORIGEN;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.meta4.service.Meta4PageableServiceImpl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SoapMeta4IcmWsCalcIncomeSessionService extends Meta4PageableServiceImpl {

  public List<GenericTiendaResultItemDto> getFlagCalcula(final FlagCalculaRequestDto request) {
    return this.getResultItem(request, Meta4PropertiesConstants.FLAG_CALCULA,
        FlagCalculaResponseDto.class, GenericTiendaResultItemDto.class);
  }

  public List<GenericTiendaResultItemDto> getFestivos(final FestivosRequestDto request) {
    return this.getResultItem(request, Meta4PropertiesConstants.FESTIVOS,
        FestivosResponseDto.class, GenericTiendaResultItemDto.class);
  }

  public List<GenericEmpleadoResultItemDto> getCoefJornada(final CoefJornadaRequestDto request) {
    return this.getResultItem(request, Meta4PropertiesConstants.COEF_JORNADA,
        CoefJornadaResponseDto.class, GenericEmpleadoResultItemDto.class);
  }

  public List<GenericEmpleadoResultItemDto> getPresenciaManual(final PresenciaManualRequestDto request) {
    return this.getResultItem(request, Meta4PropertiesConstants.PRESENCIA_MANUAL,
        PresenciaManualResponseDto.class, GenericEmpleadoResultItemDto.class);
  }

  public List<GenericEmpleadoResultItemDto> getEmpleadosPresencia(final EmpleadosPresenciaRequestDto request) {
    return this.getResultItem(request, Meta4PropertiesConstants.EMPLEADOS_PRESENCIA,
        EmpleadosPresenciaResponseDto.class, GenericEmpleadoResultItemDto.class);
  }

  public List<PeriodosResultItemDto> getPeriodos(final PeriodosRequestDto request) {
    return this.getResultItem(request, Meta4PropertiesConstants.PERIODOS,
        PeriodosResponseDto.class, PeriodosResultItemDto.class);
  }

  public List<GenericTiendaResultItemDto> searchTiendas(final SearchTiendasRequestDto request) {
    return this.getResultItem(request, Meta4PropertiesConstants.SEARCH_TIENDAS,
        SearchTiendasResponseDto.class, GenericTiendaResultItemDto.class);
  }

  public List<GenericTiendaResultItemDto> getTiendas(final TiendasRequestDto request) {
    return this.getResultItem(request, Meta4PropertiesConstants.TIENDAS,
        TiendasResponseDto.class, GenericTiendaResultItemDto.class);
  }

  public List<GenericEmpleadoResultItemDto> searchEmpleados(final SearchEmpleadosRequestDto request) {
    return this.getResultItem(request, Meta4PropertiesConstants.SEARCH_EMPLEADOS,
        SearchEmpleadosResponseDto.class, GenericEmpleadoResultItemDto.class);
  }

  public List<EstructurasComResultItemDto> getEstructurasCom(final EstructurasComRequestDto request) {
    return this.getResultItem(request, Meta4PropertiesConstants.ESTRUCTURAS_COM,
        EstructurasComResponseDto.class, EstructurasComResultItemDto.class);
  }

  public List<EstructurasPolResultItemDto> getEstructurasPol(final EstructurasPolRequestDto request) {
    return this.getResultItem(request, Meta4PropertiesConstants.ESTRUCTURAS_POL,
        EstructurasPolResponseDto.class, EstructurasPolResultItemDto.class);
  }

  public List<GenericEmpleadoResultItemDto> getEmpleados(final EmpleadosRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.EMPLEADOS,
        EmpleadosResponseDto.class, GenericEmpleadoResultItemDto.class);
  }

  public List<ConfiguracionVentaOnlineResultItemDto> getConfiguracionVentaOnline(
      final ConfiguracionVentaOnlineRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.CONF_VENTA_ONLINE,
        ConfiguracionVentaOnlineResponseDto.class, ConfiguracionVentaOnlineResultItemDto.class);
  }

  public List<AgrupOnlineResultItemDto> getAgrupacionesOnline(final AgrupOnlineRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.AGRUPACION_ONLINE,
        AgrupOnlineResponseDto.class, AgrupOnlineResultItemDto.class);
  }

  public List<TiendaOnlineResultItemDto> tiendaOnline(final TiendaOnlineRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.TIENDAS_ONLINE,
        TiendaOnlineResponseDto.class, TiendaOnlineResultItemDto.class);
  }

  public List<EmpresaResultItemDto> getEmpresa(final EmpresaRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.EMPRESA, EmpresaResponseDto.class, EmpresaResultItemDto.class);
  }

  public List<OrigenResultItemDto> getOrigen(final OrigenRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.ORIGEN, OrigenResponseDto.class, OrigenResultItemDto.class);
  }

  public List<AusenciasResultItemDto> getAusencias(final AusenciasRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.AUSENCIAS, AusenciasResponseDto.class, AusenciasResultItemDto.class);
  }

  public List<ConfiguracionProductoVentaResultItemDto> getConfiguracionProductoVenta(
      final ConfiguracionProductoVentaRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.CONF_PRODUCTO_VENTA, ConfiguracionProductoVentaResponseDto.class,
        ConfiguracionProductoVentaResultItemDto.class);
  }

  @Cacheable(value = ID_PRODUCTO_BY_ID_TAREA_AND_ID_ORIGEN, key = "{#idTarea,#cclIdOrigen}")
  public List<ConfiguracionProductoVentaResultItemDto> getConfiguracionProductoVenta(final Long idTarea,
      final String cclIdOrigen) {
    final GenericFilterDto filter = new GenericFilterDto();
    filter.setIdOrigen(cclIdOrigen);
    final ConfiguracionProductoVentaRequestDto productoRequest = new ConfiguracionProductoVentaRequestDto();
    productoRequest.setData(filter);
    productoRequest.setPage(this.meta4Properties.get(Meta4PropertiesConstants.CONF_PRODUCTO_VENTA).getPage());
    return this.getResultItem(productoRequest,
        Meta4PropertiesConstants.CONF_PRODUCTO_VENTA, ConfiguracionProductoVentaResponseDto.class,
        ConfiguracionProductoVentaResultItemDto.class);
  }

  public List<GenericEmpleadoResultItemDto> getEmpleadosDesplazamiento(
      final EmpleadosDesplazamientoRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.EMPLEADOS_DESPLAZAMIENTO,
        EmpleadosDesplazamientoResponseDto.class, GenericEmpleadoResultItemDto.class);
  }

  public List<ConfChDiasMinimosResultItemDto> getConfChallengeDiasMinimos(final ConfChDiasMinimosRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.CONFCHALLENGEDIASMINIMOS,
        ConfChDiasMinimosResponseDto.class, ConfChDiasMinimosResultItemDto.class);
  }

  public List<PresupuestosWlocResultItemDto> getPresupuestosWloc(final PresupuestosWlocRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.PRESUPUESTOSWLOC,
        PresupuestosWlocResponseDto.class, PresupuestosWlocResultItemDto.class);
  }

  public List<ConfPrecioHoraResultItemDto> getConfPrecioHora(final ConfPrecioHoraRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.CONFPRECIOHORA,
        ConfPrecioHoraResponseDto.class, ConfPrecioHoraResultItemDto.class);
  }

  public List<ConfChTpVentaResultItemDto> getConfChallengeTpVenta(final ConfChTpVentaRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.CONFCHALLENGETPVENTA,
        ConfChTpVentaResponseDto.class, ConfChTpVentaResultItemDto.class);
  }

  public List<PresupuestosRangoResultItemDto> getPresupuestosRango(final PresupuestosRangoRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.PRESUPUESTOSRANGO,
        PresupuestosRangoResponseDto.class, PresupuestosRangoResultItemDto.class);
  }

  public List<VentaCongeladaResultItemDto> getVentaCongelada(final VentaCongeladaRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.VENTACONGELADA,
        VentaCongeladaResponseDto.class, VentaCongeladaResultItemDto.class);
  }

  public List<DesplazamientosMultiempresaItemDto> getDesplazamientoMultiempresa(
      final DesplazamientosMultiempresaRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.MULTIEMPRESA,
        DesplazamientosMultiempresaResponseDto.class, DesplazamientosMultiempresaItemDto.class);
  }

  public List<DesplazamientoRealResultItemDto> getDesplazReal(final DesplazamientoRealRequestDto request) {
    return this.getResultItem(request,
        Meta4PropertiesConstants.DESPLAZAMIENTO_REAL,
        DesplazamientoRealResponseDto.class, DesplazamientoRealResultItemDto.class);
  }

  public List<PresenciaManualWlocResultItemDto> getPresenciaManualWloc(
      final PresenciaManualWlocRequestDto request) {
    return this.getResultItem(request, Meta4PropertiesConstants.PRESENCIA_MANUAL_WLOC,
        PresenciaManualWlocResponseDto.class, PresenciaManualWlocResultItemDto.class);
  }

  public List<VentaManualWlocResultItemDto> getVentaManualWloc(
      final VentaManualWlocRequestDto request) {
    return this.getResultItem(request, Meta4PropertiesConstants.VENTA_MANUAL_WLOC,
        VentaManualWlocResponseDto.class, VentaManualWlocResultItemDto.class);
  }

  public List<EstadoWlocResultItemDto> getEstadoWloc(
      final EstadoWlocRequestDto request) {
    return this.getResultItem(request, Meta4PropertiesConstants.ESTADO_WLOC,
        EstadoWlocResponseDto.class, EstadoWlocResultItemDto.class);
  }
}
