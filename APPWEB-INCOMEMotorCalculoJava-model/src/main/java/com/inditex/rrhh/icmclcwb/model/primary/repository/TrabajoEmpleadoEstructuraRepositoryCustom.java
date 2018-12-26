package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstructura;

public interface TrabajoEmpleadoEstructuraRepositoryCustom {

    List<TrabajoEmpleadoEstructura> save(List<TrabajoEmpleadoEstructura> src) throws Exception;

}
