package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface TareaCalculoPersonaPrecioHoraService {

    List<IdPersonaLocalDto> getIdsPersonasCalculoPrecioHoraByTarea(Long idTarea);

    CompletableFuture<Void> calcularPrecioHora(RunTareaDto tunTarea, List<IdPersonaLocalDto> personas);

}
