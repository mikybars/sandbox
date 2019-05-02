package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoLocalizacion;

public interface PeriodoLocalizacionRepositoryCustom {

    List<PeriodoLocalizacion> save(List<PeriodoLocalizacion> src);

}
