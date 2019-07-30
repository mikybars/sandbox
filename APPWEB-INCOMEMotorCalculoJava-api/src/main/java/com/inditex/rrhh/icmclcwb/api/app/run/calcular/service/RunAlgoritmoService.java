package com.inditex.rrhh.icmclcwb.api.app.run.calcular.service;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.run.calcular.dto.RunAlgoritmoDto;

public interface RunAlgoritmoService {

    RunAlgoritmoDto findById(@NotNull @Positive Integer id);

    List<RunAlgoritmoDto> findAll();

}
