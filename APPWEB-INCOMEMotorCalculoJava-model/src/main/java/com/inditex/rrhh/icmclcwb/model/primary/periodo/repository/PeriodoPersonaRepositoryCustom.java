package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoPersona;

public interface PeriodoPersonaRepositoryCustom {

    List<PeriodoPersona> save(List<PeriodoPersona> src);

}
