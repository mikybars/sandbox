package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum MigrationMode {

  SHADOW,
  REST;

  public static MigrationMode from(String value) {
    try {
      return MigrationMode.valueOf(value.toUpperCase());
    } catch (IllegalArgumentException e) {
      log.warn("Unknown migration-mode '{}', defaulting to SHADOW", value);
      return SHADOW;
    }
  }

}
