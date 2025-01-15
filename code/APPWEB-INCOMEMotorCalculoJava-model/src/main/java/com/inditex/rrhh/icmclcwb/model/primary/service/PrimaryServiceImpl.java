package com.inditex.rrhh.icmclcwb.model.primary.service;

import com.inditex.rrhh.icmclcwb.api.primary.service.PrimaryService;
import com.inditex.rrhh.icmclcwb.model.app.util.FileUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PrimaryServiceImpl implements PrimaryService {

  private static final Logger LOG = LoggerFactory.getLogger(PrimaryServiceImpl.class);

  @Autowired
  private PrimaryRepositoryCustom primaryRepositoryCustom;

  @Autowired
  private ResourceLoader resourceLoader;

  @Override
  public Boolean loadDML(@Valid @NotBlank final String path) {
    LOG.info("Inicio carga path {}", path);
    Resource resource = FileUtils.getResource(this.resourceLoader, path);
    LOG.info("Fin carga path {}", path);
    LOG.info("Inicio load path {}", path);

    Boolean result = Boolean.FALSE;
    result = primaryRepositoryCustom.load(resource);
    LOG.info("Fin load path {} con resultado {}", path, result);
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
