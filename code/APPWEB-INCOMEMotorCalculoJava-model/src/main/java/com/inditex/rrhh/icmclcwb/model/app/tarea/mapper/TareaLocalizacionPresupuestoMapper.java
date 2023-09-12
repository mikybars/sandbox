package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionLocalizacionPresupuestoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuesto;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {org.apache.commons.lang3.math.NumberUtils.class})
@DecoratedWith(value = TareaLocalizacionLocalizacionPresupuestoDecorator.class)
public abstract class TareaLocalizacionPresupuestoMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "tarea.id", source = "tarea.id")
  @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
  @Mapping(target = "stdIdLegEnt", source = "src.idEmpresa")
  @Mapping(target = "stdIdWorkLocat", source = "src.idLugarTrabajo")
  @Mapping(target = "cclIdCodOrigen", source = "src.idLugarTrabajoMtu")
  @Mapping(target = "cclIdSeccion", source = "src.idSeccion")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  @Mapping(target = "importeSinImpuestos",
      expression = "java(NumberUtils.isParsable(src.getImporteSinImpuestos()) ? Double.parseDouble(src.getImporteSinImpuestos()) : 0.0)")
  @Mapping(target = "importeConImpuestos",
      expression = "java(NumberUtils.isParsable(src.getImporteConImpuestos()) ? Double.parseDouble(src.getImporteConImpuestos()) : 0.0)")
  @Mapping(target = "banda", source = "src.banda")
  @Mapping(target = "ordinal", source = "src.ordinal")
  @Mapping(target = "excepcion", source = "src.excepcion")
  @Mapping(target = "tipoPresupuesto", ignore = true)
  @Mapping(target = "estructura", ignore = true)
  @Mapping(target = "activo", constant = "false")
  public abstract TareaLocalizacionPresupuesto presupuestosWlocResultItemDtoToTareaLocalizacionPresupuesto(
      PresupuestosWlocResultItemDto src, TareaDto tarea);

  public List<TareaLocalizacionPresupuesto> presupuestosWlocResultItemDtoToTareaLocalizacionPresupuesto(
      final List<PresupuestosWlocResultItemDto> src, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
