package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.Collection;

import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

import org.jspecify.annotations.NonNull;

public interface TrabajoRepository extends BaseRepository<Trabajo, Long> {

  Trabajo findByIdAndEstadoIdIn(@NonNull final Long id, final Collection<Integer> estados);

}
