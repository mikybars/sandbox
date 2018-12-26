package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTipoHora;

public interface TrabajoTipoHoraRepositoryCustom {

    List<TrabajoTipoHora> save(List<TrabajoTipoHora> src) throws Exception;

}
