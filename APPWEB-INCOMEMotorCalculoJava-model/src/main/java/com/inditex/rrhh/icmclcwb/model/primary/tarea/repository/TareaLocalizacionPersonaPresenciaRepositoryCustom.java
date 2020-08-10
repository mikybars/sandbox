package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

public interface TareaLocalizacionPersonaPresenciaRepositoryCustom {

    List<TareaLocalizacionPersonaPresencia> save(List<TareaLocalizacionPersonaPresencia> src);

    void updateActivo(@NotNull RunTareaDto runTareaDto);

    void compensar(@NotNull RunTareaDto runTareaDto);

    void presenciasIncluidoVenta(@NotNull RunTareaDto runTareaDto);

    void updateActivoVacio(@NotNull RunTareaDto runTareaDto);

    void indicadorPresencia(@NotNull RunTareaDto runTareaDto);

    void indicadorPresenciaDesplazamiento(@NotNull RunTareaDto runTareaDto);

    void indicadorPresenciaDesplazamientoBase(@NotNull RunTareaDto runTareaDto);

    void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(@NotNull RunTareaDto runTareaDto);

    void presenciasHorasFijas(@NotNull RunTareaDto runTareaDto);

    void presenciasHorasFijasDesplazamiento(@NotNull RunTareaDto runTareaDto);

    void indicadorPersonaPorVenta(@NotNull RunTareaDto runTareaDto);

    void indicadorPersonaPorVentaSimplificada(@NotNull RunTareaDto runTareaDto);

    void compensarChallenge(@NotNull RunTareaDto runTareaDto);

    void indicadorDesplazamientoDirectoVenta(@NotNull RunTareaDto runTareaDto);

    void indicadorDesplazamientoBaseDirectoVenta(@NotNull RunTareaDto runTareaDto);

}
