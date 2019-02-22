package com.inditex.rrhh.icmclcwb.api.app.run.proceso.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.AlgoritmoDto;

public interface AlgoritmoService {

    AlgoritmoDto findByTipoCalculoId(@NotNull @Positive Long id);

    AlgoritmoDto findByTipoCalculoId(@NotNull @Positive Long idTipoCalculo, @NotNull @Positive Long idTipoComision);

    AlgoritmoDto findById(Long id);

}
