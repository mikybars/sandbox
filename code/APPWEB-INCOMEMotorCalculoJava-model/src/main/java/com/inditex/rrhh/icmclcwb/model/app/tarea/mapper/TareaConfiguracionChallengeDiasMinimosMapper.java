package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionChallengeDiasMinimosDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaConfiguracionChallengeDiasMinimosDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionChallengeDiasMinimos;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = TareaConfiguracionChallengeDiasMinimosDecorator.class)
public abstract class TareaConfiguracionChallengeDiasMinimosMapper {

  @Mapping(target = "tarea", ignore = true)
  public abstract TareaConfiguracionChallengeDiasMinimos tareaConfiguracionChallengeDiasMinimosDtoToTareaConfiguracionChallengeDiasMinimos(
      TareaConfiguracionChallengeDiasMinimosDto src);

  public abstract List<
      TareaConfiguracionChallengeDiasMinimos> tareaConfiguracionChallengeDiasMinimosDtoToTareaConfiguracionChallengeDiasMinimos(
          List<TareaConfiguracionChallengeDiasMinimosDto> src);

  @Mapping(target = "idTarea", ignore = true)
  public abstract TareaConfiguracionChallengeDiasMinimosDto tareaConfiguracionChallengeDiasMinimosToTareaConfiguracionChallengeDiasMinimosDto(
      TareaConfiguracionChallengeDiasMinimos src);

  public abstract List<
      TareaConfiguracionChallengeDiasMinimosDto> tareaConfiguracionChallengeDiasMinimosToTareaConfiguracionChallengeDiasMinimosDto(
          List<TareaConfiguracionChallengeDiasMinimos> src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "tarea.id", source = "tarea.id")
  @Mapping(target = "icmIdTpCalculo", source = "src.idTipoCalculo")
  @Mapping(target = "icmMinNumDays", source = "src.numDias")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
  public abstract TareaConfiguracionChallengeDiasMinimos confChDiasMinimosResultItemDtoToTareaConfiguracionChallengeDiasMinimos(
      ConfChDiasMinimosResultItemDto src, TareaDto tarea);

  public List<TareaConfiguracionChallengeDiasMinimos> confChDiasMinimosResultItemDtoToTareaConfiguracionChallengeDiasMinimos(
      final List<ConfChDiasMinimosResultItemDto> src, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
