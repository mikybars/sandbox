package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoHistorico;

public interface TrabajoEmpleadoHistoricoRepositoryCustom {

    List<TrabajoEmpleadoHistorico> save(List<TrabajoEmpleadoHistorico> src) throws Exception;

}
