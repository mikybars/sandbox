package com.inditex.rrhh.icmclcwb.api.app.run.calcular.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.RunAlgoritmoDTO;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface RunAlgoritmoService {

  RunAlgoritmoDTO findById(@NonNull @Positive Integer id);

  List<RunAlgoritmoDTO> findAll();

}
