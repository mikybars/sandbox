package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaComisionHistorico;

public interface TrabajoTiendaComisionHistoricoRepositoryCustom {

    List<TrabajoTiendaComisionHistorico> save(List<TrabajoTiendaComisionHistorico> src) throws Exception;

}
