package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.inditex.rrhh.icmclcwb.api.meta4.PageDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraFilterDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaFilterDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.CondicionesComisionResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.CondicionesDesplazamientoResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.CondicionesFijasResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.CondicionesPoliticasResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.CondicionesResaltaResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.CondicionesTopesResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesFilterDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Constants;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmCondicionescomisionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmCondicionesdesplazamientoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmCondicionesfijasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmCondicionesfijasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmCondicionespoliticasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmCondicionesresaltaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmCondicionestopesRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmEmpleadosestructuraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmEmpleadostiendaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrosempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrosplantillaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrosplantillaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrostiendaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmPlantillacondicionesRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.mapper.decorator.IcmWsIncomeMapperDecorator;

@Mapper
@DecoratedWith(IcmWsIncomeMapperDecorator.class)
public interface IcmWsIncomeMapper {

	@Mappings({ @Mapping(source = "tipoorden", target = "tipoOrden"),
					@Mapping(source = "campoorden", target = "campoOrden"),
					@Mapping(source = "idbusqueda", target = "idBusqueda"),
					@Mapping(source = "numeropagina", target = "numeroPagina"),
					@Mapping(source = "numerototalpaginas", target = "numeroTotalPaginas"),
					@Mapping(source = "numeroregistrospagina", target = "numeroRegistrosPagina"),
					@Mapping(source = "numerototalresultados", target = "numeroTotalResultados") })
	PageDTO asPageDTO(IcmParametrospaginacionBlock src);

	@InheritInverseConfiguration
	// @Mappings({ @Mapping(source = "tipoOrden", target = "tipoorden"),
	// @Mapping(source = "campoOrden", target = "campoorden"),
	// @Mapping(source = "idBusqueda", target = "idbusqueda"),
	// @Mapping(source = "numeroPagina", target = "numeropagina"),
	// @Mapping(source = "numeroTotalPaginas", target = "numerototalpaginas"),
	// @Mapping(source = "numeroRegistrosPagina", target =
	// "numeroregistrospagina"),
	// @Mapping(source = "numeroTotalResultados", target =
	// "numerototalresultados") })
	IcmParametrospaginacionBlock asIcmParametrospaginacionBlock(PageDTO src);

	@Mappings({ @Mapping(source = "fechafin", target = "fechaFin", dateFormat = Constants.META4_DATE_FULL),
					@Mapping(source = "idestado", target = "idEstado"),
					@Mapping(source = "fechainicio", target = "fechaInicio", dateFormat = Constants.META4_DATE_FULL),
					@Mapping(source = "idestadomtu", target = "idEstadoMtu"),
					@Mapping(source = "idlugartrabajo", target = "idLugarTrabajo") })
	EmpleadosTiendaFilterDTO asGetEmpleadosTiendaFilterDTO(IcmParametrostiendaBlock src);

	@InheritInverseConfiguration
	IcmParametrostiendaBlock asIcmParametrostiendaBlock(EmpleadosTiendaFilterDTO src);
	
	@Mappings({ @Mapping(source = "m4AutoGeneratedRecordID", target = "m4AutoGeneratedRecordID"),
		@Mapping(source = "m4AutoGeneratedToDelete", target = "m4AutoGeneratedToDelete"),
		@Mapping(source = "inout", target = "inOut"),
		@Mapping(source = "idpuesto", target = "idPuesto"),
		@Mapping(source = "idseccion", target = "idSeccion"),
		@Mapping(source = "idempleado", target = "idEmpleado"),
		@Mapping(source = "nombrepuesto", target = "nombrePuesto"),
		@Mapping(source = "numregistros", target = "numRegistros"),
		@Mapping(source = "nombreseccion", target = "nombreSeccion"),
		@Mapping(source = "desplazamiento", target = "desplazamiento"),
		@Mapping(source = "nombreempleado", target = "nombreEmpleado"),
		@Mapping(source = "idempleadolocal", target = "idEmpleadoLocal")})
	EmpleadosTiendaResultItemDTO asGetEmpleadosTiendaResultDTO(IcmEmpleadostiendaRecord src);

