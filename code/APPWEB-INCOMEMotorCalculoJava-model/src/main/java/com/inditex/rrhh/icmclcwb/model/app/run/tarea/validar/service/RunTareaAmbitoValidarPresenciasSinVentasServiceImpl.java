package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.SincronizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPresenciasSinVentasService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPresenciasSinVentasService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionDatoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaAmbitoValidarPresenciasSinVentasServiceImpl implements RunTareaAmbitoValidarPresenciasSinVentasService {

  private static final Logger LOG = LoggerFactory.getLogger(RunTareaAmbitoValidarPresenciasSinVentasServiceImpl.class);

  private final TareaFaseAccionServiceImpl tareaFaseAccionService;

  private final TareaCalculoPresenciasSinVentasService tareaCalculoPresenciasSinVentasService;

  private final TareaFaseAccionDatoServiceImpl tareaFaseAccionFallidasService;

  private final ValidacionMapper validacionMapper;

  @Override
  public ValidacionDto execute(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {

    final List<IdLocalizacionLocalDto> tiendasPresenciasSinVentasValidationResult;
    final List<TareaFaseAccionDatoDto> tareaFaseAccionDatoList = new ArrayList<>();

    try {
      tiendasPresenciasSinVentasValidationResult =
          this.tareaCalculoPresenciasSinVentasService.findTiendaPresenciasSinVentas(tareaAmbito.getIdTarea());

      LOG.info("Trabajo[{}]Tarea[{}] :: Validación presencias sin ventas - Tiendas encontradas: {}",
          runTareaDto.getTrabajo().getId(), runTareaDto.getTarea().getId(),
          tiendasPresenciasSinVentasValidationResult != null ? tiendasPresenciasSinVentasValidationResult.size() : 0);

      if (tiendasPresenciasSinVentasValidationResult != null && !tiendasPresenciasSinVentasValidationResult.isEmpty()) {
        tiendasPresenciasSinVentasValidationResult
            .forEach(tienda -> tareaFaseAccionDatoList.add(TareaFaseAccionDatoDto.builder().idTareaFaseAccion(tareaFaseAccion.getId())
                .idTipoDato(TipoDatoEnum.LOCALIZACION.getId()).dato(tienda.getId()).build()));
        this.tareaFaseAccionFallidasService.save(tareaFaseAccionDatoList);
      }

      return this.validacionMapper.idLocalizacionLocalDtoTovalidacionDto(tareaAmbito, tareaFaseAccion,
          tiendasPresenciasSinVentasValidationResult,
          PrevalidarPropertiesDto.builder().sincronizacion(SincronizacionDto.builder().activo(false).build()).build(),
          runTareaDto.getTarea());

    } catch (final Exception e) {
      RunTareaAmbitoValidarPresenciasSinVentasServiceImpl.LOG.error(
          "Trabajo[{}]Tarea[{}] :: Error :: RunTareaAmbitoValidarPresenciasSinVentasServiceImpl :: presenciasSinVentas",
          runTareaDto.getTrabajo().getId(), runTareaDto.getTarea().getId(), e);
      return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);
    }
  }
}
