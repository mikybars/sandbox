package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoEmpleadoHistorico;

public interface TrabajoEmpleadoHistoricoRepositoryCustom {

    List<TrabajoEmpleadoHistorico> save(List<TrabajoEmpleadoHistorico> src);

}
