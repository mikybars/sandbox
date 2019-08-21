package com.inditex.rrhh.icmclcwb.api.primary.service;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public interface PrimaryService {

    Boolean loadDML(@Valid @NotBlank final String path);

}