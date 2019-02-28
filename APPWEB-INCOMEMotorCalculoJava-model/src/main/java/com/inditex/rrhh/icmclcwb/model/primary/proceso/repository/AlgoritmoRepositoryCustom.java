package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface AlgoritmoRepositoryCustom {

    public List<Long> customFindAlgoritmosIdsByProceso(@NotNull @Positive final Long idProceso);

}
