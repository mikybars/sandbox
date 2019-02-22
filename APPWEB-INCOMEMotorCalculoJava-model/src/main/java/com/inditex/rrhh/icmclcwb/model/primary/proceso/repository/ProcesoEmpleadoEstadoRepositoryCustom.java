package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleadoEstado;

public interface ProcesoEmpleadoEstadoRepositoryCustom {

    List<ProcesoEmpleadoEstado> save(List<ProcesoEmpleadoEstado> src);

}
