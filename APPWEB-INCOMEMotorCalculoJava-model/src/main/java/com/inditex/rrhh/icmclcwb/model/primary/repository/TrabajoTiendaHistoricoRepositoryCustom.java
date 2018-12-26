package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaHistorico;

public interface TrabajoTiendaHistoricoRepositoryCustom {

    List<TrabajoTiendaHistorico> save(List<TrabajoTiendaHistorico> src) throws Exception;

}
