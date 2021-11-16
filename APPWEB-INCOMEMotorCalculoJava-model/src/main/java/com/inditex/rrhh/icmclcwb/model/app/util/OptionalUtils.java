package com.inditex.rrhh.icmclcwb.model.app.util;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.Optional;

public class OptionalUtils {

  private OptionalUtils() {
  }

  public static <T> T get(final Optional<T> optional) {
    return get(optional, null);
  }

  public static <T> T get(final Optional<T> optional, final T defaultValue) {
    return optional.isPresent() ? optional.get() : defaultValue;
  }

}
