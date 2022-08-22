package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarVentaIntegraService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraRequestDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.exception.VentaIntegraIcmclcwbException;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.service.VentaIntegraServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionDatoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaLocalizacionHistoricoServiceImpl;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoValidarVentaIntegraServiceImpl implements RunTareaAmbitoValidarVentaIntegraService {

  @Autowired
  private TareaLocalizacionHistoricoServiceImpl findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito;

  @Autowired
  private VentaIntegraServiceImpl ventaIntegraService;

  @Autowired
  private TareaFaseAccionDatoServiceImpl tareaFaseAccionDatoService;

  @Autowired
  private TareaFaseAccionServiceImpl tareaFaseAccionService;

  @Autowired
  private ValidacionMapper validacionMapper;

  @Autowired
  private Logger log;

  @Override
  public ValidacionDto execute(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {

    try {
      final List<IdLocalizacionDto> tiendas = this.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito
          .findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(runTareaDto.getTarea().getId(), tareaAmbito.getCclIdOrigen());

      if (tiendas.isEmpty()) {
        throw new VentaIntegraIcmclcwbException("El numero de tiendas afectadas es 0 para la tarea "
            +
            runTareaDto.getTarea().getId() + " y el origen " + tareaAmbito.getCclIdOrigen());
      }

      final List<Integer> tiendasRequest = new ArrayList<>();
      tiendas.forEach(x -> tiendasRequest.add(Integer.valueOf(x.getId().substring(1))));

      final List<Integer> tiendasNoIntegras = this.ventaIntegraService.getTiendasVentaNoIntegra(VentaIntegraRequestDto.builder()
          .idOrigen(Integer.valueOf(tareaAmbito.getCclIdOrigen())).idEmpresa(Integer.valueOf(runTareaDto.getTarea().getStdIdLegEnt()))
          .fechaDesde(runTareaDto.getTarea().getFechaInicioPeriodo().toString())
          .fechaHasta(runTareaDto.getTarea().getFechaFinPeriodo().toString()).listaTiendas(tiendasRequest).build());

      final List<TareaFaseAccionDatoDto> tareaFaseAccionDatoDtoList = new ArrayList<>();
      tiendasNoIntegras
          .forEach(x -> tareaFaseAccionDatoDtoList.add(TareaFaseAccionDatoDto.builder().idTareaFaseAccion(tareaFaseAccion.getId())
              .idTipoDato(TipoDatoEnum.VENTA_NO_INTEGRA.getId()).dato(x.toString()).build()));

      this.tareaFaseAccionDatoService.save(tareaFaseAccionDatoDtoList);

    } catch (final Exception e) {
      this.log.error("Trabajo[{}]Tarea[{}] :: Fin :: RunTareaAmbitoValidarVentaIntegraServiceImpl :: VentaIntegra: {}",
          runTareaDto.getTrabajo().getId(), runTareaDto.getTarea().getIdTrabajo(), e);
    }

    return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);
  }
}
