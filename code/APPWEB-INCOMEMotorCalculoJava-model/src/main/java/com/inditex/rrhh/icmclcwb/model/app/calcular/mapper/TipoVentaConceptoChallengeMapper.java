package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoChallengeDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConceptoChallenge;
import com.inditex.rrhh.icmclcwb.rest.client.dto.TiposVentaChallengeResponseDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TipoVentaConceptoChallengeMapper {

  @Mapping(target = "id", source = "src.id")
  @Mapping(target = "icmIdConceptoVenta", source = "src.icmIdConceptoVenta")
  @Mapping(target = "nombre", source = "src.nombre")
  @Mapping(target = "descripcion", source = "src.descripcion")
  public abstract TipoVentaConceptoChallengeDto tipoVentaConceptoChallengeToTipoVentaConceptoChallengeDto(
      TipoVentaConceptoChallenge src);

  @Mapping(target = "fechaInicio", expression = "java(source.getFechaInicio() != null ? source.getFechaInicio().atStartOfDay() : null)")
  @Mapping(target = "fechaFin", expression = "java(source.getFechaFin() != null ? source.getFechaFin().atStartOfDay() : null)")
  @Mapping(target = "idAgrupacion", source = "idAgrupacionOnline")
  @Mapping(target = "idOrigen", source = "idOrigen")
  @Mapping(target = "idConceptoVenta", source = "idConceptoVenta")
  public abstract ConfChTpVentaResultItemDto toConfChTpVentaResultItemDto(TiposVentaChallengeResponseDTO source);

  @Mapping(target = "fechaInicio", expression = "java(source.getFechaInicio() != null ? source.getFechaInicio().atStartOfDay() : null)")
  @Mapping(target = "fechaFin", expression = "java(source.getFechaFin() != null ? source.getFechaFin().atStartOfDay() : null)")
  @Mapping(target = "idAgrupacion", source = "idAgrupacionOnline")
  @Mapping(target = "idOrigen", source = "idOrigen")
  @Mapping(target = "idConceptoVenta", source = "idConceptoVenta")
  public abstract List<ConfChTpVentaResultItemDto> confChTpVentaResultItemDtoListToConfChTpVentaResultItemDtoList(
      List<TiposVentaChallengeResponseDTO> source);
}
