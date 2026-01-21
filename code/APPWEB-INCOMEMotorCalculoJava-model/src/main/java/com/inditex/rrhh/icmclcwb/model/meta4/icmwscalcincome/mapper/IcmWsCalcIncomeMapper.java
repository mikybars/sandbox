package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaRequestItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaCondicionesBaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaCondicionesDestinoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaValoresBaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaValoresDestinoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.ListaCondicionesPoliticasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.ListaValoresPoliticasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.AvisosGuardadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.AvisosGuardadoResultItemParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.ErorresGuardadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.ErroresGuardadoResultItemParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoRequestItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultErrorDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcatalogoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetclasesOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfiguracionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetmailOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetsistdestinoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiposhoraOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmAvisosguardadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmAvisosguardadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmErroresguardadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmErroresguardadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaausenciasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacadenasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacatalogoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaclasesRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacondicionesbaseRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacondicionesdestinoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacondicionespoliticaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfchdiasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfchventaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfiguracionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconforigenRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfpreciohoraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListadesplazrealRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempresasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaestadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaestructuraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListamailRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListamotivosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListamultiempresaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaorigenesRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaperiodosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapoliticasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapresenciamanwlocRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapresupuestosrangoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapresupuestoswlocRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListasincroRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiposhoraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListavaloresbaseRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListavaloresbasemanRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListavaloresdestinoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListavaloresdestinomanRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListavalorespoliticaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaventacongeladaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaventamanwlocRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcadenaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcadenaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcatalogoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcatalogoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchdiasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchventaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchventaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconforigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconforigenRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfpreciohoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfpreciohoraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaldesplazrealBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaldesplazrealRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosdesplazBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosdesplazRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadospresenciaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadospresenciaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalflagcalculaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalflagcalculaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalliquidacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalliquidacionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalmotivosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalmotivosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalmultiempresaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalplanificadorBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalplanificadorRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresenciamanualBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresenciamanualRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestosrangoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestosrangoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsincroBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsincroRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsistdestinoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiposhoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalusuarioBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalventacongeladaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalventacongeladaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmResultadoguardadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmResultadoguardadoRecord;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {CollectionUtils.class, Collections.class, StringUtils.class, Meta4Constants.class})
@DecoratedWith(IcmWsCalcIncomeMapperDecorator.class)
public interface IcmWsCalcIncomeMapper {

  @Mapping(target = "tipoOrden", source = "tipoorden", defaultValue = "")
  @Mapping(target = "campoOrden", source = "campoorden", defaultValue = "")
  @Mapping(target = "idBusqueda", source = "idbusqueda", defaultValue = "")
  @Mapping(target = "numeroPagina", source = "numeropagina")
  @Mapping(target = "numeroTotalPaginas", source = "numerototalpaginas")
  @Mapping(target = "numeroRegistrosPagina", source = "numeroregistrospagina")
  @Mapping(target = "numeroTotalResultados", source = "numerototalresultados")
  PageDto asPageDto(IcmParametrospaginacionBlock src);

  @InheritInverseConfiguration
  @Mapping(target = "tipoorden", source = "tipoOrden", defaultValue = "")
  @Mapping(target = "campoorden", source = "campoOrden", defaultValue = "")
  @Mapping(target = "idbusqueda", source = "idBusqueda", defaultValue = "")
  @Mapping(target = "icmParametrospaginacionRecordSet", ignore = true)
  IcmParametrospaginacionBlock asIcmParametrospaginacionBlock(PageDto src);

  @InheritInverseConfiguration
  @Mapping(target = "ambito", ignore = true)
  @Mapping(target = "idempresa",
      expression = "java(CollectionUtils.isNotEmpty(src.getIdsEmpresa()) ? src.getIdsEmpresa().get(0) : null)")
  IcmParametrosentradaBlock asIcmParametrosentradaBlock(GenericFilterDto src);

  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idCadena", source = "idcadena")
  @Mapping(target = "idsEmpresa",
      expression = "java(StringUtils.isNotBlank(src.getIdempresa()) ? Collections.singletonList(src.getIdempresa()) : new ArrayList<>())")
  @Mapping(target = "item", source = "icmParametrosentradaRecordSet")
  GenericFilterDto asGenericFilterDto(IcmParametrosentradaBlock src);

  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idsEmpresa", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "item", source = "icmParamcalestructuraRecordSet")
  GenericFilterDto asGenericFilterDto(IcmParamcalestructuraBlock src);

  @Mapping(target = "item", source = "icmParamcalsociedadRecordSet")
  @Mapping(target = "fechaInicio", ignore = true)
  @Mapping(target = "fechaFin", ignore = true)
  @Mapping(target = "idOrigen", ignore = true)
  @Mapping(target = "idsEmpresa", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  GenericFilterDto asGenericFilterDto(IcmParamcalsociedadBlock src);

  @Mapping(target = "item", source = "icmParamcalorigenRecordSet")
  @Mapping(target = "fechaInicio", ignore = true)
  @Mapping(target = "fechaFin", ignore = true)
  @Mapping(target = "idOrigen", ignore = true)
  @Mapping(target = "idsEmpresa", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  GenericFilterDto asGenericFilterDto(IcmParamcalorigenBlock src);

  @Mapping(target = "item", source = "icmParamcalperiodoRecordSet")
  @Mapping(target = "fechaInicio", ignore = true)
  @Mapping(target = "fechaFin", ignore = true)
  @Mapping(target = "idOrigen", ignore = true)
  @Mapping(target = "idsEmpresa", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  GenericFilterDto asGenericFilterDto(IcmParamcalperiodoBlock src);

  @InheritInverseConfiguration
  IcmParamcalestructuraBlock asIcmParamcalestructuraBlock(GenericFilterDto src);

  @InheritInverseConfiguration
  IcmParamcalestructuraBlock asIcmParamcalestructuraBlock(EstructurasComFilterDto src);

  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = "yyyy-MM-dd")
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = "yyyy-MM-dd")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "item", source = "icmParamcalestructuraRecordSet")
  EstructurasComFilterDto asEstructurasComFilterDto(IcmParamcalestructuraBlock src);

  @InheritInverseConfiguration
  IcmParamcalestructuraRecord asIcmParamcalestructuraRecord(GenericFilterParametersDto src);

  @InheritInverseConfiguration
  IcmParamcalestructuraRecord asIcmParamcalestructuraRecord(EstructurasComFilterParametersDto src);

