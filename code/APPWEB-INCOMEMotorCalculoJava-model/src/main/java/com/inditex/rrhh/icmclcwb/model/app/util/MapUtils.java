package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.Map;

public class MapUtils {

  private MapUtils() {
  }

  @SuppressWarnings("rawtypes")
  public static boolean isEmpty(final Map map) {
    return ((map == null) || map.isEmpty());
  }

  @SuppressWarnings("rawtypes")
  public static boolean isNotEmpty(final Map map) {
    return !MapUtils.isEmpty(map);
  }

}
