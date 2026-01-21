package com.inditex.rrhh.icmclcwb.model.primary.simulacion.repository;

import java.util.List;
import java.util.Optional;

import com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity.SimulacionLocalizacionBandaExcepcion;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

import jakarta.validation.constraints.NotNull;

public interface SimuladorLocalizacionBandaExcepcionRepository extends BaseRepository<SimulacionLocalizacionBandaExcepcion, Long> {

  Optional<List<SimulacionLocalizacionBandaExcepcion>> findBySimulacion_Id(@NotNull final Long id);

}
