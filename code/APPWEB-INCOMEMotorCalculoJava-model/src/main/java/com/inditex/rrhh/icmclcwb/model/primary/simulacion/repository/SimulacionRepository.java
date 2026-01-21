package com.inditex.rrhh.icmclcwb.model.primary.simulacion.repository;

import java.util.Optional;

import com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity.Simulacion;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

import jakarta.validation.constraints.NotNull;

public interface SimulacionRepository extends BaseRepository<Simulacion, Long> {

  Optional<Simulacion> findById(@NotNull final Long id);

}
