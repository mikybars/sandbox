package com.inditex.rrhh.icmclcwb.model.service;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.model.app.util.FileUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.service.PrimaryServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class PrimaryServiceImplTest {

  @Mock
  private Logger log;

  @Mock
  private PrimaryRepositoryCustom primaryRepositoryCustom;

  @Mock
  private ResourceLoader resourceLoader;

  @Mock
  Resource resource;

  @InjectMocks
  PrimaryServiceImpl primaryServiceImpl;

  @Test
  void loadDMLTest() {
    try (MockedStatic<FileUtils> utilities = Mockito.mockStatic(FileUtils.class)) {
      utilities.when(() -> FileUtils.getResource(this.resourceLoader, ""))
          .thenReturn(this.resource);

      doReturn(true).when(this.primaryRepositoryCustom).load(this.resource);

      final Boolean result = this.primaryServiceImpl.loadDML("");

      assertNotNull(result);
    }
  }

  @Test
  void changelogDMLTest() {
    try (MockedStatic<FileUtils> utilities = Mockito.mockStatic(FileUtils.class)) {
      utilities.when(() -> FileUtils.getResource(this.resourceLoader, "changelog-primary-dml.md"))
          .thenReturn(this.resource);

      final Resource result = this.primaryServiceImpl.changelogDML();

      assertNotNull(result);
    }
  }

  @Test
  void changelogDDLTest() {
    try (MockedStatic<FileUtils> utilities = Mockito.mockStatic(FileUtils.class)) {
      utilities.when(() -> FileUtils.getResource(this.resourceLoader, "changelog-primary-ddl.md"))
          .thenReturn(this.resource);

      final Resource result = this.primaryServiceImpl.changelogDDL();

      assertNotNull(result);
    }
  }

}
