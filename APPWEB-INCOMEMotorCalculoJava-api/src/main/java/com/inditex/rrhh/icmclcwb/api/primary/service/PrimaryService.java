package com.inditex.rrhh.icmclcwb.api.primary.service;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.core.io.Resource;

public interface PrimaryService {

  Boolean loadDML(@Valid @NotBlank final String path);

  @NotNull
  Resource changelogDML();

  @NotNull
  Resource changelogDDL();

}
