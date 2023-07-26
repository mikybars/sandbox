package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

import org.springframework.scheduling.annotation.Async;

@Async("meta4Executor")
public interface Meta4IcmWsCalcIncomeSessionAsyncService {

  CompletableFuture<List<GenericTiendaResultItemDto>> searchTiendas(SearchTiendasRequestDto request);

  CompletableFuture<List<GenericTiendaResultItemDto>> getTiendas(TiendasRequestDto request);

  CompletableFuture<List<GenericEmpleadoResultItemDto>> searchEmpleados(SearchEmpleadosRequestDto request);

  CompletableFuture<List<GenericEmpleadoResultItemDto>> getEmpleados(EmpleadosRequestDto request);

  CompletableFuture<List<PeriodosResultItemDto>> getPeriodos(PeriodosRequestDto request);

  CompletableFuture<List<GenericEmpleadoResultItemDto>> getEmpleadosPresencia(EmpleadosPresenciaRequestDto request);

  CompletableFuture<List<GenericEmpleadoResultItemDto>> getPresenciaManual(PresenciaManualRequestDto request);

  CompletableFuture<List<GenericTiendaResultItemDto>> getFestivos(FestivosRequestDto request);

  CompletableFuture<List<GenericEmpleadoResultItemDto>> getCoefJornada(CoefJornadaRequestDto request);

  CompletableFuture<List<GenericTiendaResultItemDto>> getFlagCalcula(FlagCalculaRequestDto request);

  CompletableFuture<List<ConfiguracionVentaOnlineResultItemDto>> getConfiguracionVentaOnline(
      ConfiguracionVentaOnlineRequestDto request);

  CompletableFuture<List<AgrupOnlineResultItemDto>> getAgrupacionesOnline(AgrupOnlineRequestDto request);

  CompletableFuture<List<TiendaOnlineResultItemDto>> getTiendasOnline(TiendaOnlineRequestDto request);

  CompletableFuture<List<EmpresaResultItemDto>> getEmpresa(EmpresaRequestDto request);

  CompletableFuture<List<OrigenResultItemDto>> getOrigen(OrigenRequestDto request);

  CompletableFuture<List<ConfiguracionProductoVentaResultItemDto>> getConfiguracionProductoVenta(
      ConfiguracionProductoVentaRequestDto request);

  CompletableFuture<List<GenericEmpleadoResultItemDto>> getEmpleadosDesplazamiento(
      EmpleadosDesplazamientoRequestDto request);

  CompletableFuture<List<EstructurasComResultItemDto>> getEstructurasCom(EstructurasComRequestDto request);

  CompletableFuture<List<EstructurasPolResultItemDto>> getEstructurasPol(EstructurasPolRequestDto request);

  CompletableFuture<List<AusenciasResultItemDto>> getAusencias(AusenciasRequestDto request);

  CompletableFuture<List<ConfChDiasMinimosResultItemDto>> getConfChallengeDiasMinimos(
      ConfChDiasMinimosRequestDto request);

  CompletableFuture<List<PresupuestosWlocResultItemDto>> getPresupuestosWloc(PresupuestosWlocRequestDto request);

  CompletableFuture<List<ConfPrecioHoraResultItemDto>> getConfPrecioHora(ConfPrecioHoraRequestDto request);

  CompletableFuture<List<ConfChTpVentaResultItemDto>> getConfChallengeTpVenta(ConfChTpVentaRequestDto request);

  CompletableFuture<List<PresupuestosRangoResultItemDto>> getPresupuestosRango(PresupuestosRangoRequestDto request);

  CompletableFuture<List<VentaCongeladaResultItemDto>> getVentaCongelada(VentaCongeladaRequestDto request);

  CompletableFuture<List<DesplazamientoRealResultItemDto>> getDesplazReal(DesplazamientoRealRequestDto request);

  CompletableFuture<List<DesplazamientosMultiempresaItemDto>> getDesplazamientosMultiempresa(
      DesplazamientosMultiempresaRequestDto request);

  CompletableFuture<List<PresenciaManualWlocResultItemDto>> getPresenciaManualWloc(
      PresenciaManualWlocRequestDto request);

  CompletableFuture<List<VentaManualWlocResultItemDto>> getVentaManualWloc(
      VentaManualWlocRequestDto request);

  CompletableFuture<List<EstadoWlocResultItemDto>> estadoWloc(
      EstadoWlocRequestDto request);
}