	@InheritInverseConfiguration
	IcmEmpleadostiendaRecord asIcmEmpleadostiendaRecord(EmpleadosTiendaResultItemDTO src);
	
	List<EmpleadosTiendaResultItemDTO> asGetEmpleadosTiendaResultDTOs(List<IcmEmpleadostiendaRecord> src);

	@Mappings({ @Mapping(source = "fechafin", target = "fechaFin", dateFormat = Constants.META4_DATE_FULL),
		@Mapping(source = "idempleado", target = "idEmpleado"),
		@Mapping(source = "orempleado", target = "orEmpleado"),
		@Mapping(source = "fechainicio", target = "fechaInicio", dateFormat = Constants.META4_DATE_FULL),
		@Mapping(source = "idlugartrabajo", target = "idLugarTrabajo"),
		@Mapping(source = "idorigenpresencia", target = "idOrigenPresencia")
		 })
	EmpleadosEstructuraFilterDTO asEmpleadosEstructuraFilterDTO(IcmParametrosempleadoBlock src);
	
	@InheritInverseConfiguration
	IcmParametrosempleadoBlock asIcmParametrosempleadoBlock(EmpleadosEstructuraFilterDTO src);
	
	@Mappings({ @Mapping(source = "m4AutoGeneratedRecordID", target = "m4AutoGeneratedRecordID"),
		@Mapping(source = "m4AutoGeneratedToDelete", target = "m4AutoGeneratedToDelete"),
		@Mapping(source = "inout", target = "inOut"),
		@Mapping(source = "idempleado", target = "idEmpleado"),
		@Mapping(source = "orempleado", target = "orEmpleado"),
		@Mapping(source = "fechainicio", target = "fechaInicio", dateFormat = Constants.META4_DATE_FULL),
		@Mapping(source = "idestructura", target = "idEstructura"),
		@Mapping(source = "tipoestructura", target = "tipoEstructura")})
	EmpleadosEstructuraResultItemDTO asEmpleadosEstructuraResultItemDTO(IcmEmpleadosestructuraRecord src);
	
	List<EmpleadosEstructuraResultItemDTO> asEmpleadosEstructuraResultItemDTOs(List<IcmEmpleadosestructuraRecord> src);
	
	
	@Mappings({ @Mapping(source = "m4AutoGeneratedRecordID", target = "m4AutoGeneratedRecordID"),
		@Mapping(source = "m4AutoGeneratedToDelete", target = "m4AutoGeneratedToDelete"),
		@Mapping(source = "inout", target = "inOut"),
		@Mapping(source = "nuevo", target = "nuevo"),
		@Mapping(source = "idfija", target = "idFija"),
		@Mapping(source = "orfija", target = "orFija"),
		@Mapping(source = "borrado", target = "borrado"),
		@Mapping(source = "cantidad", target = "cantidad"),
		@Mapping(source = "modificado", target = "modificado"),
		@Mapping(source = "nombrefija", target = "nombreFija"),
		@Mapping(source = "idtipocondicion", target = "idTipoCondicion"),
		@Mapping(source = "idsubtipocondicion", target = "idSubtipoCondicion"),
		@Mapping(source = "nombretipocondicion", target = "nombreTipoCondicion"),
		@Mapping(source = "nombresubtipocondicion", target = "nombreSubtipoCondicion")
		 })
	CondicionesFijasResultItemDTO asCondicionesFijasResultItemDTO(IcmCondicionesfijasRecord src); 
	
	@InheritInverseConfiguration
	IcmCondicionesfijasRecord asIcmCondicionesfijasRecord(CondicionesFijasResultItemDTO src);

