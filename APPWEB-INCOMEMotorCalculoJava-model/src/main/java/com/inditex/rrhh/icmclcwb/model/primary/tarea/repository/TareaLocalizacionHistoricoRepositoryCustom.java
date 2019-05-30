package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;

public interface TareaLocalizacionHistoricoRepositoryCustom {

    List<TareaLocalizacionHistorico> save(List<TareaLocalizacionHistorico> src);

}
