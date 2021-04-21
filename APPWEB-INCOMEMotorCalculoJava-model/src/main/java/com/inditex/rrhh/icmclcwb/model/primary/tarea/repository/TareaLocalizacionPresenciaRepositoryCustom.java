package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

public interface TareaLocalizacionPresenciaRepositoryCustom {

    List<TareaLocalizacionPresencia> save(List<TareaLocalizacionPresencia> src);

    void compensar(@NotNull RunTareaDto runTareaDto);

    void totalizar(@NotNull RunTareaDto runTareaDto);

    void compensarEcommerce(@NotNull RunTareaDto runTareaDto);

    void updateActivoVacio(@NotNull RunTareaDto runTareaDto);

    void totalizarEcommerce(@NotNull RunTareaDto runTareaDto);

    void totalizarEmpleadosPorVenta(@NotNull RunTareaDto runTareaDto);

    void compensarLocalizacionManual(@NotNull RunTareaDto runTareaDto);

}
