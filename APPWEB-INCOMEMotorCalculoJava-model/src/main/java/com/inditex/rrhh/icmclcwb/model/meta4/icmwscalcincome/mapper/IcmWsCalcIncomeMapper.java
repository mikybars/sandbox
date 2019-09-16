package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ListaEstructuraDesplazamientosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ListaPorcentajesResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultErrorDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmErroresguardadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacadenasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfiguracionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempresasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaestrdesplRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaestructurasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaorigenesRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaperiodosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaporcentajesRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaporcentajesdespRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmResultadoguardadoBlock;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

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
    IcmParametrospaginacionBlock asIcmParametrospaginacionBlock(PageDto src);

    @InheritInverseConfiguration
    IcmParametrosentradaBlock asIcmParametrosentradaBlock(GenericFilterDto src);

    @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "idCadena", source = "idcadena")
    @Mapping(target = "idEmpresa", source = "idempresa")
    @Mapping(target = "item", source = "icmParametrosentradaRecordSet")
    GenericFilterDto asGenericFilterDto(IcmParametrosentradaBlock src);

    @InheritInverseConfiguration
    IcmParamcalestructuraBlock asIcmParamcalestructuraBlock(GenericFilterDto src);

    @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "item", source = "icmParamcalestructuraRecordSet")
    GenericFilterDto asGenericFilterDto(IcmParamcalestructuraBlock src);

    @InheritInverseConfiguration
    IcmParamcalestructuraRecord asIcmParamcalestructuraRecord(GenericFilterParametersDto src);

    @Mapping(target = "idEmpleado", source = "idempleado")
    @Mapping(target = "orEmpleado", source = "orempleado")
    GenericFilterParametersDto asGenericFilterParametersDto(IcmParamcalestructuraRecord src);

    @InheritInverseConfiguration
    IcmParamcalsociedadBlock asIcmParamcalsociedadBlock(GenericFilterDto src);

    @Mapping(target = "item", source = "icmParamcalsociedadRecordSet")
    GenericFilterDto asGenericFilterDto(IcmParamcalsociedadBlock src);

    @InheritInverseConfiguration
    IcmParamcalsociedadRecord asIcmParamcalsociedadRecord(GenericFilterParametersDto src);

    @Mapping(target = "idSociedadReg", source = "idsociedad")
    GenericFilterParametersDto asGenericFilterParametersDto(IcmParamcalsociedadRecord src);

    @InheritInverseConfiguration
    IcmParamcalorigenBlock asIcmParamcalorigenBlock(GenericFilterDto src);

    @Mapping(target = "item", source = "icmParamcalorigenRecordSet")
    GenericFilterDto asGenericFilterDto(IcmParamcalorigenBlock src);

    @InheritInverseConfiguration
    IcmParamcalorigenRecord asIcmParamcalorigenRecord(GenericFilterParametersDto src);

    @Mapping(target = "idOrigenReg", source = "idorigen")
    GenericFilterParametersDto asGenericFilterParametersDto(IcmParamcalorigenRecord src);

    @InheritInverseConfiguration
    IcmParamcalperiodoBlock asIcmParamcalperiodoBlock(GenericFilterDto src);

    @Mapping(target = "item", source = "icmParamcalperiodoRecordSet")
    GenericFilterDto asGenericFilterDto(IcmParamcalperiodoBlock src);

    @InheritInverseConfiguration
    IcmParamcalperiodoRecord asIcmParamcalperiodoRecord(GenericFilterParametersDto src);

    @Mapping(target = "idSociedadReg", source = "idsociedad")
    @Mapping(target = "idPeriodo", source = "idperiodo")
    GenericFilterParametersDto asGenericFilterParametersDto(IcmParamcalperiodoRecord src);

    @InheritInverseConfiguration
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
    GenericTiendaResultItemDto asGenericTiendaResultItemDto(IcmListatiendasRecord src);

    @InheritInverseConfiguration
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
    GenericEmpleadoResultItemDto asGenericEmpleadoResultItemDto(IcmListaempleadosRecord src);

    @InheritInverseConfiguration
    IcmListaempleadosRecord asIcmListatiendasRecord(GenericEmpleadoResultItemDto src);

    List<GenericEmpleadoResultItemDto> asGenericEmpleadoResultItemDtos(List<IcmListaempleadosRecord> src);

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
    IcmListaperiodosRecord asIcmListatiendasRecord(PeriodosResultItemDto src);

    List<PeriodosResultItemDto> asPeriodosResultItemDtos(List<IcmListaperiodosRecord> src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "diaD", source = "diad")
    @Mapping(target = "diaJ", source = "diaj")
    @Mapping(target = "diaL", source = "dial")
    @Mapping(target = "diaM", source = "diam")
    @Mapping(target = "diaS", source = "dias")
    @Mapping(target = "diaV", source = "diav")
    @Mapping(target = "diaX", source = "diax")
    @Mapping(target = "inOut", source = "inout")
    @Mapping(target = "importe", source = "importe")
    @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "numHoras", source = "numhoras")
    @Mapping(target = "idEmpleado", source = "idempleado")
    @Mapping(target = "importeMax", source = "importemax")
    @Mapping(target = "importeMin", source = "importemin")
    @Mapping(target = "orEmpleado", source = "orempleado")
    @Mapping(target = "idEstructura", source = "idestructura")
    @Mapping(target = "idMotivoBaja", source = "idmotivobaja")
    @Mapping(target = "idTipoCalculo", source = "idtipocalculo")
    @Mapping(target = "numMesesMedia", source = "nummesesmedia")
    @Mapping(target = "excDenominador", source = "excdenominador")
    @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
    @Mapping(target = "idTipoComision", source = "idtipocomision")
    @Mapping(target = "idTipoPolitica", source = "idtipopolitica")
    @Mapping(target = "idEmpleadoLocal", source = "idempleadolocal")
    @Mapping(target = "idLugarTrabajoMtu", source = "idlugartrabajomtu")
    @Mapping(target = "desplazamiento", source = "desplazamiento")
    @Mapping(target = "idOrigen", source = "idorigen")
    @Mapping(target = "icmListaPorcentajes", source = "icmListaporcentajes.icmListaporcentajesRecordSet")
    @Mapping(target = "icmListaEstrDespl", source = "icmListaestrdespl.icmListaestrdesplRecordSet")
    ComisionEmpleadoResultItemDto asComisionEmpleadoResultItemDto(IcmListaestructurasRecord src);

    @InheritInverseConfiguration
    IcmListaestructurasRecord asIcmListaestructurasRecord(ComisionEmpleadoResultItemDto src);

    List<ComisionEmpleadoResultItemDto> asComisionEmpleadoResultItemDtos(List<IcmListaestructurasRecord> src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "idSeccion", source = "idseccion")
    @Mapping(target = "porcentaje", source = "porcentaje")
    ListaPorcentajesResultItemDto asListaPorcentajesResultItemDto(IcmListaporcentajesRecord src);

    @InheritInverseConfiguration
    IcmListaporcentajesRecord asIcmListaporcentajesRecord(ListaPorcentajesResultItemDto src);

    List<ListaPorcentajesResultItemDto> asListaPorcentajesResultItemDto(List<IcmListaporcentajesRecord> src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "diaD", source = "diad")
    @Mapping(target = "diaJ", source = "diaj")
    @Mapping(target = "diaL", source = "dial")
    @Mapping(target = "diaM", source = "diam")
    @Mapping(target = "diaS", source = "dias")
    @Mapping(target = "diaV", source = "diav")
    @Mapping(target = "diaX", source = "diax")
    @Mapping(target = "inOut", source = "inout")
    @Mapping(target = "importe", source = "importe")
    @Mapping(target = "fechaFin", source = "fechafin", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "fechaInicio", source = "fechainicio", dateFormat = Meta4Constants.META4_DATE_FULL)
    @Mapping(target = "horasOrigen", source = "horasorigen")
    @Mapping(target = "horasDestino", source = "horasdestino")
    @Mapping(target = "idMotivoDesplazamiento", source = "idmotivodesp")
    @Mapping(target = "idTipoCalculo", source = "idtipocalculo")
    @Mapping(target = "idTipoOpCalculo", source = "idtipoopccalc")
    @Mapping(target = "idPuestoDestino", source = "idpuestodestino")
    @Mapping(target = "idSeccionDestino", source = "idsecciondestino")
    @Mapping(target = "idTipoReqComision", source = "idtiporeqcomision")
    @Mapping(target = "idLugarTrabajoDestino", source = "idlugartrabajodestino")
    @Mapping(target = "idLugarTrabajoDestinoMtu", source = "idlugartrabajodestinomtu")
    @Mapping(target = "listaPorcentajes", source = "icmListaporcentajesdesp.icmListaporcentajesdespRecordSet")
    ListaEstructuraDesplazamientosResultItemDto asListaEstructuraDesplazamientosResultItemDto(IcmListaestrdesplRecord src);

    @InheritInverseConfiguration
    IcmListaestrdesplRecord asIcmListaestrdesplRecord(ListaEstructuraDesplazamientosResultItemDto src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "idSeccion", source = "idseccion")
    @Mapping(target = "porcentaje", source = "porcentaje")
    ListaPorcentajesResultItemDto asListaPorcentajesResultItemDtoDesplazamiento(IcmListaporcentajesdespRecord src);

    List<ListaPorcentajesResultItemDto> asListaPorcentajesResultItemDtoDesplazamiento(List<IcmListaporcentajesdespRecord> src);

    List<ListaEstructuraDesplazamientosResultItemDto> asListaEstructuraDesplazamientosResultItemDto(List<IcmListaestrdesplRecord> src);

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
    
    List<ConfiguracionProductoVentaResultItemDto> asConfiguracionProductoVentaResultItemDto(List<IcmListaconfiguracionRecord> src);
    
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
    IcmParamcalprocesoRecord asIcmParamcalprocesoRecord(SaveProcesoParametersDto src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "idEmpresa", source = "idempresa")
    @Mapping(target = "idLugarTrabajo", source = "idlugartrabajo")
    @Mapping(target = "idEmpleado", source = "idempleado")
    @Mapping(target = "orEmpleado", source = "orempleado")
    SaveProcesoParametersDto asSaveProcesoParametersDto(IcmParamcalprocesoRecord src);

    @Mapping(target = "resultadoOk", ignore = true)
    @Mapping(target = "resultadoError", ignore = true)
    @Mapping(target = "data", source = "icmResultadoguardadoRecordSet")
    SaveResultDto asSaveResultDto(IcmResultadoguardadoBlock src);

    @Mapping(target = "m4AutoGeneratedRecordID", source = "m4AutoGeneratedRecordID")
    @Mapping(target = "m4AutoGeneratedToDelete", source = "m4AutoGeneratedToDelete")
    @Mapping(target = "literal", source = "literal")
    @Mapping(target = "registroAfectado", source = "registroafectado")
    SaveResultErrorDto asSaveResultErrorDto(IcmErroresguardadoRecord src);

}
