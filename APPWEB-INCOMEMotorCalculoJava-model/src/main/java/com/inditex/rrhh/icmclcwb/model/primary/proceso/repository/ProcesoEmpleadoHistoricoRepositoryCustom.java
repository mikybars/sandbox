package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleadoHistorico;

public interface ProcesoEmpleadoHistoricoRepositoryCustom {

    List<ProcesoEmpleadoHistorico> save(List<ProcesoEmpleadoHistorico> src);

}
