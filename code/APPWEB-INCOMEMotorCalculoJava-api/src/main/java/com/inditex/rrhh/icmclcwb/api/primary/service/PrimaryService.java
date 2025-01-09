package com.inditex.rrhh.icmclcwb.api.primary.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.jspecify.annotations.NonNull;
import org.springframework.core.io.Resource;

public interface PrimaryService {

  Boolean loadDML(@Valid @NotBlank final String path);

  @NonNull
  Resource changelogDML();

  @NonNull
  Resource changelogDDL();

}
