package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoHistorico;

public interface TareaEmpleadoHistoricoRepositoryCustom {

    List<TareaEmpleadoHistorico> save(List<TareaEmpleadoHistorico> src);

}
