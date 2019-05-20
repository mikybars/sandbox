package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;

public interface AlgoritmoService {

    AlgoritmoDto findByTipoCalculoId(@NotNull @Positive Long id);

    AlgoritmoDto findByTipoCalculoIdAndTipoComisionId(@NotNull @Positive Long idTipoCalculo,
            @NotNull @Positive Long idTipoComision);

    AlgoritmoDto findById(@NotNull @Positive Long id);

    List<AlgoritmoDto> findAll();

    List<Long> customFindAlgoritmosIdsByTarea(@NotNull @Positive Long id);

    Boolean checkDuplicatedActives();

}
