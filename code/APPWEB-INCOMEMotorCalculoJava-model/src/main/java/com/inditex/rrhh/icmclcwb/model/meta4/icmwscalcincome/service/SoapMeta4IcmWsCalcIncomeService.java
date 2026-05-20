package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.GET_CLASES;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.GET_SISTEMA_DESTINO;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.GET_TIPOS_HORA;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesResponseDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionResultItemDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetagruponlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetausenciasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcadenaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcatalogoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetclasesOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcoefjornadaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfchdiasminimosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfchtpventaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfiguracionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfpreciohoraOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfprodventaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfventaonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetdesplazmultiempresaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetdesplazrealOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosdesplazOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadospresenciaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempresasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestadowlocOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestructurascomOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestructuraspolOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetfestivosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetflagcalculaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetmailOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetmotivosdesplazamientoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetorigenesOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetperiodosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresenciamanualOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresenciamanualwlocOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresupuestosrangoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresupuestoswlocOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetsistdestinoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasincomeOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiposhoraOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetventacongeladaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetventamanualwlocOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcadenaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcatalogoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchdiasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchventaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfpreciohoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaldesplazrealBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosdesplazBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadospresenciaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalflagcalculaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalliquidacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalmotivosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalmultiempresaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalplanificadorBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresenciamanualBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestosrangoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsincroBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsistdestinoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiposhoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalusuarioBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalventacongeladaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.LiquidacionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.PlanificacionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SaveprocesoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SincronizacionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper.IcmWsCalcIncomeMapper;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SoapMeta4IcmWsCalcIncomeService {

  @Qualifier("meta4ClientPool")
  private final Meta4ClientPool meta4ClientPool;

  private final IcmWsCalcIncomeMapper icmWsCalcIncomeMapper;

  public AgrupOnlineResponseDto getAgrupOnline(final AgrupOnlineRequestDto request) {
    final AgrupOnlineResponseDto result = new AgrupOnlineResponseDto();
    final IcmParamcalorigenBlock param1 = this.icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetagruponlineOutput getAgrupOnlineOutput = this.meta4ClientPool.getagruponline(param1, param2);
    if ((getAgrupOnlineOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getAgrupOnlineOutput.getReturn()) == 0)) {
      if (getAgrupOnlineOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getAgrupOnlineOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getAgrupOnlineOutput.getIcmListaconfiguracion() != null)
          && CollectionUtils
              .isNotEmpty(getAgrupOnlineOutput.getIcmListaconfiguracion().getIcmListaconfiguracionRecordSet())) {
        final List<AgrupOnlineResultItemDto> items = this.icmWsCalcIncomeMapper.asAgrupOnlineResultItemDtos(
            getAgrupOnlineOutput.getIcmListaconfiguracion().getIcmListaconfiguracionRecordSet());
        result.setData(items);
      }
    }

    return result;
  }

  public FlagCalculaResponseDto getFlagCalcula(final FlagCalculaRequestDto request) {
    final FlagCalculaResponseDto result = new FlagCalculaResponseDto();
    final IcmParamcalflagcalculaBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalflagcalculaBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetflagcalculaOutput getFlagCalculaOutput = this.meta4ClientPool.getflagcalcula(param1, param2);

    if ((getFlagCalculaOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getFlagCalculaOutput.getReturn()) == 0)) {
      if (getFlagCalculaOutput.getIcmParametrospaginacion() != null) {
        getFlagCalculaOutput.getIcmParametrospaginacion().setIdbusqueda("0");
        getFlagCalculaOutput.getIcmParametrospaginacion().setNumerototalpaginas("0");
        getFlagCalculaOutput.getIcmParametrospaginacion().setNumerototalresultados("0");

        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getFlagCalculaOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getFlagCalculaOutput.getIcmListatiendas() != null)
          && CollectionUtils
              .isNotEmpty(getFlagCalculaOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
        final List<GenericTiendaResultItemDto> items = this.icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(
            getFlagCalculaOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
        result.setData(items);
      }
    }

    return result;
  }

  public CoefJornadaResponseDto getCoefJornada(final CoefJornadaRequestDto request) {
    final CoefJornadaResponseDto result = new CoefJornadaResponseDto();
    final IcmParametrosentradaBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParametrosentradaBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetcoefjornadaOutput getCoefJornadaOutput = this.meta4ClientPool.getcoefjornada(param1, param2);
    if ((getCoefJornadaOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getCoefJornadaOutput.getReturn()) == 0)) {
      if (getCoefJornadaOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getCoefJornadaOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getCoefJornadaOutput.getIcmListaempleados() != null)
          && CollectionUtils
              .isNotEmpty(getCoefJornadaOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
        final List<GenericEmpleadoResultItemDto> items = this.icmWsCalcIncomeMapper
            .asGenericEmpleadoResultItemDtos(
                getCoefJornadaOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public FestivosResponseDto getFestivos(final FestivosRequestDto request) {
    final FestivosResponseDto result = new FestivosResponseDto();
    final IcmParametrosentradaBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParametrosentradaBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetfestivosOutput getFestivosOutput = this.meta4ClientPool.getfestivos(param1, param2);
    if ((getFestivosOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getFestivosOutput.getReturn()) == 0)) {
      if (getFestivosOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getFestivosOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getFestivosOutput.getIcmListatiendas() != null)
          && CollectionUtils
              .isNotEmpty(getFestivosOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
        final List<GenericTiendaResultItemDto> items = this.icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(
            getFestivosOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public PresenciaManualResponseDto getPresenciaManual(final PresenciaManualRequestDto request) {
    final PresenciaManualResponseDto result = new PresenciaManualResponseDto();
    final IcmParamcalpresenciamanualBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalpresenciamanualBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetpresenciamanualOutput getPresenciaManualOutput = this.meta4ClientPool.getpresenciamanual(param1,
        param2);
    if ((getPresenciaManualOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getPresenciaManualOutput.getReturn()) == 0)) {
      if (getPresenciaManualOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getPresenciaManualOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getPresenciaManualOutput.getIcmListaempleados() != null)
          && CollectionUtils
              .isNotEmpty(getPresenciaManualOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
        final List<GenericEmpleadoResultItemDto> items = this.icmWsCalcIncomeMapper
            .asGenericEmpleadoResultItemDtos(
                getPresenciaManualOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public EmpleadosPresenciaResponseDto getEmpleadosPresencia(final EmpleadosPresenciaRequestDto request) {
    final EmpleadosPresenciaResponseDto result = new EmpleadosPresenciaResponseDto();
    final IcmParamcalempleadospresenciaBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalempleadospresenciaBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetempleadospresenciaOutput getempleadospresenciaOutput = this.meta4ClientPool
        .getempleadospresencia(param1, param2);
    if ((getempleadospresenciaOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getempleadospresenciaOutput.getReturn()) == 0)) {
      if (getempleadospresenciaOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getempleadospresenciaOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getempleadospresenciaOutput.getIcmListaempleados() != null)
          && CollectionUtils
              .isNotEmpty(getempleadospresenciaOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
        final List<GenericEmpleadoResultItemDto> items = this.icmWsCalcIncomeMapper
            .asGenericEmpleadoResultItemDtos(
                getempleadospresenciaOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public PeriodosResponseDto getPeriodos(final PeriodosRequestDto request) {
    final PeriodosResponseDto result = new PeriodosResponseDto();
    final IcmParamcalperiodoBlock param1 = this.icmWsCalcIncomeMapper.asIcmParamcalperiodoBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetperiodosOutput getperiodosOutput = this.meta4ClientPool.getperiodos(param1, param2);
    if ((getperiodosOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getperiodosOutput.getReturn()) == 0)) {
      if (getperiodosOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getperiodosOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getperiodosOutput.getIcmListaperiodos() != null)
          && CollectionUtils
              .isNotEmpty(getperiodosOutput.getIcmListaperiodos().getIcmListaperiodosRecordSet())) {
        final List<PeriodosResultItemDto> items = this.icmWsCalcIncomeMapper.asPeriodosResultItemDtos(
            getperiodosOutput.getIcmListaperiodos().getIcmListaperiodosRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public SearchTiendasResponseDto searchTiendas(final SearchTiendasRequestDto request) {
    final SearchTiendasResponseDto result = new SearchTiendasResponseDto();
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final IcmParamcaltiendasBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcaltiendasBlock(request.getData());
    final SearchtiendasOutput searchTiendasOutput = this.meta4ClientPool.searchtiendas(param1, param2);
    if ((searchTiendasOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, searchTiendasOutput.getReturn()) == 0)) {
      if (searchTiendasOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(searchTiendasOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((searchTiendasOutput.getIcmListatiendas() != null)
          && (searchTiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet() != null)
          && CollectionUtils
              .isNotEmpty(searchTiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
        final List<GenericTiendaResultItemDto> items = this.icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(
            searchTiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public TiendasResponseDto getTiendas(final TiendasRequestDto request) {
    final TiendasResponseDto result = new TiendasResponseDto();
    final IcmParametrosentradaBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParametrosentradaBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GettiendasincomeOutput tiendasOutput = this.meta4ClientPool.gettiendasincome(param2, param1);
    if ((tiendasOutput != null) && (Double.compare(NumberUtils.DOUBLE_ZERO, tiendasOutput.getReturn()) == 0)) {
      if (tiendasOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper.asPageDto(tiendasOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((tiendasOutput.getIcmListatiendas() != null)
          && (tiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet() != null)
          && CollectionUtils.isNotEmpty(tiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
        final List<GenericTiendaResultItemDto> items = this.icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(
            tiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public SearchEmpleadosResponseDto searchEmpleados(final SearchEmpleadosRequestDto request) {
    final SearchEmpleadosResponseDto result = new SearchEmpleadosResponseDto();
    final IcmParamcalempleadoBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalempleadoBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final SearchempleadosOutput searchEmpleadosOutput = this.meta4ClientPool.searchempleados(param2, param1);
    if ((searchEmpleadosOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, searchEmpleadosOutput.getReturn()) == 0)) {
      if (searchEmpleadosOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(searchEmpleadosOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((searchEmpleadosOutput.getIcmListaempleado() != null)
          && (searchEmpleadosOutput.getIcmListaempleado().getIcmListaempleadoRecordSet() != null)
          && CollectionUtils
              .isNotEmpty(searchEmpleadosOutput.getIcmListaempleado().getIcmListaempleadoRecordSet())) {
        final List<GenericEmpleadoResultItemDto> items = this.icmWsCalcIncomeMapper
            .asGenericEmpleadoResultItemDtosSearchEmpleados(
                searchEmpleadosOutput.getIcmListaempleado().getIcmListaempleadoRecordSet());
        result.setData(items);
      }
    }
    return result;

  }

  public EstructurasComResponseDto getEstructurasCom(final EstructurasComRequestDto request) {
    final EstructurasComResponseDto result = new EstructurasComResponseDto();
    final IcmParamcalestructuraBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalestructuraBlock(request.getData());
    final GetestructurascomOutput getEstructurasComOutput = this.meta4ClientPool.getestructurascom(param1);
    if ((getEstructurasComOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getEstructurasComOutput.getReturn()) == 0)
        && (getEstructurasComOutput.getIcmListaestructura() != null) && CollectionUtils
            .isNotEmpty(getEstructurasComOutput.getIcmListaestructura().getIcmListaestructuraRecordSet())) {
      final List<EstructurasComResultItemDto> items = this.icmWsCalcIncomeMapper
          .asEstructurasComResultItemDtos(
              getEstructurasComOutput.getIcmListaestructura().getIcmListaestructuraRecordSet());
      result.setData(items);
    }

    return result;
  }

  public EstructurasPolResponseDto getEstructurasPol(final EstructurasPolRequestDto request) {
    final EstructurasPolResponseDto result = new EstructurasPolResponseDto();
    final IcmParamcalestructuraBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalestructuraBlock(request.getData());
    final GetestructuraspolOutput getEstructurasPolOutput = this.meta4ClientPool.getestructuraspol(param1);
    if ((getEstructurasPolOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getEstructurasPolOutput.getReturn()) == 0)
        && (getEstructurasPolOutput.getIcmListapoliticas() != null) && CollectionUtils
            .isNotEmpty(getEstructurasPolOutput.getIcmListapoliticas().getIcmListapoliticasRecordSet())) {
      final List<EstructurasPolResultItemDto> items = this.icmWsCalcIncomeMapper
          .asEstructurasPolResultItemDto(
              getEstructurasPolOutput.getIcmListapoliticas().getIcmListapoliticasRecordSet());
      result.setData(items);
    }

    return result;
  }

  public EmpleadosResponseDto getEmpleados(final EmpleadosRequestDto request) {
    final EmpleadosResponseDto result = new EmpleadosResponseDto();
    final IcmParamcalempleadosBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalempleadosBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetempleadosOutput getEmpleadosOutput = this.meta4ClientPool.getempleados(param1, param2);
    if ((getEmpleadosOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getEmpleadosOutput.getReturn()) == 0)) {
      if (getEmpleadosOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getEmpleadosOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getEmpleadosOutput.getIcmListaempleados() != null)
          && (getEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet() != null)
          && CollectionUtils
              .isNotEmpty(getEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
        final List<GenericEmpleadoResultItemDto> items = this.icmWsCalcIncomeMapper
            .asGenericEmpleadoResultItemDtos(
                getEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public ConfiguracionVentaOnlineResponseDto getConfVentaOnline(final ConfiguracionVentaOnlineRequestDto request) {
    final ConfiguracionVentaOnlineResponseDto result = new ConfiguracionVentaOnlineResponseDto();
    final IcmParametrosentradaBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParametrosentradaBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetconfventaonlineOutput getconfventaonline = this.meta4ClientPool.getconfventaonline(param1, param2);
    if (getconfventaonline != null) {
      if (getconfventaonline.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getconfventaonline.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getconfventaonline.getIcmListaconfiguracion() != null)
          && (getconfventaonline.getIcmListaconfiguracion().getIcmListaconfiguracionRecordSet() != null)) {
        final List<ConfiguracionVentaOnlineResultItemDto> items = this.icmWsCalcIncomeMapper
            .asConfiguracionVentaOnlineResultItemDto(
                getconfventaonline.getIcmListaconfiguracion().getIcmListaconfiguracionRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public TiendaOnlineResponseDto getTiendasOnline(final TiendaOnlineRequestDto request) {
    final TiendaOnlineResponseDto result = new TiendaOnlineResponseDto();
    final IcmParametrosentradaBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParametrosentradaBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GettiendasonlineOutput gettiendasonline = this.meta4ClientPool.gettiendasonline(param2, param1);
    if (gettiendasonline != null) {
      if (gettiendasonline.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(gettiendasonline.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((gettiendasonline.getIcmListatiendas() != null)
          && (gettiendasonline.getIcmListatiendas().getIcmListatiendasRecordSet() != null)) {
        final List<TiendaOnlineResultItemDto> items = this.icmWsCalcIncomeMapper.asTiendaOnlineResultItemDto(
            gettiendasonline.getIcmListatiendas().getIcmListatiendasRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public ConfiguracionProductoVentaResponseDto getConfiguracionProductoVenta(
      final ConfiguracionProductoVentaRequestDto request) {
    final ConfiguracionProductoVentaResponseDto result = new ConfiguracionProductoVentaResponseDto();
    final IcmParametrosentradaBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParametrosentradaBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetconfprodventaOutput getconfprodventaoutput = this.meta4ClientPool.getconfprodventa(param1, param2);
    if (getconfprodventaoutput != null) {
      if (getconfprodventaoutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getconfprodventaoutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getconfprodventaoutput.getIcmListaconfiguracion() != null)
          && (getconfprodventaoutput.getIcmListaconfiguracion()
              .getIcmListaconfiguracionRecordSet() != null)) {
        final List<ConfiguracionProductoVentaResultItemDto> items = this.icmWsCalcIncomeMapper
            .asConfiguracionProductoVentaResultItemDto(
                getconfprodventaoutput.getIcmListaconfiguracion().getIcmListaconfiguracionRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public CadenaResponseDto getCadena(final CadenaRequestDto request) {
    final CadenaResponseDto result = new CadenaResponseDto();
    final IcmParamcalcadenaBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalcadenaBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetcadenaOutput getcadenaoutput = this.meta4ClientPool.getcadena(param1, param2);
    if (getcadenaoutput != null) {
      if (getcadenaoutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper.asPageDto(getcadenaoutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getcadenaoutput.getIcmListacadenas() != null)
          && (getcadenaoutput.getIcmListacadenas().getIcmListacadenasRecordSet() != null)) {
        final List<CadenaResultItemDto> items = this.icmWsCalcIncomeMapper
            .asCadenaResultItemDto(getcadenaoutput.getIcmListacadenas().getIcmListacadenasRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public EmpresaResponseDto getEmpresa(final EmpresaRequestDto request) {
    final EmpresaResponseDto result = new EmpresaResponseDto();
    final IcmParamcalorigenBlock param1 = this.icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetempresasOutput getempresasoutput = this.meta4ClientPool.getempresas(param1, param2);
    if (getempresasoutput != null) {
      if (getempresasoutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getempresasoutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getempresasoutput.getIcmListaempresas() != null)
          && (getempresasoutput.getIcmListaempresas().getIcmListaempresasRecordSet() != null)) {
        final List<EmpresaResultItemDto> items = this.icmWsCalcIncomeMapper
            .asEmpresaResultItemDto(getempresasoutput.getIcmListaempresas().getIcmListaempresasRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public OrigenResponseDto getOrigen(final OrigenRequestDto request) {
    final OrigenResponseDto result = new OrigenResponseDto();
    final IcmParamcalsociedadBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalsociedadBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetorigenesOutput getorigenesoutput = this.meta4ClientPool.getorigenes(param1, param2);
    if (getorigenesoutput != null) {
      if (getorigenesoutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getorigenesoutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getorigenesoutput.getIcmListaorigenes() != null)
          && (getorigenesoutput.getIcmListaorigenes().getIcmListaorigenesRecordSet() != null)) {
        final List<OrigenResultItemDto> items = this.icmWsCalcIncomeMapper
            .asOrigenResultItemDto(getorigenesoutput.getIcmListaorigenes().getIcmListaorigenesRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public EmpleadosDesplazamientoResponseDto getEmpleadosDesplazamiento(
      final EmpleadosDesplazamientoRequestDto request) {
    final EmpleadosDesplazamientoResponseDto result = new EmpleadosDesplazamientoResponseDto();
    final IcmParamcalempleadosdesplazBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalempleadosdesplazBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetempleadosdesplazOutput getempldesplaz = this.meta4ClientPool.getempleadosdesplaz(param2, param1);
    if (getempldesplaz != null) {
      if (getempldesplaz.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper.asPageDto(getempldesplaz.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getempldesplaz.getIcmListaempleados() != null)
          && CollectionUtils
              .isNotEmpty(getempldesplaz.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
        final List<GenericEmpleadoResultItemDto> items = this.icmWsCalcIncomeMapper
            .asGenericEmpleadoResultItemDtos(
                getempldesplaz.getIcmListaempleados().getIcmListaempleadosRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public AusenciasResponseDto getAusencias(final AusenciasRequestDto request) {
    final AusenciasResponseDto result = new AusenciasResponseDto();
    final IcmParamcalempleadoBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalempleadoBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetausenciasOutput getausencias = this.meta4ClientPool.getausencias(param2, param1);
    if (getausencias != null) {
      if (getausencias.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper.asPageDto(getausencias.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getausencias.getIcmListaausencias() != null)
          && CollectionUtils
              .isNotEmpty(getausencias.getIcmListaausencias().getIcmListaausenciasRecordSet())) {
        final List<AusenciasResultItemDto> items = this.icmWsCalcIncomeMapper.asAusenciasResultItemDtos(
            getausencias.getIcmListaausencias().getIcmListaausenciasRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public SaveResultDto saveProceso(final SaveProcesoDto request) {
    final SaveprocesoOutput saveProcesoOutput = this.meta4ClientPool
        .saveproceso(this.icmWsCalcIncomeMapper.asIcmParamcalprocesoBlock(request));
    final SaveResultDto saveResult = this.icmWsCalcIncomeMapper
        .asSaveResultDto(saveProcesoOutput.getIcmResultadoguardado());
    if (Boolean.TRUE.equals(saveResult.getResultadoError())
        ||
        Boolean.FALSE.equals(saveResult.getResultadoOk())) {
      final StringBuilder sb = new StringBuilder("Error al guardar el proceso: \n");
      saveResult.getData()
          .forEach(x -> sb.append(x.getLiteral()).append(" ").append(x.getRegistroAfectado()).append('\n'));
      throw new IcmclcwbException(sb.toString());
    }
    return saveResult;
  }

  public ConfiguracionesResponseDto getConfiguracion(final ConfiguracionesRequestDto request) {
    final GetconfiguracionOutput configuracionOutput = this.meta4ClientPool
        .getconfiguracion(this.icmWsCalcIncomeMapper.asIcmParamconfBlock(request));
    return this.icmWsCalcIncomeMapper
        .asConfiguracionesResponseDto(configuracionOutput, request.getIdOrigen());
  }

  public ConfChDiasMinimosResponseDto getConfChallengeDiasMinimos(final ConfChDiasMinimosRequestDto request) {
    final ConfChDiasMinimosResponseDto result = new ConfChDiasMinimosResponseDto();
    final IcmParamcalconfchdiasBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalconfchdiasBlock(request.getData());
    final GetconfchdiasminimosOutput getConfChDiasMinimos = this.meta4ClientPool.getconfchdiasminimos(param1);
    if ((getConfChDiasMinimos != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getConfChDiasMinimos.getReturn()) == 0)
        && (getConfChDiasMinimos.getIcmListaconfchdias() != null) && CollectionUtils
            .isNotEmpty(getConfChDiasMinimos.getIcmListaconfchdias().getIcmListaconfchdiasRecordSet())) {
      final List<ConfChDiasMinimosResultItemDto> items = this.icmWsCalcIncomeMapper
          .asConfChDiasMinimosResultItemDto(
              getConfChDiasMinimos.getIcmListaconfchdias().getIcmListaconfchdiasRecordSet());
      result.setData(items);
    }
    return result;
  }

  public PresupuestosWlocResponseDto getPresupuestosWloc(final PresupuestosWlocRequestDto request) {
    final PresupuestosWlocResponseDto result = new PresupuestosWlocResponseDto();
    final IcmParamcalpresupuestoswlocBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalpresupuestoswlocBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetpresupuestoswlocOutput getPresupuestosWlocOutput = this.meta4ClientPool.getpresupuestoswloc(param1,
        param2);
    if (getPresupuestosWlocOutput != null) {
      if (getPresupuestosWlocOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getPresupuestosWlocOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getPresupuestosWlocOutput.getIcmListapresupuestoswloc() != null)
          && CollectionUtils
              .isNotEmpty(getPresupuestosWlocOutput.getIcmListapresupuestoswloc()
                  .getIcmListapresupuestoswlocRecordSet())) {
        final List<PresupuestosWlocResultItemDto> items = this.icmWsCalcIncomeMapper
            .asPresupuestosWlocResultItemDto(
                getPresupuestosWlocOutput.getIcmListapresupuestoswloc()
                    .getIcmListapresupuestoswlocRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public ConfPrecioHoraResponseDto getConfPrecioHora(final ConfPrecioHoraRequestDto request) {
    final ConfPrecioHoraResponseDto result = new ConfPrecioHoraResponseDto();
    final IcmParamcalconfpreciohoraBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalconfpreciohoraBlock(request.getData());
    final GetconfpreciohoraOutput getConfPrecioHora = this.meta4ClientPool.getconfpreciohora(param1);
    if ((getConfPrecioHora != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getConfPrecioHora.getReturn()) == 0)
        && (getConfPrecioHora.getIcmListaconfpreciohora() != null) && CollectionUtils
            .isNotEmpty(getConfPrecioHora.getIcmListaconfpreciohora().getIcmListaconfpreciohoraRecordSet())) {
      final List<ConfPrecioHoraResultItemDto> items = this.icmWsCalcIncomeMapper
          .asConfPrecioHoraResultItemDto(
              getConfPrecioHora.getIcmListaconfpreciohora().getIcmListaconfpreciohoraRecordSet());
      result.setData(items);
    }
    return result;
  }

  public ConfChTpVentaResponseDto getConfChallengeTpVenta(final ConfChTpVentaRequestDto request) {
    final ConfChTpVentaResponseDto result = new ConfChTpVentaResponseDto();
    final IcmParamcalconfchventaBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalconfchventaBlock(request.getData());
    final GetconfchtpventaOutput getConfChallengeTpVenta = this.meta4ClientPool.getconfchtpventa(param1);
    if ((getConfChallengeTpVenta != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getConfChallengeTpVenta.getReturn()) == 0)
        && (getConfChallengeTpVenta.getIcmListaconfchventa() != null) && CollectionUtils
            .isNotEmpty(getConfChallengeTpVenta.getIcmListaconfchventa().getIcmListaconfchventaRecordSet())) {
      final List<ConfChTpVentaResultItemDto> items = this.icmWsCalcIncomeMapper.asConfChTpVentaResultItemDto(
          getConfChallengeTpVenta.getIcmListaconfchventa().getIcmListaconfchventaRecordSet());
      result.setData(items);
    }
    return result;
  }

  public PresupuestosRangoResponseDto getPresupuestosRango(final PresupuestosRangoRequestDto request) {
    final PresupuestosRangoResponseDto result = new PresupuestosRangoResponseDto();
    final IcmParamcalpresupuestosrangoBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalpresupuestosrangoBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetpresupuestosrangoOutput getPresupuestosRangoOutput = this.meta4ClientPool.getpresupuestosrango(param2,
        param1);
    if (getPresupuestosRangoOutput != null) {
      if (getPresupuestosRangoOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getPresupuestosRangoOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getPresupuestosRangoOutput.getIcmListapresupuestosrango() != null)
          && CollectionUtils
              .isNotEmpty(getPresupuestosRangoOutput.getIcmListapresupuestosrango()
                  .getIcmListapresupuestosrangoRecordSet())) {
        final List<PresupuestosRangoResultItemDto> items = this.icmWsCalcIncomeMapper
            .asPresupuestosRangoResultItemDto(
                getPresupuestosRangoOutput.getIcmListapresupuestosrango()
                    .getIcmListapresupuestosrangoRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public VentaCongeladaResponseDto getVentaCongelada(final VentaCongeladaRequestDto request) {
    final VentaCongeladaResponseDto result = new VentaCongeladaResponseDto();
    final IcmParamcalventacongeladaBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalventacongeladaBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetventacongeladaOutput getVentaCongeladaOutput = this.meta4ClientPool.getventacongelada(param2, param1);
    if (getVentaCongeladaOutput != null) {
      if (getVentaCongeladaOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getVentaCongeladaOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getVentaCongeladaOutput.getIcmListaventacongelada() != null)
          && CollectionUtils
              .isNotEmpty(getVentaCongeladaOutput.getIcmListaventacongelada().getIcmListaventacongeladaRecordSet())) {
        final List<VentaCongeladaResultItemDto> items = this.icmWsCalcIncomeMapper
            .asVentaCongeladaResultItemDto(
                getVentaCongeladaOutput.getIcmListaventacongelada().getIcmListaventacongeladaRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public DesplazamientosMultiempresaResponseDto getDesplazamientosMultiempresa(
      final DesplazamientosMultiempresaRequestDto request) {

    final DesplazamientosMultiempresaResponseDto result = new DesplazamientosMultiempresaResponseDto();
    final IcmParamcalmultiempresaBlock param1 = new IcmParamcalmultiempresaBlock();
    param1.getIcmParamcalmultiempresaRecordSet()
        .add(this.icmWsCalcIncomeMapper.asIcmParamcalmultiempresaRecord(request.getData()));
    final GetdesplazmultiempresaOutput desplazamientoMultiempresaOutput = this.meta4ClientPool
        .getDesplazamientoMultiempresa(param1);
    if ((desplazamientoMultiempresaOutput.getIcmListamultiempresa() != null)
        && CollectionUtils.isNotEmpty(desplazamientoMultiempresaOutput.getIcmListamultiempresa()
            .getIcmListamultiempresaRecordSet())) {
      final List<DesplazamientosMultiempresaItemDto> items = this.icmWsCalcIncomeMapper
          .asDesplazamientosMultiempresaItemDto(
              desplazamientoMultiempresaOutput.getIcmListamultiempresa().getIcmListamultiempresaRecordSet());
      result.setData(items);
    }
    return result;
  }

  public DesplazamientoRealResponseDto getDesplazReal(final DesplazamientoRealRequestDto request) {
    final DesplazamientoRealResponseDto result = new DesplazamientoRealResponseDto();
    final IcmParamcaldesplazrealBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcaldesplazrealBlock(request.getData());
    final GetdesplazrealOutput getConfPrecioHora = this.meta4ClientPool.getdesplazreal(param1);
    if ((getConfPrecioHora != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getConfPrecioHora.getReturn()) == 0)) {
      if ((getConfPrecioHora.getIcmListadesplazreal() != null)
          && CollectionUtils
              .isNotEmpty(getConfPrecioHora.getIcmListadesplazreal().getIcmListadesplazrealRecordSet())) {
        final List<DesplazamientoRealResultItemDto> items = this.icmWsCalcIncomeMapper
            .asDesplazamientoRealResultItemDto(
                getConfPrecioHora.getIcmListadesplazreal().getIcmListadesplazrealRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public PresenciaManualWlocResponseDto getPresenciaManualWloc(final PresenciaManualWlocRequestDto request) {
    final PresenciaManualWlocResponseDto result = new PresenciaManualWlocResponseDto();
    final IcmParamcaltiendasBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcaltiendasBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetpresenciamanualwlocOutput getPresenciaManualOutput = this.meta4ClientPool.getpresenciamanualwloc(
        param2,
        param1);
    if ((getPresenciaManualOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getPresenciaManualOutput.getReturn()) == 0)) {
      if (getPresenciaManualOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getPresenciaManualOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getPresenciaManualOutput.getIcmListapresenciamanwloc() != null)
          && CollectionUtils
              .isNotEmpty(getPresenciaManualOutput.getIcmListapresenciamanwloc()
                  .getIcmListapresenciamanwlocRecordSet())) {
        final List<PresenciaManualWlocResultItemDto> items = this.icmWsCalcIncomeMapper
            .asPresenciaManualWlocResultItemDto(
                getPresenciaManualOutput.getIcmListapresenciamanwloc()
                    .getIcmListapresenciamanwlocRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public VentaManualWlocResponseDto getVentaManualWloc(final VentaManualWlocRequestDto request) {
    final VentaManualWlocResponseDto result = new VentaManualWlocResponseDto();
    final IcmParamcaltiendasBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcaltiendasBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetventamanualwlocOutput getVentaManualOutput = this.meta4ClientPool.getventamanualwloc(
        param2,
        param1);
    if ((getVentaManualOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getVentaManualOutput.getReturn()) == 0)) {
      if (getVentaManualOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getVentaManualOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getVentaManualOutput.getIcmListaventamanwloc() != null)
          && CollectionUtils
              .isNotEmpty(getVentaManualOutput.getIcmListaventamanwloc()
                  .getIcmListaventamanwlocRecordSet())) {
        final List<VentaManualWlocResultItemDto> items = this.icmWsCalcIncomeMapper
            .asVentaManualWlocResultItemDto(
                getVentaManualOutput.getIcmListaventamanwloc()
                    .getIcmListaventamanwlocRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

  public SincronizacionResponseDto sincronizacion(final SincronizacionRequestDto request) {
    final SincronizacionResponseDto result = new SincronizacionResponseDto();
    final IcmParamcalsincroBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcalsincroBlock(request.getData());
    final SincronizacionOutput sincronizacion = this.meta4ClientPool.sincronizacion(param1);
    if ((sincronizacion != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, sincronizacion.getReturn()) == 0)
        && (sincronizacion.getIcmListasincro() != null) && CollectionUtils
            .isNotEmpty(sincronizacion.getIcmListasincro().getIcmListasincroRecordSet())) {
      final List<SincronizacionResultItemDto> items = this.icmWsCalcIncomeMapper
          .asSincronizacionResultItemDto(
              sincronizacion.getIcmListasincro().getIcmListasincroRecordSet());
      result.setData(items);
    }
    return result;
  }

  public MotivosDesplazamientoResponseDto getMotivosDesplazamiento(
      final MotivosDesplazamientoRequestDto request) {
    final IcmParamcalmotivosBlock param = this.icmWsCalcIncomeMapper.asIcmParamcalmotivosBlock(request);

    final GetmotivosdesplazamientoOutput motivosdesplazamiento = this.meta4ClientPool
        .getmotivosdesplazamiento(param);

    return MotivosDesplazamientoResponseDto
        .builder()
        .items(this.icmWsCalcIncomeMapper
            .asMotivosDesplazamientoItemDto(
                motivosdesplazamiento.getIcmListamotivos().getIcmListamotivosRecordSet()))
        .build();

  }

  @Cacheable(value = GET_SISTEMA_DESTINO, key = "{#request.cclIdOrigen}")
  public SistemaDestinoResponseDto getSistemaDestino(
      final SistemaDestinoRequestDto request) {

    final IcmParamcalsistdestinoBlock param = this.icmWsCalcIncomeMapper
        .asIcmParamcalsistdestinoBlock(request);
    final GetsistdestinoOutput sistdestino = this.meta4ClientPool.getsisdestino(param);
    return this.icmWsCalcIncomeMapper.asSistemaDestinoResponseDto(sistdestino);

  }

  public CatalogoResponseDto getCatalogo(
      final CatalogoRequestDto request) {

    final IcmParamcalcatalogoBlock param = this.icmWsCalcIncomeMapper.asIcmParamcalcatalogoBlock(request);
    final GetcatalogoOutput catalogo = this.meta4ClientPool.getcatalogo(param);
    return this.icmWsCalcIncomeMapper.asCatalogoResponseDto(catalogo);

  }

  @Cacheable(value = GET_TIPOS_HORA, key = "{#request.idOrigen, #request.idsEmpresa}")
  public TiposHoraResponseDto getTiposHora(
      final TiposHoraRequestDto request) {

    final IcmParamcaltiposhoraBlock param = this.icmWsCalcIncomeMapper.asIcmParamcaltiposhoraBlock(request);
    final GettiposhoraOutput tiposhora = this.meta4ClientPool.gettiposhora(param);

    return this.icmWsCalcIncomeMapper.asTiposHoraResponseDto(tiposhora);

  }

  public UsuarioResponseDto getMail(
      final UsuarioRequestDto request) {
    final IcmParamcalusuarioBlock param = this.icmWsCalcIncomeMapper
        .asIcmParamcalusuarioBlock(request);
    final GetmailOutput mail = this.meta4ClientPool.getmail(param);
    return this.icmWsCalcIncomeMapper.asUsuarioResponseDto(mail);
  }

  @Cacheable(value = GET_CLASES, key = "{#request.cclIdOrigen}")
  public ClaseResponseDto getClases(
      final ClaseRequestDto request) {
    final IcmParamcalorigenBlock param = this.icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(request);
    final GetclasesOutput clases = this.meta4ClientPool.getclases(param);
    return this.icmWsCalcIncomeMapper.asClaseResponseDto(clases);
  }

  public LiquidacionResponseDto liquidacion(
      final LiquidacionRequestDto request) {
    final LiquidacionResponseDto result = new LiquidacionResponseDto();

    final IcmParamcalliquidacionBlock param = this.icmWsCalcIncomeMapper
        .asIcmParamcalliquidacionBlock(request.getData());
    final LiquidacionOutput liquidacion = this.meta4ClientPool.liquidacion(param);

    if ((liquidacion != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, liquidacion.getReturn()) == 0)
        && (liquidacion.getIcmResultadoguardado() != null) && CollectionUtils
            .isNotEmpty(liquidacion.getIcmResultadoguardado().getIcmResultadoguardadoRecordSet())) {
      final List<LiquidacionResultItemDto> items = this.icmWsCalcIncomeMapper
          .asLiquidacionResultItemDto(
              liquidacion.getIcmResultadoguardado().getIcmResultadoguardadoRecordSet());
      result.setData(items);
    }
    return result;
  }

  public PlanificacionResponseDto planificacion(
      final PlanificacionRequestDto request) {
    final PlanificacionResponseDto result = new PlanificacionResponseDto();

    final IcmParamcalplanificadorBlock param = this.icmWsCalcIncomeMapper
        .asIcmParamcalplanificadorBlock(request.getData());
    final PlanificacionOutput planificacion = this.meta4ClientPool.planificacion(param);

    if ((planificacion != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, planificacion.getReturn()) == 0)
        && (planificacion.getIcmResultadoguardado() != null) && CollectionUtils
            .isNotEmpty(planificacion.getIcmResultadoguardado().getIcmResultadoguardadoRecordSet())) {
      final List<PlanificacionResultItemDto> items = this.icmWsCalcIncomeMapper
          .asPlanificacionResultItemDto(
              planificacion.getIcmResultadoguardado().getIcmResultadoguardadoRecordSet());
      result.setData(items);
    }
    return result;
  }

  public EstadoWlocResponseDto getEstadoWloc(final EstadoWlocRequestDto request) {
    final EstadoWlocResponseDto result = new EstadoWlocResponseDto();
    final IcmParamcaltiendasBlock param1 = this.icmWsCalcIncomeMapper
        .asIcmParamcaltiendasBlock(request.getData());
    final IcmParametrospaginacionBlock param2 = this.icmWsCalcIncomeMapper
        .asIcmParametrospaginacionBlock(request.getPage());
    final GetestadowlocOutput getestadowlocOutput = this.meta4ClientPool.getEstadoWloc(
        param1, param2);
    if ((getestadowlocOutput != null)
        && (Double.compare(NumberUtils.DOUBLE_ZERO, getestadowlocOutput.getReturn()) == 0)) {
      if (getestadowlocOutput.getIcmParametrospaginacion() != null) {
        final PageDto page = this.icmWsCalcIncomeMapper
            .asPageDto(getestadowlocOutput.getIcmParametrospaginacion());
        result.setPage(page);
      }
      if ((getestadowlocOutput.getIcmListaestado() != null)
          && CollectionUtils
              .isNotEmpty(getestadowlocOutput.getIcmListaestado()
                  .getIcmListaestadoRecordSet())) {
        final List<EstadoWlocResultItemDto> items = this.icmWsCalcIncomeMapper
            .asEstadoWlocResultItemDto(
                getestadowlocOutput.getIcmListaestado()
                    .getIcmListaestadoRecordSet());
        result.setData(items);
      }
    }
    return result;
  }

}
