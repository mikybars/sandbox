package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaHistorico;

public interface ProcesoTiendaHistoricoRepositoryCustom {

    List<ProcesoTiendaHistorico> save(List<ProcesoTiendaHistorico> src);

}
