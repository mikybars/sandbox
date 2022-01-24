package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.LocalizacionOnlineDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionOnlineHistoricoMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOnlineHistorico;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaLocalizacionOnlineHistoricoMapperDecorator.class)
public abstract class TareaLocalizacionOnlineHistoricoMapper {

  @Mapping(source = "tarea.id", target = "tarea.id")
  @Mapping(source = "src.idOrigen", target = "cclIdOrigen")
  @Mapping(source = "src.idLocalizacion", target = "cclIdCodOrigen")
  @Mapping(source = "src.idLocalizacionMeta4", target = "stdIdWorkLocat")
  @Mapping(source = "src.idEmpresa", target = "stdIdLegEnt")
  @Mapping(source = "src.idCadena", target = "cclIdCadena")
  @Mapping(source = "src.fechaInicio", target = "fechaInicio")
  @Mapping(source = "src.fechaFin", target = "fechaFin")
  public abstract TareaLocalizacionOnlineHistorico getTiendaOnlineResultItemDtoToTareaTiendaOnlineHistorico(
      TiendaOnlineResultItemDto src, TareaDto tarea);

  public List<TareaLocalizacionOnlineHistorico> getTiendaOnlineResultItemDtoToTareaTiendaOnlineHistorico(
      List<TiendaOnlineResultItemDto> src, TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Mapping(target = "id", source = "cclIdCodOrigen")
  public abstract LocalizacionOnlineDto getTareaTiendaOnlineHistoricoToLocalizacionOnlineDto(
      TareaLocalizacionOnlineHistorico src);

  public List<LocalizacionOnlineDto> getTareaTiendaOnlineHistoricoToLocalizacionOnlineDto(
      List<TareaLocalizacionOnlineHistorico> src) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
