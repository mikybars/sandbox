package com.inditex.rrhh.icmclcwb.api.primary.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.core.io.Resource;

public interface PrimaryService {

  Boolean loadDML(@Valid @NotBlank final String path);

  @NotNull
  Resource changelogDML();

  @NotNull
  Resource changelogDDL();

}