  	@Mappings({ @Mapping(source = "m4AutoGeneratedRecordID", target = "m4AutoGeneratedRecordID"),
		@Mapping(source = "m4AutoGeneratedToDelete", target = "m4AutoGeneratedToDelete"),
		@Mapping(source = "inout", target = "inOut"),
		@Mapping(source = "nuevo", target = "nuevo"),
		@Mapping(source = "borrado", target = "borrado"),
		@Mapping(source = "idpolitica", target = "idPolitica"),
		@Mapping(source = "modificado", target = "modificado"),
		@Mapping(source = "orpolitica", target = "orPolitica"),
		@Mapping(source = "porcentaje", target = "porcentaje"),
		@Mapping(source = "idmotivobaja", target = "idMotivoBaja"),
		@Mapping(source = "idporcentaje", target = "idPorcentaje"),
		@Mapping(source = "idsubtipocondicion", target = "numDiasAplica"),
		@Mapping(source = "cantidadlimite", target = "cantidadLimite"),
		@Mapping(source = "nombrepolitica", target = "nombrePolitica"),
		@Mapping(source = "idtipocondicion", target = "idTipoCondicion"),
		@Mapping(source = "nombremotivobaja", target = "nombreMotivoBaja"),
		@Mapping(source = "idsubtipocondicion", target = "idSubtipoCondicion"),
		@Mapping(source = "nombretipocondicion", target = "nombreTipoCondicion"),
		@Mapping(source = "nombresubtipocondicion", target = "nombreSubtipoCondicion"),
		@Mapping(source = "considerarmediacomision", target = "considerarMediaComision")
		 })
	CondicionesPoliticasResultItemDTO asCondicionesPoliticasResultItemDTO(IcmCondicionespoliticasRecord src);
	
  	@InheritInverseConfiguration
  	IcmCondicionespoliticasRecord asIcmCondicionespoliticasRecord(CondicionesPoliticasResultItemDTO src); 
	
  	@Mappings({ @Mapping(source = "m4AutoGeneratedRecordID", target = "m4AutoGeneratedRecordID"),
		@Mapping(source = "m4AutoGeneratedToDelete", target = "m4AutoGeneratedToDelete"),
		@Mapping(source = "inout", target = "inOut"),
		@Mapping(source = "nuevo", target = "nuevo"),
		@Mapping(source = "borrado", target = "borrado"),
		@Mapping(source = "idcomision", target = "idComision"),
		@Mapping(source = "modificado", target = "modificado"),
		@Mapping(source = "orcomision", target = "orComision"),
		@Mapping(source = "porcentaje", target = "porcentaje"),
		@Mapping(source = "idtipoventa", target = "idTipoVenta"),
		@Mapping(source = "idporcentaje", target = "idPorcentaje"),
		@Mapping(source = "idtipocalculo", target = "idTipoCalculo"),
		@Mapping(source = "nombrecomision", target = "nombreComision"),
		@Mapping(source = "idtipocondicion", target = "idTipoCondicion"),
		@Mapping(source = "nombretipoventa", target = "nombreTipoVenta"),
		@Mapping(source = "idseccioncalculo", target = "idSeccionCalculo"),
		@Mapping(source = "nombretipocalculo", target = "nombreTipoCalculo"),
		@Mapping(source = "idsubtipocondicion", target = "idSubtipoCondicion"),
		@Mapping(source = "nombretipocondicion", target = "nombreTipoCondicion"),
		@Mapping(source = "nombreseccioncalculo", target = "nombreSeccionCalculo"),
		@Mapping(source = "nombresubtipocondicion", target = "nombreSubtipoCondicion"),
		@Mapping(source = "icmCondicionestopes.icmCondicionestopesRecordSet", target = "condicionesTopes"),
		@Mapping(source = "icmCondicionesresalta.icmCondicionesresaltaRecordSet", target = "condicionesResalta"),
		@Mapping(source = "icmCondicionesdesplazamiento.icmCondicionesdesplazamientoRecordSet", target = "condicionesDesplazamiento"),
		 })
  	CondicionesComisionResultItemDTO asCondicionesComisionResultItemDTO(IcmCondicionescomisionRecord src);
  	
  	@InheritInverseConfiguration
  	IcmCondicionescomisionRecord asIcmCondicionescomisionRecord(CondicionesComisionResultItemDTO src); 
  	  	
