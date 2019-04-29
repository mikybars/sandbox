package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;

public interface TareaPersonaHistoricoRepositoryCustom {

    List<TareaPersonaHistorico> save(List<TareaPersonaHistorico> src);

}