  @Mapping(target = "idEmpleado", source = "idempleado")
  @Mapping(target = "orEmpleado", source = "orempleado")
  @Mapping(target = "idLugarTrabajo", ignore = true)
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "ambito", ignore = true)
  @Mapping(target = "idPais", ignore = true)
  @Mapping(target = "abierto", ignore = true)
  @Mapping(target = "vigente", ignore = true)
  @Mapping(target = "idTipoHora", ignore = true)
  @Mapping(target = "idEmpleadoLocal", ignore = true)
  @Mapping(target = "idLugarTrabajoMtu", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "idOrigenReg", ignore = true)
  @Mapping(target = "idSociedadReg", ignore = true)
  @Mapping(target = "idEstado", ignore = true)
  @Mapping(target = "idRegion", ignore = true)
  @Mapping(target = "idPeriodo", ignore = true)
  @Mapping(target = "idUsuario", ignore = true)
  @Mapping(target = "resultado", ignore = true)
  @Mapping(target = "fechaDesde", ignore = true)
  @Mapping(target = "fechaHasta", ignore = true)
  @Mapping(target = "idCadenaReg", ignore = true)
  @Mapping(target = "idPoblacion", ignore = true)
  @Mapping(target = "idTipoProceso", ignore = true)
  @Mapping(target = "nombreEmpleado", ignore = true)
  @Mapping(target = "fechaFinCalculo", ignore = true)
  @Mapping(target = "apellidoEmpleado", ignore = true)
  @Mapping(target = "fechaInicioCalculo", ignore = true)
  @Mapping(target = "idManualProgramado", ignore = true)
  @Mapping(target = "fechaFinExportacion", ignore = true)
  @Mapping(target = "fechaInicioExportacion", ignore = true)
  GenericFilterParametersDto asGenericFilterParametersDto(IcmParamcalestructuraRecord src);

  @Mapping(target = "idSociedadReg", source = "idsociedad")
  @Mapping(target = "idEmpleado", ignore = true)
  @Mapping(target = "orEmpleado", ignore = true)
  @Mapping(target = "idLugarTrabajo", ignore = true)
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "ambito", ignore = true)
  @Mapping(target = "idPais", ignore = true)
  @Mapping(target = "abierto", ignore = true)
  @Mapping(target = "vigente", ignore = true)
  @Mapping(target = "idTipoHora", ignore = true)
  @Mapping(target = "idEmpleadoLocal", ignore = true)
  @Mapping(target = "idLugarTrabajoMtu", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "idOrigenReg", ignore = true)
  @Mapping(target = "idPeriodo", ignore = true)
  @Mapping(target = "idEstado", ignore = true)
  @Mapping(target = "idRegion", ignore = true)
  @Mapping(target = "idUsuario", ignore = true)
  @Mapping(target = "resultado", ignore = true)
  @Mapping(target = "fechaDesde", ignore = true)
  @Mapping(target = "fechaHasta", ignore = true)
  @Mapping(target = "idCadenaReg", ignore = true)
  @Mapping(target = "idPoblacion", ignore = true)
  @Mapping(target = "idTipoProceso", ignore = true)
  @Mapping(target = "nombreEmpleado", ignore = true)
  @Mapping(target = "fechaFinCalculo", ignore = true)
  @Mapping(target = "apellidoEmpleado", ignore = true)
  @Mapping(target = "fechaInicioCalculo", ignore = true)
  @Mapping(target = "idManualProgramado", ignore = true)
  @Mapping(target = "fechaFinExportacion", ignore = true)
  @Mapping(target = "fechaInicioExportacion", ignore = true)
  GenericFilterParametersDto asGenericFilterParametersDto(IcmParamcalsociedadRecord src);

  @Mapping(target = "idOrigenReg", source = "idorigen")
  @Mapping(target = "idEmpleado", ignore = true)
  @Mapping(target = "orEmpleado", ignore = true)
  @Mapping(target = "idLugarTrabajo", ignore = true)
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "ambito", ignore = true)
  @Mapping(target = "idPais", ignore = true)
  @Mapping(target = "abierto", ignore = true)
  @Mapping(target = "vigente", ignore = true)
  @Mapping(target = "idTipoHora", ignore = true)
  @Mapping(target = "idEmpleadoLocal", ignore = true)
  @Mapping(target = "idLugarTrabajoMtu", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "idSociedadReg", ignore = true)
  @Mapping(target = "idPeriodo", ignore = true)
  @Mapping(target = "idEstado", ignore = true)
  @Mapping(target = "idRegion", ignore = true)
  @Mapping(target = "idUsuario", ignore = true)
  @Mapping(target = "resultado", ignore = true)
  @Mapping(target = "fechaDesde", ignore = true)
  @Mapping(target = "fechaHasta", ignore = true)
  @Mapping(target = "idCadenaReg", ignore = true)
  @Mapping(target = "idPoblacion", ignore = true)
  @Mapping(target = "idTipoProceso", ignore = true)
  @Mapping(target = "nombreEmpleado", ignore = true)
  @Mapping(target = "fechaFinCalculo", ignore = true)
  @Mapping(target = "apellidoEmpleado", ignore = true)
  @Mapping(target = "fechaInicioCalculo", ignore = true)
  @Mapping(target = "idManualProgramado", ignore = true)
  @Mapping(target = "fechaFinExportacion", ignore = true)
  @Mapping(target = "fechaInicioExportacion", ignore = true)
  GenericFilterParametersDto asGenericFilterParametersDto(IcmParamcalorigenRecord src);

  @Mapping(target = "idSociedadReg", source = "idsociedad")
  @Mapping(target = "idPeriodo", source = "idperiodo")
  @Mapping(target = "idEmpleado", ignore = true)
  @Mapping(target = "orEmpleado", ignore = true)
  @Mapping(target = "idLugarTrabajo", ignore = true)
  @Mapping(target = "ambito", ignore = true)
  @Mapping(target = "idPais", ignore = true)
  @Mapping(target = "idTipoHora", ignore = true)
  @Mapping(target = "idEmpleadoLocal", ignore = true)
  @Mapping(target = "idLugarTrabajoMtu", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "idOrigenReg", ignore = true)
  @Mapping(target = "idEstado", ignore = true)
  @Mapping(target = "idRegion", ignore = true)
  @Mapping(target = "idUsuario", ignore = true)
  @Mapping(target = "resultado", ignore = true)
  @Mapping(target = "fechaDesde", ignore = true)
  @Mapping(target = "fechaHasta", ignore = true)
  @Mapping(target = "idCadenaReg", ignore = true)
  @Mapping(target = "idPoblacion", ignore = true)
  @Mapping(target = "idTipoProceso", ignore = true)
  @Mapping(target = "nombreEmpleado", ignore = true)
  @Mapping(target = "fechaFinCalculo", ignore = true)
  @Mapping(target = "apellidoEmpleado", ignore = true)
  @Mapping(target = "fechaInicioCalculo", ignore = true)
  @Mapping(target = "idManualProgramado", ignore = true)
  @Mapping(target = "fechaFinExportacion", ignore = true)
  @Mapping(target = "fechaInicioExportacion", ignore = true)
  GenericFilterParametersDto asGenericFilterParametersDto(IcmParamcalperiodoRecord src);

  @Mapping(target = "idEmpleado", source = "idempleado")
  @Mapping(target = "orEmpleado", source = "orempleado")
  @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
  @Mapping(target = "activo", source = "activo")
  @Mapping(target = "abierto", source = "abierto")
  @Mapping(target = "idTipoHora", source = "idtipohora")
  @Mapping(target = "idEmpleadoLocal", source = "idempleadolocal")
  @Mapping(target = "idLugarTrabajoMtu", source = "idlugartrabajomtu")
  @Mapping(target = "idCadena", source = "idcadenareg")
  @Mapping(target = "idOrigenReg", source = "idorigenreg")
  @Mapping(target = "idSociedadReg", source = "idsociedadreg")
  @Mapping(target = "ambito", ignore = true)
  @Mapping(target = "idPais", ignore = true)
  @Mapping(target = "idEstado", ignore = true)
  @Mapping(target = "idRegion", ignore = true)
  @Mapping(target = "idPeriodo", ignore = true)
  @Mapping(target = "idUsuario", ignore = true)
  @Mapping(target = "fechaDesde", ignore = true)
  @Mapping(target = "fechaHasta", ignore = true)
  @Mapping(target = "idCadenaReg", ignore = true)
  @Mapping(target = "idPoblacion", ignore = true)
  @Mapping(target = "idTipoProceso", ignore = true)
  @Mapping(target = "nombreEmpleado", ignore = true)
  @Mapping(target = "fechaFinCalculo", ignore = true)
  @Mapping(target = "apellidoEmpleado", ignore = true)
  @Mapping(target = "fechaInicioCalculo", ignore = true)
  @Mapping(target = "idManualProgramado", ignore = true)
  @Mapping(target = "fechaFinExportacion", ignore = true)
  @Mapping(target = "fechaInicioExportacion", ignore = true)
  GenericFilterParametersDto asGenericFilterParametersDto(IcmParametrosentradaRecord src);

  @Mapping(target = "idEmpleado", source = "idempleado")
  @Mapping(target = "orEmpleado", source = "orempleado")
  @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
  @Mapping(target = "idEmpleadoLocal", source = "idempleadolocal")
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "ambito", ignore = true)
  @Mapping(target = "idPais", ignore = true)
  @Mapping(target = "abierto", ignore = true)
  @Mapping(target = "vigente", ignore = true)
  @Mapping(target = "idTipoHora", ignore = true)
  @Mapping(target = "idLugarTrabajoMtu", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "idOrigenReg", ignore = true)
  @Mapping(target = "idSociedadReg", ignore = true)
  @Mapping(target = "idEstado", ignore = true)
  @Mapping(target = "idRegion", ignore = true)
  @Mapping(target = "idPeriodo", ignore = true)
  @Mapping(target = "idUsuario", ignore = true)
  @Mapping(target = "resultado", ignore = true)
  @Mapping(target = "fechaDesde", ignore = true)
  @Mapping(target = "fechaHasta", ignore = true)
  @Mapping(target = "idCadenaReg", ignore = true)
  @Mapping(target = "idPoblacion", ignore = true)
  @Mapping(target = "idTipoProceso", ignore = true)
  @Mapping(target = "nombreEmpleado", ignore = true)
  @Mapping(target = "fechaFinCalculo", ignore = true)
  @Mapping(target = "apellidoEmpleado", ignore = true)
  @Mapping(target = "fechaInicioCalculo", ignore = true)
  @Mapping(target = "idManualProgramado", ignore = true)
  @Mapping(target = "fechaFinExportacion", ignore = true)
  @Mapping(target = "fechaInicioExportacion", ignore = true)
  EstructurasComFilterParametersDto asEstructurasComFilterParametersDto(IcmParamcalestructuraRecord src);

  @Mapping(target = "idEmpleado", source = "idempleado")
  @Mapping(target = "orEmpleado", source = "orempleado")
  @Mapping(target = "idEmpleadoLocal", source = "idempleadolocal")
  @Mapping(target = "idLugarTrabajo", ignore = true)
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "ambito", ignore = true)
  @Mapping(target = "idPais", ignore = true)
  @Mapping(target = "abierto", ignore = true)
  @Mapping(target = "vigente", ignore = true)
  @Mapping(target = "idTipoHora", ignore = true)
  @Mapping(target = "idLugarTrabajoMtu", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "idOrigenReg", ignore = true)
  @Mapping(target = "idSociedadReg", ignore = true)
  @Mapping(target = "idEstado", ignore = true)
  @Mapping(target = "idRegion", ignore = true)
  @Mapping(target = "idPeriodo", ignore = true)
  @Mapping(target = "idUsuario", ignore = true)
  @Mapping(target = "resultado", ignore = true)
  @Mapping(target = "fechaDesde", ignore = true)
  @Mapping(target = "fechaHasta", ignore = true)
  @Mapping(target = "idCadenaReg", ignore = true)
  @Mapping(target = "idPoblacion", ignore = true)
  @Mapping(target = "idTipoProceso", ignore = true)
  @Mapping(target = "nombreEmpleado", ignore = true)
  @Mapping(target = "fechaFinCalculo", ignore = true)
  @Mapping(target = "apellidoEmpleado", ignore = true)
  @Mapping(target = "fechaInicioCalculo", ignore = true)
  @Mapping(target = "idManualProgramado", ignore = true)
  @Mapping(target = "fechaFinExportacion", ignore = true)
  @Mapping(target = "fechaInicioExportacion", ignore = true)
  GenericFilterParametersDto asEstructurasComFilterParametersDto(IcmParamcalempleadoRecord src);

  @InheritInverseConfiguration
  @Mapping(target = "idempresa", ignore = true)
  IcmParamcalempleadoRecord asIcmParamcalempleadoRecord(GenericFilterParametersDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "idempresa", ignore = true)
  @Mapping(target = "idcadena", ignore = true)
  @Mapping(target = "idempleado", ignore = true)
  @Mapping(target = "orempleado", ignore = true)
  @Mapping(target = "idempleadolocal", ignore = true)
  IcmParamcalempleadoRecord asIcmParamcalempleadoRecord(SearchEmpleadosFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "idempresa", ignore = true)
  @Mapping(target = "idempleado", ignore = true)
  @Mapping(target = "orempleado", ignore = true)
  @Mapping(target = "idempleadolocal", ignore = true)
  IcmParamcalempleadoRecord asIcmParamcalempleadoRecord(GenericFilterDto src);

  @InheritInverseConfiguration
  IcmParamcalsociedadBlock asIcmParamcalsociedadBlock(GenericFilterDto src);

  @InheritInverseConfiguration
  IcmParamcalsociedadRecord asIcmParamcalsociedadRecord(GenericFilterParametersDto src);

  @Mapping(target = "icmParamcalorigenRecordSet", ignore = true)
  IcmParamcalorigenBlock asIcmParamcalorigenBlock(ClaseRequestDto src);

  @InheritInverseConfiguration
  IcmParamcalorigenBlock asIcmParamcalorigenBlock(GenericFilterDto src);

  @InheritInverseConfiguration
  IcmParamcalorigenRecord asIcmParamcalorigenRecord(GenericFilterParametersDto src);

  @Mapping(target = "idorigen", source = "cclIdOrigen")
  IcmParamcalorigenRecord asIcmParamcalorigenRecord(ClaseRequestDto src);

  @InheritInverseConfiguration
  IcmParamcalperiodoBlock asIcmParamcalperiodoBlock(GenericFilterDto src);

  @InheritInverseConfiguration
  @Mapping(target = "idorigen", ignore = true)
  IcmParamcalperiodoRecord asIcmParamcalperiodoRecord(GenericFilterParametersDto src);

  @InheritInverseConfiguration
  @Mapping(target = "idpais", ignore = true)
  @Mapping(target = "idestado", ignore = true)
  @Mapping(target = "idregion", ignore = true)
  @Mapping(target = "idperiodo", ignore = true)
  @Mapping(target = "idusuario", ignore = true)
  @Mapping(target = "fechadesde", ignore = true)
  @Mapping(target = "fechahasta", ignore = true)
  @Mapping(target = "idpoblacion", ignore = true)
  @Mapping(target = "idtipoproceso", ignore = true)
  @Mapping(target = "nombreempleado", ignore = true)
  @Mapping(target = "fechafincalculo", ignore = true)
  @Mapping(target = "apellidoempleado", ignore = true)
  @Mapping(target = "fechainiciocalculo", ignore = true)
  @Mapping(target = "idmanualprogramado", ignore = true)
  @Mapping(target = "fechafinexportacion", ignore = true)
  @Mapping(target = "fechainicioexportacion", ignore = true)
  IcmParametrosentradaRecord asIcmParametrosentradaRecord(GenericFilterParametersDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "idPais", source = "idpais")
  @Mapping(target = "fechaInicio", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaFin", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "idCadena", source = "idcadena")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idEmpresa", source = "idempresa")
  @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
  @Mapping(target = "idLugarTrabajoMtu", source = "idlugartrabajomtu")
  @Mapping(target = "esComisionable", source = "escomisionable")
  @Mapping(target = "calcula", source = "calcula")
  @Mapping(target = "idTiendaMtu", ignore = true)
  @Mapping(target = "fechaFestivo", ignore = true)
  @Mapping(target = "idProvincia", source = "idpoblacion")
  GenericTiendaResultItemDto asGenericTiendaResultItemDto(IcmListatiendasRecord src);

  @InheritInverseConfiguration
  @Mapping(target = "importe", ignore = true)
  @Mapping(target = "fechafin", ignore = true)
  @Mapping(target = "idestado", ignore = true)
  @Mapping(target = "idregion", ignore = true)
  @Mapping(target = "nombrepais", ignore = true)
  @Mapping(target = "fechainicio", ignore = true)
  @Mapping(target = "idpoblacion", ignore = true)
  @Mapping(target = "fechacalculo", ignore = true)
  @Mapping(target = "fechafestivo", ignore = true)
  @Mapping(target = "nombreestado", ignore = true)
  @Mapping(target = "nombreregion", ignore = true)
  @Mapping(target = "nombreempresa", ignore = true)
  @Mapping(target = "nombrepoblacion", ignore = true)
  @Mapping(target = "fechaexportacion", ignore = true)
  @Mapping(target = "nombrelugartrabajo", ignore = true)
  IcmListatiendasRecord asIcmListatiendasRecord(GenericTiendaResultItemDto src);

  @InheritInverseConfiguration
  @Mapping(target = "boletaap", ignore = true)
  @Mapping(target = "fechafin", ignore = true)
  @Mapping(target = "idestado", ignore = true)
  @Mapping(target = "fechafincom", ignore = true)
  @Mapping(target = "fechafinpar", ignore = true)
  @Mapping(target = "fechafinsec", ignore = true)
  @Mapping(target = "fechainicio", ignore = true)
  @Mapping(target = "fechacalculo", ignore = true)
  @Mapping(target = "nombreestado", ignore = true)
  @Mapping(target = "nombreempresa", ignore = true)
  @Mapping(target = "fechainiciocom", ignore = true)
  @Mapping(target = "fechainiciopar", ignore = true)
  @Mapping(target = "fechainiciosec", ignore = true)
  @Mapping(target = "nombreempleado", ignore = true)
  @Mapping(target = "fechaexportacion", ignore = true)
  @Mapping(target = "apellidosempleado", ignore = true)
  @Mapping(target = "icmListasecciones", ignore = true)
  IcmListaempleadosRecord asIcmListatiendasRecord(GenericEmpleadoResultItemDto src);

  @InheritInverseConfiguration
  IcmListaperiodosRecord asIcmListatiendasRecord(PeriodosResultItemDto src);

  List<GenericTiendaResultItemDto> asGenericTiendaResultItemDtos(List<IcmListatiendasRecord> src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fechaFin", source = "fechafin")
  @Mapping(target = "idCadena", source = "idcadena")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idEmpresa", source = "idempresa")
  @Mapping(target = "idConcepto", source = "idconcepto")
  @Mapping(target = "idProducto", source = "idproducto")
  @Mapping(target = "porcentaje", source = "porcentaje")
  @Mapping(target = "fechaInicio", source = "fechainicio")
  @Mapping(target = "idAgrupacion", source = "idagrupacion")
  AgrupOnlineResultItemDto asAgrupOnlineResultItemDto(IcmListaconfiguracionRecord src);

  @InheritInverseConfiguration
  IcmListaconfiguracionRecord asIcmListaconfiguracionRecord(AgrupOnlineResultItemDto src);

  List<AgrupOnlineResultItemDto> asAgrupOnlineResultItemDtos(List<IcmListaconfiguracionRecord> src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fecha", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaInicio", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaFin", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaInicioSec", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaFinSec", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaInicioPar", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaFinPar", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaInicioCom", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaFinCom", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "idCadena", source = "idcadena")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idPais", source = "idpais")
  @Mapping(target = "idEmpresa", source = "idempresa")
  @Mapping(target = "idEmpleado", source = "idempleado")
  @Mapping(target = "orEmpleado", source = "orempleado")
  @Mapping(target = "idSeccion", source = "idseccion")
  @Mapping(target = "idTipoHora", source = "idtipohora")
  @Mapping(target = "idLugarTrabajoMtu", source = "idlugartrabajomtu")
  @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
  @Mapping(target = "idEmpleadoLocal", source = "idempleadolocal")
  @Mapping(target = "coefJornada", source = "coefjornada")
  @Mapping(target = "importe", source = "importe")
  @Mapping(target = "minutos", source = "minutos")
  @Mapping(target = "idPuesto", source = "idpuesto")
  @Mapping(target = "fechaInicioLoc", ignore = true)
  @Mapping(target = "fechaFinLoc", ignore = true)
  @Mapping(target = "fechaAntiguedad", ignore = true)
  GenericEmpleadoResultItemDto asGenericEmpleadoResultItemDto(IcmListaempleadosRecord src);

  List<GenericEmpleadoResultItemDto> asGenericEmpleadoResultItemDtos(List<IcmListaempleadosRecord> src);

  @Mapping(target = "fechaInicio", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaFin", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "idEmpleado", source = "idempleado")
  @Mapping(target = "orEmpleado", source = "orempleado")
  @Mapping(target = "tipo", source = "tipo")
  AusenciasResultItemDto asAusenciasResultItemDto(IcmListaausenciasRecord src);

  @InheritInverseConfiguration
  @Mapping(target = "fechafin", ignore = true)
  @Mapping(target = "fechainicio", ignore = true)
  IcmListaausenciasRecord asIcmListaausenciasRecord(AusenciasResultItemDto src);

  List<AusenciasResultItemDto> asAusenciasResultItemDtos(List<IcmListaausenciasRecord> src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fecha", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaInicio", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaFin", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaInicioSec", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaFinSec", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaInicioPar", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaFinPar", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaInicioCom", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaFinCom", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "fechaAntiguedad", dateFormat = Meta4Constants.META4_DATE_FULL, ignore = true)
  @Mapping(target = "idCadena", source = "idcadena")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idEmpresa", source = "idempresa")
  @Mapping(target = "idEmpleado", source = "idempleado")
  @Mapping(target = "orEmpleado", source = "orempleado")
  @Mapping(target = "idSeccion", source = "idseccion")
  @Mapping(target = "idLugarTrabajoMtu", source = "idlugartrabajomtu")
  @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
  @Mapping(target = "idEmpleadoLocal", source = "idempleadolocal")
  @Mapping(target = "fechaInicioLoc", ignore = true)
  @Mapping(target = "fechaFinLoc", ignore = true)
  @Mapping(target = "idPais", ignore = true)
  @Mapping(target = "idTipoHora", ignore = true)
  @Mapping(target = "coefJornada", ignore = true)
  @Mapping(target = "importe", ignore = true)
  @Mapping(target = "minutos", ignore = true)
  @Mapping(target = "idPuesto", ignore = true)
  GenericEmpleadoResultItemDto asGenericEmpleadoResultItemDtosSearchEmpleados(IcmListaempleadoRecord src);

  List<GenericEmpleadoResultItemDto> asGenericEmpleadoResultItemDtosSearchEmpleados(List<IcmListaempleadoRecord> src);

  @InheritInverseConfiguration
  @Mapping(target = "fechafin", ignore = true)
  @Mapping(target = "fechafinloc", ignore = true)
  @Mapping(target = "fechafinsec", ignore = true)
  @Mapping(target = "fechainicio", ignore = true)
  @Mapping(target = "fechainicioloc", ignore = true)
  @Mapping(target = "fechainiciosec", ignore = true)
  @Mapping(target = "fechaantiguedad", ignore = true)
  IcmListaempleadoRecord asIcmListaempleadoRecord(GenericEmpleadoResultItemDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idPeriodo", source = "idperiodo")
  @Mapping(target = "nombrePeriodo", source = "nombreperiodo")
  @Mapping(target = "abierto", source = "abierto")
  @Mapping(target = "activo", source = "activo")
  @Mapping(target = "modificado", source = "modificado")
  @Mapping(target = "nuevo", source = "nuevo")
  @Mapping(target = "borrado", source = "borrado")
  PeriodosResultItemDto asPeriodosResultItemDto(IcmListaperiodosRecord src);

  List<PeriodosResultItemDto> asPeriodosResultItemDtos(List<IcmListaperiodosRecord> src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idEmpleado", source = "idempleado")
  @Mapping(target = "orEmpleado", source = "orempleado")
  @Mapping(target = "idEstructura", source = "idestructura")
  @Mapping(target = "idEmpleadoLocal", source = "idempleadolocal")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idTpEstructura", source = "idtpestructura")
  @Mapping(target = "icmListaCondicionesBase", ignore = true)
  @Mapping(target = "icmListaCondicionesDestino", ignore = true)
  EstructurasComResultItemDto asEstructurasComResultItemDto(IcmListaestructuraRecord src);

  @InheritInverseConfiguration
  IcmListaestructuraRecord asIcmListaestructuraRecord(EstructurasComResultItemDto src);

  List<EstructurasComResultItemDto> asEstructurasComResultItemDtos(List<IcmListaestructuraRecord> src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "diaD", source = "diad")
  @Mapping(target = "diaJ", source = "diaj")
  @Mapping(target = "diaL", source = "dial")
  @Mapping(target = "diaM", source = "diam")
  @Mapping(target = "diaS", source = "dias")
  @Mapping(target = "diaV", source = "diav")
  @Mapping(target = "diaX", source = "diax")
  @Mapping(target = "festivo", source = "festivo")
  @Mapping(target = "idTipoCalculo", source = "idtipocalculo")
  @Mapping(target = "idTipoComision", source = "idtipocomision")
  @Mapping(target = "idEstructuraBase", source = "idestructurabase")
  @Mapping(target = "icmListaValoresBase", source = "icmListavaloresbase.icmListavaloresbaseRecordSet")
  ListaCondicionesBaseResultItemDto asListaCondicionesBaseResultItemDto(IcmListacondicionesbaseRecord src);

  List<ListaCondicionesBaseResultItemDto> asListaCondicionesBaseResultItemDto(
      List<IcmListacondicionesbaseRecord> src);

  @InheritInverseConfiguration
  IcmListacondicionesbaseRecord asIcmListacondicionesbaseRecord(ListaCondicionesBaseResultItemDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "tope", source = "tope")
  @Mapping(target = "valor", source = "valor")
  @Mapping(target = "idSeccion", source = "idseccion")
  @Mapping(target = "grupoManual", constant = "0")
  @Mapping(target = "idTipoVenta", ignore = true)
  ListaValoresBaseResultItemDto asListaValoresBaseResultItemDto(IcmListavaloresbaseRecord src);

  List<ListaValoresBaseResultItemDto> asListaValoresBaseResultItemDto(List<IcmListavaloresbaseRecord> src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "tope", ignore = true)
  @Mapping(target = "valor", source = "valor")
  @Mapping(target = "idSeccion", constant = "0")
  @Mapping(target = "grupoManual", source = "idgrupomanual")
  @Mapping(target = "idTipoVenta", ignore = true)
  ListaValoresBaseResultItemDto asListaValoresBaseResultItemDto(IcmListavaloresbasemanRecord src);

  List<ListaValoresBaseResultItemDto> asListaValoresBaseResultItemDtoFromIcmListavaloresbasemanRecord(
      List<IcmListavaloresbasemanRecord> src);

  @InheritInverseConfiguration
  IcmListavaloresbaseRecord asIcmListavaloresbaseRecord(ListaValoresBaseResultItemDto src);

  @InheritInverseConfiguration
  IcmListavaloresbasemanRecord asIcmListavaloresbasemanRecord(ListaValoresBaseResultItemDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "diaD", source = "diad")
  @Mapping(target = "diaJ", source = "diaj")
  @Mapping(target = "diaL", source = "dial")
  @Mapping(target = "diaM", source = "diam")
  @Mapping(target = "diaS", source = "dias")
  @Mapping(target = "diaV", source = "diav")
  @Mapping(target = "diaX", source = "diax")
  @Mapping(target = "idTipoCalculo", source = "idtipocalculo")
  @Mapping(target = "idTipoComision", source = "idtipocomision")
  @Mapping(target = "horasOrigen", source = "horasorigen")
  @Mapping(target = "horasDestino", source = "horasdestino")
  @Mapping(target = "idMotivoDesplazamiento", source = "idmotivodesp")
  @Mapping(target = "idTipoOpCalculo", source = "idtipoopccalc")
  @Mapping(target = "idPuestoDestino", source = "idpuestodestino")
  @Mapping(target = "idSeccionDestino", source = "idsecciondestino")
  @Mapping(target = "idTipoReqComision", source = "idtiporeqcomision")
  @Mapping(target = "idEstructuraDestino", source = "idestructuradestino")
  @Mapping(target = "idLugarTrabajoDestino", source = "idlugartrabajodestino")
  @Mapping(target = "idLugarTrabajoDestinoMtu", source = "idlugartrabajodestinomtu")
  @Mapping(target = "idEstructuraAmbito", source = "idestructuraambito")
  @Mapping(target = "festivo", source = "festivo")
  @Mapping(target = "totalCondiciones", source = "totalcondiciones")
  @Mapping(target = "icmListaValoresDestino", source = "icmListavaloresdestino.icmListavaloresdestinoRecordSet")
  ListaCondicionesDestinoResultItemDto asListaCondicionesDestinoResultItemDto(IcmListacondicionesdestinoRecord src);

  List<ListaCondicionesDestinoResultItemDto> asListaCondicionesDestinoResultItemDto(
      List<IcmListacondicionesdestinoRecord> src);

  @InheritInverseConfiguration
  IcmListacondicionesdestinoRecord asIcmListacondicionesdestinoRecord(ListaCondicionesDestinoResultItemDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "tope", source = "tope")
  @Mapping(target = "valor", source = "valor")
  @Mapping(target = "idSeccion", source = "idseccion")
  @Mapping(target = "grupoManual", constant = "0")
  @Mapping(target = "idTipoVenta", ignore = true)
  ListaValoresDestinoResultItemDto asListaValoresDestinoResultItemDto(IcmListavaloresdestinoRecord src);

  List<ListaValoresDestinoResultItemDto> asListaValoresDestinoResultItemDto(List<IcmListavaloresdestinoRecord> src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "tope", ignore = true)
  @Mapping(target = "valor", source = "valor")
  @Mapping(target = "idSeccion", constant = "0")
  @Mapping(target = "grupoManual", source = "idgrupomanual")
  @Mapping(target = "idTipoVenta", ignore = true)
  ListaValoresDestinoResultItemDto asListaValoresDestinoResultItemDto(IcmListavaloresdestinomanRecord src);

  List<ListaValoresDestinoResultItemDto> asListaValoresDestinoResultItemDtoFromIcmListavaloresdestinomanRecord(
      List<IcmListavaloresdestinomanRecord> src);

  @InheritInverseConfiguration
  IcmListavaloresdestinoRecord asIcmListavaloresdestinoRecord(ListaValoresDestinoResultItemDto src);

  @InheritInverseConfiguration
  IcmListavaloresdestinomanRecord asIcmListavaloresdestinomanRecord(ListaValoresDestinoResultItemDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idEmpleado", source = "idempleado")
  @Mapping(target = "orEmpleado", source = "orempleado")
  @Mapping(target = "idEstructura", source = "idestructura")
  @Mapping(target = "idEmpleadoLocal", source = "idempleadolocal")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "icmListaCondicionesPolitica",
      source = "icmListacondicionespolitica.icmListacondicionespoliticaRecordSet")
  @Mapping(target = "importe", ignore = true)
  EstructurasPolResultItemDto asEstructurasPolResultItemDto(IcmListapoliticasRecord src);

  List<EstructurasPolResultItemDto> asEstructurasPolResultItemDto(List<IcmListapoliticasRecord> src);

  @InheritInverseConfiguration
  @Mapping(target = "idtpestructura", ignore = true)
  IcmListapoliticasRecord asIcmListapoliticasRecord(EstructurasPolResultItemDto src);

  @InheritInverseConfiguration
  IcmListaconfchdiasRecord asIcmListapoliticasRecord(ConfChDiasMinimosResultItemDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "excDenominador", source = "excdenominador")
  @Mapping(target = "idTipoPolitica", source = "idtipopolitica")
  @Mapping(target = "numMesesCalcMedia", source = "nummesescalcmedia")
  @Mapping(target = "numHoras", source = "numhoras")
  @Mapping(target = "importeMax", source = "importemax")
  @Mapping(target = "importeMin", source = "importemin")
  @Mapping(target = "idMotivoBaja", source = "idmotivobaja")
  @Mapping(target = "icmListaValoresPoliticas", source = "icmListavalorespolitica.icmListavalorespoliticaRecordSet")
  ListaCondicionesPoliticasResultItemDto asListaCondicionesPoliticasResultItemDto(
      IcmListacondicionespoliticaRecord src);

  List<ListaCondicionesPoliticasResultItemDto> asListaCondicionesPoliticasResultItemDto(
      List<IcmListacondicionespoliticaRecord> src);

  @InheritInverseConfiguration
  @Mapping(target = "nombremotivobaja", ignore = true)
  @Mapping(target = "nombretipopolitica", ignore = true)
  IcmListacondicionespoliticaRecord asIcmListacondicionespoliticaRecord(ListaCondicionesPoliticasResultItemDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "tramo", source = "tramo")
  @Mapping(target = "valor", source = "valor")
  @Mapping(target = "idUnidadTiempo", source = "idunidadtiempo")
  @Mapping(target = "numeroUnidades", source = "numerounidades")
  ListaValoresPoliticasResultItemDto asListaValoresPoliticasResultItemDto(IcmListavalorespoliticaRecord src);

  List<ListaValoresPoliticasResultItemDto> asListaValoresPoliticasResultItemDto(
      List<IcmListavalorespoliticaRecord> src);

  @InheritInverseConfiguration
  IcmListavalorespoliticaRecord asIcmListavalorespoliticaRecord(ListaValoresPoliticasResultItemDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idConcepto", source = "idconcepto")
  @Mapping(target = "porcentaje", source = "porcentaje")
  @Mapping(target = "idAgrupacion", source = "idagrupacion")
  ConfiguracionVentaOnlineResultItemDto asConfiguracionVentaOnlineResultItemDto(IcmListaconfiguracionRecord src);

  List<ConfiguracionVentaOnlineResultItemDto> asConfiguracionVentaOnlineResultItemDto(
      List<IcmListaconfiguracionRecord> src);

  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idCadena", source = "idcadena")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idEmpresa", source = "idempresa")
  @Mapping(target = "idLocalizacion", source = "idlugartrabajomtu")
  @Mapping(target = "idLocalizacionMeta4", source = "idlugartrabajo")
  TiendaOnlineResultItemDto asTiendaOnlineResultItemDto(IcmListatiendasRecord src);

  List<TiendaOnlineResultItemDto> asTiendaOnlineResultItemDto(List<IcmListatiendasRecord> src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idProducto", source = "idproducto")
  ConfiguracionProductoVentaResultItemDto asConfiguracionProductoVentaResultItemDto(IcmListaconfiguracionRecord src);

  List<ConfiguracionProductoVentaResultItemDto> asConfiguracionProductoVentaResultItemDto(
      List<IcmListaconfiguracionRecord> src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "idCadena", source = "idcadena")
  @Mapping(target = "idEmpresa", source = "idempresa")
  CadenaResultItemDto asCadenaResultItemDto(IcmListacadenasRecord src);

  List<CadenaResultItemDto> asCadenaResultItemDto(List<IcmListacadenasRecord> src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "idEmpresa", source = "idempresa")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "nombreEmpresa", source = "nombreempresa")
  EmpresaResultItemDto asEmpresaResultItemDto(IcmListaempresasRecord src);

  List<EmpresaResultItemDto> asEmpresaResultItemDto(List<IcmListaempresasRecord> src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idSociedad", source = "idsociedad")
  OrigenResultItemDto asOrigenResultItemDto(IcmListaorigenesRecord src);

  List<OrigenResultItemDto> asOrigenResultItemDto(List<IcmListaorigenesRecord> src);

  @InheritInverseConfiguration
  IcmParamcalprocesoBlock asIcmParamcalprocesoBlock(SaveProcesoDto src);

  @Mapping(target = "idAmbito", source = "idambito")
  @Mapping(target = "nombreUsuario", source = "idusuario")
  @Mapping(target = "idOrganization", source = "idorganization")
  @Mapping(target = "idPeriodo", source = "idperiodo")
  @Mapping(target = "idTrabajo", source = "idtrabajo")
  @Mapping(target = "idTipoEjecucionCalculo", source = "idtpejeccalculo")
  @Mapping(target = "idTipoEjecucion", source = "idtpejec")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "item", source = "icmParamcalprocesoRecordSet")
  SaveProcesoDto asSaveProcesoDto(IcmParamcalprocesoBlock src);

  @InheritInverseConfiguration
  IcmParamcalprocesoRecord asIcmParamcalprocesoRecord(SaveProcesoParametersDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "idEmpresa", source = "idempresa")
  @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
  @Mapping(target = "idEmpleado", source = "idempleado")
  @Mapping(target = "idEmpleadoLocal", source = "idempleadolocal")
  @Mapping(target = "orEmpleado", source = "orempleado")
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "ambito", ignore = true)
  @Mapping(target = "idPais", ignore = true)
  @Mapping(target = "abierto", ignore = true)
  @Mapping(target = "vigente", ignore = true)
  @Mapping(target = "idTipoHora", ignore = true)
  @Mapping(target = "idLugarTrabajoMtu", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "idOrigenReg", ignore = true)
  @Mapping(target = "idSociedadReg", ignore = true)
  @Mapping(target = "idEstado", ignore = true)
  @Mapping(target = "idRegion", ignore = true)
  @Mapping(target = "idPeriodo", ignore = true)
  @Mapping(target = "idUsuario", ignore = true)
  @Mapping(target = "resultado", ignore = true)
  @Mapping(target = "fechaDesde", ignore = true)
  @Mapping(target = "fechaHasta", ignore = true)
  @Mapping(target = "idCadenaReg", ignore = true)
  @Mapping(target = "idPoblacion", ignore = true)
  @Mapping(target = "idTipoProceso", ignore = true)
  @Mapping(target = "nombreEmpleado", ignore = true)
  @Mapping(target = "fechaFinCalculo", ignore = true)
  @Mapping(target = "apellidoEmpleado", ignore = true)
  @Mapping(target = "fechaInicioCalculo", ignore = true)
  @Mapping(target = "idManualProgramado", ignore = true)
  @Mapping(target = "fechaFinExportacion", ignore = true)
  @Mapping(target = "fechaInicioExportacion", ignore = true)
  SaveProcesoParametersDto asSaveProcesoParametersDto(IcmParamcalprocesoRecord src);

  @Mapping(target = "resultadoOk", ignore = true)
  @Mapping(target = "resultadoError", ignore = true)
  @Mapping(target = "data", source = "icmResultadoguardadoRecordSet")
  SaveResultDto asSaveResultDto(IcmResultadoguardadoBlock src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "literal", ignore = true)
  @Mapping(target = "registroAfectado", ignore = true)
  SaveResultErrorDto asSaveResultErrorDto(IcmResultadoguardadoRecord src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "literal", source = "literal")
  @Mapping(target = "registroAfectado", source = "registroafectado")
  SaveResultErrorDto asSaveResultErrorDto(IcmErroresguardadoRecord src);

  @InheritInverseConfiguration
  IcmParamcalconforigenBlock asIcmParamconfBlock(ConfiguracionesRequestDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "idEmpleado", ignore = true)
  @Mapping(target = "orEmpleado", ignore = true)
  @Mapping(target = "idLugarTrabajo", ignore = true)
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "ambito", ignore = true)
  @Mapping(target = "idPais", ignore = true)
  @Mapping(target = "abierto", ignore = true)
  @Mapping(target = "vigente", ignore = true)
  @Mapping(target = "idTipoHora", ignore = true)
  @Mapping(target = "idEmpleadoLocal", ignore = true)
  @Mapping(target = "idLugarTrabajoMtu", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "idOrigenReg", ignore = true)
  @Mapping(target = "idSociedadReg", ignore = true)
  @Mapping(target = "idEstado", ignore = true)
  @Mapping(target = "idRegion", ignore = true)
  @Mapping(target = "idPeriodo", ignore = true)
  @Mapping(target = "idUsuario", ignore = true)
  @Mapping(target = "resultado", ignore = true)
  @Mapping(target = "fechaDesde", ignore = true)
  @Mapping(target = "fechaHasta", ignore = true)
  @Mapping(target = "idCadenaReg", ignore = true)
  @Mapping(target = "idPoblacion", ignore = true)
  @Mapping(target = "idTipoProceso", ignore = true)
  @Mapping(target = "nombreEmpleado", ignore = true)
  @Mapping(target = "fechaFinCalculo", ignore = true)
  @Mapping(target = "apellidoEmpleado", ignore = true)
  @Mapping(target = "fechaInicioCalculo", ignore = true)
  @Mapping(target = "idManualProgramado", ignore = true)
  @Mapping(target = "fechaFinExportacion", ignore = true)
  @Mapping(target = "fechaInicioExportacion", ignore = true)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE)
  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE)
  @Mapping(target = "items", source = "icmParamcalconforigenRecordSet")
  ConfiguracionesRequestDto asConfiguracionesRequestDto(IcmParamcalconforigenBlock src);

  @InheritInverseConfiguration
  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  IcmParamcalconforigenRecord asIcmParamconfRecord(ConfiguracionesRequestItemDto src);

  ConfiguracionesRequestItemDto asConfiguracionesRequestItemDto(IcmParamcalconforigenRecord src);

  @Mapping(target = "items", ignore = true)
  ConfiguracionesResponseDto asConfiguracionesResponseDto(GetconfiguracionOutput src, String idOrigen);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "src.m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "src.m4AutoGeneratedToDelete")
  @Mapping(target = "fechaInicio", source = "src.fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaFin", source = "src.fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idTipoHora", source = "src.idtphorafija")
  @Mapping(target = "idOrigen", source = "idOrigen")
  @Mapping(target = "idConfiguracion", ignore = true)
  @Mapping(target = "icmCkVentaImpuestos", source = "src.chkventaimpuestos")
  @Mapping(target = "icmCkIncIvaEvalPtpo", source = "src.chkevalpres")
  @Mapping(target = "icmCkRedJornada", source = "src.chkredjornada")
  ConfiguracionItemDto asConfiguracionItemDto(IcmListaconforigenRecord src, String idOrigen);

  @InheritInverseConfiguration
  IcmParamcalconfchdiasBlock asIcmParamcalconfchdiasBlock(ConfChDiasMinimosFilterDto src);

  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "item", source = "icmParamcalconfchdiasRecordSet")
  ConfChDiasMinimosFilterDto asConfChDiasMinimosFilterDto(IcmParamcalconfchdiasBlock src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idTipoCalculo", source = "idtpcalculo")
  @Mapping(target = "numDias", source = "numdias")
  ConfChDiasMinimosResultItemDto asConfChDiasMinimosResultItemDto(IcmListaconfchdiasRecord src);

  List<ConfChDiasMinimosResultItemDto> asConfChDiasMinimosResultItemDto(List<IcmListaconfchdiasRecord> src);

  @InheritInverseConfiguration
  IcmParamcalpresupuestoswlocBlock asIcmParamcalpresupuestoswlocBlock(PresupuestosWlocFilterDto src);

  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idSeccion", ignore = true)
  @Mapping(target = "banda", ignore = true)
  @Mapping(target = "ordinal", ignore = true)
  @Mapping(target = "item", source = "icmParamcalpresupuestoswlocRecordSet")
  PresupuestosWlocFilterDto asPresupuestosWlocFilterDto(IcmParamcalpresupuestoswlocBlock src);

  @InheritInverseConfiguration
  IcmParamcalpresupuestoswlocRecord asIcmParamcalpresupuestoswlocRecord(PresupuestosWlocFilterParametersDto src);

  @InheritInverseConfiguration
  IcmParamcalconfpreciohoraRecord asIcmParamcalpresupuestoswlocRecord(ConfPrecioHoraFilterParametersDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
  @Mapping(target = "idTpPresupuesto", source = "idtppresupuesto")
  @Mapping(target = "idEmpresa", source = "idempresa")
  PresupuestosWlocFilterParametersDto asPresupuestosWlocFilterParametersDto(IcmParamcalpresupuestoswlocRecord src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idSeccion", source = "idseccion")
  @Mapping(target = "idEmpresa", source = "idempresa")
  @Mapping(target = "banda", source = "banda")
  @Mapping(target = "ordinal", source = "ordinal")
  @Mapping(target = "excepcion", source = "excepcion")
  @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
  @Mapping(target = "idLugarTrabajoMtu", source = "idcodorigen")
  @Mapping(target = "idTpPresupuesto", source = "idtppresupuesto")
  @Mapping(target = "importeConImpuestos", source = "importeconimpuestos")
  @Mapping(target = "importeSinImpuestos", source = "importesinimpuestos")
  PresupuestosWlocResultItemDto asPresupuestosWlocResultItemDto(IcmListapresupuestoswlocRecord src);

  List<PresupuestosWlocResultItemDto> asPresupuestosWlocResultItemDto(List<IcmListapresupuestoswlocRecord> src);

  @InheritInverseConfiguration
  IcmListapresupuestoswlocRecord asIcmListapresupuestoswlocRecord(PresupuestosWlocResultItemDto src);

  @InheritInverseConfiguration
  IcmParamcalconfpreciohoraBlock asIcmParamcalconfpreciohoraBlock(ConfPrecioHoraFilterDto src);

  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "item", source = "icmParamcalconfpreciohoraRecordSet")
  ConfPrecioHoraFilterDto asConfPrecioHoraFilterDto(IcmParamcalconfpreciohoraBlock src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  ConfPrecioHoraFilterParametersDto asConfPrecioHoraFilterParametersDto(IcmParamcalconfpreciohoraRecord src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idTipoHoraComis", source = "tipohoracomis")
  @Mapping(target = "idTipoHoraIncptpo", source = "tipohoraincptpo")
  ConfPrecioHoraResultItemDto asConfPrecioHoraResultItemDto(IcmListaconfpreciohoraRecord src);

  List<ConfPrecioHoraResultItemDto> asConfPrecioHoraResultItemDto(List<IcmListaconfpreciohoraRecord> src);

  @InheritInverseConfiguration
  IcmListaconfpreciohoraRecord asIcmListaconfpreciohoraRecord(ConfPrecioHoraResultItemDto src);

  @InheritInverseConfiguration
  IcmParamcalconfchventaBlock asIcmParamcalconfchventaBlock(ConfChTpVentaFilterDto src);

  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idCadena", source = "idcadena")
  @Mapping(target = "item", source = "icmParamcalconfchventaRecordSet")
  @Mapping(target = "idEmpresa", ignore = true) // Se comprueba por origen, no por empresa
  ConfChTpVentaFilterDto asConfChTpVentaFilterDto(IcmParamcalconfchventaBlock src);

  @InheritInverseConfiguration
  @Mapping(target = "idempresa", ignore = true)
  IcmParamcalconfchventaRecord asIcmParamcalconfchventaRecord(ConfChTpVentaFilterParametersDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  ConfChTpVentaFilterParametersDto asConfChTpVentaFilterParametersDto(IcmParamcalconfchventaRecord src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idAgrupacion", source = "idagrupacion")
  @Mapping(target = "idConceptoVenta", source = "idconceptoventa")
  ConfChTpVentaResultItemDto asConfChTpVentaResultItemDto(IcmListaconfchventaRecord src);

  List<ConfChTpVentaResultItemDto> asConfChTpVentaResultItemDto(List<IcmListaconfchventaRecord> src);

  @InheritInverseConfiguration
  IcmListaconfchventaRecord asIcmListaconfchventaRecord(ConfChTpVentaResultItemDto src);

  @InheritInverseConfiguration
  IcmParamcalpresupuestosrangoBlock asIcmParamcalpresupuestosrangoBlock(PresupuestosRangoFilterDto src);

  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "item", source = "icmParamcalpresupuestosrangoRecordSet")
  PresupuestosRangoFilterDto asPresupuestosRangoFilterDto(IcmParamcalpresupuestosrangoBlock src);

  @InheritInverseConfiguration
  IcmParamcalpresupuestosrangoRecord asIcmParamcalpresupuestosrangoRecord(PresupuestosRangoFilterParametersDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "idTpPresupuesto", source = "idtppresupuesto")
  @Mapping(target = "idEmpresa", source = "idempresa")
  PresupuestosRangoFilterParametersDto asPresupuestosRangoFilterParametersDto(IcmParamcalpresupuestosrangoRecord src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idEmpresa", source = "idempresa")
  @Mapping(target = "idTpPresupuesto", source = "idtppresupuesto")
  PresupuestosRangoResultItemDto asPresupuestosRangoResultItemDto(IcmListapresupuestosrangoRecord src);

  List<PresupuestosRangoResultItemDto> asPresupuestosRangoResultItemDto(List<IcmListapresupuestosrangoRecord> src);

  @InheritInverseConfiguration
  IcmListapresupuestosrangoRecord asIcmListapresupuestosrangoRecord(PresupuestosRangoResultItemDto src);

  @InheritInverseConfiguration
  IcmParamcalventacongeladaBlock asIcmParamcalventacongeladaBlock(VentaCongeladaFilterDto src);

  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "item", source = "icmParamcalventacongeladaRecordSet")
  VentaCongeladaFilterDto asVentaCongeladaFilterDto(IcmParamcalventacongeladaBlock src);

  @InheritInverseConfiguration
  IcmParamcalventacongeladaRecord asIcmParamcalventacongeladaRecord(VentaCongeladaFilterParametersDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "idSeccion", source = "idseccion")
  @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
  @Mapping(target = "idConceptoVenta", source = "idconceptoventa")
  @Mapping(target = "idTpPresupuesto", source = "idtppresupuesto")
  VentaCongeladaFilterParametersDto asVentaCongeladaFilterParametersDto(IcmParamcalventacongeladaRecord src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "ordinal", source = "ordinal")
  @Mapping(target = "idSeccion", source = "idseccion")
  @Mapping(target = "idCadena", source = "idcadena")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
  @Mapping(target = "idLugarTrabajoMtu", source = "idlugartrabajomtu")
  @Mapping(target = "idConceptoVenta", source = "idconceptoventa")
  @Mapping(target = "idTpPresupuesto", source = "idtppresupuesto")
  @Mapping(target = "importeConImpuestos", source = "importeconimpuestos")
  @Mapping(target = "importeSinImpuestos", source = "importesinimpuestos")
  VentaCongeladaResultItemDto asVentaCongeladaResultItemDto(IcmListaventacongeladaRecord src);

  List<VentaCongeladaResultItemDto> asVentaCongeladaResultItemDto(List<IcmListaventacongeladaRecord> src);

  @InheritInverseConfiguration
  IcmListaventacongeladaRecord asIcmListaventacongeladaRecord(VentaCongeladaResultItemDto src);

  @InheritInverseConfiguration
  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  IcmParamcalmultiempresaRecord asIcmParamcalmultiempresaRecord(DesplazamientosMultiempresaRequestItemDto src);

  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idEmpresa", source = "idempresa")
  DesplazamientosMultiempresaRequestItemDto asDesplazamientosMultiempresaRequestItemDto(
      IcmParamcalmultiempresaRecord src);

  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idEmpresa", source = "idempresa")
  DesplazamientosMultiempresaItemDto asDesplazamientosMultiempresaItemDto(IcmListamultiempresaRecord src);

  List<DesplazamientosMultiempresaItemDto> asDesplazamientosMultiempresaItemDto(List<IcmListamultiempresaRecord> src);

  @Mapping(target = "icmParamcalempleadosdesplazRecordSet", ignore = true)
  IcmParamcalempleadosdesplazBlock asIcmParamcalempleadosdesplazBlock(GenericFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "fechafin", source = "fechaFin")
  @Mapping(target = "fechainicio", source = "fechaInicio")
  @Mapping(target = "idempresa", ignore = true)
  @Mapping(target = "idlugartrabajo", ignore = true)
  @Mapping(target = "idempleado", ignore = true)
  @Mapping(target = "idorigen", source = "idOrigen")
  IcmParamcalempleadosdesplazRecord asIcmParamcalempleadosdesplazRecord(GenericFilterDto src);

  @Mapping(target = "icmParamcalempleadospresenciaRecordSet", ignore = true)
  IcmParamcalempleadospresenciaBlock asIcmParamcalempleadospresenciaBlock(GenericFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "fechafin", source = "fechaFin")
  @Mapping(target = "fechainicio", source = "fechaInicio")
  @Mapping(target = "idempresa", ignore = true)
  @Mapping(target = "idlugartrabajo", ignore = true)
  @Mapping(target = "idempleado", ignore = true)
  @Mapping(target = "idorigen", source = "idOrigen")
  @Mapping(target = "idtipohora", ignore = true)
  IcmParamcalempleadospresenciaRecord asIcmParamcalempleadospresenciaRecord(GenericFilterDto src);

  @Mapping(target = "icmParamcaltiendasRecordSet", ignore = true)
  IcmParamcaltiendasBlock asIcmParamcaltiendasBlock(GenericFilterDto src);

  @Mapping(target = "icmParamcaltiendasRecordSet", ignore = true)
  IcmParamcaltiendasBlock asIcmParamcaltiendasBlock(SearchTiendasFilterDto src);

  @Mapping(target = "icmParamcaltiendasRecordSet", ignore = true)
  IcmParamcaltiendasBlock asIcmParamcaltiendasBlock(PresenciaManualWlocFilterDto src);

  @Mapping(target = "icmParamcaltiendasRecordSet", ignore = true)
  IcmParamcaltiendasBlock asIcmParamcaltiendasBlock(VentaManualWlocFilterDto src);

  @Mapping(target = "icmParamcaltiendasRecordSet", ignore = true)
  IcmParamcaltiendasBlock asIcmParamcaltiendasBlock(EstadoWlocFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "fechafin", source = "fechaFin")
  @Mapping(target = "fechainicio", source = "fechaInicio")
  @Mapping(target = "idempresa", ignore = true)
  @Mapping(target = "idlugartrabajo", ignore = true)
  @Mapping(target = "idlugartrabajomtu", ignore = true)
  @Mapping(target = "idorigen", source = "idOrigen")
  IcmParamcaltiendasRecord asIcmParamcaltiendasRecord(GenericFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "fechafin", source = "fechaFin")
  @Mapping(target = "fechainicio", source = "fechaInicio")
  @Mapping(target = "idempresa", ignore = true)
  @Mapping(target = "idcadena", ignore = true)
  @Mapping(target = "idlugartrabajo", ignore = true)
  @Mapping(target = "idlugartrabajomtu", ignore = true)
  @Mapping(target = "idorigen", source = "idOrigen")
  IcmParamcaltiendasRecord asIcmParamcaltiendasRecord(SearchTiendasFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "fechafin", source = "fechaFin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechainicio", source = "fechaInicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idempresa", ignore = true)
  @Mapping(target = "idlugartrabajo", ignore = true)
  @Mapping(target = "idlugartrabajomtu", ignore = true)
  @Mapping(target = "idorigen", ignore = true)
  IcmParamcaltiendasRecord asIcmParamcaltiendasRecord(PresenciaManualWlocFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "fechafin", source = "fechaFin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechainicio", source = "fechaInicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idempresa", ignore = true)
  @Mapping(target = "idlugartrabajo", ignore = true)
  @Mapping(target = "idlugartrabajomtu", ignore = true)
  @Mapping(target = "idorigen", source = "idOrigen")
  IcmParamcaltiendasRecord asIcmParamcaltiendasRecord(VentaManualWlocFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "fechafin", source = "fechaFin", dateFormat = Meta4Constants.META4_DATE)
  @Mapping(target = "fechainicio", source = "fechaInicio", dateFormat = Meta4Constants.META4_DATE)
  @Mapping(target = "idempresa", ignore = true)
  @Mapping(target = "idlugartrabajo", ignore = true)
  @Mapping(target = "idlugartrabajomtu", ignore = true)
  @Mapping(target = "idorigen", source = "idOrigen")
  IcmParamcaltiendasRecord asIcmParamcaltiendasRecord(EstadoWlocFilterDto src);

  @Mapping(target = "fechafin", source = "fechaFin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechainicio", source = "fechaInicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idorigen", source = "idOrigen")
  @Mapping(target = "icmParamcalempleadoRecordSet", ignore = true)
  IcmParamcalempleadoBlock asIcmParamcalempleadoBlock(SearchEmpleadosFilterDto src);

  @Mapping(target = "fechafin", source = "fechaFin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechainicio", source = "fechaInicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idorigen", source = "idOrigen")
  @Mapping(target = "icmParamcalempleadoRecordSet", ignore = true)
  IcmParamcalempleadoBlock asIcmParamcalempleadoBlock(GenericFilterDto src);

  @Mapping(target = "icmParamcalcadenaRecordSet", ignore = true)
  IcmParamcalcadenaBlock asIcmParamcalcadenaBlock(GenericFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "fechafin", source = "fechaFin")
  @Mapping(target = "fechainicio", source = "fechaInicio")
  @Mapping(target = "idempresa", ignore = true)
  @Mapping(target = "idorigen", source = "idOrigen")
  IcmParamcalcadenaRecord asIcmParamcalcadenaRecord(GenericFilterDto src);

  @Mapping(target = "icmParamcaldesplazrealRecordSet", ignore = true)
  IcmParamcaldesplazrealBlock asIcmParamcaldesplazrealBlock(DesplazamientoRealFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "fechafin", source = "fechaFin")
  @Mapping(target = "fechainicio", source = "fechaInicio")
  @Mapping(target = "idestructura", source = "idEstructuraPadre")
  @Mapping(target = "idestructurabase", source = "idEstructuraBase")
  @Mapping(target = "idestructuradestino", source = "idEstructura")
  @Mapping(target = "idestructuraambito", source = "idEstructuraAmbito")
  @Mapping(target = "idorigen", source = "idOrigen")
  @Mapping(target = "idempleado", source = "idEmpleado")
  @Mapping(target = "orempleado", source = "orEmpleado")
  IcmParamcaldesplazrealRecord asIcmParamcaldesplazrealRecord(DesplazamientoRealFilterParametersDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idEstructura", source = "idestructuradestino")
  @Mapping(target = "idEstructuraBase", source = "idestructurabase")
  @Mapping(target = "idEstructuraPadre", source = "idestructura")
  @Mapping(target = "idEstructuraAmbito", source = "idestructuraambito")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idEmpleado", source = "idempleado")
  @Mapping(target = "orEmpleado", source = "orempleado")
  DesplazamientoRealResultItemDto asDesplazamientoRealResultItemDto(IcmListadesplazrealRecord src);

  List<DesplazamientoRealResultItemDto> asDesplazamientoRealResultItemDto(List<IcmListadesplazrealRecord> src);

  @InheritInverseConfiguration
  IcmListadesplazrealRecord asIcmListadesplazrealRecord(DesplazamientoRealResultItemDto src);

  @Mapping(target = "icmParamcalempleadosRecordSet", ignore = true)
  IcmParamcalempleadosBlock asIcmParamcalempleadosBlock(GenericFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "fechafin", source = "fechaFin")
  @Mapping(target = "fechainicio", source = "fechaInicio")
  @Mapping(target = "idempresa", ignore = true)
  @Mapping(target = "idlugartrabajo", ignore = true)
  @Mapping(target = "idlugartrabajomtu", ignore = true)
  @Mapping(target = "idempleado", ignore = true)
  @Mapping(target = "idempleadolocal", ignore = true)
  @Mapping(target = "idorigen", source = "idOrigen")
  IcmParamcalempleadosRecord asIcmParamcalempleadosRecord(GenericFilterDto src);

  @Mapping(target = "icmParamcalflagcalculaRecordSet", ignore = true)
  IcmParamcalflagcalculaBlock asIcmParamcalflagcalculaBlock(GenericFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "fechafin", source = "fechaFin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechainicio", source = "fechaInicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idempresa",
      expression = "java(CollectionUtils.isNotEmpty(src.getIdsEmpresa()) ? src.getIdsEmpresa().get(0) : \"\")")
  @Mapping(target = "idlugartrabajo", ignore = true)
  @Mapping(target = "idorigen", source = "idOrigen")
  IcmParamcalflagcalculaRecord asIcmParamcalflagcalculaRecord(GenericFilterDto src);

  @Mapping(target = "icmParamcalpresenciamanualRecordSet", ignore = true)
  IcmParamcalpresenciamanualBlock asIcmParamcalpresenciamanualBlock(GenericFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "idorigen", source = "idOrigen")
  @Mapping(target = "idempleado", ignore = true)
  @Mapping(target = "idtipohora", ignore = true)
  @Mapping(target = "idlugartrabajo", ignore = true)
  @Mapping(target = "fechafin", source = "fechaFin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechainicio", source = "fechaInicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idempresa",
      expression = "java(CollectionUtils.isNotEmpty(src.getIdsEmpresa()) ? src.getIdsEmpresa().get(0) : \"\")")
  IcmParamcalpresenciamanualRecord asIcmParamcalpresenciamanualRecord(GenericFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fecha", source = "fecha", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idCadena", source = "idcadena")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idEmpresa", source = "idempresa")
  @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
  @Mapping(target = "idLugarTrabajoMtu", source = "idlugartrabajomtu")
  PresenciaManualWlocResultItemDto asPresenciaManualWlocResultItemDto(IcmListapresenciamanwlocRecord src);

  List<PresenciaManualWlocResultItemDto> asPresenciaManualWlocResultItemDto(List<IcmListapresenciamanwlocRecord> src);

  @InheritInverseConfiguration
  IcmListapresenciamanwlocRecord asIcmListapresenciamanwlocRecord(PresenciaManualWlocResultItemDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fecha", source = "fecha", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idCadena", source = "idcadena")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idEmpresa", source = "idempresa")
  @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
  @Mapping(target = "idLugarTrabajoMtu", source = "idlugartrabajomtu")
  VentaManualWlocResultItemDto asVentaManualWlocResultItemDto(IcmListaventamanwlocRecord src);

  List<VentaManualWlocResultItemDto> asVentaManualWlocResultItemDto(List<IcmListaventamanwlocRecord> src);

  @InheritInverseConfiguration
  IcmListaventamanwlocRecord asIcmListaventamanwlocRecord(VentaManualWlocResultItemDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
  @Mapping(target = "idEstado", source = "idestado")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idEmpresa", source = "idempresa")
  @Mapping(target = "idSeccion", source = "idseccion")
  @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
  @Mapping(target = "numDias", source = "numdias")
  EstadoWlocResultItemDto asEstadoWlocResultItemDto(IcmListaestadoRecord src);

  List<EstadoWlocResultItemDto> asEstadoWlocResultItemDto(List<IcmListaestadoRecord> src);

  @InheritInverseConfiguration
  IcmListaestadoRecord asIcmListaestadoRecord(EstadoWlocResultItemDto src);

  @Mapping(target = "icmParamcalsincroRecordSet", ignore = true)
  IcmParamcalsincroBlock asIcmParamcalsincroBlock(SincronizacionFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  IcmParamcalsincroRecord asIcmParamcalsincroRecord(SincronizacionFilterDto src);

  @Mapping(target = "idorigen", source = "idOrigen")
  @Mapping(target = "idempresa", source = "idEmpresa")
  @Mapping(target = "idempleado", source = "idEmpleado")
  @Mapping(target = "fechafin", source = "fechaFin", dateFormat = Meta4Constants.META4_DATE)
  @Mapping(target = "fechainicio", source = "fechaInicio", dateFormat = Meta4Constants.META4_DATE)
  IcmParamcalsincroRecord asIcmParamcalsincroRecord(SincronizacionFilterParametersDto src);

  @InheritInverseConfiguration
  IcmListasincroRecord asIcmListasincroRecord(SincronizacionResultItemDto src);

  @Mapping(target = "resultado", source = "resultado")
  @Mapping(target = "idEmpleado", source = "idempleado")
  SincronizacionResultItemDto asSincronizacionResultItemDto(IcmListasincroRecord src);

  List<SincronizacionResultItemDto> asSincronizacionResultItemDto(List<IcmListasincroRecord> src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "idOrigen", source = "idorigen")
  MotivosDesplazamientoRequestItemDto asMotivosDesplazamientoFilterParametersDto(IcmParamcalmotivosRecord src);

  @InheritInverseConfiguration
  IcmParamcalmotivosRecord asIcmParamcalmotivosRecord(MotivosDesplazamientoRequestItemDto src);

  @Mapping(target = "icmParamcalmotivosRecordSet", source = "items")
  IcmParamcalmotivosBlock asIcmParamcalmotivosBlock(MotivosDesplazamientoRequestDto src);

  @Mapping(target = "idMotivo", source = "idmotivo")
  MotivosDesplazamientoItemDto asMotivosDesplazamientoItemDto(IcmListamotivosRecord src);

  List<MotivosDesplazamientoItemDto> asMotivosDesplazamientoItemDto(List<IcmListamotivosRecord> src);

  @Mapping(target = "idorigen", source = "cclIdOrigen")
  @Mapping(target = "icmParamcalsistdestinoRecordSet", ignore = true)
  IcmParamcalsistdestinoBlock asIcmParamcalsistdestinoBlock(SistemaDestinoRequestDto src);

  @Mapping(target = "idSistemaDestino", ignore = true)
  SistemaDestinoResponseDto asSistemaDestinoResponseDto(GetsistdestinoOutput src);

  @Mapping(target = "idorigen", source = "cclIdOrigen")
  @Mapping(target = "icmParamcalcatalogoRecordSet", source = "items")
  IcmParamcalcatalogoBlock asIcmParamcalcatalogoBlock(CatalogoRequestDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "stdIdLegEnt", source = "idempresa")
  CatalogoRequestItemDto asCatalogoRequestItemDto(IcmParamcalcatalogoRecord src);

  @InheritInverseConfiguration
  IcmParamcalcatalogoRecord asIcmParamcalcatalogoRecord(CatalogoRequestItemDto src);

  @Mapping(target = "items", ignore = true)
  CatalogoResponseDto asCatalogoResponseDto(GetcatalogoOutput src);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "stdIdLegEnt", source = "idempresa")
  @Mapping(target = "cclIdOrigen", source = "idorigen")
  @Mapping(target = "idCatalogo", source = "idcatalogo")
  CatalogoResultItemDto asCatalogoResponseItemDto(IcmListacatalogoRecord src);

  @Mapping(target = "idorigen", source = "idOrigen")
  @Mapping(target = "icmParamcaltiposhoraRecordSet", ignore = true)
  IcmParamcaltiposhoraBlock asIcmParamcaltiposhoraBlock(TiposHoraRequestDto request);

  @Mapping(target = "items", ignore = true)
  TiposHoraResponseDto asTiposHoraResponseDto(GettiposhoraOutput tiposhora);

  @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
  @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idEmpresa", source = "idempresa")
  @Mapping(target = "idTipoHora", source = "idtipohora")
  @Mapping(target = "incluidoVenta", expression = "java(Meta4Constants.TRUE.equals(src.getEsincluidoventa()))")
  @Mapping(target = "excluidoCalculo", expression = "java(Meta4Constants.TRUE.equals(src.getEsexcluidocalculo()))")
  @Mapping(target = "incluidoChallenge",
      expression = "java(Meta4Constants.TRUE.equals(src.getEsincluidochallenge()))")
  @Mapping(target = "incluidoCommerce", expression = "java(Meta4Constants.TRUE.equals(src.getEsincluidoecommerce()))")
  @Mapping(target = "excluidoDenominador",
      expression = "java(Meta4Constants.TRUE.equals(src.getEsexcluidodenominador()))")
  @Mapping(target = "excluidoDenominadorRepartoProvincia",
      expression = "java(Meta4Constants.TRUE.equals(src.getEsexcluidodenominadorrepprov()))")
  @Mapping(target = "incluidoChallengePorcentaje",
      expression = "java(Meta4Constants.TRUE.equals(src.getEsincluidochallengeporc()))")
  TiposHoraResultItemDto asTiposHoraResultItemDto(IcmListatiposhoraRecord src);

  @Mapping(target = "icmParamcalusuarioRecordSet", ignore = true)
  IcmParamcalusuarioBlock asIcmParamcalusuarioBlock(UsuarioRequestDto src);

  @Mapping(target = "items", ignore = true)
  UsuarioResponseDto asUsuarioResponseDto(GetmailOutput src);

  @Mapping(target = "mail", source = "mail")
  @Mapping(target = "idUsuario", source = "idusuario")
  UsuarioResultItemDto asUsuarioResultItemDto(IcmListamailRecord src);

  @Mapping(target = "items", ignore = true)
  ClaseResponseDto asClaseResponseDto(GetclasesOutput src);

  @Mapping(target = "idOrigen", source = "idorigen")
  @Mapping(target = "idClase", source = "idtpclas")
  @Mapping(target = "idsEstadoSil", ignore = true)
  ClaseResultItemDto asClaseResultItemDto(IcmListaclasesRecord src);

  @Mapping(target = "icmParamcalliquidacionRecordSet", ignore = true)
  IcmParamcalliquidacionBlock asIcmParamcalliquidacionBlock(LiquidacionFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  IcmParamcalliquidacionRecord asIcmParamcalliquidacionRecord(LiquidacionFilterDto src);

  @Mapping(target = "idorigen", source = "idOrigen")
  @Mapping(target = "idempresa", source = "idEmpresa")
  @Mapping(target = "idempleado", source = "idEmpleado")
  @Mapping(target = "orempleado", source = "orEmpleado")
  @Mapping(target = "fechafin", source = "fechaFin", dateFormat = Meta4Constants.META4_DATE)
  IcmParamcalliquidacionRecord asIcmParamcalliquidacionRecord(LiquidacionFilterParametersDto src);

  @Mapping(target = "refresco", source = "refresco")
  @Mapping(target = "resultado", source = "resultado")
  @Mapping(target = "errores", ignore = true)
  @Mapping(target = "avisos", ignore = true)
  LiquidacionResultItemDto asLiquidacionResultItemDto(IcmResultadoguardadoRecord src);

  List<LiquidacionResultItemDto> asLiquidacionResultItemDto(List<IcmResultadoguardadoRecord> src);

  @Mapping(target = "literal", source = "literal")
  @Mapping(target = "registroAfectado", source = "registroafectado")
  AvisosGuardadoResultItemParametersDto asAvisosGuardadoResultItemParametersDto(IcmAvisosguardadoRecord src);

  List<AvisosGuardadoResultItemParametersDto> asAvisosGuardadoResultItemParametersDto(List<IcmAvisosguardadoRecord> src);

  @Mapping(target = "resultado", source = "resultado")
  AvisosGuardadoResultItemDto asAvisosGuardadoResultItemDto(IcmAvisosguardadoBlock src);

  List<AvisosGuardadoResultItemDto> asAvisosGuardadoResultItemDto(List<IcmAvisosguardadoBlock> src);

  @Mapping(target = "literal", source = "literal")
  @Mapping(target = "registroAfectado", source = "registroafectado")
  ErroresGuardadoResultItemParametersDto asErroresGuardadoResultItemParametersDto(IcmErroresguardadoRecord src);

  List<ErroresGuardadoResultItemParametersDto> asErroresGuardadoResultItemParametersDto(List<IcmErroresguardadoRecord> src);

  @Mapping(target = "resultado", source = "resultado")
  ErorresGuardadoResultItemDto asErroresGuardadoResultItemDto(IcmErroresguardadoBlock src);

  List<ErorresGuardadoResultItemDto> asErroresGuardadoResultItemDto(List<IcmErroresguardadoBlock> src);

  @Mapping(target = "icmParamcalplanificadorRecordSet", ignore = true)
  IcmParamcalplanificadorBlock asIcmParamcalplanificadorBlock(PlanificacionFilterDto src);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  IcmParamcalplanificadorRecord asIcmParamcalplanificadorRecord(PlanificacionFilterDto src);

  @Mapping(target = "idorigen", source = "idOrigen")
  @Mapping(target = "idperiodo", source = "idPeriodo")
  @Mapping(target = "idambito", source = "idAmbito")
  @Mapping(target = "proceso", source = "proceso")
  @Mapping(target = "listaempresas", source = "listaEmpresas")
  @Mapping(target = "listatiendas", source = "listaTiendas")
  @Mapping(target = "listaempleados", source = "listaEmpleados")
  @Mapping(target = "fecfin", source = "fecFin", dateFormat = Meta4Constants.META4_DATE)
  @Mapping(target = "fecpro", source = "fecPro", dateFormat = Meta4Constants.META4_DATE_FULL)
  IcmParamcalplanificadorRecord asIcmParamcalplanificadorRecord(PlanificacionFilterParametersDto src);

  @Mapping(target = "refresco", source = "refresco")
  @Mapping(target = "resultado", source = "resultado")
  @Mapping(target = "errores", ignore = true)
  @Mapping(target = "avisos", ignore = true)
  PlanificacionResultItemDto asPlanificacionResultItemDto(IcmResultadoguardadoRecord src);

  List<PlanificacionResultItemDto> asPlanificacionResultItemDto(List<IcmResultadoguardadoRecord> src);

  @InheritInverseConfiguration
  IcmResultadoguardadoRecord asIcmResultadoguardadoRecord(PlanificacionResultItemDto src);

  @InheritInverseConfiguration
  IcmResultadoguardadoRecord asIcmResultadoguardadoRecord(LiquidacionResultItemDto src);
}
