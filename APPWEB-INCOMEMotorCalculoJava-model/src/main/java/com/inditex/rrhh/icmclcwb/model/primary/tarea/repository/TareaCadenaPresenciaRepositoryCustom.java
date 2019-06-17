package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCadenaPresencia;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface TareaCadenaPresenciaRepositoryCustom {

    List<TareaCadenaPresencia> save(@NotNull final List<TareaCadenaPresencia> src);

    void updateActivo(@NotNull TareaDto tarea);
}
