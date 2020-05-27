package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaResultItemDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfiguracionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmErroresguardadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaausenciasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacadenasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacondicionesbaseRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacondicionesdestinoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacondicionespoliticaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfchdiasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfchventaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfiguracionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconforigenRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfpreciohoraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempresasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaestructuraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaorigenesRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaperiodosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapoliticasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapresupuestosrangoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapresupuestoswlocRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListavaloresbaseRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListavaloresdestinoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListavalorespoliticaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaventacongeladaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchdiasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchventaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchventaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconforigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconforigenRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfpreciohoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfpreciohoraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestosrangoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestosrangoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalventacongeladaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalventacongeladaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmResultadoguardadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmResultadoguardadoRecord;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
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
    IcmParametrosentradaBlock asIcmParametrosentradaBlock(GenericFilterDto src);

    @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "idCadena", source = "idcadena")
    @Mapping(target = "idEmpresa", source = "idempresa")
    @Mapping(target = "item", source = "icmParametrosentradaRecordSet")
    GenericFilterDto asGenericFilterDto(IcmParametrosentradaBlock src);

    @InheritInverseConfiguration
    IcmParamcalempleadoBlock asIcmParamcalempleadoBlock(GenericFilterDto src);

    @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "idEmpresa", source = "idempresa")
    @Mapping(target = "idCadena", ignore = true)
    @Mapping(target = "item", source = "icmParamcalempleadoRecordSet")
    GenericFilterDto asGenericFilterDto(IcmParamcalempleadoBlock src);

    @InheritInverseConfiguration
    IcmParamcalestructuraBlock asIcmParamcalestructuraBlock(GenericFilterDto src);

    @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "idEmpresa", ignore = true)
    @Mapping(target = "idCadena", ignore = true)
    @Mapping(target = "item", source = "icmParamcalestructuraRecordSet")
    GenericFilterDto asGenericFilterDto(IcmParamcalestructuraBlock src);

    @InheritInverseConfiguration
    IcmParamcalestructuraBlock asIcmParamcalestructuraBlock(EstructurasComFilterDto src);

    @Mapping(target = "fechaFin", source = "fechafin", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "item", source = "icmParamcalestructuraRecordSet")
    EstructurasComFilterDto asEstructurasComFilterDto(IcmParamcalestructuraBlock src);

    @InheritInverseConfiguration
    IcmParamcalestructuraRecord asIcmParamcalestructuraRecord(GenericFilterParametersDto src);

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
    EstructurasComFilterParametersDto asEstructurasComFilterParametersDto(IcmParamcalestructuraRecord src);

    @InheritInverseConfiguration
    IcmParamcalempleadoRecord asIcmParamcalempleadoRecord(GenericFilterParametersDto src);

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
    IcmParamcalsociedadBlock asIcmParamcalsociedadBlock(GenericFilterDto src);

    @Mapping(target = "item", source = "icmParamcalsociedadRecordSet")
    @Mapping(target = "fechaInicio", ignore = true)
    @Mapping(target = "fechaFin", ignore = true)
    @Mapping(target = "idOrigen", ignore = true)
    @Mapping(target = "idEmpresa", ignore = true)
    @Mapping(target = "idCadena", ignore = true)
    GenericFilterDto asGenericFilterDto(IcmParamcalsociedadBlock src);

    @InheritInverseConfiguration
    IcmParamcalsociedadRecord asIcmParamcalsociedadRecord(GenericFilterParametersDto src);

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

    @InheritInverseConfiguration
    IcmParamcalorigenBlock asIcmParamcalorigenBlock(GenericFilterDto src);

    @Mapping(target = "item", source = "icmParamcalorigenRecordSet")
    @Mapping(target = "fechaInicio", ignore = true)
    @Mapping(target = "fechaFin", ignore = true)
    @Mapping(target = "idOrigen", ignore = true)
    @Mapping(target = "idEmpresa", ignore = true)
    @Mapping(target = "idCadena", ignore = true)
    GenericFilterDto asGenericFilterDto(IcmParamcalorigenBlock src);

    @InheritInverseConfiguration
    IcmParamcalorigenRecord asIcmParamcalorigenRecord(GenericFilterParametersDto src);

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

    @InheritInverseConfiguration
    IcmParamcalperiodoBlock asIcmParamcalperiodoBlock(GenericFilterDto src);

    @Mapping(target = "item", source = "icmParamcalperiodoRecordSet")
    @Mapping(target = "fechaInicio", ignore = true)
    @Mapping(target = "fechaFin", ignore = true)
    @Mapping(target = "idOrigen", ignore = true)
    @Mapping(target = "idEmpresa", ignore = true)
    @Mapping(target = "idCadena", ignore = true)
    GenericFilterDto asGenericFilterDto(IcmParamcalperiodoBlock src);

    @InheritInverseConfiguration
    @Mapping(target = "idorigen", ignore = true)
    IcmParamcalperiodoRecord asIcmParamcalperiodoRecord(GenericFilterParametersDto src);

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
    @Mapping(target = "inOut", ignore = true)
    @Mapping(target = "idTiendaMtu", ignore = true)
    @Mapping(target = "fechaFestivo", ignore = true)
    GenericTiendaResultItemDto asGenericTiendaResultItemDto(IcmListatiendasRecord src);

    @InheritInverseConfiguration
    @Mapping(target = "inout", ignore = true)
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

    List<GenericTiendaResultItemDto> asGenericTiendaResultItemDtos(List<IcmListatiendasRecord> src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "inOut", source = "inout")
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
    @Mapping(target = "inOut", source = "inout")
    @Mapping(target = "importe", source = "importe")
    @Mapping(target = "minutos", source = "minutos")
    @Mapping(target = "idPuesto", source = "idpuesto")
    @Mapping(target = "fechaInicioLoc", ignore = true)
    @Mapping(target = "fechaFinLoc", ignore = true)
    @Mapping(target = "fechaAntiguedad", ignore = true)
    GenericEmpleadoResultItemDto asGenericEmpleadoResultItemDto(IcmListaempleadosRecord src);

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

    List<GenericEmpleadoResultItemDto> asGenericEmpleadoResultItemDtos(List<IcmListaempleadosRecord> src);

    @Mapping(target = "inOut", source = "inout")
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
    @Mapping(target = "inOut", source = "inout")
    @Mapping(target = "fechaInicioLoc", ignore = true)
    @Mapping(target = "fechaFinLoc", ignore = true)
    @Mapping(target = "idPais", ignore = true)
    @Mapping(target = "idTipoHora", ignore = true)
    @Mapping(target = "coefJornada", ignore = true)
    @Mapping(target = "importe", ignore = true)
    @Mapping(target = "minutos", ignore = true)
    @Mapping(target = "idPuesto", ignore = true)
    GenericEmpleadoResultItemDto asGenericEmpleadoResultItemDtosSearchEmpleados(IcmListaempleadoRecord src);

    @InheritInverseConfiguration
    @Mapping(target = "fechafin", ignore = true)
    @Mapping(target = "fechafinloc", ignore = true)
    @Mapping(target = "fechafinsec", ignore = true)
    @Mapping(target = "fechainicio", ignore = true)
    @Mapping(target = "fechainicioloc", ignore = true)
    @Mapping(target = "fechainiciosec", ignore = true)
    @Mapping(target = "fechaantiguedad", ignore = true)
    IcmListaempleadoRecord asIcmListaempleadoRecord(GenericEmpleadoResultItemDto src);

    List<GenericEmpleadoResultItemDto> asGenericEmpleadoResultItemDtosSearchEmpleados(List<IcmListaempleadoRecord> src);

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

    @InheritInverseConfiguration
    @Mapping(target = "inout", ignore = true)
    IcmListaperiodosRecord asIcmListatiendasRecord(PeriodosResultItemDto src);

    List<PeriodosResultItemDto> asPeriodosResultItemDtos(List<IcmListaperiodosRecord> src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "inOut", source = "inout")
    @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "idEmpleado", source = "idempleado")
    @Mapping(target = "orEmpleado", source = "orempleado")
    @Mapping(target = "idEstructura", source = "idestructura")
    @Mapping(target = "idEmpleadoLocal", source = "idempleadolocal")
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "idTpEstructura", source = "idtpestructura")
    @Mapping(target = "icmListaCondicionesBase", source = "icmListacondicionesbase.icmListacondicionesbaseRecordSet")
    @Mapping(target = "icmListaCondicionesDestino",
            source = "icmListacondicionesdestino.icmListacondicionesdestinoRecordSet")
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
    @Mapping(target = "idTipoCalculo", source = "idtipocalculo")
    @Mapping(target = "idTipoComision", source = "idtipocomision")
    @Mapping(target = "idEstructuraBase", source = "idestructurabase")
    @Mapping(target = "icmListaValoresBase", source = "icmListavaloresbase.icmListavaloresbaseRecordSet")
    ListaCondicionesBaseResultItemDto asListaCondicionesBaseResultItemDto(IcmListacondicionesbaseRecord src);

    @InheritInverseConfiguration
    IcmListacondicionesbaseRecord asIcmListacondicionesbaseRecord(ListaCondicionesBaseResultItemDto src);

    List<ListaCondicionesBaseResultItemDto> asListaCondicionesBaseResultItemDto(
            List<IcmListacondicionesbaseRecord> src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "tope", source = "tope")
    @Mapping(target = "valor", source = "valor")
    @Mapping(target = "idSeccion", source = "idseccion")
    @Mapping(target = "idTipoVenta", ignore = true)
    ListaValoresBaseResultItemDto asListaValoresBaseResultItemDto(IcmListavaloresbaseRecord src);

    @InheritInverseConfiguration
    IcmListavaloresbaseRecord asIcmListavaloresbaseRecord(ListaValoresBaseResultItemDto src);

    List<ListaValoresBaseResultItemDto> asListaValoresBaseResultItemDto(List<IcmListavaloresbaseRecord> src);

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
    @Mapping(target = "icmListaValoresDestino", source = "icmListavaloresdestino.icmListavaloresdestinoRecordSet")
    ListaCondicionesDestinoResultItemDto asListaCondicionesDestinoResultItemDto(IcmListacondicionesdestinoRecord src);

    @InheritInverseConfiguration
    IcmListacondicionesdestinoRecord asIcmListacondicionesdestinoRecord(ListaCondicionesDestinoResultItemDto src);

    List<ListaCondicionesDestinoResultItemDto> asListaCondicionesDestinoResultItemDto(
            List<IcmListacondicionesdestinoRecord> src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "tope", source = "tope")
    @Mapping(target = "valor", source = "valor")
    @Mapping(target = "idSeccion", source = "idseccion")
    @Mapping(target = "idTipoVenta", ignore = true)
    ListaValoresDestinoResultItemDto asListaValoresDestinoResultItemDto(IcmListavaloresdestinoRecord src);

    @InheritInverseConfiguration
    IcmListavaloresdestinoRecord asIcmListavaloresdestinoRecord(ListaValoresDestinoResultItemDto src);

    List<ListaValoresDestinoResultItemDto> asListaValoresDestinoResultItemDto(List<IcmListavaloresdestinoRecord> src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "inOut", source = "inout")
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

    @InheritInverseConfiguration
    @Mapping(target = "idtpestructura", ignore = true)
    IcmListapoliticasRecord asIcmListapoliticasRecord(EstructurasPolResultItemDto src);

    List<EstructurasPolResultItemDto> asEstructurasPolResultItemDto(List<IcmListapoliticasRecord> src);

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

    @InheritInverseConfiguration
    @Mapping(target = "nombremotivobaja", ignore = true)
    @Mapping(target = "nombretipopolitica", ignore = true)
    IcmListacondicionespoliticaRecord asIcmListacondicionespoliticaRecord(ListaCondicionesPoliticasResultItemDto src);

    List<ListaCondicionesPoliticasResultItemDto> asListaCondicionesPoliticasResultItemDto(
            List<IcmListacondicionespoliticaRecord> src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "tramo", source = "tramo")
    @Mapping(target = "valor", source = "valor")
    @Mapping(target = "idUnidadTiempo", source = "idunidadtiempo")
    @Mapping(target = "numeroUnidades", source = "numerounidades")
    ListaValoresPoliticasResultItemDto asListaValoresPoliticasResultItemDto(IcmListavalorespoliticaRecord src);

    @InheritInverseConfiguration
    IcmListavalorespoliticaRecord asIcmListavalorespoliticaRecord(ListaValoresPoliticasResultItemDto src);

    List<ListaValoresPoliticasResultItemDto> asListaValoresPoliticasResultItemDto(
            List<IcmListavalorespoliticaRecord> src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "inout", source = "inout")
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
    @Mapping(target = "inout", source = "inout")
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "idProducto", source = "idproducto")
    ConfiguracionProductoVentaResultItemDto asConfiguracionProductoVentaResultItemDto(IcmListaconfiguracionRecord src);

    List<ConfiguracionProductoVentaResultItemDto> asConfiguracionProductoVentaResultItemDto(
            List<IcmListaconfiguracionRecord> src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "inout", source = "inout")
    @Mapping(target = "idCadena", source = "idcadena")
    @Mapping(target = "idEmpresa", source = "idempresa")
    CadenaResultItemDto asCadenaResultItemDto(IcmListacadenasRecord src);

    List<CadenaResultItemDto> asCadenaResultItemDto(List<IcmListacadenasRecord> src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "inOut", source = "inout")
    @Mapping(target = "idEmpresa", source = "idempresa")
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "nombreEmpresa", source = "nombreempresa")
    EmpresaResultItemDto asEmpresaResultItemDto(IcmListaempresasRecord src);

    List<EmpresaResultItemDto> asEmpresaResultItemDto(List<IcmListaempresasRecord> src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "inOut", source = "inout")
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
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "item", source = "icmParamcalprocesoRecordSet")
    SaveProcesoDto asSaveProcesoDto(IcmParamcalprocesoBlock src);

    @InheritInverseConfiguration
    @Mapping(target = "idempleado", ignore = true)
    IcmParamcalprocesoRecord asIcmParamcalprocesoRecord(SaveProcesoParametersDto src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "idEmpresa", source = "idempresa")
    @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
    @Mapping(target = "idEmpleado", source = "idempleadolocal")
    @Mapping(target = "orEmpleado", source = "orempleado")
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
    @Mapping(target = "inOut", ignore = true)
    @Mapping(target = "icmCkVentaImpuestos", source = "src.chkventaimpuestos")
    @Mapping(target = "icmCkIncIvaEvalPtpo", source = "src.chkevalpres")
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

    @InheritInverseConfiguration
    IcmListaconfchdiasRecord asIcmListapoliticasRecord(ConfChDiasMinimosResultItemDto src);

    List<ConfChDiasMinimosResultItemDto> asConfChDiasMinimosResultItemDto(List<IcmListaconfchdiasRecord> src);

    @InheritInverseConfiguration
    IcmParamcalpresupuestoswlocBlock asIcmParamcalpresupuestoswlocBlock(PresupuestosWlocFilterDto src);

    @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "idEmpresa", source = "idempresa")
    @Mapping(target = "idSeccion", ignore = true)
    @Mapping(target = "banda", ignore = true)
    @Mapping(target = "ordinal", ignore = true)
    @Mapping(target = "item", source = "icmParamcalpresupuestoswlocRecordSet")
    PresupuestosWlocFilterDto asPresupuestosWlocFilterDto(IcmParamcalpresupuestoswlocBlock src);

    @InheritInverseConfiguration
    IcmParamcalpresupuestoswlocRecord asIcmParamcalpresupuestoswlocRecord(PresupuestosWlocFilterParametersDto src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
    @Mapping(target = "idTpPresupuesto", source = "idtppresupuesto")
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
    @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
    @Mapping(target = "idLugarTrabajoMtu", source = "idcodorigen")
    @Mapping(target = "idTpPresupuesto", source = "idtppresupuesto")
    @Mapping(target = "importeConImpuestos", source = "importeconimpuestos")
    @Mapping(target = "importeSinImpuestos", source = "importesinimpuestos")
    PresupuestosWlocResultItemDto asPresupuestosWlocResultItemDto(IcmListapresupuestoswlocRecord src);

    @InheritInverseConfiguration
    IcmListapresupuestoswlocRecord asIcmListapresupuestoswlocRecord(PresupuestosWlocResultItemDto src);

    List<PresupuestosWlocResultItemDto> asPresupuestosWlocResultItemDto(List<IcmListapresupuestoswlocRecord> src);

    @InheritInverseConfiguration
    IcmParamcalconfpreciohoraBlock asIcmParamcalconfpreciohoraBlock(ConfPrecioHoraFilterDto src);

    @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "item", source = "icmParamcalconfpreciohoraRecordSet")
    ConfPrecioHoraFilterDto asConfPrecioHoraFilterDto(IcmParamcalconfpreciohoraBlock src);

    @InheritInverseConfiguration
    IcmParamcalconfpreciohoraRecord asIcmParamcalpresupuestoswlocRecord(ConfPrecioHoraFilterParametersDto src);

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

    @InheritInverseConfiguration
    IcmListaconfpreciohoraRecord asIcmListaconfpreciohoraRecord(ConfPrecioHoraResultItemDto src);

    List<ConfPrecioHoraResultItemDto> asConfPrecioHoraResultItemDto(List<IcmListaconfpreciohoraRecord> src);

    @InheritInverseConfiguration
    IcmParamcalconfchventaBlock asIcmParamcalconfchventaBlock(ConfChTpVentaFilterDto src);

    @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "idCadena", source = "idcadena")
    @Mapping(target = "idEmpresa", source = "idempresa")
    @Mapping(target = "item", source = "icmParamcalconfchventaRecordSet")
    ConfChTpVentaFilterDto asConfChTpVentaFilterDto(IcmParamcalconfchventaBlock src);

    @InheritInverseConfiguration
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
    ConfChTpVentaResultItemDto asConfPrecioHoraResultItemDto(IcmListaconfchventaRecord src);

    @InheritInverseConfiguration
    IcmListaconfchventaRecord asIcmListaconfchventaRecord(ConfChTpVentaResultItemDto src);

    List<ConfChTpVentaResultItemDto> asConfChTpVentaResultItemDto(List<IcmListaconfchventaRecord> src);

    @InheritInverseConfiguration
    IcmParamcalpresupuestosrangoBlock asIcmParamcalpresupuestosrangoBlock(PresupuestosRangoFilterDto src);

    @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "idEmpresa", source = "idempresa")
    @Mapping(target = "item", source = "icmParamcalpresupuestosrangoRecordSet")
    PresupuestosRangoFilterDto asPresupuestosRangoFilterDto(IcmParamcalpresupuestosrangoBlock src);

    @InheritInverseConfiguration
    IcmParamcalpresupuestosrangoRecord asIcmParamcalpresupuestosrangoRecord(PresupuestosRangoFilterParametersDto src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "idTpPresupuesto", source = "idtppresupuesto")
    PresupuestosRangoFilterParametersDto asPresupuestosRangoFilterParametersDto(IcmParamcalpresupuestosrangoRecord src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "idEmpresa", source = "idempresa")
    @Mapping(target = "idTpPresupuesto", source = "idtppresupuesto")
    PresupuestosRangoResultItemDto asPresupuestosRangoResultItemDto(IcmListapresupuestosrangoRecord src);

    @InheritInverseConfiguration
    IcmListapresupuestosrangoRecord asIcmListapresupuestosrangoRecord(PresupuestosRangoResultItemDto src);

    List<PresupuestosRangoResultItemDto> asPresupuestosRangoResultItemDto(List<IcmListapresupuestosrangoRecord> src);

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

    @InheritInverseConfiguration
    IcmListaventacongeladaRecord asIcmListaventacongeladaRecord(VentaCongeladaResultItemDto src);

    List<VentaCongeladaResultItemDto> asVentaCongeladaResultItemDto(List<IcmListaventacongeladaRecord> src);

}
