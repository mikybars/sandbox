package com.inditex.rrhh.icmclcwb.model.primary.service;

import com.inditex.rrhh.icmclcwb.api.primary.service.PrimaryService;
import com.inditex.rrhh.icmclcwb.model.app.util.FileUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryRepositoryCustom;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PrimaryServiceImpl implements PrimaryService {

  @Autowired
  private Logger log;

  @Autowired
  private PrimaryRepositoryCustom primaryRepositoryCustom;

  @Autowired
  private ResourceLoader resourceLoader;

  @Override
  public Boolean loadDML(@Valid @NotBlank final String path) {
    log.info("Inicio carga path {}", path);
    Resource resource = FileUtils.getResource(this.resourceLoader, path);
    log.info("Fin carga path {}", path);
    log.info("Inicio load path {}", path);

    Boolean result = Boolean.FALSE;
    result = primaryRepositoryCustom.load(resource);
    log.info("Fin load path {} con resultado {}", path, result);
    return result;
  }

  @Override
  public @NotNull Resource changelogDML() {
    return FileUtils.getResource(resourceLoader, "changelog-primary-dml.md");
  }

  @Override
  public @NotNull Resource changelogDDL() {
    return FileUtils.getResource(resourceLoader, "changelog-primary-ddl.md");
  }

}
