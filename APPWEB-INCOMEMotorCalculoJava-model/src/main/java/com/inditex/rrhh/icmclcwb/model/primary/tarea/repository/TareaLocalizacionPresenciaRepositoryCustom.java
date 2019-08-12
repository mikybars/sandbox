package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

import java.util.List;

import javax.validation.constraints.NotNull;

public interface TareaLocalizacionPresenciaRepositoryCustom {

    List<TareaLocalizacionPresencia> save(List<TareaLocalizacionPresencia> src);

    void compensar(@NotNull RunTareaDto runTareaDto);

    void incluirMinutosDesplazamientoOrigen(@NotNull RunTareaDto runTareaDto);

    void incluirMinutosDesplazamientoDestino(@NotNull RunTareaDto runTareaDto);

    void totalizar(@NotNull RunTareaDto runTareaDto);

    void compensarEcommerce(@NotNull RunTareaDto runTareaDto);

    void incluirMinutosEcommerceDesplazamientoOrigen(@NotNull RunTareaDto runTareaDto);

    void incluirMinutosEcommerceDesplazamientoDestino(@NotNull RunTareaDto runTareaDto);

    void updateActivoVacio(@NotNull RunTareaDto runTareaDto);

}
