package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.AlgoritmoAjuste;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class AlgoritmoAjusteMapper {

  public abstract AlgoritmoAjusteDto algoritmoAjusteToAlgoritmoAjusteDto(AlgoritmoAjuste src);

  public abstract List<AlgoritmoAjusteDto> algoritmoAjusteToAlgoritmoAjusteDto(List<AlgoritmoAjuste> src);

  @InheritInverseConfiguration
  @Mapping(target = "tipoPolitica", ignore = true)
  public abstract AlgoritmoAjuste algoritmoAjusteDtoToAlgoritmo(AlgoritmoAjusteDto src);

  @InheritInverseConfiguration
  public abstract List<AlgoritmoAjuste> algoritmoAjusteDtoToAlgoritmo(List<AlgoritmoAjusteDto> src);

}
