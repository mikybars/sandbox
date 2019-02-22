package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleado;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface ProcesoEmpleadoRepository extends BaseRepository<ProcesoEmpleado, Long> {

    List<ProcesoEmpleado> findByProcesoId(Long procesoId);

}