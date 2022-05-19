package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;
/*
 * Copyright (c) 2022.  Inditex
 */

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarVentaNoIntegraService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraRequestDto;
import com.inditex.rrhh.icmclcwb.model.app.service.VentaIntegraServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaLocalizacionHistoricoServiceImpl;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

public class RunTareaAmbitoValidarVentaNoIntegraServiceImpl implements RunTareaAmbitoValidarVentaNoIntegraService {

    @Autowired
    private TareaLocalizacionHistoricoServiceImpl findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito;

    @Autowired
    private VentaIntegraServiceImpl ventaIntegraServiceImpl;

    @Override
    public ValidacionDto execute(
        @Valid final RunTareaDto runTareaDto,
        @Valid final TareaAmbitoDto tareaAmbito,
        @Valid final TareaFaseAccionDto tareaFaseAccion) {

        final List<Integer> tiendasRequest = new ArrayList<>();

        final List<IdLocalizacionDto> tiendas = this.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito
            .findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(runTareaDto.getTarea().getId(), tareaAmbito.getCclIdOrigen());

        tiendas.forEach(x -> tiendasRequest.add(Integer.valueOf(x.getId())));

        final List<Integer> tiendasNoIntegras = this.ventaIntegraServiceImpl.getTiendasVentaNoIntegra(
            VentaIntegraRequestDto.builder()
                .idOrigen(Integer.valueOf(tareaAmbito.getCclIdOrigen()))
                .idEmpresa(Integer.valueOf(runTareaDto.getTarea().getStdIdLegEnt()))
                .fechaDesde(runTareaDto.getTarea().getFechaInicioPeriodo().toString())
                .fechaHasta(runTareaDto.getTarea().getFechaFinPeriodo().toString())
                .listaTiendas(tiendasRequest).build());



        return null;
    }
}
