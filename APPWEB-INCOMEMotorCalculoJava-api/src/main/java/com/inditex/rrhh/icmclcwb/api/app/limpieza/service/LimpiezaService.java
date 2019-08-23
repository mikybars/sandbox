package com.inditex.rrhh.icmclcwb.api.app.limpieza.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface LimpiezaService {

    void run();
    
    void clean(@Positive @NotNull final Long id);

}