  	@Mappings({ @Mapping(source = "m4AutoGeneratedRecordID", target = "m4AutoGeneratedRecordID"),
		@Mapping(source = "m4AutoGeneratedToDelete", target = "m4AutoGeneratedToDelete"),
		@Mapping(source = "inout", target = "inOut"),
		@Mapping(source = "nuevo", target = "nuevo"),
		@Mapping(source = "idtope", target = "idTope"),
		@Mapping(source = "ortope", target = "orTope"),
		@Mapping(source = "borrado", target = "borrado"),
		@Mapping(source = "modificado", target = "modificado"),
		@Mapping(source = "nombretope", target = "nombreTope"),
		@Mapping(source = "idtipoventa", target = "idTipoVenta"),
		@Mapping(source = "idtipocondicion", target = "idTipoCondicion"),
		@Mapping(source = "nombretipoventa", target = "nombreTipoVenta"),
		@Mapping(source = "porcentajetramo1", target = "porcentajeTramo1"),
		@Mapping(source = "porcentajetramo2", target = "porcentajeTramo2"),
		@Mapping(source = "porcentajetramo3", target = "porcentajeTramo3"),
		@Mapping(source = "idporcentajetramo1", target = "idPorcentajeTramo1"),
		@Mapping(source = "idporcentajetramo2", target = "idPorcentajeTramo2"),
		@Mapping(source = "idporcentajetramo3", target = "idPorcentajeTramo3"),
		@Mapping(source = "idsubtipocondicion", target = "idSubtipoCondicion"),
		@Mapping(source = "nombretipocondicion", target = "nombreTipoCondicion"),
		@Mapping(source = "nombresubtipocondicion", target = "nombreSubtipoCondicion")
		 })
  	CondicionesTopesResultItemDTO asCondicionesTopesResultItemDTO(IcmCondicionestopesRecord src);
    	
  	@InheritInverseConfiguration
  	IcmCondicionestopesRecord asIcmCondicionestopesRecord(CondicionesTopesResultItemDTO src);
  	
  	@Mappings({ @Mapping(source = "m4AutoGeneratedRecordID", target = "m4AutoGeneratedRecordID"),
		@Mapping(source = "m4AutoGeneratedToDelete", target = "m4AutoGeneratedToDelete"),
		@Mapping(source = "inout", target = "inOut"),
		@Mapping(source = "nuevo", target = "nuevo"),
		@Mapping(source = "borrado", target = "borrado"),
		@Mapping(source = "idresalta", target = "idResalta"),
		@Mapping(source = "orresalta", target = "orResalta"),
		@Mapping(source = "modificado", target = "modificado"),
		@Mapping(source = "porcentaje", target = "porcentaje"),
		@Mapping(source = "idtipoventa", target = "idTipoVenta"),
		@Mapping(source = "idporcentaje", target = "idPorcentaje"),
		@Mapping(source = "nombreresalta", target = "nombreResalta"),
		@Mapping(source = "idtipocondicion", target = "idTipoCondicion"),
		@Mapping(source = "nombretipoventa", target = "nombreTipoVenta"),
		@Mapping(source = "idsubtipocondicion", target = "idSubtipoCondicion"),
		@Mapping(source = "nombretipocondicion", target = "nombreTipoCondicion"),
		@Mapping(source = "nombresubtipocondicion", target = "nombreSubtipoCondicion")
		 })
  	CondicionesResaltaResultItemDTO asCondicionesResaltaResultItemDTO(IcmCondicionesresaltaRecord src);
  	
  	@InheritInverseConfiguration
  	IcmCondicionesresaltaRecord asIcmCondicionesresaltaRecord(CondicionesResaltaResultItemDTO src);
  	
