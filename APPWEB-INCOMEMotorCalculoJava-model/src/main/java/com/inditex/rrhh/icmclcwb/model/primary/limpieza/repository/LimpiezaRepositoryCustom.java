package com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface LimpiezaRepositoryCustom {

    Long findMinId();

    List<Long> findIds(@Positive @NotNull final Long id);

    void limpieza(@Positive @NotNull Long id);

    void consolidar(@Positive @NotNull Long id);

}
