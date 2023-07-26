package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service;

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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;

public interface Meta4IcmWsCalcIncomeSessionService {

  List<GenericTiendaResultItemDto> searchTiendas(SearchTiendasRequestDto request);

  List<GenericTiendaResultItemDto> getTiendas(TiendasRequestDto request);

  List<GenericEmpleadoResultItemDto> searchEmpleados(SearchEmpleadosRequestDto request);

  List<GenericEmpleadoResultItemDto> getEmpleados(EmpleadosRequestDto request);

  List<TiendaOnlineResultItemDto> tiendaOnline(TiendaOnlineRequestDto request);

  List<PeriodosResultItemDto> getPeriodos(PeriodosRequestDto request);

  List<GenericEmpleadoResultItemDto> getEmpleadosPresencia(EmpleadosPresenciaRequestDto request);

  List<GenericEmpleadoResultItemDto> getPresenciaManual(PresenciaManualRequestDto request);

  List<GenericEmpleadoResultItemDto> getCoefJornada(CoefJornadaRequestDto request);

  List<GenericTiendaResultItemDto> getFestivos(FestivosRequestDto request);

  List<GenericTiendaResultItemDto> getFlagCalcula(FlagCalculaRequestDto request);

  List<ConfiguracionVentaOnlineResultItemDto> getConfiguracionVentaOnline(
      final ConfiguracionVentaOnlineRequestDto request);

  List<AgrupOnlineResultItemDto> getAgrupacionesOnline(AgrupOnlineRequestDto request);

  List<EmpresaResultItemDto> getEmpresa(EmpresaRequestDto request);

  List<OrigenResultItemDto> getOrigen(OrigenRequestDto request);

  List<ConfiguracionProductoVentaResultItemDto> getConfiguracionProductoVenta(
      ConfiguracionProductoVentaRequestDto request);

  List<ConfiguracionProductoVentaResultItemDto> getConfiguracionProductoVenta(Long idTarea, String cclIdOrigen);

  List<GenericEmpleadoResultItemDto> getEmpleadosDesplazamiento(EmpleadosDesplazamientoRequestDto request);

  List<EstructurasComResultItemDto> getEstructurasCom(EstructurasComRequestDto request);

  List<EstructurasPolResultItemDto> getEstructurasPol(EstructurasPolRequestDto request);

  List<AusenciasResultItemDto> getAusencias(AusenciasRequestDto request);

  List<ConfChDiasMinimosResultItemDto> getConfChallengeDiasMinimos(ConfChDiasMinimosRequestDto request);

  List<PresupuestosWlocResultItemDto> getPresupuestosWloc(PresupuestosWlocRequestDto request);

  List<ConfPrecioHoraResultItemDto> getConfPrecioHora(ConfPrecioHoraRequestDto request);

  List<ConfChTpVentaResultItemDto> getConfChallengeTpVenta(ConfChTpVentaRequestDto request);

  List<PresupuestosRangoResultItemDto> getPresupuestosRango(PresupuestosRangoRequestDto request);

  List<VentaCongeladaResultItemDto> getVentaCongelada(VentaCongeladaRequestDto request);

  List<DesplazamientoRealResultItemDto> getDesplazReal(DesplazamientoRealRequestDto request);

  List<DesplazamientosMultiempresaItemDto> getDesplazamientoMultiempresa(
      DesplazamientosMultiempresaRequestDto request);

  List<PresenciaManualWlocResultItemDto> getPresenciaManualWloc(
      PresenciaManualWlocRequestDto request);

  List<VentaManualWlocResultItemDto> getVentaManualWloc(VentaManualWlocRequestDto request);

  List<EstadoWlocResultItemDto> estadoWloc(
      EstadoWlocRequestDto request);
}
