package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

import java.util.List;

import javax.validation.constraints.NotNull;

public interface TareaLocalizacionPresenciaRepositoryCustom {

    List<TareaLocalizacionPresencia> save(List<TareaLocalizacionPresencia> src);

    void compensar(@NotNull RunTareaDto runTareaDto);

    void incluirPresenciasDesplazamientoOrigen(@NotNull RunTareaDto runTareaDto);

    void incluirPresenciasDesplazamientoDestino(@NotNull RunTareaDto runTareaDto);

    void totalizar(@NotNull RunTareaDto runTareaDto);

    void compensarEcommerce(@NotNull RunTareaDto runTareaDto);

    void incluirPresenciaDesplazamientoOrigenEcommerce(@NotNull RunTareaDto runTareaDto);

    void incluirPresenciaDesplazamientoDestinoEcommerce(@NotNull RunTareaDto runTareaDto);

    void updateActivoVacio(@NotNull RunTareaDto runTareaDto);

}
