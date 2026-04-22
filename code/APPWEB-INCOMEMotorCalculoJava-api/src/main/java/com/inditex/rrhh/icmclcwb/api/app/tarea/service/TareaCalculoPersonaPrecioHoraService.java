package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

public interface TareaCalculoPersonaPrecioHoraService {

    List<IdPersonaLocalDto> getIdsPersonasCalculoPrecioHoraByTareaAndAmbito(RunTareaDto runTareaDto, TareaAmbitoDto ambitoDto);

    CompletableFuture<Void> calcularPrecioHora(RunTareaDto tunTarea, TareaAmbitoDto ambitoDto,
        List<IdPersonaLocalDto> personas);

}
