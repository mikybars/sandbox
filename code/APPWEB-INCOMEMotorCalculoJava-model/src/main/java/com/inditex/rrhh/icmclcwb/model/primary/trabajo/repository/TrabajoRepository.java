package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.Collection;

import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoRepository extends BaseRepository<Trabajo, Long> {

  Trabajo findByIdAndEstadoIdIn(@NotNull final Long id, final Collection<Integer> estados);

}
