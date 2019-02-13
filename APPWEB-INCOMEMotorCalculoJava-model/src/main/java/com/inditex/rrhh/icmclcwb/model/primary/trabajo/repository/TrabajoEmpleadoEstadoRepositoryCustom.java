package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoEmpleadoEstado;

public interface TrabajoEmpleadoEstadoRepositoryCustom {

    List<TrabajoEmpleadoEstado> save(List<TrabajoEmpleadoEstado> src);

}
