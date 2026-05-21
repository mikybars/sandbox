package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPresenciasMismaFechaDistintaTiendaService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoRepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class TareaCalculoPresenciasMismaFechaDistintaTiendaServiceImpl implements TareaCalculoPresenciasMismaFechaDistintaTiendaService {

    private final TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

    @Override
    public List<IdPersonaLocalDto> findPersonaPresenciasMismaFechaDistintaTienda(
        Long idTarea) {
        return this.tareaCalculoRepositoryCustom.findPersonaPresenciasMismaFechaDistintaTienda(idTarea);
    }

}
