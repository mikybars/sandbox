package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleadoEstructura;

public interface ProcesoEmpleadoEstructuraRepositoryCustom {

    List<ProcesoEmpleadoEstructura> save(List<ProcesoEmpleadoEstructura> src);

}
