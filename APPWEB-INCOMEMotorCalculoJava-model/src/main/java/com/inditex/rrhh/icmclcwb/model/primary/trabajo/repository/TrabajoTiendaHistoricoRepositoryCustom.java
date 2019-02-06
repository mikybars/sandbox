package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoTiendaHistorico;

public interface TrabajoTiendaHistoricoRepositoryCustom {

    List<TrabajoTiendaHistorico> save(List<TrabajoTiendaHistorico> src) throws Exception;

}
