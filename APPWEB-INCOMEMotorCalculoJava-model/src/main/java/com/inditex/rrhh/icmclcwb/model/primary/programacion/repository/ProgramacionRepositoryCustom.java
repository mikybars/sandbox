package com.inditex.rrhh.icmclcwb.model.primary.programacion.repository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface ProgramacionRepositoryCustom {

    void reset();

    void activa();

    void activa(@Positive @NotNull final Long id);

    void desactiva();

    void desactiva(@Positive @NotNull final Long id);

}
