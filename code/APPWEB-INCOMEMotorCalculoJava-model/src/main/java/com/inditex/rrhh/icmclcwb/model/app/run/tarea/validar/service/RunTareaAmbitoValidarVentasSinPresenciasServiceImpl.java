package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.SincronizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarVentasSinPresenciasService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoVentasSinPresenciasService;
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
public class RunTareaAmbitoValidarVentasSinPresenciasServiceImpl implements RunTareaAmbitoValidarVentasSinPresenciasService {

  private static final Logger LOG = LoggerFactory.getLogger(RunTareaAmbitoValidarVentasSinPresenciasServiceImpl.class);

  private final TareaFaseAccionServiceImpl tareaFaseAccionService;

  private final TareaCalculoVentasSinPresenciasService tareaCalculoVentasSinPresenciasService;

  private final TareaFaseAccionDatoServiceImpl tareaFaseAccionFallidasService;

  private final ValidacionMapper validacionMapper;

  @Override
  public ValidacionDto execute(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {

    final List<IdLocalizacionLocalDto> tiendasVentasSinPresenciasValidationResult;
    final List<TareaFaseAccionDatoDto> tareaFaseAccionDatoList = new ArrayList<>();

    try {
      tiendasVentasSinPresenciasValidationResult =
          this.tareaCalculoVentasSinPresenciasService.findTiendaVentasSinPresencias(tareaAmbito.getIdTarea());

      LOG.info("Trabajo[{}]Tarea[{}] :: Validación ventas sin presencias - Tiendas encontradas: {}",
          runTareaDto.getTrabajo().getId(), runTareaDto.getTarea().getId(),
          tiendasVentasSinPresenciasValidationResult != null ? tiendasVentasSinPresenciasValidationResult.size() : 0);

      if (tiendasVentasSinPresenciasValidationResult != null && !tiendasVentasSinPresenciasValidationResult.isEmpty()) {
        tiendasVentasSinPresenciasValidationResult
            .forEach(tienda -> tareaFaseAccionDatoList.add(TareaFaseAccionDatoDto.builder().idTareaFaseAccion(tareaFaseAccion.getId())
                .idTipoDato(TipoDatoEnum.LOCALIZACION.getId()).dato(tienda.getId()).build()));
        this.tareaFaseAccionFallidasService.save(tareaFaseAccionDatoList);
      }

      return this.validacionMapper.idLocalizacionLocalDtoTovalidacionDto(tareaAmbito, tareaFaseAccion,
          tiendasVentasSinPresenciasValidationResult,
          PrevalidarPropertiesDto.builder().sincronizacion(SincronizacionDto.builder().activo(false).build()).build(),
          runTareaDto.getTarea());

    } catch (final Exception e) {
      RunTareaAmbitoValidarVentasSinPresenciasServiceImpl.LOG.error(
          "Trabajo[{}]Tarea[{}] :: Error :: RunTareaAmbitoValidarVentasSinPresenciasServiceImpl :: ventasSinPresencias",
          runTareaDto.getTrabajo().getId(), runTareaDto.getTarea().getId(), e);
      return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);
    }
  }
}