  	@Mappings({ @Mapping(source = "m4AutoGeneratedRecordID", target = "m4AutoGeneratedRecordID"),
		@Mapping(source = "m4AutoGeneratedToDelete", target = "m4AutoGeneratedToDelete"),
		@Mapping(source = "inout", target = "inOut"),
		@Mapping(source = "nuevo", target = "nuevo"),
		@Mapping(source = "borrado", target = "borrado"),
		@Mapping(source = "modificado", target = "modificado"),
		@Mapping(source = "idpuestodestino", target = "idPuestoDestino"),
		@Mapping(source = "idtiendadestino", target = "idTiendaDestino"),
		@Mapping(source = "idtipocondicion", target = "idTipoCondicion"),
		@Mapping(source = "iddesplazamiento", target = "idDesplazamiento"),
		@Mapping(source = "idsecciondestino", target = "idSeccionDestino"),
		@Mapping(source = "ordesplazamiento", target = "orDesplazamiento"),
		@Mapping(source = "idsubtipocondicion", target = "idSubtipoCondicion"),
		@Mapping(source = "idtipoopcioncalculo", target = "idTipoOpcionCalculo"),
		@Mapping(source = "nombrepuestodestino", target = "nombrePuestoDestino"),
		@Mapping(source = "nombretiendadestino", target = "nombreTiendaDestino"),
		@Mapping(source = "nombretipocondicion", target = "nombreTipoCondicion"),
		@Mapping(source = "nombredesplazamiento", target = "nombreDesplazamiento"),
		@Mapping(source = "nombresecciondestino", target = "nombreSeccionDestino"),
		@Mapping(source = "nombresubtipocondicion", target = "nombreSubtipoCondicion"),
		@Mapping(source = "nombretipoopcioncalculo", target = "nombreTipoOpcionCalculo"),
		@Mapping(source = "contabilizartiendaorigen", target = "contabilizarTiendaOrigen"),
		@Mapping(source = "contabilizartiendadestino", target = "contabilizarTiendaDestino")
		 })
  	CondicionesDesplazamientoResultItemDTO asCondicionesDesplazamientoResultItemDTO(IcmCondicionesdesplazamientoRecord src);
  	
  	@InheritInverseConfiguration
  	IcmCondicionesdesplazamientoRecord asIcmCondicionesdesplazamientoRecord(CondicionesDesplazamientoResultItemDTO src);
  	
	@Mappings({ @Mapping(source = "idestructura", target = "idEstructura", dateFormat = Constants.META4_DATE_FULL),
		@Mapping(source = "tipocondicion", target = "tipoCondicion", dateFormat = Constants.META4_DATE_FULL),
		@Mapping(source = "tiposplantillas", target = "tiposPlantillas"),
		@Mapping(source = "subtipocondicion", target = "subtipoCondicion")
		 })
	ValoresCondicionesFilterDTO asValoresCondicionesFilterDTO(IcmParametrosplantillaBlock src);
	
	@InheritInverseConfiguration
	IcmParametrosplantillaBlock asIcmParametrosplantillaBlock(ValoresCondicionesFilterDTO src);
	
	@Mappings({@Mapping(source = "m4AutoGeneratedRecordID", target = "m4AutoGeneratedRecordID"),
		@Mapping(source = "m4AutoGeneratedToDelete", target = "m4AutoGeneratedToDelete"),
		@Mapping(source = "inout", target = "inOut"),
		@Mapping(source = "nuevo", target = "nuevo"),
		@Mapping(source = "borrado", target = "borrado"),
		@Mapping(source = "modificado", target = "modificado"),
		@Mapping(source = "idplantilla", target = "idPlantilla"),
		@Mapping(source = "idestructura", target = "idEstructura"),
		@Mapping(source = "idtipoplantilla", target = "idTipoPlantilla"),
		@Mapping(source = "nombreplantilla", target = "nombrePlantilla"),
		@Mapping(source = "nombreestructura", target = "nombreEstructura"),
		@Mapping(source = "nombretipoplantilla", target = "nombreTipoPlantilla"),
		@Mapping(source = "icmCondicionesfijas.icmCondicionesfijasRecordSet", target = "condicionesFijas"),
		@Mapping(source = "icmCondicionescomision.icmCondicionescomisionRecordSet", target = "condicionesComision"),
		@Mapping(source = "icmCondicionespoliticas.icmCondicionespoliticasRecordSet", target = "condicionesPoliticas")
	
	})
	ValoresCondicionesResultItemDTO asValoresCondicionesResultItemDTO(IcmPlantillacondicionesRecord src);
	
	List<ValoresCondicionesResultItemDTO> asValoresCondicionesResultItemDTOs(List<IcmPlantillacondicionesRecord> src);
}