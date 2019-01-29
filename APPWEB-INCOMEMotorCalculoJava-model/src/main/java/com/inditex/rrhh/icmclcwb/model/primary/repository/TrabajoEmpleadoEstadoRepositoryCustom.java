package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;

public interface TrabajoEmpleadoEstadoRepositoryCustom {

    List<TrabajoEmpleadoEstado> save(List<TrabajoEmpleadoEstado> src) throws Exception;

}
